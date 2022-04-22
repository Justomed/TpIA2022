package search.action;

import java.awt.Point;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import search.EstadoAmbiente;
import search.EstadoPlanta;

public class PelearDerecha extends SearchAction {

	
	
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		
		EstadoPlanta planta= (EstadoPlanta) s;
			
		Integer xAux= planta.getPosicion().x+1;
		Integer y=planta.getPosicion().y;
		Point punto=new Point(xAux,y);
		Integer energia=planta.getEnergia();
		
		
		//si en  la posicion adyacente se encuentra un zombie y tiene los soles para matarlo
		//entonces puede pelear
		if(planta.getZombies().containsKey(punto) 
				&& planta.getZombies().get(punto).getEnergia()<energia) {
			
			planta.setEnergia(energia-planta.getZombies().get(punto).getEnergia());
			planta.getZombies().remove(punto);
			planta.setCantidadZombies(planta.getCantidadZombies()-1);
			planta.setMatarZombie(0);
			
			
		}
	
		return planta;
	}

	@Override
	public Double getCost() {
		
		return 1.0;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {

		
		EstadoPlanta planta= (EstadoPlanta) ast;
		EstadoAmbiente ambiente=(EstadoAmbiente) est;
				
		
		Integer xAux= ambiente.getPosicionPlanta().x+1;
		Integer y=ambiente.getPosicionPlanta().y;
		Point punto=new Point(xAux,y);
		Integer energia=ambiente.getEnergiaPlanta();
		
		
		//si en  la posicion adyacente se encuentra un zombie y tiene los soles para matarlo
		//entonces puede pelear
		if(ambiente.getZombies().containsKey(punto) 
				&& ambiente.getZombies().get(punto).getEnergia()<energia) {
			
			ambiente.setEnergiaPlanta(energia-ambiente.getZombies().get(punto).getEnergia());
		
			ambiente.setCantidadZombies(ambiente.getCantidadZombies()-1);
			
		
			planta.setMatarZombie(1);
			ambiente.getZombies().remove(punto);
			
		}
		
	
		return ambiente;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "PelearDerecha";
	}
	
	

}
