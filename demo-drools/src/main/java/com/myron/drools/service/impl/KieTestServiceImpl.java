package com.myron.drools.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.kie.api.cdi.KSession;
import org.kie.api.command.Command;
import org.kie.api.runtime.KieSession;
import org.kie.internal.command.CommandFactory;
import org.kie.internal.runtime.StatelessKnowledgeSession;
import org.springframework.stereotype.Service;

import com.myron.drools.service.KieTestService;
import com.myron.drools.service.bean.Message;

@Service("kieTestServiceImpl")
public class KieTestServiceImpl implements KieTestService {

	@Resource(name = "ksessionStateless")
	private StatelessKnowledgeSession statelessKnowledgeSession;
	
	@KSession("simpleRuleKSession")
	private KieSession ksession;

	@Override
	public void test() {
/*		Message message = new Message();
		List<Message> messageList = new ArrayList<Message>();
		message.setMessage("Hello World");
		message.setStatus(Message.HELLO);
		messageList.add(message);

		MessageList messageList1 = new MessageList();
		messageList1.setMessageList(messageList);
		Command command1 = CommandFactory.newInsert(messageList1);
		
		List<Long> appIdList = new ArrayList<Long>();
		for (int i = 0; i < 10; i++) {
			appIdList.add((long) i);
		}
		try {
			statelessKnowledgeSession.setGlobal("appIdList", appIdList);
			statelessKnowledgeSession.execute(command1);
		} catch (LinkageError error) {
			System.out.println("" + error.getMessage());
		} catch (Exception ex) {
			System.out.println("" + ex);
		}*/
	}
}