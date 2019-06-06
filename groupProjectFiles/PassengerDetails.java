package groupProjectFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class PassengerDetails {
	
	private String FirstName;
	private String LastName;
	private String Gender;
	private int Age;
	private long PhoneNumber;
	private String Email;
	private String CurrentAddress;
	public String PassengerDetailsCSV = "D:\\Eclipse\\PracticeWork\\src\\groupProjectFiles\\PassengerDetails.csv";//\\CSC201_INCLASS\\src
	
	
	public PassengerDetails() {
		
	}
	
	public PassengerDetails(String firstName, String lastName, String gender, int age, long phoneNumber, String email,
			String currentAddress) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Gender = gender;
		Age = age;
		PhoneNumber = phoneNumber;
		Email = email;
		CurrentAddress = currentAddress;
	}
	
	public void sendPassengerDetailsToFile() throws IOException {
		FileWriter fw = new FileWriter(PassengerDetailsCSV, true);
		PrintWriter pw = new PrintWriter(fw);
		pw.println( FirstName + ", " + LastName + ", " + Gender + ", " + Age + ", " + PhoneNumber + ", " + Email + ", " + CurrentAddress );
		pw.close();
	}
	
	//-----------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------
	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public long getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getCurrentAddress() {
		return CurrentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		CurrentAddress = currentAddress;
	}
	//-----------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------
	public String SearchString(String FName) throws FileNotFoundException {
		//Returns a list of matching names in a string
		String[] str;
		File f = new File(PassengerDetailsCSV);
		Scanner FI = new Scanner(f);
		String FirstNameMatch= "FIRST NAME MATCH : -----------------------\n";
		String LastNameMatch = "LAST NAME MATCH  : -----------------------\n";
		String AddressMatch  = "ADDRESS MATCH    : -----------------------\n";
		String EmailMatch    = "EMAIL MATCH      : -----------------------\n";
		String FinalOutput   = "";
		
		while(FI.hasNextLine()) {
			str = FI.nextLine().split(",");
		
			if(str[0].toUpperCase().equals(FName.toUpperCase())){
				//FIRST NAME MATCH
				FirstNameMatch += (str[0] + ", " + str[1] + ", "
								 + str[2] + ", " + str[3] + ", " 
								 + str[4] + ", " + str[5] + ", " + str[6] + "\n");
			}
			if(str[1].toUpperCase().equals(FName.toUpperCase())){
				//LAST NAME MATCH
				LastNameMatch += (str[0] + ", " + str[1] + ", "
								+ str[2] + ", " + str[3] + ", " 
								+ str[4] + ", " + str[5] + ", " + str[6] + "\n");
			}
			if(str[5].toUpperCase().equals(FName.toUpperCase())){
				//EMAIL MATCH
				EmailMatch += (str[0] + ", " + str[1] + ", "
							 + str[2] + ", " + str[3] + ", " 
							 + str[4] + ", " + str[5] + ", " + str[6] + "\n");
			}
			if(str[6].toUpperCase().equals(FName.toUpperCase())){
				//ADDRESS MATCH
				AddressMatch += (str[0] + ", " + str[1] + ", "
							   + str[2] + ", " + str[3] + ", " 
							   + str[4] + ", " + str[5] + ", " + str[6] + "\n");
			}
			
		}
		FinalOutput = (FirstNameMatch + "\n" + LastNameMatch + "\n" + EmailMatch + '\n' + AddressMatch);
		return FinalOutput;
	}
	
	public String SearchFirstName(String FName) throws FileNotFoundException {
		//Returns a list of matching names in a string
		String[] str;
		File f = new File(PassengerDetailsCSV);
		Scanner FI = new Scanner(f);
		String FirstNameMatch= "FIRST NAME MATCH : -----------------------\n";
		String FinalOutput   = "";
		
		while(FI.hasNextLine()) {
			str = FI.nextLine().split(",");
		
			if(str[0].toUpperCase().equals(FName.toUpperCase())){
				//FIRST NAME MATCH
				FirstNameMatch += (str[0] + ", " + str[1] + ", "
								 + str[2] + ", " + str[3] + ", " 
								 + str[4] + ", " + str[5] + ", " + str[6] + "\n");
			}
			/*if(str[1].toUpperCase().equals(FName.toUpperCase())){
				//LAST NAME MATCH
				LastNameMatch += (str[0] + ", " + str[1] + ", "
								+ str[2] + ", " + str[3] + ", " 
								+ str[4] + ", " + str[5] + ", " + str[6] + "\n");
			}
			if(str[5].toUpperCase().equals(FName.toUpperCase())){
				//EMAIL MATCH
				EmailMatch += (str[0] + ", " + str[1] + ", "
							 + str[2] + ", " + str[3] + ", " 
							 + str[4] + ", " + str[5] + ", " + str[6] + "\n");
			}
			if(str[6].toUpperCase().equals(FName.toUpperCase())){
				//ADDRESS MATCH
				AddressMatch += (str[0] + ", " + str[1] + ", "
							   + str[2] + ", " + str[3] + ", " 
							   + str[4] + ", " + str[5] + ", " + str[6] + "\n");
			}*/
			
		}
		FinalOutput = (FirstNameMatch); // + "\n" + LastNameMatch + "\n" + EmailMatch + '\n' + AddressMatch);
		return FinalOutput;
		
		
	}

	public String SearchLastName(String LName) throws FileNotFoundException {
		//Returns a list of matching names in a string
				String[] str;
				File f = new File(PassengerDetailsCSV);
				Scanner FI = new Scanner(f);
				//String FirstNameMatch= "FIRST NAME MATCH : -----------------------\n";
				String LastNameMatch = "LAST NAME MATCH  : -----------------------\n";
				//String AddressMatch  = "ADDRESS MATCH    : -----------------------\n";
				//String EmailMatch    = "EMAIL MATCH      : -----------------------\n";
				String FinalOutput   = "";
				
				while(FI.hasNextLine()) {
					str = FI.nextLine().split(",");
				
					/*if(str[0].toUpperCase().equals(LName.toUpperCase())){
						//FIRST NAME MATCH
						FirstNameMatch += (str[0] + ", " + str[1] + ", "
										 + str[2] + ", " + str[3] + ", " 
										 + str[4] + ", " + str[5] + ", " + str[6] + "\n");
					}*/
					if(str[1].toUpperCase().equals(LName.toUpperCase())){
						//LAST NAME MATCH
						LastNameMatch += (str[0] + ", " + str[1] + ", "
										+ str[2] + ", " + str[3] + ", " 
										+ str[4] + ", " + str[5] + ", " + str[6] + "\n");
					}
					/*if(str[5].toUpperCase().equals(LName.toUpperCase())){
						//EMAIL MATCH
						EmailMatch += (str[0] + ", " + str[1] + ", "
									 + str[2] + ", " + str[3] + ", " 
									 + str[4] + ", " + str[5] + ", " + str[6] + "\n");
					}
					if(str[6].toUpperCase().equals(LName.toUpperCase())){
						//ADDRESS MATCH
						AddressMatch += (str[0] + ", " + str[1] + ", "
									   + str[2] + ", " + str[3] + ", " 
									   + str[4] + ", " + str[5] + ", " + str[6] + "\n");
					}*/
					
				}
				//FinalOutput = (FirstNameMatch + "\n" + LastNameMatch + "\n" + EmailMatch + '\n' + AddressMatch);
				FinalOutput = LastNameMatch;
				return FinalOutput;

	}
	
	public String SearchNumber(int in) throws FileNotFoundException {
		String[] str;
		File f = new File(PassengerDetailsCSV);
		Scanner FI = new Scanner(f);
		String PhoneNumMatch  = "PHONE NUMBER MATCH    : -----------------------\n";
		String AgeMatch       = "AGE MATCH             : -----------------------\n";
		String FinalOutput   = "";
		
		while(FI.hasNextLine()) {
			str = FI.nextLine().split(",");
			String oneS = str[3];	int oneSI = Integer.parseInt((String) oneS);
			//String twoS = str[4];	int twoSI = Integer.parseInt((String) twoS);
			if(oneSI == in){
				//AGE MATCH
				AgeMatch += (str[0] + ", " + str[1] + ", "
						   + str[2] + ", " + str[3] + ", " 
						   + str[4] + ", " + str[5] + ", " + str[6] + "\n");
			}
			
			/*if(twoS.equals(in)){
				//PHONE NUMBER MATCH
				PhoneNumMatch += (str[0] + ", " + str[1] + ", "
						   + str[2] + ", " + str[3] + ", " 
						   + str[4] + ", " + str[5] + ", " + str[6] + "\n");
			}*/
			FinalOutput = (AgeMatch + "\n" + PhoneNumMatch);
		}
		return FinalOutput;
	}
	
	public String SearchNumber(long num) throws FileNotFoundException {
		String[] str;
		File f = new File(PassengerDetailsCSV);
		Scanner FI = new Scanner(f);
		String PhoneNumMatch  = "PHONE NUMBER MATCH    : -----------------------\n";
		String AgeMatch       = "AGE MATCH             : -----------------------\n";
		String FinalOutput   = "";
		
		while(FI.hasNextLine()) {
			str = FI.nextLine().split(",");
			/*if(Integer.parseInt(str[2]) == num){
				//AGE MATCH
				AgeMatch += (str[0] + ", " + str[1] + ", "
						   + str[2] + ", " + str[3] + ", " 
						   + str[4] + ", " + str[5] + ", " + str[6] + "\n");
			}*/
			if(Long.parseLong(str[4]) == num){
				//PHONE NUMBER MATCH
				PhoneNumMatch += (str[0] + ", " + str[1] + ", "
						   + str[2] + ", " + str[3] + ", " 
						   + str[4] + ", " + str[5] + ", " + str[6] + "\n");
			}
			FinalOutput = (AgeMatch + "\n" + PhoneNumMatch);
		}
		return FinalOutput;
	}
	
	public String getFileLocation() {
		return PassengerDetailsCSV;
	}
			
}
