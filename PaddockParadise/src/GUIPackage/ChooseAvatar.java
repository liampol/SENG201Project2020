package GUIPackage;

import baseutility.Setup1;
import MainClassesPackage.*;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChooseAvatar {

	private JFrame chooseAvatarWindow;
	private static PaddockParadiseManager manager;
	public Farmer newFarmer;
	private static Setup1 setup;

	/**
	 * "ChooseFarmer" window is open which allows the player to choose one avatar to play as through the game,
	 *      The player can choose from being a "FemaleFarmer", "MaleFarmer", or an "AlienFarmer".
	 *      NOTE: Avatars do not have special abilities or bonuses associated, they also do not change gameplay
	 *       
	 */
	public static void main(String[] args) {
		
		// implemented for testing
		PaddockParadiseManager manager = new PaddockParadiseManager();
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseAvatar window = new ChooseAvatar(setup);
					window.chooseAvatarWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChooseAvatar(Setup1 newSetup) {
		setup = newSetup;
		manager = setup.getManager();
		newFarmer = manager.getFarmer();
		initialize();
		chooseAvatarWindow.setVisible(true);
	}
	
	
	/*
	 * Confirms the choice of avatar from user and if the user does not want the chosen avatar, they are then prompted to re-choose
	 */
	public void farmerTypeConfirm() {
		int choice = JOptionPane.showConfirmDialog(chooseAvatarWindow, "Are you sure you want to be " + newFarmer.getType() + " ?", "Choose Yes or No", JOptionPane.YES_NO_OPTION);
		if (choice == JOptionPane.YES_OPTION) {
			finishedWindow();
		} else if (choice == JOptionPane.NO_OPTION) {                                            // Deleting Object created
			JOptionPane.showMessageDialog(chooseAvatarWindow, "Please re-choose Avatar");        // Re-choosing Farmer
			
		} else {
		JOptionPane.showMessageDialog(chooseAvatarWindow, "You need to select yes or no!", "Oops!", JOptionPane.ERROR_MESSAGE);
		farmerTypeConfirm();
		}
	}
	
	public void closeWindow() {
		chooseAvatarWindow.dispose();
	}
	
	public void finishedWindow() {
		setup.closeChooseAvatarScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		chooseAvatarWindow = new JFrame();
		chooseAvatarWindow.setTitle("Choose Avatar");
		chooseAvatarWindow.setBounds(100, 100, 784, 482);
		chooseAvatarWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chooseAvatarWindow.getContentPane().setLayout(null);
		
		JLabel femaleAvatar = new JLabel("");
		femaleAvatar.setIcon(new ImageIcon(ChooseAvatar.class.getResource("/Images/FemaleFarmerHeadResized.jpg")));
		femaleAvatar.setBounds(93, 137, 200, 164);
		chooseAvatarWindow.getContentPane().add(femaleAvatar);
		
		JLabel maleAvatar = new JLabel("");
		maleAvatar.setIcon(new ImageIcon(ChooseAvatar.class.getResource("/Images/MaleHead.jpg")));
		maleAvatar.setBounds(303, 126, 193, 175);
		chooseAvatarWindow.getContentPane().add(maleAvatar);
		
		JLabel alienAvatar = new JLabel("");
		alienAvatar.setIcon(new ImageIcon(ChooseAvatar.class.getResource("/Images/AlienResized.jpg")));
		alienAvatar.setBounds(506, 126, 193, 175);
		chooseAvatarWindow.getContentPane().add(alienAvatar);
		
		/**
		 * 
		 * Sets the farmerType to the chosen avatar of class Farmer to "Female Farmer"
		 *     which is then used to associate the avatar image to the farmer
		 */
		JButton femaleAvatarBtn = new JButton("Female Farmer");
		femaleAvatarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newFarmer.setType("Female Farmer");
				farmerTypeConfirm();
			}
		});
		femaleAvatarBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		femaleAvatarBtn.setBounds(119, 312, 125, 23);
		femaleAvatarBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		chooseAvatarWindow.getContentPane().add(femaleAvatarBtn);
		
		/**
		 * 
		 * Sets the farmerType to the chosen avatar of class Farmer to "Male Farmer"
		 *     which is then used to associate the avatar image to the farmer
		 */
		JButton maleAvatarBtn = new JButton("Male Farmer");
		maleAvatarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newFarmer.setType("Male Farmer");
				farmerTypeConfirm();
			}
		});
		maleAvatarBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		maleAvatarBtn.setBounds(348, 312, 115, 23);
		maleAvatarBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		chooseAvatarWindow.getContentPane().add(maleAvatarBtn);
		
		/**
		 * 
		 * Sets the farmerType to the chosen avatar of class Farmer to "Alien Farmer"
		 *     which is then used to associate the avatar image to the farmer
		 */
		JButton alienAvatarBtn = new JButton("Alien Farmer");
		alienAvatarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newFarmer.setType("Alien Farmer");
				farmerTypeConfirm();
				
			}
		});
		alienAvatarBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		alienAvatarBtn.setBounds(554, 312, 107, 23);
		alienAvatarBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		chooseAvatarWindow.getContentPane().add(alienAvatarBtn);
		
		JLabel chooseFarmerLbl = new JLabel("Please choose Farmer to play as:");
		chooseFarmerLbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		chooseFarmerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		chooseFarmerLbl.setBounds(119, 46, 542, 41);
		chooseAvatarWindow.getContentPane().add(chooseFarmerLbl);
		
	}
}
