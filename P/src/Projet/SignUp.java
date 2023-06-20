package Projet;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp extends JDialog{
	private static final long serialVersionUID = 1L;
	private JPanel sp = new JPanel(new GridLayout(9, 0));
	 private JTextField idText = new JTextField("아이디");
	 private JButton bidtest = new JButton("종복");
	 private JPasswordField pwText = new JPasswordField();
	 private JPasswordField pwCheckText = new JPasswordField();
	 private JTextField numText = new JTextField("고유번호");
	 private JButton signUpbtn = new JButton("회원가입");
	 private JLabel idlabel = new JLabel("아이디");
	 private JLabel pwlabel = new JLabel("비밀번호");
	 private JLabel numlabel = new JLabel("고유번호");
	 private JLabel pwChecklabel = new JLabel("비밀번호 확인");
	 private MemberDAO dao = new MemberDAO() ;
	
	 private boolean idchek= false;
	 private String number ="87184898";
	 
	 
	
	  
	 

	 public SignUp() {
		 
		 
		
	
	
		
	
		this.setContentPane(sp);
		this.setSize(400,500);				
		this.setLocationRelativeTo(null);
		sp.setLayout(null);
		
		idlabel.setBounds(50, 75,100, 40);
		idText.setBounds(110, 75, 200, 40);
		bidtest.setBounds(310, 75, 60, 40);
		
		pwlabel.setBounds(50, 150, 100, 40);
		pwText.setBounds(110, 150, 200, 40);
		
		pwChecklabel.setBounds(30, 225, 100, 40);
		pwCheckText.setBounds(110, 225, 200, 40);
		
		numlabel.setBounds(50, 300, 100, 40);
		numText.setBounds(110, 300, 200, 40);
		
		signUpbtn.setBounds(150, 350, 100, 80);
		
		
		
	
		sp.add(idlabel);
		sp.add(idText);
		sp.add(pwlabel);
		sp.add(pwText);
		sp.add(pwChecklabel);
		sp.add(pwCheckText);
		sp.add(numlabel);
		sp.add(numText);
		sp.add(signUpbtn);
		sp.add(bidtest);
		
		
		
		
		
		

		FocusEvent();
		checkValue();
		idcheck();//중복 체크
		
		
	}
	 
	 
	 
	 
	 
	
	 //텍스트 필드에 있는 값을 체크하고 지우기 위한 메소드
	 private void FocusEvent() {
			idText.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {				
					if(idText.getText().trim().length()==0) {
						idText.setText("아이디");
					}
				}
				public void focusGained(FocusEvent e) {				
					if(idText.getText().trim().equals("아이디")) {
						idText.setText("");
					}				
				}
			});
			
			numText.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					if(numText.getText().trim().length()==0) {
						numText.setText("고유번호");
					}
				}
				
				public void focusGained(FocusEvent e) {			
					if(numText.getText().trim().equals("고유번호")) {
						numText.setText("");
					}
				}
			});
			

			
	
			
	
			


	 }
	 private void idcheck() {
		 bidtest.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 
				 String strId =idText.getText();
				 
				 ArrayList<MemberVo> list =dao.list(strId);
				 
		
				 
				
				 if(list.size()==0) {
					 JOptionPane.showMessageDialog(null,"동일한 아이디가 없습니다.","다음으로",JOptionPane.WARNING_MESSAGE);
					 idchek = true;
					 return;
					 
				 }
				 else {
					 JOptionPane.showMessageDialog(null,"중복된 아이디가 있습니다.","다음으로",JOptionPane.WARNING_MESSAGE);
					 idchek = false;
					 return;
				 }
			 }
			 
		 });
		 
	 }
	 
	 
	 

		
	
	 
	 
	 //회원 가입할때 모든 값이 입력되었는지 체크하기 위한 메소드
	 private void checkValue(){
		 signUpbtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(idText.getText().trim().length()==0 || idText.getText().trim().equals("아이디")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해 주세요.", "아이디 입력", JOptionPane.WARNING_MESSAGE);
					idText.grabFocus();
					
					return;
				}
			
				
				
				if(pwText.getText().trim().length()==0) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해 주세요.", "비밀번호 입력", JOptionPane.WARNING_MESSAGE);
					pwText.grabFocus();
					return;
				}
				
				if(pwCheckText.getText().trim().length()==0) {
					JOptionPane.showMessageDialog(null, "비밀번호 확인을 입력해 주세요.", "비밀번호 확인 입력", JOptionPane.WARNING_MESSAGE);
					pwCheckText.grabFocus();
					return;
				}
				
				if(!(pwText.getText().trim().equals(pwCheckText.getText().trim()))) {
					JOptionPane.showMessageDialog(null, "비밀번호가 같지 않습니다.!!", "비밀번호 확인", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				if(numText.getText().trim().length()==0 || numText.getText().trim().equals("고유번호")) {
					JOptionPane.showMessageDialog(null, "고유번호을 입력해 주세요.", "고유번호 입력", JOptionPane.WARNING_MESSAGE);
					numText.grabFocus();
					return;
				}
				
				
				
				
				String nnumText=numText.getText();
				
			if(nnumText.equals(number)&&idchek==true) {
				dao.insertForStatement(idText.getText(),pwText.getText());
				JOptionPane.showMessageDialog(null, "환영합니다.", "환영합니다.", JOptionPane.WARNING_MESSAGE);
				numText.grabFocus();
				
				
			}
			else if(!nnumText.equals(number)){
				JOptionPane.showMessageDialog(null, "고유번호가 다릅니다.", "고유번호 재입력", JOptionPane.WARNING_MESSAGE);
				numText.grabFocus();
				return;
			}
			else if(idchek==false){
				JOptionPane.showMessageDialog(null, "중복된 아이디가 있습니다.", "중복된 아이디", JOptionPane.WARNING_MESSAGE);
				numText.grabFocus();
				return;
			}
				
		
				
				
				}
			
			
		
		 });
	 }
	 
	 

	 
	 
	 
	 
	 //메인 클래스에서 다이얼로그 회원가입 창 데이터를 가져오기 위한 get 메소드 선언
	public String getIdText() {
		return this.idText.getText().trim();
	}

	@SuppressWarnings("deprecation")
	public String getPwText() {
		return this.pwText.getText().trim();
	}

	@SuppressWarnings("deprecation")
	public String getPwCheckText() {
		return this.pwCheckText.getText().trim();
	}

	public String getnumText() {
		return this.numText.getText().trim();
	}


	
	 
	 
}


