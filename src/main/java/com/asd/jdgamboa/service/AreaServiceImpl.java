package com.asd.jdgamboa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asd.jdgamboa.dao.AreaDAO;
import com.asd.jdgamboa.entity.Area;

@Service
public class AreaServiceImpl implements AreaService {

	// need to inject customer dao
	/**
	 * DAO del objeto a manipular, en este caso "Area"
	 */
	@Autowired
	private AreaDAO areaDAO;
	
	@Override
	@Transactional
	public List<Area> getAreas() {
		return areaDAO.getAreas();
	}

	@Override
	@Transactional
	public void saveArea(Area area) {
		areaDAO.saveArea(area);
	}

	@Override
	@Transactional
	public Area getArea(String codArea) {
		return areaDAO.getArea(codArea);
	}

	@Override
	@Transactional
	public void deleteArea(String codArea) {
		areaDAO.deleteArea(codArea);
	}
	
}





