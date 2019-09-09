package com.organization.management.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.organization.management.manager.Manager;
import com.orgination.managemen.vo.EmployeeVo;
import com.orgination.managemen.vo.EventRegisterVo;
import com.orgination.managemen.vo.EventVo;

@Controller
@RequestMapping("/")
public class DashBoardController {
	
	 private static final Logger logger = LoggerFactory.getLogger(DashBoardController.class);
	@Value("${spring.application.name}")
	String appName;

	@Autowired
	Manager manager;
	
	@GetMapping
	public String dashboard(Model model) {
		logger.info("This is dashboard ");
		model.addAttribute("appName", appName);
		model.addAttribute("evtReg", new EventRegisterVo());
		model.addAttribute("events",  eventMap());
		model.addAttribute("resources", resourceMap());
		model.addAttribute("scheduledEvents",  manager.getRegisteredEvents());
		
		return "event";
	}

		 
	private Map<Long, String> eventMap() {
		Map<Long, String> eventMap = new LinkedHashMap<Long, String>();
		eventMap.put(new Long(-999), "Select");
		for(EventVo eventVo : manager.getEvents()) {
			eventMap.put(eventVo.getId(), eventVo.getTitle());
			logger.info("\n DB Events = ID:"+eventVo.getId() +", Title:"+ eventVo.getTitle());
		}
		return eventMap;
	}

	private Map<Long, String> resourceMap() {
		Map<Long, String> empMap = new LinkedHashMap<Long, String>();
		empMap.put(new Long(-99), "Select");
		for(EmployeeVo empVo : manager.getEmployees()) {
			empMap.put(empVo.getMid(), empVo.getName());
		}
		return empMap;
	}

	@GetMapping("/header")
	public String header(Model model) {
		logger.info("This is header ");
		return "common/header";
	}

	@GetMapping("/footer")
	public String footer(Model model) {
		logger.info("This is footer ");
		return "/common/footer";
	}
}
