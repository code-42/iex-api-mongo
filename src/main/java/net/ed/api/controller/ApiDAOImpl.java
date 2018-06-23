package net.ed.api.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.ed.api.entity.Stock;

@Repository
public class ApiDAOImpl implements IApiDAO{
	
	// build the session factory
	@Autowired
	SessionFactory sessionFactory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Stock.class)
			.buildSessionFactory();
	
	// write data to the database
	 @Override
	 @Transactional
	 public void saveStock(Stock theStock) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		try {
			// create a student object
			System.out.println("34. Creating new todays_totals object...");
			Stock tempStock = new Stock(theStock);
			
			// start a transaction
			currentSession.beginTransaction();
			
			// save the student object
			System.out.println("41. Saving the Totals...");
			currentSession.save(tempStock);
			
			// commit transaction
			currentSession.getTransaction().commit();
			
			System.out.println("47. Done!");
		}
		finally {
			currentSession.close();
		}
	}

}
