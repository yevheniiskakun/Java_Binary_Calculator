// Console based program of binary calculator
import java.util.InputMismatchException;
import java.util.Scanner;

class Binary_Calculator{
	
	static void decToBinary(int number) 
    { 	
		int bit_system = 8; // bit system can be 8, 16, 32, 64
        // array to store binary number 
        int[] binaryNum = new int[1000]; 
        int n = number;
        // counter for binary array 
        int i = 0;
        
        if(n < 0) {
        	n = n * -1;
        	n = (int) ((Math.pow(2, bit_system - 1) - 1) -  n); // adaptation for all bit systems
        }
        while (n > 0)  
        { 
            // storing remainder in binary array 
            binaryNum[i] = n % 2; 
            n = n / 2; 
            i++; 
        } 
        System.out.print(number);
    	System.out.print("-");
    	
        // printing binary array in reverse order 
    	if(number == 0 || number == -0) {
    		System.out.print("00000000");
    	}
    	else if(number < 0) {
    		System.out.print(1);
    		
    		for(int k = 0; k < bit_system - i - 1; k++) {
    			System.out.print(0); 
    		}
    		for (int j = i - 1; j >= 0; j--) {
    			
                System.out.print(binaryNum[j]); 
            }
    	}
    	else {
    		for(int k = 0; k < bit_system - i; k++) {
    			System.out.print(0); 
    		}
    		for (int j = i - 1; j >= 0; j--) {
                System.out.print(binaryNum[j]); 
            }
    	}
   
        System.out.println("");
    } 

@SuppressWarnings("unused")
public static void main (String[] args)
    { 	
	
	
	String restart = "yes"; // variable for restarting the program, in the end we will choose restart programm or not
	
	while(restart.equals("yes")) {
		
		int first_number_bin[] = {};
		int second_number_bin[] = {};
		
		int result = 0;
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		// inizialise all variables
		int first_number;
		int second_number;
		String operation;
		
		// check inputs in infinite loops
		while (true) {
	        try {														// check if user enter the integer
	        	System.out.println("Please enter first number: ");
	            first_number = scan.nextInt();
	            break;
	        }
	        catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please reenter");
	            scan.nextLine();
	        }
	    }
		while (true) {
	        try {													// check if user enter the integer
	        	System.out.println("Please enter second number: ");
	            second_number = scan.nextInt();
	            break;
	        }
	        catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please reenter");
	            scan.nextLine();
	        }
	    }
		
	    while(true) {												// check if user enter correct operation
		    System.out.println("Please enter operation: ");
	
		    operation = scan.next();
		   // operations ask like Strings
		    if(operation.equals("+")) {
		    	result = first_number + second_number;	
		    	break;
		    }
		    else if(operation.equals("-")) {
		    	result = first_number - second_number;
		    	break;
		    }
		    else if(operation.equals("*")) {
		    	result = first_number * second_number;
		    	break;
		    }
		    else if(operation.equals("/")) {
		    	if(second_number == 0) {							// check if user enter 0
		    		System.out.println("You can not divide by 0!");
		    	}
		    	else {
		    		result = first_number / second_number;
		    	}
		    	break;
		    }
		    else {
		    	System.out.println("You did not choose operation");
		    	
		    }
	    }
	    
	    if(second_number == 0 && operation.equals("/")) {
	    	decToBinary(first_number);						// call bin function for first number and for 0 if we have division by 0
	    	decToBinary(0);
	    }else {
	    	decToBinary(first_number);	 // call bin function for all inputs if we have everything correct
	    	decToBinary(second_number);
	    	System.out.print("Result: ");
	        decToBinary(result);				// write the result
	    }
	     
	    // asking for repeating the program
	    System.out.println("Do you want to restart program?");
	    System.out.println("Print yes if you want to restart restart the program or no if not");
	    restart = scan.next();
	    
	}
		
    }
}