package Projet;

import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class stuffEi {
	private JFrame fe;
	private Panel pe;
	private ImageIcon logoIcon;
	private JButton bIcon,button;
	private JComboBox kind;
	TextField fieldtitl;
	TextField fieldcon;
	String kindch[] = { " ", "호랑이", "사자", "코끼리", "기린", "토끼", "원숭이" };
	
	int number,size;
	
	
	MemberDAO dao =new MemberDAO();
	
	
	
	public void stuffEi(int number,String name){
		fe = new JFrame("코끼리 물품");
		fe.setSize(1000, 1000);
		fe.setLocation(500, 10);
		fe.setLayout(null);
		fe.addWindowListener(null);
		
		logoIcon = new ImageIcon("C:\\Users\\Class01\\Desktop\\img2.png");
		
		bIcon = new JButton();
		bIcon.setIcon(logoIcon);
		bIcon.setBounds(300, 50, 400, 100);
		bIcon.setContentAreaFilled(false);
		bIcon.setBorderPainted(false);

		kind = new JComboBox(kindch);
		kind.setBounds(10, 10, 100, 50);
		kind.setSelectedItem("코끼리");
		
		
		
		
		
		
		
		
		
		
		
		
		this.number = number;
		int size = 75;
		
		pe = new Panel();
		pe.setBounds(150, 150, 700, 700);
		pe.setLayout(null);
		pe.setVisible(true);
		fe.add(pe);
		fe.add(bIcon);
		fe.add(kind);
		fe.setVisible(true);
		
		bIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainMenu();
				fe.dispose();
			}
		});
		
		for (int i = 0; i < number; i++) {
			ArrayList<stuffVo> stuff = dao.stuff(name);
			stuffVo v = stuff.get(i);
			
			
			fieldtitl = new TextField(v.getstuff_item());
			fieldtitl.setBounds(25, size, 100, 50);
			fieldcon = new TextField(v.getstuff_number());
			fieldcon.setBounds(125, size, 200, 50);
			size = size + 50;

			pe.add(fieldtitl);
			pe.add(fieldcon);
			fieldtitl.setEnabled(false);
			fieldcon.setEnabled(false);
			
			
		}

		
		
	}

}