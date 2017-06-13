package modelo.personajes.estados;


import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.personajes.Stats;
import modelo.excepciones.AtaqueMismoEquipoException;

public class MajinBooEstadoBooMalo extends Estado {

    public MajinBooEstadoBooMalo(Stats stats) {
		stats.setPoder(50);
		stats.setDistanciaAtaque(2);
		stats.setVelocidadMov(3);
		stats.setKi(stats.getKi() - 20);

    }

    @Override
    public void Atacar(IPersonajeEquipoVillano pPersonaje, Stats stats) {
        throw new AtaqueMismoEquipoException();
    }
}