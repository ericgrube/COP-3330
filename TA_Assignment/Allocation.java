/*Eric Grube
 * COP3330 Section 0001
 * 10/15/13
 * This is the allocation class
 */

import java.util.*;
import java.io.*;

public class Allocation extends Object {

	public static void main(String[] args) {
		
		//Try-catch for error handling
		try {
			// Setup the scanner and filewriters for the input and output files
			Scanner sc = new Scanner(new File("HW_List"));
			FileWriter fw = new FileWriter("HW_Allocation.txt");
			PrintWriter filePrinter = new PrintWriter(fw);
			HomeworkQueue hwq = new HomeworkQueue();

			// Make a while loop to read in the data from the HW_List file
		    while(sc.hasNext()) {
		    	String lastName = sc.next();	/*lastName*/
		    	String firstName = sc.next();
		    	int section = sc.nextInt();
		    	int date = sc.nextInt();
		    	int numFiles = sc.nextInt();
		    	Name studentName = new Name(firstName, lastName);
		    	String fileArray[] = new String[numFiles];

		    	//Place the file into a string array
		    	for(int i = 0; i < numFiles; i++) {
		    		fileArray[i] = sc.next();
		    	}

		    	// Make a file object with the array of files
		    	Files files = new Files(fileArray);

		    	//Make a homework object using the files object and the other variables needed
		    	Homework hw  = new Homework(Homework.generateNextUniqueId(), studentName, section, files, date);

		    	// Put the homework into a boolean queue and store it on whether or not it was added
		    	boolean addedToQueue = hwq.addHomework(hw);

		    	//prints out the string according to whether or not it was added to the queue
		    	if(addedToQueue) {
		    		filePrinter.println(hw.toString() + " added to the queue.");
		    	}

		    	else {
		    		filePrinter.println(hw.toString() + " already in queue. Not added.");
		    	}
		    }	

		    filePrinter.println("Finished processing homeworks!");
		    filePrinter.println();

		    // Sets up a new Scanner and a new homework object
		    Scanner sc2 = new Scanner(new File("TA_Queries"));
		    Homework currentHW = null;

		    // Go through the TA queries until it reaches the end of the file
		    while(sc2.hasNext()) {

		    	//Puts the data into variables
		    	int taID = sc2.nextInt();
		    	int taSection = sc2.nextInt();
		    	int numHW = sc2.nextInt();

		    	// If the homework section is empty, then the result is printed out. If it isn't, then a loop gets as many homeworks as possible without going over the limit of the TA.
		    	// Then it outputs the results
		    	if(hwq.sectionIsEmpty(taSection)) {
		    		filePrinter.println("TA " + taID + " assigned no homeworks. Nothing in the queue for section " + taSection);
		    	}

		    	else {
		    		//If not, then it all gets printed out to the file as it is
		    		int hwCount = 0;
		    		for(int i = 0; !(hwq.sectionIsEmpty(taSection)) && (i < numHW); i++, hwCount ++) {
		    			currentHW = hwq.getHomework(taSection);
		    			String daysString = new String();
		    			if(currentHW.getDaysLate() < 0) {
		    				daysString = ("" + (currentHW.getDaysLate()*(-1)) + " day(s) early ");
		    			}

		    			else if(currentHW.getDaysLate() > 0) {
		    				daysString = ("" + currentHW.getDaysLate() + " day(s) late ");
		    			}

		    			else {
		    				daysString = ("on time ");
		    			}

		    			filePrinter.println("TA " + taID + " gets assigned homework " + currentHW.getId() + ": " + currentHW.getFiles().getNumberOfFile() + " files(s) " + 
		    			currentHW.getFiles().toString() + " submitted by " + currentHW.getName().toString() + " " + daysString + "for section " + currentHW.getSection());
		    		}

		    		if((hwCount) == 0) {
		    			filePrinter.println("TA " + taID + " assigned no homeworks. Nothing in the queue for section " + currentHW.getSection());
		    		}

		    		else if((hwCount) < numHW) {
		    			filePrinter.println("TA " + taID + " assigned " + hwCount + "/"
		    			+ numHW + " homework(s) from section " + currentHW.getSection() + ".");
		    		}

		    		else if((hwCount) == numHW) {
		    			filePrinter.println("TA " + taID + " assigned all " + hwCount + " requested homework(s) from section " + currentHW.getSection() + ".");
		    		}
		    	}	

		    	filePrinter.println();
		    }

		    filePrinter.println("Finished processing TA Queries! Exiting.");
		    filePrinter.close(); // you have to close when finish

		}

		catch(Exception e) {
		    e.printStackTrace();
		}

	}	    	

}
