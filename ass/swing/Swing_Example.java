package ass.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import connection.DBConnection;

class Login_Page extends  Confirmation implements ActionListener{
	
	JLabel l1,l2;
	JTextField t1,t2;
	JButton b1;
	
	public Login_Page() {
		JFrame fr2 = new JFrame("Login Page");
		fr2.setVisible(true);
		fr2.setLayout(null);
		fr2.setSize(500, 400);
		
		l1 = new JLabel("Email:");
		l1.setBounds(100, 100, 100, 30);
		fr2.add(l1);
		t1 = new JTextField();
		t1.setBounds(200, 100, 200, 20);
		fr2.add(t1);
		
		l2 = new JLabel("Password:");
		l2.setBounds(100, 150, 100, 30);
		fr2.add(l2);
		t2 = new JTextField();
		t2.setBounds(200, 150, 200, 20);
		fr2.add(t2);
		
		b1 = new JButton("Login");
		b1.setBounds(180, 200, 100, 30);
		fr2.add(b1);
		
		b1.addActionListener(this);
	}
	
		public static void Home(String email,String password) {
		
			boolean flag = Confirmation.CheckEmail(email, password);
			
			if(flag == true) {
			try {
				Connection conn = DBConnection.createConnection();
				String sql = "select * from student";
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				
				while(rs.next()) {
					System.out.println(Integer.parseInt(rs.getString("id")));
					System.out.println(rs.getString("name"));
					System.out.println(Long.parseLong(rs.getString("contact")));
					System.out.println(rs.getString("address"));
					System.out.println(rs.getString("email"));
					System.out.println(rs.getString("password"));
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == b1) {
				System.out.println("Redirect to Home page.");
				new Home_Page();
			}
		}
}
class Confirmation implements ActionListener{
	JLabel l1;
	JButton b1;
	public Confirmation() {
		
		JFrame fr1 = new JFrame("Sucess");
		fr1.setVisible(true);
		fr1.setSize(400, 200);
		fr1.setLayout(null);
		
		l1 = new JLabel("Data inserted successfully");
		l1.setBounds(130, 40, 300, 50);
		fr1.add(l1);
		b1 = new JButton("Done");
		b1.setBounds(150, 100, 100, 20);
		fr1.add(b1);
		
		b1.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == b1) {
			System.out.println("Redirect to login page.");
			new Login_Page();
		}
	}
	
	public static boolean CheckEmail(String email,String password) {
		
		boolean flag = false;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from student where email=? and password=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				flag = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}

class Home_Page{
	
	public Home_Page() {
		JFrame fr3 = new JFrame("Home Page");
		fr3.setVisible(true);
		fr3.setLayout(null);
		fr3.setSize(600, 500);
	}
}
class Swing_demo implements ActionListener{
	
	JLabel l1,l2,l3,l4,l5,lb;
	JTextField t1,t2,t3,t4,t5,tf;
	JButton b1,b2; 
	
	public Swing_demo() {
		
		JFrame frm = new JFrame("My Application");
		frm.setVisible(true);
		frm.setLayout(null);
		frm.setSize(600, 400);
		

		lb = new JLabel("Id:");
		lb.setBounds(50, 10, 100, 20);
		frm.add(lb);
		tf = new JTextField();
		tf.setBounds(150, 10, 200, 20);
		frm.add(tf);
		
		l1 = new JLabel("Name:");
		l1.setBounds(50, 50, 100, 20);
		frm.add(l1);
		t1 = new JTextField();
		t1.setBounds(150, 50, 200, 20);
		frm.add(t1);
		
		l2 = new JLabel("Contact:");
		l2.setBounds(50, 90, 100, 20);
		frm.add(l2);
		t2 = new JTextField();
		t2.setBounds(150, 90, 200, 20);
		frm.add(t2);
		
		l3= new JLabel("Address:");
		l3.setBounds(50, 130, 100, 20);
		frm.add(l3);
		t3 = new JTextField();
		t3.setBounds(150, 130, 200, 20);
		frm.add(t3);
		
		l4 = new JLabel("Email:");
		l4.setBounds(50, 170, 100, 20);
		frm.add(l4);
		t4 = new JTextField();
		t4.setBounds(150, 170, 200, 20);
		frm.add(t4);
		
		l5 = new JLabel("Password:");
		l5.setBounds(50, 210, 100, 20);
		frm.add(l5);
		t5 = new JTextField();
		t5.setBounds(150, 210, 200, 20);
		frm.add(t5);
		
		b1 = new JButton("Register");
		b1.setBounds(50, 250, 300, 30);
		frm.add(b1);
		
		b1.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == b1) {
				
				int id = Integer.parseInt(tf.getText());
				String name = t1.getText();
				long contact = Long.parseLong(t2.getText());
				String address = t3.getText();
				String email = t4.getText();
				String password = t5.getText();
				System.out.println("Registered Button clicked");
				System.out.println(id);
				System.out.println(name);
				System.out.println(contact);
				System.out.println(address);
				System.out.println(email);
				System.out.println(password);
				
				try {
					
					Connection conn = DBConnection.createConnection();
					String sql = "insert into student(id,name,contact,address,email,password) values(?,?,?,?,?,?)";
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.setInt(1, id);
					pst.setString(2, name);
					pst.setLong(3, contact);
					pst.setString(4, address);
					pst.setString(5, email);
					pst.setString(6	, password);
					pst.executeUpdate();
					System.out.println("Data inserted Successfully");
					new Confirmation();
				} 
				catch (Exception e2) {
					e2.printStackTrace();
				}
		}
	}
}
public class Swing_Example {
	public static void main(String[] args) {
		new Swing_demo();
		
	}	
}


