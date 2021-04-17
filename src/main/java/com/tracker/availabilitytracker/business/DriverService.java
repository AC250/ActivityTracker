package com.tracker.availabilitytracker.business;

import com.tracker.availabilitytracker.model.DriverEntity;
import com.tracker.availabilitytracker.repository.DriverRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

  private final DriverRepository driverRepository;

  public DriverService(final DriverRepository driverRepository) {
    this.driverRepository = driverRepository;
  }

  public DriverEntity getDriverLocationInfo(final int driverId) {
    return driverRepository.findById(driverId).orElse(null);
  }

  public List<DriverEntity> getAllDriverLocationInfo() {
    return driverRepository.findAll();
  }

  /**
   * Gets available drivers in the location, in the 10x10 grid mentioned below, only taking those
   * drivers which are less than 2 units away
   *
   * @param xCoordinate x value of user
   * @param yCoordinate y value of user
   * @return list of drivers nearby
   */
  public List<DriverEntity> getAllDriversNearMe(final int xCoordinate, final int yCoordinate) {
    return driverRepository.findAll().stream()
        .filter(driverEntity -> isWithinDistance(driverEntity, xCoordinate, yCoordinate, 2))
        .collect(Collectors.toList());
  }

  /** Bean to populate empty driver entities in the database, currently setting only 20 drivers */
  @Bean
  public void populateDate() {
    for (int i = 0; i < 20; i++) {
      DriverEntity driverEntity = new DriverEntity();
      driverRepository.save(driverEntity);
    }
  }

  /**
   * This sets the location of a driver randomly. Just assuming a 10x10 unit area grid right now.
   */
  @Scheduled(fixedDelay = 5000)
  public void setRandomizedLocationValues() {
    driverRepository
        .findAll()
        .forEach(
            driverEntity -> {
              driverEntity.setxCoordinate((int) (Math.random() * 10));
              driverEntity.setyCoordinate((int) (Math.random() * 10));
              driverRepository.save(driverEntity);
            });
  }

  private boolean isWithinDistance(
      final DriverEntity driverEntity,
      final int xCoordinate,
      final int yCoordinate,
      final double distance) {
    return Math.sqrt(
            (driverEntity.getxCoordinate() - xCoordinate)
                    * (driverEntity.getxCoordinate() - xCoordinate)
                + (driverEntity.getyCoordinate() - yCoordinate)
                    * (driverEntity.getyCoordinate() - yCoordinate))
        <= distance;
  }
}
