import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;


public class RegCustomer extends JFrame implements ActionListener{
	JLabel userLabel, passLabel, eNameLabel, addressLabel, salaryLabel;
	JTextField userTF, passTF, addressTF, eNameTF, salaryTF;
	JButton regBtn, backBtn;
	JPanel panel;
	
	String userId;
	
	public RegCustomer()
	{
		super("Restaurant Management System - register- customer");
		
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		userLabel = new JLabel("User ID : ");
		userLabel.setBounds(250, 100, 120, 30);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(400, 100, 120, 30);
		panel.add(userTF);
		
		passLabel = new JLabel("Password : ");
		passLabel.setBounds(250, 150, 120, 30);
		panel.add(passLabel);
		
		passTF = new JTextField();
		passTF.setBounds(400, 150, 120, 30);
		panel.add(passTF);
		
		
		eNameLabel = new JLabel("Name : ");
		eNameLabel.setBounds(250, 200, 120, 30);
		panel.add(eNameLabel);
		
		eNameTF = new JTextField();
		eNameTF.setBounds(400, 200, 120, 30);
		panel.add(eNameTF);
		
		addressLabel = new JLabel("Address : ");
		addressLabel.setBounds(250, 250, 120, 30);
		panel.add(addressLabel);
		
		addressTF = new JTextField();
		addressTF.setBounds(400, 250, 120, 30);
		panel.add(addressTF);
		
	
		regBtn = new JButton("Register");
		regBtn.setBounds(250, 400, 120, 30);
		regBtn.addActionListener(this);
		panel.add(regBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(400, 400, 120, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(text.equals(backBtn.getText()))
		{
			Register r = new Register();
			r.setVisible(true);
			this.dispose();
		}
		
		
		else if(text.equals(regBtn.getText()))
		{
			insertIntoDB();
		}
		else{}
	}
	public void insertIntoDB()
	{
		String newId = userTF.getText();
		String newPass = passTF.getText();
		String eName = eNameTF.getText();
		String address = addressTF.getText();
		int status = 1;
		
		
		String query1 = "INSERT INTO Customer VALUES ('"+newId+"','"+eName+"','"+ address+"',"+status+");";
		String query2 = "INSERT INTO Login VALUES ('"+newId+"','"+newPass+"',"+status+");";
		System.out.println(query1);
		System.out.println(query2);
        
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a02", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query1);
			stm.execute(query2);
			stm.close();
			con.close();
			JOptionPane.showMessageDialog(this, "Success !!!");
		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this, "Oops !!!");
        }
	}

}
