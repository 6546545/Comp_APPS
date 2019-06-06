package groupProjectFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;



public class LoadPassengerData {
	
	static PassengerDetails sample = new PassengerDetails();
	static String FirstName;
	static String LastName;
	static String Gender;
	static int Age;
	static long PhoneNumber;
	static String Email;
	static String CurrentAddress;
	static String PassengerDetailsCSV = "D:\\Eclipse\\PracticeWork\\src\\groupProjectFiles\\PassengerDetails.csv";//\\CSC201_INCLASS\

	static String oneDeparture;
	static String twoDeparture;
	static String oneArrival;
	static String twoArrival;
	
	static String AirportsList;
	
	static FlightTimings FT;
	
	static int FlightHours;
	static int FlightMins;
	
	static String FlightTime1;
	static String FlightTime2;
	
	public static Date d1;
	public static Date dD;
	public static Date dA;
	public static String[] str;
	public static int[] in;
	
	public static void main(String[] args) throws IOException, FileNotFoundException {
		
		//These two lines of Code should be run at the begining and only once. 
		
		
		
		
		/*Scanner one = new Scanner(System.in);
		int UserOption = 0;
		
		System.out.println("Enter today's Date");
		System.out.print("Enter the Year   : ");
		int year = one.nextInt();
		System.out.print("Enter the Month  : ");
		int month = one.nextInt();
		System.out.print("Enter the Day    : ");
		int day = one.nextInt();
		
		d1 = new Date(year, month, day);
	
		System.out.println(d1.getMonth() + "/" + d1.getDay() + "/" + d1.getYear());
		
		//int FN = (int) ((Math.random() * 99990) + 100000);
		//System.out.println(FN);
		
		//getNewCustomerDetails();
		//loadCustomerDetailsToFile();*/
		//MainMenu();
		
		
		
		
		
	}
	
	public static void MainMenu() throws IOException, FileNotFoundException {
		
		Scanner one = new Scanner(System.in);
		int UserOption = 0;
		System.out.println("---------------------------------------------------");
		System.out.println("Enter the number for that option : ");
		System.out.println("-> Look up Customer Details (1) ");
		System.out.println("-> Look for new flights     (2) ");
		UserOption = one.nextInt();
		if(UserOption == 1) {
			System.out.println("Enter the number for that option : ");
			System.out.println("-> Search with Number       (1) ");
			System.out.println("-> Search with words        (2) ");
			System.out.println("-> Back to previous options (9) ");
			UserOption = one.nextInt();
			
			if(UserOption == 1) {
				fileSearchNumber();
			}else if(UserOption == 2) {
				fileSearchString();
			}else if(UserOption == 9) {
				MainMenu();
			}
			
		}else if (UserOption == 2) {
			lookForFlights();
		}
	}
	
	public static void fileSearchNumber() throws IOException, FileNotFoundException {
		Scanner one = new Scanner(System.in);
		
		File f = new File(PassengerDetailsCSV);
		if(f.canRead() || f.exists()) {
			System.out.println("Can Read File");
		}
		
		int UserOption = 0;
		
		System.out.println("Enter the number for that option : ");
		System.out.println("-> Look up Phone Number     (1) ");
		System.out.println("-> Look up Age              (2) ");
		UserOption = one.nextInt();
		if(UserOption == 1) {
			long number = 0;
			System.out.println("------------------------------------------------------------");
			System.out.println("Enter number to Search");
			number = one.nextLong();
			System.out.println("------------------------------------------------------------");
			System.out.println(sample.SearchNumber(number));
		}else if(UserOption == 2) {
			int number = 0;
			System.out.println("------------------------------------------------------------");
			System.out.println("Enter number to Search");
			number = one.nextInt();
			System.out.println("------------------------------------------------------------");
			System.out.println(sample.SearchNumber(number));
		}
		System.out.println("------------------------------------------------------------");
		MainMenu();
	}
	
	public static void fileSearchString() throws IOException, FileNotFoundException {
		Scanner one = new Scanner(System.in);
		
		File f = new File(PassengerDetailsCSV);
		if(f.canRead() || f.exists()) {
			System.out.println("Can Read File");
		}
		
		String Name = "";
		System.out.println("------------------------------------------------------------");
		System.out.println("Enter Name to Search");
		Name = one.nextLine();
		System.out.println("------------------------------------------------------------");
		System.out.println(sample.SearchString(Name));
		System.out.println("------------------------------------------------------------");
		MainMenu();
	}

