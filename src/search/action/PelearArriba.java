package search.action;

import java.awt.Point;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import search.EstadoAmbiente;
import search.EstadoPlanta;

public class PelearArriba extends SearchAction {

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {

		EstadoPlanta planta = (EstadoPlanta) s;

		Integer x = planta.getPosicion().x;
		Integer yAux = planta.getPosicion().y + 1;
		Point punto = new Point(x, yAux);
		Integer energia = planta.getEnergia();

		// si en la posicion adyacente se encuentra un zombie y tiene los soles para
		// matarlo entonces puede pelear
		if (planta.getZombies().containsKey(punto)
				&& planta.getZombies().get(punto).getEnergia() < energia) {

			planta.setEnergia(energia - planta.getZombies().get(punto).getEnergia());
			planta.getZombies().remove(punto);
			// --IMPORTANTE--
			planta.setCantidadZombies(0);
			// -------------
		}

		return planta;
	}

	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return 0.0;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {

		EstadoAmbiente ambiente = (EstadoAmbiente) est;

		Integer x = ambiente.getPosicionPlanta().x;
		Integer yAux = ambiente.getPosicionPlanta().y + 1;
		Point punto = new Point(x, yAux);
		Integer energia = ambiente.getEnergiaPlanta();

		// si en la posicion adyacente se encuentra un zombie y tiene los soles para
		// matarlo entonces puede pelear
		if (ambiente.getZombies().containsKey(punto)
				&& ambiente.getZombies().get(punto).getEnergia() < energia) {

			ambiente.setEnergiaPlanta(energia - ambiente.getZombies().get(punto).getEnergia());

			ambiente.setCantidadZombies(ambiente.getCantidadZombies() - 1);
			// planta.setMatarZombie(1);
			ambiente.getZombies().remove(punto);

		}

		return ambiente;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "PelarArriba";
	}

}
