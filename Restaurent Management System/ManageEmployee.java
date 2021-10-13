import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ManageEmployee extends JFrame implements ActionListener {
	
	JButton addEmployeeBtn, viewEmployeeBtn, backBtn, logoutBtn;
	JPanel panel;
	String userId;
	
	public ManageEmployee(String userId)
	{
		super("Restaurant Management System - Manage Employee Window");
		this.setSize(800, 450);
		this.userId = userId;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 50, 100, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		addEmployeeBtn = new JButton("Add Employee");
		addEmployeeBtn.setBounds(150, 120, 150, 30);
		addEmployeeBtn.addActionListener(this);
		panel.add(addEmployeeBtn);
		
		viewEmployeeBtn = new JButton("View Employee");
		viewEmployeeBtn.setBounds(350, 120, 150, 30);
		viewEmployeeBtn.addActionListener(this);
		panel.add(viewEmployeeBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(550, 120, 150, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
		this.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(text.equals(logoutBtn.getText()))
		{
			Login log = new Login();
			log.setVisible(true);
			this.dispose();
		}
		else if(text.equals(backBtn.getText()))
		{
			ManagerHome mh = new ManagerHome(userId);
			mh.setVisible(true);
			this.dispose();
		}
		else if(text.equals(addEmployeeBtn.getText()))
		{
			AddEmployee aem = new AddEmployee(userId);
			aem.setVisible(true);
			this.dispose();
		}
		else if(text.equals(viewEmployeeBtn.getText()))
		{
			ViewEmployee ve = new ViewEmployee(userId);
			ve.setVisible(true);
			this.dispose();
		}
	}
}
