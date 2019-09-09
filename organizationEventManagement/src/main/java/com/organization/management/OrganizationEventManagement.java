package com.organization.management;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.organization.management.manager.Manager;
import com.organization.management.model.Employee;
import com.organization.management.model.Event;
import com.organization.management.repo.EmployeeRepository;
import com.organization.management.repo.EventRepository;
import com.orgination.managemen.vo.EmployeeVo;
import com.orgination.managemen.vo.EventVo;



@ComponentScan("com.organization.management") 
@SpringBootApplication
public class OrganizationEventManagement implements CommandLineRunner {

	@Autowired
	EmployeeRepository employeeRepo;

	@Autowired
	EventRepository eventRepo;
	
	@Autowired
	Manager manager;
		
	@Value("${does.db.data.refactor}")
	Boolean reInitiateData;
	 private static final Logger logger = LoggerFactory.getLogger(Manager.class);
	public static void main(String[] args) {
		SpringApplication.run(OrganizationEventManagement.class, args);		
	}

	 public void run(String... args) throws Exception
	    {
		 if(reInitiateData) {
			 logger.info("\n ************ Initialization********* ");
		// Clean up database tables
		 employeeRepo.deleteAllInBatch();
		 eventRepo.deleteAllInBatch();
	       
		 // Adding Employee
		 Employee emp = new Employee();
		 emp.setName("Test Employee");
		 emp.setJoinDate(new Date());
		 emp.setEmailId("test@mail.com");
		
		 
		
		 // Adding Events
		 Event event = new Event();
		 event.setTitle("Code Hacker Event");	 
		 event.setDescription("Equifax");	
		 
		 Event event1 = new Event();
		 event1.setTitle("Google Hackathon");	 
		 event1.setDescription("Java");	
		 
		 // Add Event references in the Employee
		 emp.getEvents().add(event);
		 emp.getEvents().add(event1);
		 
		// Add Employee reference in the Event
	        event.getEmployees().add(emp);
	        event1.getEmployees().add(emp);
	        
	        employeeRepo.save(emp);
	    }
	    }
}
