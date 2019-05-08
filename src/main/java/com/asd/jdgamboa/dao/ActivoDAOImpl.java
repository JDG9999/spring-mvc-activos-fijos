package com.asd.jdgamboa.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asd.jdgamboa.entity.Activo;

@Repository
public class ActivoDAOImpl implements ActivoDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Activo> getActivos() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by serial
		Query<Activo> theQuery = currentSession.createQuery("FROM Activo ORDER BY serial", Activo.class);

		// execute query and get result list
		List<Activo> Activos = theQuery.getResultList();

		// return the results
		return Activos;
	}

	@Override
	public void saveActivo(Activo Activo) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/upate 
		currentSession.save(Activo);

	}
	
	@Override
	public void updateActivo(Activo Activo) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/upate 
		currentSession.update(Activo);

	}

	@Override
	public Activo getActivo(String serial) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Activo Activo = currentSession.get(Activo.class, serial);

		return Activo;
	}

	@Override
	public List<Activo> getActivosPorTipo(String tipo) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query ... sort by serial
		Query theQuery = currentSession.createQuery("FROM Activo WHERE tipo = :argTipo ORDER BY serial");
		theQuery.setParameter("argTipo", tipo);
		
		// execute query and get result list
		List<Activo> Activos = theQuery.getResultList();

		// return the results
		return Activos;
	};

	@Override
	public List<Activo> getActivosPorFechaCompra(Calendar fechaCompra) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by serial
		Query theQuery = currentSession.createQuery("FROM Activo WHERE fechaCompra = :argFecha ORDER BY serial");
		theQuery.setParameter("argFecha", fechaCompra);
		
		// execute query and get result list
		List<Activo> Activos = theQuery.getResultList();

		// return the results
		return Activos;
	};

	@Override
	public void deleteActivo(String serial) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("DELETE FROM Customer WHERE serial=:Id");
		theQuery.setParameter("Id", serial);

		theQuery.executeUpdate();
	}

}
