
package ATM;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class Signupone extends JFrame implements ActionListener {
    private JPanel contentPane;
    long first;
   public JTextField name,fname, mname,email, address, city,pincode,state;
    public JDateChooser dateChooser;
    public JRadioButtonMenuItem male,female,married,unmarried,other;
    public JButton next;
    public ButtonGroup marital,gender;

 
    public Signupone() {
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

       Random ran = new Random();
         first = Math.abs(ran.nextLong() % 9000L) + 1000L;
      // String first = "" + Math.abs(first4);

        JLabel lblNewLabel_1 = new JLabel("APPLICATION FORM NO.  " +first);
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 33));
        lblNewLabel_1.setBounds(97, 23, 516, 49);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Personal Details");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2.setBounds(228, 78, 183, 31);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_2_1 = new JLabel("Name:");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2_1.setBounds(30, 130, 127, 31);
        contentPane.add(lblNewLabel_2_1);

        JLabel lblNewLabel_2_2 = new JLabel("Father's Name:");
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2_2.setBounds(30, 172, 183, 31);
        contentPane.add(lblNewLabel_2_2);

        JLabel lblNewLabel_2_2_1 = new JLabel("Mother's Name:");
        lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2_2_1.setBounds(30, 214, 183, 31);
        contentPane.add(lblNewLabel_2_2_1);

        JLabel lblNewLabel_2_2_2 = new JLabel("Date Of Birth:");
        lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2_2_2.setBounds(30, 256, 183, 31);
        contentPane.add(lblNewLabel_2_2_2);

        JLabel lblNewLabel_2_2_3 = new JLabel("Email Address:");
        lblNewLabel_2_2_3.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2_2_3.setBounds(30, 338, 183, 31);
        contentPane.add(lblNewLabel_2_2_3);

        JLabel lblNewLabel_2_2_4 = new JLabel("Marital Status:");
        lblNewLabel_2_2_4.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2_2_4.setBounds(30, 380, 183, 31);
        contentPane.add(lblNewLabel_2_2_4);

        JLabel lblNewLabel_2_2_5 = new JLabel("Address:");
        lblNewLabel_2_2_5.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2_2_5.setBounds(30, 422, 183, 31);
        contentPane.add(lblNewLabel_2_2_5);

        JLabel lblNewLabel_2_2_6 = new JLabel("City:");
        lblNewLabel_2_2_6.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2_2_6.setBounds(30, 464, 183, 31);
        contentPane.add(lblNewLabel_2_2_6);

        JLabel lblNewLabel_2_2_7 = new JLabel("Pin Code:");
        lblNewLabel_2_2_7.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2_2_7.setBounds(30, 506, 183, 31);
        contentPane.add(lblNewLabel_2_2_7);

        JLabel lblNewLabel_2_2_8 = new JLabel("Gender");
        lblNewLabel_2_2_8.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2_2_8.setBounds(30, 298, 183, 31);
        contentPane.add(lblNewLabel_2_2_8);

        JLabel lblNewLabel_2_2_9 = new JLabel("State:");
        lblNewLabel_2_2_9.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2_2_9.setBounds(30, 548, 183, 31);
        contentPane.add(lblNewLabel_2_2_9);

        name = new JTextField();
        name.setBounds(204, 138, 405, 23);
        contentPane.add(name);
        name.setColumns(10);

        fname = new JTextField();
        fname.setColumns(10);
        fname.setBounds(204, 172, 405, 23);
        contentPane.add(fname);

        mname = new JTextField();
        mname.setColumns(10);
        mname.setBounds(204, 207, 405, 31);
        contentPane.add(mname);

         male = new JRadioButtonMenuItem("Male");
        male.setFont(new Font("Segoe UI", Font.BOLD, 18));
        male.setBackground( Color.WHITE);
        male.setForeground(Color.BLACK);
        male.setBounds(204, 301, 133, 26);
        contentPane.add(male);

         female = new JRadioButtonMenuItem("Female");
        female.setForeground(Color.BLACK);
        female.setFont(new Font("Segoe UI", Font.BOLD, 18));
        female.setBackground(Color.WHITE);
        female.setBounds(437, 298, 133, 26);
        contentPane.add(female);

        email = new JTextField();
        email.setColumns(10);
        email.setBounds(204, 338, 405, 23);
        contentPane.add(email);

        address = new JTextField();
        address.setColumns(10);
        address.setBounds(208, 422, 405, 23);
        contentPane.add(address);

        city = new JTextField();
        city.setColumns(10);
        city.setBounds(208, 464, 405, 23);
        contentPane.add(city);

        pincode = new JTextField();
        pincode.setColumns(10);
        pincode.setBounds(208, 506, 405, 23);
        contentPane.add(pincode);

        state = new JTextField();
        state.setColumns(10);
        state.setBounds(204, 548, 405, 23);
        contentPane.add(state);

        dateChooser = new JDateChooser();
