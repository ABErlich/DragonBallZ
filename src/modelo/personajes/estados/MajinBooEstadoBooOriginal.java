package modelo.personajes.estados;


import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.personajes.Stats;
import modelo.excepciones.AtaqueMismoEquipoException;

public class MajinBooEstadoBooOriginal extends Estado {

    public MajinBooEstadoBooOriginal(Stats stats) {

		stats.setPoder(60);
		stats.setDistanciaAtaque(3);
		stats.setVelocidadMov(4);
		stats.setKi(stats.getKi() - 50);
    }

    @Override
    public void Atacar(IPersonajeEquipoVillano pPersonaje, Stats stats) {
        throw new AtaqueMismoEquipoException();
    }
}