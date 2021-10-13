import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ManagerHome extends JFrame implements ActionListener {
	JLabel welcomeLabel;
	JButton manageEmployeeBtn,changePasswordBtn,backBtn, logoutBtn,myInfoBtn;
	JPanel panel;
	String userId;
	
	public ManagerHome(String userId)
	{
		super("Restaurant Management System - Manager Home Window");
		this.userId = userId;
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		welcomeLabel = new JLabel("Welcome, "+userId);
		welcomeLabel.setBounds(350, 110, 150, 30);
		panel.add(welcomeLabel);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 50, 100, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		changePasswordBtn = new JButton("Change Password");
		changePasswordBtn.setBounds(150, 190, 150, 30);
		changePasswordBtn.addActionListener(this);
		panel.add(changePasswordBtn);
		
		manageEmployeeBtn = new JButton("Manage Employee");
		manageEmployeeBtn.setBounds(350, 190, 150, 30);
		manageEmployeeBtn.addActionListener(this);
		panel.add(manageEmployeeBtn);
		
		myInfoBtn = new JButton("My Information");
		myInfoBtn.setBounds(550, 190, 150, 30);
		myInfoBtn.addActionListener(this);
		panel.add(myInfoBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 260, 100, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
		
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
		else if(text.equals(changePasswordBtn.getText()))
		{
			ChangePassword cp = new ChangePassword(userId);
			cp.setVisible(true);
			this.dispose();
		}
		else if(text.equals(manageEmployeeBtn.getText()))
		{
			ManageEmployee me = new ManageEmployee(userId);
			me.setVisible(true);
			this.dispose();
		}
		else if(text.equals(myInfoBtn.getText()))
		{
			 ManagerMyInfo mmi = new ManagerMyInfo(userId);
			 mmi.setVisible(true);
			 this.dispose();
		}
		else if(text.equals(backBtn.getText()))
		{
			Login log = new Login();
			log.setVisible(true);
			this.dispose();
		}
		else {}
	}

}
