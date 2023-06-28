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
	private JButton bs,bc,bd;
	 private Memberch ch =new Memberch();
	 private stuff st =new stuff();
	
   

	public MainMenu() {
       f = new JFrame("메인 메뉴");
       f.setSize(900,900);
       f.setLocation(500,10);
       f.setLayout(null);
       f.addWindowListener(null);
       
       bs = new JButton("동물 검색");
   
   	bc  = new JButton("일정");
   	bd = new JButton("재고");
   	
   	
   	bs.setBounds(250, 250, 450, 100);
	bs.setBorderPainted(false);
   	
   	bd.setBounds(250, 400, 450, 100);
   	bd.setBorderPainted(false);
   	
   

   
   	
	bc.setBounds(250, 550, 450, 100);

	bc.setBorderPainted(false);
	
 	try {
		f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Class01\\Desktop\\Mainmenu.jpg")))));
		}catch(IOException e) {
			e.printStackTrace();
		}
	f.pack();
   	
   	f.setVisible(true);
   	f.add(bs);
   	f.add(bd);
   
   	f.add(bc);
  
   	
   	
   	
   
   	
   	
	buttonsearch();
	buttonschedule();
	buttonsstuf() ;
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
	private void buttonsstuf() {
		bd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Click");
				f.dispose();
				st.stuff();
			
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
   
