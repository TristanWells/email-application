package emailapp;

import java.util.Scanner; //Java utility for user to input data/information

public class Email {
	
	private String firstName;					// First name variable
	private String lastName;					// Last name variable
	private String password;					// Password variable
	private String department;					// Department name variable
	private int mailboxCapacity = 500;			// Mailbox memory capacity
	private String alternateEmail;				// Alternative email 
	private int defaultPasswordLength = 10;		// Length of randomly generated password
	private String email;						// Email
	private String companySuffix = "java.com"; 	// Email suffix example
	
	// Constructor to receive first/last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);
		
		// Call method asking for the department - return department
		this.department = setDepartment();
		System.out.println("Department: " + this.department);
		
		// Call method to return random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);
		
		//Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		System.out.println("Your email is: " + email);
	}
	// Ask for department
	private String setDepartment() {
		System.out.print("DEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter Department Code:");
		Scanner in = new Scanner(System.in);
		int deptChoice = in.nextInt();
		if (deptChoice == 1){return "Sales";}
		else if (deptChoice == 2) {return "Development";}
		else if (deptChoice == 3) {return "Accounting";}
		else {return "None";}
	}
			
	// Generate random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	// Set mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	// Set alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail= altEmail;
	}
	
	// Change password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() { return mailboxCapacity; }
	public String getAlternateEmail() { return alternateEmail; }
	public String getPassword() { return password; }
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName + 
				"\nCOMPANY EMAIL: " + email + 
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}
}
