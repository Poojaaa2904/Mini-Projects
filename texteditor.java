package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class texteditor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					texteditor frame = new texteditor();
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
	public texteditor() {
		setFont(new Font("Dialog", Font.BOLD, 18));
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(139, 0, 0));
		setTitle("Text Editor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 23, 421, 527);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				//get data from textarea
				//check text area is empty or not
				//if text area is empty then print data is there to save

				String data=textArea.getText();
				if(data.equals(""))
				{
				JOptionPane.showMessageDialog(getParent(), "There is not data to save");
				
				}
				else {
					
				//else
				//show JFileChooser.save Dialog(),
					JFileChooser jfc=new JFileChooser();
					jfc.showSaveDialog(getParent());
										
				//get path with file name
					File file = jfc.getSelectedFile();
					
					String path=file.getAbsolutePath();
					System.out.println(path);
					
					try 
					{
						FileWriter fw=new FileWriter(path);
						fw.write(data);
						JOptionPane.showMessageDialog(getParent(), "File saved successfully");
						setTitle(file.getName()+" Text Editor");
						fw.close();
					} 
					catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		
					
				//save file
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Serif", Font.BOLD, 24));
		btnNewButton.setBackground(new Color(218, 112, 214));
		btnNewButton.setBounds(462, 54, 251, 63);
		contentPane.add(btnNewButton);
 		
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser jfc=new JFileChooser();
				
				jfc.showOpenDialog(getParent());
				
				File file = jfc.getSelectedFile();
				
				String path=file.getAbsolutePath();
				
				try
				{
					FileInputStream fis=new FileInputStream(path);
					
					byte b[]=fis.readAllBytes();
					
					String data=new String(b);
					
					textArea.setText(data);
					 fis.close();
					
				} 
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnOpen.setFont(new Font("Serif", Font.BOLD, 24));
		btnOpen.setBackground(new Color(218, 112, 214));
		btnOpen.setForeground(new Color(0, 0, 128));
		btnOpen.setBounds(462, 162, 251, 63);
		contentPane.add(btnOpen);
		
		JButton btnSetTextColor = new JButton("Set Text Color");
		btnSetTextColor.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Color color=JColorChooser.showDialog(getParent(), "Select Text Color ", Color.black);
				textArea.setForeground(color);
			}
		});
		btnSetTextColor.setFont(new Font("Serif", Font.BOLD, 24));
		btnSetTextColor.setBackground(new Color(218, 112, 214));
		btnSetTextColor.setForeground(new Color(0, 0, 128));
		btnSetTextColor.setBounds(462, 270, 251, 63);
		contentPane.add(btnSetTextColor);
		
		JButton btnSetBackgroundColor = new JButton("Set Background Color");
		btnSetBackgroundColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Color color=JColorChooser.showDialog(getParent(), "Select Text Color ", Color.black);
				textArea.setBackground(color);
			}
		});
		btnSetBackgroundColor.setFont(new Font("Serif", Font.BOLD, 24));
		btnSetBackgroundColor.setBackground(new Color(218, 112, 214));
		btnSetBackgroundColor.setForeground(new Color(0, 0, 128));
		btnSetBackgroundColor.setBounds(462, 374, 251, 63);
		contentPane.add(btnSetBackgroundColor);
	}
}
