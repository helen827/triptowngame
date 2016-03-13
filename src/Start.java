import java.awt.Desktop;
import java.net.URL;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author: Haoyu Dong, Jiaying He, Baoling Chen
 * Description: The Start class implements the graphical user interface of the 
 * game and initializes it.
 * 
 * compile: javac *.java
 * run: java Start
 */
public class Start extends Application {
	
	public static final int TREE1 = 1, TREE2 = 2, TREE3 = 3, HOUSE1 = 4, 
			HOUSE2 = 5, HOUSE3 = 6, GEISEL = 7, CAT = 8;
	public static int count = 1;
	public static int PrePosX, PrePosY;
	public static int timeUse;
	public static int actualNum;
	
	/**
	 * Program control automatically jumps to this method after executing 
	 * Application.launch(args).
	 */
	public void start (Stage stage) {
		
		stage.setTitle("Tritown");
		ImageView buttonImage = new ImageView(
				new Image(getClass().getResourceAsStream("adam.png"), 80, 80, false, true));
		Button web = new Button("Introduction", buttonImage);
		web.setStyle("-fx-base: #c3c8c8;"
				+ "-fx-font-family: 'Times New Roman';"
				+ "-fx-font-weight: bold");

		//Clicking the button links to our website
		web.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					Desktop.getDesktop().browse(new URL
						("file:///Users/hejiaying/Desktop/cse11_web/tripletownWeb/home.html").toURI());
				}
				catch (Exception e) {
					System.out.println("Invalid URL");
				}
			}
		});

		//Set Text to display score
		Text score = new Text("Score: 0");
		score.setFont(Font.font("Times New Roman", FontWeight.BOLD, 
				FontPosture.ITALIC,30));
		
		//Set ImageView to display next item to be placed by user
		
		ImageView grass = new ImageView(new Image
				(Start.class.getResourceAsStream
						("boss.png"), 80, 80, false, true));
		
		
		
		GridPane gridPane1 = new GridPane();
			
		gridPane1.setVgap(100);
		gridPane1.setHgap(100);
		gridPane1.setPadding(new Insets(10, 10, 10, 15));
		
		GridPane.setConstraints(web, 0, 0);
		GridPane.setHalignment(web, HPos.CENTER);
		GridPane.setConstraints(grass, 1, 0);
		GridPane.setConstraints(score, 2, 0);
		gridPane1.getChildren().addAll(web, grass, score);
		
		GridPane gridPane2 = new GridPane();
		gridPane2.setGridLinesVisible(true);
		gridPane2.setPadding(new Insets(10, 10, 10, 10));
		
		TritownActual.initialGame();
		
		GridPane main = new GridPane();
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				
				
				ImageView base = new ImageView(new Image
						(Start.class.getResourceAsStream
								("button.png"), 100, 100, false, true));
				main.add(base,  i, j);
                
        		if (TritownActual.board[j][i] == 1) {
	                ImageView input;
	        		input = new ImageView(new Image
	        				(Start.class.getResourceAsStream
	        						("1.png"), 80, 80, false, true));
	       		
	        		GridPane.setHalignment(input, HPos.CENTER);
									
					main.add(input, i, j);
					
        		}
        		if (TritownActual.board[j][i] == 2) {
                    ImageView grass1;
            		grass1 = new ImageView(new Image
            				(Start.class.getResourceAsStream
            						("2.png"), 80, 80, false, true));
           		
            		GridPane.setHalignment(grass1, HPos.CENTER);
    				
    				
    				main.add(grass1, i, j);
    				
            		}
        		if (TritownActual.board[j][i] == 3) {
                    ImageView grass1;
            		grass1 = new ImageView(new Image
            				(Start.class.getResourceAsStream
            						("3.png"), 80, 80, false, true));

    			
            		GridPane.setHalignment(grass1, HPos.CENTER);
    				
    				
    				main.add(grass1, i, j);
    				
            		}
        		
			}
		}
		main.setHgap(15);
		main.setVgap(15);
		main.setPadding(new Insets(15, 15, 15, 15));
		
		Pane startPane = new VBox(12);
		
		startPane.getChildren().addAll(gridPane1, gridPane2, main);
		
		Image bg = new Image(Start.class.getResourceAsStream
				("background.jpg"), 705, 850, false, true);
		
		BackgroundImage myBI = new BackgroundImage(bg, 
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, 
				BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT); 
		startPane.setBackground(new Background(myBI));
		
		
		
		stage.addEventFilter(
				MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					int PosX = (int) mouseEvent.getX();
					int PosY = (int) mouseEvent.getY();
					

					for (int i = 0; i < 6; i++) {
						if (PosY >= 160-7 + 115*i && PosY <= 260+115*i) {
							PosY = i;
						}
						if (PosX >= 15-7 + 115*i && PosX <= 115+115*i) {
							PosX = i;
						}
					}
					/* if (PosX > 6 || PosY > 6) {
						Alert alert = new Alert(AlertType.INFORMATION);
			    		alert.setTitle("Illegal Place");
			    		alert.setHeaderText(null);
			    		alert.setContentText("You should not put "
			    				+ "your mouse out of boundry");
			    		alert.showAndWait();
					} */
					
		    	
				if (count%2 == 1) {
		    		PrePosX = PosY;
		    		PrePosY = PosX;
		    		TritownActual.nextObject();
		    		if (PosX == 0 && PosY == 0) {
		    			timeUse++;
		    			if (timeUse < 3) {
		    				for (int a = 0; a < 7; a++) {
		    					Random rand = new Random();
		    					int rand1 = rand.nextInt(5);
		    					int rand2 = rand.nextInt(5);
		    					TritownActual.board[rand1][rand2] = 0;
		    				}
		    			
		    			
		    			 for (int i = 0; i < 6; i++) {
								for (int j = 0; j < 6; j++) {

									ImageView base = new ImageView(new Image
											(Start.class.getResourceAsStream
													("button.png"), 100, 100, 
													false, true));
									main.add(base,  i, j);
					        		
									if (TritownActual.board[j][i] == TREE1) {
					                ImageView grass1;
					        		grass1 = new ImageView(new Image
					        				(Start.class.getResourceAsStream
					        				("1.png"), 80, 80, false, true));
			
					        		GridPane.setHalignment(grass1, HPos.CENTER);
									
									main.add(grass1, i, j);
									
					        		}
					        		if (TritownActual.board[j][i] == TREE2) {
					                    ImageView grass1;
					                    grass1 = new ImageView(new Image
					                    		(Start.class.getResourceAsStream
					                    		("2.png"), 80, 80, false, true));
			
			            		
					            		GridPane.setHalignment(grass1, HPos.CENTER);
					    				
					    				
					    				main.add(grass1, i, j);
					    				
					            		}
					        		if (TritownActual.board[j][i] == TREE3) {
					                    ImageView grass1;
					            		grass1 = new ImageView(new Image
					            				(Start.class.getResourceAsStream
					            				("3.png"), 80, 80, false, true));
			
					            		GridPane.setHalignment(grass1, HPos.CENTER);
					    				main.add(grass1, i, j);
					    				
					            		}
					        		if (TritownActual.board[j][i] == HOUSE1) {
					                    ImageView grass1;
					            		grass1 = new ImageView(new Image
					            				(Start.class.getResourceAsStream
					            				("house.png"), 80, 80, false, true));
			
					            		GridPane.setHalignment(grass1, HPos.CENTER);
					    				main.add(grass1, i, j);
					    				
					            		}
					        		if (TritownActual.board[j][i] == HOUSE2) {
					                    ImageView grass1;
					            		grass1 = new ImageView(new Image
					            				(Start.class.getResourceAsStream
					            				("house2.png"), 80, 80, false, true));
			
					            		GridPane.setHalignment(grass1, HPos.CENTER);
					    				main.add(grass1, i, j);
					    				
					            		}
					        		if (TritownActual.board[j][i] == HOUSE3) {
					                    ImageView grass1;
					            		grass1 = new ImageView(new Image
					            				(Start.class.getResourceAsStream
					            				("house3.png"), 80, 80, false, true));
			
					            		GridPane.setHalignment(grass1, HPos.CENTER);
					    				main.add(grass1, i, j);
					    				
					            		}
					        		if (TritownActual.board[j][i] == GEISEL) {
					                    ImageView grass1;
					            		grass1 = new ImageView(new Image
					            				(Start.class.getResourceAsStream
					            				("boss.png"), 80, 80, false, true));
			
					            		GridPane.setHalignment(grass1, HPos.CENTER);
					    				main.add(grass1, i, j);
					    				
					            		}
					        		if (TritownActual.board[j][i] == CAT) {
						                ImageView grass1;
						        		grass1 = new ImageView(new Image
						        				(Start.class.getResourceAsStream
						        				("cat.png"), 80, 80, false, true));
						       		
						        		GridPane.setHalignment(grass1, HPos.CENTER);
														
										main.add(grass1, i, j);
										
					        			}
					        		if (TritownActual.board[j][i] == CatRun.ROCK) {
						                ImageView grass1;
						        		grass1 = new ImageView(new Image
						        				(Start.class.getResourceAsStream
						        				("rock.png"), 80, 80, false, true));
						       		
						        		GridPane.setHalignment(grass1, HPos.CENTER);
														
										main.add(grass1, i, j);
										
					        			}
					        		
					        		
									}
								}
		    			 count+=2;
		    		}
		    			 		    		
		    		else {
	    				Rectangle Square = new Rectangle();
		    			//Check for values in the tile and set the color
		    			Square.setWidth(100);
		    			Square.setHeight(100);
		    			Square.setArcHeight(15);
		    			Square.setArcWidth(15);
		    			Square.setFill(Color.BLACK);
		    			main.add(Square, PrePosY, PrePosX);
		    			count+=2;
	    				}
		    			
		    		
		    		}
		    		else {
		    			int k = 0;
		    			gridPane1.getChildren().clear();
		    			//Button web = new Button("Introduction");
		    			ImageView buttonImage = new ImageView(
		    					new Image(getClass().getResourceAsStream("adam.png"),
		    							80, 80, false, true));
		    			Button web = new Button("Introduction", buttonImage);
		    			web.setStyle("-fx-base: #c3c8c8;"
		    					+ "-fx-font-family: 'Times New Roman';"
		    					+ "-fx-font-weight: bold");
		    			web.setOnAction(new EventHandler<ActionEvent>() {
		    				@Override
		    				public void handle(ActionEvent event) {
		    					try {
		    						Desktop.getDesktop().browse(new URL
		    			("file:///C:/Users/Jerry/Desktop/tripletownWeb-master/home.html").toURI());
		    					}
		    					catch (Exception e) {
		    						System.out.println("Invalid URL");
		    					}
		    				}
		    			});
		    			
		    			Text score = new Text("Score: " + TritownActual.Score);
		    			score.setFont(Font.font("Times New Roman", 
		    					FontWeight.BOLD, FontPosture.ITALIC,30));
		    			
		    			ImageView grass = null;
			        	k = TritownActual.nextValue;
						
			        	if (k == 1) {
			        		grass = new ImageView(new Image
			        				(Start.class.getResourceAsStream
			        						("1.png"), 80, 80, false, true));
						}
			        	if (k == 2) {
			        		grass = new ImageView(new Image
			        				(Start.class.getResourceAsStream
			        						("2.png"), 80, 80, false, true));
				        }
			        	if (k == 3) {
			        		grass = new ImageView(new Image
			        				(Start.class.getResourceAsStream
			        						("3.png"), 80, 80, false, true));
			        	}
			        	if (k == 4) {		                
			        		grass = new ImageView(new Image
			        				(Start.class.getResourceAsStream
			        						("house.png"), 
			        						80, 80, false, true));	       		
			        	}
			        	if (k == 8) {		                
			        		grass = new ImageView(new Image
			        				(Start.class.getResourceAsStream
			        						("cat.png"), 80, 80, false, true));	       		
			        	}
			        	
				    	
			        	GridPane.setConstraints(grass, 1, 0);
			        	GridPane.setConstraints(score, 2, 0);
			        	gridPane1.getChildren().addAll(web, grass, score);
				    
			        	count++;
			        	
		    		}
				}
				else {
					main.getChildren().clear();			        
			        
					TritownActual.Algorithm(PosX, PosY); 			       			      
			       
			        for (int i = 0; i < 6; i++) {
			        	for (int j = 0; j < 6; j++) {
							
			        		ImageView base = new ImageView(new Image
			        				(Start.class.getResourceAsStream
			        				("button.png"), 100, 100, false, true));
							main.add(base,  i, j);
			                
			        		if (TritownActual.board[j][i] == TREE1) {
			                ImageView grass1;
			        		grass1 = new ImageView(new Image
			        				(Start.class.getResourceAsStream
			        				("1.png"), 80, 80, false, true));
	
			        		GridPane.setHalignment(grass1, HPos.CENTER);
							
							main.add(grass1, i, j);
							
			        		}
			        		if (TritownActual.board[j][i] == TREE2) {
			        			ImageView grass1;
			            		grass1 = new ImageView(new Image
			            				(Start.class.getResourceAsStream
			            				("2.png"), 80, 80, false, true));
			            		
			            		GridPane.setHalignment(grass1, HPos.CENTER);
			    				
			    				main.add(grass1, i, j);
			    				
			        		}
			        		if (TritownActual.board[j][i] == TREE3) {
			                    ImageView grass1;
			            		grass1 = new ImageView(new Image
			            				(Start.class.getResourceAsStream
			            				("3.png"), 80, 80, false, true));
	
			            		GridPane.setHalignment(grass1, HPos.CENTER);
			    				main.add(grass1, i, j);
			    				
			        		}
			        		if (TritownActual.board[j][i] == HOUSE1) {
			                    ImageView grass1;
			            		grass1 = new ImageView(new Image
			            				(Start.class.getResourceAsStream
			            				("house.png"), 80, 80, false, true));
	
			            		GridPane.setHalignment(grass1, HPos.CENTER);
			    				main.add(grass1, i, j);
			    				
			        		}
			        		if (TritownActual.board[j][i] == HOUSE2) {
			                    ImageView grass1;
			            		grass1 = new ImageView(new Image
			            				(Start.class.getResourceAsStream
			            				("house2.png"), 80, 80, false, true));
	
			            		GridPane.setHalignment(grass1, HPos.CENTER);
			    				main.add(grass1, i, j);
			    				
			        		}
			        		if (TritownActual.board[j][i] == HOUSE3) {
			                    ImageView grass1;
			            		grass1 = new ImageView(new Image
			            				(Start.class.getResourceAsStream
			            				("house3.png"), 80, 80, false, true));
	
			            		GridPane.setHalignment(grass1, HPos.CENTER);
			    				main.add(grass1, i, j);
			    				
			        		}
			        		if (TritownActual.board[j][i] == GEISEL) {
			                    ImageView grass1;
			            		grass1 = new ImageView(new Image
			            				(Start.class.getResourceAsStream
			            				("boss.png"), 80, 80, false, true));
	
			            		GridPane.setHalignment(grass1, HPos.CENTER);
			    				main.add(grass1, i, j);
			    				
			        		}
			        		if (TritownActual.board[j][i] == CAT) {
				                ImageView grass1;
				        		grass1 = new ImageView(new Image
				        				(Start.class.getResourceAsStream
				        				("cat.png"), 80, 80, false, true));
				       		
				        		GridPane.setHalignment(grass1, HPos.CENTER);
												
								main.add(grass1, i, j);
								
			        		}
			        		if (TritownActual.board[j][i] == CatRun.ROCK) {
				                ImageView grass1;
				        		grass1 = new ImageView(new Image
				        				(Start.class.getResourceAsStream
				        				("rock.png"), 80, 80, false, true));
				       		
				        		GridPane.setHalignment(grass1, HPos.CENTER);
												
								main.add(grass1, i, j);
								
			        		}
			        				
			        	}
			        }
			        if (timeUse >= 3) {
			        	Rectangle Square = new Rectangle();
		    			Square.setWidth(100);
		    			Square.setHeight(100);
		    			Square.setArcHeight(15);
		    			Square.setArcWidth(15);
		    			Square.setFill(Color.BLACK);
		    			main.add(Square, 0, 0);
			        }
			        count++;
			    	
		    	}


			}
		    });
		
		
			stage.setScene(new Scene(startPane));
			stage.show(); 
		}
	
	
	
	/**
	 * The main method starts at program execution.
	 */
	public static void main(String[] args) {
        Application.launch(args);
    }

}
