import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ViewMenu extends JFrame implements ActionListener
{
	
	JLabel imgLabel;
	JButton logoutBtn, backBtn;
	JPanel panel;
	ImageIcon img;
	String userId;
	
	public ViewMenu(String userId)
	{
        super("Restaurant Management System - customer - view menu");
        this.setSize(790, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.userId=userId;
        
		panel = new JPanel();
		//panel.setLayout(null);
		
		img = new ImageIcon("menu.png");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(0,0, 790, 480);
		panel.add(imgLabel);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 10, 120, 30);
		logoutBtn.addActionListener(this);
		this.add(logoutBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 400, 120, 30);
		backBtn.addActionListener(this);
		backBtn.repaint();
		backBtn.setVisible(true);
		this.add(backBtn);
		
		
		 this.add(panel);
		 this.setVisible(true);
		
	}	
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(text.equals(backBtn.getText()))
		{
			CustomerHome ch = new CustomerHome(userId);
			ch.setVisible(true);
			this.setVisible(false);
		}
		
		
		else if(text.equals(logoutBtn.getText()))
		{
			Login log=new Login();
			log.setVisible(true);
			this.setVisible(false);
		}
		
	}

}
