package com.tracker.availabilitytracker.controller;

import com.tracker.availabilitytracker.business.DriverService;
import com.tracker.availabilitytracker.model.DriverEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/availability/location")
public class AvailabilityController {

  private final DriverService driverService;

  public AvailabilityController(final DriverService driverService) {
    this.driverService = driverService;
  }

  @GetMapping("/driver/{driverId}")
  public ResponseEntity<Object> getDriverLocationInfo(
      @PathVariable("driverId") final int driverId) {
    final DriverEntity driverEntity = driverService.getDriverLocationInfo(driverId);
    return new ResponseEntity<>(
        driverEntity != null ? driverEntity : "No driver found for the specified driver ID!",
        HttpStatus.OK);
  }

  @GetMapping("/driver/all")
  public ResponseEntity<Object> getAllDriverLocationInfo() {
    return new ResponseEntity<>(driverService.getAllDriverLocationInfo(), HttpStatus.OK);
  }

  @GetMapping("/nearMe")
  public ResponseEntity<Object> getDriversNearMe(
      @RequestParam(value = "x") final int xCoordinate,
      @RequestParam(value = "y") final int yCoordinate) {
    return new ResponseEntity<>(
        driverService.getAllDriversNearMe(xCoordinate, yCoordinate), HttpStatus.OK);
  }
}
