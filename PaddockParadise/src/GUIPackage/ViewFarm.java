package GUIPackage;

import java.awt.Color;
import java.awt.EventQueue;


import javax.swing.JFrame;

import MainClassesPackage.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.SwingConstants;


public class ViewFarm {

	private JFrame viewFarmWindow;
	private static PaddockParadiseManager manager;
	private static Farm farm;
	private static Farmer farmer;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
//		PaddockParadiseManager newerManager = new PaddockParadiseManager();
//		newerManager.openViewFarm();
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewFarm window = new ViewFarm(manager);
					window.viewFarmWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewFarm(PaddockParadiseManager newManager) {
		
		manager = newManager;
		farm = manager.getFarm();
		farmer = manager.getFarmer();
		initialize();
		viewFarmWindow.setVisible(true);
	}
	
	/**
	 * This method is called once the user is finished viewing the farms status
	 */
	public void finishedWindow() {
		manager.closeViewFarm(this);
	}
	
	
	/**
	 * This method is called from the PaddockPAradiseManager class to close this frame
	 */
	public void closeWindow() {
		viewFarmWindow.dispose();
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		viewFarmWindow = new JFrame();
		viewFarmWindow.setTitle("View Farm");
		viewFarmWindow.setBounds(100, 100, 980, 678);
		viewFarmWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewFarmWindow.getContentPane().setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.black);
		
		JButton closeBtn = new JButton("Close");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		closeBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		closeBtn.setBounds(780, 597, 164, 31);
		closeBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		viewFarmWindow.getContentPane().add(closeBtn);
		
		JLabel farmerImgLbl = new JLabel("");
		farmerImgLbl.setIcon(new ImageIcon(ViewFarm.class.getResource(farmer.getImageType())));
		farmerImgLbl.setBounds(28, 46, 131, 111);
		viewFarmWindow.getContentPane().add(farmerImgLbl);
		
		JLabel borderLbl = new JLabel("");
		borderLbl.setBounds(10, 11, 464, 160);
		borderLbl.setBorder(border);
		viewFarmWindow.getContentPane().add(borderLbl);
		
		JLabel farmerDetailsTitle = new JLabel("Farmer Details:");
		farmerDetailsTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		farmerDetailsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		farmerDetailsTitle.setBounds(169, 18, 169, 31);
		viewFarmWindow.getContentPane().add(farmerDetailsTitle);
		
		JLabel farmerDetails = new JLabel("<html>Name:<dynamic> <br><br>Age: 0 <br><br>Farmer Type: <dynamic>");
		farmerDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		farmerDetails.setBounds(171, 60, 274, 100);
		viewFarmWindow.getContentPane().add(farmerDetails);

		
		JLabel border3 = new JLabel("");
		border3.setBounds(10, 182, 298, 410);
		border3.setBorder(border);
		viewFarmWindow.getContentPane().add(border3);
		
		JLabel borderLbl2 = new JLabel("");
		borderLbl2.setBounds(480, 11, 464, 160);
		borderLbl2.setBorder(border);
		viewFarmWindow.getContentPane().add(borderLbl2);
		
		JLabel farmImage = new JLabel("");
		farmImage.setBounds(494, 21, 169, 136);
		farmImage.setIcon(new ImageIcon(ViewFarm.class.getResource(farm.getImageType())));
		viewFarmWindow.getContentPane().add(farmImage);
		
		JLabel farmDetailsTitle = new JLabel("Farm Details:");
		farmDetailsTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		farmDetailsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		farmDetailsTitle.setBounds(665, 21, 137, 31);
		viewFarmWindow.getContentPane().add(farmDetailsTitle);
		
		JLabel farmDetails = new JLabel("<html>Farm Name:<dynamic><br><br>Farm Type:<dynamic><br><br>Current Cash: $ 0.0</html>");
		farmDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		farmDetails.setBounds(675, 46, 257, 100);
		viewFarmWindow.getContentPane().add(farmDetails);
		
		JLabel cropsTitle = new JLabel("Crops:");
		cropsTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		cropsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		cropsTitle.setBounds(123, 199, 92, 16);
		viewFarmWindow.getContentPane().add(cropsTitle);
		
		JLabel cropsStatus = new JLabel("<html>" + farm.viewCropsStatus()+ "</html>");
		cropsStatus.setHorizontalAlignment(SwingConstants.LEFT);
		cropsStatus.setBounds(28, 226, 261, 353);
		viewFarmWindow.getContentPane().add(cropsStatus);
		
		JLabel borderLbl4 = new JLabel("");
		borderLbl4.setBounds(318, 182, 298, 410);
		borderLbl4.setBorder(border);
		viewFarmWindow.getContentPane().add(borderLbl4);
		
		JLabel suppliesTitle = new JLabel("Supplies:");
		suppliesTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		suppliesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		suppliesTitle.setBounds(429, 195, 116, 24);
		viewFarmWindow.getContentPane().add(suppliesTitle);
		
		JLabel suppliesStatus = new JLabel("<html> " + farm.viewSupplies()+ "</html>");
		suppliesStatus.setHorizontalAlignment(SwingConstants.LEFT);
		suppliesStatus.setBounds(335, 226, 269, 353);
		viewFarmWindow.getContentPane().add(suppliesStatus);
		
		JLabel borderLbl5 = new JLabel("");
		borderLbl5.setBounds(626, 182, 318, 411);
		borderLbl5.setBorder(border);
		viewFarmWindow.getContentPane().add(borderLbl5);
		
		JLabel animalsTitle = new JLabel("Animals:");
		animalsTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		animalsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		animalsTitle.setBounds(730, 201, 92, 14);
		viewFarmWindow.getContentPane().add(animalsTitle);
		
		JLabel animalsStatus = new JLabel("<html> " + farm.getAnimalsStatus()+ "</html>");
		animalsStatus.setHorizontalAlignment(SwingConstants.LEFT);
		animalsStatus.setBounds(634, 226, 298, 353);
		viewFarmWindow.getContentPane().add(animalsStatus);
	}
}