//        dateChooser.getCalendarButton().addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//            }});
        dateChooser.setBounds(204, 256, 405, 31);
        contentPane.add(dateChooser);


        married = new JRadioButtonMenuItem("Married");
        married.setForeground(Color.BLACK);
        married.setFont(new Font("Segoe UI", Font.BOLD, 18));
        married.setBackground(Color.WHITE);
        married.setBounds(204, 380, 133, 26);
        contentPane.add(married);

         unmarried = new JRadioButtonMenuItem("Unmarried");
        unmarried.setForeground(Color.BLACK);
        unmarried.setFont(new Font("Segoe UI", Font.BOLD, 18));
        unmarried.setBackground(Color.WHITE);
        unmarried.setBounds(355, 380, 133, 26);
        contentPane.add(unmarried);

         other = new JRadioButtonMenuItem("Other");
        other.setForeground(Color.BLACK);
        other.setFont(new Font("Segoe UI", Font.BOLD, 18));
        other.setBackground(Color.WHITE);
        other.setBounds(486, 380, 127, 26);
        contentPane.add(other);

        // Button Groups for Radio Buttons
        gender = new ButtonGroup();
        gender.add(male);
        gender.add(female);

        marital = new ButtonGroup();
        marital.add(married);
        marital.add(unmarried);
        marital.add(other);
        
        next = new JButton("NEXT");
        next.addActionListener(this);
        next.setBackground(new Color(0, 0, 0));
        next.setForeground(new Color(255, 255, 255));
        next.setFont(new Font("Tahoma", Font.BOLD, 18));
        next.setBounds(520, 611, 89, 31);
        contentPane.add(next);
        setVisible(true);
    }

//        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String Formno =""+first; // long
                String Name = name.getText();
                String FatherName = fname.getText();
                String MotherName = mname.getText();
                String Dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
                String gender = null;
                if (male.isSelected()) {
                    gender = "Male";
                } else if (female.isSelected()) {
                    gender = "Female";
                }
                String Email = email.getText();
                String marital = null;
                if (married.isSelected()) {
                    marital = "Married";
                } else if (unmarried.isSelected()) {
                    marital = "Unmarried";
                } else if (other.isSelected()) {
                    marital = "Other";
                }
                String Address = address.getText();
                String City = city.getText();
                String State = state.getText();
                String Pin = pincode.getText();

                try {
                	
                	
        		    Conn cn = new Conn();
        		 
        		  cn.c.setAutoCommit(false);
        		    String query = "insert into signup VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        		    PreparedStatement pstmt = cn.c.prepareStatement(query);
        		    pstmt.setString(1, Formno);
        		    pstmt.setString(2, Name);
        		    pstmt.setString(3, FatherName);
        		    pstmt.setString(4, MotherName);
        		    pstmt.setString(5, Dob);
        		    pstmt.setString(6, gender);
        		    pstmt.setString(7, Email);
        		    pstmt.setString(8, marital);
        		    pstmt.setString(9, Address);
        		    pstmt.setString(10, City);
        		    pstmt.setString(11, Pin);
        		    pstmt.setString(12, State);
        		    pstmt.executeUpdate();
        		    
        		    cn.c.commit();
        		    pstmt.close();
        		   // c.conn.close();
        		    setVisible(false);
        		    new Signuptwo().setVisible(true);
        		} catch (SQLException ep) {
        			System.out.println(ep);
        		}
            
       
    
    
    }
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signupone frame = new Signupone();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//new Signupone(); 
	}
	
	
}

