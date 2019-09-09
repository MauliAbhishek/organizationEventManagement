package com.organization.management.manager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.organization.management.controller.EventController;
import com.organization.management.model.Employee;
import com.organization.management.model.Event;
import com.organization.management.repo.EmployeeRepository;
import com.organization.management.repo.EventRepository;
import com.orgination.managemen.vo.EmployeeVo;
import com.orgination.managemen.vo.EventRegisterVo;
import com.orgination.managemen.vo.EventVo;

@Component
public class Manager {
	 private static final Logger logger = LoggerFactory.getLogger(Manager.class);

	
	@Autowired
	EmployeeRepository employeeRepo;

	@Autowired
	EventRepository eventRepo;

	
	// Employee Process
	public boolean saveEmployee(EmployeeVo empVo) {
		boolean status = false;
		if (empVo != null) {
			employeeRepo.save(transform(empVo));
			status = true;
		}
		return status;
	}

	public List<EmployeeVo> getEmployees() {
		List<EmployeeVo> employeeVos = new ArrayList<EmployeeVo>();
		for (Employee emp : employeeRepo.findAll()) {
			employeeVos.add(transform(emp));
		}
		return employeeVos;
	}

	public Employee getEmployee(Long mid) {
		Optional<Employee> employee = null;
		if (mid < 1) {
			employee = employeeRepo.findById(mid);
		}
		return employee.get();
	}

	public Employee updateEmployee(Employee emp) {
		employeeRepo.save(emp);
		return getEmployee(emp.getMid());
	}

	public boolean deleteEmployee(Long mid) {
		boolean status = false;
		employeeRepo.delete(getEmployee(mid));
		return status;
	}

	private EmployeeVo transform(Employee emp) {
		EmployeeVo empVo = new EmployeeVo();
		if (emp != null) {
			empVo.setMid(emp.getMid());
			empVo.setName(emp.getName());
			empVo.setJoinDate(emp.getJoinDate());
			empVo.setEmailId(emp.getEmailId());
		}
		return empVo;
	}

	private Employee transform(EmployeeVo empVo) {
		Employee emp = new Employee();
		if (empVo != null) {
			emp.setName(empVo.getName());
			emp.setJoinDate(empVo.getJoinDate());
			emp.setEmailId(empVo.getEmailId());
		}
		return emp;
	}

	// Event Process
	public boolean saveEvent(EventVo eventVo) {
		boolean status = false;
		if (eventVo != null) {
			eventRepo.save(transform(eventVo));
			status = true;
		}
		return status;
	}

	public Set<EventVo> getEvents() {
		Set<EventVo> eventVoSet = new HashSet<EventVo>();
		for (Event event : eventRepo.findAll()) {
			eventVoSet.add(transform(event));
		}
		return eventVoSet;
	}

	// Event Registration Process
	public void registerEvent(EventRegisterVo evtReqObj) {
		
		Employee emp = employeeRepo.findById(evtReqObj.getMid()).get();		
		Event event = eventRepo.findById(evtReqObj.getEventId()).get();
		
		emp.getEvents().add(event);
		event.getEmployees().add(emp);		
		 employeeRepo.save(emp);
		 logger.info("\n ***** Envent registered Successfullyy !");
	}

	public Set<EventRegisterVo> getRegisteredEvents() {
		Set<EventRegisterVo> registeredEvents = new HashSet<EventRegisterVo>();
		
		List<Event> evnts = null;
		if(eventRepo != null) {
			evnts = eventRepo.findAll();
		}
		EventRegisterVo erv = null;
		for(Event e : evnts){
			erv = new EventRegisterVo();
			erv.setDescription(e.getDescription());
			erv.setEventId(e.getId());
			erv.setTitle(e.getTitle());
			erv.setMid(e.getEmployees().iterator().hasNext() ? e.getEmployees().iterator().next().getMid():null);
			registeredEvents.add(erv);		
		}		
		return registeredEvents;
	}


	private EventVo transform(Event event) {
		EventVo eventVo = new EventVo();
		eventVo.setId(event.getId());
		eventVo.setTitle(event.getTitle());
		eventVo.setDescription(event.getDescription());
		return eventVo;
	}

	private Event transform(EventVo eventVo) {
		Event event = null;
		if (eventVo != null) {
			event = new Event();
			event.setTitle(eventVo.getTitle());
			event.setDescription(eventVo.getDescription());
		} else {
			event = new Event();
		}
		return event;
	}

	

	// Event Process
}
