package interfaces;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import search.EstadoAmbiente;

public class Ventana extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     

	
	public Ventana(EstadoAmbiente e) {


		init(e);

	}

	public void init(EstadoAmbiente ambiente) {
		
		
		//PANEL PRINCIPAL
		JPanel panelPrincipal= new JPanel();
		panelPrincipal.setBounds(0, 0, 1100, 500);
     	panelPrincipal.setLayout(null);
		
     	
     	//DIBUJAR ZOMBIES
     	
     	ambiente.getZombies().forEach((k,v)->{
     		
     		JLabel zombie = new JLabel();
     		ImageIcon zombieIcon=null;
     		switch(v.getEnergia()) {
     		
     		case 1:
     			 zombieIcon = new ImageIcon("src/imagenes/zombie1.png");
     			break;
     		case 2:
     			 zombieIcon = new ImageIcon("src/imagenes/zombie2.png");
     			break;
     		case 3:
    			 zombieIcon = new ImageIcon("src/imagenes/zombie3.png");
    			break;
     		case 4:
    			 zombieIcon = new ImageIcon("src/imagenes/zombie4.png");
    			break;
     		case 5:
    			 zombieIcon = new ImageIcon("src/imagenes/zombie5.png");
    			break;
     		case 6:
    			 zombieIcon = new ImageIcon("src/imagenes/zombie6.png");
    			break;
    			
     		
     		
     		}
     		
     	
     		zombie.setIcon(new ImageIcon(zombieIcon.getImage().getScaledInstance(80, 80, 0)));
     		
     		
   		    zombie.setBounds(115*k.x, 100*k.y, 80, 80);
     		
   			panelPrincipal.add(zombie);
     		
     	});
     	
     	
		
		//DIBUJAR AGENTE
		JLabel planta = new JLabel();
		ImageIcon plantaIcon = new ImageIcon("src/imagenes/planta.png");
		
		planta.setIcon(new ImageIcon(plantaIcon.getImage().getScaledInstance(80, 80, 0)));
		planta.setBounds(ambiente.getPosicionPlanta().x*115, ambiente.getPosicionPlanta().y*100, 80, 80); // le sumo 70 en x para avanzar y 80 en y

		panelPrincipal.add(planta);
		
		
		
		
		//DIBUJAR GIRASOLES
		
		ambiente.getGirasoles().forEach((k,v)->{
			JLabel girasol = new JLabel();
     		ImageIcon girasolIcon= new ImageIcon("src/imagenes/girasol.png");
			
	        girasol.setIcon(new ImageIcon(girasolIcon.getImage().getScaledInstance(80, 80, 0)));
     		
     		
   		    girasol.setBounds(115*k.x, 100*k.y, 80, 80);
     		
   			panelPrincipal.add(girasol);
			
			
		});
		
		
		
		
		
		
		//FONDO
     	JLabel fondo = new JLabel();
		ImageIcon fondoIcon = new ImageIcon("src/imagenes/fondoJuego.png");
		fondo.setIcon(new ImageIcon(fondoIcon.getImage().getScaledInstance(panelPrincipal.getWidth(), panelPrincipal.getHeight(), 0)));
		fondo.setBounds(0, 0, 1200, 500);

		panelPrincipal.add(fondo);
		//CONFIGURACION VENTANA PRINCIPAL
		this.getContentPane().add(panelPrincipal);
		this.setSize(1100, 530);
	    this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		


	}
	
	
	public void actualizar(EstadoAmbiente estado) {
		
		this.getContentPane().removeAll();
		
		//PANEL PRINCIPAL
		JPanel panelPrincipal= new JPanel();
		panelPrincipal.setBounds(0, 0, 1100, 500);
     	panelPrincipal.setLayout(null);
		
     	
     	//DIBUJAR ZOMBIES
     	
     	estado.getZombies().forEach((k,v)->{
     		
     		JLabel zombie = new JLabel();
     		ImageIcon zombieIcon=null;
     		switch(v.getEnergia()) {
     		
     		case 1:
     			 zombieIcon = new ImageIcon("src/imagenes/zombie1.png");
     			break;
     		case 2:
     			 zombieIcon = new ImageIcon("src/imagenes/zombie2.png");
     			break;
     		case 3:
    			 zombieIcon = new ImageIcon("src/imagenes/zombie3.png");
    			break;
     		case 4:
    			 zombieIcon = new ImageIcon("src/imagenes/zombie4.png");
    			break;
     		case 5:
    			 zombieIcon = new ImageIcon("src/imagenes/zombie5.png");
    			break;
     		case 6:
    			 zombieIcon = new ImageIcon("src/imagenes/zombie6.png");
    			break;
    			
     		
     		
     		}
     		
     	
     		zombie.setIcon(new ImageIcon(zombieIcon.getImage().getScaledInstance(80, 80, 0)));
     		
     		
   		    zombie.setBounds(115*k.x, 100*k.y, 80, 80);
     		
   			panelPrincipal.add(zombie);
     		
   	
     	});
     	
     	
		
		//DIBUJAR AGENTE
     	JLabel planta = new JLabel();
		ImageIcon plantaIcon = new ImageIcon("src/imagenes/planta.png");
		
		planta.setIcon(new ImageIcon(plantaIcon.getImage().getScaledInstance(80, 80, 0)));
		planta.setBounds(estado.getPosicionPlanta().x*115, estado.getPosicionPlanta().y*100, 80, 80); // le sumo 70 en x para avanzar y 80 en y

		panelPrincipal.add(planta);
		
		
		
		
		//DIBUJAR GIRASOLES
		
		estado.getGirasoles().forEach((k,v)->{
			JLabel girasol = new JLabel();
     		ImageIcon girasolIcon= new ImageIcon("src/imagenes/girasol.png");
			
	        girasol.setIcon(new ImageIcon(girasolIcon.getImage().getScaledInstance(80, 80, 0)));
     		
     		
   		    girasol.setBounds(115*k.x, 100*k.y, 80, 80);
     		
   			panelPrincipal.add(girasol);
			
			
		});
		
		
		
		
		
		
		//FONDO
     	JLabel fondo = new JLabel();
		ImageIcon fondoIcon = new ImageIcon("src/imagenes/fondoJuego.png");
		fondo.setIcon(new ImageIcon(fondoIcon.getImage().getScaledInstance(panelPrincipal.getWidth(), panelPrincipal.getHeight(), 0)));
		fondo.setBounds(0, 0, 1200, 500);

		panelPrincipal.add(fondo);
		//CONFIGURACION VENTANA PRINCIPAL
		this.getContentPane().add(panelPrincipal);
		
	
	}
	


}
