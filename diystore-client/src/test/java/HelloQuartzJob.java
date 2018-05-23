import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Created by hehe on 18-2-23.
 */
public class HelloQuartzJob implements Job {
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        System.out.println("Hello, Quartz! - executing its JOB at "+
                new Date() + " by " + context.getTrigger().getCalendarName());
    }
}
