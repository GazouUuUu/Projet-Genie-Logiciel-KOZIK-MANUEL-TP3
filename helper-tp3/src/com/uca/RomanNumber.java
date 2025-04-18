package com.uca;

public class RomanNumber extends Number implements Comparable<Number>{
	
	private String roman;
	
	private int value;
	
	public RomanNumber(){
		//Ignored
	}
	
	public RomanNumber(String roman){
		this.roman = roman;
		this.value = RomanConverter.getNumberFromRoman(this.roman);
	}
	
	public RomanNumber(int value){
		this.value = value;
		this.roman = RomanConverter.getRomanFromNumber(this.value);
	}
	
	public RomanNumber(int value, String roman){
		this.value = value;
		this.roman = roman;
	}
	
	public String getRoman(){
		return this.roman;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public void setRoman(String roman){
		this.roman = roman;
		this.value = RomanConverter.getNumberFromRoman(this.roman);
	}
	public void setValue(int value){
		this.value = value;
		this.roman = RomanConverter.getRomanFromNumber(this.value);
	}
	
	
	
	
	/**
	* @{inheritDoc}
	*/
	@Override
	public double doubleValue() {
		return (double)this.value;
	}

	/**
	* @{inheritDoc}
	*/
	@Override
	public float floatValue() {
		return (float)this.value;
	}

	/**
	* @{inheritDoc}
	*/
	@Override
	public int intValue() {
		return this.value;
	}

	/**
	* @{inheritDoc}
	*/
	@Override
	public long longValue() {
		return (long)this.value;
	}

	@Override
	public String toString() {
		return this.roman + " (" + this.value + ")";
	}
	@Override
	public int compareTo(Number o){
		return Integer.compare(this.value, o.intValue());
	}
}