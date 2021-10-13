import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WaiterHome extends JFrame implements ActionListener
{
	JLabel welcomeLabel;
	JButton  odrBtn, myInfoBtn, changePasswordBtn,backBtn, logoutBtn;
	JPanel panel;
	String userId;
	
	public WaiterHome(String userId)
	{
		super("Restaurant Management System - Waiter Home Window");
		this.setSize(800, 450);
		this.userId=userId;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		panel =new JPanel();
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
		
		myInfoBtn = new JButton("My Information");
		myInfoBtn.setBounds(550, 190, 150, 30);
		myInfoBtn.addActionListener(this);
		panel.add(myInfoBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 260, 100, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		odrBtn = new JButton("Take Order");
		odrBtn.setBounds(350, 190, 150, 30);
		odrBtn.addActionListener(this);
		panel.add(odrBtn);
		
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
			this.setVisible(false);
		}
		else if(text.equals(odrBtn.getText()))
		{
			this.dispose();
			
			new TakeOrder(userId).setVisible(true);
		}
		else if(text.equals(backBtn.getText()))
		{
			Login log = new Login();
			log.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(myInfoBtn.getText()))
		{
			new WaiterInfo(userId).setVisible(true);
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