import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomerHome extends JFrame implements ActionListener
{
	JLabel welcomeLabel;
	JButton  menuBtn, myInfoBtn, changePasswordBtn,backBtn, logoutBtn, orderBtn;
	JPanel panel;
	String userId;
	
	public CustomerHome(String userId)
	{
		super("Restaurant Management System - Customer Home Window");
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
		
		menuBtn = new JButton("View Menu");
		menuBtn.setBounds(350, 190, 150, 30);
		menuBtn.addActionListener(this);
		panel.add(menuBtn);
		
		orderBtn = new JButton("My Order");
		orderBtn.setBounds(350, 230, 150, 30);
		orderBtn.addActionListener(this);
		panel.add(orderBtn);
		
		
		
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
		if(text.equals(orderBtn.getText()))
		{
			CustomerOrder co= new CustomerOrder(userId);
			co.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(menuBtn.getText()))
		{
			
			ViewMenu m = new ViewMenu(userId);
			m.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(backBtn.getText()))
		{
			Login log = new Login();
			log.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(myInfoBtn.getText()))
		{
			CustomerInfo ci=new CustomerInfo(userId);
			ci.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(changePasswordBtn.getText()))
		{
			ChangePassword cp = new ChangePassword(userId);
			cp.setVisible(true);
			this.setVisible(false);
		}
	}
}