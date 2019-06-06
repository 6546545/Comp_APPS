package groupProjectFiles;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import groupProjectFiles.Date;

public class Seating {
	
	public static String SeatChosen = "";
	public static int Counter = 0;
	
	public static int FileNumRows = 0;
	
	public static int SeatsEmpty = 0;
	public static int SeatsUsed = 0;
	public static int FlightNumIndex = 0;
	public static String FlightSeatingChartFile = "D:\\Eclipse\\PracticeWork\\src\\groupProjectFiles\\FlightSeatingChartFile.csv";
	
	static JTextField textfield1, textfield2, textfield3;
	
	//public static void main(String[] args) throws FileNotFoundException {
		//ChooseSeat(121676,75);
		//ChooseSeat(109127,75);
	//}
	
	
	//***********************************************************************
	// THE ORDER OF HOW THE METHODS SHOULD BE CALLED
	//   1) pushSeatsListToFile - IF THERE NEEDS TO BE A NEW FLIGHT CREATED
	//   2) ChooseSeat          - LET THE USER CHOOSE THEIR SEAT
	//   3) getSeatChosen       - HAS TO BE CALLED AFTER ChooseSeat
	//   4) UpdateFIle          - TO UPDATE
	//***********************************************************************
	
	
	
	//THIS METHOD IS CALLED IF THE SEATING CHART IS IN THE GRAPH AND...
	//THIS METHOD ALLOWS THE USER TO CHOODE THEIR SEAT. 
	//THIS IS A GUI
	public static void ChooseSeat(int FlightNumber, int TotalSeats) throws FileNotFoundException {
		System.out.println(FlightNumber);
		SeatChosen="";
		ArrayList<JLabel> SFilled = new ArrayList<>();
		ArrayList<JButton> SEmpty  = new ArrayList<>();
		
		
		File file = new File(FlightSeatingChartFile);
		Scanner FI = new Scanner(file);
		String[] str;
		boolean FlightMatch = false;
		ArrayList<Boolean> SeatsInFlight = new ArrayList<>();
		ArrayList<Boolean> EF = new ArrayList<>(); //TRUE MEANS IT IS EMPTY, FALSE MEANS IT IS FILLED
		//ArrayList<Integer> FNum = new ArrayList<>();
		
		while(FI.hasNextLine()) {
			str = FI.nextLine().split(",");
			FileNumRows++;
			System.out.println(Integer.parseInt(str[0]));
			if(FlightNumber == Integer.parseInt(str[0]) ) {
				FlightMatch = true;
				
				for(int i = 1; i <= TotalSeats; i++) {
					SeatsInFlight.add(Boolean.parseBoolean(str[i]));
				}
				
				break;
			}
		}
		for(int i = 0; i < SeatsInFlight.size(); i++) {
			String abc = "";
			if(SeatsInFlight.get(i) == true) {
				abc = "avaliable";
				EF.add(true);
				SEmpty.add( new JButton("S" + (i+1)) ); 
			}else {
				abc = "taken";
				EF.add(false);
				SFilled.add(new JLabel("     S" + (i+1) + " Filled") );
			}
				
		}
		
		int rows = 5;
		int columns = 15;
		
		if(TotalSeats == 75) {
			rows = 15;
			columns = 5;
		}else {
			rows = 20;
			columns = 5;
		}
		
		JFrame f = new JFrame("Choose your Flight Seat");
	    f.setVisible(true);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setSize(500,700);
	    JPanel p = new JPanel();
	    
	    p.setLayout(new GridLayout(rows+1, (columns), 1, 1));
	   
	    p.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	    
	    int ECount = 0;
	    int FCount = 0;
	    
	    for(int i = 0; i < EF.size(); i++) {
	    	if(EF.get(i) == true) {
	    		SEmpty.get(ECount).setOpaque(true);
		    	SEmpty.get(ECount).setBackground(Color.GREEN);
		    	p.add(SEmpty.get(ECount));
		    	ECount++;
	    	}else if(EF.get(i) == false) {
	    		SFilled.get(FCount).setOpaque(true);
		    	SFilled.get(FCount).setBackground(Color.RED);
		    	p.add(SFilled.get(FCount));
		    	FCount++;
	    	}
	    }
	    
	    
	    /*for(int i = 0; i < SEmpty.size(); i++) {
	    	SEmpty.get(i).setOpaque(true);
	    	SEmpty.get(i).setBackground(Color.GREEN);
	    	p.add(SEmpty.get(i));
	    }
	    for(int i = 0; i < SFilled.size(); i++) {
	    	SFilled.get(i).setOpaque(true);
	    	SFilled.get(i).setBackground(Color.RED);
	    	p.add(SFilled.get(i));
	    }*/
	    
	    f.add(p);
	    f.toFront();
	    
	    for(Counter = 0; Counter < SEmpty.size(); Counter++) {
	        SEmpty.get(Counter).addActionListener(new ActionListener() {
	    	   public void actionPerformed(ActionEvent e){   
	    		  SeatChosen =  ((AbstractButton) e.getSource()).getText();
		    	  //SeatChosen = SEmpty.get(Counter).getText();
	    		  System.out.println(SeatChosen);
		    	  Counter = -1;
		    	  f.setVisible(false);
		    	  //System.out.println("S" + Counter);
		       }
		    });
		    
		    if(Counter == -1) {
		    	//f.setVisible(false);
		    	break;
		    }
	    }
	    Counter = 0;
	    
	}
	
