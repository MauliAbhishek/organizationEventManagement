package com.organization.management.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.organization.management.manager.Manager;
import com.organization.management.model.Event;
import com.orgination.managemen.vo.EventRegisterVo;
import com.orgination.managemen.vo.EventVo;

@Controller
@RequestMapping("/api/event")
public class EventController {
	 private static final Logger logger = LoggerFactory.getLogger(EventController.class);


	@Autowired
	Manager manager;
	
	@PostMapping("/register")	
	public String registerEvent(@Valid EventRegisterVo evtReqObj, BindingResult result, Model model ) {
		logger.info("\n Event details ="+evtReqObj.toString());		
		manager.registerEvent(evtReqObj);
		logger.info("\n An Event request has been registered.");
		return "redirect:/";
	}
	
	 @GetMapping("/view")
	 public String viewEvents(Model model) {
		 logger.info("This is viewEvents ");
		 model.addAttribute("events", manager.getEvents());
	        return "eventView";
	    }
	 	
	 
	 @GetMapping("/{eventKey}")
	    public Event findOne(@PathVariable Long eventKey) {
		 logger.info("This is findOne ");
	        return new Event();
	    }
	 
	 @GetMapping("/list")
	    public List<Event> findEvents() {
		 logger.info("This is findEvents ");
	        return new ArrayList<Event>();
	    }
	 	
	 @GetMapping("/add")	  
	    public String addEvent(Model model) {
	    	logger.info("This is addEvent ");
	    	model.addAttribute("event", new EventVo());
	        return "addEvent";
	    }
	 
	    @PostMapping("/create")	  
	    public String saveEvent(EventVo eventVo, BindingResult result, Model model) {
	    	logger.info("This is saveEvent ");
	    	manager.saveEvent(eventVo);
	        return "redirect:/api/event/view";
	    }
	 
	    @DeleteMapping("/{eventKey}")
	    public void deleteEvent(@PathVariable Long eventKey) {
	    	logger.info("This is deleteEvent ");
	    }
	 
	    @PutMapping("/{eventKey}")
	    public Event updateEvent(@RequestBody EventRegisterVo eventVo, @PathVariable Long eventKey) throws Exception {
	        if (eventVo.getId() != eventKey) {
	          throw new Exception();
	        }
	        return new Event();
	    }
}