	public static void getNewCustomerDetails() throws IOException, FileNotFoundException {
		Scanner one = new Scanner(System.in);
		System.out.println("--------------------------------------------");
		System.out.print("First Name      : ");
			FirstName = one.nextLine();			FirstName = FirstName.replaceAll("\\s+", "");
		System.out.print("Last Name       : ");
			LastName = one.nextLine();			LastName = LastName.replaceAll("\\s+", "");
		System.out.print("Gender          : ");
			Gender = one.nextLine();			Gender = Gender.replaceAll("\\s+", "");
		System.out.print("Age             : ");
			Age = one.nextInt();			
		System.out.print("Phone Number    : ");
			PhoneNumber = one.nextLong();
			Scanner two = new Scanner(System.in);
		System.out.print("Email           : ");
			Email = two.nextLine();				Email = Email.replaceAll("\\s+", "");
		System.out.print("Current Address : ");
			CurrentAddress = two.nextLine();	CurrentAddress = CurrentAddress.replaceAll("\\s+", "");
		System.out.println("--------------------------------------------");
		
	}
	
	public static void loadCustomerDetailsToFile() throws IOException, FileNotFoundException {
		PassengerDetails Load = new PassengerDetails(FirstName, LastName, Gender, Age, PhoneNumber, Email, CurrentAddress);
		Load.sendPassengerDetailsToFile();
	}
	
	public static void lookForFlights() throws IOException, FileNotFoundException {
		Scanner one = new Scanner(System.in);
		int UserOption = 0;
		System.out.println("---------------------------------------------------");
		System.out.println("Enter the number for that option : ");
		System.out.println("-> One-way trip             (1) ");
		System.out.println("-> Round trip               (2) ");
		System.out.println("-> Back to previous options (9) ");
		UserOption = one.nextInt();
		System.out.println(FT.getAirports());
		if(UserOption == 1) {
			OneWayTrip();
		}else if(UserOption == 2){
			RoundTrip();
		}else if(UserOption == 9) {
			MainMenu();
		}
	}

	public static void OneWayTrip() throws IOException, FileNotFoundException {
		Scanner one = new Scanner(System.in);
		System.out.println("Enter Departure Airport (Abbreviation) ");
		oneDeparture = one.nextLine();
		System.out.println("Enter Arival Airport (Abbreviation)    ");
		oneArrival = one.nextLine();
		System.out.println("---------------------------------------------------");
		System.out.println("Flight Time is : " + FT.getHours(oneDeparture, oneArrival));
		System.out.println("---------------------------------------------------");
		numberOfFlightsOneWay();
		MainMenu();
	}
	
	public static void RoundTrip() throws IOException, FileNotFoundException {
		Scanner one = new Scanner(System.in);
		//System.out.println("Enter for first flight ");
		System.out.println("Enter Departure Airport (Abbreviation) ");
		oneDeparture = one.nextLine();	twoArrival = oneDeparture;
		System.out.println("Enter Arival Airport (Abbreviation)    ");
		oneArrival = one.nextLine();	twoDeparture = oneArrival;
		System.out.println("---------------------------------------------------");
		System.out.println("Flight Time is : " + FT.getHours(oneDeparture, oneArrival));
		System.out.println("---------------------------------------------------");
		numberOfFlightsTwoWay();
		MainMenu();
	}
	
