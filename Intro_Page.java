package d1;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;


public class Intro_Page extends JFrame {

	private JPanel contentPane;
	
	public static void main(String[] args) {
		
		Connection conn=null;
		ResultSet rs=null;	
		PreparedStatement pst=null;
		Statement stmt = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/trial","root","root");
			System.out.println("Connection Succeded..............................");
			stmt=conn.createStatement();
			
			System.out.println("Database contains:");
			String query = "select * from admin" ;
			System.out.println("");
			rs= pst.executeQuery(query);
			
			while(rs.next())
			{
				int id=rs.getInt("admin_id");
				String uname=rs.getString("username");
				String pwd=rs.getString("password");
				
				System.out.println("id : "+id+" \nusername : "+uname+" \npassword : "+pwd);

			}
		}
		catch(Exception e) {
			
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Intro_Page frame = new Intro_Page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Intro_Page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 25, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(215, 187, 245));
		contentPane.setBounds(new Rectangle(800, 1000, 1000, 800));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("WELCOME TO THE SAMSTHA STORE",JLabel.CENTER);
		
    	
    	
		title.setName("title");
		title.setBounds(391,0,900,85);
        title.setFont(new Font ("Serif",Font.BOLD,48));
        title.setForeground(Color.black);
        title.setOpaque(true);
        title.setBackground(new Color(188, 127, 205)); //MAGENTA , darkGray ,
		
		contentPane.add(title);
		
		ImageIcon img=new ImageIcon("C:\\Users\\Divya\\Desktop\\project\\project1\\images.jpg");
		int w=img.getIconWidth();
    	int h=img.getIconHeight();
    	setPreferredSize(new Dimension(w,h));
		JLabel i3 = new JLabel(img);
		i3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		i3.setBackground(Color.GRAY);
		
		i3.setBounds(0, 0, 391, 398);
		contentPane.add(i3);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(188, 127, 205));
		panel.setBounds(0, 396, 391, 900); // Increase the height to 600 pixels
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("ADMIN LOGIN");
		btnNewButton.setBounds(102, 63, 208, 80);
		panel.add(btnNewButton);
        btnNewButton.setForeground(Color.BLACK); // Set text color to black

        btnNewButton.setBorder(new LineBorder(Color.BLACK)); // Set border color to black

		btnNewButton.setBackground(new Color(148, 0, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Page1().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JButton btnUserLogin = new JButton("USER LOGIN");
		btnUserLogin.setBounds(102, 210, 208, 80);
		panel.add(btnUserLogin);
		btnUserLogin.setForeground(Color.BLACK); // Set text color to black
		btnUserLogin.setBorder(new LineBorder(Color.BLACK)); // Set border color to black

		btnUserLogin.setBackground(new Color(148, 0, 255));
		btnUserLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new User_Crud().setVisible(true);
			}
		});
		btnUserLogin.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JTextArea txtrE = new JTextArea();
		txtrE.setLineWrap(true);
        txtrE.setBackground(new Color(215, 187, 245)); //MAGENTA , darkGray ,

		txtrE.setFont(new Font("Arial", Font.BOLD, 25));
		txtrE.setText(""
				+ "\n\n\n     Empower Your College Journey with Must-Have "
				+ "\n\n\n     Stationery Essentials!"
				+ "\n\n\n     AT REASONABLE PRICES FOR ALL SAMSTHA STUDENTS ");
		txtrE.setBounds(401, 95, 860, 626);
		contentPane.add(txtrE);
		
		
		//add another image to bottom corner samstha logo
		ImageIcon img1=new ImageIcon("C:\\Users\\Divya\\Desktop\\MKSSS-Pune.png");
		int w1=img.getIconWidth();
    	int h1=img.getIconHeight();
    	setPreferredSize(new Dimension(w1,h1));
		JLabel i4 = new JLabel(img);
		i4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		i4.setBackground(Color.GRAY);
		
		i4.setBounds(0, 0, 391, 398);
		contentPane.add(i4);
	}
}
