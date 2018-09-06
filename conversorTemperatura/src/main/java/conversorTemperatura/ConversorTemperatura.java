package conversorTemperatura;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ConversorTemperatura extends JFrame {

	private JPanel contentPane;
	private JTextField resultado;
	private JLabel lblFahrenheit;
	private JLabel lblCelcius;
	private JTextField valor;
	private JButton btnConverter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorTemperatura frame = new ConversorTemperatura();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConversorTemperatura() {
		setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		setIconImage(
				Toolkit.getDefaultToolkit().getImage("C:\\Users\\Knaak\\Pictures\\Saved Pictures\\icon - Copia.png"));
		setResizable(false);
		setForeground(Color.BLACK);
		setTitle("Conversor de Temperatura");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 154);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblFahrenheit = new JLabel("Fahrenheit");
		lblFahrenheit.setIconTextGap(5);
		lblFahrenheit.setForeground(Color.BLUE);
		lblFahrenheit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblFahrenheit.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblFahrenheit);

		valor = new JTextField();
		valor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				String caracteres = "0987654321-";
				if (!caracteres.contains(ev.getKeyChar() + "")) {
					ev.consume();
				}
			}
		});
		valor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(valor);
		valor.setColumns(10);

		lblCelcius = new JLabel("Celcius");
		lblCelcius.setForeground(Color.BLUE);
		lblCelcius.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblCelcius.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCelcius);

		resultado = new JTextField();
		resultado.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321-";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		resultado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(resultado);
		resultado.setColumns(10);

		btnConverter = new JButton("Converter");
		btnConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (valor.getText().length() > 0 && resultado.getText().length() > 0) {
					valor.setText("");
					resultado.setText("");
				} else if (valor.getText().trim().equals("") || valor.getText().trim().isEmpty()) {
					try {
						double celcius = Double.parseDouble(resultado.getText());
						double fahrenheit = (celcius * 1.8) + 32;
						valor.setText(fahrenheit + "ºF");
					} catch (Exception erro) {

					}
				} else {
					double fahrenheit = Double.parseDouble(valor.getText());
					double celcius = (fahrenheit - 32) / 1.8;
					resultado.setText(celcius + "°C");

				}
			}
		});
		btnConverter.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		btnConverter.setForeground(Color.RED);
		contentPane.add(btnConverter);
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valor.setText("");
				resultado.setText("");
			}
		});
		btnLimpar.setForeground(Color.RED);
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		contentPane.add(btnLimpar);
		contentPane.setLayout(new GridLayout(3, 2, 5, 5));
		 
	}

}