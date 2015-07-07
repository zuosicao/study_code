package cong.ruan.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener
{

	@Override
	public void contextDestroyed(ServletContextEvent arg0)
	{
		System.out.println("应用关闭。。。。。。。。。。。。");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0)
	{
		System.out.println("应用启动。。。。。。。。。。。");
	}

}
