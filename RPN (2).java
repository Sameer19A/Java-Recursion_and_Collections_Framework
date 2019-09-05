import java.util.Scanner;
import java.math.*;

class StackNode {
	public StackNode underneath;
	public double data;
	
	public StackNode(double data, StackNode underneath) {
			this.data = data;
			this.underneath = underneath;
	}//end of constructor StackNode
}//end of class StackNode
	
	
class RPN {
	private String command;
	public StackNode top;
	
	public void insertIntoStack(double new_data) {		//into method is like push(), it adds the double new_data to the stack.
		StackNode new_node = new StackNode(new_data, top);
		top = new_node;
	}//end of method into
	
	
	public double takeOutofStack( ) throws RuntimeException {	//outof method is like pop(), it removes the top value in the stack. it follows the LIFO/FILO order. 
		double top_data = top.data;
		top = top.underneath;
		if (top_data <0) {
			throw new RuntimeException("Stack is empty!");
		} 
		else {
			return top_data;
		}
	}//end of method outof
	
	
	public RPN(String command) {
		top = null;
		this.command = command;
	}//end of constructor RPN
	
	
	public double get( ) {		//this method get, gets the top element in the stack, and then performs the calculation and returns the final answer, which is the top value in the stack
		double a, b;
		int j;
		int numElemStack= 0; //numElemStack is the number of elements in the stack
		String Function = ""; 
		//loop through the command string and if the character is a digit, add it to the stack
		//while (numElemStack<2) {
			for(int i = numElemStack; i < command.length( ); i++) {   //start loop at i = numElemStack?
				double number;
			 // if it's a digit
				if(Character.isDigit(command.charAt(i))) {
							//command.substring((i-1),i);
					//get a string of the number
					String temp = "";
	//				//for(j = 0; (j < 100) && (Character.isDigit(command.charAt(i)) || (command.charAt(i) == '.')); j++,i++) {
					//for(j = 0; (j < 100) &&  (command.charAt(i) != '.'); j++, i++) {
				//	for(j = 0; (j < 100); j++) {
	//					temp = temp + String.valueOf(command.charAt(i));	
						temp = temp + Character.toString(command.charAt(i));  //convert the char at pos i in the command string to a string
						//convert number in string form to double and add to the stack
						number = Double.parseDouble(temp);
						insertIntoStack(number); //add the number "number" to the stack if it's a digit
						numElemStack++; //inc number count in stack if char is digit
				
				}	//end of if statement
				else {
					Function = Character.toString(command.charAt(i));	//if char is not digit, make the char the function type
				}
			}//end of for loop				
		
			performFunction(Function,numElemStack);		

			
		double final_Ans = takeOutofStack();	//final_Ans becomes the top value in the stack, which should be the answer of the Reverse Polish Notation calculation.
		
//		if(top == null) {
//			throw new IllegalArgumentException();
//			}	//end of if statement
		
		return final_Ans;
	}	//end of method get
	
	
	private void performFunction(String f, int numElemStack) throws RuntimeException, ArithmeticException, IllegalArgumentException {
		double a;
		double b;
		char fc = f.charAt(0);
		if (numElemStack>=2)	{
			b = takeOutofStack();  //remove the top value in the stack and make it equal to b
			a = takeOutofStack();	//remove the top value in the stack and make it equal to a

			if(f.charAt(0) == '+') {
				insertIntoStack(a + b);    				//now insert the addition of a and b into the stack, after the values of a and b were gotten by removing the first 2 items in the stack.
			}//end of else if
			else if(f.charAt(0) == '-') {
				insertIntoStack(a - b);
			} //end of else if
			else if(f.charAt(0) == '*') {
				insertIntoStack(a * b);
			}//end of else if
			else if(f.charAt(0) == '/') {
				if (b !=0) { 
				insertIntoStack(a / b);
				}
				else throw new ArithmeticException("Cannot divide by 0");
			}//end of else if
			else if(f.charAt(0) == '^') {
				insertIntoStack(Math.pow(a, b));
			}//end of else if
			else if(f.charAt(0) == ' ') {
				throw new IllegalArgumentException();
				}//end of else if
			
//			else throw new RuntimeException("Cannot determine function type");
		}//end of if
	}//end of method perform function
	

	/* main method */
	public static void main(String args[]) {
		while(true) {
			Scanner in = new Scanner(System.in);
			System.out.println("Enter RPN expression or \"quit\".");
			String line = in.nextLine( );
			
			if(line.equals("quit")) {
			break;
			}	//end of if statement
			else {
				RPN calc = new RPN(line);
				System.out.printf("Answer is %f\n", calc.get());
			}//end of else
		}//end of while loop
		
	}//end of method main
	
}//end of class RPN