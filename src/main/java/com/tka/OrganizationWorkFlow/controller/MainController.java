package com.tka.OrganizationWorkFlow.controller;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.OrganizationWorkFlow.entity.Country;
import com.tka.OrganizationWorkFlow.entity.Employee;
import com.tka.OrganizationWorkFlow.service.MainService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class MainController {
	
	@Autowired
	MainService service;
	
	@PostMapping("addcountry")
	public String addCountry(@RequestBody Country c) {
		String msg = service.addCountry(c);
		return msg;
	}
	
	@PutMapping("updatecountry/{id}")
	public String updateCountry(Country c,@PathVariable int id) {
		String msg = service.addCountry(c);
		return msg;
	}
	
	@DeleteMapping("deletecountry/{cid}")
	public String deleteCountry(@PathVariable int cid) {
		String str = service.deleteCountry(cid);
		return str;
	}
	
	@GetMapping("getallcountry")
	public List<Country> getAllCountry() {
		List<Country> list = service.getAllCountry();
		return list;
	}
	
	@GetMapping("getCountryById/{cid}")
	public Country getparticularCountryById(@PathVariable int cid) {
		Country country = service.getparticularCountryById(cid);
		return country;
	}
	
	@PostMapping("addEmp")
	public String addEmployee(@RequestBody Employee emp) {
		String msg = service.addEmployee(emp);
				return msg;
		}
	@PutMapping("updatedemployee/{id}")
	public String UpdatedEmp(@RequestBody Employee emp,@PathVariable int id) {
		String str=service.UpdatedEmp(emp,id);
		return str;
	}
	@DeleteMapping("deletedemp/{id}")
	public String DeletedEmployee(@PathVariable int id) {
		String str=service.DeletedEmployee(id);
		return str;
	}
	@GetMapping("getallemployee")
	public List<Employee> getallEmployeeById() {
		List<Employee> list=service.getallEmployeeById();
		return list;
	}
	@GetMapping("getparticularembyId/{id}")
	public Employee getParticularembyId(@PathVariable int id) {
	Employee emp=service.getParticularembyId( id);
    return emp;
	
	}
	@PostMapping("login")
	public HashMap login(@RequestBody Employee e) {
		HashMap map=service.login(e);
		return map;
	}
	@PostMapping("employeesalary/{startsal}/{endsal}")
	public List<Employee> EmployeeSalary(@PathVariable double startsal,@PathVariable double endsal){
		List<Employee> list=service.EmployeeSalary(startsal,endsal);
		return list;
	}
	
	@PostMapping("Employeebystatus/{status}")
	public List<Employee> EmployeeStatus(@PathVariable String status){
		List<Employee> list=service.EmployeeStatus(status);
		return list;
	}
	
	@GetMapping("updatestatus/{id}")
	public String UpdatedStatus(@PathVariable int id ) {
		String msg=service.UpdatedStatus(id);
		return msg;
	}
	
}
	
	