	//THIS METHOD HAS TO BE CALLED RIGHT AFTER OBTAINING THE SEAT NUMBER
	//THIS HAS BE TO STORED IN ANOTHER VARIABLE 
	public static String getSeatChosen() {
		return SeatChosen;
	}
	
	
	//AFTER THE USER CHOOSES THE SEAT, THIS METHOD NEEDS TO BE CALLED TO UPDATE THE SEATING CHART.
	public static void UpdateFile(int FlightNumber, String SeatNumber) throws IOException {
		String answer = "";
		
		File f = new File(FlightSeatingChartFile);
		Scanner FI = new Scanner(f);
		File f2 = new File(FlightSeatingChartFile);
		Scanner FI2 = new Scanner(f2);
		String[] str;
		String[] str2;
		ArrayList<String> SeatsInFlight = new ArrayList<>();
	
	    String SNum = SeatNumber.substring(0, 0) + SeatNumber.substring(0 + 1);
	    		//SeatNumber.substring(-1, SeatNumber.length());
	    int SeatNum = Integer.parseInt(SNum);
		boolean updated = false;
		while(FI.hasNextLine()) {
			str = FI.nextLine().split(",");
		/*	if(updated == true) {
				answer += "\n";
				updated = false;
			} */
			//System.out.println(FileNumRows);
			FileNumRows--;
			System.out.println(FileNumRows);
			System.out.println(FlightNumber +  " " + str[0]);
			int abcd = Integer.parseInt(str[0]);
			if(FlightNumber != abcd ) {
				for(int i = 0; i < str.length; i++) {
					answer += str[i] + ",";
				}
				answer += "\n";
			}/*else {
				str[SeatNum] = "false";
				for(int i = 0; i < str.length; i++) {
					answer += str[i];
					
					if(i != (str.length-1)) {
						answer += ",";
					}
				}
				updated = true;
			}*/
		}
		
		while(FI2.hasNextLine()) {
			str2 = FI2.nextLine().split(",");
			int abcd = Integer.parseInt(str2[0]);
			if(FlightNumber == abcd ) {
				str2[SeatNum] = "false";
				for(int i = 0; i < str2.length; i++) {
					answer += str2[i];					
					if(i != (str2.length-1)) {
						answer += ",";
					}
				}
				break;
			}
		}
		
		FileWriter fw = new FileWriter(FlightSeatingChartFile);
		PrintWriter pw = new PrintWriter(fw);
		
		pw.println(answer);
		pw.close();
	}
	
