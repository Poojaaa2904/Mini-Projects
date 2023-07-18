package ATM;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class Signupthree extends JFrame implements ActionListener {

    private JPanel contentPane;
    public JRadioButton savingaccount, currentaccount, fixeddepositaccount, recurringdepositaccount;
    public JCheckBox atm, internetbanking, mobilebanking, chequebook, estatement, emailsms, declare;
    public ButtonGroup accounttype;
    long cardnum, pinnum;
    public JLabel pin, servicesrequired, card;
    public JButton submit, cancel;
    public String formno;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Signupthree frame = new Signupthree("FormNo");
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
    public Signupthree(String formno) {
        this.formno = formno;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 120, 650, 700);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Pooja\\Desktop\\icon\\logo.jpg"));
        lblNewLabel.setBounds(10, 11, 77, 61);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("Page 3: Account Details");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2.setBounds(206, 27, 240, 31);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_2_1 = new JLabel("Account Type");
        lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_2_1.setBounds(27, 105, 144, 31);
        contentPane.add(lblNewLabel_2_1);

        savingaccount = new JRadioButton("Saving Account");
        savingaccount.setFont(new Font("Tahoma", Font.BOLD, 13));
        savingaccount.setBackground(new Color(255, 255, 255));
        savingaccount.setBounds(27, 143, 144, 23);
        contentPane.add(savingaccount);

        currentaccount = new JRadioButton("Current Account");
        currentaccount.setFont(new Font("Tahoma", Font.BOLD, 13));
        currentaccount.setBackground(Color.WHITE);
        currentaccount.setBounds(27, 173, 144, 23);
        contentPane.add(currentaccount);

        fixeddepositaccount = new JRadioButton("Fixed Deposit Account");
        fixeddepositaccount.setFont(new Font("Tahoma", Font.BOLD, 13));
        fixeddepositaccount.setBackground(Color.WHITE);
        fixeddepositaccount.setBounds(286, 144, 292, 23);
        contentPane.add(fixeddepositaccount);

        recurringdepositaccount = new JRadioButton("Recurring Deposit Account");
        recurringdepositaccount.setFont(new Font("Tahoma", Font.BOLD, 13));
        recurringdepositaccount.setBackground(Color.WHITE);
        recurringdepositaccount.setBounds(286, 174, 292, 23);
        contentPane.add(recurringdepositaccount);

        card = new JLabel("Card Number");
        card.setFont(new Font("Times New Roman", Font.BOLD, 20));
        card.setBounds(27, 247, 144, 31);
        contentPane.add(card);

        JLabel lblNewLabel_1 = new JLabel(" Your 16 digit card number");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblNewLabel_1.setBounds(27, 272, 144, 14);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2_1_1_1 = new JLabel("PIN");
        lblNewLabel_2_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_2_1_1_1.setBounds(27, 310, 144, 31);
        contentPane.add(lblNewLabel_2_1_1_1);

        JLabel lblNewLabel_1_1 = new JLabel(" Your 4 digit pin number");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblNewLabel_1_1.setBounds(27, 335, 144, 14);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_2_1_2 = new JLabel("Services Required:");
        lblNewLabel_2_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_2_1_2.setBounds(27, 381, 169, 31);
        contentPane.add(lblNewLabel_2_1_2);

        JLabel lblNewLabel_2_1_1_2 = new JLabel("XXXX-XXXX-XXXX-4184");
        lblNewLabel_2_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_2_1_1_2.setBounds(302, 247, 297, 31);
        contentPane.add(lblNewLabel_2_1_1_2);

        JLabel lblNewLabel_2_1_1_3 = new JLabel("XXXX");
        lblNewLabel_2_1_1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_2_1_1_3.setBounds(302, 310, 144, 31);
        contentPane.add(lblNewLabel_2_1_1_3);

        atm = new JCheckBox("ATM CARD");
        atm.setFont(new Font("Times New Roman", Font.BOLD, 13));
        atm.setBackground(new Color(255, 255, 255));
        atm.setBounds(27, 417, 97, 23);
        contentPane.add(atm);

        mobilebanking = new JCheckBox("Mobile Banking");
        mobilebanking.setFont(new Font("Times New Roman", Font.BOLD, 13));
        mobilebanking.setBackground(Color.WHITE);
        mobilebanking.setBounds(27, 457, 127, 23);
        contentPane.add(mobilebanking);

        chequebook = new JCheckBox("Cheque Book");
        chequebook.setFont(new Font("Times New Roman", Font.BOLD, 13));
        chequebook.setBackground(Color.WHITE);
        chequebook.setBounds(27, 502, 127, 23);
        contentPane.add(chequebook);

        internetbanking = new JCheckBox("Internet Banking");
        internetbanking.setFont(new Font("Times New Roman", Font.BOLD, 13));
        internetbanking.setBackground(Color.WHITE);
        internetbanking.setBounds(288, 417, 127, 23);
        contentPane.add(internetbanking);

        emailsms = new JCheckBox("EMAIL & SMS alerts");
        emailsms.setFont(new Font("Times New Roman", Font.BOLD, 13));
        emailsms.setBackground(Color.WHITE);
        emailsms.setBounds(288, 457, 144, 23);
        contentPane.add(emailsms);

        estatement = new JCheckBox("E-Statement");
        estatement.setFont(new Font("Times New Roman", Font.BOLD, 13));
        estatement.setBackground(Color.WHITE);
        estatement.setBounds(286, 502, 127, 23);
        contentPane.add(estatement);

        declare = new JCheckBox("I hereby declares  that the above entered details  are correct to the best of my knowlwdge .");
        declare.setFont(new Font("Times New Roman", Font.BOLD, 13));
        declare.setBackground(Color.WHITE);
        declare.setBounds(27, 565, 590, 23);
        contentPane.add(declare);

        accounttype = new ButtonGroup();
        accounttype.add(savingaccount);
        accounttype.add(currentaccount);
        accounttype.add(recurringdepositaccount);
        accounttype.add(fixeddepositaccount);

        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(370, 614, 89, 23);
        contentPane.add(cancel);

        submit = new JButton("Submit");
        submit.addActionListener(this);
        submit.setFont(new Font("Times New Roman", Font.BOLD, 18));
        submit.setForeground(new Color(255, 255, 255));
        submit.setBackground(new Color(0, 0, 0));
        submit.setBounds(107, 612, 104, 23);
        contentPane.add(submit);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String accounttype = null;
        if (savingaccount.isSelected()) {
            accounttype = "Saving Account";
        } else if (currentaccount.isSelected()) {
            accounttype = "Current Account";
        } else if (recurringdepositaccount.isSelected()) {
            accounttype = "Recurring Deposit Account";
        } else if (fixeddepositaccount.isSelected()) {
            accounttype = "Fixed Deposit Account";
        }

        Random ran = new Random();
        String cardnum = "" + Math.abs((ran.nextLong() % 90000000L) + 5024789300000000L);
        String pinnumber = "" + Math.abs((ran.nextLong() % 9000L) + 1000L);

        String servicerequired = "";
        if (atm.isSelected()) {
            servicerequired += " ATM Card";
        }
        if (internetbanking.isSelected()) {
            servicerequired += " Internet Banking";
        }
        if (mobilebanking.isSelected()) {
            servicerequired += " Mobile Banking";
        }
        if (chequebook.isSelected()) {
            servicerequired += " Cheque Book";
        }
        if (estatement.isSelected()) {
            servicerequired += " E-Statement";
        }
        if (emailsms.isSelected()) {
            servicerequired += " Email & SMS";
        }

        try {
            if (e.getSource() == submit) 
            {
                if (accounttype == null) {
                    JOptionPane.showMessageDialog(null, "Account type is required");}
                else if(!declare.isSelected()){
                        JOptionPane.showMessageDialog(null, "Please click on the declaration box");}
            				
            		else {
                    Conn cn = new Conn();
                    cn.c.setAutoCommit(false);

                    String query1 = "insert into signupthree VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement pstmt = cn.c.prepareStatement(query1);
                    pstmt.setString(1, formno);
                    pstmt.setString(2, accounttype);
                    pstmt.setString(3, cardnum);
                    pstmt.setString(4, pinnumber);
                    pstmt.setString(5, servicerequired);
                    pstmt.executeUpdate();
                    String query2 = "insert into login VALUES (?, ?, ?)";
                    pstmt = cn.c.prepareStatement(query2);
                    pstmt.setString(1, formno);
                    pstmt.setString(2, cardnum);
                    pstmt.setString(3, pinnumber);
                    
                    pstmt.executeUpdate();


                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnum + "\nPin Number: " + pinnum);

                    cn.c.commit();
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }

            } 
        else if (e.getSource() == cancel) {
                System.exit(0);
                new Login(pinnumber).setVisible(true);
            }
    
        } catch (Exception ep) {
            System.out.println(ep);
        }

    }
}
