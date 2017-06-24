package modelo.tablero;

public class Coordenada {
	
	public Coordenada(int CoordX, int CoordY){
		this.CoordX = CoordX;
		this.CoordY = CoordY;
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
	
	private int getCoordX() {
		return CoordX;
	}
	private int getCoordY() {
		return CoordY;
	}

	public int calcularDistancia(Coordenada destino){
		
		int destinoX = destino.getCoordX();
		int destinoY = destino.getCoordY();
		
		int distanciaX = Math.abs(CoordX - destinoX);
		int distanciaY = Math.abs(CoordY - destinoY);
		
		int distanciatotal = Math.max(distanciaX, distanciaY);
		
		return distanciatotal;
	}
	
}
