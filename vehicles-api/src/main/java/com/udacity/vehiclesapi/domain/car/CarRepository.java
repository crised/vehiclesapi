package com.udacity.vehiclesapi.domain.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
