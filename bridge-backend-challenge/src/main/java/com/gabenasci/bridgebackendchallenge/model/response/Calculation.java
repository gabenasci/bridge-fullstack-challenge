package com.gabenasci.bridgebackendchallenge.model.response;
import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.math.*;

@Entity
@Table(name="calculation")
public class Calculation {
	@Id
//	@GeneratedValue
	private int k;
	
	private int result;
	
	private Long time;
	
	public Long getTime() {
		return time;
	}
	
	public void setTime(Long time) {
		this.time = time;
	}
	
	public int getK() {
		return k;
	}
	public void setK(int k) {
		this.k = k;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int k) {
		this.result = calculateResult(createDivisorsHash(k));
	}
	
	public static int calculateResult(HashMap<Integer, Integer> nDivisors) {
		long startTime = System.currentTimeMillis();
		int result = 0;
		// Iterar o HashMap buscando o valor (ArrayList de Divisores) de cada chave (n)
		for(int i = 2; i < nDivisors.size()+2; i++) {
			if(nDivisors.get(i) == nDivisors.get(i+1)) {
				result++; // Acrescentar contador se n-1 possui mesmo número de divisores de n
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime+"ms para Calcular o Resultado");
		return result;
	}

	public static HashMap<Integer, Integer> createDivisorsHash(int k) {
		// HashMap que contém os inteiros positivos n menores que k e seus respectivos números de divisores
		long startTime = System.currentTimeMillis();
		HashMap<Integer, Integer> nDivisors = new HashMap<>();
		for(int n = 2; n < k; n++) {
			nDivisors.put(n, calculateNumDivisors(n));
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime+"ms para popular o HashMap");
		return nDivisors;
	}
	
	public static int calculateNumDivisors(int n) {
		int count = 0;
		for(int i = 1; i <= Math.sqrt(n); i++) {
			if(n % i == 0) {
				if (n / i == i) {
					count++;					
				}
				else 
					count = count + 2;
			}
		}
//		System.out.println("count: "+count);
		return count;
	}
}
