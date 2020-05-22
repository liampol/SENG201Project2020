package GUIPackage;

import java.awt.Color;
import java.awt.EventQueue;
import GUIPackage.*;
import MainClassesPackage.*;
import javax.swing.JFrame;
import baseutility.*;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FarmerDetails {

	private JFrame farmerDetailsWindow;
	private static PaddockParadiseManager manager;
	private static Setup1 setup;
	private JTextField getsName;
	private JTextField getsAge;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FarmerDetails window = new FarmerDetails(setup);
					window.farmerDetailsWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FarmerDetails(Setup1 newSetup) {
		setup = newSetup;
		manager = setup.getManager();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		farmerDetailsWindow = new JFrame();
		farmerDetailsWindow.setTitle("FarmerDetailsWindow");
		farmerDetailsWindow.setBounds(100, 100, 685, 481);
		farmerDetailsWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		farmerDetailsWindow.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Farmer Details:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(106, 11, 445, 52);
		farmerDetailsWindow.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Please Enter Your Farmers Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 228, 228, 33);
		farmerDetailsWindow.getContentPane().add(lblNewLabel_1);
		
		JLabel nameInstructLbl = new JLabel("<html>(Name has to be between 3 and 15 characters and must NOT contain special characters and numbers)</html>");
		nameInstructLbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		nameInstructLbl.setBounds(10, 259, 265, 66);
		farmerDetailsWindow.getContentPane().add(nameInstructLbl);
		
		getsName = new JTextField();
		getsName.setBounds(248, 229, 346, 33);
		farmerDetailsWindow.getContentPane().add(getsName);
		getsName.setColumns(10);
		
		JLabel oldManImg = new JLabel("New label");
		oldManImg.setIcon(new ImageIcon(FarmerDetails.class.getResource("/Images/copy/newOldMAnCropped.jpg")));
		oldManImg.setBounds(25, 70, 192, 122);
		farmerDetailsWindow.getContentPane().add(oldManImg);
		
		JLabel lblNewLabel_4 = new JLabel("\r\n");
		lblNewLabel_4.setBounds(10, 57, 620, 161);
		Border border = BorderFactory.createLineBorder(Color.black);
		lblNewLabel_4.setBorder(border);
		farmerDetailsWindow.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Hi !");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(276, 65, 97, 42);
		farmerDetailsWindow.getContentPane().add(lblNewLabel_5);
		
		JLabel oldManSpeech = new JLabel("<html>Welcome to Paddock Paradise!<br> My Name is \"FARMER BILL\" !!,<br>\r\nBefore we start, I just need to grt a few details from you so please follow the instructions to the LETTER! or else. . . .<br>Have Fun!</html>");
		oldManSpeech.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		oldManSpeech.setBounds(227, 98, 386, 110);
		farmerDetailsWindow.getContentPane().add(oldManSpeech);
		
		JLabel ageInstruct = new JLabel("Please Enter Your Age:");
		ageInstruct.setFont(new Font("Tahoma", Font.BOLD, 13));
		ageInstruct.setBounds(10, 336, 207, 33);
		farmerDetailsWindow.getContentPane().add(ageInstruct);
		
		
		
		getsAge = new JTextField();
		getsAge.setBounds(248, 340, 125, 26);
		farmerDetailsWindow.getContentPane().add(getsAge);
		getsAge.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("<html>(Enter a age between 10 and 100)</html>");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_8.setBounds(10, 359, 228, 33);
		farmerDetailsWindow.getContentPane().add(lblNewLabel_8);
		
		JButton submitNameBtn = new JButton("Submit Name");
		submitNameBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getsName.setText(setText);
			}
		});
		submitNameBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		submitNameBtn.setBounds(248, 273, 125, 33);
		submitNameBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		farmerDetailsWindow.getContentPane().add(submitNameBtn);
		
		JButton submitAgeBtn = new JButton("Submit Age");
		submitAgeBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		submitAgeBtn.setBounds(248, 376, 125, 36);
		submitAgeBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		farmerDetailsWindow.getContentPane().add(submitAgeBtn);
	}
}
