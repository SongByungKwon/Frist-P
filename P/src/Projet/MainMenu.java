package Projet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainMenu extends JFrame {
	private static final long serialVersionUID = 1L;
	private JFrame f;
	private JButton bs, bsub,bc;
	 private Memberch ch =new Memberch();
   

	public MainMenu() {
       f = new JFrame("메인 메뉴");
       f.setSize(900,900);
       f.setLocation(500,10);
       f.setLayout(null);
       f.addWindowListener(null);
       
       bs = new JButton("동물 검색");
   	bsub = new JButton("온도측정");
   	bc  = new JButton("일정");
   	
   	bs.setBounds(0, 0, 300, 100);
   	bsub.setBounds(300, 0, 300, 100);
	bc.setBounds(600, 0, 300, 100);
   	
   	f.setVisible(true);
   	f.add(bs);
   	f.add(bsub);
   	f.add(bc);
   
   	
   	
   	
   
   	
   	
	buttonsearch();
	buttoncelsius();
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
	
	
	
	private void buttoncelsius() {
		bsub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Click!");
			}
		});
		
	}
	
	private void buttonschedule() {
		bc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Click!");
			}
		});
		
	}
   	
    	
    	
    	
    
       
    }
   
