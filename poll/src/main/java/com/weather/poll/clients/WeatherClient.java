package com.weather.poll.clients;

import com.weather.poll.resources.CiudadDetalle;

public interface WeatherClient {

	CiudadDetalle getDetalleCiudad(String ciudad);
}
