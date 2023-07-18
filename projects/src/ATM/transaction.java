package ATM;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class transaction extends JFrame implements ActionListener {

	private JPanel contentPane;
	public JButton deposit,cashwithdrawl,fastcash,exit,ministatement,pinchange,balanceenquiry;
	String pinnumber;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					transaction frame = new transaction("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param pinnumber 
	 */
	public transaction(String pinnumber) 
	{	
		this.pinnumber=pinnumber;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 00, 920, 920);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Please Select your transaction");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(new Color(230, 230, 250));
		lblNewLabel_1.setBounds(275, 196, 221, 25);
		contentPane.add(lblNewLabel_1);
		
		deposit = new JButton("Deposit");
		deposit.addActionListener(this);
		deposit.setBackground(new Color(255, 255, 255));
		deposit.setFont(new Font("Tahoma", Font.BOLD, 15));
		deposit.setBounds(160, 347, 171, 32);
		contentPane.add(deposit);
		
		fastcash = new JButton("Fast Cash");
		fastcash.addActionListener(this);
		fastcash.setFont(new Font("Tahoma", Font.BOLD, 15));
		fastcash.setBackground(Color.WHITE);
		fastcash.setBounds(160, 390, 171, 32);
		contentPane.add(fastcash);
		
		pinchange = new JButton("Pin Change");
		pinchange.addActionListener(this);
		pinchange.setFont(new Font("Tahoma", Font.BOLD, 15));
		pinchange.setBackground(Color.WHITE);
		pinchange.setBounds(160, 430, 171, 32);
		contentPane.add(pinchange);
		
		cashwithdrawl = new JButton("Cash Withdrawl");
		cashwithdrawl.addActionListener(this);
		cashwithdrawl.setFont(new Font("Tahoma", Font.BOLD, 15));
		cashwithdrawl.setBackground(Color.WHITE);
		cashwithdrawl.setBounds(360, 347, 171, 32);
		contentPane.add(cashwithdrawl);
		
		balanceenquiry = new JButton("Balance Enquiry");
		balanceenquiry.addActionListener(this);
		balanceenquiry.setFont(new Font("Tahoma", Font.BOLD, 15));
		balanceenquiry.setBackground(Color.WHITE);
		balanceenquiry.setBounds(360, 430, 171, 32);
		contentPane.add(balanceenquiry);
		
		ministatement = new JButton("Mini Statement");
		ministatement.addActionListener(this);
		ministatement.setFont(new Font("Tahoma", Font.BOLD, 15));
		ministatement.setBackground(Color.WHITE);
		ministatement.setBounds(360, 390, 171, 32);
		contentPane.add(ministatement);
		
		exit = new JButton("Exit");
		exit.addActionListener(this);
		exit.setFont(new Font("Tahoma", Font.BOLD, 15));
		exit.setBackground(Color.WHITE);
		exit.setBounds(360, 470, 171, 32);
		contentPane.add(exit);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-15, -159, 894, 1080);
		setUndecorated(true);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Pooja\\Downloads\\atm.jpg"));
		contentPane.add(lblNewLabel);
	}


	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==exit) {
			System.exit(0);
		}else if(e.getSource()==deposit) {
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
		}else if (e.getSource()==cashwithdrawl){
			setVisible(false);
			new Withdrawl(pinnumber).setVisible(true);
			
		}else if (e.getSource()==fastcash) {
			setVisible(false);
			new Fastcash(pinnumber).setVisible(true);
			
		}else if(e.getSource()==pinchange) {
			setVisible(false);
			new Pinchange(pinnumber).setVisible(true);
		}else if(e.getSource()==ministatement) {
			setVisible(false);
			new Ministatement(pinnumber).setVisible(true);
		
		}else if (e.getSource()==balanceenquiry) {
			setVisible(false);
			new Enquiry(pinnumber).setVisible(true);
		}
	}
}
