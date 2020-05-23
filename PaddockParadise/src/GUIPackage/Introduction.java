package GUIPackage;

import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;

import baseutility.IntroductionManager;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import MainClassesPackage.Farmer;
import MainClassesPackage.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Introduction {

	private JFrame introWindow;
	private static IntroductionManager manager;
	private static PaddockParadiseManager ppmManager;
	private static Farmer farmer;
	private static Farm farm;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Introduction window = new Introduction(manager);
					window.introWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Introduction(IntroductionManager newManager) {
		manager = newManager;
		ppmManager = manager.getManager();
		farmer = ppmManager.getFarmer();
		farm = ppmManager.getFarm();
		
		initialize();
		introWindow.setVisible(true);
		
	}
	
	private void finishedWindow() {
		manager.closeIntroductionWindow(this);
	}
	
	public void closeWindow() {
		introWindow.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		introWindow = new JFrame();
		introWindow.setTitle("Introduction");
		introWindow.setBounds(100, 100, 579, 322);
		introWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		introWindow.getContentPane().setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.black);
		
		JLabel farmerBillImageLbl = new JLabel("");
		farmerBillImageLbl.setIcon(new ImageIcon(Introduction.class.getResource("/Images/newOldMAnCropped.jpg")));
		farmerBillImageLbl.setBounds(32, 36, 193, 142);
		introWindow.getContentPane().add(farmerBillImageLbl);
		
		JLabel farmerBillSpeechLbl = new JLabel("<html><center>Hi,<br><br>They call me 'Farmer Bill',<br>You must be " + farmer.getName() + ",<br>You're  the one that inherited " + farm.getName() + " Farm from your grandfather.<br>Your grandfather and I were really closefriends,<br>So it'sonly fitting that I show you the ropes</center></html> ");
		farmerBillSpeechLbl.setHorizontalAlignment(SwingConstants.CENTER);
		farmerBillSpeechLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		farmerBillSpeechLbl.setBounds(223, 11, 281, 197);
		introWindow.getContentPane().add(farmerBillSpeechLbl);
		
		JLabel borderLbl = new JLabel("");
		borderLbl.setBounds(10, 11, 548, 216);
		borderLbl.setBorder(border);
		introWindow.getContentPane().add(borderLbl);
		
		JButton continueBtn = new JButton("Continue");
		continueBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		continueBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		continueBtn.setBounds(421, 238, 137, 40);
		continueBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		introWindow.getContentPane().add(continueBtn);
	}

}
