package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Encuesta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JSlider slider;
	JLabel lblNewLabel_2;
	JRadioButton rbnWindows;
	JRadioButton rbnLinux;
	JRadioButton rbnMac;
	ButtonGroup bgroup;
	JCheckBox chckbxProgramacion;
	JCheckBox chckbxDiseñoGrafico;
	JCheckBox chckbxAdministracion;
	JButton btnMostrarDatos;

	public Encuesta() {

		// --------------------------- PANEL APLICACIÓN ---------------------------

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

		// Parámetros de la ventana principal de la aplicación
		setResizable(false);
		setTitle("Encuesta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// --------------------------- RADIO BUTTONS ---------------------------
		// Añadimos los radio buttons del SO preferido por el usuario

		rbnWindows = new JRadioButton("Windows");
		rbnWindows.setFont(new Font("Arial", Font.PLAIN, 20));
		rbnWindows.setBounds(83, 133, 188, 33);
		contentPane.add(rbnWindows);

		rbnLinux = new JRadioButton("Linux");
		rbnLinux.setFont(new Font("Arial", Font.PLAIN, 20));
		rbnLinux.setBounds(83, 169, 188, 33);
		contentPane.add(rbnLinux);

		rbnMac = new JRadioButton("Mac");
		rbnMac.setFont(new Font("Arial", Font.PLAIN, 20));
		rbnMac.setBounds(83, 205, 188, 33);
		contentPane.add(rbnMac);

		bgroup = new ButtonGroup();
		bgroup.add(rbnWindows);
		bgroup.add(rbnLinux);
		bgroup.add(rbnMac);

		// --------------------------- CHECKBOX ---------------------------
		// Añadimos los checkbox de las especialidades del usuario

		chckbxProgramacion = new JCheckBox("Programación");
		chckbxProgramacion.setFont(new Font("Arial", Font.PLAIN, 20));
		chckbxProgramacion.setBounds(455, 141, 222, 33);
		contentPane.add(chckbxProgramacion);

		chckbxDiseñoGrafico = new JCheckBox("Diseño Gráfico");
		chckbxDiseñoGrafico.setFont(new Font("Arial", Font.PLAIN, 20));
		chckbxDiseñoGrafico.setBounds(455, 177, 222, 33);
		contentPane.add(chckbxDiseñoGrafico);

		chckbxAdministracion = new JCheckBox("Administración");
		chckbxAdministracion.setFont(new Font("Arial", Font.PLAIN, 20));
		chckbxAdministracion.setBounds(455, 213, 222, 33);
		contentPane.add(chckbxAdministracion);

		// --------------------------- SLIDER ---------------------------
		// Añadimos el slider de las horas que le dedica al ordenador el usuario

		slider = new JSlider();
		slider.setValue(0);
		slider.setMaximum(10);
		slider.setFont(new Font("Arial", Font.BOLD, 20));
		slider.setBounds(83, 357, 549, 41);
		contentPane.add(slider);

		slider.addChangeListener(ch);

		// --------------------------- LABELS ---------------------------
		// Los diferentes campo de texto con títulos y enunciados

		JLabel lblNewLabel = new JLabel("Elige un sistema operativo:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 23));
		lblNewLabel.setBounds(83, 85, 362, 41);
		contentPane.add(lblNewLabel);

		JLabel lblEligeTuEspecialidad = new JLabel("Elige tu especialidad:");
		lblEligeTuEspecialidad.setFont(new Font("Arial", Font.PLAIN, 23));
		lblEligeTuEspecialidad.setBounds(455, 85, 362, 41);
		contentPane.add(lblEligeTuEspecialidad);

		JLabel lblNewLabel_1 = new JLabel("Horas dedicadas en el ordenador:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(83, 308, 362, 41);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("0 h");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(654, 357, 46, 41);
		contentPane.add(lblNewLabel_2);

		// --------------------------- BUTTON ---------------------------
		// Botón mostrar para consultar todos los datos añadidos por el usuario

		btnMostrarDatos = new JButton("Mostrar");
		btnMostrarDatos.setFont(new Font("Arial", Font.PLAIN, 20));
		btnMostrarDatos.setBounds(302, 441, 156, 50);
		contentPane.add(btnMostrarDatos);

		JLabel lblNewLabel_3 = new JLabel("MINI-ENCUESTA USUARIO");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel_3.setBounds(186, 26, 387, 41);
		contentPane.add(lblNewLabel_3);

		// Accion Listener del botón mostrar
		btnMostrarDatos.addActionListener(al);

		// Indicamos que se muestre la pantalla principal
		setVisible(true);
	}

	// --------------------------- SLIDER ARRASTRAR ---------------------------
	// Función del slider para ver por pantalla su valor en tiempo real (hroas
	// seleccionadas 0-10)

	ChangeListener ch = new ChangeListener() {
		public void stateChanged(ChangeEvent event) {
			lblNewLabel_2.setText(Integer.toString(slider.getValue()) + " h");
		}
	};

	// --------------------------- BUTTON HACER CLIC ---------------------------
	// Recogemos los datos introducidos por el usuario y creamos un campo de texto
	// que lo mostraremos por pantalla

	ActionListener al = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			boolean datosVaciosRB = true, datosVaciosCHB = true;
			JRadioButton[] btnSO = { rbnWindows, rbnLinux, rbnMac };
			JCheckBox[] chckbxEspecialidad = { chckbxProgramacion, chckbxDiseñoGrafico, chckbxAdministracion };
			String datosUsuario = "OPCIONES DEL USUARIO\nEl sistema operativo seleccionado: ";

			// Recorremos el array de radio buttons y mostramos el SO seleccionado
			for (int i = 0; i < btnSO.length; i++) {
				if (btnSO[i].isSelected()) {
					datosUsuario += "\n - " + btnSO[i].getText(); // Los añadimos a la cadena de texto
					datosVaciosRB = false; // Comprobación si hemos seleccionado una opción
				}
			}

			datosUsuario += "\nEspecialidades seleccionadas: ";

			// Recorremos el array de checkbox y mostramos las especialidades seleccionadas
			for (int i = 0; i < chckbxEspecialidad.length; i++) {
				if (chckbxEspecialidad[i].isSelected()) {
					datosUsuario += "\n - " + chckbxEspecialidad[i].getText(); // Los añadimos a la cadena de texto
					datosVaciosCHB = false; // Comprobación si hemos seleccionado al menos una opción
				}
			}

			// Recogemos el dato del slider de horas y lo añadimos a la cadena de texto
			datosUsuario += " \nHoras seleccionadas: " + slider.getValue();

			// Hacemos una comrpobación para seleccionar un radiobutton y al menos una checkbox
			if (!datosVaciosRB && !datosVaciosCHB) {
				// Mostramos por pantalla las opciones del usuario
				JOptionPane.showMessageDialog(contentPane, datosUsuario);
			} else {
				// Si no se cumple una de las condiciones mostramos un mesaje de error
				JOptionPane.showMessageDialog(contentPane, "NO SE HAN ELEGIDO TODAS LAS OPCIONES");
			}

		}
	};

}
