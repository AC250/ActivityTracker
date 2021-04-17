package com.tracker.availabilitytracker.repository;

import com.tracker.availabilitytracker.model.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<DriverEntity, Integer> {}
