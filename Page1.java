package d1;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Page1 extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JPasswordField tf2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Connection conn=null;
		Statement stmt = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/trial","root","root");
			System.out.println("Connection Succeded..............................");
			stmt=conn.createStatement();
			
		}
		catch(Exception e) {
			
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page1 frame = new Page1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Page1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 25, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 205, 234));
		contentPane.setName("Frame 1");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USERNAME:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setSize(new Dimension(10, 0));
		lblNewLabel.setBounds(438, 296, 159, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD:");
		lblNewLabel_1_1.setSize(new Dimension(10, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(438, 363, 142, 35);
		contentPane.add(lblNewLabel_1_1);
		
		tf1 = new JTextField();
		tf1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tf1.setBounds(626, 295, 217, 40);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setForeground(Color.black);
		btnNewButton.setBackground(new Color(255, 62, 165));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				ResultSet rs=null;
				ResultSet rs1=null;
	
				try {

			            Class.forName("com.mysql.cj.jdbc.Driver");
			            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/trial","root","root");
			            //System.out.println("Connection Succeded..............................");
			            Statement stmt=conn.createStatement();

			            String username = tf1.getText();
			            String password = new String(tf2.getPassword()); // Using getPassword() to retrieve the password
			            String query = "Select * from Admin where Username = '"+username+"' and Password = '"+password+"'";
			            rs1 = stmt.executeQuery(query);
			            if(rs1.next()) {
			                JOptionPane.showMessageDialog(null, "Success");
			                new Admin_Crud().setVisible(true);
			            }
			            else {
			                JOptionPane.showMessageDialog(null, "Username or password wrong...");
			                tf1.setText("");
			                tf2.setText("");
			            }

			    }
				catch(Exception e1) {
					
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(330, 524, 187, 57);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.setForeground(Color.black);
		btnNewButton_1.setBackground(new Color(255, 62, 165));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf1.setText("");
				tf2.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(576, 524, 187, 57);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("BACK");
		btnNewButton_1_1.setForeground(Color.black);
		btnNewButton_1_1.setBackground(new Color(255, 62, 165)
				);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Intro_Page().setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1_1.setBounds(818, 524, 187, 57);
		contentPane.add(btnNewButton_1_1);
		
		ImageIcon icon=new ImageIcon("C:\\Users\\Divya\\Desktop\\trial\\project1\\images.jpg");
		JLabel logo = new JLabel(icon);
		logo.setBounds(0,0,200,200);
		contentPane.add(logo);
		
		JLabel l1 = new JLabel("  Samstha Store login Page");
		contentPane.add(l1);
    	l1.setBounds(175,0,1250,115);
    	l1.setFont(new Font ("Serif",Font.BOLD,52));
        l1.setForeground(Color.black);
        l1.setOpaque(true);
        l1.setBackground(new Color(251, 154, 209));
        
        tf2 = new JPasswordField();
        tf2.setBounds(626, 366, 217, 40);
        contentPane.add(tf2);
        
        JLabel lblAdminLogin = new JLabel("ADMIN LOGIN");
        lblAdminLogin.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 70));
        lblAdminLogin.setBounds(481, 125, 567, 90);
        contentPane.add(lblAdminLogin);
        
	}
}

//a small logo at the bottom??