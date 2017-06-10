package modelo.tablero;

public class Coordenada {
	
	public Coordenada(int pCoordX, int pCoordY){
		this.CoordX = pCoordX;
		this.CoordY = pCoordY;
	}
	
	private int CoordX;
	private int CoordY;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + CoordX;
		result = prime * result + CoordY;
		return result;
	}

	@Override
	public boolean equals(Object other) {
	    if (!(other instanceof Coordenada)) {
	        return false;
	    }
	    Coordenada that = (Coordenada) other;
	    return this.CoordX == that.CoordX
	        && this.CoordY == that.CoordY;
	}
	
	public int getCoordX() {
		return CoordX;
	}
	public int getCoordY() {
		return CoordY;
	}
	
}
