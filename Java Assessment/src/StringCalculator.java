
public class StringCalculator {
	
	// Check if Number is greater than 1000
	public int getValue(int currentNum) {
		
		int sum = 0;
		if(currentNum <= 1000) {
			sum = currentNum;
		}
		return sum;
	}
	
	// Add method
	public int Add(String numbers){
		
		int sum = 0, currentNum;
		String stringNum = "0", negativeNum = "";
		boolean isNegativePresent = false;
		char ch;
		
		// check is string is empty
		if(numbers.isEmpty()) {
			return 0;
		}
		else {
			for(int i = 0; i < numbers.length(); i++) {
				ch = numbers.charAt(i);
				
				// check if character is digit or not
				if(Character.isDigit(ch)) {
					stringNum += ch;
					
					// check for negative numbers
					if(i > 0 && numbers.charAt(i-1) == '-') {
						isNegativePresent = true;	
					}
					
				} else if(i!=0) {
					// convert string number into integer type
					currentNum = Integer.parseInt(stringNum);
					
					// for non negative number add it to sum
					if(!isNegativePresent)
					sum = sum + getValue(currentNum);
					else {
						// if current number is negative then add it negativeNum
						negativeNum += "-" + currentNum + " ";
						isNegativePresent = false;
					}
					stringNum = "0";
				}	
			}
		}
				 
		currentNum = Integer.parseInt(stringNum);
		// return sum if no negative
		if(!isNegativePresent) {
			return (sum + getValue(currentNum));
		}
		
		else {
			// for negative throw error
			negativeNum += "-" + currentNum;
			String message = "negatives not allowed: " + negativeNum;
			throw new RuntimeException(message);
		}
	}

}
