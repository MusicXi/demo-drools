package test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myron.bean.Order;
import com.myron.bean.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:META-INF/spring/spring-context-drools.xml" })
public class DroolsSpringTest {

	// 注： 这里的值与配置文件中的值是一样的
	@Resource(name = "simpleRuleKSession")
	KieSession ksession;

	@Test
	public void runRules() {
		// 计算对象准备
		Order order = new Order();
		List<Product> products = new ArrayList<>();
		products.add(new Product("MP3", 120, 2));
		products.add(new Product("MP4", 200));
		products.add(new Product("TCL电视", 3000));
		products.add(new Product("红米note2", 799, 5));
		order.setProducts(products);


		ksession.insert(order);
		int count = ksession.fireAllRules();
		System.out.println("总执行了" + count + "条规则");
		System.out.println("实际需要支付：" + order.getPay());
		ksession.dispose();

	}
}