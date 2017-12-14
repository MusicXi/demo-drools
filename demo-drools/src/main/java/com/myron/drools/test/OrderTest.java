package com.myron.drools.test;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.myron.bean.Order;
import com.myron.bean.Product;

/**
 * drool演示测试
 * @author linrx1
 *
 */
public class OrderTest {
	static KieSession getSession(String kSessionName) {
		//规则收集与便宜,通过kmodule.xml配置不同的drl文件路径与命名
		KieServices ks = KieServices.Factory.get();
		KieContainer kc = ks.getKieClasspathContainer();
		return kc.newKieSession(kSessionName);
	}

	public static void main(String[] args) {
		//计算对象准备
		Order order = new Order();
		List<Product> products = new ArrayList<>();
		products.add(new Product("MP3", 120, 2));
		products.add(new Product("MP4", 200));
		products.add(new Product("TCL电视", 3000));
		products.add(new Product("红米note2", 799, 5));
		order.setProducts(products);

		//执行规则
		KieSession ks = getSession("simpleRuleKSession");
		ks.insert(order);
		
		//规则命中数
		int count = ks.fireAllRules();
		System.out.println("总执行了" + count + "条规则");
		System.out.println("实际需要支付：" + order.getPay());
		ks.dispose();
	}
}