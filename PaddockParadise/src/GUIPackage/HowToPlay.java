package GUIPackage;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import baseutility.IntroductionManager;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HowToPlay {

	private JFrame howToPlayWindow;
	private static IntroductionManager manager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HowToPlay window = new HowToPlay(manager);
					window.howToPlayWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HowToPlay(IntroductionManager newManager) {
		manager = newManager;
		initialize();
		howToPlayWindow.setVisible(true);
	}
	private void finishedWindow() {
		manager.closeHowToPlayWindow(this);
	}
	private void previousHowToPlayWindow() {
		manager.openPreviousHowToPlayWindow(this);
	}
	
	public void closeWindow() {
		howToPlayWindow.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		howToPlayWindow = new JFrame();
		howToPlayWindow.setTitle("How To Play");
		howToPlayWindow.setBounds(100, 100, 701, 459);
		howToPlayWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		howToPlayWindow.getContentPane().setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.black);
		
		JLabel farmerBillImage = new JLabel("");
		farmerBillImage.setIcon(new ImageIcon(HowToPlay.class.getResource("/Images/newOldMAnCropped.jpg")));
		farmerBillImage.setBounds(27, 125, 187, 132);
		howToPlayWindow.getContentPane().add(farmerBillImage);
		
		JLabel howToPlayLbl = new JLabel("How To Play:");
		howToPlayLbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		howToPlayLbl.setHorizontalAlignment(SwingConstants.CENTER);
		howToPlayLbl.setBounds(249, 11, 215, 61);
		howToPlayWindow.getContentPane().add(howToPlayLbl);
		
		JLabel borderLbl = new JLabel("");
		borderLbl.setBounds(20, 69, 665, 291);
		borderLbl.setBorder(border);
		howToPlayWindow.getContentPane().add(borderLbl);
		
		JButton continueBtn = new JButton("Continue");
		continueBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		continueBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		continueBtn.setBounds(521, 371, 154, 41);
		continueBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		howToPlayWindow.getContentPane().add(continueBtn);
		
		JLabel instructLbl = new JLabel("<html>When you first start, you will have a set amount of money that you can use to purchase your first <i>'Crops', 'Animals', </i>and <i>'supplies'</i> from the Market,<br><br>Once your items have been purchased, you will be able to view the status of your animals and crops from your farm,<br><br>BEWARE make sure your prepared for odd occurences that happen, they could mean  the end. . . <br><br> Otherwise HAVE FUN!!\r\n ");
		instructLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		instructLbl.setBounds(224, 83, 440, 260);
		howToPlayWindow.getContentPane().add(instructLbl);
		
		JButton backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previousHowToPlayWindow();
			}
		});
		backBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		backBtn.setBounds(20, 371, 132, 41);
		backBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		howToPlayWindow.getContentPane().add(backBtn);
	}

}
