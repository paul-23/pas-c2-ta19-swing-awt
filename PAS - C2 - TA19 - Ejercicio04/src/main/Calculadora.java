package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class Calculadora extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField operando1, operando2, resultado;
	private JButton restar, sumar, multiplicar, dividir;
	private JLabel titulo, texto1, texto2, result;
	private JMenuBar menuBar;
	private JMenu mnOpciones;
	private JMenuItem mntmSalir, mntmAbout;

	public Calculadora() {

		// Icono de la aplicación utilizando un una imagen de un enlace externo
		try {
			URL url = new URL("https://pauls23.000webhostapp.com/images/logo1.png");
			Image image = ImageIO.read(url);
			setIconImage(image);
		} catch (MalformedURLException ex) {
			System.out.println("Malformed URL");
		} catch (IOException iox) {
			System.out.println("Can not load file");
		}

		// Propiedades de la ventana de la aplicación
		getContentPane().setBackground(new Color(159, 198, 208));
		setResizable(false);
		setTitle("Mini Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().setLayout(null);

		// --------------------------- TEXT FIELDS ---------------------------
		// Campos donde introducimos los números o se muestra el resultado

		operando1 = new JTextField();
		operando1.setHorizontalAlignment(SwingConstants.CENTER);
		operando1.setFont(new Font("Arial", Font.PLAIN, 21));
		operando1.setBounds(74, 142, 190, 36);
		getContentPane().add(operando1);
		operando2 = new JTextField();
		operando2.setHorizontalAlignment(SwingConstants.CENTER);
		operando2.setFont(new Font("Arial", Font.PLAIN, 21));
		operando2.setBounds(74, 216, 190, 36);
		getContentPane().add(operando2);
		resultado = new JTextField();
		resultado.setHorizontalAlignment(SwingConstants.CENTER);
		resultado.setFont(new Font("Arial", Font.BOLD, 23));
		resultado.setBounds(74, 294, 190, 44);
		getContentPane().add(resultado);

		// --------------------------- BUTTONS ---------------------------
		// Los diferntes botones para seleccionar las operaciones (+, -, *, /)

		restar = new JButton("Restar");
		restar.setForeground(new Color(255, 255, 255));
		restar.setBackground(new Color(0, 102, 153));
		restar.setFont(new Font("Arial", Font.PLAIN, 21));
		restar.setBounds(171, 362, 130, 80);
		getContentPane().add(restar);
		restar.addActionListener(al);

		sumar = new JButton("Sumar");
		sumar.setForeground(new Color(255, 255, 255));
		sumar.setBackground(new Color(0, 102, 153));
		sumar.setFont(new Font("Arial", Font.PLAIN, 21));
		sumar.setBounds(31, 362, 130, 80);
		getContentPane().add(sumar);
		sumar.addActionListener(al);

		multiplicar = new JButton("Multiplicar");
		multiplicar.setForeground(new Color(255, 255, 255));
		multiplicar.setBackground(new Color(0, 102, 153));
		multiplicar.setFont(new Font("Arial", Font.PLAIN, 21));
		multiplicar.setBounds(31, 462, 130, 80);
		getContentPane().add(multiplicar);
		multiplicar.addActionListener(al);

		dividir = new JButton("Dividir");
		dividir.setForeground(new Color(255, 255, 255));
		dividir.setBackground(new Color(0, 102, 153));
		dividir.setFont(new Font("Arial", Font.PLAIN, 21));
		dividir.setBounds(171, 462, 130, 80);
		getContentPane().add(dividir);
		dividir.addActionListener(al);

		// --------------------------- LABELS ---------------------------
		// Títulos y nombres (campos de texto fijos)

		titulo = new JLabel("Mini Calculadora");
		titulo.setForeground(new Color(0, 102, 153));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 32));
		titulo.setBounds(31, 51, 270, 51);
		getContentPane().add(titulo);

		texto1 = new JLabel("Primer número");
		texto1.setFont(new Font("Arial", Font.PLAIN, 21));
		texto1.setBounds(74, 113, 190, 30);
		getContentPane().add(texto1);

		texto2 = new JLabel("Segundo número");
		texto2.setFont(new Font("Arial", Font.PLAIN, 21));
		texto2.setBounds(74, 183, 190, 30);
		getContentPane().add(texto2);

		result = new JLabel("Resultado: ");
		result.setFont(new Font("Arial", Font.PLAIN, 23));
		result.setBounds(74, 264, 190, 30);
		getContentPane().add(result);

		// --------------------------- MENÚ ---------------------------
		// Menú de opciones para mostrar el about o salir de aplicación

		menuBar = new JMenuBar();
		menuBar.setFont(new Font("Arial", Font.PLAIN, 20));
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setBounds(0, 0, 352, 30);
		getContentPane().add(menuBar);

		mnOpciones = new JMenu("Opciones");
		mnOpciones.setFont(new Font("Arial", Font.PLAIN, 20));
		menuBar.add(mnOpciones);

		mntmAbout = new JMenuItem("About");
		mntmAbout.setFont(new Font("Arial", Font.PLAIN, 20));
		mnOpciones.add(mntmAbout);
		mntmAbout.addActionListener(al);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setFont(new Font("Arial", Font.PLAIN, 20));
		mnOpciones.add(mntmSalir);
		
		mntmSalir.addActionListener(al);
		
		// Indicamos que se muestre la ventana
		setVisible(true);
	}

	// Método para identificar el botón pulsado y realizar una acción
	ActionListener al = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// Sumar
			if (e.getSource() == sumar) {
				int num1 = Integer.parseInt(operando1.getText());
				int num2 = Integer.parseInt(operando2.getText());
				int resul = num1 + num2;
				resultado.setText(String.valueOf(resul));
			}
			// Restar
			if (e.getSource() == restar) {
				int num1 = Integer.parseInt(operando1.getText());
				int num2 = Integer.parseInt(operando2.getText());
				int resul = num1 - num2;
				resultado.setText(String.valueOf(resul));
			}
			// Multiplicar
			if (e.getSource() == multiplicar) {
				int num1 = Integer.parseInt(operando1.getText());
				int num2 = Integer.parseInt(operando2.getText());
				int resul = num1 * num2;
				resultado.setText(String.valueOf(resul));
			}
			// Dividir
			if (e.getSource() == dividir) {
				int num1 = Integer.parseInt(operando1.getText());
				int num2 = Integer.parseInt(operando2.getText());
				int resul = num1 / num2;
				resultado.setText(String.valueOf(resul));
			}
			// Menu bar Salir
			if (e.getSource() == mntmSalir) {
				System.exit(0);
			}
			// Menu bar About
			if (e.getSource() == mntmAbout) {
				// Mensaje about
				JOptionPane.showMessageDialog(null, "Mensaje About Aplicación Calculadora");
			}
		}
	};
}
