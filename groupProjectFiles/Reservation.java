package groupProjectFiles;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Reservation extends Application {
	public static boolean returnFlight=false;
	public static String FinalTicket="";
	public static Image fT;
	public static RadioButton rt;
	public static RadioButton ow;
	public static ToggleGroup radioGroup;
	public static RadioButton selectedRadioButton;	
	public static TextField td;
	public static TextField tdMonth;
	public static TextField tdYr;	
	public static TextField dd;
	public static TextField ddMonth;
	public static TextField ddYr;
	public static TextField ad;
	public static TextField adMonth;
	public static TextField adYr;
	public static Date todD;
	public static Date DepD;
	public static String[] str2;
	public static int[] in2;
	public static String temp;
	public static ComboBox<String> dF ;//Departing airport
	public static ComboBox<String> cF;//Arriving Airport
	public static ArrayList<String> AirportsNames;
	public static ArrayList<String> AN;
	public static String GoingSeat;
	public static String ComingSeat; 
	
	public static void main(String[] args) {
		try {
			FlightTimings.readAirportCodesGraphFile();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		try {
			fT = new Image(new FileInputStream("D:\\Eclipse\\PracticeWork\\src\\groupProjectFiles\\a0_asx8X.jpg"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	      Label title= new Label("Welcome to MAD Airlines!");
	      title.setFont(Font.font("Verdana",FontWeight.BOLD, 30));
	      title.setTextFill(Color.PURPLE);
	      title.setLayoutX(45);;
		  //Setting the image view 
	      ImageView imageView = new ImageView(fT); 
	      
	      //Setting the position of the image 
	      imageView.setX(0); 
	      imageView.setY(0); 
	      
	      //setting the fit height and width of the image view 
	      imageView.setFitHeight(512); 
	      imageView.setFitWidth(512); 
	      
	      //Setting the preserve ratio of the image view 
	      imageView.setPreserveRatio(true);  
		
		Button start=new Button();
		Button quit=new Button();
		
		start.setText("Start");
		start.setLayoutX(256);
		start.setLayoutY(128);
		
        start.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
            	mainMenu(primaryStage);               
            }
        });
		
		quit.setText("Quit");
		quit.setLayoutX(256);
		quit.setLayoutY(188);
        quit.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
 
              System.exit(0);               
            }
        });
		
        Pane pane= new Pane();
		  pane.getChildren().add(imageView);
		  pane.getChildren().addAll(start,quit,title);
		     
		     
		  //Creating a scene object 
		  Scene scene = new Scene(pane, 512, 512);  
		
		
		primaryStage.setTitle("MAD Airlines");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	public void mainMenu(Stage primaryStage) {
		Button searchButton=new Button();
		Button lookUp=new Button();
		Label topLabel=new Label("Welcome! Please select an option from below:");
		searchButton.setText("Search For Availible Flights");
		
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
            	searchFlights(primaryStage);                
            }
        });
		
		lookUp.setText("Look up Cutomer Details");
        lookUp.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
 
              lookUp(primaryStage);               
            }
        });
		
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10,10,10,10));
		GridPane center=new GridPane();
		center.setVgap(5);
		center.setHgap(5);
		center.add(topLabel, 0, 0);
		center.add(lookUp, 0, 1);
		center.add(searchButton, 0, 3);
		
		root.setCenter(center);
		//Create Scene
		Scene scene = new Scene(root,360,310);
		
		primaryStage.setTitle("Reservation");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	protected void searchFlights(Stage primaryStage) {
		// TODO Auto-generated method stub
		BorderPane root1 = new BorderPane();
		root1.setPadding(new Insets(10,10,10,10));
		GridPane center=new GridPane();
		Label instructions=new Label("Please select a departure and a destination airport.");
		Label to=new Label("Departing From:");
		Label destination= new Label("Arriving at:");
		Label placehold= new Label("");
		Label aP=new Label();
		
		ObservableList<String> options =FXCollections.observableArrayList();
		
		final ComboBox<String> dF = new ComboBox<String>(options);
		final ComboBox<String> cF = new ComboBox<String>(options);
		ArrayList<String> AirportNames= new ArrayList<String>();
		ArrayList<String> Codes = new ArrayList<String>();
		
		rt = new RadioButton("Roundtrip");
		ow = new RadioButton("One Way");
		ToggleGroup radioGroup = new ToggleGroup();
		
		rt.setToggleGroup(radioGroup);
		ow.setToggleGroup(radioGroup);
		
		
		
		
		
		Label todayLabel=new Label("Today's Date (MM/DD/YYYY):");
		Label dDLabel=new Label("Departure Date (MM/DD/YYYY):");
		Label aDLabel=new Label("Arrival Date (MM/DD/YYYY):");
		
		TextField td=new TextField();
		TextField tdMonth=new TextField();
		TextField tdYr=new TextField();
		
		TextField dd=new TextField();
		TextField ddMonth=new TextField();
		TextField ddYr=new TextField();
		TextField ad=new TextField();
		TextField adMonth=new TextField();
		TextField adYr=new TextField();
		Button srchbtn=new Button("Search!");
		
		
		
		try {
			aP.setText(FlightTimings.getAirports());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			getAirports(Codes,AirportNames);
			//System.out.print(AirportNames);
			Codes.remove(0);
			AirportNames.set(1, "0");
			AirportNames.set(2,"0");
			//System.out.println(AirportNames);
			for(int i=0;i<AirportNames.size();i++) {
				
				if(i%3==0) {
					
					AirportNames.set(i, "0");
				
				}
				
			}
			
			for(int j=0; j<AirportNames.size();j++) {
				if(AirportNames.get(j)=="0") {
					AirportNames.remove(j);
				}
			}
			AirportNames.remove(0);
			AirportNames.remove(0);
			//System.out.println(AirportNames);
			for(int i=0;i<Codes.size();i++) {
				dF.getItems().addAll(
						Codes.get(i)
						);
				
			}
			//System.out.println(cF.getItems());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
				
		}
		
		td.setMaxSize(40, 10);
		tdMonth.setMaxSize(40, 10);
		tdYr.setMaxSize(60,10);
		dd.setMaxSize(40, 10);
		ddMonth.setMaxSize(40, 10);
		ddYr.setMaxSize(60, 10);
		
		//rt.addActionListener()
		
		rt.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ad.setMaxSize(40, 10);
				adMonth.setMaxSize(40, 10);
				adYr.setMaxSize(60, 10);
				center.add(aDLabel, 0, 7);
				center.add(ad, 2, 7);
				center.add(adMonth, 3, 7);
				center.add(adYr, 4, 7);
				returnFlight=true;
			}
			
		});
		
		center.add(instructions, 0, 0);
		center.add(placehold, 0, 1);
		center.add(to, 0, 2);
		center.add(dF, 1,2 );
		center.add(cF, 1, 3);
		center.add(destination, 0, 3);
		center.add(rt, 1, 4);
		center.add(ow, 0, 4);
		center.add(todayLabel, 0, 5);
		center.add(td, 2, 5);
		center.add(tdMonth, 3, 5);
		center.add(tdYr, 4, 5);
		center.add(dDLabel, 0, 6);
		center.add(dd, 2, 6);
		center.add(ddMonth, 3, 6);
		center.add(ddYr, 4, 6);
		
		center.add(srchbtn, 0,9);
		
		
		
		srchbtn.setOnAction(new EventHandler<ActionEvent>() {
			

			@Override
			public void handle(ActionEvent arg0) {
				
				
				
				Date todD=new Date(Integer.parseInt(tdYr.getText()),Integer.parseInt(tdMonth.getText()),Integer.parseInt(td.getText()));
				Date DepD=new Date(Integer.parseInt(ddYr.getText()),Integer.parseInt(ddMonth.getText()),Integer.parseInt(dd.getText()));
				
				
				
				
				if(returnFlight==false) {
					int numFlightsAvaliable=0;
					String date1 = "";
					String date2 = "";
					try {
						if(FlightTimings.getFlightHourNumber(dF.getValue(),cF.getValue()) > 4) {
								numFlightsAvaliable = 1;
								//date1 = LoadPassengerData.getDateOneWay();;
						}else {
							numFlightsAvaliable = 2;
							//date1 = LoadPassengerData.getDateOneWay();;
						}
						
						
					   
					    double h = (Math.random() * 5 ) + 7 ;
						int StartHour = (int) h;
						double m = (Math.random() * 60 );
						int StartMin = (int) m;
						
						int EndHour = StartHour + FlightTimings.getFlightHourNumber(dF.getValue(),cF.getValue());
						int EndMin  = StartMin + FlightTimings.getFlightHourNumber(dF.getValue(),cF.getValue());
						
						if(EndMin > 59) {
							EndMin -= 60;
							EndHour++;
						}
						// TODO Auto-generated method stub
						boolean abc = FlightDetailsFD.checkForExitingFlights(dF.getValue(),cF.getValue(), Integer.parseInt(ddYr.getText()), Integer.parseInt(ddMonth.getText()), Integer.parseInt(dd.getText()));
						GoingSeat="";
						//System.out.println(abc);
						
						if(abc == false) {
							//System.out.println("1");
							FlightDetailsFD.pushCreatedFlightToFile(dF.getValue(), cF.getValue(), 
									Integer.parseInt(ddYr.getText()), Integer.parseInt(ddMonth.getText()), Integer.parseInt(dd.getText()), 
									StartHour, StartMin, EndHour, EndMin);
							Seating.pushSeatsListToFile(FlightDetailsFD.getFlightID(dF.getValue(), cF.getValue(), Integer.parseInt(ddYr.getText()), Integer.parseInt(ddMonth.getText()), Integer.parseInt(dd.getText())), 
									FlightDetailsFD.TotalSeats( FlightTimings.getFlightHourNumber(dF.getValue(), cF.getValue()) ), 
									FlightDetailsFD.SeatsAvaliable(todD, DepD,  FlightTimings.getFlightHourNumber(dF.getValue(), cF.getValue())));
							
							
						}
						Seating.ChooseSeat(FlightDetailsFD.getFlightID(dF.getValue(), cF.getValue(), Integer.parseInt(ddYr.getText()), Integer.parseInt(ddMonth.getText()), Integer.parseInt(dd.getText())), FlightDetailsFD.TotalSeats(FlightTimings.getFlightHourNumber(dF.getValue(), cF.getValue())));
						
						
						String asdf = Seating.getSeatChosen();
						
						while(asdf.isEmpty()) {
							System.out.print(".");
							asdf = Seating.getSeatChosen();
							//wait(5000);
							if(!asdf.isEmpty()) {
								//System.out.println("end loop");
								break;
							}
						}
						asdf = "";
						
						//System.out.println("Type Ticket : ");	String asdfaassdf = one.next();
						
						GoingSeat = Seating.getSeatChosen();
						
						
						
						if(!GoingSeat.isEmpty()) {
							FinalTicket=LoadPassengerData.FINALTICKET_OneWay(dF.getValue(), cF.getValue(), todD,DepD, GoingSeat);
							System.out.print(FinalTicket);
							
						}					
					}catch(IOException e) {
						e.printStackTrace();
					}
				}else {
					Date ArrD=new Date(Integer.parseInt(adYr.getText()),Integer.parseInt(adMonth.getText()),Integer.parseInt(ad.getText()));
					int numFlightsAvaliable=0;
					String date1 = "";
					String date2 = "";
					try {
						if(FlightTimings.getFlightHourNumber(dF.getValue(),cF.getValue()) > 4) {
								numFlightsAvaliable = 1;
								//date1 = LoadPassengerData.getDateOneWay();;
						}else {
							numFlightsAvaliable = 2;
							//date1 = LoadPassengerData.getDateOneWay();;
						}
						
						
						double h = (Math.random() * 5 ) + 7 ;
						int StartHour = (int) h;
						double m = (Math.random() * 60 );
						int StartMin = (int) m;
						
						int EndHour = StartHour + FlightTimings.getFlightHourNumber(dF.getValue(),cF.getValue());
						int EndMin  = StartMin + FlightTimings.getFlightHourNumber(dF.getValue(),cF.getValue());
						
						if(EndMin > 59) {
							EndMin -= 60;
							EndHour++;
						}
						// TODO Auto-generated method stub
						//boolean abc = FlightDetailsFD.checkForExitingFlights(dF.getValue(),cF.getValue(), Integer.parseInt(ddYr.getText()), Integer.parseInt(ddMonth.getText()), Integer.parseInt(dd.getText()));
						
						//System.out.println(abc);
						boolean Going  = FlightDetailsFD.checkForExitingFlights(dF.getValue(),cF.getValue(), Integer.parseInt(ddYr.getText()), Integer.parseInt(ddMonth.getText()), Integer.parseInt(dd.getText()));
						boolean Coming = FlightDetailsFD.checkForExitingFlights(cF.getValue(),dF.getValue(), Integer.parseInt(ddYr.getText()), Integer.parseInt(ddMonth.getText()), Integer.parseInt(dd.getText()));
						//System.out.println(Going + " " + Coming);
						
						if(Going == false) {
							//System.out.println("1");
							FlightDetailsFD.pushCreatedFlightToFile(dF.getValue(),cF.getValue(), Integer.parseInt(ddYr.getText()), Integer.parseInt(ddMonth.getText()), Integer.parseInt(dd.getText()),
									StartHour, StartMin, EndHour, EndMin);
							Seating.pushSeatsListToFile(FlightDetailsFD.getFlightID(dF.getValue(),cF.getValue(), Integer.parseInt(ddYr.getText()), Integer.parseInt(ddMonth.getText()), Integer.parseInt(dd.getText())), 
									FlightDetailsFD.TotalSeats((EndHour-StartHour)), 
									FlightDetailsFD.SeatsAvaliable(todD, DepD, EndHour-StartHour));
							
							
							
						}
						if(Coming == false) {
							FlightDetailsFD.pushCreatedFlightToFile(cF.getValue(),dF.getValue(), Integer.parseInt(adYr.getText()), Integer.parseInt(adMonth.getText()), Integer.parseInt(ad.getText()), 
									StartHour, StartMin, EndHour, EndMin);
							Seating.pushSeatsListToFile(FlightDetailsFD.getFlightID(cF.getValue(),dF.getValue(), Integer.parseInt(adYr.getText()), Integer.parseInt(adMonth.getText()), Integer.parseInt(ad.getText())), 
									FlightDetailsFD.TotalSeats(EndHour-StartHour), 
									FlightDetailsFD.SeatsAvaliable(todD, DepD, EndHour-StartHour));
							
							
						}
						
						FlightDetailsFD.getFlightString(FlightTimings.getFlightHourNumber(dF.getValue(),cF.getValue()));
						//System.out.println(LoadPassengerData.displayDepartureFlight());
						//System.out.println("     Seats Avaliable on this Flight : " + FlightDetailsFD.SeatsAvaliable(d1, dD, EndHour-StartHour) 
											//+ "/" + FlightDetailsFD.TotalSeats(EndHour-StartHour));
						//System.out.println("     Price of Ticket : $" + FlightDetailsFD.getTicketPrice(d1, dD, EndHour-StartHour));
						
						//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
						//CHOOSING SEAT AND UPDATING - FLIGHT FOR GOING
						Seating.ChooseSeat(FlightDetailsFD.getFlightID(dF.getValue(),cF.getValue(), Integer.parseInt(ddYr.getText()), Integer.parseInt(ddMonth.getText()), Integer.parseInt(dd.getText())),
								FlightDetailsFD.TotalSeats(EndHour-StartHour));
						
						String asdf = Seating.getSeatChosen();
						
						while(asdf.isEmpty()) {
							System.out.print(".");
							asdf = Seating.getSeatChosen();
							//wait(5000);
							if(!asdf.isEmpty()) {
								//System.out.println("end loop");
								break;
							}
						}
						asdf = "";
						
						//System.out.println("Type Ticket : ");	String asdfaassdf = one.next();
						System.out.println(Seating.getSeatChosen());
						GoingSeat = Seating.getSeatChosen();
						
						Seating.UpdateFile(FlightDetailsFD.getFlightID(dF.getValue(), cF.getValue(), Integer.parseInt(ddYr.getText()), Integer.parseInt(ddMonth.getText()), Integer.parseInt(dd.getText())), Seating.getSeatChosen());
						//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
						
						//System.out.println(LoadPassengerData.FINALTICKET_OneWay(dF.getValue(), cF.getValue(), todD,DepD, GoingSeat));
						
						
						
						
						FlightDetailsFD.getFlightString(FlightTimings.getFlightHourNumber(dF.getValue(), cF.getValue()));
						//System.out.println(displayReturnFlight());
						System.out.println("     Seats Avaliable on this Flight : " + FlightDetailsFD.SeatsAvaliable(todD, ArrD, EndHour-StartHour) 
											+ "/" + FlightDetailsFD.TotalSeats(EndHour-StartHour));
						System.out.println("     Price of Ticket : $" 
											+ ((FlightDetailsFD.getTicketPrice(todD, DepD, EndHour-StartHour) 
													+ FlightDetailsFD.getTicketPrice(todD, ArrD, EndHour-StartHour)) * 0.75 )
											);
						
						//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
						//CHOOSING SEAT AND UPDATING - FLIGHT FOR COMING
						Seating.ChooseSeat(FlightDetailsFD.getFlightID(dF.getValue(),cF.getValue(), Integer.parseInt(ddYr.getText()), Integer.parseInt(ddMonth.getText()), Integer.parseInt(dd.getText())),
								FlightDetailsFD.TotalSeats(EndHour-StartHour));
						
						
						String asd = Seating.getSeatChosen();
						
						while(asd.isEmpty()) {
							System.out.print(".");
							asd = Seating.getSeatChosen();
							//wait(5000);
							if(!asd.isEmpty()) {
								//System.out.println("end loop");
								break;
							}
						}
						asd = "";
						
						//System.out.println("Type Ticket : ");	String asdfaassdf = one.next();
						
						ComingSeat = Seating.getSeatChosen();
						
						Seating.UpdateFile(FlightDetailsFD.getFlightID(dF.getValue(), cF.getValue(), Integer.parseInt(ddYr.getText()), Integer.parseInt(ddMonth.getText()), Integer.parseInt(dd.getText())), Seating.getSeatChosen());
						//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
						
						//GoingSeat = Seating.getSeatChosen();
						//Seating.UpdateFile(FlightDetailsFD.getFlightID(dF.getValue(),cF.getValue(), Integer.parseInt(ddYr.getText()), Integer.parseInt(ddMonth.getText()), Integer.parseInt(dd.getText())), Seating.getSeatChosen());
						
						if(!ComingSeat.isEmpty()) {
						FinalTicket=LoadPassengerData.FINALTICKET_TwoWay(dF.getValue(), cF.getValue(), todD,DepD,ArrD, cF.getValue(), dF.getValue(), GoingSeat, ComingSeat);
						System.out.print(FinalTicket);}
					}catch(IOException e) {
						e.printStackTrace();
					}
				}
				//call seating
				
				/*try {
					GoingSeat=Seating.getSeatDepartureFlight(todD, DepD, dF.getValue(), cF.getValue());
					ComingSeat=Seating.getSeatArrivalFlight(todD, DepD, dF.getValue(), cF.getValue());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				System.out.println(GoingSeat);
				System.out.println(ComingSeat);
				addPassDetails(primaryStage);

				
			}

				
			
			
		});
		
		center.setVgap(5);
		center.setHgap(5);
		 
		root1.setCenter(center);
        Scene secondScene = new Scene(root1, 600, 500);

        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("Search Flights");
        newWindow.setScene(secondScene);

        // Set position of second window, related to primary window.
        newWindow.setX(primaryStage.getX() + 200);
        newWindow.setY(primaryStage.getY() + 100);

        newWindow.show();
	}
	protected void addPassDetails(Stage primaryStage) {
		// TODO Auto-generated method stub
		BorderPane root= new BorderPane();
		
		//Margin of 10 pixels
		root.setPadding(new Insets(10,10,10,10));
		
		Button btn1;
		String Ticket=FinalTicket;

		TextField nameTxt, sexTxt ,phoneNum, ageTxt, emailTxt, addressTxt;
		ArrayList<String> ll=new ArrayList<String>();
		ArrayList<String> dl=new ArrayList<String>();
		Label lblSum;
		
		
		root.setTop(new Label("Ticket Price"+Ticket+"Enter your information in each text box below and click the button to confirm the information."));
		
		//The sum Label goes in the bottom
		lblSum=new Label("");
		root.setBottom(lblSum);
		//GridPane in the center of BorderPane
		GridPane center=new GridPane();
		center.setVgap(5);
		center.setHgap(5);
		
		
		nameTxt= new TextField();
		sexTxt= new TextField();
		ageTxt= new TextField();
		emailTxt=new TextField();
		addressTxt=new TextField();
		sexTxt.setPrefWidth(150);
		
		phoneNum=new TextField();
		phoneNum.setPrefWidth(150);
		center.add(new Label("First and Last Name:"), 0, 1);
		center.add(new Label("Gender:"), 0, 2);
		center.add(new Label("Age:"), 0, 3);
		center.add(nameTxt, 1, 1);
		center.add(sexTxt, 1, 2);
		center.add(ageTxt, 1, 3);
		
		center.add(emailTxt, 3, 1);
		center.add(addressTxt, 3, 2);
		center.add(phoneNum, 3, 3);
		center.add(new Label("Email:"), 2, 1);
		center.add(new Label("Address:"), 2, 2);
		center.add(new Label("Phone Number(No dashes):"), 2, 3);
		
		
		
		btn1 = new Button("Reserve Now!");
		
		center.add(btn1, 2, 6);
		root.setCenter(center);
		
		
		//EVENT HANDLER FOR Reserve BUTTON--------PROCESS THE INFO
		btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				String temp = nameTxt.getText();
				int index=temp.indexOf(" ");
				String fname=temp.substring(0, index);
				String lname=temp.substring(index+1);
				int age=Integer.parseInt(ageTxt.getText());
				String gender = sexTxt.getText();
				String temp1=phoneNum.getText();
				Long phoneNum=Long.parseLong(temp1);
				String email=emailTxt.getText();
				String address=addressTxt.getText();
				
				PassengerDetails newPass=new PassengerDetails(fname,lname,gender,age,phoneNum,email,address);
				
				/*System.out.println(newPass.getAge());
				System.out.println(newPass.getEmail());
				System.out.println(newPass.getCurrentAddress());
				System.out.println(newPass.getFirstName());
				System.out.println(newPass.getLastName());
				System.out.println(newPass.getPhoneNumber());
				System.out.println(newPass.getGender());*/
				try {
					
					newPass.sendPassengerDetailsToFile();
					if(returnFlight==false) {
						try {
							fT = new Image(new FileInputStream("D:\\Eclipse\\PracticeWork\\src\\groupProjectFiles\\Plane Ticket.jpg"));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
						//Setting the image view 
					      ImageView imageView = new ImageView(fT); 
					      
					      //Setting the position of the image 
					      imageView.setX(50); 
					      imageView.setY(25); 
					      
					      //setting the fit height and width of the image view 
					      imageView.setFitHeight(700); 
					      imageView.setFitWidth(1000); 
					      
					      //Setting the preserve ratio of the image view 
					      imageView.setPreserveRatio(true);
					      
					      str2=LoadPassengerData.str.clone();
							in2=LoadPassengerData.in.clone();
							String flightNum=String.valueOf(in2[0]);
							String dD=String.valueOf(in2[2]);
							String dM=String.valueOf(in2[1]);
							String dY=String.valueOf(in2[3]);
							String flightHour=String.valueOf(in2[4]);
							String flightMin=String.valueOf(in2[5]);
							String GoingSeat=str2[2];
							String departDate=dM+"/"+dD+"/"+dY;
							String fullLocTxt="";
							String fullDestTxt="";
							
							for(int i=0;i<FlightTimings.Airports.size();i++) {
								if(FlightTimings.Airports.get(i).contains(str2[0])) {
									String tmps=FlightTimings.Airports.get(i)+" ";
									String[] tm=tmps.split(",");
									int index1=tm[2].lastIndexOf("]");
									fullLocTxt=tm[2].substring(0,index1);
								}
								if(FlightTimings.Airports.get(i).contains(str2[1])) {
									String tmps=FlightTimings.Airports.get(i)+" ";
									String[] tm=tmps.split(",");
									int index1=tm[2].lastIndexOf("]");
									fullDestTxt=tm[2].substring(0, index1);
								}
							}
							System.out.println(fullLocTxt);
							System.out.println(fullDestTxt);
							Text name= new Text(temp);
						      Text name2=new Text(temp);
						      Text location= new Text(str2[0]);
						      Text dest=new Text(str2[1]);
						      Text gate= new Text("6A");
						      Text gate2= new Text("6A");
						      Text fliNum= new Text(flightNum);
						      Text fliNum2= new Text(flightNum);
						      Text seat=new Text(GoingSeat);
						      Text seat2=new Text(GoingSeat);
						      Text boardingT= new Text(flightHour+":"+flightMin);
						      Text boardingT2= new Text(flightHour+":"+flightMin);
						      Text boardingD= new Text(departDate);
						      Text fullLoc=new Text(fullLocTxt);
						      Text fullDest= new Text(fullDestTxt);
						      
						      
						      name.setFont(Font.font("Verdana", 20));
						      name.setX(175);
						      name.setY(140);
						      name2.setFont(Font.font("Verdana", 20));
						      name2.setRotate(-90);
						      name2.setY(140);
						      name2.setX(750);
						      location.setFont(Font.font("Verdana", FontWeight.BOLD,40));
						      location.setY(200);
						      location.setX(110);
						      dest.setFont(Font.font("Verdana", FontWeight.BOLD,40));
						      dest.setY(200);
						      dest.setX(300);
						      gate.setFont(Font.font("Verdana",FontWeight.BOLD, 30));
						      gate.setY(300);
						      gate.setX(380);
						      gate2.setFont(Font.font("Verdana",30));
						      gate2.setRotate(-90);
						      gate2.setY(330);
						      gate2.setX(830);
						      fliNum.setFont(Font.font("Verdana",FontWeight.BOLD, 30));
						      fliNum.setY(300);
						      fliNum.setX(130);
						      fliNum2.setFont(Font.font("Verdana", 30));
						      fliNum2.setRotate(-90);
						      fliNum2.setY(200);
						      fliNum2.setX(780);	      
						      seat.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
						      seat.setY(200);
						      seat.setX(450);
						      seat2.setFont(Font.font("Verdana", 20));
						      seat2.setRotate(-90);
						      seat2.setY(220);
						      seat2.setX(760);
						      boardingT.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
						      boardingT.setY(200);
						      boardingT.setX(535);
						      boardingT2.setFont(Font.font("Verdana", 30));
						      boardingT2.setRotate(-90);
						      boardingT2.setY(310);
						      boardingT2.setX(740);
						      boardingD.setFont(Font.font("Verdana", 15));
						      boardingD.setFill(Color.GRAY);
						      boardingD.setY(230);
						      boardingD.setX(535);
						      fullLoc.setFont(Font.font("Verdana", 15));
						      fullLoc.setFill(Color.GRAY);
						      fullLoc.setY(230);
						      fullLoc.setX(120);
						      fullDest.setFont(Font.font("Verdana", 15));
						      fullDest.setFill(Color.GRAY);
						      fullDest.setY(230);
						      fullDest.setX(300);
						      
						      Pane pane= new Pane();
							  pane.getChildren().add(imageView);
							  pane.getChildren().addAll(name,name2,location,dest,gate,gate2,fliNum,fliNum2,seat,seat2,boardingT,boardingT2, boardingD,fullLoc,fullDest);
							     
							     
							  //Creating a scene object 
							  Scene scene = new Scene(pane, 1000, 700);  
							      
							  //Setting title to the Stage 
							  primaryStage.setTitle("Flight Ticket");  
							     
							  //Adding scene to the stage 
							  primaryStage.setScene(scene);
							      
							  //Displaying the contents of the stage 
							  primaryStage.show(); 
					}else {
						try {
							fT = new Image(new FileInputStream("D:\\Eclipse\\PracticeWork\\src\\groupProjectFiles\\Plane TicketRT.jpg"));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}  
					      
						  //Setting the image view 
					      ImageView imageView = new ImageView(fT); 
					      
					      //Setting the position of the image 
					      imageView.setX(50); 
					      imageView.setY(25); 
					      
					      //setting the fit height and width of the image view 
					      imageView.setFitHeight(700); 
					      imageView.setFitWidth(1000); 
					      
					      //Setting the preserve ratio of the image view 
					      imageView.setPreserveRatio(true);  
					      
					      //Creating a Group object  
					      //Group root = new Group(imageView);  
					      str2=LoadPassengerData.str.clone();
							in2=LoadPassengerData.in.clone();
	/*int DH = FlightDetailsFD.getDepartureHour(oneDeparture, oneArrival, dD.getYear(), dD.getMonth(), dD.getDay());
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
		
		*
		*
		*
		*Flight Route    : " + oneDeparture + " to " + oneArrival                       + "\n"
				+ "Flight ID       : " + FID                                                      + "\n"
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
				+ "Departure Date  : " + (dA.getMonth() + "/" + dA.getDay() + "/" + dA.getYear()) + "\n"
				+ "Departure Time  : " + ADH + ":" + ADM                                          + "\n"
				+ "Arrival Time    : " + AAH + ":" + AAM                                          + "\n"
				+ "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "              + "\n"
				+ "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "              + "\n"
				+ "Price of Seat   : $" + price                                                   + "\n"
				+ "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "  		*/
							
							
							String flightNum=String.valueOf(in2[0]);
							String dD=String.valueOf(in2[1]);
							String dM=String.valueOf(in2[2]);
							String dY=String.valueOf(in2[3]);
							String GoingSeat=str2[4];
							String ComingSeat=str2[5];
							String departDate=dM+"/"+dD+"/"+dY;
							String departTime=String.valueOf(in2[4])+":"+String.valueOf(in2[5]);
							String departTime2=String.valueOf(in2[12])+":"+String.valueOf(in2[13]);
							String fullLocTxt="";
							String fullDestTxt="";
							String flightNum2=String.valueOf(in2[7]);
							String dD2=String.valueOf(in2[9]);
							String dM2=String.valueOf(in2[10]);
							String dY2=String.valueOf(in2[11]);
							String departDate2=dM2+"/"+dD2+"/"+dY2;
							String fullLocTxt2="";
							String fullDestTxt2="";
							
							for(int i=0;i<FlightTimings.Airports.size();i++) {
								if(FlightTimings.Airports.get(i).contains(str2[0])) {
									String tmps=FlightTimings.Airports.get(i)+" ";
									String[] tm=tmps.split(",");
									int index1=tm[2].lastIndexOf("]");
									fullLocTxt=tm[2].substring(0,index1);
								}
								if(FlightTimings.Airports.get(i).contains(str2[1])) {
									String tmps=FlightTimings.Airports.get(i)+" ";
									String[] tm=tmps.split(",");
									int index1=tm[2].lastIndexOf("]");
									fullDestTxt=tm[2].substring(0, index1);
								}
								
							}
							System.out.println(fullLocTxt);
							System.out.println(fullDestTxt);
							Text name= new Text(temp);
						      Text name2=new Text(temp);
						      Text location= new Text(str2[0]);
						      Text dest=new Text(str2[1]);
						      Text gate= new Text("6A");
						      Text gate2= new Text("6A");
						      Text fliNum= new Text(flightNum);
						      Text fliNum2= new Text(flightNum);
						      Text seat=new Text(GoingSeat);
						      Text seat2=new Text(GoingSeat);
						      Text boardingT= new Text(departTime);
						      Text boardingT2= new Text(departTime);
						      Text boardingD= new Text(departDate);
						      Text fullLoc=new Text(fullLocTxt);
						      Text fullDest= new Text(fullDestTxt);
						      
						      Text name3= new Text(temp);
						      Text name4=new Text(temp);
						      Text location2= new Text(str2[1]);
						      Text dest2=new Text(str2[2]);
						      Text gate21= new Text("6A");
						      Text gate22= new Text("6A");
						      Text fliNum21= new Text(flightNum2);
						      Text fliNum22= new Text(flightNum2);
						      Text seat21=new Text(ComingSeat);
						      Text seat22=new Text(ComingSeat);
						      Text boardingT21= new Text(departTime2);
						      Text boardingT22= new Text(departTime2);
						      Text boardingD2= new Text(departDate2);
						      Text fullLoc2=new Text(fullDestTxt);
						      Text fullDest2= new Text(fullLocTxt);
						      
						      
						     
						      name.setFont(Font.font("Verdana", 20));
						      name.setX(175);
						      name.setY(140);
						      name2.setFont(Font.font("Verdana", 20));
						      name2.setRotate(-90);
						      name2.setY(140);
						      name2.setX(750);
						      location.setFont(Font.font("Verdana", FontWeight.BOLD,40));
						      location.setY(200);
						      location.setX(110);
						      dest.setFont(Font.font("Verdana", FontWeight.BOLD,40));
						      dest.setY(200);
						      dest.setX(300);
						      gate.setFont(Font.font("Verdana",FontWeight.BOLD, 30));
						      gate.setY(300);
						      gate.setX(380);
						      gate2.setFont(Font.font("Verdana",30));
						      gate2.setRotate(-90);
						      gate2.setY(330);
						      gate2.setX(830);
						      fliNum.setFont(Font.font("Verdana",FontWeight.BOLD, 30));
						      fliNum.setY(300);
						      fliNum.setX(130);
						      fliNum2.setFont(Font.font("Verdana", 30));
						      fliNum2.setRotate(-90);
						      fliNum2.setY(200);
						      fliNum2.setX(780);	      
						      seat.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
						      seat.setY(200);
						      seat.setX(450);
						      seat2.setFont(Font.font("Verdana", 30));
						      seat2.setRotate(-90);
						      seat2.setY(220);
						      seat2.setX(760);
						      boardingT.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
						      boardingT.setY(200);
						      boardingT.setX(535);
						      boardingT2.setFont(Font.font("Verdana", 30));
						      boardingT2.setRotate(-90);
						      boardingT2.setY(310);
						      boardingT2.setX(740);
						      boardingD.setFont(Font.font("Verdana", 15));
						      boardingD.setFill(Color.GRAY);
						      boardingD.setY(230);
						      boardingD.setX(535);
						      fullLoc.setFont(Font.font("Verdana", 15));
						      fullLoc.setFill(Color.GRAY);
						      fullLoc.setY(230);
						      fullLoc.setX(120);
						      fullDest.setFont(Font.font("Verdana", 15));
						      fullDest.setFill(Color.GRAY);
						      fullDest.setY(230);
						      fullDest.setX(300);
						      
						      
						      name3.setFont(Font.font("Verdana", 20));
						      name3.setX(175);
						      name3.setY(440);
						      name4.setFont(Font.font("Verdana", 20));
						      name4.setRotate(-90);
						      name4.setY(450);
						      name4.setX(750);
						      location2.setFont(Font.font("Verdana", FontWeight.BOLD,40));
						      location2.setY(530);
						      location2.setX(110);
						      dest2.setFont(Font.font("Verdana", FontWeight.BOLD,40));
						      dest2.setY(530);
						      dest2.setX(300);
						      gate21.setFont(Font.font("Verdana",FontWeight.BOLD, 30));
						      gate21.setY(620);
						      gate21.setX(380);
						      gate22.setFont(Font.font("Verdana",30));
						      gate22.setRotate(-90);
						      gate22.setY(630);
						      gate22.setX(830);
						      fliNum21.setFont(Font.font("Verdana",FontWeight.BOLD, 30));
						      fliNum21.setY(620);
						      fliNum21.setX(130);
						      fliNum22.setFont(Font.font("Verdana", 30));
						      fliNum22.setRotate(-90);
						      fliNum22.setY(500);
						      fliNum22.setX(830);	      
						      seat21.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
						      seat21.setY(520);
						      seat21.setX(450);
						      seat22.setFont(Font.font("Verdana", 30));
						      seat22.setRotate(-90);
						      seat22.setY(520);
						      seat22.setX(740);
						      boardingT21.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
						      boardingT21.setY(520);
						      boardingT21.setX(535);
						      boardingT22.setFont(Font.font("Verdana", 30));
						      boardingT22.setRotate(-90);
						      boardingT22.setY(630);
						      boardingT22.setX(730);
						      boardingD2.setFont(Font.font("Verdana", 15));
						      boardingD2.setFill(Color.GRAY);
						      boardingD2.setY(550);
						      boardingD2.setX(535);
						      fullLoc2.setFont(Font.font("Verdana", 15));
						      fullLoc2.setFill(Color.GRAY);
						      fullLoc2.setY(550);
						      fullLoc2.setX(120);
						      fullDest2.setFont(Font.font("Verdana", 15));
						      fullDest2.setFill(Color.GRAY);
						      fullDest2.setY(550);
						      fullDest2.setX(300);
						      Pane pane= new Pane();
							  pane.getChildren().add(imageView);
							  pane.getChildren().addAll(name,name2,location,dest,gate,gate2,fliNum,fliNum2,seat,seat2,boardingT,boardingT2, boardingD,fullLoc,fullDest,
									  name3,name4,location2,dest2,gate21,gate22,fliNum21,fliNum22,seat21,seat22,boardingT21,boardingT22, boardingD2,fullLoc2,fullDest2);
							    
							     
							  //Creating a scene object 
							  Scene scene = new Scene(pane, 1000, 700);  
							      
							  //Setting title to the Stage 
							  primaryStage.setTitle("Flight Ticket");  
							     
							  //Adding scene to the stage 
							  primaryStage.setScene(scene);
							      
							  //Displaying the contents of the stage 
							  primaryStage.show(); 
					
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			}	
		}			
	);
			
			Scene secondScene = new Scene(root, 750, 600);

	        // New window (Stage)
	        Stage newWindow = new Stage();
	        newWindow.setTitle("Passenger Details");
	        newWindow.setScene(secondScene);

	        // Set position of second window, related to primary window.
	        newWindow.setX(primaryStage.getX() + 200);
	        newWindow.setY(primaryStage.getY() + 100);

	        newWindow.show();
	}

	private void getAirports(ArrayList<String> codes, ArrayList<String> airportNames) throws IOException {
		// TODO Auto-generated method stub
		String fileLocation = "D:\\Eclipse\\PracticeWork\\src\\groupProjectFiles\\AirportNamesState.csv";//\\\\
		File f = new File(fileLocation);
		
		
		try {
			BufferedReader br=new BufferedReader(new FileReader(f));
			String currentLine;
			
			while((currentLine=br.readLine())!=null) {
				
				String[] tmp= currentLine.split(",");
				
				for(int i=0;i<tmp.length;i++) {
						if(i%3==0)
						codes.add(tmp[i]);
						
				}
				for(int i=0;i<tmp.length;i++) {
					
					airportNames.add(tmp[i]);
					
			}
				
					

				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void lookUp(Stage primaryStage) {
		// TODO Auto-generated method stub
		PassengerDetails search=new PassengerDetails();
		TextField textField= new TextField();
		String text=textField.getText();
		
		BorderPane root1 = new BorderPane();
		Button searchBtn=new Button("Search");
		String str="";
		
		searchBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub			
				try {
					
					
					int x=Integer.parseInt(textField.getText());
					
					String str= search.SearchNumber(x);
					lookUpWind(str, primaryStage);					
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					}catch(NumberFormatException e) {
						
						try {
							Long L=Long.parseLong(textField.getText());
							try {
								String str=search.SearchNumber(L);
								lookUpWind(str, primaryStage);
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}catch(NumberFormatException e2) {
							try {
								
								String str=search.SearchString(textField.getText());
								lookUpWind(str, primaryStage);
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
				}
				
				
			
		}});
		root1.setPadding(new Insets(10,10,10,10));
		GridPane center=new GridPane();
		center.setVgap(5);
		center.setHgap(5);
	    center.add(textField, 10, 0);
		center.add(searchBtn, 10, 1);

		root1.setCenter(center);
	    Scene secondScene = new Scene(root1, 350, 250);
	
	    // New window (Stage)
	    Stage newWindow = new Stage();
	    newWindow.setTitle("Look Up Customer");
	    newWindow.setScene(secondScene);
	
	    // Set position of second window, related to primary window.
	    newWindow.setX(primaryStage.getX());
	    newWindow.setY(primaryStage.getY());
	
	    newWindow.show();
	}
	protected void lookUpWind(String str, Stage primaryStage) {
		// TODO Auto-generated method stub
		BorderPane root1 = new BorderPane();
		
		root1.setPadding(new Insets(10,10,10,10));
		GridPane center=new GridPane();
		center.setVgap(5);
		center.setHgap(5);
		
		root1.setCenter(center);
		
	    Scene secondScene = new Scene(root1, 600, 500);
	    Label btmLabel=new Label();
	    btmLabel.setText(str);
		center.add(btmLabel, 10, 0);
	    // New window (Stage)
	    Stage newWindow = new Stage();
	    newWindow.setTitle("Look Up Customer");
	    newWindow.setScene(secondScene);
	
	    // Set position of second window, related to primary window.
	    newWindow.setX(primaryStage.getX());
	    newWindow.setY(primaryStage.getY());
	
	    newWindow.show();
	}
	
	
	
}
