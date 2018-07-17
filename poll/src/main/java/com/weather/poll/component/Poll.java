package com.weather.poll.component;

import java.util.concurrent.*;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.weather.poll.exceptions.BusinessException;
import com.weather.poll.services.PollService;


@Component
public class Poll implements CommandLineRunner {

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    
    @Autowired
	private PollService pollService;
    
    @Override
    public void run(String... args) throws Exception {
        main(args);
    }

    public void main(String[] args) throws InterruptedException, ExecutionException, BusinessException {
    	pollService.updateDb();
    }
}