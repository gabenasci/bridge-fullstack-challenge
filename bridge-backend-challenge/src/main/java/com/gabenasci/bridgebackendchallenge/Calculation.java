package com.gabenasci.bridgebackendchallenge;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.math.*;

public class Calculation {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Insert number (k): ");
		int k = sc.nextInt();
		long startTime = System.currentTimeMillis();
		HashMap<Integer, Integer> nDivisors = calculateNAndDivisors(k);
		System.out.println(nDivisors);
		System.out.println(calculateResult(nDivisors));
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime+"ms Total");
	}
	public static int calculateResult(HashMap<Integer, Integer> nDivisors) {
		long startTime = System.currentTimeMillis();
		int result = 0;
		// Inicializar varíavel ArrayList dos divisores n-1
//		ArrayList<Integer> prevDivisors = new ArrayList<>(Arrays.asList(0));
		
		// Iterar o HashMap buscando o valor (ArrayList de Divisores) de cada chave (n)
		for(int i = 2; i < nDivisors.size()+2; i++) {
			if(nDivisors.get(i) == nDivisors.get(i+1)) {
				result++; // Acrescentar contador se n-1 possui mesmo número de divisores de n
//				System.out.println("partial result: "+result);
			}
		}

		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime+"ms to Calculate Result (compare all n divisors)");
		return result;
	}
	public static HashMap<Integer, Integer> calculateNAndDivisors(int k) {
		// HashMap que contém os inteiros positivos n menores que k e seus respectivos números de divisores
		long startTime = System.currentTimeMillis();
		HashMap<Integer, Integer> nDivisors = new HashMap<>();
		for(int n = 2; n < k; n++) {
			nDivisors.put(n, calculateDivisors(n));
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime+"ms to populate HashMap");
		return nDivisors;
	}
	
	public static int calculateDivisors(int n) {
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
