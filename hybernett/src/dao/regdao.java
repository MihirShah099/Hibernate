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
import vo.regvo;
public class regdao {
	public void insert(regvo v1)
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

}
