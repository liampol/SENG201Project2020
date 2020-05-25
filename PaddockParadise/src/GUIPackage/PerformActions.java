package GUIPackage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import MainClassesPackage.Farm;
import MainClassesPackage.Farmer;
import MainClassesPackage.PaddockParadiseManager;

public class PerformActions {

	private JFrame performActionFrame;
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
					PerformActions window = new PerformActions(manager);
					window.performActionFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PerformActions(PaddockParadiseManager newManager) {
		manager = newManager;
		farmer = manager.getFarmer();
		farm = manager.getFarm();
		
		initialize();
		performActionFrame.setVisible(true);
	}
	private void launchFeedAnimal() {
		launchFeedAnimal(manager);
	}
	
	
	private void harvestCrops() {
		FeedAnimalWindow feedAnimalScreen = new FeedAnimalWindow(manager);
	}
	
	
	
	private void tendToLand() {
		manager.launchTendLand();
	}
	
	private void tendToCrops() {
		manager.launchTendCrops(manager);
	}
	
	private void playWithAnimal() {
		manager.launchPlayWithAnimal(manager);
	}

	public void closeWindow() {
		performActionFrame.dispose();
	}
	
	private void finishedWindow() {
		manager.closePerformActions(this);
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		performActionFrame = new JFrame();
		performActionFrame.setTitle("Perform Action");
		performActionFrame.setBounds(100, 100, 910, 673);
		performActionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Border border = BorderFactory.createLineBorder(Color.black);
		Border raiseBorder = BorderFactory.createRaisedBevelBorder();
		performActionFrame.getContentPane().setLayout(null);
		
	
		JLabel actionsTitle = new JLabel("<html>Perform Actions</html>");
		actionsTitle.setFont(new Font("Tahoma", Font.BOLD, 27));
		actionsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		actionsTitle.setBounds(243, 11, 407, 31);
		performActionFrame.getContentPane().add(actionsTitle);
		
		JLabel border1 = new JLabel("");
		border1.setFont(new Font("Tahoma", Font.BOLD, 13));
		border1.setBounds(10, 46, 874, 125);
		border1.setBorder(border);
		performActionFrame.getContentPane().add(border1);
		
		JLabel avatarDialog = new JLabel("<html>What Actions should we perform today?</html>");
		avatarDialog.setHorizontalAlignment(SwingConstants.CENTER);
		avatarDialog.setFont(new Font("Tahoma", Font.BOLD, 18));
		avatarDialog.setBounds(161, 60, 444, 102);
		performActionFrame.getContentPane().add(avatarDialog);
		
		JLabel avatarImg = new JLabel("");
		avatarImg.setIcon(new ImageIcon(PerformActions.class.getResource(farmer.getImageType())));
		avatarImg.setBounds(21, 60, 130, 102);
		performActionFrame.getContentPane().add(avatarImg);
		
		JLabel displayLbl = new JLabel("");
		displayLbl.setHorizontalAlignment(SwingConstants.CENTER);
		displayLbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		displayLbl.setBounds(10, 494, 879, 65);
		displayLbl.setBorder(border);
		displayLbl.setForeground(Color.green);
		performActionFrame.getContentPane().add(displayLbl);
		
		JButton closeBtn = new JButton("Close");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				
			}
		});
		closeBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		closeBtn.setBounds(707, 570, 182, 38);
		closeBtn.setBorder(raiseBorder);
		performActionFrame.getContentPane().add(closeBtn);
		
		JButton feedAnimBtn = new JButton("Feed Animal");
		feedAnimBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchFeedAnimal();
				manager.feedAnimal();
				displayLbl.setForeground(Color.green);
				displayLbl.setText("Carrots has been added to cart!");
			}
		});
		feedAnimBtn.setBounds(55, 279, 182, 33);
		feedAnimBtn.setBorder(raiseBorder);
		performActionFrame.getContentPane().add(feedAnimBtn);
		
		JButton playWithAnimalBtn = new JButton("Play With Farm Animal");
		playWithAnimalBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.playWithAnimal();
				displayLbl.setForeground(Color.green);
				displayLbl.setText("");
			}
		});
		playWithAnimalBtn.setBounds(378, 349, 167, 33);
		playWithAnimalBtn.setBorder(raiseBorder);
		performActionFrame.getContentPane().add(playWithAnimalBtn);
		
		JButton tendLAndBtn = new JButton("Tend Land");
		tendLAndBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.tendLand();
				displayLbl.setForeground(Color.green);
				displayLbl.setText("");
			}
		});
		tendLAndBtn.setBounds(55, 436, 182, 31);
		tendLAndBtn.setBorder(raiseBorder);
		performActionFrame.getContentPane().add(tendLAndBtn);
		
		JButton harvestBtn = new JButton("Harvest A Crop");
		harvestBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.harvestCrops();
				displayLbl.setForeground(Color.green);
				displayLbl.setText("");
			}
		});
		harvestBtn.setBounds(668, 436, 167, 31);
		harvestBtn.setBorder(raiseBorder);
		performActionFrame.getContentPane().add(harvestBtn);
		
		JButton tendCropBtn = new JButton("Tend to a Crop");
		tendCropBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.tendCrops();
				displayLbl.setForeground(Color.green);
				displayLbl.setText("");
				
			}
		});
		tendCropBtn.setBounds(668, 279, 167, 33);
		tendCropBtn.setBorder(raiseBorder);
		performActionFrame.getContentPane().add(tendCropBtn);
		
		JLabel feedAnimalBorder = new JLabel("");
		feedAnimalBorder.setBounds(10, 182, 291, 145);
		feedAnimalBorder.setBorder(border);
		performActionFrame.getContentPane().add(feedAnimalBorder);
		
		JLabel happyAnimalBorder = new JLabel("");
		happyAnimalBorder.setFont(new Font("Tahoma", Font.BOLD, 13));
		happyAnimalBorder.setBounds(311, 243, 294, 161);
		happyAnimalBorder.setBorder(border);
		performActionFrame.getContentPane().add(happyAnimalBorder);
		
		JLabel cauliBorder = new JLabel();
		cauliBorder.setBounds(10, 338, 291, 145);
		cauliBorder.setBorder(border);
		performActionFrame.getContentPane().add(cauliBorder);
		
		JLabel tendCropBorder = new JLabel("");
		tendCropBorder.setBounds(617, 182, 272, 145);
		tendCropBorder.setBorder(border);
		performActionFrame.getContentPane().add(tendCropBorder);
		
		JLabel harvestCropBorder = new JLabel("");
		harvestCropBorder.setBounds(617, 338, 267, 145);
		harvestCropBorder.setBorder(border);
		performActionFrame.getContentPane().add(harvestCropBorder);
		
		JLabel feedAnimalStat = new JLabel("Increases the animals healthiness");
		feedAnimalStat.setHorizontalAlignment(SwingConstants.CENTER);
		feedAnimalStat.setFont(new Font("Tahoma", Font.BOLD, 13));
		feedAnimalStat.setBounds(21, 196, 267, 72);
		performActionFrame.getContentPane().add(feedAnimalStat);
		
		JLabel playWithAnimalStat = new JLabel("Increases the animals happiness");
		playWithAnimalStat.setHorizontalAlignment(SwingConstants.CENTER);
		playWithAnimalStat.setFont(new Font("Tahoma", Font.BOLD, 13));
		playWithAnimalStat.setBounds(349, 266, 239, 72);
		performActionFrame.getContentPane().add(playWithAnimalStat);
		
		JLabel tendToCropStat = new JLabel("<html>Decreases the time until it can be harvested</html>");
		tendToCropStat.setHorizontalAlignment(SwingConstants.CENTER);
		tendToCropStat.setFont(new Font("Tahoma", Font.BOLD, 13));
		tendToCropStat.setBounds(626, 196, 248, 72);
		performActionFrame.getContentPane().add(tendToCropStat);
		
		JLabel tendLandStat = new JLabel("Allows more crops to be grown");
		tendLandStat.setHorizontalAlignment(SwingConstants.CENTER);
		tendLandStat.setFont(new Font("Tahoma", Font.BOLD, 13));
		tendLandStat.setBounds(28, 351, 260, 82);
		performActionFrame.getContentPane().add(tendLandStat);
		
		JLabel harvestCropStat = new JLabel("<html>Harvest and sell a fully grown crop</html>");
		harvestCropStat.setHorizontalAlignment(SwingConstants.CENTER);
		harvestCropStat.setFont(new Font("Tahoma", Font.BOLD, 13));
		harvestCropStat.setBounds(626, 352, 248, 72);
		performActionFrame.getContentPane().add(harvestCropStat);
	}

}
