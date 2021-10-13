import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ChefHome extends JFrame implements ActionListener {
	JLabel welcomeLabel;
	JButton viewOrderBtn, menuBtn, myInfoBtn, changePasswordBtn,backBtn, logoutBtn;
	JPanel panel;
	String userId;
	
	public ChefHome(String userId)
	{
		super("Restaurant Management System - Chef Home Window");
		this.userId = userId;
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		welcomeLabel = new JLabel("Welcome, "+userId);
		welcomeLabel.setBounds(350, 50, 100, 30);
		panel.add(welcomeLabel);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 50, 100, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		viewOrderBtn = new JButton("View Order");
		viewOrderBtn.setBounds(50, 120, 150, 30);
		viewOrderBtn.addActionListener(this);
		panel.add(viewOrderBtn);
		
		menuBtn = new JButton("Manage Menu");
		menuBtn.setBounds(220, 120, 150, 30);
		menuBtn.addActionListener(this);
		panel.add(menuBtn);
		
		myInfoBtn = new JButton("My Information");
		myInfoBtn.setBounds(400, 120, 150, 30);
		myInfoBtn.addActionListener(this);
		panel.add(myInfoBtn);
		
		changePasswordBtn = new JButton("Change Password");
		changePasswordBtn.setBounds(575, 120, 150, 30);
		changePasswordBtn.addActionListener(this);
		panel.add(changePasswordBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(575, 200, 150, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
		
		
	}
	
	public void actionPerformed(ActionEvent event)
	{
String text = event.getActionCommand();
		
		if(text.equals(logoutBtn.getText()))
		{
			Login log = new Login();
			log.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(viewOrderBtn.getText()))
		{
			ViewOrder vo=new ViewOrder(userId);
			vo.setVisible(true);
			this.dispose();
		}
		else if(text.equals(menuBtn.getText()))
		{
			Menu m = new Menu(userId);
			m.setVisible(true);
			this.dispose();
		}
		else if(text.equals(backBtn.getText()))
		{
			Login log = new Login();
			log.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(myInfoBtn.getText()))
		{
			MyInfo mi = new MyInfo(userId);
			mi.setVisible(true);
			this.dispose();
		}
		else if(text.equals(changePasswordBtn.getText()))
		{
			ChangePassword cp = new ChangePassword(userId);
			cp.setVisible(true);
			this.dispose();
		}
		
	}
	

}
