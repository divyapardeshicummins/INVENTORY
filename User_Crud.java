package d1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JList;
import java.awt.SystemColor;

public class User_Crud extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model ;
	private JTextField custid;
	private JTextField custname;
	private JTextField phno;
	private JTextField department;
	private JTextField t1;
	private JTextField t2;
	private JTextField f1;
	private JTextField f3;
	private JTable table_1;
	private JTextField f2;
	private JTextField tf2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Crud frame = new User_Crud();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public User_Crud() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 25, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(252, 129, 158));
		panel.setBounds(0, 0, 1362, 808);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//aaa
		JPanel panel_1 = new JPanel();
		panel.setBackground(new Color(253, 206, 223));

		panel_1.setBounds(439, 21, 1, 1);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(253, 206, 223));
		panel_2.setBounds(20, 21, 302, 726);
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(253, 206, 223));
		panel_3.setBounds(342, 1, 951, 746);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(253, 206, 223));
		tabbedPane.setBounds(10, -22, 931, 782);
		panel_3.add(tabbedPane);
		
		JPanel panel_11 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_11, null);
		tabbedPane.setBackground(Color.black);
		panel_11.setBackground(new Color(248, 232, 238));//welcome
		
		panel_11.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("LOG IN");
		btnNewButton_1.setBackground(new Color(247, 65, 143));
		btnNewButton_1.setBounds(330, 275, 233, 51);
		panel_11.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(6);
			}
		});
		btnNewButton_1.setFont(new Font("Tw Cen MT", Font.BOLD, 26));
		
		JButton btnLogin2 = new JButton("SIGN UP\r\n");
		btnLogin2.setBackground(new Color(247, 65, 143));
		btnLogin2.setBounds(330, 397, 233, 51);
		panel_11.add(btnLogin2);
		btnLogin2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(5);
			}
		});
		btnLogin2.setFont(new Font("Tw Cen MT", Font.BOLD, 26));
