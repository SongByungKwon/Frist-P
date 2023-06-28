package Projet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainMenu extends JFrame {
	private static final long serialVersionUID = 1L;
	private JFrame f;
	private JButton bs,bc;
	 private Memberch ch =new Memberch();
   

	public MainMenu() {
       f = new JFrame("메인 메뉴");
       f.setSize(900,900);
       f.setLocation(500,10);
       f.setLayout(null);
       f.addWindowListener(null);
       
       bs = new JButton("동물 검색");
   
   	bc  = new JButton("일정");
   	
   	bs.setBounds(250, 300, 450, 100);
   	
   

   	bs.setBorderPainted(false);
   	
	bc.setBounds(250, 500, 450, 100);
	


	bc.setBorderPainted(false);
	
 	try {
		f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Class01\\Desktop\\Mainmenu.jpg")))));
		}catch(IOException e) {
			e.printStackTrace();
		}
	f.pack();
   	
   	f.setVisible(true);
   	f.add(bs);
   
   	f.add(bc);
  
   	
   	
   	
   
   	
   	
	buttonsearch();
	buttonschedule();
    }
    
    	
    	
    	
	private void buttonsearch() { 
		bs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Click!");
				f.dispose();
				ch.Search();
				
			}
		});
   		
   	}
	
	
	
	
	private void buttonschedule() {
		bc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Click!");
				 new clac();
			}
		});
		
	}
   	
    	
    	
    	
    
       
    }
   
