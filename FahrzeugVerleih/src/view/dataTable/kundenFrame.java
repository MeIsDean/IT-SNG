package view.dataTable;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class kundenFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kundenFrame frame = new kundenFrame();
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
	public kundenFrame() {
		setTitle("Bitte Kundendaten eingeben");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(10, 227, 199, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(225, 227, 199, 23);
		contentPane.add(btnCancel);
		
		textField = new JTextField();
		textField.setBounds(225, 23, 199, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(225, 79, 199, 23);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(225, 133, 199, 23);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(163, 27, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblVorname = new JLabel("Vorname");
		lblVorname.setBounds(143, 83, 66, 14);
		contentPane.add(lblVorname);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(143, 137, 66, 14);
		contentPane.add(lblAdresse);
	}

}
