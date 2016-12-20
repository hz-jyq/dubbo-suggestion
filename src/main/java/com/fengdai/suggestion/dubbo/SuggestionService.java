package com.fengdai.suggestion.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SuggestionService {
	
	 public static void main(String[] args) throws Exception { 
	    @SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"config/suggestion-provider-dev.xml"});
	 	System.out.println("-------------------DUBBO CONSUMER START-------------------");
		System.out.println("-------------------DUBBO CONSUMER END-------------------");
		System.out.println("按任意键退出");
	     context.start();
	     System.in.read(); // 按任意键退出
	    }
	 
}
