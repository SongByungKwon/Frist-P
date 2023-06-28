package Projet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class stuff {
	private JFrame f;
	private ImageIcon logoIcon;
	private JButton bIcon;
	private JComboBox kind;
	String kindch[] = {"호랑이","사자","코끼리","기린","토끼","원숭이"};
	
	
	public void stuff() {
		f = new JFrame("재고");
		f.setSize(1000,1000);
	       f.setLocation(500,10);
	       f.setLayout(null);
	       f.addWindowListener(null);
	       
	       
	       logoIcon = new ImageIcon("C:\\Users\\Class01\\Desktop\\img2.png");
	       
	       bIcon = new JButton();
			bIcon.setIcon(logoIcon);
			bIcon.setBounds(300, 100, 400, 100);
			bIcon.setContentAreaFilled(false);
			bIcon.setBorderPainted(false);
			
			kind = new JComboBox(kindch);
			kind.setBounds(100, 400, 100, 50);
			
			
			
			
			
			  f.add(bIcon);
			  f.add(kind);
			   	f.setVisible(true);
			
			
			//  돌아가는 아이콘 만들기
			bIcon.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new MainMenu();
					f.dispose();
				}
			});
	       //완료
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	     
		
		
	}

}
