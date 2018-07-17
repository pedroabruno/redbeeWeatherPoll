package com.weather.poll.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.poll.clients.WeatherClient;
import com.weather.poll.db.DBDriver;
import com.weather.poll.exceptions.BusinessException;
import com.weather.poll.resources.CiudadDetalle;

import ch.qos.logback.classic.Logger;

@Service
public class PollServiceImpl implements PollService {
	
	@Autowired
	private DBDriver dbDriver;
	
	@Autowired
	private WeatherClient weatherClient;
	
	@Override
	public synchronized void updateDb() throws BusinessException{
			List<String> listaCiudades = dbDriver.getListaCiudades();
			listaCiudades.forEach(ciudad->updateOnDB(ciudad));
	}
	
	private synchronized void updateOnDB(String ciudad){
		CiudadDetalle ciudadDetalle = weatherClient.getDetalleCiudad(ciudad);
		dbDriver.updateCiudadDetalle(ciudadDetalle);
	}
}
