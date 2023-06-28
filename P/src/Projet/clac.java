package Projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class clac extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private MemberDAO dao = new MemberDAO();

	String[] Time = { "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00",
			"18:00", "19:00", "20:00", "21:00" };

	private String calc_y, calc_m, calc_d, titel, contents;

	// North

	JPanel topPane = new JPanel();

	JButton prevBtn = new JButton("◀");

	JButton nextBtn = new JButton("▶");

	JLabel yearLbl = new JLabel("년");

	JLabel monthLbl = new JLabel("월");

	JComboBox<Integer> yearCombo = new JComboBox<Integer>();

	DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>();

	JComboBox<Integer> monthCombo = new JComboBox<Integer>();

	DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<Integer>();

	JComboBox<Integer> DayCombo = new JComboBox<Integer>();

	DefaultComboBoxModel<Integer> DayCombo1 = new DefaultComboBoxModel<Integer>();

	// Center

	JPanel centerPane = new JPanel(new BorderLayout());

	JPanel titlePane = new JPanel(new GridLayout(1, 7));

	String titleStr[] = { "일", "월", "화", "수", "목", "금", "토" };

	JPanel datePane = new JPanel(new GridLayout(0, 7));

	Calendar now;

	int year, month, date;

	public clac() {

		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // 자원 해제 후 종료

		now = Calendar.getInstance(); // 현재 날짜

		year = now.get(Calendar.YEAR);

		month = now.get(Calendar.MONTH) + 1;

		date = now.get(Calendar.DATE);

		topPane.add(prevBtn);

		for (int i = year - 100; i <= year + 50; i++) {

			yearModel.addElement(i);

		}

		yearCombo.setModel(yearModel);

		yearCombo.setSelectedItem(year); // 현재 년도 선택

		topPane.add(yearCombo);

		topPane.add(yearLbl);

		for (int i = 1; i <= 12; i++) {

			monthModel.addElement(i);

		}

		monthCombo.setModel(monthModel);

		monthCombo.setSelectedItem(month); // 현재 월 선택

		topPane.add(monthCombo);

		topPane.add(monthLbl);

		topPane.add(nextBtn);

		topPane.setBackground(new Color(100, 200, 200));

		add(topPane, "North");

		// Center

		titlePane.setBackground(Color.white);

		for (int i = 0; i < titleStr.length; i++) {

			JLabel lbl = new JLabel(titleStr[i], JLabel.CENTER);

			if (i == 0) {

				lbl.setForeground(Color.red);

			} else if (i == 6) {

				lbl.setForeground(Color.blue);

			}

			titlePane.add(lbl);

		}

		centerPane.add(titlePane, "North");

		// 날짜 출력

		dayPrint(year, month);

		centerPane.add(datePane, "Center");

		add(centerPane, "Center");

//		setSize(600, 500);
		setBounds(600,300,600,500);
		

		setVisible(true);

		prevBtn.addActionListener(this);

		nextBtn.addActionListener(this);

		yearCombo.addActionListener(this);

		monthCombo.addActionListener(this);

	}

	// Overring

	public void actionPerformed(ActionEvent ae) {

		Object obj = ae.getSource();

		if (obj instanceof JButton) {

			JButton eventBtn = (JButton) obj;

			int yy = (Integer) yearCombo.getSelectedItem();

			int mm = (Integer) monthCombo.getSelectedItem();

			if (eventBtn.equals(prevBtn)) { // 전달

				if (mm == 1) {

					yy--;
					mm = 12;

				} else {

					mm--;

				}

			} else if (eventBtn.equals(nextBtn)) { // 다음달

				if (mm == 12) {

					yy++;
					mm = 1;

				} else {

					mm++;

				}

			}

			yearCombo.setSelectedItem(yy);

			monthCombo.setSelectedItem(mm);

		} else if (obj instanceof JComboBox) { // 콤보박스 이벤트 발생시

			createDayStart();

		}

	}

	public void createDayStart() {

		datePane.setVisible(false); // 패널 숨기기

		datePane.removeAll(); // 날짜 출력한 라벨 지우기

		dayPrint((Integer) yearCombo.getSelectedItem(), (Integer) monthCombo.getSelectedItem());

		datePane.setVisible(true); // 패널 재출력

	}

	public void dayPrint(int y, int m) {

		Calendar cal = Calendar.getInstance();

		cal.set(y, m - 1, 1); // 출력할 첫날의 객체 만든다.

		int week = cal.get(Calendar.DAY_OF_WEEK); // 1일에 대한 요일 일요일 : 0

		int lastDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 그 달의 마지막 날

		for (int i = 1; i < week; i++) { // 날짜 출력 전까지의 공백 출력

			datePane.add(new JLabel(" "));

		}

		for (int i = 1; i <= lastDate; i++) {

			JLabel lbl = new JLabel(String.valueOf(i), JLabel.CENTER);

			cal.set(y, m - 1, i);

			int outWeek = cal.get(Calendar.DAY_OF_WEEK);

			if (outWeek == 1) {

				lbl.setForeground(Color.red);

			} else if (outWeek == 7) {

				lbl.setForeground(Color.BLUE);

			}

			datePane.add(lbl);

			lbl.addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent me) {
					JLabel mouseClick = (JLabel) me.getSource();
					String str = mouseClick.getText();
					String y = "" + yearCombo.getSelectedItem();
					String m = "" + monthCombo.getSelectedItem();

					System.out.println(str);
					// ----------------------------- 일정 만들기(송병권 06.22)
					JFrame f = new JFrame("일정");
					f.setSize(400, 250);
					f.setLocation(400, 0);
					f.setLayout(null);
					f.addWindowListener(null);
					f.setVisible(true);

					JLabel LTime = new JLabel("날짜 : ");
					LTime.setBounds(60, 60, 40, 40);
					TextField TTime = new TextField();
					TTime.setBounds(100, 60, 200, 40);

					JComboBox strCombo = new JComboBox(Time);
					strCombo.setBounds(300, 50, 75, 50);

					JButton bupd = new JButton("찾기");
					bupd.setBounds(100, 120, 75, 75);
					JButton bsub = new JButton("추가");
					bsub.setBounds(200, 120, 75, 75);

					TTime.setText(y + "-" + m + "-" + str);

					f.add(LTime);
					f.add(TTime);
					f.add(strCombo);

					f.add(bupd);
					f.add(bsub);
					
					
					
					
// 넣는 부분
					bsub.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String timeget = (String) strCombo.getSelectedItem();
							System.out.println(timeget);
							ArrayList<MemberVo> listcalc = dao.listcalc(y, m, str, timeget);

							if (listcalc.size() == 1) {
								JOptionPane.showMessageDialog(null, "해당 날짜에 일정이 있습니다.", "다음으로",
										JOptionPane.WARNING_MESSAGE);
							} else if (listcalc.size() == 0) {

								JFrame fin = new JFrame("일정추가");
								fin.setSize(400, 500);
								fin.setLocation(800, 0);
								fin.setLayout(null);
								fin.addWindowListener(null);

								JLabel schedule = new JLabel("날짜");
								schedule.setBounds(40, 50, 40, 40);
//								TextField Tscheduley = new TextField();
								JComboBox Tscheduley = new JComboBox(yearModel);
								Tscheduley.setBounds(100, 50, 50, 40);

//								TextField Tschedulem = new TextField();
								JComboBox Tschedulem = new JComboBox(monthModel);
								Tschedulem.setBounds(150, 50, 50, 40);

//								TextField Tscheduled = new TextField();
								JComboBox Tscheduled = new JComboBox(DayCombo1);
								Tscheduled.setBounds(200, 50, 50, 40);

								JLabel days = new JLabel("제목");
								days.setBounds(40, 150, 40, 40);
								TextField Tdays = new TextField();
								Tdays.setBounds(100, 150, 250, 40);

								JLabel contens = new JLabel("특이사항");
								contens.setBounds(40, 250, 60, 40);
								TextField Tcontens = new TextField();
								Tcontens.setBounds(100, 250, 250, 130);

								JComboBox straCombo = new JComboBox(Time);
								straCombo.setBounds(300, 50, 75, 50);

								JButton jbsub = new JButton("추가");
								jbsub.setBounds(100, 400, 70, 50);

								fin.add(schedule);
								fin.add(straCombo);
								fin.add(days);
								fin.add(contens);
								fin.add(Tscheduley);
								fin.add(Tschedulem);
								fin.add(Tscheduled);
								fin.add(Tdays);
								fin.add(Tcontens);

								fin.add(jbsub);
								fin.setVisible(true);

								jbsub.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {

										if (Tscheduley.equals(null)  ) {
											JOptionPane.showMessageDialog(null, "연도를 골라주세요.", "다음으로",
													JOptionPane.WARNING_MESSAGE);

										} else if (Tschedulem.equals(null)  ) {
											JOptionPane.showMessageDialog(null, "월 골라주세요.", "다음으로",
													JOptionPane.WARNING_MESSAGE);

										} else if (Tscheduled.equals(null)  ) {
											JOptionPane.showMessageDialog(null, "일 골라주세요.", "다음으로",
													JOptionPane.WARNING_MESSAGE);

										}
										else if (days.equals(null)) {
											JOptionPane.showMessageDialog(null, "제목을 적어주세요.", "다음으로",
													JOptionPane.WARNING_MESSAGE);

										}
										else {
											String yy=Tscheduley.getText();
											String mm=Tschedulem.getText();
											String dd=Tscheduled.getText();
											String time=(String) straCombo.getSelectedItem();
											String days=Tdays.getText();
											String Tcontens=Tcontens.Tcontens();
											dao.insult(yy, mm, dd, time, days, Tcontens);
										}
										
									}
								});
							}

						}

	
					});
					
					
