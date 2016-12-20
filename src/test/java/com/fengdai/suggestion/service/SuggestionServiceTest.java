package com.fengdai.suggestion.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.fengdai.suggestion.base.BaseTest;


public class SuggestionServiceTest  extends BaseTest{

	ContextConfiguration context;
	
	@Autowired
	private  MySuggestionService mySuggestionService;
	
	static int num=0;
	
	@Test
	public void testcheckUniqueByName() {
		System.out.println(mySuggestionService.selectByPrimaryKey("11").getContext());
	}
	@Test
	public void aslist() {
		List<StringBuffer> relateSrtList=new ArrayList<StringBuffer>();
		StringBuffer stringBuffer=new StringBuffer();
		StringBuffer stringBuffer1=new StringBuffer();
		stringBuffer.append("692f34ec38e94008b6e22cdaf9b5814a35F366746AD24FB7BB7525ACF27E509A4138830760cb457f932e978b259d14aac814c0f7efa04d49b3ee5c0abe0a2a43");
		relateSrtList.add(stringBuffer);
		stringBuffer1.append("692f34ec38e94008b6e22cdaf9b5814a35F366746AD24FB7BB7525ACF27E509A4138830760cb457f932e978b259d14aac814c0f7efa04d49b3ee5c0abe0a2a43");
		relateSrtList.contains(stringBuffer1);
	}
	
	@Test
	public void asMap() {
		Map<StringBuffer,StringBuffer> map=new HashMap<StringBuffer,StringBuffer>();
		StringBuffer s=new StringBuffer("1");
		map.put(s, s);
		s.setLength(0);
		s.append("2");
		System.out.println(map);
		StringBuffer str=new StringBuffer();
		str.append("2");
		System.out.println(map.get("2"));
		
	}
	
	@Override
	public  boolean equals(Object obj) {  
		 if(this == obj) {  
		   return true;  
		 }  
		 if(null == obj) {  
		   return false;  
		 }  
		 if(getClass() != obj.getClass()) {  
		   return false;  
		 }  
		  
		 StringBuffer String = (StringBuffer) obj;  
		 if(String.toString().equals(String.toString())) {  
		  return false;  
		 }  
		  return true;  
		}
	
	@Test
	public void list() {
		List<String> str=new ArrayList<String>();
		//str.set(index, element);
		//int i=new int();
		String[] str1=new String[3];
	}
	
	@Test
	public void lock() {
		
		ReentrantLock lock = new ReentrantLock();
		lock.lock();
		ExecutorService se = Executors.newCachedThreadPool();
		for (int  i = 0; i < 1000; i++) {
			se.execute(new Runnable() {
				public void run() {
					int i=num;
					update(i);
				}
			});
		};
		se.shutdownNow();
		System.out.print("无敌");
	}
	
	class TestRunnable implements Runnable{   
		public void run(int i){
	    	update(i);
	    	System.out.println(num);
	        System.out.println(Thread.currentThread().getName() + "线程被调用了。");   
	   /*    try {
		Thread.sleep(100);
		} catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName());
            Thread.currentThread().interrupt();
            System.out.println("after interrupt");
		}*/
	    }
	   
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	@Test
	public void Thread() {
		for (int i = 0; i < 1000; i++) {
			TestRunnable testRunnable=new TestRunnable();
			testRunnable.run();
		};
	}
	
	 public void update(int i){
	    	num=i;
	    	System.out.println(num);
			
	    }
	
	@Test
    public void tesTtransient() throws FileNotFoundException, IOException, ClassNotFoundException{  
        People p = new People();  
        p.setUserName("snowolf");  
        p.setPassword("123456");  
  
        System.err.println("------操作前------");  
        System.err.println("username: " + p.getUserName());  
        System.err.println("password: " + p.getPassword());  
  
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("people.txt"));  
        oos.writeObject(p);  
        oos.flush();  
        oos.close();  
  
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(  
                "people.txt"));  
        p = (People) ois.readObject();  
  
        ois.close();  
  
        System.err.println("------操作后------");  
        System.err.println("username: " + p.getUserName());  
        System.err.println("password: " + p.getPassword());  
    } 

	class People implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 2571080844375426372L;
		String  userName;
		String password;
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	}
	
}

