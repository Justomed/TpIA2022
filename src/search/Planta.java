package search;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.solver.search.AStarSearch;
import frsf.cidisi.faia.solver.search.BreathFirstSearch;
import frsf.cidisi.faia.solver.search.DepthFirstSearch;
import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.Search;
import frsf.cidisi.faia.solver.search.UniformCostSearch;
import search.action.PelearAbajo;
import search.action.PelearArriba;
import search.action.PelearDerecha;
import search.action.PelearIzquierda;
import search.action.Plantar;
import search.action.irAbajo;
import search.action.irArriba;
import search.action.irDerecha;
import search.action.irIzquierda;

public class Planta extends SearchBasedAgent {

	// private EstadoPlanta estado;
	// private ObjetivoPlanta objetivo;

	public Planta() {

		// Objetivo de la planta
		ObjetivoPlanta objetivo = new ObjetivoPlanta();

		EstadoPlanta estado = new EstadoPlanta();

		this.setAgentState(estado);

		Vector<SearchAction> acciones = new Vector<SearchAction>();
		acciones.addElement(new Plantar());
		acciones.addElement(new irIzquierda());
		acciones.addElement(new irDerecha());
		acciones.addElement(new irAbajo());
		acciones.addElement(new irArriba());
		acciones.addElement(new PelearAbajo());
		acciones.addElement(new PelearArriba());
		acciones.addElement(new PelearIzquierda());
		acciones.addElement(new PelearDerecha());

		Problem problema = new Problem(objetivo, estado, acciones);

		this.setProblem(problema);

	}

	@Override
	public void see(Perception p) {
		this.getAgentState().updateState(p);
	}

	@Override
	public Action selectAction() {

		// BreathFirstSearch estrategia = new BreathFirstSearch ();
		// UniformCostSearch estrategia= new UniformCostSearch(new CostFunction());
		AStarSearch estrategia = new AStarSearch(new CostFunction(), new Heuristic());

		Search searchSolver = new Search(estrategia);

		// searchSolver.setVisibleTree(Search.XML_TREE);

		this.setSolver(searchSolver);

		Action selectedAction = null;
		try {
			selectedAction = this.getSolver().solve(new Object[] { this.getProblem() });
		} catch (Exception ex) {
			Logger.getLogger(Planta.class.getName()).log(Level.SEVERE, null, ex);
		}

		// Return the selected action
		return selectedAction;

	}

}
