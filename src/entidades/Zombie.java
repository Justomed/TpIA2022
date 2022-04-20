package entidades;

public class Zombie {
	private Integer id;
	private Integer energia;
	private Integer contador;

	public Zombie(Integer id, Integer energia, Integer contador) {
		this.id = id;
		this.energia = energia;
		this.contador = contador;// random entre 1 y 3, determina la cantidad de ciclos para moverse
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEnergia() {
		return energia;
	}

	public void setEnergia(Integer energia) {
		this.energia = energia;
	}

	public Integer getContador() {
		return contador;
	}

	public void setContador(Integer contador) {
		this.contador = contador;
	}

	@Override
	public boolean equals(Object obj) {

		Zombie aux = (Zombie) obj;

		return aux.getId().equals(this.getId());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Zombie id: " + this.getId();
	}

}
