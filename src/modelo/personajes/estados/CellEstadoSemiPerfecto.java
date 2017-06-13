package modelo.personajes.estados;


import modelo.personajes.Stats;
import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.excepciones.AtaqueMismoEquipoException;

public class CellEstadoSemiPerfecto extends Estado {

    public CellEstadoSemiPerfecto(Stats stats) {
		stats.setPoder(40);
		stats.setDistanciaAtaque(4);
		stats.setVelocidadMov(3);

    }

    @Override
    public void Atacar(IPersonajeEquipoVillano pPersonaje, Stats stats) {
        throw new AtaqueMismoEquipoException();
    }
}