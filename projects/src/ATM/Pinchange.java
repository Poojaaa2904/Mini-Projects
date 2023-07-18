package ATM;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;

public class Pinchange extends JFrame implements ActionListener {

	private JPanel contentPane;
	public JButton change,back;
	public JPasswordField enter,reenter;
	public JLabel l1,l2,l3;
	String pinnumber;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pinchange frame = new Pinchange("");
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
	public Pinchange(String pinnumber) {
		 this.pinnumber = pinnumber;
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(300, 00, 920, 920);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        JLabel lblNewLabel_1 = new JLabel("Change Your PIN");
	        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        lblNewLabel_1.setForeground(new Color(255, 255, 255));
	        lblNewLabel_1.setBounds(271, 196, 123, 25);
	        contentPane.add(lblNewLabel_1);

	        change = new JButton("Change");
	        change.addActionListener(this);
	        change.setBackground(new Color(255, 255, 255));
	        change.setFont(new Font("Tahoma", Font.BOLD, 15));
	        change.setBounds(413, 425, 109, 32);
	        contentPane.add(change);

	        back = new JButton("Back");
	        back.addActionListener(this);
	        back.setFont(new Font("Tahoma", Font.BOLD, 15));
	        back.setBackground(Color.WHITE);
	        back.setBounds(413, 461, 109, 32);
	        contentPane.add(back);

	        enter = new JPasswordField();
	        enter.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	        enter.setBounds(375, 250, 147, 32);
	        contentPane.add(enter);
	        enter.setColumns(10);

	        reenter = new JPasswordField();
	        reenter.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	        reenter.setBounds(375, 293, 147, 32);
	        contentPane.add(reenter);
	        enter.setColumns(10);
	        
	        l3 = new JLabel("RE-ENTER NEW PIN");
	        l3.setForeground(Color.WHITE);
	        l3.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        l3.setBounds(169, 296, 196, 25);
	        contentPane.add(l3);
	        	       	        
	        l2 = new JLabel("NEW PIN");
	        l2.setForeground(new Color(255, 255, 255));
	        l2.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        l2.setBounds(169, 250, 123, 25);
	        contentPane.add(l2);
	        
	        l1 = new JLabel("");
	        l1.setBounds(-15, -159, 894, 1080);
	        setUndecorated(true);
	        l1.setIcon(new ImageIcon("C:\\Users\\Pooja\\Downloads\\atm.jpg"));
	        contentPane.add(l1);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String epin=enter.getText();
		String repin=reenter.getText();
		if(e.getSource()==back)
		{
			setVisible(false);
			new transaction(pinnumber).setVisible(true);
		}
		if(e.getSource()==change) {
				if(!epin.equals(repin)) {
					JOptionPane.showMessageDialog(null, "Entered PIN does not match");
					return;
				}else if(epin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter the new PIN");
					return;
				} else if(repin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please re-enter the new PIN");
					return;
				}
		}	
			
			try {
				Conn cn= new Conn();
				cn.c.setAutoCommit(false);
			String query1="update bank set pin = ? where pin= ?";			
			PreparedStatement pstmt = cn.c.prepareStatement(query1);
			pstmt.setString(1,repin);
			pstmt.setString(2,pinnumber);
			pstmt.executeUpdate();
			
			String query2="update login set Pin_Number =? where Pin_Number=?";			
			pstmt = cn.c.prepareStatement(query2);
			pstmt.setString(1,repin);
			pstmt.setString(2,pinnumber);
			pstmt.executeUpdate();
			
			String query3="update signupthree set Pin_Number =? where Pin_Number =?";
			pstmt = cn.c.prepareStatement(query3);
			pstmt.setString(1,repin);
			pstmt.setString(2,pinnumber);
			pstmt.executeUpdate();
			
			 JOptionPane.showMessageDialog(null, "PIN changed successfully");
			 cn.c.commit();
             setVisible(false);
             new transaction(repin).setVisible(true);
             
             
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
	}

}
