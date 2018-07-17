package com.weather.poll.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.weather.poll.exceptions.BusinessException;
import com.weather.poll.resources.CiudadDetalle;

@Service
public class DBDriverImpl implements DBDriver {
	
	@Value("${dbUrl}")
	private String dbUrl;
	
	@Value("${dbUser}")
	private String dbUser;
	
	@Value("${dbPass}")
	private String dbPass;
		
	@Override
	public List<String> getListaCiudades() throws BusinessException{
				
		List<String> listaCiudaes =  new ArrayList<String>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection(dbUrl,dbUser,dbPass);
			Statement query = myConn.createStatement();
			ResultSet resultSet = query.executeQuery("SELECT * FROM weather.ciudad");
			
			while(resultSet.next()){				
				listaCiudaes.add(resultSet.getString("idCiudad"));
			}
			
		}catch(Exception e){
			throw new BusinessException(e.getMessage());
		}
		
		return listaCiudaes;
	}
	
	@Override
	public void updateCiudadDetalle(CiudadDetalle ciudadDetalle){
		
		try{
			Connection myConn = DriverManager.getConnection(dbUrl,dbUser,dbPass);
			Statement query = myConn.createStatement();
			try{
				query.executeUpdate("UPDATE WEATHER.CIUDAD set CODIGO = '"+ciudadDetalle.getCodigo()+"',TEMPERATURA ='" +ciudadDetalle.getTemperatura()+"', CONDICION = '"+ciudadDetalle.getCondicion()+"' WHERE IDCIUDAD = '"+ciudadDetalle.getNombre() +"'");
			}catch(SQLException e){
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
