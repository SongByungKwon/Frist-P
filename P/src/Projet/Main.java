package Projet;

import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Main extends WindowAdapter implements ActionListener {
	private JFrame f, fMain;
	private TextField tfId, tfPwd, tfMsg;
	private Button bLogin , bmember;
	private MemberDAO dao;
	

	public Main() {
		dao = new MemberDAO();

		f = new JFrame("Login Frame");
		f.setSize(500, 400);
		f.setLocation(500, 10); // 따라 하지 마세요!
		f.setLayout(null);
		f.addWindowListener(this);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//CLOSE
		
		
//		//이미지 넣기-----------------------------
//		try {
//			f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Class01\\Desktop\\main.jpg")))));
//			}catch(IOException e) {
//				e.printStackTrace();
//			}
//		f.pack();
//		//이미지 넣기 완----------------------
//		
		
	

		JLabel lid = new JLabel("ID : ");
		lid.setBounds(50, 60, 100, 40);
		
		
		
		

		tfId = new TextField();
		tfId.setBounds(160, 60, 190, 40);

		JLabel lpwd = new JLabel("Password : ");
		lpwd.setBounds(50, 130, 100, 40);

		tfPwd = new TextField();
		tfPwd.setBounds(160, 130, 190, 40);
		tfPwd.setEchoChar('*');

		bLogin = new Button("Login");
		bLogin.setBounds(380, 90, 50, 50);
		bLogin.addActionListener(this);

		tfMsg = new TextField();
		tfMsg.setBounds(50, 180, 370, 40);
		tfMsg.setEditable(false);
		tfMsg.setFocusable(false);
		
		//----------------------
		bmember = new Button("회원가입");
		bmember.setBounds(220, 230, 50, 50);
		//*----------------------
		
	
		
		
		
		
		
		

		f.add(lid);
		f.add(tfId);
		f.add(lpwd);
		f.add(tfPwd);
		f.add(bLogin);
		f.add(tfMsg);
		
		f.add(bmember);
		
		
		
		bmember.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				SignUp signup = new SignUp();
				signup.setVisible(true);
			}
			
		});	
		

		f.setVisible(true);
		
		
		
		
		
	}

	public static void main(String[] args) {
		new Main();
	
	}


//
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Click!");
		System.out.println(tfId.getText() + " : " + tfPwd.getText());

		String strId = tfId.getText();

		ArrayList<MemberVo> list = dao.list(strId);

		System.out.println("list.size() : " + list.size());
		if (list.size() == 1) {
			MemberVo data = (MemberVo) list.get(0);
			String id = data.getId();
			String pwd = data.getPassword();

			System.out.println("DB ==> " + id + " : " + pwd);

			if (tfPwd.getText().equals(pwd)) {
				System.out.println("로그인이 되었습니다!");
				tfMsg.setText("로그인이 되었습니다!");

				new MainMenu();
			} else {
				System.out.println("다시 입력하세요.");
				tfMsg.setText("다시 입력하세요.");
			}
		} else {
			tfMsg.setText("ID가 틀렸습니다. 다시 입력하세요.");
		}
	

	}
}