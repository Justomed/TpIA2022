package search;

import java.awt.Point;
import java.util.HashMap;

import entidades.Zombie;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class PlantaPerception extends Perception {

	// Tiene que percibir en todo momento como cambia la energia de los girasoles
	private HashMap<Point, Integer> girasoles;
	private HashMap<Point, Zombie> zombies;
	private Point posicion;
	private Integer energiaPlanta;
	private Integer cantidadZombies;

	public PlantaPerception() {
		zombies = new HashMap<Point, Zombie>();

	}

	@Override
	public void initPerception(Agent agent, Environment environment) {
		// TODO Auto-generated method stub

	}

	public HashMap<Point, Zombie> getZombies() {
		return zombies;
	}

	public void setZombies(HashMap<Point, Zombie> zombies) {
		this.zombies = zombies;
	}

	public Point getPosicion() {
		return posicion;
	}

	public void setPosicion(Point posicion) {
		this.posicion = posicion;
	}

	public HashMap<Point, Integer> getGirasoles() {
		return girasoles;
	}

	public void setGirasoles(HashMap<Point, Integer> girasoles) {
		this.girasoles = girasoles;
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

}
