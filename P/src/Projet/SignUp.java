package Projet;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp extends JDialog{
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
	 
	
	  
	 private boolean membershipProgress = false;//회원가입 때 true로 변환 될 예정;

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

	 
	 
	 //회원 가입할때 모든 값이 입력되었는지 체크하기 위한 메소드
	 private void checkValue(){
		 signUpbtn.addActionListener(new ActionListener() {
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
			
				
				
                /** 컴퓨터 C드라이브에 java_member 폴더 만들고 member.txt 파일 만드시면 됩니다. **/
				//회원가입시 텍스트 파일을 하나 만들어서 아이디와 비번을 저장 하자. 한줄 뛰고 아이디|비밀번호 텍스트 파일에 차곡 차곡 저장하기~ | 는 아이디랑 패스워드 구분하기 위해 사용
				String txt = idText.getText()+"|"+pwText.getText();
				txt+="\n";
				
				String fileName = "C:\\java_member\\member.txt" ;
				
				
				try{
					BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));
					
					// 파일안에 문자열 쓰기
					fw.write(txt);
					fw.flush();

					// 객체 닫기
					fw.close();					
					
				}catch(Exception errmsg){
					errmsg.printStackTrace();
				}
				
				
				//여기까지 왔다면 모든 값을 입력하고 선택하는 것이 완료되었으니 회원가입 과정이 완료.				
				membershipProgress = true;				
				
				JOptionPane.showMessageDialog(null, "회원 가입이 완료 되었습니다.","회원 가입 완료.", JOptionPane.WARNING_MESSAGE);
								
				setVisible(false);
			}
		});
	 }
	 
	 

	 
	 
	 
	 
	 
	 
	 
	 //메인 클래스에서 다이얼로그 회원가입 창 데이터를 가져오기 위한 get 메소드 선언
	public String getIdText() {
		return this.idText.getText().trim();
	}

	public String getPwText() {
		return this.pwText.getText().trim();
	}

	public String getPwCheckText() {
		return this.pwCheckText.getText().trim();
	}

	public String getnumText() {
		return this.numText.getText().trim();
	}



	public boolean memberCheck() {
		return membershipProgress;
	}
	 
	 
	 
}