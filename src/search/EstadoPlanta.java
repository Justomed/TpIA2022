package search;

import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;

import entidades.Zombie;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class EstadoPlanta extends SearchBasedAgentState {

	private Point posicion;
	private HashMap<Point, Integer> girasoles;
	private HashMap<Point, Zombie> zombies;
	private Integer cantidadZombies;
	private Integer matarZombie;
	private Integer energia;
	private Point objAux;




	public EstadoPlanta() {

		initState();
	}


	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof EstadoPlanta))
			return false;

		EstadoPlanta planta = (EstadoPlanta) obj;

		if (this.getCantidadZombies() == planta.getCantidadZombies() 
				&& this.getPosicion().equals(planta.getPosicion()) 
				&& this.getZombies().size()==planta.getZombies().size() 
				&& this.getGirasoles().size()== planta.getGirasoles().size()  
				&& this.getObjAux().equals(planta.getObjAux()) 
				&& this.getMatarZombie().equals(planta.getMatarZombie())
				&& this.getEnergia().equals(planta.getEnergia()))
				 {
		return true;
			
		}

		return false;
	}

	@Override
	public SearchBasedAgentState clone() {
		
		EstadoPlanta nuevoEstado= new EstadoPlanta();
		
		nuevoEstado.setCantidadZombies(this.getCantidadZombies());
		nuevoEstado.setEnergia(this.getEnergia());
		nuevoEstado.setPosicion(new Point(this.getPosicion().x,this.getPosicion().y));
		nuevoEstado.setObjAux(new Point(this.getObjAux().x,this.getObjAux().y));
		nuevoEstado.setMatarZombie(this.getMatarZombie());
		HashMap <Point,Zombie> zombies= new HashMap();
		HashMap <Point,Integer> girasoles= new HashMap();
		this.getZombies().forEach((k,v)->{
			
			Zombie z= new Zombie(v.getId(),v.getEnergia(),v.getContador());
			Point p= new Point(k.x,k.y);
			
			zombies.put(p, z);
			
			
			
		});
	
		
		this.getGirasoles().forEach((k,v)->{
			Point p= new Point(k.x,k.y);
			
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
		this.setZombies(percepcion.getZombies());
	

	}

	private void eliminarZombie(Zombie zombie) {

		Point punto=new Point();
		
		this.getZombies().forEach((k, v) -> {

			if (v.equals(zombie)) {

				punto.setLocation(k.x,k.y);

			}
		});
		this.getZombies().remove(punto);

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Posicion Actual: " + this.getPosicion().getX() + ";" + this.getPosicion().getY() + "\n"
				+ " Cantidad de zombies: " + this.getCantidadZombies() + "\n" + " Energía: " + this.getEnergia()
				+ "\n "+
				
				"Zombies:" + this.getZombies() + "\n "+
				"Girasoles: " + this.getGirasoles()+ "\n "+
				"Objetivo actual-> " + this.getObjAux().x + " : "+ this.getObjAux().y ;
	
	}

	@Override
	public void initState() {

		girasoles = new HashMap<Point, Integer>();
		zombies = new HashMap<Point, Zombie>();
		objAux=new Point(0,4);
		matarZombie=1;
	
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


	public Point getObjAux() {
		return objAux;
	}


	public void setObjAux(Point objAux) {
		this.objAux = objAux;
	}


	public Integer getMatarZombie() {
		return matarZombie;
	}


	public void setMatarZombie(Integer matarZombie) {
		this.matarZombie = matarZombie;
	}




	

}
