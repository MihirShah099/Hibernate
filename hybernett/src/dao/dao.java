package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.util.*;
import vo.vo;
	public class dao 
	{
	    public void insert(vo v1)
	    {
	    	try
	    	{
	    		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
	    		
	    		Session session = sessionfactory.openSession();
	    		
	    		Transaction transaction = session.beginTransaction();
	    		session.save(v1);
	    		
	    		transaction.commit();
	    		session.close();
	    		
	    	}
	    	catch (Exception e) {
				// TODO: handle exception
	    		//e.printStackTrace();
			}}
	    public	List search(vo v)
	    	{
	    		 List ls= new ArrayList();
	    		
	    		 try
	    			{
	    			
	    			
	    			 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
	 	    		
	 	    		Session session = sessionfactory.openSession();
	 	    		Query q=session.createQuery("from vo");
	 	    		
	    			
	    			
	    			
	    				ls=q.list();
	    			
	    				
	    			}
	    			catch(Exception e){
	    				e.printStackTrace();
	    			}
	    		 return ls;
	    	}
	    public void delete(vo v)
		{
			try
			{
SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
	    		
	    		Session session = sessionfactory.openSession();
	    		
	    		Transaction transaction = session.beginTransaction();
	    		session.delete(v);
	    		
	    		transaction.commit();
	    		session.close();
	    			
	 	    		    		
	    		
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	public    List  edit(vo v)
		{
			List ls1=new ArrayList();
			try
			{
SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
	    		
	    		Session session = sessionfactory.openSession();
	    		Query q=session.createQuery("from vo where id='"+v.getId()+"'");		
					
				
				
			}
				catch(Exception e){
					e.printStackTrace();
			}		 return ls1;

		}

	public void update(vo v1)
	{
		try
		{
			SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
    		
    		Session session = sessionfactory.openSession();
    		
    		Transaction transaction = session.beginTransaction();
    		session.update(v1);
    		
    		transaction.commit();
    		session.close();
	    		
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
	}
	    	

	    }


