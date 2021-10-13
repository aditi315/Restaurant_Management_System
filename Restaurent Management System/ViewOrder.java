import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ViewOrder extends JFrame implements ActionListener
{
	private JLabel title;
	private JButton logoutBtn,backBtn,orderBtn1,orderBtn2,orderBtn3;
	private JPanel panel;
	private String userId;
	
	public ViewOrder(String userId)
	{
		super("View Order");
		this.setSize(800, 450);
		this.userId=userId;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("View Order");
		title.setBounds(380, 50, 350, 30);
		panel.add(title);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 50, 120, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 330, 120, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		orderBtn1 = new JButton("Order 1");
		orderBtn1.setBounds(30, 100, 200, 200);
		orderBtn1.addActionListener(this);
		panel.add(orderBtn1);
		
		orderBtn2 = new JButton("Order 2");
		orderBtn2.setBounds(270, 100, 200, 200);
		orderBtn2.addActionListener(this);
		panel.add(orderBtn2);
		
		orderBtn3 = new JButton("Order 3");
		orderBtn3.setBounds(520, 100, 200, 200);
		orderBtn3.addActionListener(this);
		panel.add(orderBtn3);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(text.equals(backBtn.getText()))
		{
			new ChefHome(userId).setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(logoutBtn.getText()))
		{
			new Login().setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(orderBtn1.getText()))
		{
			new OrderFirst(userId);
			this.setVisible(false);
		}
		else if(text.equals(orderBtn2.getText()))
		{
			new OrderSecond(userId);
			this.setVisible(false);
		}
		else if(text.equals(orderBtn3.getText()))
		{
			new OrderThird(userId);
			this.setVisible(false);
		}
		
	}
}