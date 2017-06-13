package modelo.personajes.estados;


import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.personajes.Stats;
import modelo.excepciones.AtaqueMismoEquipoException;

public class FreezerEstadoDefinitivo extends Estado {

    public FreezerEstadoDefinitivo(Stats stats) {
		stats.setPoder(50);
		stats.setDistanciaAtaque(3);
		stats.setVelocidadMov(6);
		stats.setKi(stats.getKi() - 50);
    }

    @Override
    public void Atacar(IPersonajeEquipoVillano pPersonaje, Stats stats) {
        throw new AtaqueMismoEquipoException();
    }
}