package com.asd.jdgamboa.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asd.jdgamboa.entity.Area;

@Repository
public class AreaDAOImpl implements AreaDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Area> getAreas() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by code
		Query<Area> theQuery = 
				currentSession.createQuery("FROM Area ORDER BY codArea",
											Area.class);
		
		// execute query and get result list
		List<Area> empleados = theQuery.getResultList();
		System.out.println(empleados);		
		// return the results		
		return empleados;
	}

	@Override
	public void saveArea(Area area) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate 
		currentSession.saveOrUpdate(area);
		
	}

	@Override
	public Area getArea(String codArea) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Area area = currentSession.get(Area.class, codArea);
		
		return area;
	}

	@Override
	public void deleteArea(String codArea) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("DELETE FROM Area WHERE codArea=:Id");
		theQuery.setParameter("Id", codArea);
		
		theQuery.executeUpdate();		
	}

}











