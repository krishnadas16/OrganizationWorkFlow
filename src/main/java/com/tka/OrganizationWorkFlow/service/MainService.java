package com.tka.OrganizationWorkFlow.service;

import java.util.List;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.OrganizationWorkFlow.dao.MainDao;
import com.tka.OrganizationWorkFlow.entity.Country;
import com.tka.OrganizationWorkFlow.entity.Employee;
import java.util.HashMap;
@Service
public class MainService {

	@Autowired
	MainDao dao;
	//Get country service method
	public String addCountry(Country c) {
		String msg = dao.addCountry(c);
		if(Objects.isNull(msg)) {
			msg = "country is not added";
		}
		return msg;
	}
	//Update country service method
	 public String updateCountry(Country c, int id) {
	        String msg = dao.updateCountry(c, id);
	        if (Objects.isNull(msg)) {
	            msg = "Country update failed";
	        }
	        return msg;
	    }
    // Delete country service method
	public String deleteCountry(int cid) {
		String str = dao.deleteCountry(cid);
		if(Objects.isNull(str)) {
			str = "Country is not deleted";
		}
		return str;
	}
    
	// GetAllRecord country service method
	public List<Country> getAllCountry() {
		List<Country> list = dao.getAllCountry();
		if(Objects.isNull(list)) {
			list=null;
		}
		return list;
	}
    
	//GetParticularCountry country service method
	public Country getparticularCountryById(int cid) {
	Country country = dao.getparticularCountryById(cid);
	if	(Objects.isNull(country)) {
	country = null;
	}
	return country;
	}

	//Add Employee service method
	public String addEmployee(Employee emp) {
		String msg = dao.addEmployee(emp);
		if(Objects.isNull(msg)) {
			msg = "Employee is not added";
		}
		return msg;
	}
	public String UpdatedEmp(Employee emp,int id) {
		// TODO Auto-generated method stub
		String msg=dao.UpdatedEmp(emp,id);
		if(Objects.isNull(emp)) {
			emp=null;
		}
		return msg;
	}

	public String DeletedEmployee(int id) {
		// TODO Auto-generated method stub
		String msg=dao.DeletedEmployee(id);
		if(Objects.isNull(msg)) {
			msg="Employee is not Deleted successfully";
		}
		return msg;
	}

	
		
		public List<Employee> getallEmployeeById(){
			List<Employee> list=dao.getallEmployeeById();
			if(Objects.isNull(list)) {
				list=null;
			}
		return list;
	}

		public Employee getParticularembyId(int id) {
			// TODO Auto-generated method stub
			Employee emp = dao.getparticularembyId(id);
			if(Objects.isNull(emp)) {
				emp=null;
				
			}
			return emp;
		}

		public HashMap login(Employee e) {
			Employee emp=dao.login(e);
			HashMap map=new HashMap();
			if(Objects.isNull(emp)) {
				map.put("msg", "Invalid User");
			}else {
				map.put("msg", "vaild User");
		    }
			map.put("user", emp);
			return map;
		}

		public List<Employee> EmployeeSalary(double startsal, double endsal) {
			List<Employee> list=dao.EmployeeSalary(startsal,endsal);
			if(Objects.isNull(list)) {
				list=null;
			}
			return list;
		}
		public List<Employee> EmployeeStatus(String status) {
			List<Employee> list=dao.EmployeeStatus(status);
			if(Objects.isNull(list)) {
				list = null;
			}
			return list;
		}
		
		public String UpdatedStatus(int id) {
			String msg=dao.UpdatedStatus(id);
			return msg;
		}

}
