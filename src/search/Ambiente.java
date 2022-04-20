package search;

import java.awt.Point;

import entidades.Zombie;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class Ambiente extends Environment {

	public Ambiente() {

		this.environmentState = new EstadoAmbiente();

	}

	public EstadoAmbiente getEstadoAmbiente() {

		return (EstadoAmbiente) super.getEnvironmentState();

	}

	@Override
	public Perception getPercept() {

		// Antes de enviar la percepcion actualizamos la posicion de los
		// zombies y girasoles
		// this.getEstadoAmbiente().actualizarGirasoles();
		// this.getEstadoAmbiente().actualizarZombies();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Se crea la perception que se le va a enviar al agente
		PlantaPerception perception = new PlantaPerception();

		// Le enviamos cual es su posicion actual
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
		return perception;
	}

	private void vistaAbajo(PlantaPerception p) {

		boolean visto = false;
		Integer x = p.getPosicion().x;
		Integer y = p.getPosicion().y;
		Integer yAux = y;
		// El metodo basicamente recorre en una direccion hasta encontrarse con un
		// zombie,limite o girasol
		while (!visto) {

			yAux--;

			Point punto = new Point(x, yAux);
			if (yAux == -1 || yAux == 5 || this.getEstadoAmbiente().getGirasoles().containsKey(punto)) {
				visto = true;
			}

			else if (this.getEstadoAmbiente().getZombies().containsKey(punto)) {

				Zombie zombie = this.getEstadoAmbiente().getZombies().get(punto);
				p.getZombies().put(punto, zombie);
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
			if (yAux == -1 || yAux == 5 || this.getEstadoAmbiente().getGirasoles().containsKey(punto)) {
				visto = true;
			}

			else if (this.getEstadoAmbiente().getZombies().containsKey(punto)) {

				Zombie zombie = this.getEstadoAmbiente().getZombies().get(punto);
				p.getZombies().put(punto, zombie);
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
			if (xAux == -1 || xAux == 10 || this.getEstadoAmbiente().getGirasoles().containsKey(punto)) {
				visto = true;
			}

			else if (this.getEstadoAmbiente().getZombies().containsKey(punto)) {
				System.out.println("ok");
				Zombie zombie = this.getEstadoAmbiente().getZombies().get(punto);
				p.getZombies().put(punto, zombie);
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
			if (xAux == -1 || xAux == 10 || this.getEstadoAmbiente().getGirasoles().containsKey(punto)) {
				visto = true;
			} else if (this.getEstadoAmbiente().getZombies().containsKey(punto)) {

				Zombie zombie = this.getEstadoAmbiente().getZombies().get(punto);
				p.getZombies().put(punto, zombie);
				visto = true;
			}

		}

	}

	@Override
	public boolean agentFailed(Action actionReturned) {

		return (this.getEstadoAmbiente().getEnergiaPlanta() <= 0 || this.getEstadoAmbiente().isZombieLlego());
	}

	@Override
	public String toString() {

		return this.getEstadoAmbiente().toString();

	}

}
