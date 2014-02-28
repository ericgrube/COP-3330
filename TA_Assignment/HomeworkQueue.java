/*Eric Grube
 * COP3330 Section 0001
 * 10/15/13
 * This is the homework class
 */

public class Homework extends Object implements Comparable<Homework> {
	
	//Make all the variables for the class
	public static int nextAvailableUid = 0;
	private Files filesField;
	private int dateSubmittedField;
	private int idField;
	private Name nameField;
	private int sectionField;	

	// Make a homework assignment with the variables given.
	public Homework(int id, Name name, int section, Files files, int dateSubmitted) {
		filesField = files;
		dateSubmittedField = dateSubmitted;
		idField = id;
		nameField = name;
		sectionField = section;
	}

	// Make a homework assignment with the given files and the empty list of files.
	public Homework(int id, Name name, int section, int dateSubmitted) {
		dateSubmittedField = dateSubmitted;
		idField = id;
		nameField = name;
		sectionField = section;
	}

	// Make an assignemnt that generates the next valid ID automatically
	public Homework(String first, String last, int section, int dateSubmitted) {
		dateSubmittedField = dateSubmitted;
		sectionField = section;
	}

	// This method compares the homeworks to get their priorities for grading
	public int compareTo(Homework other) {

		if(this.getDaysLate() < other.getDaysLate()) {
			return -1;
		}

		else if(this.getDaysLate() > other.getDaysLate()) {
			return 1;
		}

		else if((this.getDaysLate() == other.getDaysLate()) && ((this.filesField).compareTo(other.filesField) < 0)) {
			return -1;
		}

		else if((this.getDaysLate() == other.getDaysLate()) && ((this.filesField).compareTo(other.filesField) > 0)) {
			return 1;
		}

		else if((this.getDaysLate() == other.getDaysLate()) && ((this.filesField).compareTo(other.filesField) == 0) && (this.getName().compareTo(other.getName()) < 0)) {
			return -1;
		}

		else if((this.getDaysLate() == other.getDaysLate()) && ((this.filesField).compareTo(other.filesField) == 0) && (this.getName().compareTo(other.getName()) > 0)) {
			return 1;
		}

		else {
			return 0;
		}

	}

	// Make the next ID for homework assignment and put it into the next available ID
	public static int generateNextUniqueId() {
		nextAvailableUid++;
		return nextAvailableUid;
	}

	// Get the number of late days for the homework assignment
	// If it's negative, then the assignment was submitted early by that many days
	// Since all the assignments are due on the 15th, then it is assumed to be submitted on the month that they are due
	public int getDaysLate() {
		return (dateSubmittedField - 15);
	}

	// Gets the files for the homework assignment
	public Files getFiles() {
		return filesField;
	}

	// Get the ID that is associated with the homework
	public int getId() {
		return idField;
	}

	// Gets the name of the associated homework for the student who turned in the assignment
	public Name getName() {
		return nameField;
	}

	// Get the section number of the homework assignment
	public int getSection() {
		return sectionField;
	}

	// Puts in a toString method to change the homework representation to a String for output
	public String toString() {

		String daysString = new String();

		if(this.getDaysLate() < 0) {
			daysString = ("" + (this.getDaysLate()*(-1)) + " day(s) early ");
		}

		else if(this.getDaysLate() > 0) {
			daysString = ("" + this.getDaysLate() + " day(s) late ");
		}

		else {
			daysString = ("on time ");
		}

		String homeworkString = new String("Homework " + idField + ": " + filesField.getNumberOfFile() + " files(s) " + filesField.toString() + " submitted by " + nameField.toString() + " " + daysString + "for section " + sectionField);
		return homeworkString;

	}

}
