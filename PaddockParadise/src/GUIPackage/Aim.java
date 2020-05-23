package GUIPackage;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import baseutility.*;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Aim {

	private JFrame aimWindow;
	private static IntroductionManager manager;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aim window = new Aim(manager);
					window.aimWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Aim(IntroductionManager newManager) {
		manager = newManager;
		initialize();
		aimWindow.setVisible(true);
	}

	private void finishedWindow() {
		manager.closeAimScreen(this);
	}
	
	private void previousWindow() {
		manager.openPreviousAimWindow(this);
	}
	
	public void closeWindow() {
		aimWindow.dispose();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		aimWindow = new JFrame();
		aimWindow.setTitle("How To Play");
		aimWindow.setBounds(100, 100, 736, 572);
		aimWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aimWindow.getContentPane().setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.black);
		
		JLabel lblNewLabel = new JLabel("How To Play:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(263, 11, 196, 60);
		aimWindow.getContentPane().add(lblNewLabel);
		
		JLabel farmerBillImage = new JLabel("New label");
		farmerBillImage.setIcon(new ImageIcon(Aim.class.getResource("/Images/newOldMAnCropped.jpg")));
		farmerBillImage.setBounds(25, 164, 196, 140);
		aimWindow.getContentPane().add(farmerBillImage);
		
		JLabel borderLbl = new JLabel("");
		borderLbl.setBounds(10, 71, 700, 404);
		borderLbl.setBorder(border);
		aimWindow.getContentPane().add(borderLbl);
		
		JButton continueBtn = new JButton("Continue");
		continueBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		continueBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		continueBtn.setBounds(572, 486, 138, 36);
		continueBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		aimWindow.getContentPane().add(continueBtn);
		
		JButton backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previousWindow();
			}
		});
		backBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		backBtn.setBounds(10, 486, 138, 36);
		backBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		aimWindow.getContentPane().add(backBtn);
		
		JLabel aimLbl = new JLabel("AIM:");
		aimLbl.setHorizontalAlignment(SwingConstants.CENTER);
		aimLbl.setFont(new Font("Tahoma", Font.BOLD, 25));
		aimLbl.setBounds(296, 82, 121, 36);
		aimWindow.getContentPane().add(aimLbl);
		
		JLabel lblNewLabel_1 = new JLabel("<html>* The aim of the game is to try increase the worth of your farm by ,<i>Growing Crops, </i>and<i> Looking After animals,</i><br>This is done by performing actions everyday, but <i>BEWARE,</i> you only get 2 actions to perform per day, ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(219, 120, 465, 96);
		aimWindow.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("<html> THIS IS A LIST OF YOUR ACTIONS:<br><br>*FEED A FARM ANIMAL: You can feed your animals using supplies purchased from the Market, this increase the Animals <i>Healthiness,</i><br><br>*PLAY WITH FARM ANIMALS: This increase the animals<i> happiness, </i><br><br>*TEND TO A CROP: This decreases the amount of days needed to wait before you can harvest your crops, BEWARE, You can only tend to one type of crop per day,<br><br>*TEND TO FARMLAND: This allows more crops to grow,<br><br>*HARVEST A CROP: Allows you to harvest and sell fully grown crops,");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(219, 215, 443, 248);
		aimWindow.getContentPane().add(lblNewLabel_2);
	}

}
