package GUIPackage;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

import MainClassesPackage.PaddockParadiseManager;
import baseutility.Setup1;

import java.awt.Color;

public class WelcomeScreen {

	private JFrame welcomeWindow;
	private static PaddockParadiseManager manager;
	private static Setup1 setup;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeScreen window = new WelcomeScreen(setup);
					window.welcomeWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WelcomeScreen(Setup1 newSetup) {
		setup = newSetup;
		manager = setup.getManager();
		initialize();
		welcomeWindow.setVisible(true);
	}
	
	private void setDays(int day) {
		manager.setDays(day);
		finishedWindow();
	}
	
	
	public void closeWindow() {
		welcomeWindow.dispose();
	}
	
	private void finishedWindow() {
		setup.closeWelcomeScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		welcomeWindow = new JFrame();
		welcomeWindow.setTitle("Welcome");
		welcomeWindow.setBounds(100, 100, 619, 525);
		welcomeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcomeWindow.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(WelcomeScreen.class.getResource("/WelcomeMessage/Artboard 1.png")));
		lblNewLabel.setBounds(0, 0, 612, 425);
		welcomeWindow.getContentPane().add(lblNewLabel);
		
		JButton welcomeContinueBtn = new JButton("Continue to game");
		welcomeContinueBtn.addActionListener(new ActionListener() {
	/**
	 * Get the amount of days the user would like to play for
	 */
			public void actionPerformed(ActionEvent e) {
				
				String[] days = {"5", "6", "7", "8", "9", "10"};
				String daySelection =  (String) JOptionPane.showInputDialog(
				                    welcomeWindow,
				                    "Hi! Before we start " + "," + "how long would you like to play the game for?",
				                    "Days Selection",
				                    JOptionPane.PLAIN_MESSAGE,
				                    null,
				                    days,
				                    days[0]);

			
				if (daySelection == null) {
					JOptionPane.showMessageDialog(welcomeWindow, "You need to select a day!", "Oops!", JOptionPane.ERROR_MESSAGE);
					actionPerformed(e);
				}
				
				else {
					int day = Integer.parseInt(daySelection);
					setDays(day);
					finishedWindow();
				}
			}
		});
		
		welcomeContinueBtn.setFont(new Font("Tahoma", Font.BOLD, 25));
		welcomeContinueBtn.setBounds(310, 436, 283, 39);
		welcomeContinueBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		welcomeWindow.getContentPane().add(welcomeContinueBtn);
	}
}
