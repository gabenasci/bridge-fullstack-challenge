package com.gabenasci.bridgebackendchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gabenasci.bridgebackendchallenge.model.response.Calculation;

public interface CalculationRepository extends JpaRepository<Calculation, Integer>{
}
