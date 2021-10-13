import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ManagerMyInfo extends JFrame implements ActionListener 
{
	JLabel title, eNameLabel,userLabel, addressLabel, salaryLabel;
	JTextField eNameTF,userTF, addressTF, salaryTF;
	JButton logoutBtn,backBtn;
	JPanel panel;
	String userId;
	
	public ManagerMyInfo(String userId)
	{
		super("Manager Information");
		this.userId = userId;
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("MANAGER INFO");
		title.setBounds(380, 50, 350, 30);
		panel.add(title);
		
		eNameLabel = new JLabel("Name :");
		eNameLabel.setBounds(322, 110, 60, 30);
		panel.add(eNameLabel);
		
		eNameTF = new JTextField();
		eNameTF.setBounds(390, 110, 100, 30);
		eNameTF.setEditable(false);
		panel.add(eNameTF);
		
		userLabel = new JLabel("User ID :");
		userLabel.setBounds(322, 150, 70, 30);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(390, 150, 100, 30);
		userTF.setEditable(false);
		panel.add(userTF);
		
		addressLabel = new JLabel("Address :");
		addressLabel.setBounds(322, 190, 70, 30);
		panel.add(addressLabel);
		
		addressTF = new JTextField();
		addressTF.setBounds(390, 190, 100, 30);
		addressTF.setEditable(false);
		panel.add(addressTF);
		
		salaryLabel = new JLabel("Salary :");
		salaryLabel.setBounds(322, 230, 70, 30);
		panel.add(salaryLabel);
		
		salaryTF = new JTextField();
		salaryTF.setBounds(390, 230, 100, 30);
		salaryTF.setEditable(false);
		panel.add(salaryTF);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 50, 120, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 300, 120, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
		this.setVisible(true);
		
		displayinfo(userId);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		
		if(text.equals(backBtn.getText()))
		{
			ManagerHome mh = new ManagerHome(userId);
			mh.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(logoutBtn.getText()))
		{
			Login log = new Login();
			log.setVisible(true);
			this.setVisible(false);
		}
	}
	
	public void displayinfo(String userId)
	{
		 String uid;
		String eName;
		String address;
		double salary;
				
		String query = "SELECT `userId`, `name`, `address`, `salary` FROM `manager`;";     
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a02","root","");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
			
			boolean flag = false;
			
				while(rs.next())
			{
				String u= rs.getString("userId");
				
				if(u.equals(this.userId))
				{
				  uid=rs.getString("userId");
				eName = rs.getString("name");
				 address=rs.getString("address");
				 salary = rs.getDouble("salary");
				flag=true;
				
				userTF.setText(uid);
				eNameTF.setText(eName);
				addressTF.setText(address);
				salaryTF.setText(""+salary);
				}
			}	
			
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
        finally
		{
            try
			{
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
        }
		
	}
	
	
	
}
