package com.asd.jdgamboa.service;

import java.util.List;

import com.asd.jdgamboa.entity.Area;

public interface AreaService {

	public List<Area> getAreas();

	public void saveArea(Area area);

	public Area getArea(String codArea);

	public void deleteArea(String codArea);
	
}
