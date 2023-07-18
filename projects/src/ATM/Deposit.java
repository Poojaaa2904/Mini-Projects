package ATM;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Deposit extends JFrame implements ActionListener {

    private JPanel contentPane;
   public JButton deposit, back;
   public JTextField amount;
   public String pinnumber;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Deposit frame = new Deposit("");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Deposit(String pinnumber) {
        this.pinnumber = pinnumber;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 00, 920, 920);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Enter the amount you want to deposit");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1.setForeground(new Color(230, 230, 250));
        lblNewLabel_1.setBounds(166, 196, 330, 25);
        contentPane.add(lblNewLabel_1);

        deposit = new JButton("Deposit");
        deposit.addActionListener(this);
        deposit.setBackground(new Color(255, 255, 255));
        deposit.setFont(new Font("Tahoma", Font.BOLD, 15));
        deposit.setBounds(413, 425, 109, 32);
        contentPane.add(deposit);

        back = new JButton("Back");
        back.addActionListener(this);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.setBackground(Color.WHITE);
        back.setBounds(413, 461, 109, 32);
        contentPane.add(back);

        amount = new JTextField();
        amount.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        amount.setBounds(165, 244, 357, 32);
        contentPane.add(amount);
        amount.setColumns(10);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(-15, -159, 894, 1080);
        setUndecorated(true);
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Pooja\\Downloads\\atm.jpg"));
        contentPane.add(lblNewLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deposit) {
            String number = amount.getText();
            Date currentDate = new Date();
            String date = currentDate.toString();

            if (number.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the amount to be deposited.");
            } else {
                try {
                    Conn cn = new Conn();
                    cn.c.setAutoCommit(false);
                    String query = "INSERT INTO bank VALUES (?, ?, ?, ?)";
                    PreparedStatement pstmt = cn.c.prepareStatement(query);
                    pstmt.setString(1, pinnumber);
                    pstmt.setString(2, date);
                    pstmt.setString(3, "Deposit");
                    pstmt.setString(4, number);

                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Rs. " + number + " deposited successfully.");

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
