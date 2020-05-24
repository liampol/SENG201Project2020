package GUIPackage;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.Border;

import MainClassesPackage.Farm;
import MainClassesPackage.PaddockParadiseManager;
import baseutility.Setup1;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class FarmName {

	private JFrame farmNameWindow;
	private static Setup1 setup;
	private static PaddockParadiseManager manager;
	private static Farm farm;
    private Pattern nums = Pattern.compile("[0-9]");
    private Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
	
	private JTextField getFarmName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FarmName window = new FarmName(setup);
					window.farmNameWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application. an initializes attributes
	 */
	public FarmName(Setup1 newSetup) {
		setup = newSetup;
		manager = setup.getManager();
		farm = manager.getFarm();
		initialize();
		farmNameWindow.setVisible(true);
	}
	
	/**
	 * Once the Continue button is pressed, 
	 * the input is checked to see if it meets specifications
	 * 
	 * @return
	 */
	private void checkNameInput() {

		String newName = getFarmName.getText();
		Matcher hasNums = nums.matcher(newName);
		Matcher hasSpecial = special.matcher(newName);
		
		// Checks name
		if (!(hasNums.find() || hasSpecial.find() || newName.length() < 3 || newName.length() > 15)) {
			farm.setName(newName);
			completeDetails();
		}else {
			// If name is invalid
			JOptionPane.showMessageDialog(farmNameWindow, "Sorry you entered a invalid name!\nPlease re-enter a valid name!", "Oops!", JOptionPane.ERROR_MESSAGE);
			}
	}
	
	/**
	 * If input meets specifications, then user is asked if they are happy with there decision,
	 * if yes, then the window is closed
	 * If no then the the user is asked to re-enter input
	 */
	private void completeDetails() {
		
		int choice = JOptionPane.showConfirmDialog(farmNameWindow, "Are you sure you want\n" 
				+ "Farm Name: " + farm.getName(),"Choose Yes or No", JOptionPane.YES_NO_OPTION);
			if (choice == JOptionPane.YES_OPTION) {
				finishedWindow();
				}else if (choice == JOptionPane.NO_OPTION) {                                      
					JOptionPane.showMessageDialog(farmNameWindow, "Please change details");       
				}else {
				JOptionPane.showMessageDialog(farmNameWindow, "You need to select yes or no!", "Oops!", JOptionPane.ERROR_MESSAGE);
				}
				
	}
	
	/**
	 * Once user is happy with the name, this method is called which passes the setup back to the setup class
	 */
	public void finishedWindow() {
		setup.closeFarmNameWindow(this);
	}
	
	
	/**
	 * This method iscalled from the Setup class to close this frame
	 */
	public void closeWindow() {
		farmNameWindow.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		farmNameWindow = new JFrame();
		farmNameWindow.setTitle("Farm Name");
		farmNameWindow.setBounds(100, 100, 554, 330);
		farmNameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		farmNameWindow.getContentPane().setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.black);
		
		JLabel oldManImgLbl = new JLabel("");
		oldManImgLbl.setIcon(new ImageIcon(FarmName.class.getResource("/Images/newOldMAnCropped.jpg")));
		oldManImgLbl.setBounds(21, 21, 177, 122);
		farmNameWindow.getContentPane().add(oldManImgLbl);
		
		JLabel borderLbl = new JLabel("");
		 borderLbl.setBounds(10, 11, 518, 143);
		 borderLbl.setBorder(border);
		farmNameWindow.getContentPane().add( borderLbl);
		
		JLabel speechLbl = new JLabel("<html>Farmer Bill:<br><br>What would you like to name your new Farm?</html>");
		speechLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		speechLbl.setBounds(240, 21, 240, 108);
		farmNameWindow.getContentPane().add(speechLbl);
		
		JLabel nameInstructLl = new JLabel("<html>Enter your new Farm Name :");
		nameInstructLl.setFont(new Font("Tahoma", Font.BOLD, 13));
		nameInstructLl.setBounds(20, 171, 188, 32);
		farmNameWindow.getContentPane().add(nameInstructLl);
		
		getFarmName = new JTextField();
		getFarmName.setBounds(218, 172, 310, 32);
		farmNameWindow.getContentPane().add(getFarmName);
		getFarmName.setColumns(10);
		
		
		JButton continueBtn = new JButton("Continue\r\n");
		continueBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkNameInput();
				
			}
		});
		continueBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		continueBtn.setBounds(384, 246, 144, 34);
		continueBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		farmNameWindow.getContentPane().add(continueBtn);
		
		JLabel lblNewLabel = new JLabel("<html><i>(Please do not enter numbers or special characters,<br>Also keep longer than 3 characters but shorter than 15 characters)<i/></html>");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(21, 202, 187, 78);
		farmNameWindow.getContentPane().add(lblNewLabel);
	}
}
