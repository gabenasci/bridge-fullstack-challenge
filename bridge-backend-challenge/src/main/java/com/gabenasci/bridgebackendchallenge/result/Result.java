package com.gabenasci.bridgebackendchallenge.result;

public class Result {
	private int result;

	public int getResult() {
		return result;
	}

	public Result(int result) {
		super();
		this.result = result;
	}

	@Override
	public String toString() {
		return "Result [result=" + result + "]";
	}
	
}
