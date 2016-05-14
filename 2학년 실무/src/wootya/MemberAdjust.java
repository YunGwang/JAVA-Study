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

public class MemberAdjust extends JFrame {
	public static String ID;
	public static String PW;

	JLayeredPane LP;
	JPanel pBackGround, pMJBG;
	JLabel lTitle, lId, lPW, lName, lEmail, lHP,  lPost, lAdr, lsex,lbirth;
	JTextField tfId, tfPW, tfName, tfEmail, tfHP, tfPost, tfAdr,tfbirth;
	JButton bMemberAdjust, bLoad, bMemberCancel, bMemberDrop;
	Checkbox cbM, cbF;
	CheckboxGroup group1;
	Image img;

	public void DispClear() {
		tfId.setText("");
		tfPW.setText("");
		tfName.setText("");
		tfEmail.setText("");
		tfHP.setText("");
		tfbirth.setText("");
		tfAdr.setText("");
	}

	
	public MemberAdjust() {
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

		// 레이블 생성
		lTitle = new JLabel("회원정보");
		lId = new JLabel("ID");
		lPW = new JLabel("비밀번호");
		lName = new JLabel("이름");
		lEmail = new JLabel("E-mail");
		lHP = new JLabel("H P");
		lbirth = new JLabel("생년월일");
		lAdr = new JLabel("상세주소");
		lsex = new JLabel("성별");
		
		
		// TextField 생성
		tfId = new JTextField();
		tfPW = new JTextField();
		tfName = new JTextField();
		tfEmail = new JTextField();
		tfHP = new JTextField();
		tfAdr = new JTextField();
		tfbirth = new JTextField();
		
		
		// Button 생성
		bMemberAdjust = new JButton("수정");
		bLoad = new JButton("불러오기");
		bMemberCancel = new JButton("취소");
		bMemberDrop = new JButton("탈퇴");
		lTitle.setFont(new Font("굴림", Font.BOLD, 20));

		bMemberAdjust.addActionListener(new UpdateDB());
		bMemberAdjust.setBackground(new Color(35, 151, 151));
		bMemberAdjust.setForeground(new Color(253, 243, 222));
		bLoad.addActionListener(new load());
		bLoad.setBackground(new Color(35, 151, 151));
		bLoad.setForeground(new Color(253, 243, 222));
		bMemberCancel.addActionListener(new goHome1());
		bMemberCancel.setBackground(new Color(35, 151, 151));
		bMemberCancel.setForeground(new Color(253, 243, 222));
		bMemberDrop.addActionListener(new delete());
		bMemberDrop.setBackground(new Color(35, 151, 151));
		bMemberDrop.setForeground(new Color(253, 243, 222));

		pMJBG.setBackground(new Color(255, 255, 255));

		
	
		CheckboxGroup group1 = new CheckboxGroup();
		cbM = new Checkbox("남", group1, false);
		cbF = new Checkbox("여", group1, false);
		LP.setLayout(null);
		LP.setBounds(0, 0, 1000, 700);

		pBackGround.setBounds(0, 0, 1000, 700);
		// pMJBG.setBounds(150, 50, 700, 500);
		lTitle.setBounds(300, 10, 400, 100);
		lId.setBounds(300, 110, 70, 30);
		lPW.setBounds(300, 150, 70, 30);
		lName.setBounds(300, 190, 70, 30);
		lEmail.setBounds(300, 230, 70, 30);
		lHP.setBounds(300, 270, 70, 30);
		lAdr.setBounds(300, 310, 70, 30);
		lsex.setBounds(300, 390, 50, 30);
		lbirth.setBounds(300, 350, 70, 30);
		bMemberAdjust.setBackground(new Color(67, 116, 217));
		bMemberAdjust.setForeground(new Color(253,243,222));
		bLoad.setBackground(new Color(67, 116, 217));
		bLoad.setForeground(new Color(253,243,222));
		bMemberCancel.setBackground(new Color(67, 116, 217));
		bMemberCancel.setForeground(new Color(253,243,222));
		bMemberDrop.setBackground(new Color(67, 116, 217));
		bMemberDrop.setForeground(new Color(253,243,222));
		tfId.setBounds(395, 110, 200, 30);
		tfPW.setBounds(395, 150, 200, 30);
		tfName.setBounds(395, 190, 200, 30);
		tfEmail.setBounds(395, 230, 200, 30);
		tfHP.setBounds(395, 270, 200, 30);
		tfAdr.setBounds(395, 310, 300, 30);
		tfbirth.setBounds(395, 350, 200, 30);

		cbM.setBounds(395, 390, 50, 30);
		cbF.setBounds(445, 390, 50, 30);
		bLoad.setBounds(600, 110, 90, 30);
		bMemberDrop.setBounds(460, 490, 70, 40);
		bMemberAdjust.setBounds(540, 490, 70, 40);
		bMemberCancel.setBounds(620, 490, 70, 40);

		LP.add(pBackGround, new Integer(0));
		LP.add(pMJBG, new Integer(1));		
		LP.add(lTitle, new Integer(2));
		LP.add(lId, new Integer(2));
		LP.add(lPW, new Integer(2));
		LP.add(lName, new Integer(2));
		LP.add(lEmail, new Integer(2));
		LP.add(lHP, new Integer(2));
		LP.add(lAdr, new Integer(2));
		LP.add(lsex, new Integer(2));
		LP.add(lbirth, new Integer(2));	
		LP.add(tfId, new Integer(2));
		LP.add(tfPW, new Integer(2));
		LP.add(tfName, new Integer(2));
		LP.add(tfEmail, new Integer(2));
		LP.add(tfHP, new Integer(2));
		LP.add(tfAdr, new Integer(2));
		LP.add(tfbirth, new Integer(2));
		// LP.add(cHP,new Integer(2));
		LP.add(bLoad, new Integer(2));
		LP.add(bMemberCancel, new Integer(2));
		LP.add(bMemberDrop, new Integer(2));
		LP.add(bMemberAdjust, new Integer(2));
		LP.add(cbM, new Integer(2));
		LP.add(cbF, new Integer(2));


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle("회원정보 수정");
		tfId.setEditable(false);
		setContentPane(LP);
		setSize(1000, 600);
		
	}

