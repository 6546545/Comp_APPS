package groupProjectFiles;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import groupProjectFiles.Date;

public class FlightDetailsFD {

	private int numRows;
	private int numColumns;
	
	public static String FDFileLocation = "D:\\Eclipse\\PracticeWork\\src\\groupProjectFiles\\FlightDetails.csv";
	
	public static String FlightListFileLocation = "D:\\Eclipse\\PracticeWork\\src\\groupProjectFiles\\FlightList.csv";
	
	private String Aircraft;
	private int TotalCarryCapacity;
	private int FC_CC;
	private int BC_CC;
	private int EC_CC;
	private int FlightNumber;
	
	private static int FlightNumIndex = 0;
	private static int SeatsUsed = 0;
	private static int SeatsEmpty = 0;
	
	private static boolean[] flightSeats75 = new boolean[75];
	private static boolean[] flightSeats100 = new boolean[100];
	
	static ArrayList<String> AirC = new ArrayList<>();
	static ArrayList<Integer> TCC = new ArrayList<>();
	static ArrayList<Integer> FC = new ArrayList<>();
	static ArrayList<Integer> BC = new ArrayList<>();
	static ArrayList<Integer> EC = new ArrayList<>();
	static ArrayList<Integer> FlightNum = new ArrayList<>();
	
	
	public static void readFlightDetailsFile() throws FileNotFoundException {
		//RUN ONCE ONLY
		String[] str;
		File f = new File(FDFileLocation);
		Scanner FI = new Scanner(f);
		while(FI.hasNextLine()) {
			str = FI.nextLine().split(",");
			AirC.add(str[0]);
			//FlightNum.add(Integer.parseInt(str[1]));
			TCC.add(Integer.parseInt(str[2]));
			FC.add(Integer.parseInt(str[3]));
			BC.add(Integer.parseInt(str[4]));
			EC.add(Integer.parseInt(str[5]));
		}
		
	}
	
	public static int createFlightNum() throws FileNotFoundException {
		int FN = (int) ((Math.random() * 99990) + 100000);
	/*	boolean match = true;
		String[] str;
		File f = new File(FlightListFileLocation);
		Scanner FI = new Scanner(f);
		ArrayList<Integer> FNum = new ArrayList<>();
		FI.next();
		FI.next();
		while(FI.hasNextLine()) {
			str = FI.nextLine().split(",");
			FNum.add(Integer.parseInt(str[0]));
		}
		
		while(match) {
			for(int i = 0; i < FNum.size(); i++) {
				if(FN == FNum.get(i)) {
					FN = (int) Math.random() * 9999990 + 10000000;
				}else {
					match = false;
				}
			}
		}*/
		return FN;
	}
	
