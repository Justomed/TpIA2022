package search.action;

import java.awt.Point;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import search.EstadoAmbiente;
import search.EstadoPlanta;

public class Plantar extends SearchAction {

   private Double cost=1.1;
	
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		
		EstadoPlanta planta= (EstadoPlanta)s;
		
		Point punto= new Point(planta.getPosicion().x,planta.getPosicion().y);

		if(!planta.getGirasoles().containsKey(punto) && planta.getEnergia()>1 ) {
			
			
			
			
			planta.getGirasoles().put(punto, 6);
			planta.setEnergia(planta.getEnergia()-1);
		
			if(planta.getGirasoles().size()>5) {
				cost=100.0;
				
			}else {
				
				cost=-1.0;
			}
			
			
				
		}
	
		
	
		
		return planta;
	}

	@Override
	public Double getCost() {
	
		
		// TODO Auto-generated method stub
		return cost;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
	    
		EstadoPlanta planta= (EstadoPlanta)ast;
		EstadoAmbiente ambiente =(EstadoAmbiente) est;

		Point punto= new Point(ambiente.getPosicionPlanta().x,ambiente.getPosicionPlanta().y);

		if(!ambiente.getGirasoles().containsKey(punto) && ambiente.getEnergiaPlanta()>1) {
			
			ambiente.getGirasoles().put(punto, 0);
			ambiente.setEnergiaPlanta(ambiente.getEnergiaPlanta()-1);
			planta.getGirasoles().put(punto, 0);
			planta.setEnergia(ambiente.getEnergiaPlanta()-1);
		
			
		}
				
		return ambiente;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Plantar";
	}

}
