import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AddEmployee extends JFrame implements ActionListener{
	
	JButton chefBtn, waiterBtn, delBtn, backBtn, logoutBtn;
	JPanel panel;
	String userId;
	
	public AddEmployee(String userId)
	{
		super("Restaurant Management System - Add Employee");
		
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
		
		chefBtn= new JButton("Chef");
		chefBtn.setBounds(250, 100, 275, 30);
		chefBtn.addActionListener(this);
		panel.add(chefBtn);
		
		waiterBtn= new JButton("Waiter");
		waiterBtn.setBounds(250, 200, 275, 30);
		waiterBtn.addActionListener(this);
		panel.add(waiterBtn);
		
		
		
	
		backBtn = new JButton("Back");
		backBtn.setBounds(500, 400, 120, 30);
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
			ManageEmployee me = new ManageEmployee(userId);
			me.setVisible(true);
			this.dispose();
		}
		
		else if(text.equals(logoutBtn.getText()))
		{
			Login log = new Login();
			log.setVisible(true);
			this.dispose();
		}
		
		else if(text.equals(chefBtn.getText()))
		{
			AddChef c=new AddChef(userId);
			c.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(waiterBtn.getText()))
		{
			AddWaiter w=new AddWaiter(userId);
			w.setVisible(true);
			this.setVisible(false);
		}
	}
	
	
	
	

}
