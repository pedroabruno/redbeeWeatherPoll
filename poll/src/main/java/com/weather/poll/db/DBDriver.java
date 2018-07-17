package com.weather.poll.db;

import java.util.List;

import com.weather.poll.exceptions.BusinessException;
import com.weather.poll.resources.CiudadDetalle;

public interface DBDriver {
	
	List<String> getListaCiudades() throws BusinessException;
	
	void updateCiudadDetalle(CiudadDetalle ciudadDetalle);
}
