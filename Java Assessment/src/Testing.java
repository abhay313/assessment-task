import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Testing {
	
	StringCalculator strCalculator = new StringCalculator();
	
	@Test
	void stringOfAtmostLengthTwo() {
		
		// Empty string or it is of length 1 or 2
		assertEquals(0, strCalculator.Add(""));
		assertEquals(1, strCalculator.Add("1"));
		assertEquals(3, strCalculator.Add("1,2"));
	}
	
	@Test
	void stringOfUnkmownLength()  {
		
		// String of unknown length
		assertEquals(100, strCalculator.Add("12,,2,,,6,,50,,30"));
	}
	
	@Test
	void stringContainsNewLine() {
		
		// String having new line i.e \n
		assertEquals(6, strCalculator.Add("1\n2,3"));
		assertEquals(100, strCalculator.Add("12\n2\n6\n\n50\n30"));	
	}
	
	
	@Test
	void stringHavingMultipleDelimiters() {
		
		// String having delimiters
		assertEquals(3, strCalculator.Add("//;\\n1;2"));
		
		// String having multiple delimiters
		assertEquals(6, strCalculator.Add("//[**][%%]\\n1**2%%3"));
		assertEquals(6, strCalculator.Add("//[*][%]\\n1*2%3"));
		
		// String having unknown amount of delimiters
		assertEquals(6, strCalculator.Add("//[***]\\n1***2***3"));
	}
	
	@Test
	void stringHavingNumberGreaterThanThousand() {
		
		// String contains greater than 1000
		assertEquals(3, strCalculator.Add("1\n2,3000"));
		assertEquals(1002, strCalculator.Add("1000\n2,3000"));
	}
	
	@Test
	void stringHavingNegativeNumbers(){
		
		// String contains negative numbers
	    Exception exception = assertThrows(RuntimeException.class, () -> {
	        strCalculator.Add("-35,44,-55,20,30,-1");
	    });

	    String expectedMessage = "negatives not allowed: -35 -55 -1";
	    String actualMessage = exception.getMessage();
	    assertEquals(expectedMessage, actualMessage);
	}
}
