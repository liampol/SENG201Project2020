package GUIPackage;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import MainClassesPackage.*;

public class ChooseFarmType {

	private JFrame chooseFarmType;
	private static PaddockParadiseManager manager;
	private Farmer farmer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseFarmType window = new ChooseFarmType();
					window.chooseFarmType.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChooseFarmType() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		chooseFarmType = new JFrame();
		chooseFarmType.setTitle("Choose Farm Type");
		chooseFarmType.setBounds(100, 100, 731, 476);
		chooseFarmType.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chooseFarmType.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Speed Crops image");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(55, 76, 112, 72);
		chooseFarmType.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("AnimalWelfare Image");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(357, 76, 112, 72);
		chooseFarmType.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Money Tree Image");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(55, 258, 112, 72);
		chooseFarmType.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Thrift Farm Image");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(357, 258, 112, 72);
		chooseFarmType.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Please choose farm type:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(129, 22, 424, 43);
		chooseFarmType.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Speed Crop");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(55, 182, 112, 23);
		chooseFarmType.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Speed Crop Stats");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(177, 76, 170, 129);
		chooseFarmType.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("Animal Welfare");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(357, 182, 112, 23);
		chooseFarmType.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("Animal WelfareStats");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(479, 76, 170, 129);
		chooseFarmType.getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton_2 = new JButton("Money Tree");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(55, 352, 112, 23);
		chooseFarmType.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_7 = new JLabel("Money Tree Stats");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(177, 258, 170, 117);
		chooseFarmType.getContentPane().add(lblNewLabel_7);
		
		JButton btnNewButton_3 = new JButton("Thrift Farm");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setBounds(357, 352, 112, 23);
		chooseFarmType.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_8 = new JLabel("Thrift Farm Stats");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(479, 258, 170, 117);
		chooseFarmType.getContentPane().add(lblNewLabel_8);
	}
}
