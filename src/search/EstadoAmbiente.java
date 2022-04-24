package search;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import entidades.Zombie;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.state.EnvironmentState;

public class EstadoAmbiente extends EnvironmentState {

	
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

		setEnergiaPlanta(numeroAleatorio(2, 20));
		posicionPlanta = new Point(0, 0);

		zombies = new HashMap<>(); // crear zombies y posiciones
		crearZombies(zombies);

		girasoles = new HashMap<>(); // girasoles que vaya colocando el agente

		zombieLlego = false;
	}

	private void crearZombies(HashMap<Point, Zombie> zombies) {

		cantidadZombies = numeroAleatorio(2, 20); // un random

		for (int i = 0; i < cantidadZombies; i++) {

			Point punto = new Point();
			do {
				punto.setLocation(numeroAleatorio(15, 40), numeroAleatorio(0, 4)); // punto aleatorio en la matriz del
																					// lado no visible

			} while (zombies.containsKey(punto));// CONTROLA QUE NO HAYA PUNTOS REPETIDOS

			Integer tipoZombie = numeroAleatorio(1, 6);
			Zombie zombie = new Zombie(i, tipoZombie, numeroAleatorio(1, 3));

			zombies.put(punto, zombie);

		}

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
	public HashMap<Point, Zombie> actualizarZombies() {

		HashMap<Point, Zombie> actualizacion = new HashMap<>();

		this.getZombies().forEach((k, v) -> {
			// FALTA CONTEMPLAR SI PISA UN GIRASOL,OTRO ZOMBIE O EL AGENTE

			Zombie nuevoZombie = new Zombie(v.getId(), v.getEnergia(), v.getContador() - 1);
			Point nuevoPunto = new Point(k.x, k.y);

			if (nuevoZombie.getContador() == 0) {

				if (!this.getZombies().containsKey(new Point(k.x - 1, k.y))) {
					nuevoPunto.setLocation(k.x - 1, k.y);
				}

				nuevoZombie.setContador(numeroAleatorio(1, 4));
			}

			if (nuevoPunto.x == 0) {
				zombieLlego = true;
			}
			if (this.getGirasoles().containsKey(nuevoPunto)) {

				this.getGirasoles().remove(nuevoPunto);
			}

			actualizacion.put(nuevoPunto, nuevoZombie);

		}

		);

		return actualizacion;

	}

	// como van apareciendo los soles en los girasoles
	// entre uno y tres por ciclo de percepcion
	public void actualizarGirasoles() {

		this.getGirasoles().forEach((k, v) -> {

			// Sumo a cada girasol entre uno y tres soles por ciclo de percepcion
			this.getGirasoles().replace(k, v + numeroAleatorio(1, 3));

		});

	}

	public Point obtenerObjetivo(Point puntoActual) {

		Point nuevoPunto = new Point();
		boolean valido = false;
		Integer numero;

		while (!valido) {

			numero = numeroAleatorio(1, 4);
			switch (numero) {
			case 1:
				if (puntoActual.x + 1 <= 8) {
					nuevoPunto.setLocation(puntoActual.x + 1, puntoActual.y);
					valido=true;
				}
				break;

			case 2:
				if (puntoActual.x - 1 >= 0) {

					nuevoPunto.setLocation(puntoActual.x - 1, puntoActual.y);
					valido=true;
				}
				break;

			case 3:
				if (puntoActual.y + 1 <= 4) {

					nuevoPunto.setLocation(puntoActual.x, puntoActual.y + 1);
					valido=true;
				}
				break;

			case 4:
				if (puntoActual.y - 1 >= 0) {

					nuevoPunto.setLocation(puntoActual.x, puntoActual.y -1);
					valido=true;
				}
				break;

			}

		}

		return nuevoPunto;

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
