package com.organization.management.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import com.orgination.managemen.vo.EmployeeVo;

@Controller
@RequestMapping("/api/admin")
public class ResourcesController {
	 private static final Logger logger = LoggerFactory.getLogger(ResourcesController.class);

	
	@Value("${spring.application.name.admin}")
	String appName;

	@Autowired
	Manager manager;
	
	@GetMapping("/view")
	public String viewResource(Model model) {
		logger.info("This is admin ");
		model.addAttribute("events", manager.getEmployees());
		return "employeeView";
	}

	@GetMapping("/add")
	public String addResource(Model model) {
		logger.info("This is addResource ");
		model.addAttribute("resource", new EmployeeVo());
		return "addResource";
	}

	@PostMapping("/save")
	public String saveResource(EmployeeVo empVo, BindingResult result, Model model) {
		logger.info("This is saveResource ");
		manager.saveEmployee(empVo);
		return "redirect:/api/admin/view";
	}

	

	@GetMapping("/edit/{mid}")
	public String editResource(@PathVariable Long mid, Model model) {
		logger.info("This is edit Resource " + mid);
		model.addAttribute("emp", new EmployeeVo());
		return "/api/admin/view";
	}

	@PutMapping("/update/{mid}")
	public EmployeeVo updateResource(@RequestBody EmployeeVo employee, @PathVariable Long mid) throws Exception {
		if (employee.getMid() != mid) {
			throw new Exception();
		}
		return new EmployeeVo();
	}

	@DeleteMapping("/delete/{mid}")
	public void deleteResource(@PathVariable Long mid) {
		logger.info("This is deleteResource ");
	}
	
	
	
	
}
