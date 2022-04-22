package search;


import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class MainPlanta {
	

public static void main(String[] args) {
	
	
	
	Planta planta = new Planta();

    Ambiente ambiente = new Ambiente();

    SearchBasedAgentSimulator simulador = new SearchBasedAgentSimulator(ambiente, planta);
  
    simulador.start();
    
}
	

     
 
      
}
