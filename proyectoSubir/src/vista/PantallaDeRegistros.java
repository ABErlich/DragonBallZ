package vista;
import controladores.BotonAJuego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PantallaDeRegistros extends VBox{
	Stage stage;
	String nombreDeJugadorVillano;
	String nombreDeJugadorEquipoZ;
	
	public PantallaDeRegistros(Stage stage, Scene botonAJuego,Label labelVillano,Label labelGuerrero ){
		super();
		this.stage = stage;
		this.setAlignment(Pos.CENTER);
	    this.setSpacing(20);
	    this.setPadding(new Insets(25));
	    
	    
	    //Visualizar la pantalla de bienvenida
	     Image imagenVillano = new Image("/vista/imagenes/equipoVillano.png");
	     ImageView imgVillano= new ImageView(imagenVillano);
		 imgVillano.setFitWidth(300);//un rango de 1000x1000
		 //para que la imagen no se distorsione
		 imgVillano.setPreserveRatio(true);
		 imgVillano.setSmooth(true);
		 imgVillano.setCache(true);			
			
		 Image imagenZ = new Image("/vista/imagenes/equipoZ.png");
		 ImageView imgZ= new ImageView(imagenZ);
		 imgZ.setFitWidth(300);//un rango de 1000x1000
		 //para que la imagen no se distorsione
		 imgZ.setPreserveRatio(true);
		 imgZ.setSmooth(true);
		 imgZ.setCache(true);
	    
		 
	     TextField jugadorVillano = new TextField();
	     jugadorVillano.setPromptText("Equipo Villanos>>>Ingrese su nombre");
	     
	     
	     TextField jugadorZ = new TextField();
	     jugadorZ.setPromptText("Equipo GuerreroZ>>>Ingrese su nombre");
	     
	     
	     
	     
	    
	     //boton next
	     Button botonjugar=new Button("Next>>");
	     botonjugar.setStyle("-fx-font: 30 arial; -fx-base: #6a2125;");
	     BotonAJuego botonAjuego=new BotonAJuego(stage,jugadorVillano,jugadorZ,labelVillano,labelGuerrero,botonAJuego);
	     botonjugar.setOnAction(botonAjuego);
	     
	     
	     this.getChildren().addAll(imgVillano,jugadorVillano,imgZ,jugadorZ,botonjugar);
	     
	}
	
}
