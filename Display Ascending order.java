/**
* instead of performing alphabetic check in this loop. call a seperate function called WordCheck that will chk if it is a word and if so add it to WordsList, else 
* throw an exception if the word does not start with an alphabet
 */
import java.util.*;
import java.io.*;

public class CompulsoryTask1 {
	
	
	public static void main(String[] args) {
		List<String> WordsList = new ArrayList<String>();	//WordsList is an array list that will	
		try {
			File x = new File("C:\\Users\\Sameer\\Google Drive\\Hyperion Programming\\Ch2 - Intro to Software Engineering\\Task 20\\Input.txt");
			Scanner in = new Scanner(x);

			while (in.hasNext()) {
				
				if (!in.hasNextLine()) {	//if the file does not have a nextline, then exit the loop
					break;	//break will exit form the loop
				}	//end if

				else  { //else if there is a line, find the words in that line and display them alphabetically.
					String Line = in.nextLine();
					Line = Line.trim();	// Remove the leading and trailing white spaces in the line.
					String[] Words = Line.split(" ");	//split the line into seperate elements according to spaces and insert each element into a string array
					for (int i=0; i<Words.length;i++) {
						//System.out.println("single" + Words[i]);
						if (CheckWord(Words[i])) {
							WordsList.add(Words[i]);		//if it is a valid word, add it to the wordlist
						}//end of if
						
						else {
							System.out.println("there is an invalid word present");
							
						}//end of else
						
					}//end of for loop
					
					WordsList.sort(String.CASE_INSENSITIVE_ORDER);  // sorts alphabetically in ascending order
					//WordsList.sort(Comparator.naturalOrder());  //prints the list as is.
					
					//WordsList.sort(Comparator.reverseOrder());
					
					//using an iterator to print the sorted words one after the other.
					Iterator<String> WordsIterator = WordsList.iterator();
					while (WordsIterator.hasNext()) {
						System.out.print(WordsIterator.next() +" ");
					}//end of iterator while loop 

				}//end of else
				
			}//end of while
			
			
		}	//end of try
		catch (FileNotFoundException e){
			System.out.println("Error - input file not found");
			}  //end of File not found catch block
		catch (NumberFormatException NumFrmtEx) {
			System.out.println("Error - Word does not start with a letter");
		}//end of number format exception block
				
	}//end of method main

	
public static boolean CheckWord(String Word) throws NumberFormatException  {	
	if (Character.isAlphabetic(Word.charAt(0))) {  //if the first letter of the each word in the words array is an alphabet, add it to the WordsList. if not, move to next word 
		//WordsList.add(Word);
		return true;
	}	//end of if statement
	else throw new NumberFormatException("Error - Word does not start with letter");
	
}//end of method CheckWord
	

Comparator<String> comp = (String a, String b) -> {
    return b.compareTo(a);
};
//}//end of sorting object



}//end of class CompulsoryTask1
