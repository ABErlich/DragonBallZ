package modelo.vista;




import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;



public class PantallaDeJuego extends StackPane {

		public PantallaDeJuego(Label labelVillano,Label labelGuerrero){
			
			//this.setAlignment(Pos.TOP_LEFT);
			
			 Image imagen = new Image("/vista/imagenes/fondojuego.png");
		     BackgroundSize backgroundSize = new BackgroundSize(1500,950, true, true, true, false);
		     BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
		     this.setBackground(new Background(imagenDeFondo));
			
			
			
			
			this.getChildren().add(labelVillano);
			this.setAlignment(labelVillano,Pos.TOP_RIGHT);
			this.getChildren().add(labelGuerrero);
			this.setAlignment(labelGuerrero,Pos.TOP_LEFT);
			//this.setPrefWidth(1000);
			//------------------------------------------------------------
		GridPane gPane=new GridPane();
			gPane.setAlignment(Pos.CENTER);
			
					for(int i=0;i< 8;i++){
						for(int j=0;j<8;j++){
							
							Button btn=new Button();
							
							btn.setPrefSize(70,70);
							btn.setStyle("-fx-base: #0B0B0B;");

							
							if (i==0&&j==1){
								Image imagenGoku = new Image(getClass().getResourceAsStream("/vista/imagenes/Goku.png"));
								ImageView imgGoku = new ImageView(imagenGoku);
								imgGoku.setFitWidth(50);
								imgGoku.setFitHeight(50);
								imgGoku.setPreserveRatio(true);
								imgGoku.setSmooth(true);
								imgGoku.setCache(true);
								

								btn.setGraphic(imgGoku);						
							
							}
							if (i==0&&j==3){
								Image imagenGoku = new Image(getClass().getResourceAsStream("/vista/imagenes/Gohan.png"));
								ImageView imgGoku = new ImageView(imagenGoku);
								imgGoku.setFitWidth(50);
								imgGoku.setFitHeight(50);
								imgGoku.setPreserveRatio(true);
								imgGoku.setSmooth(true);
								imgGoku.setCache(true);
								

								btn.setGraphic(imgGoku);						
							
							}
							if (i==0&&j==5){
								Image imagenGoku = new Image(getClass().getResourceAsStream("/vista/imagenes/Piccolo.png"));
								ImageView imgGoku = new ImageView(imagenGoku);
								imgGoku.setFitWidth(50);
								imgGoku.setFitHeight(50);
								imgGoku.setPreserveRatio(true);
								imgGoku.setSmooth(true);
								imgGoku.setCache(true);
								

								btn.setGraphic(imgGoku);						
							
							}	
							if (i==7&&j==1){
								Image imagenGoku = new Image(getClass().getResourceAsStream("/vista/imagenes/freezer.png"));
								ImageView imgGoku = new ImageView(imagenGoku);
								imgGoku.setFitWidth(50);
								imgGoku.setFitHeight(50);
								imgGoku.setPreserveRatio(true);
								imgGoku.setSmooth(true);
								imgGoku.setCache(true);
								

								btn.setGraphic(imgGoku);						
							
							}	
							if (i==7&&j==3){
								Image imagenGoku = new Image(getClass().getResourceAsStream("/vista/imagenes/Majinbuu.png"));
								ImageView imgGoku = new ImageView(imagenGoku);
								imgGoku.setFitWidth(50);
								imgGoku.setFitHeight(50);
								imgGoku.setPreserveRatio(true);
								imgGoku.setSmooth(true);
								imgGoku.setCache(true);
								

								btn.setGraphic(imgGoku);						
							
							}	
							if (i==7&&j==5){
								Image imagenGoku = new Image(getClass().getResourceAsStream("/vista/imagenes/Cell.png"));
								ImageView imgGoku = new ImageView(imagenGoku);
								imgGoku.setFitWidth(50);
								imgGoku.setFitHeight(50);
								imgGoku.setPreserveRatio(true);
								imgGoku.setSmooth(true);
								imgGoku.setCache(true);
								

								btn.setGraphic(imgGoku);						
							
							}
					
					btn.setMaxWidth(Long.MAX_VALUE);
					btn.setMaxHeight(Long.MAX_VALUE);
					//btn.setMaxWidth(1000);
					//btn.setMaxHeight(1000);
					
					gPane.add(btn, i, j);
				}
			}
			this.getChildren().add(gPane);
			
			
	        
		}	
	
	}


