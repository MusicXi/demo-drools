package com.myron.drools.test;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.myron.bean.Order;
import com.myron.bean.Product;

public class OrderTest {
	static KieSession getSession() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kc = ks.getKieClasspathContainer();
		return kc.newKieSession("simpleRuleKSession");
	}

	public static void main(String[] args) {
		KieSession ks = getSession();
		Order order = new Order();
		List<Product> products = new ArrayList<>();
		products.add(new Product("MP3", 120, 2));
		products.add(new Product("MP4", 200));
		products.add(new Product("TCL电视", 3000));
		products.add(new Product("红米note2", 799, 5));

		order.setProducts(products);

		ks.insert(order);
		int count = ks.fireAllRules();
		System.out.println("总执行了" + count + "条规则");
		System.out.println("实际需要支付：" + order.getPay());
		ks.dispose();
	}
}