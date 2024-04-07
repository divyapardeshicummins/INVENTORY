package d1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;

public class Page2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page2 frame = new Page2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Page2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 25, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogin.setBounds(516, 433, 161, 57);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(448, 290, 143, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(448, 345, 143, 33);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(586, 293, 143, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(586, 348, 143, 33);
		contentPane.add(textField_1);
		
		ImageIcon icon=new ImageIcon("holic.jpg");
		JLabel logo = new JLabel(icon);
		logo.setBounds(0,0,175,115);
		contentPane.add(logo);
		
		JLabel l1 = new JLabel("	SamsthaStore.com");
		contentPane.add(l1);
    	l1.setBounds(175,0,1250,115);
    	l1.setFont(new Font ("Serif",Font.BOLD,52));
        l1.setForeground(Color.white);
        l1.setOpaque(true);
        l1.setBackground(Color.darkGray);
        
	}

}
