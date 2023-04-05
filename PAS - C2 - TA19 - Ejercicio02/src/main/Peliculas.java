package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Peliculas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JComboBox<String> comboBox;

	/**
	 * Create the frame.
	 */
	public Peliculas() {

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

		// Indicamos las propiedades de la ventana
		setResizable(false);
		setTitle("Peliculas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Campo de texto (JLabel)
		JLabel lblNewLabel = new JLabel("Escribe el nombre de una película");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(42, 63, 348, 47);
		contentPane.add(lblNewLabel);

		// Campo (JTextField) para introducir el nombre de las películas
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 19));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(70, 121, 293, 47);
		contentPane.add(textField);
		textField.setColumns(10);

		// Botón para añadir las películas en el desplegable
		JButton btnNewButton = new JButton("Añadir");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton.setBounds(137, 179, 140, 47);
		contentPane.add(btnNewButton);

		// Campo de texto (JLabel)
		JLabel lblNewLabel_1 = new JLabel("Películas");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(504, 72, 271, 28);
		contentPane.add(lblNewLabel_1);

		// Desplegable con todas las películas añadidas
		comboBox = new JComboBox<>();
		comboBox.addItem("Películas");
		comboBox.setFont(new Font("Arial", Font.BOLD, 19));
		comboBox.setBounds(514, 119, 261, 49);
		contentPane.add(comboBox);

		// Listener para comprobar cuando hacemos clic en el botón
		// o pulsamos la tecla enter en el campo de texto
		btnNewButton.addActionListener(al);
		textField.addActionListener(al);

		// Mostramos la ventana
		setVisible(true);
	}

	ActionListener al = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// Comprobamos que el campo no esté vacio antes de enviar
			if (textField.getText().equals("")) {
				JOptionPane.showMessageDialog(contentPane, "NO SE HA INTRODUCIDO NINGUNA PELICULA"); // Mostramos mensaje de error
			} else {
				// Si no esta vacío lo añadimo en el desplegable
				comboBox.addItem(textField.getText());
				// Simulación de placeholder "Películas" en el desplegable
				// (en caso de que añadamos una película lo retiramos de la primera posición)
				if (comboBox.getItemCount() > 1 && comboBox.getItemAt(0).equals("Películas")) {
					comboBox.removeItem("Películas");
				}
				// Limpiamos el campo de texto una vez añadido al desplegable
				textField.setText("");
			}
		}
	};
}
