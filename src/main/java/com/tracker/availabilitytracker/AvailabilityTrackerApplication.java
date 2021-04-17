package com.tracker.availabilitytracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AvailabilityTrackerApplication {

  public static void main(String[] args) {
    SpringApplication.run(AvailabilityTrackerApplication.class, args);
  }
}
