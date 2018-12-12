package tw.com.softleader.springbatchtest;

import java.time.LocalDateTime;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class ScheduleTask {

	@Autowired
	private JobLauncher jobLauncher;
	
	
	@Autowired
	private Job job;
	
	@Scheduled(cron="0 0/5 * * * *")
	public void importUser() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		JobParameters jobParams = new JobParameters();
		
		System.out.println("--------------NEW------------");
		
		jobLauncher.run(job, jobParams);
		
	}

	
	
	
}
