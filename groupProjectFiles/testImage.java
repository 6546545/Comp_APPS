package groupProjectFiles;

import java.awt.Label;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class testImage extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		
		Image fT = null;
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
	      
	  	Text name= new Text("Test Name");
	      Text name2=new Text("Test Name");
	      Text location= new Text("LAX");
	      Text dest=new Text("IST");
	      Text gate= new Text("6A");
	      Text gate2= new Text("6A");
	      Text fliNum= new Text("06256454");
	      Text fliNum2= new Text("06256454");
	      Text seat=new Text("TEST");
	      Text seat2=new Text("TEST");
	      Text boardingT= new Text("TEST");
	      Text boardingT2= new Text("TEST");
	      Text boardingD= new Text("01/20/1659");
	      Text fullLoc=new Text("Test");
	      Text fullDest= new Text("Test");
	      
	      Text name3= new Text("Test Name");
	      Text name4=new Text("Test Name");
	      Text location2= new Text("LAX");
	      Text dest2=new Text("IST");
	      Text gate21= new Text("6A");
	      Text gate22= new Text("6A");
	      Text fliNum21= new Text("06256454");
	      Text fliNum22= new Text("06256454");
	      Text seat21=new Text("TEST");
	      Text seat22=new Text("TEST");
	      Text boardingT21= new Text("TEST");
	      Text boardingT22= new Text("TEST");
	      Text boardingD2= new Text("02/32/5555");
	      Text fullLoc2=new Text("TEST");
	      Text fullDest2= new Text("TEST");
	      
	      
	     
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
	      seat2.setX(735);
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
	      fliNum22.setX(780);	      
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

}
