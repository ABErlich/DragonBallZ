package modelo.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class BotonExit implements EventHandler<ActionEvent> {

	public BotonExit() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		// TODO Auto-generated method stub
		System.exit(0);		
		
	}

}
