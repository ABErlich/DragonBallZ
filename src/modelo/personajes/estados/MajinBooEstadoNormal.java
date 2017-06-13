package modelo.personajes.estados;


import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.personajes.Stats;
import modelo.excepciones.AtaqueMismoEquipoException;

public class MajinBooEstadoNormal extends Estado {

    public MajinBooEstadoNormal(Stats stats){
    	stats.setVida(300);
		stats.setPoder(30);
		stats.setDistanciaAtaque(2);
		stats.setVelocidadMov(2);
		stats.setKi(0);

    }

    @Override
    public void Atacar(IPersonajeEquipoVillano pPersonaje, Stats stats){
        throw new AtaqueMismoEquipoException();
    }


}
