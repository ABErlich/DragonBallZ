package modelo.personajes.estados;


import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.personajes.Stats;
import modelo.excepciones.AtaqueMismoEquipoException;

public class FreezerEstadoNormal extends Estado {

    public FreezerEstadoNormal(Stats stats){
    	stats.setVida(400);
		stats.setPoder(20);
		stats.setDistanciaAtaque(2);
		stats.setVelocidadMov(4);
		stats.setKi(0);

    }

    @Override
    public void Atacar(IPersonajeEquipoVillano pPersonaje, Stats stats){
        throw new AtaqueMismoEquipoException();
    }


}
