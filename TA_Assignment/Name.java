/*Eric Grube
 * COP3330 Section 0001
 * 10/15/13
 * This is the name class
 */

public class Name extends Object implements Comparable<Name> {

	//Make the fields for the Name object
	private String lastName;
	private String firstName;

	//This makes an object using the first and last given name
	public Name(String first, String last) {

		//Make a substring taking off the first letter of each name
		String lastNameSub = last.substring(1,last.length());
		String firstNameSub = first.substring(1,first.length());
		
		//Make a substring using only the first letter of the first and last name
		String lastNameSub1 = last.substring(0,1);
		String firstNameSub1 = first.substring(0,1);

		//Makes the first letter of each name upper case, and the end of the other names lower case.
		firstName = firstNameSub1.toUpperCase() + firstNameSub.toLowerCase();
		lastName = lastNameSub1.toUpperCase() + lastNameSub.toLowerCase();

	}
 
	//Make a compareTo method that sets the ordering of the names
	public int compareTo(Name other) {
		//take in the names. If the first letter of the last name comes before the other name, the method will return -1 which means that the
		//object should come before the other name.
		if((this.lastName.charAt(0)) < (other.lastName.charAt(0))) {
			return -1;
		}

		//if the first letter of the last name comes after the other name, then 1 is returned
		else if((this.lastName.charAt(0)) > (other.lastName.charAt(0))) {
			return 1;
		}

		//if the first letter of both names are equal, then we just compare the first names as the last names were
		else {
			if(this.firstName.charAt(0) < other.firstName.charAt(0)) {
				return -1;
			}

			else if(this.firstName.charAt(0) > other.firstName.charAt(0)) {
				return 1;
			}

			else {
				return 0;
			}

		}

	}

	//This boolean checks to see if the names are equal, hence another assignment
	public boolean equals(Name other) {
		
		//if equal, then they are the same name. Otherwise, it returns false
		if((this.firstName).equals(other.firstName) && ((this.lastName).equals(other.lastName))) {
			return true;
		}

		else {
			return false;
		}
	}

	//Put the names in a toString method that formats then in the proper notation as denoted by the assignment parameters.
	public String toString() {
		String nameString = new String(this.firstName + " " + this.lastName);
		return nameString;
	}
}
