import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Register extends JFrame implements ActionListener{
	
	JLabel tittle;
	JButton custBtn, manaBtn, backBtn;
	JPanel panel;
	String userId;
	
	public Register()
	{
		super("Restaurant Management System - Register");
		
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.userId = userId;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		tittle= new JLabel("Register Now");
		tittle.setBounds(350,100, 100, 40);
		panel.add(tittle);
		
		
		custBtn= new JButton("Customer");
		custBtn.setBounds(250, 150, 275, 30);
		custBtn.addActionListener(this);
		panel.add(custBtn);
		
		manaBtn= new JButton("Manager");
		manaBtn.setBounds(250, 200, 275, 30);
		manaBtn.addActionListener(this);
		panel.add(manaBtn);
		
		
		
	
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
			Login log = new Login();
			log.setVisible(true);
			this.dispose();
		}
		
		
		else if(text.equals(custBtn.getText()))
		{
			RegCustomer c=new RegCustomer();
			c.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(manaBtn.getText()))
		{
			RegManager m=new RegManager();
			m.setVisible(true);
			this.setVisible(false);
		}
	}

}
