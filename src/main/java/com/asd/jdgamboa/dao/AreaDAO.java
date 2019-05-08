package com.asd.jdgamboa.dao;

import java.util.List;

import com.asd.jdgamboa.entity.Area;

public interface AreaDAO {

	public List<Area> getAreas();

	public void saveArea(Area area);

	public Area getArea(String codArea);

	public void deleteArea(String codArea);
	
}
