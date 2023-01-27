package com.prowings.empcrud.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.prowings.empcrud.dao.EmployeeDao;
import com.prowings.empcrud.model.Employee;
@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void saveEmployee(Employee employee) {
		Session session=sessionFactory.openSession();
		Transaction txn=session.beginTransaction();
		session.save(employee);
		txn.commit();
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		Employee emp;
		Session session=sessionFactory.openSession();
		Transaction txn=session.beginTransaction();
		emp=session.get(Employee.class,id);
		txn.commit();
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		List<Employee> Emplist=null;
		try {
			tx=session.beginTransaction();
			org.hibernate.Query<Employee> query=session.createQuery("from Employee");
			Emplist=query.list();
			tx.commit();
		}catch(HibernateException ex)
		{
			if(tx!=null) {
				tx.rollback();
			}
			System.out.println("Exception:"+ex.getMessage());
			ex.printStackTrace(System.err);			
		}finally {
			session.close();
			return Emplist;
		}
	}

	@Override
	public List<Employee> getEmployeesByCityAndDept(String city, String department) {

		Session session=sessionFactory.openSession();
		Transaction tx=null;
		List<Employee> Emplist=null;
		try {
			tx=session.beginTransaction();
//			CriteriaBuilder cb=session.getCriteriaBuilder();
//			CriteriaQuery<Employee> cr=cb.createQuery(Employee.class);
//			Root<Employee> root=cr.select(root).where(cb.like(root.get("department"),department)););
//			cr.select(root);
			
			org.hibernate.query.Query query=session.createQuery(" from Employee e where e.department=department");
			query.setParameter("department", department);
			Emplist= query.list();
			tx.commit();
			
			//			org.hibernate.query.Query<Employee> query=session.createQuery(cr);
//			Emplist=query.getResultList();
//			tx.commit();
			
		}catch(HibernateException ex)
		{
			if(tx!=null) {
				tx.rollback();
			}
			System.out.println("Exception:"+ex.getMessage());
			ex.printStackTrace(System.err);			
		}finally {
			session.close();
			return Emplist;
		}
	}

}
