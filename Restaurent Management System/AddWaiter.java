import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

public class AddWaiter extends JFrame implements ActionListener{
	JLabel userLabel, passLabel, eNameLabel, addressLabel, roleLabel, salaryLabel;
	JTextField userTF, passTF, addressTF, eNameTF, salaryTF;
	JButton autoPassBtn, addBtn, backBtn, logoutBtn;
	JPanel panel;
	
	String userId;
	
	public AddWaiter(String userId)
	{
		super("Restaurant Management System - Add New Employee-addWaiter");
		
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.userId = userId;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 50, 100, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
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
		passTF.setEnabled(false);
		panel.add(passTF);
		
		autoPassBtn = new JButton("Generate");
		autoPassBtn.setBounds(550, 150, 150, 30);
		autoPassBtn.addActionListener(this);
		panel.add(autoPassBtn);
		
		eNameLabel = new JLabel("Employee Name : ");
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
		
		
		salaryLabel = new JLabel("Salary : ");
		salaryLabel.setBounds(250, 300, 120, 30);
		panel.add(salaryLabel);
		
		salaryTF = new JTextField();
		salaryTF.setBounds(400, 300, 120, 30);
		panel.add(salaryTF);
		
		addBtn = new JButton("Add");
		addBtn.setBounds(250, 400, 120, 30);
		addBtn.addActionListener(this);
		panel.add(addBtn);
		
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
			AddEmployee me = new AddEmployee(userId);
			me.setVisible(true);
			this.dispose();
		}
		else if(text.equals(logoutBtn.getText()))
		{
			Login log = new Login();
			log.setVisible(true);
			this.dispose();
		}
		else if(text.equals(autoPassBtn.getText()))
		{
			Random r = new Random();
			passTF.setText(r.nextInt(89999999)+10000000+"");
			autoPassBtn.setEnabled(false);
		}
		else if(text.equals(addBtn.getText()))
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
		double salary = Double.parseDouble(salaryTF.getText());
		int status = 2;
		
		
		String query1 = "INSERT INTO Waiter VALUES ('"+newId+"','"+eName+"','"+address+"',"+salary+","+status+");";
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
