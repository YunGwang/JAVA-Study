package wootya;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberJoin extends JFrame {
	JLayeredPane LP;
	JPanel pBackGround, pMJBG;
	JLabel lTitle, lId, lPW, lName, lEmail, lHP,
			 lAdr, lsex, lbirth;
	JTextField tfId, tfPW, tfName, tfEmail, tfHP,tfbirth,
			tfAdr;
	JButton bMemberJoin, bCheckId, bMemberCancel;
	Checkbox cbM, cbF;
	Image img;
	Statement stmt = null;

	String sex; // cbM, cbF 의 선택상태에 따라 값을 넣어줌
	public void DispClear() {
		tfId.setText("");
		tfPW.setText("");
		tfName.setText("");
		tfEmail.setText("");
		tfHP.setText("ex)01011112222");
		tfAdr.setText("");
		tfbirth.setText("ex)19950101");
		}

		public MemberJoin() {
		setLayout(null);
		// img = Toolkit.getDefaultToolkit().getImage("image/Background.jpg");
		img = Toolkit.getDefaultToolkit().getImage("tv.jpg");
		LP = new JLayeredPane();

		// Panel 생성
		pBackGround = new JPanel() {
		public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, 1000, 700, this);
		}
		};
		pMJBG = new JPanel();

		// 레이블생성
		lTitle = new JLabel("회원가입");
		lId = new JLabel("ID");
		lName = new JLabel("이름");
		lPW = new JLabel("비밀번호");
		lEmail = new JLabel("E-mail");
		lHP = new JLabel("H P");
		lbirth = new JLabel("생년월일");
		lsex = new JLabel("성별");
		lAdr = new JLabel("상세주소");
	
		// TextField 생성
		tfId = new JTextField();
		tfPW = new JTextField();
		tfName = new JTextField();
		tfEmail = new JTextField();
		tfHP = new JTextField();
		tfAdr = new JTextField();
		tfbirth = new JTextField();
		// Button 생성
		bMemberJoin = new JButton("가입");
		bCheckId = new JButton("중복확인");
		bMemberCancel = new JButton("취소");

		lTitle.setFont(new Font("굴림", Font.BOLD, 20));

		bMemberJoin.addActionListener(new InsertDB());
		bMemberJoin.setBackground(new Color(35, 151, 151));
		bMemberJoin.setForeground(new Color(253, 243, 222));
		bCheckId.addActionListener(new viewPopUp());
		bCheckId.setBackground(new Color(35, 151, 151));
		bCheckId.setForeground(new Color(253, 243, 222));
		bMemberCancel.addActionListener(new goHome());
		bMemberCancel.setBackground(new Color(35, 151, 151));
		bMemberCancel.setForeground(new Color(253, 243, 222));

		CheckboxGroup group1 = new CheckboxGroup();
		cbM = new Checkbox("남", group1, true);
		cbF = new Checkbox("여", group1, false);
		LP.setLayout(null);
		LP.setBounds(0, 0, 1000, 700);

		pBackGround.setBounds(0, 0, 1000, 700);
		pMJBG.setBounds(150, 50, 700, 500);
		lTitle.setBounds(300, 50, 400, 100);
		lId.setBounds(300, 150, 70, 30);
		lPW.setBounds(300, 190, 70, 30);
		lName.setBounds(300, 230, 70, 30);
		lEmail.setBounds(300, 270, 70, 30);
		lHP.setBounds(300, 310, 190, 30);
		lAdr.setBounds(300, 350, 70, 30);
		lsex.setBounds(300, 390, 50, 30);
		lbirth.setBounds(300, 430, 70, 30);
		
		tfId.setBounds(395, 150, 200, 30);
		tfPW.setBounds(395, 190, 200, 30);
		tfName.setBounds(395, 230, 200, 30);
		tfEmail.setBounds(395, 270, 200, 30);
		bMemberJoin.setBackground(new Color(67, 116, 217));
		bMemberJoin.setForeground(new Color(253,243,222));
		bCheckId.setBackground(new Color(67, 116, 217));
		bCheckId.setForeground(new Color(253,243,222));
		bMemberCancel.setBackground(new Color(67, 116, 217));
		bMemberCancel.setForeground(new Color(253,243,222));

		tfHP.setBounds(395, 310, 200, 30);
		tfAdr.setBounds(395, 350, 300, 30);

		cbM.setBounds(395, 390, 50, 30);
		cbF.setBounds(445, 390, 50, 30);
		tfbirth.setBounds(395, 430, 200, 30);
		
		bCheckId.setBounds(600, 150, 90, 30);
		bMemberJoin.setBounds(540, 480, 70, 40);
		bMemberCancel.setBounds(620, 480, 70, 40);

		LP.add(pBackGround, new Integer(0));
		LP.add(lTitle, new Integer(2));
		LP.add(lId, new Integer(2));
		LP.add(lPW, new Integer(2));
		LP.add(lName, new Integer(2));
		LP.add(lEmail, new Integer(2));
		LP.add(lHP, new Integer(2));
		LP.add(lAdr, new Integer(2));
		LP.add(lsex, new Integer(2));
		LP.add(tfId, new Integer(2));
		LP.add(tfPW, new Integer(2));
		LP.add(tfName, new Integer(2));
		LP.add(tfEmail, new Integer(2));
		LP.add(tfHP, new Integer(2));
		LP.add(tfAdr, new Integer(2));
		LP.add(bMemberJoin, new Integer(2));
		LP.add(bCheckId, new Integer(2));
		LP.add(bMemberCancel, new Integer(2));
		LP.add(cbM, new Integer(2));
		LP.add(cbF, new Integer(2));
		LP.add(tfbirth, new Integer(2));
		LP.add(lbirth, new Integer(2));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		setTitle("회원등록");

		setContentPane(LP);
		setSize(1000, 600);
		}

		private class InsertDB implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		Connection conn;
		Statement stmt;

		try {

		// Class.forName("com.mysql.jdbc.Driver").newInstance();
		conn = Main.conn;

		if (cbM.getState() == true)
		sex = "M";
		else
		sex = "F";

		if ((tfId.getText() != "") || (tfPW.getText() != "")
		|| (tfName.getText() != "")
		|| (tfEmail.getText() != "") || (tfHP.getText() != "")
		|| (tfAdr.getText() != "")) {
		String sql = "INSERT INTO member VALUES ('"
		+ tfId.getText() + "','" + tfName.getText() + "','"
		+ tfPW.getText() + "','" + tfEmail.getText()
		+ "','" +  tfHP.getText() + "',to_date('" + tfbirth.getText()
		+  "','yyyy-mm-dd'),'" +sex+ "','" +tfAdr.getText() + "')";
		System.out.println(sql);
		stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		JOptionPane.showMessageDialog(null, "가입완료", "회원등록",
		JOptionPane.PLAIN_MESSAGE);
		DispClear();
		FrameManager.getInstance().showFrame("First");
		}
		} catch (SQLException ex) {
		ex.printStackTrace();
		} catch (Exception ex) {
		ex.printStackTrace();
		}
		}
		}

		private class goHome implements ActionListener {
			public void actionPerformed(ActionEvent e) {
			DispClear();
			FrameManager.getInstance().showFrame("First");
			}
			}

			private class viewPopUp implements ActionListener {
			public void actionPerformed(ActionEvent e) {
			Connection conn;
			ResultSet rs;

			try {
			conn = Main.conn;
			String sql = "Select * from member where mem_id = '"
			+ tfId.getText() + "'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
			JOptionPane.showMessageDialog(null, "중복입니다. 다른ID를입력하세요.",
			"ID 중복확인", JOptionPane.PLAIN_MESSAGE);
			} else {
			JOptionPane.showMessageDialog(null, "사용가능한ID입니다.",
			"ID 중복확인", JOptionPane.PLAIN_MESSAGE);
			}

			} catch (Exception ex) {
			ex.printStackTrace();
			}
			}
			}
			}