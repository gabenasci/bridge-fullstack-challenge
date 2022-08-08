package com.gabenasci.bridgebackendchallenge;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class Calculation {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Insert number (k): ");
		int k = sc.nextInt();
		System.out.println(calculateNAndDivisors(k));
		System.out.println(calculateResult(calculateNAndDivisors(k)));
	}
	public static int calculateResult(HashMap<Integer, ArrayList<Integer>> nDivisors) {
		int result = 0;
		// Inicializar varíavel ArrayList dos divisores n-1
		ArrayList<Integer> prevDivisors = new ArrayList<>(Arrays.asList(0));
		
		// Iterar o HashMap buscando o valor (ArrayList de Divisores) de cada chave (n)
		for(ArrayList<Integer> divisors: nDivisors.values()) {
			if(prevDivisors.size() == divisors.size()) {
				result++; // Acrescentar contador se n-1 possui mesmo número de divisores de n
			}
			prevDivisors = divisors;
		}
		return result;
	}
	public static HashMap<Integer, ArrayList<Integer>> calculateNAndDivisors(int k) {
		// HashMap que contém os inteiros positivos n menores que k e seus respectivos divisores
		HashMap<Integer, ArrayList<Integer>> nDivisors = new HashMap<>();
		for(int n = 2; n < k; n++) {
			nDivisors.put(n, calculateDivisors(n));
		}
		return nDivisors;
	}
	
	public static ArrayList<Integer> calculateDivisors(int n) {
		ArrayList<Integer> divisorsOfN = new ArrayList<>();
		for(int i = 1; i<=n; i++) {
			if(n % i == 0) {
				divisorsOfN.add(i);
			}
		}
		return divisorsOfN;
	}
}