	public static void getFlightString(int FlightHours) {//DO NOT USE THIS METHOD
		
		//String FlightDetails = "";
		if(FlightHours <= 3) {
			FlightNumIndex = 1;
			//FlightDetails += "Aircraft : " + AirC.get(1) + " Flight Number : ";
			//FlightDetails += "Aircraft : " + AirC.get(1) + " Flight Number : " + FlightNum.get(1);
		}else if(FlightHours >= 5) {
			FlightNumIndex = 1;
			//FlightDetails += "Aircraft : " + AirC.get(2) + " Flight Number : ";
			//FlightDetails += "Aircraft : " + AirC.get(2) + " Flight Number : " + FlightNum.get(2);
		}
		//return FlightDetails;
	}

	
	//USE THIS METHOD TO GET THE SEATS
	public static int SeatsAvaliable(Date Current, Date FlightDate, int FlightHours) {
		int fill = 0;
		int monthDif = 0;
		int dayDif = 0;
		
		monthDif = FlightDate.getMonth() - Current.getMonth();
		dayDif = FlightDate.getDay() - Current.getDay();
			
		int days = (monthDif * 30) + dayDif;
		//System.out.println(days);
		
		if(FlightHours <= 4) {
			FlightNumIndex = 1;
		}else if(FlightHours >= 5) {
			FlightNumIndex = 2;
		}
		
		
		if(days > 365) {
			SeatsEmpty = 0;
		}else if(days > 250) {
			SeatsEmpty = 2;
		}else if(days > 200) {
			SeatsEmpty = 3;
		}else if(days > 100) {
			SeatsEmpty = 4;
		}else if(days > 75) {
			SeatsEmpty = 5;
		}else if(days > 60) {
			SeatsEmpty = 6;
		}else if(days > 50) {
			SeatsEmpty = 9;
		}else if(days > 40) {
			SeatsEmpty = 12;
		}else if(days > 30) {
			SeatsEmpty = 14;
		}else if(days > 25) {
			SeatsEmpty = 15;
		}else if(days > 23) {
			SeatsEmpty = 2;
		}else if(days > 21) {
			SeatsEmpty = 2;
		}else if(days > 19) {
			SeatsEmpty = 2;
		}else if(days > 18) {
			SeatsEmpty = 85;
		}else if(days > 16) {
			SeatsEmpty = 87;
		}else if(days > 14) {
			SeatsEmpty = 88;
		}else if(days > 12) {
			SeatsEmpty = 89;
		}else if(days > 10) {
			SeatsEmpty = 90;
		}else if(days > 8) {
			SeatsEmpty = 91;
		}else if(days > 6) {
			SeatsEmpty = 92;
		}else if(days > 5) {
			SeatsEmpty = 93;
		}else if(days > 4) {
			SeatsEmpty = 94;
		}else if(days > 3) {
			SeatsEmpty = 95;
		}else if(days > 2) {
			SeatsEmpty = 96;
		}else if(days > 1) {
			SeatsEmpty = 97;
		}else {
			SeatsEmpty = 98;
		}
		//System.out.println(SeatsEmpty);
		
		if(FlightNumIndex == 1) {
			SeatsEmpty = (int) (SeatsEmpty * 3 / 4);
			SeatsUsed = 75 - SeatsEmpty;
		}else if(FlightNumIndex == 2) {
			SeatsUsed = 100 - SeatsEmpty;
		}
		//System.out.println(SeatsEmpty);
		return SeatsEmpty;
	}
	
	//USE THIS METHOD TO GET THE TOTAL SEATS IN THE FLIGHT
	public static int TotalSeats(int FlightHours) {
		int answer = 0;
		
		if(FlightHours <= 4) {
			FlightNumIndex = 1;
		}else if(FlightHours >= 5) {
			FlightNumIndex = 2;
		}
		
		if(FlightNumIndex == 1) {
			answer = 75;
		}else if(FlightNumIndex == 2) {
			answer = 100;
		}
		return answer;
	}

	
	//USE THIS METHOD TO GET THE TICKET PRICE
	public static double getTicketPrice(Date Current, Date FlightDate, int FlightHours) {
		double price = 0;
		int fill = 0;
		int monthDif = 0;
		int dayDif = 0;
		
		monthDif = FlightDate.getMonth() - Current.getMonth();
		dayDif = FlightDate.getDay() - Current.getDay();
		
		int days = (monthDif * 30) + dayDif;
		
		//LONGER FLIGHT HOURS MEANS HIGHER PRICES
		//LONGER THAN 21 DAYS TILL DEPARTURE MEANS HIGH PRICE
		//21 DAYS, PLUS OR MINUS 3 DAYS TILL DEPARTRUE MEANS LOWEST PRICES
		//SHORTER THAN 21 DAYS MEANS HIGHER PRICES
		if(days > 60) {
			price = Math.abs(60 - 21) + 61;
		}else if(days <= 60) {
			price = Math.abs(days - 21) + 61;
		}else if(days < 21) {
			price = (-2) * (days - 51.5);
		}
		
		price = (int) (price * FlightHours * 1.25);
		return price;
	}

