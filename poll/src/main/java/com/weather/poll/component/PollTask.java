package com.weather.poll.component;

import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;

import com.weather.poll.services.PollService;

public class PollTask extends TimerTask{
	
	@Autowired
	private PollService pollService;
		
	@Override
	public synchronized void run() {
	}
}
