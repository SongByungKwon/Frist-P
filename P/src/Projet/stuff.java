package Projet;

import java.awt.Color;
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
	private Panel p;
	private ImageIcon logoIcon;
	private JButton bIcon,button;
	private JComboBox kind;
	TextField fieldtitl;
	TextField fieldcon;

	MemberDAO dao = new MemberDAO();

	String kindch[] = { " ", "호랑이", "사자", "코끼리", "기린", "토끼", "원숭이" };
	int size = 75;

	public void makePanel() {
		p = new Panel();
		p.setBounds(150, 150, 700, 700);
		p.setLayout(null);
		
		p.setVisible(true);
		p.setBackground(Color.red);
		f.add(p);
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
		
		makePanel();
//		p = new Panel();
//		p.setBounds(150, 150, 700, 700);
//		p.setLayout(null);

		

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
//					f.dispose();
//					f.setVisible(true);

					makePanel();
					
					
					
					size = 75;
					
					ArrayList<stuffVo> stuff = dao.stuff(name);

					System.out.println("stuff.size() : " + stuff.size());
					for (int i = 0; i < stuff.size(); i++) {
						stuffVo v = stuff.get(i);
						
						fieldtitl = new TextField(v.getstuff_item());
						fieldtitl.setBounds(25, size, 100, 50);
						fieldcon = new TextField(v.getstuff_number());
						fieldcon.setBounds(125, size, 200, 50);
						size = size + 50;

						p.add(fieldtitl);
						p.add(fieldcon);
						fieldtitl.setEnabled(false);
						fieldcon.setEnabled(false);
					
						
						
						
						
						
					}

					


				
				} else if (name.equals("사자")) {
//					f.dispose();
//					f.setVisible(true);
					makePanel();
					
					size = 75;
					
					ArrayList<stuffVo> stuff = dao.stuff(name);
					
					
					
					
					

					System.out.println("stuff.size() : " + stuff.size());
					for (int i = 0; i < stuff.size(); i++) {
						stuffVo v = stuff.get(i);
						
						fieldtitl = new TextField(v.getstuff_item());
						fieldtitl.setBounds(25, size, 100, 50);
						fieldcon = new TextField(v.getstuff_number());
						fieldcon.setBounds(125, size, 200, 50);
						size = size + 50;

						p.add(fieldtitl);
						p.add(fieldcon);
						fieldtitl.setEnabled(false);
						fieldcon.setEnabled(false);
						
						
					}

				} else if (name.equals("코끼리")) {
//					f.dispose();
//					f.setVisible(true);
					
					size = 75;
					
					
					
					
					
					
					ArrayList<stuffVo> stuff = dao.stuff(name);

					System.out.println("stuff.size() : " + stuff.size());
					for (int i = 0; i < stuff.size(); i++) {
						stuffVo v = stuff.get(i);
						
						fieldtitl = new TextField(v.getstuff_item());
						fieldtitl.setBounds(25, size, 100, 50);
						fieldcon = new TextField(v.getstuff_number());
						fieldcon.setBounds(125, size, 200, 50);
						size = size + 50;

						p.add(fieldtitl);
						p.add(fieldcon);
						fieldtitl.setEnabled(false);
						fieldcon.setEnabled(false);
						
						
						
					}

				} else if (name.equals("기린")) {
					size = 75;
					f.dispose();
					f.setVisible(true);
				
					
					
					
					
					ArrayList<stuffVo> stuff = dao.stuff(name);

					System.out.println("stuff.size() : " + stuff.size());
					for (int i = 0; i < stuff.size(); i++) {
						stuffVo v = stuff.get(i);
						
						fieldtitl = new TextField(v.getstuff_item());
						fieldtitl.setBounds(25, size, 100, 50);
						fieldcon = new TextField(v.getstuff_number());
						fieldcon.setBounds(125, size, 200, 50);
						size = size + 50;

						p.add(fieldtitl);
						p.add(fieldcon);
						fieldtitl.setEnabled(false);
						fieldcon.setEnabled(false);
						
						
						
					}

				} else if (name.equals("토끼")) {
					size = 75;
					
					
					
					
					
					
					
					
					
					ArrayList<stuffVo> stuff = dao.stuff(name);

					System.out.println("stuff.size() : " + stuff.size());
					for (int i = 0; i < stuff.size(); i++) {
						stuffVo v = stuff.get(i);
						
						fieldtitl = new TextField(v.getstuff_item());
						fieldtitl.setBounds(25, size, 100, 50);
						fieldcon = new TextField(v.getstuff_number());
						fieldcon.setBounds(125, size, 200, 50);
						size = size + 50;

						p.add(fieldtitl);
						p.add(fieldcon);
						fieldtitl.setEnabled(false);
						fieldcon.setEnabled(false);
						
					
					}

				} else if (name.equals("원숭이")) {
					f.dispose();
					f.setVisible(true);
					size = 75;
					
					
					
					ArrayList<stuffVo> stuff = dao.stuff(name);

					System.out.println("stuff.size() : " + stuff.size());
					for (int i = 0; i < stuff.size(); i++) {
						stuffVo v = stuff.get(i);
						
						fieldtitl = new TextField(v.getstuff_item());
						fieldtitl.setBounds(25, size, 100, 50);
						fieldcon = new TextField(v.getstuff_number());
						fieldcon.setBounds(125, size, 200, 50);
						size = size + 50;
						
						p.add(fieldtitl);
						p.add(fieldcon);
						fieldtitl.setEnabled(false);
						fieldcon.setEnabled(false);		
					}
				} else {
					

				}
			}
		});
		// 완료
	}
}