	//USE THIS METHOD TO SEE IF THERE IS ANY FLIGHTS SIMILAR TO WHAT THE USER ENTERED FOR
	public static boolean checkForExitingFlights(String Departure, String Arrival, int Year, int Month, int Date) throws FileNotFoundException {
		File f = new File(FlightListFileLocation);
		Scanner FI = new Scanner(f);
		String[] str;
		boolean FlightMatch = false;
		//ArrayList<Integer> FNum = new ArrayList<>();
		while(FI.hasNextLine()) {
			str = FI.nextLine().split(",");
			if((Departure.equals(str[8])) && (Arrival.equals(str[9])) 
					&& (Year == Integer.parseInt(str[1])) 
					&& (Month == Integer.parseInt(str[2]))
					&& (Date == Integer.parseInt(str[3]))) {
				FlightMatch = true;
				break;
			}
		}
		return FlightMatch;	
	}
	
	//USE THIS METHOD IF THE ABOVE METHOD RETURNS FALSE
	public static void pushCreatedFlightToFile(String Departure, String Arrival, int Year, int Month, int Date, 
			int DHour, int DMin, int AHour, int AMin) throws IOException {
		FileWriter fw = new FileWriter(FlightListFileLocation, true);
		PrintWriter pw = new PrintWriter(fw);
		//System.out.println("marker 1");
		int Fnum = createFlightNum();
		//(int) ((Math.random() * 99990) + 100000);
		
		pw.println( Fnum + "," + Year + "," + Month + "," + Date + "," + 
		DHour + "," + DMin + "," + AHour + "," + AMin  + "," + Departure + "," + Arrival);
		//System.out.println("marker 2");
		pw.close();
	}
	
	
	//USE THESE METHOD TO GET DEPATURE HOUR
	public static int getDepartureHour(String Departure, String Arrival, int Year, int Month, int Date) throws FileNotFoundException {
		File f = new File(FlightListFileLocation);
		Scanner FI = new Scanner(f);
		String[] str;
		int DHOUR = 0;
		while(FI.hasNextLine()) {
			str = FI.nextLine().split(",");
			if((Departure.equals(str[8])) && (Arrival.equals(str[9])) 
					&& (Year == Integer.parseInt(str[1])) 
					&& (Month == Integer.parseInt(str[2]))
					&& (Date == Integer.parseInt(str[3]))) {
				DHOUR = Integer.parseInt(str[4]);
				System.out.print(DHOUR);
				break;
			}
		}
		return DHOUR;
	}
	
	//USE THESE METHOD TO GET DEPATURE MINUTES
	public static int getDepartureMin(String Departure, String Arrival, int Year, int Month, int Date) throws FileNotFoundException {
		File f = new File(FlightListFileLocation);
		Scanner FI = new Scanner(f);
		String[] str;
		int DMin = 0;
		while(FI.hasNextLine()) {
			str = FI.nextLine().split(",");
			if((Departure.equals(str[8])) && (Arrival.equals(str[9])) 
					&& (Year == Integer.parseInt(str[1])) 
					&& (Month == Integer.parseInt(str[2]))
					&& (Date == Integer.parseInt(str[3]))) {
				DMin = Integer.parseInt(str[5]);
				break;
			}
		}
		return DMin;
	}
	
	//USE THESE METHOD TO GET ARRIVAL HOUR
	public static int getArrivalHour(String Departure, String Arrival, int Year, int Month, int Date) throws FileNotFoundException {
		File f = new File(FlightListFileLocation);
		Scanner FI = new Scanner(f);
		String[] str;
		int AH = 0;
		while(FI.hasNextLine()) {
			str = FI.nextLine().split(",");
			if((Departure.equals(str[8])) && (Arrival.equals(str[9])) 
					&& (Year == Integer.parseInt(str[1])) 
					&& (Month == Integer.parseInt(str[2]))
					&& (Date == Integer.parseInt(str[3]))) {
				AH = Integer.parseInt(str[6]);
				break;
			}
		}
		return AH;
	}
	
	//USE THESE METHOD TO GET ARRIVAL HOUR
	public static int getArrivalMin(String Departure, String Arrival, int Year, int Month, int Date) throws FileNotFoundException {
		File f = new File(FlightListFileLocation);
		Scanner FI = new Scanner(f);
		String[] str;
		int AM = 0;
		while(FI.hasNextLine()) {
			str = FI.nextLine().split(",");
			if((Departure.equals(str[8])) && (Arrival.equals(str[9])) 
					&& (Year == Integer.parseInt(str[1])) 
					&& (Month == Integer.parseInt(str[2]))
					&& (Date == Integer.parseInt(str[3]))) {
				AM = Integer.parseInt(str[7]);
				break;
			}
		}
		return AM;
	}
	
