package view.dataTable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class NewItemDialogFrame extends JFrame {
	
    private int type;
	private JPanel contentPane;
	private JTextField textLic;
	private JTextField textTyp;
	private JTextField textBez;
	private JTextField textKm;
	private JTextField textChk;
	private JLabel lblFztyp;
	private JLabel lblHersteller;
	private JLabel lblKmstand;
	private JLabel lblNchsterFzcheck;
	
	
	
	public NewItemDialogFrame(int t) {
		this.type = t;
	}
	
	private void createLayoutCar() {
	}
	
	private void createLayoutCustomer() {
		
	}
	
	private boolean checkText(String text) {
		return text instanceof String;
		}
	
	private boolean checkNumbers(String text) {
		return true;
	}
	
	private boolean checkTextAndNumbers(String text) {
		return true;
	}
	
	private void submitCustomerData() {
		
	}
	
	private void submitCarData(){
		
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewItemDialogFrame frame = new NewItemDialogFrame();
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
	public NewItemDialogFrame() {
		setTitle("Bitte Fahrzeugdaten eingeben");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nikxx\\Desktop\\workspace\\FahrzeugVerleih\\resources\\hws.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 227, 203, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(223, 227, 201, 23);
		contentPane.add(btnNewButton_1);
		
		textLic = new JTextField();
		textLic.setBounds(150, 11, 274, 29);
		contentPane.add(textLic);
		textLic.setColumns(10);
		
		textTyp = new JTextField();
		textTyp.setColumns(10);
		textTyp.setBounds(150, 51, 274, 29);
		contentPane.add(textTyp);
		
		textBez = new JTextField();
		textBez.setColumns(10);
		textBez.setBounds(150, 91, 274, 29);
		contentPane.add(textBez);
		
		textKm = new JTextField();
		textKm.setColumns(10);
		textKm.setBounds(150, 131, 274, 29);
		contentPane.add(textKm);
		
		textChk = new JTextField();
		textChk.setColumns(10);
		textChk.setBounds(150, 171, 274, 29);
		contentPane.add(textChk);
		
		JLabel lblNewLabel = new JLabel("Kennzeichen");
		lblNewLabel.setBounds(58, 18, 82, 14);
		contentPane.add(lblNewLabel);
		
		lblFztyp = new JLabel("Fz-Typ");
		lblFztyp.setBounds(76, 58, 64, 14);
		contentPane.add(lblFztyp);
		
		lblHersteller = new JLabel("Hersteller");
		lblHersteller.setBounds(69, 98, 71, 14);
		contentPane.add(lblHersteller);
		
		lblKmstand = new JLabel("Km-Stand");
		lblKmstand.setBounds(61, 138, 79, 14);
		contentPane.add(lblKmstand);
		
		lblNchsterFzcheck = new JLabel("N\u00E4chster Fz-Check");
		lblNchsterFzcheck.setBounds(27, 178, 113, 14);
		contentPane.add(lblNchsterFzcheck);
	}
}