	private class UpdateDB implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ID = Home1.ID;
			PW = Home1.PW;

			try {
				Statement stmt = null;
				Connection conn;
				conn = Main.conn;

				String sex = null;
				if (cbM.getState() == true)
					sex = "M";
				else
					sex = "F";

				String sql = "update member set mem_pwd='"+ tfPW.getText() + "',mem_name='"
						+ tfName.getText() + "',mem_email = '" + tfEmail.getText()
						+ "',mem_phone='" +  tfHP.getText() + "',mem_address='" + tfAdr.getText()
						+  "',mem_sex='" +sex+ "',mem_birth= to_date('" +tfbirth.getText()  
						+ "','yyyymmdd'), "+ " where mem_id = '" + tfId.getText()+"'";
				System.out.println(sql);
				stmt = conn.createStatement();
				stmt.executeUpdate(sql);

				DispClear();
				JOptionPane.showMessageDialog(null, "회원정보 수정 완료", "회원정보 수정", JOptionPane.PLAIN_MESSAGE);

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	private class delete implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				Statement stmt = null;
				Connection conn;
				ResultSet rs;

				conn = Main.conn;
				String sql = "Select * from member where mem_Id = '" + ID + "'";
				stmt = conn.createStatement();

				rs = stmt.executeQuery(sql);

				if (rs.next()) {
					int i = JOptionPane.showConfirmDialog(null, "정말로 탈퇴하시겠습니까?", "확인", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
					if (i == 0) {
						String sql2 = "delete  member where mem_id='" + tfId.getText() + "'";
						System.out.println(sql2);
						stmt = conn.createStatement();

						stmt.executeUpdate(sql2);
						JOptionPane.showMessageDialog(null, "탈퇴 완료", "회원 탈퇴", JOptionPane.PLAIN_MESSAGE);
						DispClear();

						FrameManager.getInstance().showFrame("First");
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
	}

	private class goHome1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DispClear();
			FrameManager.getInstance().showFrame("Home1");
		}
	}

	private class load implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ID = Home1.ID;
			PW = Home1.PW;

			try {
				Statement stmt = null;
				Connection conn;
				ResultSet rs;

				conn = Main.conn;

				String sql = "Select * from member where mem_Id='" + ID  + "' ";
				System.out.println(sql);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);

				if (rs.next()) {
					JOptionPane.showMessageDialog(null, "회원정보를 성공적으로 불러왔습니다.", "회원정보 불러오기 성공",
							JOptionPane.PLAIN_MESSAGE);
					tfId.setText(ID);
					tfPW.setText("");

					String sql_select = null;
					sql_select = "select mem_id, mem_pwd, mem_name ,mem_email, mem_phone, mem_address ,mem_birth, mem_sex from member where mem_id='"
							+ ID + "'";
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql_select);

					while (rs.next()) {
						tfId.setText(rs.getString(1));
						tfPW.setText(rs.getString(2));
						tfName.setText(rs.getString(3));
						tfEmail.setText(rs.getString(4));
						tfHP.setText(rs.getString(5));
						tfAdr.setText(rs.getString(6));
						tfbirth.setText(rs.getString(7));
						if (rs.getString(6) == "F") {
							cbF.setState(true);
						} else {
							cbM.setState(true);
						}
					}
				}

			} catch (Exception e1) {
				e1.printStackTrace();

			}
		}
	}

}