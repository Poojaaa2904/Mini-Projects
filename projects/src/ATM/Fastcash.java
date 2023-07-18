package ATM;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Fastcash extends JFrame implements ActionListener {

	private JPanel contentPane;
	public JButton r100,r500,r1000,r2000,r5000,r10000,back;
	String pinnumber;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fastcash frame = new Fastcash("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Fastcash(String pinnumber) {
		this.pinnumber=pinnumber;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 00, 920, 920);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Please select the amount you want to withdraw");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(new Color(230, 230, 250));
		lblNewLabel_1.setBounds(176, 196, 355, 25);
		contentPane.add(lblNewLabel_1);
		
		r100 = new JButton("Rs 100");
		r100.addActionListener(this);
		r100.setBackground(new Color(255, 255, 255));
		r100.setFont(new Font("Tahoma", Font.BOLD, 15));
		r100.setBounds(160, 347, 171, 32);
		contentPane.add(r100);
		
		r500 = new JButton("Rs 500");
		r500.addActionListener(this);
		r500.setFont(new Font("Tahoma", Font.BOLD, 15));
		r500.setBackground(Color.WHITE);
		r500.setBounds(160, 390, 171, 32);
		contentPane.add(r500);
		
		r1000 = new JButton("Rs 1000");
		r1000.addActionListener(this);
		r1000.setFont(new Font("Tahoma", Font.BOLD, 15));
		r1000.setBackground(Color.WHITE);
		r1000.setBounds(160, 430, 171, 32);
		contentPane.add(r1000);
		
		r2000 = new JButton("Rs 2000");
		r2000.addActionListener(this);
		r2000.setFont(new Font("Tahoma", Font.BOLD, 15));
		r2000.setBackground(Color.WHITE);
		r2000.setBounds(360, 347, 171, 32);
		contentPane.add(r2000);
		
		r5000 = new JButton("Rs 5000");
		r5000.addActionListener(this);
		r5000.setFont(new Font("Tahoma", Font.BOLD, 15));
		r5000.setBackground(Color.WHITE);
		r5000.setBounds(360, 430, 171, 32);
		contentPane.add(r5000);
		
		r10000 = new JButton("Rs 10000");
		r10000.addActionListener(this);
		r10000.setFont(new Font("Tahoma", Font.BOLD, 15));
		r10000.setBackground(Color.WHITE);
		r10000.setBounds(360, 390, 171, 32);
		contentPane.add(r10000);
		
		back = new JButton("Back");
		back.addActionListener(this);
		back.setFont(new Font("Tahoma", Font.BOLD, 15));
		back.setBackground(Color.WHITE);
		back.setBounds(360, 470, 171, 32);
		contentPane.add(back);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-15, -159, 894, 1080);
		setUndecorated(true);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Pooja\\Downloads\\atm.jpg"));
		contentPane.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			 setVisible(false);
	           new transaction(pinnumber).setVisible(true);
		}else 
			{
				String amount=((JButton)e.getSource()).getText().substring(3);
				Conn cn= new Conn();
				
			  try {
				  cn.c.setAutoCommit(false);
				ResultSet rs=cn.st.executeQuery("select *from bank where pin = '"+pinnumber+"'");
				int balance =0; 
				while(rs.next())
					{
						if(rs.getString("type").equals("Deposit")) 
							{
								balance+=Integer.parseInt(rs.getString("amount"));					
							 	}else 
							 	{
							 		balance-=Integer.parseInt(rs.getString("amount"));
							 	}
						
				
								if(e.getSource()!= back && balance < Integer.parseInt(amount)) 
								{
									JOptionPane.showMessageDialog(null, "Insuffiecient balance");
									return;
								 }
						  }								 							  
							Date currentdate= new Date();
							String date=currentdate.toString();
							String query = "INSERT INTO bank VALUES (?, ?, ?, ?)";
			                PreparedStatement pstmt = cn.c.prepareStatement(query);
			                pstmt.setString(1, pinnumber);
			                pstmt.setString(2, date);
			                pstmt.setString(3, "Withdraw");
			                pstmt.setString(4, amount);
			                
			                pstmt.executeUpdate();
			                JOptionPane.showMessageDialog(null,"Rs "+amount+" is debited successfully");
			                cn.c.commit();
			                setVisible(false);
			                new transaction(pinnumber).setVisible(true);
				}//try
			catch(Exception ec) {
				System.out.println(ec);
			}
		}
	}//esle
}

