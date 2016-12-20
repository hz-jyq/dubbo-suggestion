package com.fengdai.suggestion.base;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fengdai.suggestion.service.MySuggestionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:config/suggestion-provider-dev.xml"})
public abstract class BaseTest{
	private ApplicationContext context;
	
	@Before
	public void init(){
		context = new ClassPathXmlApplicationContext("classpath*:config/suggestion-provider-dev.xml");	
		context.getBean(MySuggestionService.class);
	}
	
	public abstract boolean equals(Object obj);
}
