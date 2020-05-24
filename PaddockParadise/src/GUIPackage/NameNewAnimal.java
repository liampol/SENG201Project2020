package GUIPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;

import MainClassesPackage.Animal;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NameNewAnimal {

	private JFrame frmNameAnimal;
	private static Animal animal;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NameNewAnimal window = new NameNewAnimal(animal);
					window.frmNameAnimal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NameNewAnimal(Animal newAnimal) {
		animal = newAnimal;
		initialize();
		frmNameAnimal.setVisible(true);
		
	}
	
	public void closeWindow() {
		frmNameAnimal.dispose();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNameAnimal = new JFrame();
		frmNameAnimal.setTitle("Name Animal");
		frmNameAnimal.setBounds(100, 100, 577, 291);
		frmNameAnimal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNameAnimal.getContentPane().setLayout(null);
		
		JLabel inage = new JLabel("");
		inage.setIcon(new ImageIcon(NameNewAnimal.class.getResource("/Images/checkout.jpg")));
		inage.setBounds(10, 11, 114, 100);
		frmNameAnimal.getContentPane().add(inage);
		
		JLabel dialog = new JLabel("<html>What would you like to name your new ANIMAL?<br><i>(you can name it whatever you like)</i></html>");
		dialog.setFont(new Font("Tahoma", Font.BOLD, 18));
		dialog.setBounds(134, 11, 417, 100);
		frmNameAnimal.getContentPane().add(dialog);
		
		textField = new JTextField();
		textField.setBounds(10, 138, 541, 52);
		frmNameAnimal.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				animal.setName(name);
				closeWindow();
			}
		});
		confirm.setBounds(220, 201, 125, 34);
		Border border = BorderFactory.createRaisedBevelBorder();
		confirm.setBorder(border);
		frmNameAnimal.getContentPane().add(confirm);
	}
}
