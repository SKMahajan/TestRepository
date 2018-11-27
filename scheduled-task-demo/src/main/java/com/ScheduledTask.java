package com;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {
	
	@Scheduled(fixedRate=50000)
	public void task1() {
		System.out.println("current time is "+ new Date());
	}
}
