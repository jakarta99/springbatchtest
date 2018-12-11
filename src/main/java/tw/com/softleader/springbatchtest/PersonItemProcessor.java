package tw.com.softleader.springbatchtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;


public class PersonItemProcessor implements ItemProcessor<Person, Person> {

	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	public Person process(Person person) throws Exception {

		log.debug("BEFORE: {}", person );
		
		String firstName = person.getFirstName().toUpperCase();
		String lastName = person.getLastName().toUpperCase();
		
		Person p = new Person();
		p.setFirstName(firstName);
		p.setLastName(lastName);
		
		log.debug("AFTER: {}", p );
		
		return p;
		
		
	}

}
