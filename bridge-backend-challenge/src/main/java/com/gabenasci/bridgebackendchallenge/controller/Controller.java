package com.gabenasci.bridgebackendchallenge.controller;

import java.util.Arrays;
import java.util.HashMap;
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
	
	@PostMapping("/result")
	public HashMap<String, String> calculateResult(String input) {
		System.out.println("INPUT: "+input);
		int k = Integer.parseInt(input);
		HashMap<String, String> response = new HashMap<>();
		long startTime = System.currentTimeMillis();
		int result = Calculation.calculateResult(Calculation.calculateNAndDivisors(k));
		System.out.println("RESULT: "+result+"\n");
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime-startTime;
		response.put("result", Integer.toString(result));
		response.put("time", Long.toString(elapsedTime));
		return response;
	}
}
