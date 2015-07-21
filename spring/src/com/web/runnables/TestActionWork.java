package com.web.runnables;

import com.web.actions.TestAction;

public class TestActionWork implements Runnable{

	private TestAction testAction;
	private int threadCode;
	
	public TestActionWork(TestAction testAction,int threadCode) {
		this.testAction = testAction;
		this.threadCode = threadCode;
	}
	
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++)
		{
			testAction.step1();
			
			try {
				System.out.println("sleep......" + threadCode + ":>> "+i + "<<" + testAction.hashCode());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
