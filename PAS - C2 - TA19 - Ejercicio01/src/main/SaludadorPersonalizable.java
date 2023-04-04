package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class SaludadorPersonalizable extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombre;

	public SaludadorPersonalizable() {
		
		// Cambiamos el icono de la aplicación utilizando un una imagen de un enlace externo
		try {
        	URL url = new URL("https://pauls23.000webhostapp.com/images/logo1.png");
            Image image = ImageIO.read(url);
            setIconImage(image);
        } catch (MalformedURLException ex) {
            System.out.println("Malformed URL");
        } catch (IOException iox) {
            System.out.println("Can not load file");
        }
		
		setTitle("Saludador"); // Ponemos el título de la ventana de la aplicación
		setResizable(false); // Indicamos que no se puede modificar el tamaño de la ventana de la aplicación
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Indicamos que al cerrar la ventana se cierra la apliacción
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 153)); // Cambiamos el color de fondo del panel principal
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Cambiamos el valor del borde del panel principal

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escribe un nombre para saludar"); // Creamos un campo de texto con un mensaje
		lblNewLabel.setForeground(new Color(255, 255, 255)); // Cambiamos el color del texto anterior
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER); // Lo alineamos al centro
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22)); // Cambiamos la fuente y tamaño del texto
		lblNewLabel.setBounds(33, 56, 369, 34); // Le indicamo un tamaño del campo
		contentPane.add(lblNewLabel);
		
		nombre = new JTextField(); // Creamos un campo para introducir texto por teclado
		nombre.setHorizontalAlignment(SwingConstants.CENTER); // Lo alineamos al centro
		nombre.setFont(new Font("Arial", Font.BOLD, 20)); // Cambiamos la fuente y tamaño del texto
		nombre.setBounds(33, 109, 369, 41); // Le indicamo un tamaño del campo
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		JButton btnSaludar = new JButton("¡Saludar!"); // Creamos un botón con ell texto ¡Saludar!
		btnSaludar.setBackground(new Color(255, 255, 255)); // Cambiamos el color del texto anterior
		btnSaludar.setFont(new Font("Arial", Font.BOLD, 17)); // Cambiamos la fuente y tamaño del texto
		btnSaludar.setBounds(161, 184, 113, 34); // Le indicamo un tamaño del botón
		contentPane.add(btnSaludar);
		
		btnSaludar.addActionListener(al); // Creamos un listener para enviar una acción al hacer clic en el botón
		nombre.addActionListener(al); // Creamos un listener para enviar una acción al hacer al pulsar la tecla enter
		setVisible(true); // Lo hacemos visible para que se muestre por pantalla
	}
	
	// Cremos un metodo que no muestra un mensaje dentro de una alerta al pulsar el botón
	ActionListener al = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JLabel label = new JLabel("¡Hola " + nombre.getText() + "!");
			label.setFont(new Font("Arial", Font.BOLD, 18)); // Cambiamos la fuente y tamaño del texto
			JOptionPane.showMessageDialog(contentPane, label);
		}
	};
	
}
