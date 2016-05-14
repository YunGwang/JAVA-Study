package wootya;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class First extends JFrame {
	public static String ID;
	public static String PW;

	JLayeredPane LP;
	JPanel pBackGround;
	JButton bMember, bSM, bMaster;
	Image img;
	Statement stmt = null;
	Connection conn;
	JLabel lId, lPw;
	JButton bLogin, bmemberJoin;
	JTextField tfId, tfPw;

	public First() {
		setLayout(null);
		img = Toolkit.getDefaultToolkit().getImage("image/irene4.jpg");
		LP = new JLayeredPane();
		pBackGround = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(img, 0, 0, 1000, 570, this);
			}
		};

		bLogin = new JButton("로그인");
		bLogin.addActionListener(new Login());
		bmemberJoin = new JButton("회원가입");
		bmemberJoin.setBackground(new Color(67, 116, 217));
		bmemberJoin.setForeground(new Color(253,243,222));
		bmemberJoin.addActionListener(new GoMemberJoin());

		lId = new JLabel("아이디");
		lPw = new JLabel("비밀번호");

		tfId = new JTextField("");
		tfPw = new JPasswordField("");

		bLogin.setFont(new Font("굴림", Font.BOLD, 20));
		bLogin.setBackground(new Color(67, 116, 217));
		bLogin.setForeground(new Color(253,243,222));
		bmemberJoin.setFont(new Font("굴림", Font.BOLD, 15));
		lId.setFont(new Font("굴림", Font.BOLD, 15));
		lPw.setFont(new Font("굴림", Font.BOLD, 15));

		LP.setLayout(null);
		LP.setBounds(0, 0, 1000, 700);
		pBackGround.setBounds(0, 0, 1000, 700);

		lId.setBounds(690, 280, 80, 30);
		lPw.setBounds(690, 315, 80, 30);
		tfId.setBounds(755, 280, 100, 30);
		tfPw.setBounds(755, 315, 100, 30);
		bLogin.setBounds(860, 280, 100, 66);
		bmemberJoin.setBounds(755, 360, 100, 40);
		LP.add(pBackGround, new Integer(0));
		LP.add(lId, new Integer(1));
		LP.add(lPw, new Integer(1));
		LP.add(tfId, new Integer(1));
		LP.add(tfPw, new Integer(1));
		LP.add(bLogin, new Integer(1));
		LP.add(bmemberJoin, new Integer(1));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("메인화면");

		add(LP);
		setSize(1000, 600);
	}

	private class GoMemberJoin implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			FrameManager.getInstance().showFrame("MemberJoin");
		}
	}

	private class Login implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			ResultSet rs1, rs2;
			String sql1, sql2;

			try {
				conn = Main.conn;

				sql1 = "Select * from member where mem_id = '" + tfId.getText() + "' and mem_pwd='" + tfPw.getText()
						+ "' ";

				sql2 = "Select * from member where mem_id = '" + tfId.getText() + "' and mem_pwd='" + tfPw.getText()
						+ "' ";

				stmt = conn.createStatement();
				rs1 = stmt.executeQuery(sql1);
				stmt = conn.createStatement();
				rs2 = stmt.executeQuery(sql2);

				if (rs1.next()) {
					ID = tfId.getText();
					PW = tfPw.getText();
					tfId.setText("");
					tfPw.setText("");
					FrameManager.getInstance().showFrame("Home1");
					return;
				}

				if (rs2.next()) {
					ID = tfId.getText();
					PW = tfPw.getText();
					tfId.setText("");
					tfPw.setText("");
					FrameManager.getInstance().showFrame("Home2");
					return;
				}

				JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 다시 입력해주세요", "로그인실패", JOptionPane.PLAIN_MESSAGE);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
	}
}
