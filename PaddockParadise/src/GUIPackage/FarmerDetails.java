package GUIPackage;

import java.awt.Color;


import java.awt.EventQueue;
import MainClassesPackage.*;
import javax.swing.JFrame;
import baseutility.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class FarmerDetails {

	private JFrame farmerDetailsWindow;
	private static PaddockParadiseManager manager;
	private static Farmer farmer;
	private static Setup1 setup;
	private JTextField getsName;
	private JTextField getsAge;
	Pattern letter = Pattern.compile("[a-zA-z]");
    Pattern nums = Pattern.compile("[0-9]");
    Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		// Implemented for testing
		
		
		
		
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
		farmer = manager.getFarmer();
		initialize();
		farmerDetailsWindow.setVisible(true);
	}
	
	
	private void confirmDetails() {
		
		boolean validName = checkNameInput();
		boolean validAge = checkAgeInput();
		int condition = 0;
		
		if (validName == false && validAge == false){
			condition = 1;
		}else if (validName == true && validAge == false) {
			condition = 2;
		}else if (validAge == true && validName == false) {
			condition = 3;
		}else {
			completeDetails();
		}
		// First checks if name is a valid input
		switch(condition) {
		case 1:
			// I both name and age is invalid
			JOptionPane.showMessageDialog(farmerDetailsWindow, "Sorry you entered a invalid name and age!\nPlease re-enter a valid name and age!", "Oops!", JOptionPane.ERROR_MESSAGE);
			break;
		case 2:
			// If age is invalid
			JOptionPane.showMessageDialog(farmerDetailsWindow, "Sorry you entered a invalid age!\nPlease re-enter a valid age!", "Oops!", JOptionPane.ERROR_MESSAGE);
			break;
		case 3:
			// If name is invalid
			JOptionPane.showMessageDialog(farmerDetailsWindow, "Sorry you entered a invalid name!\nPlease re-enter a valid name!", "Oops!", JOptionPane.ERROR_MESSAGE);
			break;
			}
	}
	
	private void completeDetails() {
		
		int choice = JOptionPane.showConfirmDialog(farmerDetailsWindow, "Are you sure you want\n" 
				+ "Farmer Name: " + farmer.getName() + "\n"
				+ "Farmer Age: " + farmer.getAge() ,"Choose Yes or No", JOptionPane.YES_NO_OPTION);
			if (choice == JOptionPane.YES_OPTION) {
				finishedWindow();
				}else if (choice == JOptionPane.NO_OPTION) {                                      
					JOptionPane.showMessageDialog(farmerDetailsWindow, "Please change details");       
				}else {
				JOptionPane.showMessageDialog(farmerDetailsWindow, "You need to select yes or no!", "Oops!", JOptionPane.ERROR_MESSAGE);
				}
				
	}
	
	private void finishedWindow() {
		setup.closeFarmerDetailsScreen(this);
	}
	
	public void closeWindow() {
		farmerDetailsWindow.dispose();
	}
	
	
	private boolean checkNameInput() {

		String newName = getsName.getText();

		boolean valid = false;
		Matcher hasNums = nums.matcher(newName);
		Matcher hasSpecial = special.matcher(newName);
		
		// Checks name
		if (!(hasNums.find() || hasSpecial.find() || newName.length() < 3 || newName.length() > 15)) {
			valid = true;
			farmer.setName(newName);
		}

		return valid;
	}
	
	private boolean checkAgeInput() {
		
		String newAge = getsAge.getText();
		boolean valid = false;

		Matcher hasSpecial = special.matcher(newAge);
		Matcher hasLetter = letter.matcher(newAge);
		
		// Checks age
		if (!(hasSpecial.find() || hasLetter.find())){
			valid = true;
		}

		//Convert string to int
		int age = 0;
		if (valid) {
			 age = Integer.parseInt(newAge);
		}
		//Checks to make sure int falls within parameters
		if (valid) {
			if (age >= 10 && age <= 100) {
				farmer.setAge(age);
			}else
				valid = false;
		}
		return valid;
		
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
		
		JLabel oldManSpeech = new JLabel("<html>Welcome to Paddock Paradise!<br> My Name is \"FARMER BILL\" !!,<br>\r\nBefore we start, I just need to get a few details from you so please follow the instructions to the LETTER! or else. . . .<br>Have Fun!</html>");
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
		

		JButton submitDetails = new JButton("Submit Details");
		submitDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmDetails();
			}
		});
		submitDetails.setFont(new Font("Tahoma", Font.BOLD, 13));
		submitDetails.setBounds(507, 389, 152, 42);
		submitDetails.setBorder(BorderFactory.createRaisedBevelBorder());
		farmerDetailsWindow.getContentPane().add(submitDetails);
	}
}
