package com.fengdai.suggestion.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SuggestionService {

	private static ClassPathXmlApplicationContext context = null;

	static SuggestionService suggestionService = new SuggestionService();

	static SuggestionService getInstance() {
		return suggestionService;
	}
	
	public static void main(String[] args) throws Exception {
		SuggestionService.getInstance().start();;
		System.out.println("-------------------DUBBO CONSUMER START-------------------");
		System.out.println("-------------------DUBBO CONSUMER END-------------------");
		System.out.println("[SuggestionService SERVICE STARTED]");
		System.in.read(); // 按任意键退出
		while (true) {
			Thread.sleep(1000);
		}
	}

	@SuppressWarnings("resource")
	public synchronized void start() {
		if (context == null) {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					new String[] { "config/suggestion-provider-dev.xml" });
			context.start();
		}
	}
}
