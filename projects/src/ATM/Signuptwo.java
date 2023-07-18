
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Signuptwo extends JFrame implements ActionListener {
    private JPanel contentPane;
  public JComboBox religion,category, education,income, occupation;
   public JTextField pan,aadhar;   
    public JRadioButtonMenuItem existyes,existno,senyes,senno;
    public JButton next;
    public ButtonGroup scitizen, eaccount; 
    String formno;
 
    public Signuptwo() 
     {
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


        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
      

        JLabel lblNewLabel_2 = new JLabel("Page 2: Additional Details");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2.setBounds(204, 78, 240, 31);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_2_1 = new JLabel("Religion:");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2_1.setBounds(30, 130, 127, 31);
        contentPane.add(lblNewLabel_2_1);

        JLabel lblNewLabel_2_2 = new JLabel("Category:");
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2_2.setBounds(30, 172, 183, 31);
        contentPane.add(lblNewLabel_2_2);

        JLabel lblNewLabel_2_2_1 = new JLabel("Income:");
        lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2_2_1.setBounds(30, 214, 183, 31);
        contentPane.add(lblNewLabel_2_2_1);

        JLabel lblNewLabel_2_2_2 = new JLabel("Educational ");
        lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2_2_2.setBounds(30, 256, 127, 38);
        contentPane.add(lblNewLabel_2_2_2);

        JLabel lblNewLabel_2_2_3 = new JLabel("Qualification:");
        lblNewLabel_2_2_3.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2_2_3.setBounds(30, 282, 183, 31);
        contentPane.add(lblNewLabel_2_2_3);

        JLabel lblNewLabel_2_2_4 = new JLabel("Occupation:");
        lblNewLabel_2_2_4.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2_2_4.setBounds(30, 323, 183, 31);
        contentPane.add(lblNewLabel_2_2_4);

        JLabel lblNewLabel_2_2_5 = new JLabel("PAN Number:");
        lblNewLabel_2_2_5.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2_2_5.setBounds(30, 367, 183, 31);
        contentPane.add(lblNewLabel_2_2_5);

        JLabel lblNewLabel_2_2_6 = new JLabel("Aadhar Number:");
        lblNewLabel_2_2_6.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2_2_6.setBounds(30, 409, 183, 31);
        contentPane.add(lblNewLabel_2_2_6);

        JLabel lblNewLabel_2_2_7 = new JLabel("Senior Citizen:");
        lblNewLabel_2_2_7.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2_2_7.setBounds(30, 454, 183, 31);
        contentPane.add(lblNewLabel_2_2_7);

        religion = new JComboBox();
        religion.setBackground(new Color(255, 255, 255));
        religion.setFont(new Font("Tahoma", Font.PLAIN, 16));
        religion.setModel(new DefaultComboBoxModel(new String[] {"----Select religion----", "Hindu", "Muslim", "Sikh", "Christian", "other"}));
        religion.setBounds(204, 135, 405, 31);
        contentPane.add(religion);

        category = new JComboBox();
        category.setModel(new DefaultComboBoxModel(new String[] {"----Select category----", "General", "OBC", "SC", "ST", "other"}));
        category.setFont(new Font("Tahoma", Font.PLAIN, 16));
        category.setBackground(new Color(255, 255, 255));
        category.setBounds(204, 172, 405, 31);
        contentPane.add(category);

        income = new JComboBox();
        income.setBackground(new Color(255, 255, 255));
        income.setModel(new DefaultComboBoxModel(new String[] {"----Select Income----", "Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "Above 10,00,000"}));
        income.setFont(new Font("Tahoma", Font.PLAIN, 16));
        income.setBounds(204, 209, 405, 31);
        contentPane.add(income);

        education = new JComboBox();
        education.setBackground(new Color(255, 255, 255));
        education.setModel(new DefaultComboBoxModel(new String[] {"----Select qualification----", "Non-Graduate","Graduate","Post-Graduate","Doctrate","other"}));
        education.setFont(new Font("Tahoma", Font.PLAIN, 16));
        education.setBounds(204, 261, 405, 31);
        contentPane.add(education);
        
        occupation = new JComboBox();
        occupation.setBackground(new Color(255, 255, 255));
        occupation.setModel(new DefaultComboBoxModel(new String[] {"----Select occupation----", "Salaried","Self-Employmed","Business","Student","Retired","other"}));
        occupation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        occupation.setBounds(204, 320, 405, 31);
        contentPane.add(occupation);
        
  
        JLabel lblNewLabel_2_2_8 = new JLabel("Exiting Account");
        lblNewLabel_2_2_8.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2_2_8.setBounds(30, 499, 183, 31);
        contentPane.add(lblNewLabel_2_2_8);
        
        pan = new JTextField();
        pan.setColumns(10);
        pan.setBounds(204, 374, 405, 23);
        contentPane.add(pan);

        aadhar = new JTextField();
        aadhar.setColumns(10);
        aadhar.setBounds(208, 422, 405, 23);
        contentPane.add(aadhar);

         existyes = new JRadioButtonMenuItem("Yes");
        existyes.setForeground(Color.BLACK);
        existyes.setFont(new Font("Segoe UI", Font.BOLD, 16));
        existyes.setBackground(Color.WHITE);
        existyes.setBounds(228, 499, 133, 26);
        contentPane.add(existyes);

        existno = new JRadioButtonMenuItem("No");
        existno.setForeground(new Color(0, 0, 0));
        existno.setFont(new Font("Segoe UI", Font.BOLD, 16));
        existno.setBackground(new Color(255, 255, 255));
        existno.setBounds(422, 504, 133, 26);
        contentPane.add(existno);

         senyes = new JRadioButtonMenuItem("Yes");
        senyes.setForeground(new Color(0, 0, 0));
        senyes.setFont(new Font("Segoe UI", Font.BOLD, 16));
        senyes.setBackground(new Color(255, 255, 255));
        senyes.setBounds(228, 459, 133, 26);
        contentPane.add(senyes);

         senno = new JRadioButtonMenuItem("No");
        senno.setForeground(new Color(0, 0, 0));
        senno.setFont(new Font("Segoe UI", Font.BOLD, 16));
        senno.setBackground(new Color(255, 255, 255));
        senno.setBounds(428, 467, 127, 26);
        contentPane.add(senno);
//
//        // Button Groups for Radio Buttons
        scitizen = new ButtonGroup();
        scitizen.add(senyes);
        scitizen.add(senno);

        eaccount = new ButtonGroup();
        eaccount.add(existyes);
        eaccount.add(existno);
        
        next = new JButton("NEXT");
        next.addActionListener(this);
        next.setBackground(new Color(0, 0, 0));
        next.setForeground(new Color(255, 255, 255));
        next.setFont(new Font("Tahoma", Font.BOLD, 18));
        next.setBounds(520, 611, 89, 31);
        contentPane.add(next);
        setVisible(true);
   }
//
    	   public void actionPerformed(ActionEvent e) {
       
//
              String Religion=(String) religion.getSelectedItem();
              String Category=(String) category.getSelectedItem();
              String Income=(String) income.getSelectedItem();
              String Educational_Qualification=(String) education.getSelectedItem();
              String Occupation=(String) occupation.getSelectedItem();
              String Pan_Number = pan.getText();
              String Aadhar = aadhar.getText();
                String eaccount = null;
                if (existyes.isSelected()) {
                    eaccount = "Yes";
                } else if (existno.isSelected()) {
                    eaccount = "No";
                }
                String scitizen = null;
                if (senyes.isSelected()) {
                    scitizen = "Yes";
               
                } else if (senno.isSelected()) {
                    scitizen = "No";
                }
                
                try {
        		    Conn cn = new Conn();
        		 
        		  cn.c.setAutoCommit(false);
        		    String query = "insert into signtwo VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        		    PreparedStatement pstmt = cn.c.prepareStatement(query);
        		    pstmt.setString(1, Religion);
        		    pstmt.setString(2, Category);
        		    pstmt.setString(3, Income);
        		    pstmt.setString(4, Educational_Qualification);
        		    pstmt.setString(5, Occupation);
        		    pstmt.setString(6, Pan_Number);
        		    pstmt.setString(7, Aadhar);
        		    pstmt.setString(8, scitizen);
        		    pstmt.setString(9, eaccount);
        		    
        		    pstmt.executeUpdate();
        		    
        		    cn.c.commit();
        		    pstmt.close();
        		   // c.conn.close();
        		    setVisible(false);
        		    new Signupthree(formno).setVisible(true);
        		} catch (SQLException ep) {
        			System.out.println(ep);
        		}
            
       
    
    
    }
    
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try
				{
					Signuptwo frame = new Signuptwo();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		//new Signupone(); 
	
       }
       }



	