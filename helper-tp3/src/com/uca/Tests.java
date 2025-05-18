package com.uca;

import org.junit.jupiter.api.Test;
import java.util.concurrent.Callable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Tests {
	
	@Test
	public void testRomanFromNumber(){
		assertThat(RomanConverter.getRomanFromNumber(1), equalTo("I"));
        assertThat(RomanConverter.getRomanFromNumber(4), equalTo("IV"));
        assertThat(RomanConverter.getRomanFromNumber(9), equalTo("IX"));
        assertThat(RomanConverter.getRomanFromNumber(46), equalTo("XLVI"));
        assertThat(RomanConverter.getRomanFromNumber(92), equalTo("XCII"));
        assertThat(RomanConverter.getRomanFromNumber(405), equalTo("CDV"));
        assertThat(RomanConverter.getRomanFromNumber(913), equalTo("CMXIII"));
        assertThat(RomanConverter.getRomanFromNumber(3999), equalTo("MMMCMXCIX"));
	}

    @Test
    public void testNumberFromRoman(){
        assertThat(RomanConverter.getNumberFromRoman("I"), equalTo(1));
        assertThat(RomanConverter.getNumberFromRoman("IV"), equalTo(4));
        assertThat(RomanConverter.getNumberFromRoman("IX"), equalTo(9));
        assertThat(RomanConverter.getNumberFromRoman("XLIX"), equalTo(49));
        assertThat(RomanConverter.getNumberFromRoman("XC"), equalTo(90));
        assertThat(RomanConverter.getNumberFromRoman("CMII"), equalTo(902));
        assertThat(RomanConverter.getNumberFromRoman("MMVI"), equalTo(2006));
        assertThat(RomanConverter.getNumberFromRoman("MMMCMXCIX"), equalTo(3999));


    }
	
	@Test
    public void testNegativeValue(){
        assertThat(exceptionOf(()-> RomanConverter.getRomanFromNumber(-1)), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(-5)), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(-10)), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(-50)), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(-100)), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(-1000)), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(-3999)), instanceOf(IllegalArgumentException.class));
    }

    @Test
    public void testIntervalle(){
        for(int i=1; i<=3999; i++){
            assertThat(i, equalTo(RomanConverter.getNumberFromRoman(RomanConverter.getRomanFromNumber(i))));
        }
    }

    @Test
    public void testRepetition(){
        assertThat(exceptionOf(()-> RomanConverter.getNumberFromRoman("IIII")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(()-> RomanConverter.getNumberFromRoman("VV")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(()-> RomanConverter.getNumberFromRoman("XXXX")), instanceOf(IllegalArgumentException.class));
    }

    @Test
    public void testAntecedentInvalide(){
        assertThat(exceptionOf(()-> RomanConverter.getNumberFromRoman("IVIX")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(()-> RomanConverter.getNumberFromRoman("IVX")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(()-> RomanConverter.getNumberFromRoman("VIV")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(()-> RomanConverter.getNumberFromRoman("IVI")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(()-> RomanConverter.getNumberFromRoman("CDCD")), instanceOf(IllegalArgumentException.class));

    }

    


    //Help you to handle exception. :-)
    public static Throwable exceptionOf(Callable<?> callable) {
        try {
            callable.call();
            return null;
        } catch (Throwable t) {
            return t;
        }
    }
}
