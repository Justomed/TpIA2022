package search;

import java.awt.Point;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class ObjetivoPlanta extends GoalTest {

	@Override
	public boolean isGoalState(AgentState agentState) {
		
		EstadoPlanta planta= (EstadoPlanta) agentState;
				
	
		if((planta.getPosicion().equals(planta.getObjAux()) 
				&& planta.getZombies().isEmpty())// && planta.getGirasoles().size()>=5)
				|| planta.getCantidadZombies()==0) {
			return true;
		}
		
		return false;
	}

}
