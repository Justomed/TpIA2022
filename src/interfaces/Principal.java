package interfaces;

import java.awt.Point;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entidades.Zombie;
import search.EstadoAmbiente;

public class Principal {

	public static void main(String[] args) {

		
		EstadoAmbiente e= new EstadoAmbiente();
		
		HashMap<Point,Zombie> zombies= new HashMap<>();
		HashMap<Point,Integer> girasoles= new HashMap<>();
		
		zombies.put(new Point(2,2),new Zombie(0, 2, 3));
		zombies.put(new Point(2,3),new Zombie(0, 1, 3));
		zombies.put(new Point(4,4),new Zombie(0, 3, 3));
		zombies.put(new Point(7,3),new Zombie(0, 4, 3));
		zombies.put(new Point(8,1),new Zombie(0, 5, 3));
		zombies.put(new Point(5,0),new Zombie(0, 6, 3));
		
		girasoles.put(new Point(0, 4),1);
		girasoles.put(new Point(0, 3),1);
		girasoles.put(new Point(0, 2),1);
		
		e.setGirasoles(girasoles);
		e.setZombies(zombies);
		
		
		Ventana ventana = new Ventana(e);
		
		
		
		
		ventana.setVisible(true);
//		JPanel panel = new JPanel();
//		JLabel plantaImagen = new JLabel();
//		JLabel fondo = new JLabel();
//		JLabel zombieImagen = new JLabel();
//		ImageIcon planta = new ImageIcon("src/imagenes/planta.png");
//		ImageIcon bg = new ImageIcon("src/imagenes/fondoJuego.png");
//		ImageIcon zombie = new ImageIcon("src/imagenes/zombie1.png");
//		panel.setBounds(0, 0, 1100, 500);
//		panel.setLayout(null);
//		System.out.println(planta.getIconHeight() + " " + planta.getIconWidth());
//
//		System.out.println(bg.getIconHeight() + " " + bg.getIconWidth());
//
//		plantaImagen.setIcon(new ImageIcon(planta.getImage().getScaledInstance(80, 80, 0)));
//		plantaImagen.setBounds(30, 10, 80, 80); // le sumo 70 en x para avanzar y 80 en y
//
//		zombieImagen.setIcon(new ImageIcon(zombie.getImage().getScaledInstance(80, 80, 0)));
//		zombieImagen.setBounds(950, 105, 80, 80);
//
//		fondo.setIcon(new ImageIcon(bg.getImage().getScaledInstance(panel.getWidth(), panel.getHeight(), 0)));
//		fondo.setBounds(0, 0, 1200, 500);
//
//		panel.add(plantaImagen);
//		panel.add(zombieImagen);
//		panel.add(fondo);
//
//		ventana.getContentPane().add(panel);
//		ventana.setSize(1100, 530);
//		ventana.setLocationRelativeTo(null);
//		ventana.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//
//		ventana.setVisible(true);
//
//		for (int i = 1; i < 9; i++) {
//			try {
//				Thread.sleep(500);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//			plantaImagen.setBounds(plantaImagen.getX() + 115, plantaImagen.getY(), 80, 80);
//			zombieImagen.setBounds(zombieImagen.getX() - 115, zombieImagen.getY(), 80, 80);
//		}

	}
}
