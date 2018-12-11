package tw.com.softleader.springbatchtest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void afterJob(JobExecution jobExecution) {
		
		log.debug("Now status = {}", jobExecution.getStatus());
		
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.debug("Job Finished !! ");
			
			jdbcTemplate.query("SELECT * FROM people",
					(rs, row)-> new Person() {{
						setFirstName(rs.getString("first_name"));
						setLastName(rs.getString("last_name"));
					}}
			).forEach(person -> log.info("Found {}", person));
		}
		
		
	}
	
}
