package GUIPackage;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import MainClassesPackage.Animal;
import MainClassesPackage.Farm;
import MainClassesPackage.Farmer;
import MainClassesPackage.Market;
import MainClassesPackage.PaddockParadiseManager;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class FeedAnimalWindow {

	private JFrame currentAnimalFrame;
	private ArrayList<Animal> currentAnimals;
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
					FeedAnimalWindow window = new FeedAnimalWindow(manager);
					window.currentAnimalFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FeedAnimalWindow(PaddockParadiseManager newManager) {
		manager = newManager;
		farm = manager.getFarm();
		initialize();
		currentAnimalFrame.setVisible(true);
		
	}
	
	public void closeWindow() {
		currentAnimalFrame.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		currentAnimalFrame = new JFrame();
		currentAnimalFrame.setTitle("Feed Animal");
		currentAnimalFrame.setBounds(100, 100, 595, 250);
		currentAnimalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		currentAnimalFrame.getContentPane().setLayout(null);
		
		
		JLabel image = new JLabel("");
		image.setIcon(new ImageIcon(FeedAnimalWindow.class.getResource(farmer.getImageType())));
		image.setBounds(10, 11, 114, 100);
		currentAnimalFrame.getContentPane().add(image);
		
		JLabel dialog = new JLabel("<html>What animal should we Feed?</html>");
		dialog.setHorizontalAlignment(SwingConstants.CENTER);
		dialog.setFont(new Font("Tahoma", Font.BOLD, 22));
		dialog.setBounds(63, 11, 417, 100);
		currentAnimalFrame.getContentPane().add(dialog);
		

		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		confirm.setBounds(377, 122, 156, 38);
		Border border = BorderFactory.createRaisedBevelBorder();
		confirm.setBorder(border);
		currentAnimalFrame.getContentPane().add(confirm);
		
		
		JComboBox<Animal> animalBox = new JComboBox<Animal>();
		for (Animal animal : farm.getAnimals())
			animalBox.addItem(animal);
		animalBox.setBounds(36, 122, 270, 32);
		currentAnimalFrame.getContentPane().add(animalBox);
	}
}
