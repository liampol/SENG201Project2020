package GUIPackage;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import MainClassesPackage.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frameMainWindow;
	private static PaddockParadiseManager manager;
	private static Farm farm;
	private static Farmer farmer;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow(manager);
					window.frameMainWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow(PaddockParadiseManager newManager) {
		manager = newManager;
		farmer = manager.getFarmer();
		farm = manager.getFarm();
		initialize();
		frameMainWindow.setVisible(true);
	}
	
	private void viewFarm() {
		manager.openViewFarm();
	}
	
	private void openMarket() {
		manager.visitMarket();
	}
	
	public void closeWindow() {
		frameMainWindow.dispose();
	}
	
	private void finishedWindow() {
		manager.closeMainWindow(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameMainWindow = new JFrame();
		frameMainWindow.setTitle("Main Window");
		frameMainWindow.setBounds(100, 100, 767, 499);
		frameMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMainWindow.getContentPane().setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.black);
		
		JLabel farmerImage = new JLabel("");
		farmerImage.setIcon(new ImageIcon(MainWindow.class.getResource(farmer.getImageType())));
		farmerImage.setBounds(10, 11, 166, 122);
		farmerImage.setBorder(border);
		frameMainWindow.getContentPane().add(farmerImage);
		
		JLabel moneyLbl = new JLabel("Current Cash: $" + farm.getMoney());
		moneyLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		moneyLbl.setBounds(532, 70, 166, 21);
		frameMainWindow.getContentPane().add(moneyLbl);
		
		JLabel farmNameLbl = new JLabel("Farm Name: " + farm.getName());
		farmNameLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		farmNameLbl.setBounds(196, 31, 321, 28);
		frameMainWindow.getContentPane().add(farmNameLbl);
		
		JLabel farmTypeLbl = new JLabel("Farm Type: " + farm.getType());
		farmTypeLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		farmTypeLbl.setBounds(196, 66, 321, 28);
		frameMainWindow.getContentPane().add(farmTypeLbl);
		
		JLabel farmerNameLbl = new JLabel("Farmer Name: " + farmer.getName());
		farmerNameLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		farmerNameLbl.setBounds(196, 105, 312, 28);
		frameMainWindow.getContentPane().add(farmerNameLbl);
		
		JLabel viewFarmStatus = new JLabel("<html>View Status of the farm</html>");
		viewFarmStatus.setHorizontalAlignment(SwingConstants.CENTER);
		viewFarmStatus.setBounds(22, 176, 130, 118);
		frameMainWindow.getContentPane().add(viewFarmStatus);
		
		JButton viewFarmBtn = new JButton("View Farm");
		viewFarmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewFarm();
			}
		});
		viewFarmBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		viewFarmBtn.setBounds(20, 305, 132, 45);
		viewFarmBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		frameMainWindow.getContentPane().add(viewFarmBtn);
		
		JLabel performActionLbl = new JLabel("<html>Perform An Action</html>");
		performActionLbl.setHorizontalAlignment(SwingConstants.CENTER);
		performActionLbl.setBounds(198, 176, 130, 118);
		frameMainWindow.getContentPane().add(performActionLbl);
		
		JButton performActionBtn = new JButton("Perform Actions");
		performActionBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		performActionBtn.setBounds(196, 305, 142, 45);
		performActionBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		frameMainWindow.getContentPane().add(performActionBtn);
		
		JLabel visitMarketLbl = new JLabel("<html>Visit the Market</html>");
		visitMarketLbl.setHorizontalAlignment(SwingConstants.CENTER);
		visitMarketLbl.setBounds(365, 176, 152, 118);
		frameMainWindow.getContentPane().add(visitMarketLbl);
		
		JButton visitMarketBtn = new JButton("Open Market");
		visitMarketBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openMarket();
			}
		});
		visitMarketBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		visitMarketBtn.setBounds(365, 305, 152, 45);
		visitMarketBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		frameMainWindow.getContentPane().add(visitMarketBtn);
		
		JLabel skipDayLbl = new JLabel("Skip to next day");
		skipDayLbl.setHorizontalAlignment(SwingConstants.CENTER);
		skipDayLbl.setBounds(566, 176, 152, 118);
		frameMainWindow.getContentPane().add(skipDayLbl);
		
		JButton skipDayBtn = new JButton("Skip Day");
		skipDayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(frameMainWindow, "<html>Are you sure you want skip to next day?"
						+ "<br>Any <i>'UNUSED'</i> actions will be lost!","Choose Yes or No", JOptionPane.YES_NO_OPTION);
					if (choice == JOptionPane.YES_OPTION) {
						manager.skipDay();
						JOptionPane.showMessageDialog(frameMainWindow, "Welcome to the new day!", "Morning!", JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		skipDayBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		skipDayBtn.setBounds(566, 305, 152, 45);
		skipDayBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		frameMainWindow.getContentPane().add(skipDayBtn);
		
		JLabel questionLbl = new JLabel("<html>What would you like to do? <i>(Please choose an option)</i></html>");
		questionLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		questionLbl.setHorizontalAlignment(SwingConstants.CENTER);
		questionLbl.setBounds(63, 371, 608, 66);
		frameMainWindow.getContentPane().add(questionLbl);
		
		JLabel borderLbl = new JLabel("\r\n");
		borderLbl.setBounds(10, 149, 166, 211);
		borderLbl.setBorder(border);
		frameMainWindow.getContentPane().add(borderLbl);
		
		JLabel borderLbl1 = new JLabel("");
		borderLbl1.setBounds(186, 148, 160, 211);
		borderLbl1.setBorder(border);
		frameMainWindow.getContentPane().add(borderLbl1);
		
		JLabel borderLbl2 = new JLabel("");
		borderLbl2.setBounds(356, 148, 177, 211);
		borderLbl2.setBorder(border);
		frameMainWindow.getContentPane().add(borderLbl2);
		
		JLabel borderLbl3 = new JLabel("");
		borderLbl3.setBounds(543, 149, 198, 211);
		borderLbl3.setBorder(border);
		frameMainWindow.getContentPane().add(borderLbl3);
		
		JLabel days = new JLabel("Days Left: " + manager.getDays());
		days.setFont(new Font("Tahoma", Font.BOLD, 13));
		days.setBounds(532, 31, 137, 28);
		frameMainWindow.getContentPane().add(days);
		
		JLabel actions = new JLabel("Actions Left: " + manager.getActivitiesLeft() );
		actions.setFont(new Font("Tahoma", Font.BOLD, 13));
		actions.setBounds(532, 98, 209, 28);
		frameMainWindow.getContentPane().add(actions);
	}

}
