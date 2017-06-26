package modelo.vista;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import modelo.vista.personajeTipo;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;


public class personaje extends StackPane implements MouseMotionListener{
	
	
	private personajeTipo tipo;
	
	private double mouseX, mouseY;
    private double antiguoX, antiguoY;
    
    

	public personaje(personajeTipo tipo, int x, int y){
		
	}
	public personajeTipo getTipo(){
    	return tipo;
    }

	public double getAntiguoY() {
		return antiguoY;
	}

	public double getAntiguoX() {
		return antiguoX;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
    
	
    
	
	

}
