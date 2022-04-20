package search;

import java.awt.Point;
import java.util.HashMap;

import entidades.Zombie;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class EstadoPlanta extends SearchBasedAgentState {

	private Point posicion;
	private HashMap<Point, Integer> girasoles;
	private HashMap<Point, Zombie> zombies;
	private Integer cantidadZombies;
	private Integer energia;

	public EstadoPlanta() {

		initState();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof EstadoPlanta))
			return false;

		EstadoPlanta planta = (EstadoPlanta) obj;

		if (this.getCantidadZombies() == planta.getCantidadZombies() && this.getEnergia() == planta.getEnergia()
				&& this.getPosicion().equals(planta.posicion) && this.getZombies().equals(planta.getZombies())
				&& this.getGirasoles().equals(planta.getGirasoles())) {
			return true;

		}

		return false;
	}

	@Override
	public SearchBasedAgentState clone() {

		EstadoPlanta nuevoEstado = new EstadoPlanta();

		nuevoEstado.setCantidadZombies(this.getCantidadZombies());
		nuevoEstado.setEnergia(this.getEnergia());
		nuevoEstado.setPosicion(new Point(this.getPosicion().x, this.getPosicion().y));

		HashMap<Point, Zombie> zombies = new HashMap<Point, Zombie>();
		HashMap<Point, Integer> girasoles = new HashMap<Point, Integer>();
		this.getZombies().forEach((k, v) -> {

			Zombie z = new Zombie(v.getId(), v.getEnergia(), v.getContador());
			Point p = new Point(k.x, k.y);

			zombies.put(p, z);

		});

		this.getGirasoles().forEach((k, v) -> {
			Point p = new Point(k.x, k.y);

			girasoles.put(p, v);

		});

		nuevoEstado.setZombies(zombies);
		nuevoEstado.setGirasoles(girasoles);

		return nuevoEstado;

	}

	@Override
	public void updateState(Perception p) {
		PlantaPerception percepcion = (PlantaPerception) p;

		this.setPosicion(percepcion.getPosicion());
		this.setGirasoles(percepcion.getGirasoles());
		this.setCantidadZombies(percepcion.getCantidadZombies());
		this.setEnergia(percepcion.getEnergiaPlanta());

		percepcion.getZombies().forEach((k, v) -> {
			if (this.getZombies().containsValue(v)) {
				eliminarZombie(v);
			} // lo elimino para despues agregarlo de nuevo con el nuevo punto
			this.getZombies().put(k, v);
		});

	}

	private void eliminarZombie(Zombie zombie) {

		Point punto = new Point();

		this.getZombies().forEach((k, v) -> {

			if (v.equals(zombie)) {

				punto.setLocation(k.x, k.y);

			}
		});
		this.getZombies().remove(punto);

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Posicion Actual: " + this.getPosicion().getX() + ";" + this.getPosicion().getY() + "\n"
				+ " Cantidad de zombies: " + this.getCantidadZombies() + "\n" + " Energía: " + this.getEnergia() + "\n "
				+

				"Zombies:" + this.getZombies() + "\n " + "Girasoles: " + this.getGirasoles();

	}

	@Override
	public void initState() {
		posicion = new Point(2, 2);
		girasoles = new HashMap<Point, Integer>();
		zombies = new HashMap<Point, Zombie>();

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

	public HashMap<Point, Zombie> getZombies() {
		return zombies;
	}

	public void setZombies(HashMap<Point, Zombie> zombies) {
		this.zombies = zombies;
	}

	public Integer getCantidadZombies() {
		return cantidadZombies;
	}

	public void setCantidadZombies(Integer cantidadZombies) {
		this.cantidadZombies = cantidadZombies;
	}

	public Integer getEnergia() {
		return energia;
	}

	public void setEnergia(Integer energia) {
		this.energia = energia;
	}

}
