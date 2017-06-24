package vista;

public enum personajeTipo {
	FREEZER(-1),MAJINBOO(-2),CELL(-3), GOKU(1),GOHAN(2),PICCOLO(3);
	
	final int movimientoDir;
	personajeTipo(int movimiento){
		this.movimientoDir=movimiento;
	}
	
}
