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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Withdrawl extends JFrame implements ActionListener{

	private JPanel contentPane;
	String pinnumber;
	public JButton withdraw,back;
	public JTextField number;
	public JLabel l1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdrawl frame = new Withdrawl("");
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
	public Withdrawl(String pinnumber) {
		this.pinnumber=pinnumber;
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(300, 00, 920, 920);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		getContentPane().setLayout(null);
//		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-15, -159, 894, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 00, 920, 920);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Enter the amount you want to withdraw");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1.setForeground(new Color(230, 230, 250));
        lblNewLabel_1.setBounds(166, 196, 330, 25);
        contentPane.add(lblNewLabel_1);

        withdraw = new JButton("Withdraw");
        withdraw.addActionListener(this);
        withdraw.setBackground(new Color(255, 255, 255));
        withdraw.setFont(new Font("Tahoma", Font.BOLD, 15));
        withdraw.setBounds(413, 425, 109, 32);
        contentPane.add(withdraw);

        back = new JButton("Back");
        back.addActionListener(this);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.setBackground(Color.WHITE);
        back.setBounds(413, 461, 109, 32);
        contentPane.add(back);

        number = new JTextField();
        number.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        number.setBounds(165, 244, 357, 32);
        contentPane.add(number);
        number.setColumns(10);

        JLabel lblNewLabel1 = new JLabel("");
        lblNewLabel1.setBounds(-15, -159, 894, 1080);
        setUndecorated(true);
        lblNewLabel1.setIcon(new ImageIcon("C:\\Users\\Pooja\\Downloads\\atm.jpg"));
		contentPane.add(lblNewLabel1);
		setUndecorated(true);
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{		 	String amount = number.getText();
			    Date currentDate = new Date();
			    String date = currentDate.toString();
        if (e.getSource() == withdraw) 
        	{           
            if (amount.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the amount to be withdraw.");
            }
              else {
                try {
                	Conn cn =new Conn();
                	int balance =0;
    				ResultSet rs=cn.st.executeQuery("select *from bank where pin = '"+pinnumber+"'");
    				
    				while(rs.next()) {
    					if(rs.getString("type").equals("Deposit")) {
    						balance+=Integer.parseInt(rs.getString("amount"));					
    					}else {
    						balance-=Integer.parseInt(rs.getString("amount"));
    					}
    						
    				
    				if(e.getSource()!= back && balance < Integer.parseInt(amount)) {
    				JOptionPane.showMessageDialog(null, "Insuffiecient balance");
    				return;}}
    			
    				String query = "INSERT INTO bank VALUES (?, ?, ?, ?)";
                    PreparedStatement pstmt = cn.c.prepareStatement(query);
                    pstmt.setString(1, pinnumber);
                    pstmt.setString(2, date);
                    pstmt.setString(3, "Withdraw");
                    pstmt.setString(4, amount);

                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " withdrawl successfully.");

                    cn.c.commit();
                    setVisible(false);
                    new transaction(pinnumber).setVisible(true);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }

        } else if (e.getSource() == back) {
            setVisible(false);
            new transaction(pinnumber).setVisible(true);
        }
    }
}
