package net.ed.api.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.ed.api.entity.Chart;

@Repository
public class ApiDAOImpl implements IApiDAO{
	
	// build the session factory
	@Autowired
	SessionFactory sessionFactory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Chart.class)
			.buildSessionFactory();
	
	// write data to the database
	 @Override
	 @Transactional
	 public void saveChart(Chart theChart) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		try {
			// create a student object
			System.out.println("34. Creating new todays_totals object...");
			Chart tempChart = new Chart(theChart);
			
			// start a transaction
			currentSession.beginTransaction();
			
			// save the student object
			System.out.println("41. Saving the Chart...");
			currentSession.save(tempChart);
			
			// commit transaction
			currentSession.getTransaction().commit();
			
			System.out.println("47. Done!");
		}
		finally {
			currentSession.close();
		}
	}

}
