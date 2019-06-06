package groupProjectFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FlightTimings {
	
	public static String fileLocationAirportCODES = "D:\\Eclipse\\PracticeWork\\src\\groupProjectFiles\\AirportCodesGraph.csv";
	public static String fileLocationAllAirportsList = "D:\\Eclipse\\PracticeWork\\src\\groupProjectFiles\\AirportNamesState.csv";
	static ArrayList<String> day = new ArrayList<String>();
	static ArrayList<Integer> DepartureTime = new ArrayList<Integer>();
	static ArrayList<Integer> ArrivalTime = new ArrayList<Integer>();
	
	static ArrayList<ArrayList<String>> Codes = new ArrayList<ArrayList<String>>(9);
	static ArrayList<ArrayList<String>> Airports = new ArrayList<ArrayList<String>>(9);
	
	static int flightHours;
	static int flightMins;

	public static void readAirportCodesGraphFile() throws FileNotFoundException {
		//THIS METHOD SHOULD ONLY BE CALLED ONCE AND SHOULD BE RUN AT THE START OF THE ENTIRE PROGRAM. 
		//String fileLocation = "..\\CSC201_INCLASS\\src\\groupProjectFiles\\AirportCodesGraph.csv";//\\\\
		File f = new File(fileLocationAirportCODES);
		Scanner FI = new Scanner(f);
		
		String[] str;
		int count = 0;
		
		while(FI.hasNextLine()) {
			str = FI.nextLine().split(",");
			
			Codes.add(new ArrayList());
			Codes.get(count).add(str[0]);
			Codes.get(count).add(str[1]);
			Codes.get(count).add(str[2]);
			Codes.get(count).add(str[3]);
			Codes.get(count).add(str[4]);
			Codes.get(count).add(str[5]);
			Codes.get(count).add(str[6]);
			Codes.get(count).add(str[7]);
			Codes.get(count).add(str[8]);
			
			count++;
			
			//day.add(str[0]);
			//DepartureTime.add(Integer.parseInt(str[1]));
		}
		
		//System.out.println(Codes.get(3).get(7));
		
	}
	
	public static String getAirports() throws FileNotFoundException {
		String FO = "";
		
		//String fileLocation = "..\\CSC201_INCLASS\\src\\groupProjectFiles\\AirportNamesState.csv";//\\CSC201_INCLASS\\src\\
		File f = new File(fileLocationAllAirportsList);
		Scanner FI = new Scanner(f);
		
		String[] str;
		int count = 0;
		
		while(FI.hasNextLine()) {
			str = FI.nextLine().split(",");
			
			Airports.add(new ArrayList());
			Airports.get(count).add(str[0]);
			Airports.get(count).add(str[1]);
			Airports.get(count).add(str[2]);
			
			FO += Airports.get(count).get(0) + "   " + Airports.get(count).get(1) + "   " + Airports.get(count).get(2) + "\n";
			
			count++;
		}
		
		return FO;
	}
	
	public static String getHours(String D, String A) throws FileNotFoundException {
		
		String FO = "";
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;
		
		int height;
		int width;
		
		for(int y = 0; y < Codes.size(); y++) {
			for(int x = 0; x < Codes.get(y).size(); x++) {
				if(D.equals(Codes.get(y).get(x))) {
					y1 = y;
					x1 = x;
				}
				if(A.equals(Codes.get(y).get(x))) {
					y2 = y;
					x2 = x;
				}
			}
		}
		
		if((y2 - y1) == 0) {
			height = 1;
		}else {
			height = (y2 - y1);		Math.abs(height);
		}
		if((x2 - x1) == 0) {
			width = 1;
		}else {
			width = (x2 - x1);		Math.abs(width);
		}
		
		double finalHours = Math.sqrt( Math.pow(height, 2) + Math.pow(width, 2) );
		
		double seconds = finalHours * 360;

		int t = (int) ( 100 * finalHours);
		int hour = (int) finalHours/1;
		finalHours = finalHours - hour;
		int min = (int) (finalHours * 60);
		finalHours = finalHours - (min/60);
		int sec = t;
		
		FO =  hour + " hours and " + min + " minutes";
		//System.out.println("Flight Duration : " + FO);
		
		flightHours = hour;
		flightMins  = min;
		
		return FO;
	}
	
	
	//USE THIS METHOD TO GET THE NUMBER OF HOURS IN THE DURATION OF THE FLIGHT 
	//THIS METHOD DOES NOT INCLUDE THE MINUTES AFTER THE HOUR, NEED TO BOTH METHODS IF YOU WANT HOUR:MIN FORMAT
	public static int getFlightHourNumber(String D, String A) throws FileNotFoundException {
		getHours(D, A);
		return flightHours;
	}
	
	//USE THIS METHOD TO GET THE NUMBER OF MINUTES IN THE DURATION OF THE FLIGHT
	//THIS RETURNS THE MINUTES = (TOTAL TIME - HOUR)
	public static int getFlightMinNumber(String D, String A) throws FileNotFoundException {
		getHours(D, A);
		return flightMins;
	}

}
