package com.klef.jfsd.exam;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

public class ClientDemo 
{
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) 
	{
		ClientDemo cd = new ClientDemo();
		while(true)
		{
			System.out.println("1.Add Department\n2.Delete Department Using nmaed Parameters\n3.Display all Departments");
			System.out.println("\nEnter Choice : ");
			int ch=sc.nextInt();
		
			switch(ch) {
			case 1:
				cd.addDepartment();
				cd.viewAllDepartments();
				break;
			case 2:
				cd.deleteDepartment();
				cd.viewAllDepartments();
				break;
			case 3:
				cd.viewAllDepartments();
				break;
			
			default:
				System.exit(0);
		}
			}
		
		
	}
	
	public void addDepartment()
	{
		Configuration configuration = new Configuration();
	       configuration.configure("hibernate.cfg.xml");
	       
	       SessionFactory sf = configuration.buildSessionFactory();
	       Session session = sf.openSession();
	       
	       Transaction t =  session.beginTransaction();
	       
	       Department d = new Department();
	       System.out.println("Enter Department Name :");
	       String dname=sc.next();
	       System.out.println("Enter Department Location : ");
	       String dloc=sc.next();
	       System.out.println("Enter Department HodName :");
	       String dhodname=sc.next();
	       
	       d.setName(dname);
	       d.setLocation(dloc);
	       d.setHoDName(dhodname);
	       
	       session.persist(d);
	       t.commit();
	       session.close();
	       sf.close();
	}
	
	public void deleteDepartment()
	{
		Configuration configuration = new Configuration();
	       configuration.configure("hibernate.cfg.xml");
	       
	       SessionFactory sf = configuration.buildSessionFactory();
	       Session session = sf.openSession();
	       
	       Transaction t=session.beginTransaction();
	       
	       System.out.println("Enter Depatment ID to Delete:");
	       int did=sc.nextInt();
	       
	       MutationQuery query =  session.createMutationQuery("delete Department where department_id=?1");
	       query.setParameter(1, did);
	       
	       int n = query.executeUpdate();
	       
	       t.commit();
	       
	       if(n>0)
	       {
	       System.out.println(n+" Department(s) Deleted Successfully");
	       }
	       else
	       {
	    	   System.out.println("Department ID Not Found");
	       }
	       
	       
	       session.close();
	       sf.close();  
	}
	
	public void viewAllDepartments()
	{
		
		Configuration configuration = new Configuration();
	       configuration.configure("hibernate.cfg.xml");
	       
	       SessionFactory sf = configuration.buildSessionFactory();
	       Session session = sf.openSession();
	       
	       String hql="from Department";
	       
	       Query<Department> qry=session.createQuery(hql, Department.class);
	       List<Department> deptlist = qry.getResultList();
	       
	       System.out.println("Total Departments="+deptlist.size());
	       
	       
	       for(Department d : deptlist)
	       {
	    	   System.out.println(d.toString());
	       }
	       
	       session.close();
	       sf.close();
	}
}
