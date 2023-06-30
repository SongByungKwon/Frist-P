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

public class stuff {
	private JFrame f;
	private ImageIcon logoIcon;
	private JButton bIcon,button;
	private JComboBox kind;
	

	MemberDAO dao = new MemberDAO();
	static sutffLi li = new sutffLi();
	static stuffTi ti = new stuffTi();
	static stuffEi ei = new stuffEi();
	static stuffGi gi = new stuffGi();
	static stuffri ri= new stuffri();
	static stuffmi mi= new stuffmi();
	
	
	String kindch[] = { " ", "호랑이", "사자", "코끼리", "기린", "토끼", "원숭이" };
	int size = 75;

	public void makePanel() {
		
	
	}
	
	public void stuff() {
		f = new JFrame("재고");
		f.setSize(1000, 1000);
		f.setLocation(500, 10);
		f.setLayout(null);
		f.addWindowListener(null);

		logoIcon = new ImageIcon("C:\\Users\\Class01\\Desktop\\img2.png");

		bIcon = new JButton();
		bIcon.setIcon(logoIcon);
		bIcon.setBounds(300, 50, 400, 100);
		bIcon.setContentAreaFilled(false);
		bIcon.setBorderPainted(false);

		kind = new JComboBox(kindch);
		kind.setBounds(10, 10, 100, 50);
		


		

		f.add(bIcon);
		f.add(kind);
		
		
		button = new JButton();
		button.setBounds(870, 200, 100, 100);
		f.add(button);
		

		f.setVisible(true);
		

		// 돌아가는 아이콘 만들기
		bIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainMenu();
				f.dispose();
			}
		});
		kind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				kind = (JComboBox) e.getSource();
				String name = (String) kind.getSelectedItem();

				if (name.equals("호랑이")) {
					
					ArrayList<stuffVo> stuff = dao.stuff(name);
					int Tinmber = stuff.size();
					ti.stuffTi(Tinmber,name);
					f.dispose();
					
					
					
				
					


				
				} else if (name.equals("사자")) {

					ArrayList<stuffVo> stuff = dao.stuff(name);
					int linmber = stuff.size();
					li.suffLi(linmber,name);
					f.dispose();
					
					
				} else if (name.equals("코끼리")) {
//					
					ArrayList<stuffVo> stuff = dao.stuff(name);
					int Einmber = stuff.size();
					ei.stuffEi(Einmber,name);
					f.dispose();
					
					
					
					
					
					


				} else if (name.equals("기린")) {
					ArrayList<stuffVo> stuff = dao.stuff(name);
					int Ginmber = stuff.size();
					gi.stuffGi(Ginmber,name);
					f.dispose();
				
					

				} else if (name.equals("토끼")) {
					ArrayList<stuffVo> stuff = dao.stuff(name);
					int Rinmber = stuff.size();
					ri.stuffRi(Rinmber,name);
					f.dispose();
				
				} else if (name.equals("원숭이")) {
					ArrayList<stuffVo> stuff = dao.stuff(name);
					int Minmber = stuff.size();
					mi.stuffMi(Minmber,name);
					f.dispose();
				} else {
					

				}
			}
		});
		// 완료
	}
}
