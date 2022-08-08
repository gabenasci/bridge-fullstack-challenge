package com.gabenasci.bridgebackendchallenge.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gabenasci.bridgebackendchallenge.Calculation;
import com.gabenasci.bridgebackendchallenge.result.Result;

@RestController
public class Controller {
	// http://localhost:8080/result
//	@GetMapping("/result")
//	public List<Result> getAllResults() {
//		return Arrays.asList(new Result(1));
//	}
	
	@PostMapping("/getresult")
	public int calculateResult(String input) {
		System.out.println("INPUT: "+input);
		int k = Integer.parseInt(input);
		System.out.println(k);
		return Calculation.calculateResult(Calculation.calculateNAndDivisors(k));
	}
}
