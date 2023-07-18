package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.BorderLayout;

public class ImageViewer extends JFrame {

	private JPanel contentPane;
	CardLayout card;
	private JTextField num;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageViewer frame = new ImageViewer();
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
	public ImageViewer() {
		card=new CardLayout();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel imgpanel = new JPanel();
		imgpanel.setBounds(29, 11, 682, 495);
		contentPane.add(imgpanel);
		imgpanel.setLayout(card);
		
		JPanel p1 = new JPanel();
		imgpanel.add(p1, "1");
		p1.setLayout(new BoxLayout(p1, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Pooja\\Pictures\\e1.jpg"));
		p1.add(lblNewLabel);
		
		JPanel p2 = new JPanel();
		imgpanel.add(p2, "2");
		p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Pooja\\Pictures\\e2.jpg"));
		p2.add(lblNewLabel_1);
		
		JPanel p3 = new JPanel();
		imgpanel.add(p3, "3");
		p3.setLayout(new BoxLayout(p3, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Pooja\\Pictures\\e3.jpg"));
		p3.add(lblNewLabel_2);
		
		JPanel p4 = new JPanel();
		imgpanel.add(p4, "4");
		p4.setLayout(new BoxLayout(p4, BoxLayout.X_AXIS));

		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Pooja\\Pictures\\e6.jpg"));
		p4.add(lblNewLabel_3);
		
		JPanel p5 = new JPanel();
		imgpanel.add(p5, "5");
		p4.setLayout(new BoxLayout(p5, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Pooja\\Pictures\\e5.jpg"));
		p5.add(lblNewLabel_4);
		
		JPanel buttonpanel = new JPanel();
		buttonpanel.setBounds(29, 529, 682, 121);
		contentPane.add(buttonpanel);
		
		JButton btnLast = new JButton("Last");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				card.last(imgpanel);
			}
		});
		btnLast.setForeground(new Color(255, 215, 0));
		btnLast.setBackground(new Color(199, 21, 133));
		btnLast.setFont(new Font("Times New Roman", Font.BOLD, 23));
		
		JButton btnNewButton_1_1 = new JButton("First");
		btnNewButton_1_1.setForeground(new Color(255, 215, 0));
		btnNewButton_1_1.setBackground(new Color(199, 21, 133));
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				card.first(imgpanel);
			}
		});
		
		JButton btnNewButton_1_2 = new JButton("Next");
		btnNewButton_1_2.setForeground(new Color(255, 215, 0));
		btnNewButton_1_2.setBackground(new Color(199, 21, 133));
		btnNewButton_1_2.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				card.next(imgpanel);
			}
		});
		
		JButton btnNewButton_1_3 = new JButton("Previous");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				card.previous(imgpanel);
			}
		});
		btnNewButton_1_3.setForeground(new Color(255, 215, 0));
		btnNewButton_1_3.setBackground(new Color(199, 21, 133));
		btnNewButton_1_3.setFont(new Font("Times New Roman", Font.BOLD, 23));
		
		JButton btnNewButton_1_1_1 = new JButton("Select Number");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String n=num.getText();
				
				card.show(imgpanel, n);
			}
		});
		btnNewButton_1_1_1.setForeground(new Color(255, 215, 0));
		btnNewButton_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnNewButton_1_1_1.setBackground(new Color(199, 21, 133));
		
		num = new JTextField();
		num.setFont(new Font("Times New Roman", Font.BOLD, 18));
		num.setColumns(10);
		GroupLayout gl_buttonpanel = new GroupLayout(buttonpanel);
		gl_buttonpanel.setHorizontalGroup(
			gl_buttonpanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_buttonpanel.createSequentialGroup()
					.addGroup(gl_buttonpanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_buttonpanel.createSequentialGroup()
							.addGap(22)
							.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addGap(48)
							.addComponent(btnNewButton_1_2, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_buttonpanel.createSequentialGroup()
							.addGap(130)
							.addComponent(num, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addGroup(gl_buttonpanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_buttonpanel.createSequentialGroup()
							.addGap(10)
							.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_buttonpanel.createSequentialGroup()
							.addComponent(btnNewButton_1_3, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addComponent(btnLast, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)))
					.addGap(20))
		);
		gl_buttonpanel.setVerticalGroup(
			gl_buttonpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttonpanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_buttonpanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1_3, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_buttonpanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton_1_2, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnLast, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_buttonpanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1_1_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(num, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
					.addContainerGap())
		);
		buttonpanel.setLayout(gl_buttonpanel);
	}
}
