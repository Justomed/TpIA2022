package interfaces;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Principal {

	public static void main(String[] args) {

		JFrame ventana = new JFrame();

		JPanel panel = new JPanel();
		JLabel plantaImagen = new JLabel();
		JLabel fondo = new JLabel();
		JLabel zombieImagen = new JLabel();
		ImageIcon planta = new ImageIcon("src/imagenes/planta.png");
		ImageIcon bg = new ImageIcon("src/imagenes/fondoJuego.png");
		ImageIcon zombie = new ImageIcon("src/imagenes/zombie1.png");
		panel.setBounds(0, 0, 1100, 500);
		panel.setLayout(null);
		System.out.println(planta.getIconHeight() + " " + planta.getIconWidth());

		System.out.println(bg.getIconHeight() + " " + bg.getIconWidth());

		plantaImagen.setIcon(new ImageIcon(planta.getImage().getScaledInstance(80, 80, 0)));
		plantaImagen.setBounds(30, 10, 80, 80); // le sumo 70 en x para avanzar y 80 en y

		zombieImagen.setIcon(new ImageIcon(zombie.getImage().getScaledInstance(80, 80, 0)));
		zombieImagen.setBounds(950, 105, 80, 80);

		fondo.setIcon(new ImageIcon(bg.getImage().getScaledInstance(panel.getWidth(), panel.getHeight(), 0)));
		fondo.setBounds(0, 0, 1200, 500);

		panel.add(plantaImagen);
		panel.add(zombieImagen);
		panel.add(fondo);

		ventana.getContentPane().add(panel);
		ventana.setSize(1100, 530);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		ventana.setVisible(true);

		for (int i = 1; i < 9; i++) {
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			plantaImagen.setBounds(plantaImagen.getX() + 115, plantaImagen.getY(), 80, 80);
			zombieImagen.setBounds(zombieImagen.getX() - 115, zombieImagen.getY(), 80, 80);
		}

	}
}