	//USE THESE METHOD TO GET THE FLIGHT ID
	public static int getFlightID(String Departure, String Arrival, int Year, int Month, int Date) throws FileNotFoundException {
		File f = new File(FlightListFileLocation);
		Scanner FI = new Scanner(f);
		String[] str;
		int FID = 0;
		while(FI.hasNextLine()) {
			str = FI.nextLine().split(",");
			if((Departure.equals(str[8])) && (Arrival.equals(str[9])) 
					&& (Year == Integer.parseInt(str[1])) 
					&& (Month == Integer.parseInt(str[2]))
					&& (Date == Integer.parseInt(str[3]))) {
				FID = Integer.parseInt(str[0]);
				System.out.print(FID);
				break;
			}
			
		}
		return FID;
	}
	
	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------
	public FlightDetailsFD(int numRows, int numColumns, String aircraft, int totalCarryCapacity, int fC_CC, int bC_CC,
			int eC_CC, int flightNumber) {
		super();
		this.numRows = numRows;
		this.numColumns = numColumns;
		Aircraft = aircraft;
		TotalCarryCapacity = totalCarryCapacity;
		FC_CC = fC_CC;
		BC_CC = bC_CC;
		EC_CC = eC_CC;
		FlightNumber = flightNumber;
	}

	public String getAircraft() {
		return Aircraft;
	}

	public void setAircraft(String aircraft) {
		Aircraft = aircraft;
	}

	public int getTotalCarryCapacity() {
		return TotalCarryCapacity;
	}

	public void setTotalCarryCapacity(int totalCarryCapacity) {
		TotalCarryCapacity = totalCarryCapacity;
	}

	public int getFC_CC() {
		return FC_CC;
	}

	public void setFC_CC(int fC_CC) {
		FC_CC = fC_CC;
	}

	public int getBC_CC() {
		return BC_CC;
	}

	public void setBC_CC(int bC_CC) {
		BC_CC = bC_CC;
	}

	public int getEC_CC() {
		return EC_CC;
	}

	public void setEC_CC(int eC_CC) {
		EC_CC = eC_CC;
	}
	
	//-------------------------------------------------------------------------------

	public int getFlightNumber() {
		return FlightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		FlightNumber = flightNumber;
	}

	public FlightDetailsFD() {
		numRows = 0;
		numColumns = 0;
	}

	public FlightDetailsFD(int numRows, int numColumns) {
		this.numColumns = numColumns;
		this.numRows = numRows;
	}
	
	//-------------------------------------------------------------------------------
	
	public int getNumColumns() {
		return numColumns;
	}

	public void setNumColumns(int numColumns) {
		this.numColumns = numColumns;
	}

	public int getNumRows() {
		return numRows;
	}

	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}

	public boolean[][] populateSeats(int numSeatsRows, int numSeatsColumn) {
		Scanner input = new Scanner(System.in);
		boolean[][] seats = new boolean[numSeatsRows][numSeatsColumn];
		for (int i = 0; i < numSeatsRows; i++) {
			for (int j = 0; j < numSeatsColumn; j++) {
				seats[i][j] = false;
			}
		}
		return seats;
	}

	public ArrayList<Boolean> populateSeats2(ArrayList<Boolean> testList, int maxSeats) {
		ArrayList<Boolean> testList1 = new ArrayList<Boolean>();
		for (int i=0; i <maxSeats; i++) {
			testList1.add(false);
		}
		//Collections.fill(testList, Boolean.FALSE);
		return testList1;
	}

	public void displaySeats2(ArrayList<Boolean> testList, int maxSeats) {
		for (int i = 0; i < testList.size(); i++) {
			System.out.println(testList.get(i));
		}
	}

	public void displaySeats(boolean[][] array, int numSeatsRows, int numSeatsColumn) {
		for (int i = 0; i < numSeatsRows; i++) {
			for (int j = 0; j < numSeatsColumn; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
