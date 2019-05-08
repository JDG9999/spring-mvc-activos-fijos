package com.asd.jdgamboa.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asd.jdgamboa.entity.Empleado;

@Repository
public class EmpleadoDAOImpl implements EmpleadoDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Empleado> getEmpleados() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by code
		Query<Empleado> theQuery = 
				currentSession.createQuery("FROM Empleado ORDER BY codEmpleado",
											Empleado.class);
		
		// execute query and get result list
		List<Empleado> empleados = theQuery.getResultList();
		System.out.println(empleados);		
		// return the results		
		return empleados;
	}

	@Override
	public void saveEmpleado(Empleado empleado) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate 
		currentSession.saveOrUpdate(empleado);
		
	}

	@Override
	public Empleado getEmpleado(String codEmpleado) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Empleado empleado = currentSession.get(Empleado.class, codEmpleado);
		
		return empleado;
	}

	@Override
	public void deleteEmpleado(String codEmpleado) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("DELETE FROM Empleado WHERE codEmpleado=:Id");
		theQuery.setParameter("Id", codEmpleado);
		
		theQuery.executeUpdate();		
	}

}











