package modelo.personajes.estados;


import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.personajes.Stats;
import modelo.excepciones.AtaqueMismoEquipoException;

public class FreezerEstadoSegundaForma extends Estado {

    public FreezerEstadoSegundaForma(Stats stats) {
		stats.setPoder(40);
		stats.setDistanciaAtaque(3);
		stats.setVelocidadMov(4);
		stats.setKi(stats.getKi() - 20);

    }

    @Override
    public void Atacar(IPersonajeEquipoVillano pPersonaje, Stats stats) {
        throw new AtaqueMismoEquipoException();
    }
}