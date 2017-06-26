package DBZ;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

	private SceneManager sceneManager;

    public MainApp() {
    	this.sceneManager = new SceneManager(this);
    }

    @Override
    public void start(Stage vista) {
    	sceneManager.start(vista);
    }

    public static void main(String[] args) {
        launch(args);
    }
}