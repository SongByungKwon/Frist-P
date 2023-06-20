package Projet;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Memberch {
	private JFrame fm,fsech ,fpush;
	private TextField Textch;
	private JButton bSearch,bIcon,bIcon1,bsub,bpush;
	private TextField Tname,Tse,Tin,Tqpqp  , Taname,Tase,Taqpqp;
	private JLabel Lname,Lse,Lin,Lqpqp , Laname,Lase,Laqpqp   ; 
	 private MemberDAO dao = new MemberDAO() ;
	
	
	
	
	private Icon logoIcon;
	
	public void Search() {
		fm= new JFrame("검색창");
		fm.setSize(1000,1000);
		fm.setLocation(500,10);
		fm.setLayout(null);
		fm.addWindowListener(null); 
		
		
		
		
		Textch =new TextField();
		Textch.setBounds(200,400,600,100);
		
		bSearch = new JButton("검색");
		bSearch.setBounds(800,400,100,100);
		bSearch.setContentAreaFilled(false);
		
		logoIcon = new ImageIcon("C:\\Users\\Class01\\Desktop\\img.png");
		
		bIcon = new JButton();
		bIcon.setIcon(logoIcon);
		bIcon.setBounds(400, 200, 200, 200);
		bIcon.setContentAreaFilled(false);
		
		
		
		bsub= new JButton("추가하기");
		bsub.setBounds(450,800, 100, 100);
		fm.add(bsub);
		
		
		
		
		Font font = new Font("궁서체",1,40);
		Textch.setFont(font);
		
		
		fm.add(Textch);
		fm.add(bSearch);
		fm.add(bIcon);
		
		
		
		
		fm.setVisible(true);
		
		bSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Test");
				SearchFrame();
				fm.dispose();
				
				

			
			}
		});
		
		
		bIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainMenu();
				fm.dispose();
			}
		});
		bsub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fpush = new JFrame("검색창");
				fpush.setSize(500,500);
				fpush.setLocation(500,10);
				fpush.setLayout(null);
				fpush.addWindowListener(null); 
				fpush.setVisible(true);
				
				
				Lname =new JLabel("이름 : ");
				Lname.setBounds(50, 60, 100, 40);
				Tname = new TextField();
				Tname.setBounds(160, 60, 190, 40);
				
				
				Lse =new JLabel("종류 : ");
				Lse.setBounds(50, 130, 100, 40);
				Tse = new TextField();
				Tse.setBounds(160, 130, 190, 40);
				
				Lin =new JLabel("이미지 넣기 : ");
				Lin.setBounds(50, 180, 100, 40);
				Tin = new TextField();
				Tin.setBounds(160, 180, 190, 40);
				
				bpush=new JButton("추가");
				bpush.setBounds(200, 400, 100, 50);
				
				
				Lqpqp =new JLabel("특이사항 : ");
				Lqpqp.setBounds(50, 220, 100, 40);
				Tqpqp = new TextField();
				Tqpqp.setBounds(160, 220, 300, 150);
				
				
				fpush.add(Lname);
				fpush.add(Lse);
				fpush.add(Lin);
				fpush.add(Lqpqp);
				fpush.add(Tname);
				fpush.add(Tse);
				fpush.add(Tin);
				fpush.add(Tqpqp);
				fpush.add(bpush);
				
				
				bpush.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String name= Tname.getText();
						String se= Tse.getText();
						String in= Tin.getText();
						String qpqp= Tqpqp.getText();
						 
							dao.Filein(name,se,in,qpqp);
					}
			});
				
			
			}
		});
		
	}
	
	
	
	
	
	public void SearchFrame() {
		fsech = new JFrame("검색창");
		fsech.setSize(800,800);
		fsech.setLocation(500,10);
		fsech.setLayout(null);
		fsech.addWindowListener(null); 
		
		fsech.setVisible(true);
		
		
		
		Laname =new JLabel("이름 : ");
		Laname.setBounds(200, 130, 100, 40);
		Taname = new TextField();
		Taname.setBounds(300, 130, 190, 40);
		
		
		Lase =new JLabel("종류 : ");
		Lase.setBounds(200, 220, 100, 40);
		Tase = new TextField();
		Tase.setBounds(300, 220, 190, 40);
		
	
		
		
		Laqpqp =new JLabel("특이사항 : ");
		Laqpqp.setBounds(200, 300, 100, 40);
		Taqpqp = new TextField();
		Taqpqp.setBounds(300, 300, 300, 400);
		
		bIcon1 = new JButton();
		bIcon1.setIcon(logoIcon);
		bIcon1.setBounds(300, 10, 200, 100);
		bIcon1.setContentAreaFilled(false);
		
		
		fsech.add(Laname);
		fsech.add(Lase);
		fsech.add(Laqpqp);
		
		fsech.add(Taname);
		fsech.add(Tase);
		fsech.add(Taqpqp);
		fsech.add(bIcon1);
		
		
		bIcon1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainMenu();
				fsech.dispose();
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
