package com.tracker.availabilitytracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "drivers")
@Entity
public class DriverEntity {

  @Id
  @Column(name = "driver_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  public int driverId;

  @Column(name = "x_coordinate")
  public int xCoordinate;

  @Column(name = "y_coordinate")
  public int yCoordinate;

  public int getDriverId() {
    return driverId;
  }

  public void setDriverId(int driverId) {
    this.driverId = driverId;
  }

  public int getxCoordinate() {
    return xCoordinate;
  }

  public void setxCoordinate(int xCoordinate) {
    this.xCoordinate = xCoordinate;
  }

  public int getyCoordinate() {
    return yCoordinate;
  }

  public void setyCoordinate(int yCoordinate) {
    this.yCoordinate = yCoordinate;
  }
}
