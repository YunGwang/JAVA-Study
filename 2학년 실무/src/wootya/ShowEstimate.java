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

public class ShowEstimate extends JFrame {
	public static String ID;
	public static String PW;

	JLayeredPane LP;
	JPanel pBackGround, pMJBG;
	JLabel lTitle, lId, lPW, lName, lEmail, lHP,  lPost, lAdr, lsex,lbirth, lprice;
	JTextField tfId, tfPW, tfName, tfEmail, tfHP, tfPost, tfAdr,tfbirth, tfsex, tfprice;
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
		tfsex.setText("");
		tfprice.setText("");
	}

	
	public ShowEstimate() {
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
		lTitle = new JLabel("견적서 정보");
		lId = new JLabel("ID");
		lPW = new JLabel("CPU");
		lName = new JLabel("VGA");
		lEmail = new JLabel("RAM");
		lHP = new JLabel("MBoard");
		lbirth = new JLabel("POWER");
		lAdr = new JLabel("CASE");
		lsex = new JLabel("HDD");
		lprice = new JLabel("가격");
		
		
		// TextField 생성
		tfId = new JTextField();
		tfPW = new JTextField();
		tfName = new JTextField();
		tfEmail = new JTextField();
		tfHP = new JTextField();
		tfAdr = new JTextField();
		tfbirth = new JTextField();
		tfsex = new JTextField();
		tfprice = new JTextField();
		
		// Button 생성
		bMemberAdjust = new JButton("수정");
		bLoad = new JButton("불러오기");
		bMemberCancel = new JButton("취소");
		bMemberDrop = new JButton("삭제");
		lTitle.setFont(new Font("굴림", Font.BOLD, 20));

		bMemberAdjust.addActionListener(new UpdateDB());
		bMemberAdjust.setBackground(new Color(35, 151, 151));
		bMemberAdjust.setForeground(new Color(253, 243, 222));
		bLoad.addActionListener(new load());
		bLoad.setBackground(new Color(35, 151, 151));
		bLoad.setForeground(new Color(253, 243, 222));
		bMemberCancel.addActionListener(new goHome1());
		bMemberDrop.addActionListener(new delete());
		bMemberDrop.setBackground(new Color(35, 151, 151));
		bMemberDrop.setForeground(new Color(253, 243, 222));
		bMemberCancel.setBackground(new Color(35, 151, 151));
		bMemberCancel.setForeground(new Color(253, 243, 222));
		pMJBG.setBackground(new Color(255, 255, 255));


		CheckboxGroup group1 = new CheckboxGroup();
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
		lprice.setBounds(300, 430, 70, 30);

		tfId.setBounds(395, 110, 200, 30);
		tfPW.setBounds(395, 150, 250, 30);
		tfName.setBounds(395, 190, 250, 30);
		tfEmail.setBounds(395, 230, 250, 30);
		tfHP.setBounds(395, 270, 250, 30);
		tfAdr.setBounds(395, 310, 250, 30);
		tfbirth.setBounds(395, 350, 250, 30);
		tfsex.setBounds(395, 390, 250, 30);
		tfprice.setBounds(395, 430, 250, 30);


		bLoad.setBounds(600, 110, 90, 30);
		bMemberDrop.setBounds(460, 490, 70, 40);
		bMemberAdjust.setBounds(540, 490, 70, 40);
		bMemberCancel.setBounds(620, 490, 70, 40);
		bLoad.setBackground(new Color(67, 116, 217));
		bLoad.setForeground(new Color(253,243,222));
		bMemberDrop.setBackground(new Color(67, 116, 217));
		bMemberDrop.setForeground(new Color(253,243,222));
		bMemberCancel.setBackground(new Color(67, 116, 217));
		bMemberCancel.setForeground(new Color(253,243,222));
		bMemberAdjust.setBackground(new Color(67, 116, 217));
		bMemberAdjust.setForeground(new Color(253,243,222));
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
		LP.add(tfsex, new Integer(2));
		LP.add(tfprice, new Integer(2));
		LP.add(lprice, new Integer(2));
		LP.add(bLoad, new Integer(2));
		LP.add(bMemberCancel, new Integer(2));
		LP.add(bMemberAdjust, new Integer(2));
		LP.add(bMemberDrop, new Integer(2));

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

				String sql = "update estimate1 set cpu_name='" + tfPW.getText()
						+ "',vga_name='"+ tfName.getText() 
						+ "',ram_name = '" + tfEmail.getText() 
						+ "',mboard_name='" + tfHP.getText()
						+ "',power_name='" + tfbirth.getText() 
						+ "',case_name='" + tfAdr.getText()
						+ "',hdd_name='" + tfsex.getText() 
						+ " ,price=" + tfprice.getText()
						+ "' where mem_id = '" + tfId.getText()+"'";
				System.out.println(sql);
				stmt = conn.createStatement();
				stmt.executeUpdate(sql);

				DispClear();
				JOptionPane.showMessageDialog(null, "견적서 정보 수정 완료", "견적서 정보 수정", JOptionPane.PLAIN_MESSAGE);
				tfId.setText("");
				tfPW.setText("");
				tfName.setText("");
				tfEmail.setText("");
				tfHP.setText("");
				tfbirth.setText("");
				tfAdr.setText("");
				tfsex.setText("");
				tfprice.setText("");

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
				String sql = "Select * from estimate1 where mem_Id = '" + ID + "'";
				stmt = conn.createStatement();

				rs = stmt.executeQuery(sql);
		
				tfsex.setText("");
				if (rs.next()) {
					int i = JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠습니까?", "확인", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
					if (i == 0) {
						String sql2 = "delete ESTIMATE1 where mem_id='" + tfId.getText() + "'";
						System.out.println(sql2);
						stmt = conn.createStatement();

						stmt.executeUpdate(sql2);
						JOptionPane.showMessageDialog(null, "삭제 완료", "견적서 삭제", JOptionPane.PLAIN_MESSAGE);
						DispClear();

						FrameManager.getInstance().showFrame("Home1");
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
			ID = Home1.ID; //홈 화면 클래스내에 저장되어있는 ID를 선언
			PW = Home1.PW; //홈 화면 클래스내에 저장되어있는 PW를 선언

			try {
				Statement stmt = null;
				Connection conn;
				ResultSet rs;

				conn = Main.conn;

				String sql = "Select * from ESTIMATE1 where MEM_ID='" + ID  + "' "; //견적서 테이블 중 해당 아이디의 견적서 출력
				System.out.println(sql);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);

				if (rs.next()) { // next로 끝까지 간 다음
					JOptionPane.showMessageDialog(null, "견적서 정보를 성공적으로 불러왔습니다.", "견적서 정보 불러오기 성공",
							JOptionPane.PLAIN_MESSAGE);
					tfId.setText(ID); // 받아온 ID를 아이디 텍스트필드에 setText시킨다.

					String sql_select = null;
					sql_select = "select mem_id, CPU_NAME, VGA_NAME, RAM_NAME, MBOARD_NAME, POWER_NAME, CASE_NAME, HDD_NAME, price from estimate1 where mem_id='"
							+ ID + "'";
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql_select);

					while (rs.next()) {
						tfId.setText(rs.getString(1)); //1번부터 9번까지 모든 컬럼을 불러온다.
						tfPW.setText(rs.getString(2));
						tfName.setText(rs.getString(3));
						tfEmail.setText(rs.getString(4));
						tfHP.setText(rs.getString(5));
						tfAdr.setText(rs.getString(6));
						tfbirth.setText(rs.getString(7));
						tfsex.setText(rs.getString(8));
						tfprice.setText(rs.getString(9));
					
					}
				}

			} catch (Exception e1) {
				e1.printStackTrace();

			}
		}
	}

}