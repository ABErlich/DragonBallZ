package modelo.vista;



import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;


public class Aplicacion extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(final Stage stage) throws Exception {
		
		stage.setTitle("---DragonBallZ---");
		
		
		//Scene EscenaSiguiente=new Scene(null);
		
		//BorderPane root = new BorderPane();
		//Scene scene = new Scene(root,400,400);
		Label labelVillano=new Label();
		Label labelGuerrero=new Label();
		
		PantallaDeJuego pantallaTabla=new PantallaDeJuego(labelVillano,labelGuerrero);
		Scene escenaDeJuego=new Scene(pantallaTabla,1500,700);
		//Paso la escena registro
		
		PantallaDeRegistros pantallaRegistros=new PantallaDeRegistros(stage, escenaDeJuego,labelVillano,labelGuerrero);
		
		Scene escenaDeRegistros=new Scene(pantallaRegistros,500,900);
		
		
		//Escena de bienvenida
		PantallaDeBienvenida pantallaBienvenidos=new PantallaDeBienvenida(stage, escenaDeRegistros);
		Scene escenaDeBienvenidos=new Scene(pantallaBienvenidos,1500,700);
		
        stage.setScene(escenaDeBienvenidos);
        stage.setFullScreen(true);

        stage.show();
        
        
		/*try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}*/
       
	}
	
}	
	