;
		
		JLabel lblNewLabel_1 = new JLabel("Welcome To SamsthaStore!");
		lblNewLabel_1.setForeground(new Color(247, 65, 143));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 44));
		lblNewLabel_1.setBounds(168, 48, 568, 180);
		panel_11.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(null);
		panel_4.setBackground(new Color(128, 0, 128));
		tabbedPane.addTab("New tab", null, panel_4, null);
		panel_4.setLayout(null);
		
		
		//header.setBackground(Color.orange);
		model = new DefaultTableModel();
		Object col[] = {"PId","PName","Price","Category","Quantity","Admin_id"};
		model.setColumnIdentifiers(col);
		
		JPanel panel_5 = new JPanel();

		tabbedPane.addTab("New tab", null, panel_5, null);
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(253, 206, 223));

		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_12.setBackground(new Color(160, 118, 249));
		panel_12.setBounds(113, 51, 660, 441);
		panel_5.add(panel_12);
		panel_12.setLayout(null);
		
		JLabel lblUserId_1_2 = new JLabel("RECEIPT");
		lblUserId_1_2.setForeground(new Color(255, 255, 255));
		lblUserId_1_2.setBounds(193, 7, 144, 42);
		panel_12.add(lblUserId_1_2);
		lblUserId_1_2.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		JLabel lblUserId_1_3 = new JLabel("Transaction ID");
		lblUserId_1_3.setForeground(new Color(255, 255, 255));
		lblUserId_1_3.setBounds(72, 78, 153, 35);
		panel_12.add(lblUserId_1_3);
		lblUserId_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblUserId_1_3_1 = new JLabel("Roll Number");
		lblUserId_1_3_1.setForeground(new Color(255, 255, 255));
		lblUserId_1_3_1.setBounds(72, 138, 123, 35);
		panel_12.add(lblUserId_1_3_1);
		lblUserId_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblUserId_1_3_1_1 = new JLabel("Student Name");
		lblUserId_1_3_1_1.setForeground(new Color(255, 255, 255));
		lblUserId_1_3_1_1.setBounds(72, 199, 153, 35);
		panel_12.add(lblUserId_1_3_1_1);
		lblUserId_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblUserId_1_3_1_1_1 = new JLabel("Product Name");
		lblUserId_1_3_1_1_1.setForeground(Color.WHITE);
		lblUserId_1_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserId_1_3_1_1_1.setBounds(72, 255, 153, 35);
		panel_12.add(lblUserId_1_3_1_1_1);
		
		JLabel lblUserId_1_3_1_1_2 = new JLabel("Quantity");
		lblUserId_1_3_1_1_2.setForeground(Color.WHITE);
		lblUserId_1_3_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserId_1_3_1_1_2.setBounds(72, 310, 123, 35);
		panel_12.add(lblUserId_1_3_1_1_2);
		
		JLabel lblUserId_1_3_1_1_2_1 = new JLabel("Total Price");
		lblUserId_1_3_1_1_2_1.setForeground(Color.WHITE);
		lblUserId_1_3_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserId_1_3_1_1_2_1.setBounds(72, 373, 123, 35);
		panel_12.add(lblUserId_1_3_1_1_2_1);
		
		final JLabel l1 = new JLabel("-");
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l1.setBounds(280, 78, 123, 35);
		panel_12.add(l1);
		
		final JLabel l2 = new JLabel("-");
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l2.setBounds(280, 138, 123, 35);
		panel_12.add(l2);
		
		final JLabel l3 = new JLabel("-");
		l3.setForeground(Color.WHITE);
		l3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l3.setBounds(280, 199, 123, 35);
		panel_12.add(l3);
		
		final JLabel l4 = new JLabel("-");
		l4.setForeground(Color.WHITE);
		l4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l4.setBounds(280, 255, 123, 35);
		panel_12.add(l4);
		
		final JLabel l6 = new JLabel("-");
		l6.setForeground(Color.WHITE);
		l6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l6.setBounds(280, 373, 123, 35);
		panel_12.add(l6);
		
		final JLabel l5 = new JLabel("-");
		l5.setForeground(Color.WHITE);
		l5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l5.setBounds(280, 310, 123, 35);
		panel_12.add(l5);
		
		 JLabel lblNewLabel = new JLabel("Thank You For Visiting the Samstha Store!!");
	        lblNewLabel.setForeground(new Color(255, 192, 203)); // Set text color to pink
	        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
	        lblNewLabel.setBounds(455, 644, 432, 48);
	        panel_5.add(lblNewLabel);
	        
		JButton btn1 = new JButton("Generate ReceipT");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn2=DriverManager.getConnection("jdbc:mysql://localhost/trial","root","root");
					
					PreparedStatement ps6 = conn2.prepareStatement("Select t_id from transaction order by t_id DESC LIMIT 1");
					ResultSet rs6=ps6.executeQuery();
					rs6.next();
					String tid2 = Integer.toString(rs6.getInt("t_id"));
					System.out.println("tid = "+tid2);
					
					PreparedStatement ps7 = conn2.prepareStatement("Select roll_number from transaction order by t_id DESC LIMIT 1");
					ResultSet rs7=ps7.executeQuery();
					rs7.next();
					String custId2 = rs7.getString("roll_number");
					System.out.println("custId = "+custId2);
					
					PreparedStatement ps8 = conn2.prepareStatement("Select Student_name from customer where roll_number = '"+custId2+"'");
					ResultSet rs8=ps8.executeQuery();
					rs8.next();
					String custName2 = rs8.getString("Student_Name");
					
					PreparedStatement ps9 = conn2.prepareStatement("Select P_name from transaction order by t_id DESC LIMIT 1");
					ResultSet rs9=ps9.executeQuery();
					rs9.next();
					String pname2 = rs9.getString("P_name");
					
					PreparedStatement ps10 = conn2.prepareStatement("Select quantity from transaction order by t_id DESC LIMIT 1");
					ResultSet rs10=ps10.executeQuery();
					rs10.next();
					String quantity2 = Integer.toString(rs10.getInt("quantity"));
					
					PreparedStatement ps11 = conn2.prepareStatement("Select Total_price from transaction order by t_id DESC LIMIT 1");
					ResultSet rs11=ps11.executeQuery();
					rs11.next();
					String Total_price2 = rs11.getString("Total_price");
					
					l1.setText(tid2);
					l2.setText(String.valueOf(custId2));
					l3.setText(custName2);
					l4.setText(pname2);
					l5.setText(quantity2);
					l6.setText(Total_price2);
				}
				catch(Exception e4) {
					e4.printStackTrace();
				}
			}
		});
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btn1.setBackground(new Color(160, 118, 249));
		btn1.setForeground(Color.black);

		btn1.setBounds(113, 545, 302, 56);
		panel_5.add(btn1);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_6, null);
		panel_6.setLayout(null);
		
		JLabel lblOrderCancelled = new JLabel("Enter student roll number, to cancel\n order : ");
		lblOrderCancelled.setForeground(new Color(160, 118, 249)
				);
		lblOrderCancelled.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblOrderCancelled.setBounds(28, 226, 618, 48);
		panel_6.add(lblOrderCancelled);
		
		tf2 = new JTextField();
		tf2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tf2.setBounds(656, 226, 202, 48);
		panel_6.add(tf2);
		tf2.setColumns(10);
		
		final JLabel cancellbl = new JLabel("- ");
		cancellbl.setFont(new Font("Tahoma", Font.PLAIN, 26));
		cancellbl.setBounds(358, 519, 249, 48);
		panel_6.add(cancellbl);
		
		JButton btnCancelConfirm = new JButton("Cancellation Confirm..");
		btnCancelConfirm.setBackground(new Color(160, 118, 249));

		btnCancelConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cid5 = tf2.getText();
				System.out.println("cid : "+cid5);
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn2=DriverManager.getConnection("jdbc:mysql://localhost/trial","root","root");
					
					PreparedStatement psb = conn2.prepareStatement("Select quantity from transaction order by t_id DESC LIMIT 1");
					ResultSet rsb=psb.executeQuery();
					rsb.next();
					int old_quantity = rsb.getInt("quantity");
					System.out.println("old quantity : "+old_quantity);

					PreparedStatement psc = conn2.prepareStatement("Select p_Id from transaction order by t_id DESC LIMIT 1");
					ResultSet rsc=psc.executeQuery();
					rsc.next();
					int old_pid = rsc.getInt("p_id");
					System.out.println("pid : "+old_pid);

					PreparedStatement psd = conn2.prepareStatement("Select Quantity from Product where P_Id = "+old_pid);
					ResultSet rsd=psd.executeQuery();
					rsd.next();
					int original_quantity = rsd.getInt("Quantity");
					System.out.println("original quantity : "+original_quantity);

					//Update Product table with previous quantity
					String query2 = "Update Product Set Quantity ="+(original_quantity+old_quantity)+" where P_Id ="+old_pid;
					System.out.println(query2);
					PreparedStatement ps3 = conn2.prepareStatement(query2);
					ps3.executeUpdate();
					//System.out.println("Product table updated.. ");
					
					// delete last record of transaction table 
					String query22 = "Delete from transaction order by t_id DESC LIMIT 1";
					System.out.println(query22);
					PreparedStatement ps4 = conn2.prepareStatement(query22);
					ps4.executeUpdate();
					//System.out.println("Product table updated.. ");
					
					cancellbl.setText("Order cancelled !!");
					JOptionPane.showMessageDialog(null,"Order cancelled !!");
				}
				catch(Exception e4) {
					e4.printStackTrace();
				}
			}
		});
		btnCancelConfirm.setFont(new Font("Tahoma", Font.BOLD, 27));
		btnCancelConfirm.setBounds(305, 351, 292, 56);
		panel_6.add(btnCancelConfirm);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cancel Order Here");
		lblNewLabel_1_1.setForeground(new Color(160, 118, 249));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setBounds(252, 34, 436, 63);
		panel_6.add(lblNewLabel_1_1);
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_7, null);
		panel_7.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 895, 646);
		panel_7.add(scrollPane);
		
		table = new JTable();
		Dimension dim2 = new Dimension(20,1);
		table.setIntercellSpacing(dim2);
		int height2 = table.getRowHeight();
		table.setRowHeight(height2+10);
		table.setColumnSelectionAllowed(true);
		JTableHeader header2 = table.getTableHeader();
		header2.setBackground(Color.orange);
		
		
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		model = new DefaultTableModel();
		Object col1[] = {"PId","PName","Price","Category","Quantity","Admin_id"};
		model.setColumnIdentifiers(col1);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1_2 = new JLabel("Available Stock");
		lblNewLabel_1_2.setForeground(new Color(247, 65, 143));
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 44));
		lblNewLabel_1_2.setBackground(Color.BLACK);
		lblNewLabel_1_2.setBounds(288, 0, 385, 66);
		panel_7.add(lblNewLabel_1_2);
		
		JPanel panel_8 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_8, null);
		panel_8.setBackground(new Color(255, 255, 255));
		panel_8.setLayout(null);
		
		JLabel lblUserId = new JLabel("ROLL NUMBER");
		lblUserId.setSize(new Dimension(10, 0));
		lblUserId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUserId.setBounds(238, 115, 123, 35);
		panel_8.add(lblUserId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setSize(new Dimension(10, 0));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName.setBounds(238, 175, 123, 35);
		panel_8.add(lblName);
		
		JLabel lblAddress = new JLabel("phone number");
		lblAddress.setSize(new Dimension(10, 0));
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddress.setBounds(238, 237, 123, 35);
		panel_8.add(lblAddress);
		
		JLabel lblName_1_1 = new JLabel("Department");
		lblName_1_1.setSize(new Dimension(10, 0));
		lblName_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName_1_1.setBounds(238, 303, 123, 35);
		panel_8.add(lblName_1_1);
		
		custid = new JTextField();
		custid.setBounds(424, 119, 266, 35);
		panel_8.add(custid);
		custid.setColumns(10);
		
		custname = new JTextField();
		custname.setColumns(10);
		custname.setBounds(424, 179, 266, 35);
		panel_8.add(custname);
		
		phno = new JTextField();
		phno.setColumns(10);
		phno.setBounds(424, 241, 266, 35);
		panel_8.add(phno);
		
		department = new JTextField();
		department.setColumns(10);
		department.setBounds(424, 307, 266, 35);
		panel_8.add(department);
		
		JButton btnLogin = new JButton("SIGN UP");
		btnLogin.setBackground(new Color(247, 65, 143)
				);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cid,cname,phone_number,departmentName;
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/trial","root","root");
					
						cid = custid.getText();
						cname = custname.getText();
						phone_number = phno.getText();
						departmentName = department.getText();
						
						if(custid.getText().isEmpty() || custname.getText().isEmpty() || phno.getText().isEmpty() || department.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null,"Empty fields are not allowed !!","Testing",JOptionPane.ERROR_MESSAGE);
						}
						else {
						
							String query = "Insert into customer(roll_number,Student_name,phno,department) values(?,?,?,?)";
							PreparedStatement ps2 = conn.prepareStatement(query);
							ps2.setString(1,cid);
							ps2.setString(2,cname);
							ps2.setString(3,phone_number);
							ps2.setString(4,departmentName);
							
							ps2.execute();
							
							JOptionPane.showMessageDialog(null,"Login Successfull !!");
							tabbedPane.setSelectedIndex(7);
						}
				}
				catch(Exception e3) {
					JOptionPane.showMessageDialog(null,"Pl. try again !!");
					e3.printStackTrace();
				}
			}
		});
		btnLogin.setFont(new Font("Tw Cen MT", Font.BOLD, 26));
		btnLogin.setBounds(124, 446, 195, 61);
		panel_8.add(btnLogin);
		
		JButton btnNewButton_2_1 = new JButton("RESET");
		btnNewButton_2_1.setBackground(new Color(247, 65, 143));
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				phno.setText("");
				custname.setText("");
				department.setText("");
				custid.setText("");
			}
		});
		btnNewButton_2_1.setFont(new Font("Tw Cen MT", Font.BOLD, 26));
		btnNewButton_2_1.setBounds(374, 446, 195, 61);
		panel_8.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("BACK");
		btnNewButton_2_2.setBackground(new Color(247, 65, 143));
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnNewButton_2_2.setFont(new Font("Tw Cen MT", Font.BOLD, 26));
		btnNewButton_2_2.setBounds(620, 446, 195, 61);
		panel_8.add(btnNewButton_2_2);
		
		JLabel errorlbl = new JLabel("");
		errorlbl.setForeground(new Color(255, 0, 51));
		errorlbl.setBounds(77, 369, 651, 35);
		panel_8.add(errorlbl);
		
		JLabel lblNewLabel_1_3 = new JLabel("SIGN UP");
		lblNewLabel_1_3.setForeground(new Color(247, 65, 143));
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 44));
		lblNewLabel_1_3.setBackground(Color.BLACK);
		lblNewLabel_1_3.setBounds(349, 21, 183, 53);
		panel_8.add(lblNewLabel_1_3);
		
		
		JPanel panel_9 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_9, null);
		panel_9.setBackground(new Color(255, 255, 255));
		panel_9.setBounds(50,50,300,300);
		panel_9.setLayout(null);
		
		
		JLabel lblUserId_1 = new JLabel("ROLL NUMBER");
		lblUserId_1.setSize(new Dimension(10, 0));
		lblUserId_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUserId_1.setBounds(244, 180, 123, 35);
		panel_9.add(lblUserId_1);
		
		JLabel lblUserId_1_1 = new JLabel("Phone number");
		lblUserId_1_1.setSize(new Dimension(10, 0));
		lblUserId_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUserId_1_1.setBounds(244, 258, 123, 35);
		panel_9.add(lblUserId_1_1);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(395, 184, 266, 35);
		panel_9.add(t1);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(395, 262, 266, 35);
		panel_9.add(t2);
		
		JButton btnLogin_1 = new JButton("LOGIN");
		btnLogin_1.setBackground(new Color(247, 65, 143));
		btnLogin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tt1,tt2;
				Statement st = null;
				ResultSet rs = null;
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/trial","root","root");
					
						tt1 = t1.getText();
						tt2 = t2.getText();
						
						if(t1.getText().isEmpty() || t2.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null,"Empty fields are not allowed !!","Testing",JOptionPane.ERROR_MESSAGE);
						}
						else {
						//Search
							String query = "Select * from customer where roll_number='"+tt1+"'and phno='"+tt2+"'";
	
							PreparedStatement ps2 = conn.prepareStatement(query);
							rs = ps2.executeQuery();
							int bool=0;
			
							while(rs.next()) {
								if( ( rs.getString("roll_number").equals(t1.getText()) ) && ( rs.getString("phno").equals(t2.getText()) ) ) {
									JOptionPane.showMessageDialog(null,"LOGIN Successfull !!");
									bool=1;
									tabbedPane.setSelectedIndex(7);
								}
							}
							if(bool==0) {
								JOptionPane.showMessageDialog(null,"This UserId is not available !!");
							}
						}
				}
				catch(Exception e3) {
					JOptionPane.showMessageDialog(null,"Please check Your Information Again !!");
					e3.printStackTrace();
				}
			}
		});
		btnLogin_1.setFont(new Font("Tw Cen MT", Font.BOLD, 26));
		btnLogin_1.setBounds(124, 385, 188, 65);
		panel_9.add(btnLogin_1);
		
		JButton btnLogin_1_1 = new JButton("LOGOUT");
		btnLogin_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnLogin_1_1.setBackground(new Color(247, 65, 143));
		btnLogin_1_1.setFont(new Font("Tw Cen MT", Font.BOLD, 26));
		btnLogin_1_1.setBounds(583, 385, 188, 65);
		panel_9.add(btnLogin_1_1);
		
		JButton btnLogin_1_1_1 = new JButton("RESET");
		btnLogin_1_1_1.setBackground(new Color(247, 65, 143));
		btnLogin_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText("");
				t2.setText("");
			}
		});
		btnLogin_1_1_1.setFont(new Font("Tw Cen MT", Font.BOLD, 26));
		btnLogin_1_1_1.setBounds(353, 385, 188, 65);
		panel_9.add(btnLogin_1_1_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("LOG IN");
		lblNewLabel_1_3_1.setForeground(new Color(247, 65, 143));
		lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.BOLD, 44));
		lblNewLabel_1_3_1.setBackground(Color.BLACK);
		lblNewLabel_1_3_1.setBounds(376, 44, 183, 53);
		panel_9.add(lblNewLabel_1_3_1);
		
		JPanel panel_10 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_10, null);
		panel_10.setBorder(null);
		panel_10.setBackground(new Color(255, 255, 255));
		panel_10.setLayout(null);
		
		JLabel lblPlaceOrderHere = new JLabel("PLACE ORDER HERE");
		lblPlaceOrderHere.setBackground(new Color(160, 118, 249));
		lblPlaceOrderHere.setForeground(new Color(160, 118, 249));
		lblPlaceOrderHere.setSize(new Dimension(10, 0));
		lblPlaceOrderHere.setFont(new Font("Baskerville Old Face", Font.BOLD, 35));
		lblPlaceOrderHere.setBounds(32, 27, 421, 46);
		panel_10.add(lblPlaceOrderHere);
		
		JLabel lblCustomerId = new JLabel("ROLL NUMBER");
		lblCustomerId.setForeground(new Color(0, 0, 0));
		lblCustomerId.setSize(new Dimension(10, 0));
		lblCustomerId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCustomerId.setBounds(316, 111, 137, 35);
		panel_10.add(lblCustomerId);
		
		JLabel lblUserId_3_1 = new JLabel("PRODUCT ID");
		lblUserId_3_1.setForeground(new Color(0, 0, 0));
		lblUserId_3_1.setSize(new Dimension(10, 0));
		lblUserId_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUserId_3_1.setBounds(316, 172, 113, 35);
		panel_10.add(lblUserId_3_1);
		
		f1 = new JTextField();
		f1.setColumns(10);
		f1.setBounds(466, 113, 266, 39);
		panel_10.add(f1);
		
		f3 = new JTextField();
		f3.setColumns(10);
		f3.setBounds(466, 234, 266, 39);
		panel_10.add(f3);
		
		JButton btnConfirmOrder = new JButton("Confirm and Generate Receipt");
		btnConfirmOrder.setBackground(new Color(160, 118, 249));//PURPLE
		btnConfirmOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ResultSet rs2,rs3 = null;
				try {
					//2. Product > Minus the quantity > where user entered id is present
					//1.  before that check if that much quantity is present or not
					//3. Transaction = add transaction
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn2=DriverManager.getConnection("jdbc:mysql://localhost/trial","root","root");
					
					// Values entered by user in textfield
					String cid2 = f1.getText();
					String pid = f2.getText();
					
					
					int qty2 = Integer.parseInt(f3.getText());
					System.out.println(qty2);
					
					//int qty3 = Integer.parseInt(rs2.getString("Quantity"));
					
						if( f1.getText().isEmpty() || f2.getText().isEmpty() || f3.getText().isEmpty() ) {
							JOptionPane.showMessageDialog(null,"Empty fields are not allowed !!","Testing",JOptionPane.ERROR_MESSAGE);
						}
						else {
						
							//check if that quantity is available 
							//If yes perform database operation
							
							PreparedStatement ps6 = conn2.prepareStatement("Select Quantity from Product where P_Id=?");
							ps6.setString(1, pid);
							ResultSet rs6=ps6.executeQuery();
							rs6.next();
							int original_quantity = rs6.getInt("Quantity");
							
							if(qty2 <= original_quantity) {
								System.out.println(" qty = "+qty2);
								System.out.println("Original Quantity = "+original_quantity);
								
								PreparedStatement ps = conn2.prepareStatement("Select * from Product where P_Id="+pid);
								ResultSet rs=ps.executeQuery();
								rs.next();
								String query2 = "Update Product Set Quantity ="+(rs.getInt("Quantity")-qty2)+" where P_Id="+pid;
								System.out.println(query2);
								PreparedStatement ps3 = conn2.prepareStatement(query2);
								ps3.executeUpdate();
								//JOptionPane.showMessageDialog(null,"Product table Updated Successfully !!");
									
									//calculate pname and total
								
									String query5 = "Select P_name from Product where P_Id ="+pid;
									PreparedStatement ps5 = conn2.prepareStatement(query5);
									String proName = "";
									rs3 = ps5.executeQuery();
									if(rs3.next()) {
										proName = rs3.getString(1);
									}
									System.out.println("Product name = "+proName);
									
									//calculate total
									PreparedStatement ps7 = conn2.prepareStatement("Select Price from Product where P_Id="+pid);
									ResultSet rs7=ps7.executeQuery();
									rs7.next();
									int tbl_price = rs7.getInt("Price");
									int total = qty2 * tbl_price;
									System.out.println("Total price = "+total);
									
									//add transaction details in table
									String query4 = "Insert into transaction(t_id,p_Id,P_name,quantity,time_date,roll_number,Total_price) values(?,?,?,?,?,?,?)";
									PreparedStatement ps8 = conn2.prepareStatement(query4);
									ps8.setString(1,null);
									ps8.setString(2,pid);
									ps8.setString(3,proName);
									ps8.setLong(4,qty2);
									Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
									ps8.setTimestamp(5,date);
									ps8.setString(6,cid2);
									ps8.setInt(7,total);
									
									ps8.execute();
									
									JOptionPane.showMessageDialog(null,"Order confirmed !!");
									tabbedPane.setSelectedIndex(2);
									
							}
							else {
								JOptionPane.showMessageDialog(null,"Quantity Not Available !!");
							}
						}
				
				}
				catch(Exception e3) {
					JOptionPane.showMessageDialog(null,"Pl. try again !!");
					e3.printStackTrace();
				}
			}
		});
		btnConfirmOrder.setFont(new Font("Tw Cen MT", Font.BOLD, 26));
		btnConfirmOrder.setBounds(499, 315, 365, 46);
		panel_10.add(btnConfirmOrder);
		
		JButton btnCheckAvailableStock = new JButton("Check Available Stock");
		btnCheckAvailableStock.setBackground(new Color(160, 118, 249));
		btnCheckAvailableStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/trial","root","root");
					
					PreparedStatement ps = conn.prepareStatement("Select * from Product");
					ResultSet rs = ps.executeQuery();
					DefaultTableModel tm = (DefaultTableModel)table_1.getModel();
					tm.setRowCount(0);
					while(rs.next()) {
					    
					    Integer pid = Integer.valueOf(rs.getInt("P_Id"));
					    String pname = rs.getString("P_Name");
					    Integer price = Integer.valueOf(rs.getInt("Price"));
					    String category = rs.getString("Category");
					    Integer quantity = Integer.valueOf(rs.getInt("Quantity"));
					    Integer adminId = Integer.valueOf(rs.getInt("Admin_id"));
					    
					    // Create an Object array with converted Integer objects
					    Object o[] = {pid, pname, price, category, quantity, adminId};
					    
					    // Add the Object array to the table model
					    tm.addRow(o);
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnCheckAvailableStock.setFont(new Font("Tw Cen MT", Font.BOLD, 26));
		btnCheckAvailableStock.setBounds(278, 672, 381, 51);
		panel_10.add(btnCheckAvailableStock);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(-12, 422, 938, 240);
		panel_10.add(scrollPane_1);
		
		table_1 = new JTable();
		Dimension dim = new Dimension(20,1);
		table_1.setIntercellSpacing(dim);
		int height = table_1.getRowHeight();
		table_1.setRowHeight(height+10);
		table_1.setColumnSelectionAllowed(true);
		JTableHeader header = table_1.getTableHeader();
		
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		table_1.setModel(model);
		
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblUserId_3_3_1 = new JLabel("Quantity");
		lblUserId_3_3_1.setForeground(new Color(0, 0, 0));
		lblUserId_3_3_1.setSize(new Dimension(10, 0));
		lblUserId_3_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUserId_3_3_1.setBounds(316, 232, 113, 35);
		panel_10.add(lblUserId_3_3_1);
		
		JList list = new JList();
		list.setBounds(232, 171, -44, -23);
		panel_10.add(list);
		
		f2 = new JTextField();
		f2.setColumns(10);
		f2.setBounds(466, 174, 266, 39);
		panel_10.add(f2);
		
		JButton btnCancelOrder = new JButton("Cancel Order");
		btnCancelOrder.setBorder(null);
		btnCancelOrder.setBorderPainted(false);
		btnCancelOrder.setForeground(new Color(255, 255, 255));
		btnCancelOrder.setBackground(new Color(247, 65, 143));
		btnCancelOrder.setBounds(0, 175, 302, 56);
		btnCancelOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		panel_2.setLayout(null);
		panel_2.add(btnCancelOrder);
		btnCancelOrder.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JButton btnGenerateReceipt = new JButton("Generate Receipt");
		btnGenerateReceipt.setBorder(null);
		btnGenerateReceipt.setForeground(new Color(255, 255, 255));
		btnGenerateReceipt.setBackground(new Color(247, 65, 143));
		btnGenerateReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnGenerateReceipt.setBounds(0,93,302,56);
		panel_2.add(btnGenerateReceipt);
		btnGenerateReceipt.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JButton b1 = new JButton("Place Order");
		b1.setBorderPainted(false);
		b1.setBorder(null);
		b1.setForeground(new Color(255, 255, 255));
		b1.setBackground(new Color(247, 65, 143));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(7);
			}
		});
		b1.setBounds(0, 10, 302, 56);
		panel_2.add(b1);
		b1.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JButton btnBackToMenu = new JButton("Available Stock");
		btnBackToMenu.setBorder(null);
		btnBackToMenu.setForeground(new Color(255, 255, 255));
		btnBackToMenu.setBackground(new Color(247, 65, 143));
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/trial","root","root");
					
					PreparedStatement ps = conn.prepareStatement("Select * from Product");
					ResultSet rs = ps.executeQuery();
					DefaultTableModel tm = (DefaultTableModel)table.getModel();
					tm.setRowCount(0);
					while(rs.next()) {
					    // Retrieve integer values from the result set and convert them to Integer objects
					    Integer pid = Integer.valueOf(rs.getInt("P_Id"));
					    String pname = rs.getString("P_Name");
					    Integer price = Integer.valueOf(rs.getInt("Price"));
					    String category = rs.getString("Category");
					    Integer quantity = Integer.valueOf(rs.getInt("Quantity"));
					    Integer adminId = Integer.valueOf(rs.getInt("Admin_id"));
					    
					    // Create an Object array with converted Integer objects
					    Object o[] = {pid, pname, price, category, quantity, adminId};
					    
					    // Add the Object array to the table model
					    tm.addRow(o);
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnBackToMenu.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnBackToMenu.setBounds(0, 268, 302, 56);
		panel_2.add(btnBackToMenu);
		
		JButton btnBackToMenu_1 = new JButton("Back To Menu");
		btnBackToMenu_1.setBorder(null);
		btnBackToMenu_1.setForeground(new Color(255, 255, 255));
		btnBackToMenu_1.setBackground(new Color(247, 65, 143));
		btnBackToMenu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Intro_Page().setVisible(true);
			}
		});
		btnBackToMenu_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnBackToMenu_1.setBounds(0, 355, 302, 56);
		panel_2.add(btnBackToMenu_1);
	}
}
//background colours change rgb(253, 206, 223) rgb(248, 232, 238)done
