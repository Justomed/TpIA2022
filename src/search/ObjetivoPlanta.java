package search;

import java.awt.Point;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class ObjetivoPlanta extends GoalTest {

	@Override
	public boolean isGoalState(AgentState agentState) {
		
		EstadoPlanta planta= (EstadoPlanta) agentState;
				
		
		if(planta.getPosicion().equals(new Point(8,4)) && planta.getZombies().isEmpty())   {
			return true;
		}
		
		return false;
	}

}
