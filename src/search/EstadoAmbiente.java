package search;

import java.awt.Point;
import java.util.HashMap;

import entidades.Zombie;
import frsf.cidisi.faia.state.EnvironmentState;

public class EstadoAmbiente extends EnvironmentState {

	// private Celda[][] grilla; // se va a ir actulizado para verlo por la interfaz
	private Integer energiaPlanta;
	private Point posicionPlanta;
	private HashMap<Point, Zombie> zombies; // En el point se guarda la posicion del zombie
	private HashMap<Point, Integer> girasoles;
	private Integer cantidadZombies;
	private boolean zombieLlego;

	public EstadoAmbiente() {
		initState();

	}

	@Override
	public void initState() {

		setEnergiaPlanta(20);
		posicionPlanta = new Point(2, 2);

		zombies = new HashMap<>(); // crear zombies y posiciones
		crearZombies(zombies);

		girasoles = new HashMap<>(); // girasoles que vaya colocando el agente

		zombieLlego = false;
	}

	private void crearZombies(HashMap<Point, Zombie> zombies) {

		cantidadZombies = 1; // numeroAleatorio(5,20); // un random

		for (int i = 0; i < cantidadZombies; i++) {

			Point punto = new Point();
			do {
				punto.setLocation(7, 4);// (numeroAleatorio(10,15),numeroAleatorio(0,4)); //punto aleatorio en la matriz
										// del lado no visible

			} while (zombies.containsKey(punto));// CONTROLA QUE NO HAYA PUNTOS REPETIDOS

			Integer tipoZombie = numeroAleatorio(1, 6);
			Zombie zombie = new Zombie(i, tipoZombie, numeroAleatorio(1, 3));

			zombies.put(punto, zombie);

		}
		zombies.put(new Point(0, 4), new Zombie(1, 3, 1));
		zombies.put(new Point(1, 0), new Zombie(2, 3, 1));
		zombies.put(new Point(7, 1), new Zombie(3, 3, 1));

	}

//	private void actualizarGrilla(Celda[][] grilla) {
//		
//		// aca se llenaria la grilla con las entidades
//		// despues nos va a facilitar hacer la interface 
//		
//		for(int i=0;i<30;i++) {
//			
//			Point punto = new Point();
//			punto.x=i;
//			for(int j=0;j<5;j++) {
//				punto.y=j;
//				
//				
//				if(posicionPlanta.equals(punto)) {
//					grilla[i][j]= Celda.PLANTA;
//				}
//				else if(zombies.containsKey(punto)) {
//					
//					grilla[i][j]= Celda.ZOMBIE;
//					
//					}
//				else if(girasoles.containsKey(punto)) {
//					
//					if(girasoles.get(punto) >0) { grilla[i][j]= Celda.GIRASOLYSOL;}
//					else { grilla[i][j]= Celda.GIRASOL;} 
//				}
//				else {
//					grilla[i][j]= Celda.VACIO;
//				}
//				
//				
//				
//				
//			}
//			
//			
//			
//			
//		}
//		
//		
//		
//	}

// como se van a ir moviendo los zombies
	public void actualizarZombies() {

		this.getZombies().forEach((k, v) -> {

			Integer aux = v.getContador() - 1;

			// si el contador es igual a 0 y la siguiente posicion no esta ocupada, el
			// zombie avanza
			if (aux == 0 && !this.getZombies().containsKey(new Point(k.x - 1, k.y))) {
				k.setLocation(k.x - 1, k.y);
				v.setContador(numeroAleatorio(1, 3));// volvemos a setear contador

				// Ver si el zombie queda en la posicion de un girasol o el agente

				if (this.getGirasoles().containsKey(k)) {
					// elimino el girasol
					this.getGirasoles().remove(k);
				}
				if (this.getPosicionPlanta().equals(k)) {

					// Le saco la energia al agente y lo envio al principio del mapa
					this.setPosicionPlanta(new Point(1, 1));// REEVER
					Integer energiaPlanta = this.getEnergiaPlanta();
					Integer energiaZombie = v.getEnergia() * 2;

					this.setEnergiaPlanta(energiaPlanta - energiaZombie);

				} else if (k.x == 0) {
					zombieLlego = true;
				}

			}
			// si el contador llega a 0 y la siguiente posicion esta ocupada
			else if (aux == 0) {
				v.setContador(numeroAleatorio(1, 3));// volvemos a setear el contador sin que el zombie avance
			}
			// si el contador todavia no llega a 0
			else {

				v.setContador(v.getContador() - 1);// disminuimos el contador en uno

			}

		});

	}

	// como van apareciendo los soles en los girasoles
	// entre uno y tres por ciclo de percepcion
	public void actualizarGirasoles() {

		this.getGirasoles().forEach((k, v) -> {

			// Sumo a cada girasol entre uno y tres soles por ciclo de percepcion
			this.getGirasoles().replace(k, v + numeroAleatorio(1, 3));

		});

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Posicion Actual: " + this.getPosicionPlanta().x + ";" + this.getPosicionPlanta().y + "\n"
				+ " Cantidad de zombies: " + this.getCantidadZombies() + "\n" + " Energía: " + this.getEnergiaPlanta()
				+ "\n " +

				"Zombies:" + this.getZombies() + "\n " + "Girasoles: " + this.getGirasoles();

	}

	private int numeroAleatorio(int min, int max) {
		int rango = max - min + 1;
		return (int) (Math.random() * rango) + min;
	}

	public Integer getEnergiaPlanta() {
		return energiaPlanta;
	}

	public void setEnergiaPlanta(Integer energiaPlanta) {
		this.energiaPlanta = energiaPlanta;
	}

	public Integer getCantidadZombies() {
		return cantidadZombies;
	}

	public void setCantidadZombies(Integer cantidadZombies) {
		this.cantidadZombies = cantidadZombies;
	}

//	public Celda[][] getGrilla() {
//		return grilla;
//	}
//
//	public void setGrilla(Celda[][] grilla) {
//		this.grilla = grilla;
//	}

	public Point getPosicionPlanta() {
		return posicionPlanta;
	}

	public void setPosicionPlanta(Point posicionPlanta) {
		this.posicionPlanta = posicionPlanta;
	}

	public HashMap<Point, Zombie> getZombies() {
		return zombies;
	}

	public void setZombies(HashMap<Point, Zombie> zombies) {
		this.zombies = zombies;
	}

	public HashMap<Point, Integer> getGirasoles() {
		return girasoles;
	}

	public void setGirasoles(HashMap<Point, Integer> girasoles) {
		this.girasoles = girasoles;
	}

	public boolean isZombieLlego() {
		return zombieLlego;
	}

	public void setZombieLlego(boolean zombieLlego) {
		this.zombieLlego = zombieLlego;
	}

}
