package ATM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//public class hello extends JFrame {

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	public JTextField cardnum;
	public JPasswordField pin;
	public JButton signup,signin,clear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login("");
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
	public Login(String pinnumber) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 550, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().setLayout(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to ATM");
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setBounds(178, 71, 239, 58);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Pooja\\Desktop\\icon\\logo.jpg"));
		lblNewLabel_1.setBounds(34, 60, 79, 74);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Card Number");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(10, 190, 142, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Pin");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(10, 262, 142, 32);
		contentPane.add(lblNewLabel_2_1);
		
		cardnum = new JTextField();
		cardnum.setBounds(178, 194, 346, 32);
		cardnum.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(cardnum);
		cardnum.setColumns(10);
		
		pin = new JPasswordField();
		pin.setColumns(10);
		pin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pin.setBounds(178, 262, 346, 32);
		contentPane.add(pin);
		
		signin = new JButton("SIGN IN");
		signin.addActionListener(this);
		signin.setBackground(new Color(0, 0, 0));
		signin.setForeground(new Color(248, 248, 255));
		signin.setFont(new Font("Tahoma", Font.BOLD, 18));
		signin.setBounds(128, 360, 112, 32);
		contentPane.add(signin);
		
		clear = new JButton("CLEAR");
		clear.addActionListener(this);		
		clear.setForeground(new Color(248, 248, 255));
		clear.setFont(new Font("Tahoma", Font.BOLD, 18));
		clear.setBackground(Color.BLACK);
		clear.setBounds(277, 360, 112, 32);
		contentPane.add(clear);
		
		signup = new JButton("SIGN UP");
		signup.addActionListener(this); 
		signup.setForeground(new Color(248, 248, 255));
		signup.setFont(new Font("Tahoma", Font.BOLD, 18));
		signup.setBackground(Color.BLACK);
		signup.setBounds(204, 423, 112, 32);
		contentPane.add(signup);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==clear) 
		{
			cardnum.setText("");
			pin.setText("");
		}else if (e.getSource()==signup) {
			setVisible(false);
			new Signupone().setVisible(true);
		}else if(e.getSource()==signin) {
			Conn cn=new Conn();
			String cardnumber=cardnum.getText();
			String pinnumber=pin.getText();
			
			String query= "select* from login where Card_Number='"+cardnumber+"'and Pin_Number='"+pinnumber+"'";
			try {
			ResultSet rs=cn.st.executeQuery(query);
			if(rs.next()) {
				setVisible(true);
				new transaction(pinnumber).setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
			}
			
			}catch(Exception ep) {
				
			}
			
			
		}
	}
}

