package wootya;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Estimate extends JFrame {
	public static String ID;
	public static String PW;
	private int a, b;
	JPanel pBackGround;
	Image img;
	JLayeredPane pane;
	JLabel label1, label2, label3, label4, label5, label6, label7, label8, memberid, price, p1, p2, p3, p4, p5, p6, p7,
			part;
	JTextField title, select1, select2, select3, select4, select5, select6, select7, memid, price1;
	JComboBox comboBox;
	JButton search, btn8, btn9, btn0, goclean, back, update, load, cpt;

	public Estimate() {

		setTitle("견적서 작성");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane = new JLayeredPane();

		////// 화면구성/////
		setLayout(null);
		JLabel title2 = new JLabel("손쉬운 구매");
		JLabel title = new JLabel("견적서 작성");
		JLabel label1 = new JLabel("CPU");
		JLabel label2 = new JLabel("VGA");
		JLabel label3 = new JLabel("RAM");
		JLabel label4 = new JLabel("MBoard");
		JLabel label5 = new JLabel("POWER");
		JLabel label6 = new JLabel("CASE");
		JLabel label7 = new JLabel("HDD");
		JLabel memberid = new JLabel("회원ID");
		JLabel price = new JLabel("합계");
		JLabel p1 = new JLabel("");
		JLabel p2 = new JLabel("");
		JLabel p3 = new JLabel("");
		JLabel p4 = new JLabel("");
		JLabel p5 = new JLabel("");
		JLabel p6 = new JLabel("");
		JLabel p7 = new JLabel("");
		JLabel part = new JLabel("부품별 가격");
		search = new JButton("부품조회");
		btn8 = new JButton("견적서저장");
		cpt = new JButton("호환성검사");
		btn9 = new JButton("견적입찰");
		goclean = new JButton("초기화");
		update = new JButton("견적 갱신");
		back = new JButton("뒤로가기");
		load = new JButton("ID 불러오기");
		btn8.addActionListener(new InsertDB());
		back.addActionListener(new Home1());
		search.setBackground(new Color(67, 116, 217));
		search.setForeground(new Color(253, 243, 222));
		btn8.setBackground(new Color(67, 116, 217));
		btn8.setForeground(new Color(253, 243, 222));
		cpt.setBackground(new Color(67, 116, 217));
		cpt.setForeground(new Color(253, 243, 222));
		goclean.setBackground(new Color(67, 116, 217));
		goclean.setForeground(new Color(253, 243, 222));
		update.setBackground(new Color(67, 116, 217));
		update.setForeground(new Color(253, 243, 222));
		back.setBackground(new Color(67, 116, 217));
		back.setForeground(new Color(253, 243, 222));
		load.setBackground(new Color(67, 116, 217));
		load.setForeground(new Color(253, 243, 222));
		btn9.setBackground(new Color(67, 116, 217));
		btn9.setForeground(new Color(253, 243, 222));

		title.setBounds(440, 30, 100, 30);
		pane.add(title);
		select1 = new JTextField(30);
		select1.setBounds(360, 100, 220, 30);
		select1.setEditable(false);
		pane.add(select1);

		memid = new JTextField(80);
		memid.setBounds(700, 420, 100, 40);
		memid.setVisible(false);
		pane.add(memid);

		label1.setBounds(310, 100, 70, 30);
		pane.add(label1);

		part.setBounds(590, 70, 70, 30);
		pane.add(part);

		load.setBounds(590, 420, 100, 40);
		load.addActionListener(new load());
		pane.add(load);

		search.setBounds(590, 470, 100, 40);
		search.addActionListener(new goPart());
		pane.add(search);

		select2 = new JTextField(80);
		select2.setBounds(360, 140, 220, 30);
		select2.setEditable(false);
		pane.add(select2);

		label2.setBounds(310, 140, 70, 30);
		pane.add(label2);

		select3 = new JTextField(80);
		select3.setBounds(360, 180, 220, 30);
		select3.setEditable(false);
		pane.add(select3);

		label3.setBounds(310, 180, 70, 30);
		pane.add(label3);

		select4 = new JTextField(80);
		select4.setBounds(360, 220, 220, 30);
		select4.setEditable(false);
		pane.add(select4);

		label4.setBounds(310, 220, 120, 30);
		pane.add(label4);

		select5 = new JTextField(80);
		select5.setBounds(360, 260, 220, 30);
		select5.setEditable(false);
		pane.add(select5);

		label5.setBounds(310, 260, 70, 30);
		pane.add(label5);

		select6 = new JTextField(80);
		select6.setBounds(360, 300, 220, 30);
		select6.setEditable(false);
		pane.add(select6);

		label6.setBounds(310, 300, 70, 30);
		pane.add(label6);

		select7 = new JTextField(80);
		select7.setBounds(360, 340, 220, 30);
		select7.setEditable(false);
		pane.add(select7);

		p1.setBounds(590, 100, 70, 30);
		pane.add(p1);
		p2.setBounds(590, 140, 70, 30);
		pane.add(p2);
		p3.setBounds(590, 180, 70, 30);
		pane.add(p3);
		p4.setBounds(590, 220, 70, 30);
		pane.add(p4);
		p5.setBounds(590, 260, 70, 30);
		pane.add(p5);
		p6.setBounds(590, 300, 70, 30);
		pane.add(p6);
		p7.setBounds(590, 340, 70, 30);
		pane.add(p7);
		price1 = new JTextField(80);
		price1.setBounds(590, 380, 80, 30);
		price1.setEditable(false);
		pane.add(price1);

		label7.setBounds(310, 340, 70, 30);
		pane.add(label7);

		price.setBounds(545, 380, 70, 30);
		pane.add(price);

		btn8.setBounds(360, 420, 100, 40);
		pane.add(btn8);
		cpt.setBounds(360, 375, 100, 35);
		pane.add(cpt);

		btn9.setBounds(480, 420, 100, 40);
		pane.add(btn9);

		goclean.setBounds(480, 470, 100, 40);
		pane.add(goclean);

		update.setBounds(360, 470, 100, 40);
		pane.add(update);

		back.setBounds(780, 530, 100, 40);
		pane.add(back);
	     title2.setBounds(255, 55, 100, 30);
	      pane.add(title2);
		 comboBox = new JComboBox();
	      comboBox.setModel(new DefaultComboBoxModel(new String[]{"","사무용","게임용(중)","게임용(고)"}));
	      comboBox.setBounds(250,80, 100, 20);
	      pane.add(comboBox);

		goclean.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				select1.setBackground(new Color(238, 238, 238));
				select2.setBackground(new Color(238, 238, 238));
				select3.setBackground(new Color(238, 238, 238));
				select4.setBackground(new Color(238, 238, 238));
				select5.setBackground(new Color(238, 238, 238));
				select6.setBackground(new Color(238, 238, 238));
				select7.setBackground(new Color(238, 238, 238));

				select1.setText("");
				select2.setText("");
				select3.setText("");
				select4.setText("");
				select5.setText("");
				select6.setText("");
				select7.setText("");
				p1.setText("");
				p2.setText("");
				p3.setText("");
				p4.setText("");
				p5.setText("");
				p6.setText("");
				p7.setText("");
				price1.setText("");
				memid.setText("");
			}
		});

		btn9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "입찰 등록을 완료했습니다.", "입찰 대기", JOptionPane.PLAIN_MESSAGE);

			}
		});
		cpt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PartFind mf = new PartFind();

				int a = (mf.cpc);
				int b = mf.mbc;
				if (a == b) {
					select1.setBackground(new Color(83, 255, 76));
					select2.setBackground(new Color(83, 255, 76));
					select3.setBackground(new Color(83, 255, 76));
					select4.setBackground(new Color(83, 255, 76));
					select5.setBackground(new Color(83, 255, 76));
					select6.setBackground(new Color(83, 255, 76));
					select7.setBackground(new Color(83, 255, 76));

					JOptionPane.showMessageDialog(null, "올바른 호환입니다", "호환성 체크", JOptionPane.PLAIN_MESSAGE);
				} else {
					select1.setBackground(new Color(255, 36, 36));
					select2.setBackground(new Color(83, 255, 76));
					select3.setBackground(new Color(83, 255, 76));
					select4.setBackground(new Color(255, 36, 36));
					select5.setBackground(new Color(83, 255, 76));
					select6.setBackground(new Color(83, 255, 76));
					select7.setBackground(new Color(83, 255, 76));

					JOptionPane.showMessageDialog(null, "CPU와 메인보드의 호환이 맞지 않습니다.", "호환성 체크", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});

		search.addActionListener(new ActionListener() {
			PartFind mf = new PartFind();

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		 update.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) { 
	               PartFind mf = new PartFind();
	               if(comboBox.getSelectedItem() != ""){
	                  if(comboBox.getSelectedItem() == "사무용"){
	                     select1.setText("AMD 2650 (카비니)");
	                        select2.setText("이엠텍 지포스 GTS250  512MB");
	                        select3.setText("마이크론 DDR3 4G PC3-12800");
	                        select4.setText("ASRock 970 PRO3 R2.0");
	                        select5.setText("POWEREX REX III 500W Triple V2.3");
	                        select6.setText("COX CX100 데프콘 USB3.0");
	                        select7.setText("WD 1TB BLUE WD10EZEX");
	                        p1.setText("37000");
	                        p2.setText("25000");
	                        p3.setText("55500");
	                        p4.setText("86000");
	                        p5.setText("39000");
	                        p6.setText("23000");
	                        p7.setText("55000");
	                     
	                  }
	                  if(comboBox.getSelectedItem() == "게임용(중)"){
	                     select1.setText("AMD 8300 (비쉐라) (정품)");
	                        select2.setText("ASUS 지포스 GTX750 Ti 2GB STCOM");
	                        select3.setText("마이크론 DDR3 4G PC3-12800");
	                        select4.setText("ASRock 970 PRO3 R2.0");
	                        select5.setText("POWEREX REX III 500W Triple V2.3");
	                        select6.setText("ABKO NCORE G200 타노스 USB3.0");
	                        select7.setText("WD 1TB BLUE WD10EZEX");
	                        p1.setText("136500");
	                        p2.setText("167500");
	                        p3.setText("55500");
	                        p4.setText("86000");
	                        p5.setText("39000");
	                        p6.setText("53000");
	                        p7.setText("55000");
	                     
	                  }
	                  if(comboBox.getSelectedItem() == "게임용(고)"){
	                     select1.setText("인텔 코어i5-4세대 4690");
	                        select2.setText("기가바이트 GF GTX960 SOC DDR5 2G G1");
	                        select3.setText("삼성전자 8G DDR3 12800");
	                        select4.setText("ASUS B85M-G STCOM");
	                        select5.setText("SuperFlower SF-750F14MG GOLD");
	                        select6.setText("ABKO NCORE G200 타노스 USB3.0");
	                        select7.setText("WD 4TB Red WD40EFRX");
	                        p1.setText("287000");
	                        p2.setText("278600");
	                        p3.setText("55500");
	                        p4.setText("86000");
	                        p5.setText("86000");
	                        p6.setText("53000");
	                        p7.setText("162000");
	                     
	                  }
	               
	               }
	         
	               else{
	             select1.setText(mf.cp);
	            select2.setText(mf.vg);
	            select3.setText(mf.ra);
	            select4.setText(mf.mb);
	            select5.setText(mf.pw);
	            select6.setText(mf.ca);
	            select7.setText(mf.hdd);
	            p1.setText(mf.cpp);
	            p2.setText(mf.vgp);
	            p3.setText(mf.rap);
	            p4.setText(mf.mbp);
	            p5.setText(mf.pwp);
	            p6.setText(mf.cap);
	            p7.setText(mf.hddp);
	               }
	            int sum = (Integer.parseInt(p1.getText().toString()) + Integer.parseInt(p2.getText().toString())+ + Integer.parseInt(p3.getText().toString())
	            + Integer.parseInt(p4.getText().toString())+Integer.parseInt(p5.getText().toString())+ Integer.parseInt(p6.getText().toString())+ Integer.parseInt(p7.getText().toString()));
	            String sum1 = Integer.toString(sum);
	            price1.setText(sum1);
	                  
	            }
	            
	          });

	      setSize(1000, 620);
	      setContentPane(pane);
	   }

	private class InsertDB implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Connection conn;
			Statement stmt;

			try {

				// Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn = Main.conn;

				if ((memid.getText() != "") || (select1.getText() != "") || (select2.getText() != "")
						|| (select3.getText() != "") || (select4.getText() != "") || (select5.getText() != "")
						|| (select6.getText() != "") || (select7.getText() != "") || (price1.getText() != "")) {
					String sql = "INSERT INTO estimate1 VALUES ('" + memid.getText() + "','" + select1.getText() + "','"
							+ select2.getText() + "','" + select3.getText() + "','" + select4.getText() + "','"
							+ select5.getText() + "','" + select6.getText() + "','" + select7.getText() + "','"
							+ Integer.parseInt(price1.getText()) + "')";
					System.out.println(sql);
					stmt = conn.createStatement();
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "견적서 저장 완료", "Complete", JOptionPane.PLAIN_MESSAGE);

				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	private class load implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ID = First.ID;

			try {
				Statement stmt = null;
				Connection conn;
				ResultSet rs;

				conn = Main.conn;

				String sql = "Select * from ESTIMATE1 where mem_id='" + ID + "' ";
				memid.setText(ID);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				System.out.println(sql);
				if (rs.next()) {


					String sql_select = null;
					sql_select = "select mem_id from estimate1 where mem_id='" + ID + "'";
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql_select);

					// rs.beforeFirst();

					while (rs.next()) {
						memid.setText(rs.getString(1));

					}
					// stmt.close();
					// conn.close();
				}

			} catch (Exception e1) {
				e1.printStackTrace();

			}
		}
	}

	private class Home1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			FrameManager.getInstance().showFrame("Home1");
		}
	}

	private class goPart implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			FrameManager.getInstance().showFrame("MemberFind");
		}
	}

}