// 찾는 부분
					bupd.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String timeget = (String) strCombo.getSelectedItem();
							System.out.println(timeget);
							ArrayList<MemberVo> listcalc = dao.listcalc(y, m, str, timeget);
							
							

							if (listcalc.size() == 0) {
								JOptionPane.showMessageDialog(null, "해당 날짜에 일정이 없습니다.", "다음으로",
										JOptionPane.WARNING_MESSAGE);

							} else {
								MemberVo calc = (MemberVo) listcalc.get(0);
								String yy = calc.getcalc_y();
								String mm = calc.getcalc_m();
								String dd = calc.getcalc_d();
								String time = calc.gettime();
								String titel = calc.gettitel();
								String contents = calc.getcontents();

								JFrame fse = new JFrame("일정찾기");
								fse.setSize(400, 500);
								fse.setLocation(800, 0);
								fse.setLayout(null);
								fse.addWindowListener(null);

								JLabel schedule = new JLabel("날짜");
								schedule.setBounds(40, 50, 40, 40);
								TextField Tscheduley = new TextField(yy);
								Tscheduley.setBounds(100, 50, 50, 40);

								TextField Tschedulem = new TextField(mm);
								Tschedulem.setBounds(150, 50, 50, 40);

								TextField Tscheduled = new TextField(dd);
								Tscheduled.setBounds(200, 50, 50, 40);

								JLabel days = new JLabel("제목");
								days.setBounds(40, 150, 40, 40);
								TextField Tdays = new TextField(titel);
								Tdays.setBounds(100, 150, 250, 40);

								JLabel contens = new JLabel("특이사항");
								contens.setBounds(40, 250, 60, 40);
								TextField Tcontens = new TextField(contents);
								Tcontens.setBounds(100, 250, 250, 130);

								JComboBox straCombo = new JComboBox(Time);
								straCombo.setBounds(300, 50, 75, 50);

								JButton jbin = new JButton("수정");
								jbin.setBounds(100, 400, 70, 50);
								JButton jbout = new JButton("삭제");
								jbout.setBounds(200, 400, 70, 50);
								fse.add(schedule);
								fse.add(straCombo);
								fse.add(days);
								fse.add(contens);
								fse.add(Tscheduley);
								fse.add(Tschedulem);
								fse.add(Tscheduled);
								fse.add(Tdays);
								fse.add(Tcontens);

								fse.add(jbin);
								fse.add(jbout);
								fse.setVisible(true);
								
								
								
// 수정 부분
								jbin.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										String yyin = Tscheduley.getText();
										String mmin = Tschedulem.getText();
										String ddin = Tscheduled.getText();
										String strin = (String) straCombo.getSelectedItem();
										String inday = Tdays.getText();
										String conin = Tcontens.getText();

										dao.timein(yyin, mmin, ddin, strin, inday, conin);
										JOptionPane.showMessageDialog(null, "정삭적으로 수정 되었습니다.", "수정",
												JOptionPane.WARNING_MESSAGE);
										fse.dispose();
									}

								});

								
// 삭제 부분
								jbout.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										String inday = Tdays.getText();
										dao.deltcal(inday);
										JOptionPane.showMessageDialog(null, "정삭적으로 삭제 되었습니다.", "삭제",
												JOptionPane.WARNING_MESSAGE);
										fse.dispose();
									}
								});
							}

						}

					});

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

			});

		}

	}

}