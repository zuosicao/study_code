package cong.ruan.tasks;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

//@Component("testTask")
public class QuartzTask extends QuartzJobBean{
	public static int times = 1;
	 //@Scheduled(cron = "0/3 * * * * ?")
	public void testJob(){
		System.out.println(" QuartzTask  >>>>>>>>>>> from QuartzTask.java" + times ++) ;
	}
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		this.testJob();
	}
}
