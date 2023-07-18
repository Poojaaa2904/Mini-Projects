package ATM;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ministatement extends JFrame {

	private JPanel contentPane;
	public JLabel title,card,mini,bal;
	public JButton back;
	String pinnumber;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ministatement frame = new Ministatement("");
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
	public Ministatement(String pinnumber) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 120, 400, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().setLayout(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		title = new JLabel("Apna Bank");
        title.setFont(new Font("Tahoma", Font.BOLD, 18));
        title.setForeground(new Color(0, 0, 0));
        title.setBounds(149, 11, 113, 25);
        contentPane.add(title);
        
        card = new JLabel("");
        card.setForeground(Color.BLACK);
        card.setFont(new Font("Tahoma", Font.PLAIN, 16));
        card.setBounds(20, 97, 354, 25);
        contentPane.add(card);
        
        JLabel mini = new JLabel("");
        mini.setForeground(Color.BLACK);
        mini.setFont(new Font("Tahoma", Font.PLAIN, 16));
        mini.setBounds(20, 145, 354, 334);
        contentPane.add(mini);
        
        
        
        Conn cn = new Conn();
        try {
			ResultSet rs=cn.st.executeQuery("select *from login where Pin_Number = '"+pinnumber+"'");
			while(rs.next()) {
				card.setText("Card Number: "+rs.getString("Card_Number").substring(0,4)+"XXXXXXXX"+rs.getString("Card_Number").substring(12));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
        //Conn cn = new Conn();
	try {
		ResultSet rs=cn.st.executeQuery("select *from bank where pin = '"+pinnumber+"'");
		while(rs.next()) {
			mini.setText(mini.getText() +"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 int balance =0;
  
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
		JLabel bal = new JLabel("Your current balance is Rs. "+balance);
        bal.setForeground(Color.BLACK);
        bal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        bal.setBounds(10, 525, 354, 25);
        contentPane.add(bal);
	}
		
	
}