	/*public static String getChange(int FlightNumber, String SeatNumber) {
		String answer = "";
		File f2 = new File(FlightSeatingChartFile);
		Scanner FI2 = new Scanner(f2);
		String[] str2;
		String SNum = SeatNumber.substring(0, 0) + SeatNumber.substring(0 + 1);
		int SeatNum = Integer.parseInt(SNum);
		while(FI2.hasNextLine()) {
			str2 = FI2.nextLine().split(",");
			int abcd = Integer.parseInt(str2[0]);
			if(FlightNumber == abcd ) {
				str2[SeatNum] = "false";
				for(int i = 0; i < str2.length; i++) {
					answer += str2[i];					
					if(i != (str2.length-1)) {
						answer += ",";
					}
				}
				break;
			}
		}
		return answer;
	}*/
	
	
	//THIS METHOD DOES NOT NEED TO BE USED
	public static String getSeatsEmpty(int FlightNumber, int TotalSeats) throws FileNotFoundException {
		String answer = "";
		
		File f = new File(FlightSeatingChartFile);
		Scanner FI = new Scanner(f);
		String[] str;
		boolean FlightMatch = false;
		ArrayList<Boolean> SeatsInFlight = new ArrayList<>();
		//ArrayList<Integer> FNum = new ArrayList<>();
		
		while(FI.hasNextLine()) {
			str = FI.nextLine().split(",");
			if(FlightNumber == Integer.parseInt(str[0]) ) {
				FlightMatch = true;
				
				for(int i = 1; i <= TotalSeats; i++) {
					SeatsInFlight.add(Boolean.parseBoolean(str[i]));
				}
				
				break;
			}
		}
		for(int i = 0; i < SeatsInFlight.size(); i++) {
			String abc = "";
			if(SeatsInFlight.get(i) == true) {
				abc = "avaliable";
			}else {
				abc = "taken";
			}
			
			answer += "Seat : S " + (i+1)  + " is " + abc + "\n";
		}
		return answer;
	}
	
	//IF THERE IS ALREADY AN INSTANCE OF THE FLIGHT IN FILE, THEN THIS DOES NOT NEED TO BE CALLED. 
	//THIS IS CALLED IF A NEW FLIGHT IS CREATED.
	public static void pushSeatsListToFile(int FlightNumber, int TotalSeats, int SeatsEmpty) throws IOException {
		String Answer = FlightNumber + ",";
		FileWriter fw = new FileWriter(FlightSeatingChartFile, true);
		PrintWriter pw = new PrintWriter(fw);
		for(int i = 0; i < SeatsEmpty; i++) {
			Answer += "true,";
		}
		for(int i = 0; i < (TotalSeats - SeatsEmpty); i++) {
			Answer += "false,";
		}
		if(TotalSeats != 100) {
			for(int i = 0; i < (25); i++) {
				Answer += "false,";
			}
		}
		pw.println(Answer);
		pw.close();
	}
	
	
	
	public static String getSeatDepartureFlight(Date Current, Date Departure, String DepartureAirport, String ArrivalAirport) throws FileNotFoundException {
		
		String answer = "";
		
		int hours = FlightTimings.getFlightHourNumber(DepartureAirport, ArrivalAirport);
		
		int SA = FlightDetailsFD.SeatsAvaliable(Current, Departure, hours);
		int TS = FlightDetailsFD.TotalSeats(hours);
		
		int SF = TS - SA;
		ArrayList<Boolean> SeatsAvalibility = new ArrayList<>();
		
		for(int i = 0; i < (SF); i++) {
			SeatsAvalibility.add(false);
		}
		
		for(int i = 0; i < SA; i++) {
			SeatsAvalibility.add(true);
		}
		
		for(int i = 0; i < TS; i++) {
			String TEMP = "";
			if(SeatsAvalibility.get(i) == true) {
				TEMP = "Avaliable";
			}else if(SeatsAvalibility.get(i) == false) {
				TEMP = "Unavaliable";
			}
			answer += "SA " + (i+1) + " is " + TEMP + "\n";
		}
		
		return answer;
		
	}
	
	public static String getSeatArrivalFlight(Date Current, Date Arrival, String DepartureAirport, String ArrivalAirport) throws FileNotFoundException {
		
		String answer = "";
		
		int hours = FlightTimings.getFlightHourNumber(DepartureAirport, ArrivalAirport);
		
		int SA = FlightDetailsFD.SeatsAvaliable(Current, Arrival, hours);
		int TS = FlightDetailsFD.TotalSeats(hours);
		
		int SF = TS - SA;
		ArrayList<Boolean> SeatsAvalibility = new ArrayList<>();
		
		for(int i = 0; i < (SF); i++) {
			SeatsAvalibility.add(false);
		}
		
		for(int i = 0; i < SA; i++) {
			SeatsAvalibility.add(true);
		}
		
		for(int i = 0; i < TS; i++) {
			String TEMP = "";
			if(SeatsAvalibility.get(i) == true) {
				TEMP = "Avaliable";
			}else if(SeatsAvalibility.get(i) == false) {
				TEMP = "Unavaliable";
			}
			answer += "SA " + (i+1) + " is " + TEMP + "\n";
		}
		
		return answer;
		
	}
	
	
	
}