	public static void numberOfFlightsOneWay() throws IOException, FileNotFoundException {
		Scanner one = new Scanner(System.in);
		int numFlightsAvaliable = 0;
		String date1 = "";
		String date2 = "";
		if(FT.getFlightHourNumber(oneDeparture, oneArrival) > 4) {
			numFlightsAvaliable = 1;
			//date1 = getDateOneWay();;
		}else {
			numFlightsAvaliable = 2;
			//date1 = getDateOneWay();;
		}
		
		
		double h = (Math.random() * 5 ) + 7 ;
		int StartHour = (int) h;
		double m = (Math.random() * 60 );
		int StartMin = (int) m;
		
		int EndHour = StartHour + FT.getFlightHourNumber(oneDeparture, oneArrival);
		int EndMin  = StartMin + FT.getFlightMinNumber(oneDeparture, oneArrival);
		
		if(EndMin > 59) {
			EndMin -= 60;
			EndHour++;
		}
		
		
		// THE NEXT 15-20 LINES OF CODE IS TO GET THE FLIGHT INFO, EMPTY SEATS AND THE PRICE OF THE TICKET. 
		
		
		boolean abc = FlightDetailsFD.checkForExitingFlights(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
		
		//System.out.println(abc);
		
		if(abc == false) {
			//System.out.println("1");
			FlightDetailsFD.pushCreatedFlightToFile(oneDeparture, oneArrival, 
				dD.getYear(), dD.getMonth(), dD.getDay(), 
				StartHour, StartMin, EndHour, EndMin);
		}
		

		FlightDetailsFD.getFlightString(FlightTimings.getFlightHourNumber(oneDeparture, oneArrival));
		System.out.println(displayDepartureFlight());
		System.out.println("     Seats Avaliable on this Flight : " + FlightDetailsFD.SeatsAvaliable(d1, dD, EndHour-StartHour) 
							+ "/" + FlightDetailsFD.TotalSeats(EndHour-StartHour));
		System.out.println("     Price of Ticket : $" + FlightDetailsFD.getTicketPrice(d1, dD, EndHour-StartHour));
		
		System.out.println("To continue with this flight, enter 'C' ");
		System.out.println("To go to main menu, enter           'M' ");
		System.out.println("To search for a new flight, enter   'F' ");
		String TEMP = one.nextLine();
		
		if(TEMP.toUpperCase().equals("C")) {
			getNewCustomerDetails();
			//System.out.println("|||GOT DATA");
			loadCustomerDetailsToFile();
			//System.out.println("|||SENT DATA");
			//System.out.println(FINALTICKET_OneWay(TEMP, TEMP, d1, d1));
			System.exit(0);
			//System.out.println("|||OUTPUT");
		}else if(TEMP.toUpperCase().equals("M")) {
			MainMenu();
		}else if(TEMP.toUpperCase().equals("F")) {
			lookForFlights();
		}
		
		
		/*int FOD = 0;
		FlightTime1 = "Flight 1 : " + date1 
		+ "| Departure : " + StartHour + ":" + StartMin 
		+ "| Arrival   : " + EndHour + ":" + EndMin;
		if(numFlightsAvaliable == 2) {
			FlightTime2 = "Flight 1 : " + date1 
			+ "| Departure : " + (StartHour+6) + ":" + StartMin 
			+ "| Arrival   : " + (EndHour+6) + ":" + EndMin;	
		}
		if(numFlightsAvaliable == 1){
			System.out.println("Enter which flight you want to choose :");
			System.out.println("Flight 1 : " + date1 
			+ "| Departure : " + StartHour + ":" + StartMin 
			+ "| Arrival   : " + EndHour + ":" + EndMin + "       (1)");
			System.out.println("Enter for Main Menu                                         (9)");
		}
		if(numFlightsAvaliable == 2){
			System.out.println("Enter which flight you want to choose :");
			System.out.println("Flight 1 : " + date1 
			+ "| Departure : " + StartHour + ":" + StartMin 
			+ "| Arrival   : " + EndHour + ":" + EndMin + "       (1)");
			System.out.println("Flight 1 : " + date1 
			+ "| Departure : " + (StartHour+6) + ":" + StartMin 
			+ "| Arrival   : " + (EndHour+6) + ":" + EndMin + "       (2)");
			System.out.println("Enter for Main Menu                                        (9)");
		}	
		FOD = one.nextInt();
		if(FOD == 9) {
			MainMenu();
		}*/
	}
	
	public static void numberOfFlightsTwoWay() throws IOException, FileNotFoundException {
		Scanner one = new Scanner(System.in);
		int numFlightsAvaliable = 0;
		String date1 = "";
		String date2 = "";
		int FOD = 0;
		int FOA = 0;
		if(FT.getFlightHourNumber(oneDeparture, oneArrival) > 4) {
			numFlightsAvaliable = 1;
			//date1 = getDateOneWay();
			//date2 = getDateSecondWay();
		}else {
			numFlightsAvaliable = 2;
			//date1 = getDateOneWay();
			//date2 = getDateSecondWay();
		}
		double h = (Math.random() * 5 ) + 7 ;
		int StartHour = (int) h;
		double m = (Math.random() * 60 );
		int StartMin = (int) m;
		
		int EndHour = StartHour + FT.getFlightHourNumber(oneDeparture, oneArrival);
		int EndMin  = StartMin + FT.getFlightMinNumber(oneDeparture, oneArrival);
		
		if(EndMin > 59) {
			EndMin -= 60;
			EndHour++;
		}
		
		
		// THE NEXT 30-35 LINES OF CODE IS TO GET THE FLIGHT INFO, SEATS AVAILABLE AND THE PRICE FOR THE TICKET
		
		boolean Going  = FlightDetailsFD.checkForExitingFlights(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
		boolean Coming = FlightDetailsFD.checkForExitingFlights(twoDeparture, twoArrival, dA.getYear(), dA.getMonth(), dA.getDay());
		//System.out.println(Going + " " + Coming);
		
		if(Going == false) {
			//System.out.println("1");
			FlightDetailsFD.pushCreatedFlightToFile(oneDeparture, oneArrival, 
				dD.getYear(), dD.getMonth(), dD.getDay(), 
				StartHour, StartMin, EndHour, EndMin);
		}
		if(Coming == false) {
			FlightDetailsFD.pushCreatedFlightToFile(twoDeparture, twoArrival, 
					dA.getYear(), dA.getMonth(), dA.getDay(), 
					StartHour, StartMin, EndHour, EndMin);
		}
		
		FlightDetailsFD.getFlightString(FlightTimings.getFlightHourNumber(oneDeparture, oneArrival));
		System.out.println(displayDepartureFlight());
		System.out.println("     Seats Avaliable on this Flight : " + FlightDetailsFD.SeatsAvaliable(d1, dD, EndHour-StartHour) 
							+ "/" + FlightDetailsFD.TotalSeats(EndHour-StartHour));
		//System.out.println("     Price of Ticket : $" + FlightDetailsFD.getTicketPrice(d1, dD, EndHour-StartHour));
		
		FlightDetailsFD.getFlightString(FlightTimings.getFlightHourNumber(twoDeparture, twoArrival));
		System.out.println(displayReturnFlight());
		System.out.println("     Seats Avaliable on this Flight : " + FlightDetailsFD.SeatsAvaliable(d1, dA, EndHour-StartHour) 
							+ "/" + FlightDetailsFD.TotalSeats(EndHour-StartHour));
		System.out.println("     Price of Ticket : $" 
							+ ((FlightDetailsFD.getTicketPrice(d1, dD, EndHour-StartHour) 
									+ FlightDetailsFD.getTicketPrice(d1, dA, EndHour-StartHour)) * 0.75 )
							);
		
		System.out.println("To continue with this flight, enter 'C' ");
		System.out.println("To go to main menu, enter           'M' ");
		System.out.println("To search for a new flight, enter   'F' ");
		String TEMP = one.nextLine();
		
		if(TEMP.toUpperCase().equals("C")) {
			getNewCustomerDetails();
			//System.out.println("|||GOT DATA");
			loadCustomerDetailsToFile();
			//System.out.println("|||SENT DATA");
			//System.out.println(FINALTICKET_TwoWay());
			//System.out.println("|||OUTPUT");
			System.exit(0);
		}else if(TEMP.toUpperCase().equals("M")) {
			MainMenu();
		}else if(TEMP.toUpperCase().equals("F")) {
			lookForFlights();
		}
		
		//--------------------------------------------------------------------------------------------
		/*FlightTime1 = "Flight 1 : " + date1 
		+ "| Departure : " + StartHour + ":" + StartMin 
		+ "| Arrival   : " + EndHour + ":" + EndMin;
		if(numFlightsAvaliable == 2) {
			FlightTime2 = "Flight 2 : " + date1 
			+ "| Departure : " + (StartHour+6) + ":" + StartMin 
			+ "| Arrival   : " + (EndHour+6) + ":" + EndMin;	
		}
		if(numFlightsAvaliable == 1){
			System.out.println("Enter which flight you want to choose :");
			System.out.println("Flight 1 : " + date1 
			+ "| Departure : " + StartHour + ":" + StartMin 
			+ "| Arrival   : " + EndHour + ":" + EndMin + "              (1)");
			System.out.println("Enter for Main Menu                                             (9)");
		}
		if(numFlightsAvaliable == 2){
			System.out.println("Enter which flight you want to choose :");
			System.out.println("Flight 1 : " + date1 
			+ "| Departure : " + StartHour + ":" + StartMin 
			+ "| Arrival   : " + EndHour + ":" + EndMin + "       (1)");
			System.out.println("Flight 2 : " + date1 
			+ "| Departure : " + (StartHour+6) + ":" + StartMin 
			+ "| Arrival   : " + (EndHour+6) + ":" + EndMin + "       (2)");
			System.out.println("Enter for Main Menu                                             (9)");
		}
		FOD = one.nextInt();
		//--------------------------------------------------------------------------------------------
		FlightTime1 = "Flight 3 : " + date2 
		+ "| Departure : " + StartHour + ":" + StartMin 
		+ "| Arrival   : " + EndHour + ":" + EndMin;
		if(numFlightsAvaliable == 2) {
			FlightTime2 = "Flight 4 : " + date2 
			+ "| Departure : " + (StartHour+6) + ":" + StartMin 
			+ "| Arrival   : " + (EndHour+6) + ":" + EndMin;	
		}
		if(numFlightsAvaliable == 1){
			System.out.println("Enter which flight you want to choose :");
			System.out.println("Flight 3 : " + date2 
			+ "| Departure : " + StartHour + ":" + StartMin 
			+ "| Arrival   : " + EndHour + ":" + EndMin + "       (3)");
			System.out.println("Enter for Main Menu                                              (9)");
		}
		if(numFlightsAvaliable == 2){
			System.out.println("Enter which flight you want to choose :");
			System.out.println("Flight 3 : " + date2 
			+ "| Departure : " + StartHour + ":" + StartMin 
			+ "| Arrival   : " + EndHour + ":" + EndMin + "       (3)");
			System.out.println("Flight 4 : " + date2 
			+ "| Departure : " + (StartHour+6) + ":" + StartMin 
			+ "| Arrival   : " + (EndHour+6) + ":" + EndMin + "       (4)");
			System.out.println("Enter for Main Menu                                              (9)");
		}
		FOA = one.nextInt();
		//-----------------------------------------------------------------------------------------
		
		if(FOD == 9 || FOA == 9) {
			MainMenu();
		}*/
		
		
	}

	/*public static String getDateOneWay() {
		Scanner one = new Scanner(System.in);
		String Date = "";
		System.out.println("---------------------------------------------------");
		System.out.println("Enter Date for Departure (MM/DD/YY) ");
		System.out.print("Enter the Year   : ");
		int year = one.nextInt();
		System.out.print("Enter the Month  : ");
		int month = one.nextInt();
		System.out.print("Enter the Day    : ");
		int day = one.nextInt();
		
		dD = new Date(year, month, day);
		
		Date = (dD.getMonth() + "/" + dD.getDay() + "/" + dD.getYear());
		System.out.println("---------------------------------------------------");
		return Date;
	}
	
	public static String getDateSecondWay() {
		Scanner one = new Scanner(System.in);
		String Date = "";
		System.out.println("---------------------------------------------------");
		System.out.println("Enter Date for Return (MM/DD/YY) ");
		System.out.print("Enter the Year   : ");
		int year = one.nextInt();
		System.out.print("Enter the Month  : ");
		int month = one.nextInt();
		System.out.print("Enter the Day    : ");
		int day = one.nextInt();		
		
		dA = new Date(year, month, day);
			
		Date = (dA.getMonth() + "/" + dA.getDay() + "/" + dA.getYear());
		System.out.println("---------------------------------------------------");
		return Date;
	}*/
	
	public static String displayDepartureFlight() throws FileNotFoundException {
		String answer = "";
		int DH = FlightDetailsFD.getDepartureHour(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
		int DM = FlightDetailsFD.getDepartureMin(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
		int AH = FlightDetailsFD.getArrivalHour(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
		int AM = FlightDetailsFD.getArrivalMin(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
		int FID = FlightDetailsFD.getFlightID(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
		answer = "Flight ID : " + FID 
				+ " |" + oneDeparture + " to " + oneArrival
				+ " | Date : " + (dD.getMonth() + "/" + dD.getDay() + "/" + dD.getYear()) 
				+ " | Departure : " + DH + ":" + DM
				+ " | Arrival : " + AH + ":" + AM;
		return answer;
	}
	
	public static String displayReturnFlight() throws FileNotFoundException {
		String answer = "";
		int DH = FlightDetailsFD.getDepartureHour(twoDeparture, twoArrival, dA.getYear(), dA.getMonth(), dA.getDay());
		int DM = FlightDetailsFD.getDepartureMin(twoDeparture, twoArrival, dA.getYear(), dA.getMonth(), dA.getDay());
		int AH = FlightDetailsFD.getArrivalHour(twoDeparture, twoArrival, dA.getYear(), dA.getMonth(), dA.getDay());
		int AM = FlightDetailsFD.getArrivalMin(twoDeparture, twoArrival, dA.getYear(), dA.getMonth(), dA.getDay());
		int FID = FlightDetailsFD.getFlightID(twoDeparture, twoArrival, dA.getYear(), dA.getMonth(), dA.getDay());
		answer = "Flight ID : " + FID 
				+ " |" + twoDeparture + " to " + twoArrival
				+ " | Date : " + (dA.getMonth() + "/" + dA.getDay() + "/" + dA.getYear()) 
				+ " | Departure : " + DH + ":" + DM
				+ " | Arrival : " + AH + ":" + AM;
		return answer;
	}
	
	
	
	//USE THESE METHODS TO GET THE FINAL TICKET
	public static String FINALTICKET_OneWay(String oneDeparture, String oneArrival, Date d1, Date dD) throws FileNotFoundException {
		String answer = "";
		int DH = FlightDetailsFD.getDepartureHour(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
		int DM = FlightDetailsFD.getDepartureMin(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
		int AH = FlightDetailsFD.getArrivalHour(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
		int AM = FlightDetailsFD.getArrivalMin(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
		int FID = FlightDetailsFD.getFlightID(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
		int hours = FlightTimings.getFlightHourNumber(oneDeparture, oneArrival);
		answer  = "----------------------------------------------------------------"              + "\n"
				+ "Flight Route    : " + oneDeparture + " to " + oneArrival                       + "\n"
				+ "Flight ID       : " + FID                                                      + "\n"
				+ "Seat Number     : " +Seating.getSeatChosen()                                   + "\n"
				+ "Departure Date  : " + (dD.getMonth() + "/" + dD.getDay() + "/" + dD.getYear()) + "\n"
				+ "Departure Time  : " + DH + ":" + DM                                            + "\n"
				+ "Arrival Time    : " + AH + ":" + AM                                            + "\n"
				+ "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "              + "\n"
				+ "Price of Seat   : $" + FlightDetailsFD.getTicketPrice(d1, dD, hours)           + "\n"
				+ "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "              + "\n"
				
				;
		
		
		return answer;
	}
	private static void getTicketInfoForOW(String oneDeparture2, String oneArrival2, int fID, int month, int day, int year,
			int dH, int dM, int aH, int aM, String goingSeat) {
		// TODO Auto-generated method stub
		str=new String[3];
		in=new int[8];
		
		str[0]=oneDeparture2;
		str[1]=oneArrival2;
		str[2]=goingSeat;
		in[0]=fID;
		in[1]=month;
		in[2]=day;
		in[3]=year;
		in[4]=dH;
		in[5]=dM;
		in[6]=aH;
		in[7]=aM;
	}

	
	//USE THESE METHODS TO GET THE FINAL TICKET
	public static String FINALTICKET_TwoWay(String oneDeparture, String oneArrival, Date d1, Date dD, Date dA, String twoDeparture, String twoArrival) throws FileNotFoundException {
		String answer = "";
		int DH = FlightDetailsFD.getDepartureHour(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
		int DM = FlightDetailsFD.getDepartureMin(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
		int AH = FlightDetailsFD.getArrivalHour(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
		int AM = FlightDetailsFD.getArrivalMin(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
		int FID = FlightDetailsFD.getFlightID(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
		int hours = FlightTimings.getFlightHourNumber(oneDeparture, oneArrival);
		
		int ADH = FlightDetailsFD.getDepartureHour(twoDeparture, twoArrival, dA.getYear(), dA.getMonth(), dA.getDay());
		int ADM = FlightDetailsFD.getDepartureMin(twoDeparture, twoArrival, dA.getYear(), dA.getMonth(), dA.getDay());
		int AAH = FlightDetailsFD.getArrivalHour(twoDeparture, twoArrival, dA.getYear(), dA.getMonth(), dA.getDay());
		int AAM = FlightDetailsFD.getArrivalMin(twoDeparture, twoArrival, dA.getYear(), dA.getMonth(), dA.getDay());
		int AFID = FlightDetailsFD.getFlightID(twoDeparture, twoArrival, dA.getYear(), dA.getMonth(), dA.getDay());
		int Ahours = FlightTimings.getFlightHourNumber(twoDeparture, twoArrival);
		
		double price = ( (FlightDetailsFD.getTicketPrice(d1, dD, hours) 
						+ FlightDetailsFD.getTicketPrice(d1, dA, Ahours)) 
						* 0.75 );
		String GoingSeat=Reservation.GoingSeat;
		
		String ComingSeat=Reservation.ComingSeat;
		
		answer  = "----------------------------------------------------------------"              + "\n"
				+ "Flight Route    : " + oneDeparture + " to " + oneArrival                       + "\n"
				+ "Flight ID       : " + FID                                                      + "\n"
				+ "Seat Number     : " +GoingSeat                                   + "\n"
				+ "Departure Date  : " + (dD.getMonth() + "/" + dD.getDay() + "/" + dD.getYear()) + "\n"
				+ "Departure Time  : " + DH + ":" + DM                                            + "\n"
				+ "Arrival Time    : " + AH + ":" + AM                                            + "\n"
			//	+ "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "              + "\n"
			//	+ "Price of Seat   : $" + FlightDetailsFD.getTicketPrice(d1, dD, hours)           + "\n"
			//	+ "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "              + "\n"
			//	+ "----------------------------------------------------------------"              + "\n"
				+ "----------------------------------------------------------------"              + "\n"
				+ "Flight Route    : " + twoDeparture + " to " + twoArrival                       + "\n"
				+ "Flight ID       : " + AFID                                                     + "\n"
				+ "Seat Number     : " +ComingSeat                                 + "\n"
				+ "Departure Date  : " + (dA.getMonth() + "/" + dA.getDay() + "/" + dA.getYear()) + "\n"
				+ "Departure Time  : " + ADH + ":" + ADM                                          + "\n"
				+ "Arrival Time    : " + AAH + ":" + AAM                                          + "\n"
				+ "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "              + "\n"
				+ "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "              + "\n"
				+ "Price of Seat   : $" + price                                                   + "\n"
				+ "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "              + "\n"
				
				;
		getTicketInfoForRT(oneDeparture,oneArrival,FID,dD.getMonth(),dD.getDay(),dD.getYear(),DH,DM,AH,AM,twoDeparture,twoArrival,AFID,dA.getMonth(),dA.getDay(),dA.getYear(),ADH,ADM,AAH,AAM,GoingSeat,ComingSeat);
		
		return answer;
	}

	private static void getTicketInfoForRT(String oneDeparture2, String oneArrival2, int fID, int month, int day,
			int year, int dH, int dM, int aH, int aM, String twoDeparture2, String twoArrival2, int aFID, int month2,
			int day2, int year2, int aDH, int aDM, int aAH, int aAM, String goingSeat, String comingSeat) {
		// TODO Auto-generated method stub
		str=new String[6];
		in=new int[16];
		
		str[0]=oneDeparture2;
		str[1]=oneArrival2;
		str[2]=twoArrival2;
		str[3]=twoArrival2;
		str[4]=goingSeat;
		str[5]=comingSeat;
		in[0]=fID;
		in[1]=month;
		in[2]=day;
		in[3]=year;
		in[4]=dH;
		in[5]=dM;
		in[6]=aH;
		in[7]=aM;
		in[8]=aFID;
		in[9]=month2;
		in[10]=day2;
		in[11]=year2;
		in[12]=aDH;
		in[13]=aDM;
		in[14]=aAH;
		in[15]=aAM;
		
	}
	
	
public static String FINALTICKET_OneWay(String oneDeparture, String oneArrival, Date d1, Date dD, String GoingSeat) throws FileNotFoundException {
	String answer = "";
	int DH = FlightDetailsFD.getDepartureHour(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
	int DM = FlightDetailsFD.getDepartureMin(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
	int AH = FlightDetailsFD.getArrivalHour(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
	int AM = FlightDetailsFD.getArrivalMin(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
	int FID = FlightDetailsFD.getFlightID(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
	int hours = FlightTimings.getFlightHourNumber(oneDeparture, oneArrival);
	answer  = "----------------------------------------------------------------"              + "\n"
			+ "Flight Route    : " + oneDeparture + " to " + oneArrival                       + "\n"
			+ "Flight ID       : " + FID                                                      + "\n"
			+ "Departure Date  : " + (dD.getDay() + "/" + dD.getMonth() + "/" + dD.getYear()) + "\n"
			+ "Departure Time  : " + DH + ":" + DM                                            + "\n"
			+ "Arrival Time    : " + AH + ":" + AM                                            + "\n"
			+ "Seat Number     : " + GoingSeat                                                + "\n"
			+ "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "              + "\n"
			+ "Price of Seat   : $" + FlightDetailsFD.getTicketPrice(d1, dD, hours)           + "\n"
			+ "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "              + "\n"
			+ "----------------------------------------------------------------"
			;
	getTicketInfoForOW(oneDeparture,oneArrival,FID,dD.getMonth(),dD.getDay(),dD.getYear(),DH,DM,AH,AM,GoingSeat);
	return answer;
}


public static String FINALTICKET_TwoWay(String oneDeparture, String oneArrival, Date d1, Date dD, Date dA, String twoDeparture, String twoArrival, String GoingSeat, String ComingSeat) throws FileNotFoundException {
	String answer = "";
	int DH = FlightDetailsFD.getDepartureHour(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
	int DM = FlightDetailsFD.getDepartureMin(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
	int AH = FlightDetailsFD.getArrivalHour(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
	int AM = FlightDetailsFD.getArrivalMin(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
	int FID = FlightDetailsFD.getFlightID(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
	int hours = FlightTimings.getFlightHourNumber(oneDeparture, oneArrival);
	
	int ADH = FlightDetailsFD.getDepartureHour(twoDeparture, twoArrival, dA.getYear(), dA.getMonth(), dA.getDay());
	int ADM = FlightDetailsFD.getDepartureMin(twoDeparture, twoArrival, dA.getYear(), dA.getMonth(), dA.getDay());
	int AAH = FlightDetailsFD.getArrivalHour(twoDeparture, twoArrival, dA.getYear(), dA.getMonth(), dA.getDay());
	int AAM = FlightDetailsFD.getArrivalMin(twoDeparture, twoArrival, dA.getYear(), dA.getMonth(), dA.getDay());
	int AFID = FlightDetailsFD.getFlightID(twoDeparture, twoArrival, dA.getYear(), dA.getMonth(), dA.getDay());
	int Ahours = FlightTimings.getFlightHourNumber(twoDeparture, twoArrival);
	
	double price = ( (FlightDetailsFD.getTicketPrice(d1, dD, hours) 
					+ FlightDetailsFD.getTicketPrice(d1, dA, Ahours)) 
					* 0.75 );
	
	answer  = "----------------------------------------------------------------"              + "\n"
			+ "Flight Route    : " + oneDeparture + " to " + oneArrival                       + "\n"
			+ "Flight ID       : " + FID                                                      + "\n"
			+ "Departure Date  : " + (dD.getDay() + "/" + dD.getMonth() + "/" + dD.getYear()) + "\n"
			+ "Departure Time  : " + DH + ":" + DM                                            + "\n"
			+ "Arrival Time    : " + AH + ":" + AM                                            + "\n"
			+ "Seat Number     : " + GoingSeat                                                + "\n"
		//	+ "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "              + "\n"
		//	+ "Price of Seat   : $" + FlightDetailsFD.getTicketPrice(d1, dD, hours)           + "\n"
		//	+ "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "              + "\n"
		//	+ "----------------------------------------------------------------"              + "\n"
			+ "----------------------------------------------------------------"              + "\n"
			+ "Flight Route    : " + twoDeparture + " to " + twoArrival                       + "\n"
			+ "Flight ID       : " + AFID                                                     + "\n"
			+ "Departure Date  : " + (dA.getDay() + "/" + dA.getMonth() + "/" + dA.getYear()) + "\n"
			+ "Departure Time  : " + ADH + ":" + ADM                                          + "\n"
			+ "Arrival Time    : " + AAH + ":" + AAM                                          + "\n"
			+ "Seat Number     : " + ComingSeat                                               + "\n"
			+ "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "              + "\n"
			+ "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "              + "\n"
			+ "Price of Seat   : $" + price                                                   + "\n"
			+ "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "              + "\n"
			+ "----------------------------------------------------------------"
			;
	getTicketInfoForRT(oneDeparture,oneArrival,FID,dD.getMonth(),dD.getDay(),dD.getYear(),DH,DM,AH,AM,twoDeparture,twoArrival,AFID,dA.getMonth(),dA.getDay(),dA.getYear(),ADH,ADM,AAH,AAM, Seating.SeatChosen, ComingSeat);
	return answer;
}}
