import java.util.Date;

import org.quartz.*;

import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

/**
 * Created by hehe on 18-2-23.
 */
public class QuartzTest {
    public static void main(String[] args)throws Exception {

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        JobDetail job = JobBuilder.newJob(HelloQuartzJob.class).withIdentity("JobName", "JobGroupName").build();

        Trigger trigger=TriggerBuilder.newTrigger().withIdentity("CronTrigger1", "CronTriggerGroup").withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
                .startNow().build();

        scheduler.scheduleJob(job, trigger);

        scheduler.start();

        Thread.sleep(10000);

        // 停止调度
        scheduler.shutdown();
    }
}
