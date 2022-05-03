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
     			 zombieIcon = new ImageIcon("src/imagenes2/zombie1.jpeg");
     			break;
     		case 2:
     			 zombieIcon = new ImageIcon("src/imagenes2/zombie2.jpeg");
     			break;
     		case 3:
    			 zombieIcon = new ImageIcon("src/imagenes2/zombie3.jpeg");
    			break;
     		case 4:
    			 zombieIcon = new ImageIcon("src/imagenes2/zombie4.jpeg");
    			break;
     		case 5:
    			 zombieIcon = new ImageIcon("src/imagenes2/zombie5.jpeg");
    			break;
     		case 6:
    			 zombieIcon = new ImageIcon("src/imagenes2/zombie6.jpeg");
    			break;
    			
     		
     		
     		}
     		
     	
     		zombie.setIcon(new ImageIcon(zombieIcon.getImage().getScaledInstance(80, 80, 0)));
     		
     		
   		    zombie.setBounds(115*k.x, 100*k.y, 100, 100);
     		
   			panelPrincipal.add(zombie);
     		
     	});
     	
     	
		
		//DIBUJAR AGENTE
		JLabel planta = new JLabel();
		ImageIcon plantaIcon = new ImageIcon("src/imagenes2/planta.jpeg");
		
		planta.setIcon(new ImageIcon(plantaIcon.getImage().getScaledInstance(80, 80, 0)));
		planta.setBounds(ambiente.getPosicionPlanta().x*115, ambiente.getPosicionPlanta().y*100, 100, 100); // le sumo 70 en x para avanzar y 100 en y

		panelPrincipal.add(planta);
		
		

		JLabel energia = new JLabel();
		energia.setText("E: " + ambiente.getEnergiaPlanta());
		energia.setBounds((ambiente.getPosicionPlanta().x*115+70), ((ambiente.getPosicionPlanta().y )*100 +70 ), 120, 20); 
		
		JLabel zombies = new JLabel();
		zombies.setText("Z: " + ambiente.getCantidadZombies());
		zombies.setBounds((ambiente.getPosicionPlanta().x*115+70), ((ambiente.getPosicionPlanta().y )*100 +5  ), 120, 20); 
		
		
		

		panelPrincipal.add(energia);

		panelPrincipal.add(zombies);

		
		
		//DIBUJAR GIRASOLES
		
		ambiente.getGirasoles().forEach((k,v)->{
			JLabel girasol = new JLabel();
     		ImageIcon girasolIcon= new ImageIcon("src/imagenes2/girasol.jpeg");
			
	        girasol.setIcon(new ImageIcon(girasolIcon.getImage().getScaledInstance(80, 80, 0)));
     		
     		
   		    girasol.setBounds(115*k.x, 100*k.y, 100, 100);
     		
   			panelPrincipal.add(girasol);
			
			
		});
		
		
		
		
		
		
		//FONDO
     	JLabel fondo = new JLabel();
		ImageIcon fondoIcon = new ImageIcon("src/imagenes2/fondoJuego.jpeg");
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
     			 zombieIcon = new ImageIcon("src/imagenes2/zombie1.jpeg");
     			break;
     		case 2:
     			 zombieIcon = new ImageIcon("src/imagenes2/zombie2.jpeg");
     			break;
     		case 3:
    			 zombieIcon = new ImageIcon("src/imagenes2/zombie3.jpeg");
    			break;
     		case 4:
    			 zombieIcon = new ImageIcon("src/imagenes2/zombie4.jpeg");
    			break;
     		case 5:
    			 zombieIcon = new ImageIcon("src/imagenes2/zombie5.jpeg");
    			break;
     		case 6:
    			 zombieIcon = new ImageIcon("src/imagenes2/zombie6.jpeg");
    			break;
    			
     		
     		
     		}
     		
     	
     		zombie.setIcon(new ImageIcon(zombieIcon.getImage().getScaledInstance(80, 80, 0)));
     		
     		
   		    zombie.setBounds(115*k.x, 100*k.y, 100, 100);
     		
   			panelPrincipal.add(zombie);
     		
   	
     	});
     	
		
		//ENERGIA Y ZOMBIES RESTANTES
     	
				JLabel energia = new JLabel();
				energia.setText("E: " + estado.getEnergiaPlanta());
				energia.setBounds((estado.getPosicionPlanta().x*115+70), ((estado.getPosicionPlanta().y )*100 +70 ), 120, 20); 
				
				JLabel zombies = new JLabel();
				zombies.setText("Z: " + estado.getCantidadZombies());
				zombies.setBounds((estado.getPosicionPlanta().x*115+70), ((estado.getPosicionPlanta().y )*100 +5  ), 120, 20); 
				
				
				
		
				panelPrincipal.add(energia);

				panelPrincipal.add(zombies);
		
		//DIBUJAR AGENTE
     	JLabel planta = new JLabel();
		ImageIcon plantaIcon = new ImageIcon("src/imagenes2/planta.jpeg");
		
		planta.setIcon(new ImageIcon(plantaIcon.getImage().getScaledInstance(80, 80, 0)));
		planta.setBounds(estado.getPosicionPlanta().x*115, estado.getPosicionPlanta().y*100, 100, 100); // le sumo 70 en x para avanzar y 100 en y

		panelPrincipal.add(planta);

		
		
		
		
		//DIBUJAR GIRASOLES
		
		estado.getGirasoles().forEach((k,v)->{
			JLabel girasol = new JLabel();
     		ImageIcon girasolIcon= new ImageIcon("src/imagenes2/girasol.jpeg");
			
	        girasol.setIcon(new ImageIcon(girasolIcon.getImage().getScaledInstance(80, 80, 0)));
     		
     		
   		    girasol.setBounds(115*k.x, 100*k.y, 100, 100);
     		
   			panelPrincipal.add(girasol);
			
			
		});
		
		
		
		
		
		
		//FONDO
     	JLabel fondo = new JLabel();
		ImageIcon fondoIcon = new ImageIcon("src/imagenes2/fondoJuego.jpeg");
		fondo.setIcon(new ImageIcon(fondoIcon.getImage().getScaledInstance(panelPrincipal.getWidth(), panelPrincipal.getHeight(), 0)));
		fondo.setBounds(0, 0, 1200, 500);

		panelPrincipal.add(fondo);
		//CONFIGURACION VENTANA PRINCIPAL
		this.getContentPane().add(panelPrincipal);
		
	
	}
	


}
