package modelo.personajes.estados;


import modelo.personajes.Stats;
import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.excepciones.AtaqueMismoEquipoException;

public class CellEstadoPerfecto extends Estado {

    public CellEstadoPerfecto(Stats stats) {
		stats.setPoder(80);
		stats.setDistanciaAtaque(4);
		stats.setVelocidadMov(4);

    }

    @Override
    public void Atacar(IPersonajeEquipoVillano pPersonaje, Stats stats) {
        throw new AtaqueMismoEquipoException();
    }
}