package search;

import java.awt.Point;
import entidades.Zombie;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import interfaces.Ventana;

public class Ambiente extends Environment {

	private Ventana ventana;

	public Ambiente() {

		this.environmentState = new EstadoAmbiente();

		ventana = new Ventana(this.getEstadoAmbiente());
		ventana.setVisible(true);

	}

	public EstadoAmbiente getEstadoAmbiente() {

		return (EstadoAmbiente) super.getEnvironmentState();

	}

	@Override
	public Perception getPercept() {

		// Antes de enviar la percepcion actualizamos la posicion de los
		// zombies y girasoles
		this.getEstadoAmbiente().actualizarGirasoles();
		this.getEstadoAmbiente().setZombies(this.getEstadoAmbiente().actualizarZombies());

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Se crea la perception que se le va a enviar al agente
		PlantaPerception perception = new PlantaPerception();

		// Le enviamos cual es su posicion actual
		// preguntamos si los piso un zombie al agente
		if (this.getEstadoAmbiente().getZombies().containsKey(this.getEstadoAmbiente().getPosicionPlanta())) {

			Integer energiaZombie = this.getEstadoAmbiente().getZombies()
					.get(this.getEstadoAmbiente().getPosicionPlanta()).getEnergia();
			Integer energiaPlanta = this.getEstadoAmbiente().getEnergiaPlanta();

			// le restamos energia
			this.getEstadoAmbiente().setEnergiaPlanta(energiaPlanta - energiaZombie * 2);

			this.getEstadoAmbiente().setPosicionPlanta(new Point(0, 2));// lo manda al inicio

		}

		perception.setPosicion(this.getEstadoAmbiente().getPosicionPlanta());
		// miramos en todas las direcciones (si vemos un zombie se lo agregamos)
		vistaAbajo(perception);
		vistaIzquierda(perception);
		vistaArriba(perception);
		vistaDerecha(perception);

		// le mandamos la actualizacion de soles de los girasoles
		// Osea el zombie sabe el estado de los girasoles en todo momento
		perception.setGirasoles(this.getEstadoAmbiente().getGirasoles());
		perception.setCantidadZombies(this.getEstadoAmbiente().getCantidadZombies());
		perception.setEnergiaPlanta(this.getEstadoAmbiente().getEnergiaPlanta());

		ventana.actualizar(this.getEstadoAmbiente());
		ventana.repaint();
		return perception;
	}

	private void vistaAbajo(PlantaPerception p) {

		boolean visto = false;
		Integer x = p.getPosicion().x;
		Integer y = p.getPosicion().y;
		Integer yAux = y;
		// El metodo recorre en una direccion hasta encontrarse con un
		// zombie,limite o girasol
		while (!visto) {

			yAux--;

			Point punto = new Point(x, yAux);
			if (this.getEstadoAmbiente().getZombies().containsKey(punto) && yAux >= 0) {
				Zombie zombie = this.getEstadoAmbiente().getZombies().get(punto);
				p.getZombies().put(punto, zombie);
				visto = true;
			} else if (yAux == -1 || yAux == 5 || this.getEstadoAmbiente().getGirasoles().containsKey(punto)) {
				visto = true;
			}
		}

	}

	private void vistaArriba(PlantaPerception p) {
		boolean visto = false;
		Integer x = p.getPosicion().x;
		Integer y = p.getPosicion().y;

		Integer yAux = y;
		while (!visto) {

			yAux++;

			Point punto = new Point(x, yAux);
			if (this.getEstadoAmbiente().getZombies().containsKey(punto) && yAux <= 4) {
				Zombie zombie = this.getEstadoAmbiente().getZombies().get(punto);
				p.getZombies().put(punto, zombie);
				visto = true;
			} else if (yAux == -1 || yAux == 5 || this.getEstadoAmbiente().getGirasoles().containsKey(punto)) {
				visto = true;
			}
		}

	}

	private void vistaIzquierda(PlantaPerception p) {
		boolean visto = false;
		Integer x = p.getPosicion().x;
		Integer y = p.getPosicion().y;
		Integer xAux = x;
		while (!visto) {
			xAux--;
			Point punto = new Point(xAux, y);
			if (this.getEstadoAmbiente().getZombies().containsKey(punto) && xAux >= 0) {
				Zombie zombie = this.getEstadoAmbiente().getZombies().get(punto);
				p.getZombies().put(punto, zombie);
				visto = true;
			} else if (xAux == -1 || xAux == 9 || this.getEstadoAmbiente().getGirasoles().containsKey(punto)) {
				visto = true;
			}

		}

	}

	private void vistaDerecha(PlantaPerception p) {
		boolean visto = false;
		Integer x = p.getPosicion().x;
		Integer y = p.getPosicion().y;
		Integer xAux = x;
		while (!visto) {

			xAux++;

			Point punto = new Point(xAux, y);
			if (this.getEstadoAmbiente().getZombies().containsKey(punto) && xAux <= 8) {
				Zombie zombie = this.getEstadoAmbiente().getZombies().get(punto);
				p.getZombies().put(punto, zombie);
				visto = true;
			} else if (xAux == -1 || xAux == 9 || this.getEstadoAmbiente().getGirasoles().containsKey(punto)) {
				visto = true;
			}

		}

	}

	@Override
	public boolean agentFailed(Action actionReturned) {

		return (this.getEstadoAmbiente().getEnergiaPlanta() <= 0 || this.getEstadoAmbiente().sinPosibilidades()
				|| this.getEstadoAmbiente().isZombieLlego());
	}

	@Override
	public String toString() {

		return this.getEstadoAmbiente().toString();

	}

}
