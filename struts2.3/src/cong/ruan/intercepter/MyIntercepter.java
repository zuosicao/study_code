package cong.ruan.intercepter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyIntercepter extends AbstractInterceptor
{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception
	{
		System.out.println("actionName" + invocation.getAction().getClass().getName());
		String name = (String)invocation.getStack().findString("username");
		System.out.println(name);
		if (name == null || "123".equals(name))
		{
			System.out.println("fail");
			return "fail";
		}
		return invocation.invoke();
	}
	
}
