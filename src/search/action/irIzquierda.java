package search.action;

import java.awt.Point;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import search.EstadoAmbiente;
import search.EstadoPlanta;

public class irIzquierda extends SearchAction {

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {

		EstadoPlanta estado = (EstadoPlanta) s;
		Integer y = estado.getPosicion().y;
		Integer xAux = estado.getPosicion().x - 1;
		Point punto = new Point(xAux, y);

		// Si no estoy en los limites, ni hay un zombie, el agente se puede mover
		if (xAux > -1 && xAux < 9 && !estado.getZombies().containsKey(punto)) {

			// Actualizamos la posicion
			estado.setPosicion(punto);
			// Si estamos en la posicion de un girasol y el girasol tiene mas de un sol
			// entonces
			// Le sumamos esa energia al agente
			if (estado.getGirasoles().containsKey(punto) && estado.getGirasoles().get(punto) > 0) {
				estado.setEnergia(estado.getEnergia() + estado.getGirasoles().get(punto));
				estado.getGirasoles().replace(punto, 0);

			}
		}

		return estado;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {

		EstadoPlanta planta = (EstadoPlanta) ast;
		EstadoAmbiente ambiente = (EstadoAmbiente) est;

		Integer xAux = planta.getPosicion().x - 1;
		Integer y = planta.getPosicion().y;
		Point punto = new Point(xAux, y);

		// Si no estoy en los limites, el agente se puede mover
		if (xAux > -1 && xAux < 9) {

			// Si la planta se mueve donde hay un zombie
			if (ambiente.getZombies().containsKey(punto)) {
				Integer energiaActual = ambiente.getEnergiaPlanta();
				Integer costoZombie = ambiente.getZombies().get(punto).getEnergia() * 2;

				ambiente.setEnergiaPlanta(energiaActual - costoZombie);

				// CONTEMPLAR DESPUES QUE EN LA POSICION 1 1 NO HAYA NINGUN ZOMBIE
				ambiente.setPosicionPlanta(new Point(1, 1));
			}

			else {

				ambiente.setPosicionPlanta(punto);
				planta.setPosicion(punto);

				// Si estamos en la posicion de un girasol y el girasol tiene mas de un sol
				// entonces
				// Le sumamos esa energia al agente
				if (ambiente.getGirasoles().containsKey(punto) && ambiente.getGirasoles().get(punto) > 0) {

					planta.setEnergia(ambiente.getEnergiaPlanta() + ambiente.getGirasoles().get(punto));
					ambiente.setEnergiaPlanta(ambiente.getEnergiaPlanta() + ambiente.getGirasoles().get(punto));
					planta.getGirasoles().replace(punto, 0);
					ambiente.getGirasoles().replace(punto, 0);

				}

			}

		}

		System.out.println(punto);

		return ambiente;

	}

	@Override
	public String toString() {
		return "irIzquierda";
	}

	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return 1.0;
	}

}