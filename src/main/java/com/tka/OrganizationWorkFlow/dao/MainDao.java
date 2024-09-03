package com.tka.OrganizationWorkFlow.dao;

import java.util.List;
import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.OrganizationWorkFlow.entity.Country;
import com.tka.OrganizationWorkFlow.entity.Employee;



@Repository
public class MainDao {
	
	
	@Autowired
	SessionFactory factory;
	
	public String addCountry(Country c) {
		
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
		session = factory.openSession();
		tx= session.beginTransaction();
		session.persist(c);
		tx.commit();
		msg="country added successfully";
		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session !=null) {
				session.close();
			}
		}
		
		return msg;
	}
	
	public String updateCountry(Country c, int id) {
        Session session = null;
        Transaction tx = null;
        String msg = null;
        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            Country existingCountry = session.get(Country.class, id);
            if (existingCountry != null) {
                existingCountry.setCname(c.getCname());
                existingCountry.setCid(c.getCid());
                session.update(existingCountry);
                tx.commit();
                msg = "Country updated successfully";
            } else {
                msg = "Country not found";
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return msg;
    }

	public String deleteCountry(int cid) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Country country= session.get(Country.class,cid );
			session.remove(country);
			tx.commit();
			msg = "Country is deleted";
		}catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!= null) {
				session.close();
			}
		}
		return msg;
	}

	public List<Country> getAllCountry() {
		Session session = null;
		Transaction tx = null;
		List<Country> list  = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "from Country";
			Query<Country> query = session.createQuery(hqlQuery,Country.class);
		    list=query.list();
		    tx.commit();
            }catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!= null) {
				session.close();
			}
		}
		
		return list;
	}

	public Country getparticularCountryById(int cid) {
		Session session = null;
		Transaction tx = null;
		Country country  = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			country=session.get(Country.class,cid);
			tx.commit();
            }catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!= null) {
				session.close();
			}
		}
		return country;
	}

	public String addEmployee(Employee emp) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(emp);
			tx.commit();
			msg = "Employee added successfully";
		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}
	public String UpdatedEmp(Employee emp,int id) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {
			session =factory.openSession();
			tx=session.beginTransaction();
			Employee employee=session.get(Employee.class,id);
			 employee.setName(emp.getName());
			 employee.setMobileno(emp.getMobileno());
			 employee.setEmailid(emp.getEmailid());
			 employee.setSalary(emp.getSalary());
			 employee.setDepartment(emp.getDepartment());
			 employee.setStatus(emp.getStatus());
			 employee.setCreatedBy(emp.getCreatedBy());
			 employee.setCreatedDate(emp.getCreatedDate());
			 employee.setUpdatedBy(emp.getUpdatedBy());
			 employee.setUpdatedDate(emp.getUpdatedDate());
			 employee.setCountry(emp.getCountry());
			session.merge( employee);
			tx.commit();
			msg="Employee is Updated...";
			
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
			
		return msg;
	}

	public String DeletedEmployee(int id) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {
			session =factory.openSession();
			tx=session.beginTransaction();
			Employee emp=session.get(Employee.class, id);
			session.remove(emp);
			tx.commit();
			msg="Employee is Deleted";
			
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}

	public List<Employee> getallEmployeeById() {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		List<Employee> list=null;
		try {
			session =factory.openSession();
			tx=session.beginTransaction();
			String hqlQuery="from Employee";
			
			Query<Employee> query=session.createQuery(hqlQuery,Employee.class);
			list=query.list();
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
	}

	public Employee getparticularembyId(int id) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		Employee employee=null;
		
		try {
			session =factory.openSession();
			tx=session.beginTransaction();
			employee =session.get(Employee.class, id);
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return employee;
	}

	public Employee login(Employee e) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		Employee emp=null;
		
		try {
			session =factory.openSession();
			tx=session.beginTransaction();
			String hqlQuery="from Employee where emailid=:emailid and mobileno=:mobileno";
			Query<Employee> query=session.createQuery(hqlQuery,Employee.class);
			query.setParameter("emailid", e.getEmailid());
			query.setParameter("mobileno", e.getMobileno());
			
			emp=query.uniqueResult();
			tx.commit();
		} catch (Exception e1) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
			return emp;
	}

	public List<Employee> EmployeeSalary(double startsal, double endsal) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		List<Employee> list=null;
		try {
			session =factory.openSession();
			tx=session.beginTransaction();
			String hqlQuery="from Employee where salary between :mystartsal and :myendsal";
			Query<Employee> query=session.createQuery(hqlQuery,Employee.class);
			query.setParameter("mystartsal",startsal);
			query.setParameter("myendsal",endsal);
			list=query.list();
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return list;
	}

	public List<Employee> EmployeeStatus(String status) {
	    Session session = null;
	    Transaction tx = null;
	    List<Employee> list = null;

	    try {
	        session = factory.openSession();
	        tx = session.beginTransaction();
	        
	        String hqlQuery = "from Employee where status = :mystatus";
	        Query query = session.createQuery(hqlQuery);
	        query.setParameter("mystatus", status);
	        
	        list = query.list(); 
	        
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    
	    return list; 
	}

	public String UpdatedStatus(int id) {
		Session session = null;
	    Transaction tx = null;
	    String msg = null;
	    try {
	    	session = factory.openSession();
	    	tx = session.beginTransaction();
	    	Employee emp=session.get(Employee.class,id);
	    	if(Objects.isNull(emp)) {
	    		msg ="Record not found";
	    	}else {
	    		if(emp.getStatus().equalsIgnoreCase("Suspend")) {
	    			msg = "Status is not updated due to suspend";
	    			}else {
	    			String status = "Active".equalsIgnoreCase(emp.getStatus())?"Inactive":"Active";
	    			emp.setStatus(status);
	    			session.merge(emp);
	    			msg = "status is updated";
	    			}
	    }
	    	tx.commit();
	    	}catch(Exception e){
	    	if(tx!=null) {
	    		tx.rollback();
	    	}
	    	e.printStackTrace();
	    	}finally {
	    	if(session != null) {
	    		session.close();
	    		}
	   }
	    return msg;
	    }
	}
	
	
	
	

