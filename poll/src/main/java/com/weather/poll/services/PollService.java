package com.weather.poll.services;

import com.weather.poll.exceptions.BusinessException;

public interface PollService {

	public void updateDb() throws BusinessException;
}
