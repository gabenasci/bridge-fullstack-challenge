package com.gabenasci.bridgebackendchallenge.controller;

import java.util.HashMap;
import java.util.List;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.*;

import com.gabenasci.bridgebackendchallenge.repository.CalculationRepository;
import com.gabenasci.bridgebackendchallenge.model.response.Calculation;



@RestController
public class CalculationController {
	// http://localhost:8080/result
//	@GetMapping("/result")
//	public List<Result> getAllResults() {
//		return Arrays.asList(new Result(1));
//	}
	
	private final CalculationRepository calculationRepository;
	
    public CalculationController(CalculationRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
    }
    
    @GetMapping(path="/results")
    public List<Calculation> getCalculations() {
    	return calculationRepository.findAll();
    }
	
	@GetMapping(path="/results/{k}")
	public Calculation getCalculation(@PathVariable Integer k) {
		return calculationRepository.findById(k).orElseThrow(RuntimeException::new);
	}

	@PostMapping(path="/calculate")
	public ResponseEntity<Calculation> createCalculation(@Valid @RequestBody Calculation calculation) throws URISyntaxException{
		long startTime = System.currentTimeMillis();
		calculation.setResult(calculation.getK());
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime-startTime;
		calculation.setTime(elapsedTime);
		Calculation savedCalculation = calculationRepository.save(calculation);
		return ResponseEntity.created(new URI("/results/" + savedCalculation.getK())).body(savedCalculation);
		
	}
}
