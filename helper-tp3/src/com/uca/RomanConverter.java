package com.uca;

import java.lang.IllegalArgumentException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class RomanConverter{
	
	// Table des symboles
	private static final Collection<RomanNumber> SYMBOLS = new ArrayList<>();
	static {
		SYMBOLS.add(new RomanNumber(1000, "M"));
		SYMBOLS.add(new RomanNumber(900, "CM"));
		SYMBOLS.add(new RomanNumber(500, "D"));
		SYMBOLS.add(new RomanNumber(400, "CD"));
		SYMBOLS.add(new RomanNumber(100, "C"));
		SYMBOLS.add(new RomanNumber(90, "XC"));
		SYMBOLS.add(new RomanNumber(50, "L"));
		SYMBOLS.add(new RomanNumber(40, "XL"));
		SYMBOLS.add(new RomanNumber(10, "X"));
		SYMBOLS.add(new RomanNumber(9, "IX"));
		SYMBOLS.add(new RomanNumber(5, "V"));
		SYMBOLS.add(new RomanNumber(4, "IV"));
		SYMBOLS.add(new RomanNumber(1, "I"));
	  }

	// Expression reguliere de validation
	private static final Pattern VALIDATION_RE = Pattern.compile("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");


	public static String getRomanFromNumber(int a) throws IllegalArgumentException{
		if(a<0 || a>3999){
			throw new IllegalArgumentException("Valeur négative(gros naze t'as cru on aller mettre un - devant les lettres t'es con ma parole ils connaissaient meme pas les nombres négatifs a l'époque ils pensaient encore que la terre était plate réfléchis un peu");
		}
		String resultat = "";
		for(RomanNumber n : SYMBOLS){
			while(a >= n.getValue()){
				resultat = resultat + n.getRoman();
				a = a - n.getValue();
			}
		}
		return resultat;
	}
	
	public static int getNumberFromRoman(String a) throws IllegalArgumentException{
		if(a==null || !VALIDATION_RE.matcher(a).matches()){
			throw new IllegalArgumentException("Valeur non valide");
		}
		if(a.length() == 0){
			return 0;
		}
		int resultat = 0;
		int index = 0;
		for(RomanNumber n : SYMBOLS){
			String symbol = n.getRoman();
			int valeur = n.getValue();
			while(a.startsWith(symbol, index)){
				resultat = resultat + valeur;
				index = index + symbol.length();
			}
		}
		return resultat;
	}
}