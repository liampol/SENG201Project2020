package GUIPackage;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FarmName {

	private JFrame frmFarmName;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FarmName window = new FarmName();
					window.frmFarmName.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FarmName() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFarmName = new JFrame();
		frmFarmName.setTitle("Farm Name");
		frmFarmName.setBounds(100, 100, 496, 299);
		frmFarmName.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFarmName.getContentPane().setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.black);
		
		JLabel oldManImgLbl = new JLabel("");
		oldManImgLbl.setIcon(new ImageIcon(FarmName.class.getResource("/Images/newOldMAnCropped.jpg")));
		oldManImgLbl.setBounds(21, 21, 177, 122);
		frmFarmName.getContentPane().add(oldManImgLbl);
		
		JLabel borderLbl = new JLabel("");
		 borderLbl.setBounds(10, 11, 453, 143);
		 borderLbl.setBorder(border);
		frmFarmName.getContentPane().add( borderLbl);
		
		JLabel lblNewLabel_2 = new JLabel("<html>Farmer Bill:<br><br><em>What would you like to name your new Farm?</em></html>");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(208, 21, 240, 108);
		frmFarmName.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("<html>Enter your new Farm Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(20, 171, 188, 32);
		frmFarmName.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(208, 172, 255, 32);
		frmFarmName.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton continueBtn = new JButton("Continue\r\n");
		continueBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		continueBtn.setBounds(319, 215, 144, 34);
		continueBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		frmFarmName.getContentPane().add(continueBtn);
	}
}
