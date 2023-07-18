package ATM;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Enquiry extends JFrame implements ActionListener{

	private JPanel contentPane;
	public JLabel l1,l2,l3;
	public JButton back;
	String pinnumber;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enquiry frame = new Enquiry("");
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
	public Enquiry(String pinnumber) {
		  this.pinnumber = pinnumber;
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(300, 00, 920, 920);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	        setContentPane(contentPane);
	        contentPane.setLayout(null);
	        
	        int balance =0;
	        Conn cn= new Conn();
			try {
				ResultSet rs=cn.st.executeQuery("select *from bank where pin = '"+pinnumber+"'");
				
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance +=Integer.parseInt(rs.getString("amount"));					
					}else {
						balance -=Integer.parseInt(rs.getString("amount"));
					}
				}}	
				catch(Exception ep) {
					System.out.println(ep);
				}
				 l3 = new JLabel("Your current balance is Rs. "+balance);
			        l3.setForeground(new Color(255, 255, 255));
			        l3.setFont(new Font("Tahoma", Font.PLAIN, 16));
			        l3.setBounds(169, 250, 235, 25);
			        contentPane.add(l3);
				
			l2 = new JLabel("Apna Bank");
	        l2.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        l2.setForeground(new Color(255, 255, 255));
	        l2.setBounds(293, 196, 123, 25);
	        contentPane.add(l2);
		
	        back = new JButton("Back");
	        back.addActionListener(this);
	        back.setFont(new Font("Tahoma", Font.BOLD, 15));
	        back.setBackground(Color.WHITE);
	        back.setBounds(413, 461, 109, 32);
	        contentPane.add(back); 
	        
		  l1 = new JLabel("");
	        l1.setBounds(-15, -159, 894, 1080);
	        setUndecorated(true);
	        l1.setIcon(new ImageIcon("C:\\Users\\Pooja\\Downloads\\atm.jpg"));
	        contentPane.add(l1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new transaction(pinnumber).setVisible(true);
		
	}

}
