package interfaces;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import search.EstadoAmbiente;

public class Ventana extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;

	public Ventana(EstadoAmbiente a) {

		initComponent(a);

	}

	public void initComponent(EstadoAmbiente ambiente) {

		JLabel imagen = new JLabel();

		imagen.setIcon(new ImageIcon("../imagenes/zombie1.png"));

		panel = new JPanel();
		panel.add(imagen);
		this.add(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

}
