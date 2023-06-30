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

public class stuffTi {
	private JFrame ft;
	private Panel pt;
	private ImageIcon logoIcon;
	private JButton bIcon,button;
	private JComboBox kind;
	TextField fieldtitl;
	TextField fieldcon;
	String kindch[] = { " ", "호랑이", "사자", "코끼리", "기린", "토끼", "원숭이" };
	
	int number,size;
	
	
	MemberDAO dao =new MemberDAO();
	

	static sutffLi li = new sutffLi();
	static stuffEi ei = new stuffEi();
	static stuffGi gi = new stuffGi();
	static stuffri ri= new stuffri();
	static stuffmi mi= new stuffmi();
	
	
	
	public void stuffTi(int number,String name){
		ft = new JFrame("호랑이");
		ft.setSize(1000, 1000);
		ft.setLocation(500, 10);
		ft.setLayout(null);
		ft.addWindowListener(null);
		
		logoIcon = new ImageIcon("C:\\Users\\Class01\\Desktop\\img2.png");
		
		bIcon = new JButton();
		bIcon.setIcon(logoIcon);
		bIcon.setBounds(300, 50, 400, 100);
		bIcon.setContentAreaFilled(false);
		bIcon.setBorderPainted(false);

		kind = new JComboBox(kindch);
		kind.setBounds(10, 10, 100, 50);
		kind.setSelectedItem("호랑이");
		
		
		
		
		
		
		
		
		
		
		
		
		this.number = number;
		int size = 75;
		
		pt = new Panel();
		pt.setBounds(150, 150, 700, 700);
		pt.setLayout(null);
		pt.setVisible(true);
		ft.add(pt);
		ft.add(bIcon);
		ft.add(kind);
		ft.setVisible(true);
		
		bIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainMenu();
				ft.dispose();
				ft.dispose();
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

			pt.add(fieldtitl);
			pt.add(fieldcon);
			fieldtitl.setEnabled(false);
			fieldcon.setEnabled(false);
		}
			
			kind.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					kind = (JComboBox) e.getSource();
					String name = (String) kind.getSelectedItem();

					if (name.equals("사자")) {
						
						ArrayList<stuffVo> stuff = dao.stuff(name);
						int Tinmber = stuff.size();
						li.suffLi(Tinmber,name);
						ft.dispose();
						
						

					
					}  else if (name.equals("코끼리")) {
//						
						ArrayList<stuffVo> stuff = dao.stuff(name);
						int Einmber = stuff.size();
						ei.stuffEi(Einmber,name);
						ft.dispose();
						
						
						
						
						
						
						


					} else if (name.equals("기린")) {
						ArrayList<stuffVo> stuff = dao.stuff(name);
						int Ginmber = stuff.size();
						gi.stuffGi(Ginmber,name);
						ft.dispose();
						
					
						

					} else if (name.equals("토끼")) {
						ArrayList<stuffVo> stuff = dao.stuff(name);
						int Rinmber = stuff.size();
						ri.stuffRi(Rinmber,name);
						ft.dispose();
						
					
					} else if (name.equals("원숭이")) {
						ArrayList<stuffVo> stuff = dao.stuff(name);
						int Minmber = stuff.size();
						mi.stuffMi(Minmber,name);
						ft.dispose();
						
					} else {
						

					}
				}
			});
			
			
		

		
		
	}

}