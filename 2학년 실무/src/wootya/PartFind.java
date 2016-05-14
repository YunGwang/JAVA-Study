package wootya;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PartFind extends JFrame {
   final static int x = 30;
   JLayeredPane LP;
   JPanel pBackGround;
   JLabel lTitle;
   JTextField tfSearch;
   JButton bSearch, bHome;
   JButton RAM, CPU, VGA, HDD, CASE, MBoard, POWER;
   JTable tMember;
   DefaultTableModel tMemberModel;
   Image img;
   Choice cIndex;
   String[][] data;
   String b = "";
   String c = "";
   Statement stmt = null;
   Connection conn;

   // boolean Many = true; // 포인트 많고 적음
   // boolean High = true; // 회원등급 높고 낮음
   boolean Fast = true; // 생년월일 빠름 느림

   public void DispClear() {
      tfSearch.setText("");
   }

   public PartFind() {
      setLayout(null);
      img = Toolkit.getDefaultToolkit().getImage("tv2.jpg");
      LP = new JLayeredPane();

      pBackGround = new JPanel() {
         public void paintComponent(Graphics g) {
            g.drawImage(img, 0, 0, 1000, 800, this);
         }
      };
      lTitle = new JLabel("부품 조회");
      lTitle.setFont(new Font("굴림", Font.BOLD, 20));
      bSearch = new JButton("조회");
      bSearch.setBackground(new Color(67, 116, 217));
      bSearch.setForeground(new Color(253, 243, 222));
      bSearch.addActionListener(new memberSearch());
      bHome = new JButton("뒤로가기");
      bHome.setBackground(new Color(67, 116, 217));
      bHome.setForeground(new Color(253, 243, 222));
      bHome.addActionListener(new goHome());

      RAM = new JButton("RAM");
      RAM.addActionListener(new OrderSelect());
      CPU = new JButton("CPU");
      CPU.addActionListener(new OrderSelect());
      VGA = new JButton("VGA");
      VGA.addActionListener(new OrderSelect());
      HDD = new JButton("HDD");
      HDD.addActionListener(new OrderSelect());
      CASE = new JButton("CASE");
      CASE.addActionListener(new OrderSelect());
      POWER = new JButton("POWER");
      POWER.addActionListener(new OrderSelect());
      MBoard = new JButton("MBoard");
      MBoard.addActionListener(new OrderSelect());

      cIndex = new Choice();
      cIndex.add("전체조회");
      cIndex.add("부품명");
      // cIndex.add("회원등급");

      tfSearch = new JTextField();


      // bPoint.setBackground(new Color(245, 235, 210));
      // bGrade.setBackground(new Color(245, 235, 210));
      RAM.setBackground(new Color(67, 116, 217));
      RAM.setForeground(new Color(253, 243, 222));
      CPU.setBackground(new Color(67, 116, 217));
      CPU.setForeground(new Color(253, 243, 222));
      VGA.setBackground(new Color(67, 116, 217));
      VGA.setForeground(new Color(253, 243, 222));
      HDD.setBackground(new Color(67, 116, 217));
      HDD.setForeground(new Color(253, 243, 222));
      CASE.setBackground(new Color(67, 116, 217));
      CASE.setForeground(new Color(253, 243, 222));
      POWER.setBackground(new Color(67, 116, 217));
      POWER.setForeground(new Color(253, 243, 222));
      MBoard.setBackground(new Color(67, 116, 217));
      MBoard.setForeground(new Color(253, 243, 222));
   

      bSearch.setForeground(new Color(253, 243, 222));
      bSearch.setBackground(new Color(67, 116, 217));
      bHome.setForeground(new Color(253, 243, 222));
      bHome.setBackground(new Color(67, 116, 217));

      tMemberModel = new DefaultTableModel() {
         public boolean isCellEditable(int i, int c) {
            return false;
         }
      };
      tMember = new JTable(tMemberModel);
      tMember.addMouseListener(new JtableMouseListner());
      tMember.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      tMember.getTableHeader().setReorderingAllowed(false); // 헤더고정
      tMember.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);

      tMemberModel.addColumn("부품명");
      tMemberModel.addColumn("A/S기간");
      tMemberModel.addColumn("가격");
      tMemberModel.addColumn("상세설명");
      tMemberModel.addColumn("제조사");

      JScrollPane scroll = new JScrollPane(tMember);
      tMember.setOpaque(false);
      scroll.setOpaque(false);
      tMember.getColumnModel().getColumn(0).setPreferredWidth(200);
      tMember.getColumnModel().getColumn(1).setPreferredWidth(70);
      tMember.getColumnModel().getColumn(2).setPreferredWidth(60);
      tMember.getColumnModel().getColumn(3).setPreferredWidth(452);
      tMember.getColumnModel().getColumn(4).setPreferredWidth(75);

      LP.setLayout(null);
      LP.setBounds(0, 0, 1000, 700);
      pBackGround.setBounds(0, 0, 1000, 700);
      lTitle.setBounds(430, 40, 200, 25);
      cIndex.setBounds(175, 102, 100, 25);
      tfSearch.setBounds(300, 100, 370, 25);
      bSearch.setBounds(700, 100, 100, 25);
      bHome.setBounds(820, 100, 100, 25);
      tMember.setBounds(70, 170, 860, 370);
      scroll.setBounds(70, 170, 860, 370);

      CPU.setBounds(x + 100, 135, 100, 25);
      VGA.setBounds(x + 200, 135, 100, 25);
      // bPoint.setBounds(x+405, 135, 100, 25);
      // bGrade.setBounds(x+520, 135, 100, 25);
      RAM.setBounds(x + 300, 135, 100, 25);
      HDD.setBounds(x + 400, 135, 100, 25);
      CASE.setBounds(x + 500, 135, 100, 25);
      POWER.setBounds(x + 600, 135, 100, 25);
      MBoard.setBounds(x + 700, 135, 100, 25);

      LP.add(pBackGround, new Integer(0));
      LP.add(lTitle, new Integer(1));
      LP.add(tfSearch, new Integer(1));
      LP.add(bSearch, new Integer(1));
      LP.add(bHome, new Integer(1));
      LP.add(scroll, new Integer(1));
      // LP.add(bPoint, new Integer(1));
      // LP.add(bGrade, new Integer(1));
      LP.add(RAM, new Integer(1));
      LP.add(CPU, new Integer(1));
      LP.add(VGA, new Integer(1));
      LP.add(HDD, new Integer(1));
      LP.add(CASE, new Integer(1));
      LP.add(POWER, new Integer(1));
      LP.add(MBoard, new Integer(1));
      LP.add(cIndex, new Integer(1));

      tMember.getSelectedRow();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      setTitle("부품조회");
      setContentPane(LP);
      setSize(1000, 600);
   }

   private class memberSearch implements ActionListener {
      public void actionPerformed(ActionEvent e) {

         // ResultSet rs = null;

         try {
            conn = Main.conn;

            String EColumnTemp = (String) cIndex.getSelectedItem();
            String EColumn = null;

            String sql_select = null;
            if (EColumnTemp == "부품명") {
               EColumn = "prt_name";
               sql_select = "Select prt_name, prt_as, prt_price, prt_text , com_code from part join where "
                     + EColumn + "='" + tfSearch.getText() + "' order by prt_name";
            }
      

            for (int cnt = tMemberModel.getRowCount(); cnt > 0; cnt--)
               tMemberModel.removeRow(0);

            if (EColumnTemp == "전체조회")
               sql_select = "Select prt_code,prt_name,prt_as,prt_price,prt_text,grp_code ,com_code from PART";

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(sql_select);

            if (rs.next()) {
               int cnt = 0;
               while (rs.next()) {
                  cnt++;
                  System.out.println(cnt);
               }
               rs.last();
               rs.beforeFirst();

               data = new String[cnt][5];

               while (rs.next()) {
                  String col[] = new String[5];
                  col[0] = rs.getString("prt_name");
                  col[1] = rs.getString("prt_as");
                  col[2] = rs.getString("prt_price");
                  col[3] = rs.getString("prt_text");
                  col[4] = rs.getString("com_name");

                  // System.out.println("aaaa");
                  // System.out.println(col);
                  tMemberModel.addRow(col);
               }

               DispClear();
               JOptionPane.showMessageDialog(null, "       [ " + cIndex.getSelectedItem() + " ] 조회 완료", "회원조회",
                     JOptionPane.PLAIN_MESSAGE);

            } else {
               JOptionPane.showMessageDialog(null, "적절하지 못한 검색입니다. 다시 입력하세요.", "회원조회", JOptionPane.PLAIN_MESSAGE);
            }
         } catch (SQLException ex) {
            ex.printStackTrace();
         }
      }
   }

   static String z = "";
   static String cp = "";
   static String vg = "";
   static String ra = "";
   static String hdd = "";
   static String ca = "";
   static String pw = "";
   static String mb = "";
   static String zp = "";
   static String cpp = "";
   static String vgp = "";
   static String rap = "";
   static String hddp = "";
   static String cap = "";
   static String pwp = "";
   static String mbp = "";
   static int mbc = 0;
   static int cpc = 0;

   private class JtableMouseListner implements MouseListener {

      @Override
      public void mouseClicked(MouseEvent e) {
         // TODO Auto-generated method stub
         JTable jt = (JTable) e.getSource();
         int row = jt.getSelectedRow();
         int col = jt.getSelectedColumn();

         
         tfSearch.setText("" + tMemberModel.getValueAt(row, col));
         ;
         
         
         
         int a = Integer.parseInt((String) b);
         int d = Integer.parseInt((String) cou[row]);
         System.out.println(""+a+""+d);
         if(e.getClickCount()==2){
            JOptionPane.showMessageDialog(null,""+tMemberModel.getValueAt(row, 0)+"선택 되었습니다.");
            if(a == 1){
                cp = (String) (tMemberModel.getValueAt(row, 0));
                cpp = (String) (tMemberModel.getValueAt(row, 2));
                cpc = d;
                }
            if(a == 2){
                ra = (String) (tMemberModel.getValueAt(row, 0));
                rap = (String) (tMemberModel.getValueAt(row, 2));
                }
            if(a == 3){
                mb = (String) (tMemberModel.getValueAt(row, 0));
                mbp = (String) (tMemberModel.getValueAt(row, 2));
                mbc = d;
                }
            if(a == 4){
                vg = (String) (tMemberModel.getValueAt(row, 0));
                vgp = (String) (tMemberModel.getValueAt(row, 2));
                }
            if(a == 5){
                hdd = (String) (tMemberModel.getValueAt(row, 0));
                hddp = (String) (tMemberModel.getValueAt(row, 2));
                }
            if(a == 6){
                ca = (String) (tMemberModel.getValueAt(row, 0));
                cap = (String) (tMemberModel.getValueAt(row, 2));
                }
            if(a == 7){
                pw = (String) (tMemberModel.getValueAt(row, 0));
                pwp = (String) (tMemberModel.getValueAt(row, 2));
                }
         }
      }

      @Override
      public void mouseEntered(MouseEvent e) {
         // TODO Auto-generated method stub

      }

      @Override
      public void mouseExited(MouseEvent e) {
         // TODO Auto-generated method stub

      }

      @Override
      public void mousePressed(MouseEvent e) {
         // TODO Auto-generated method stub

      }

      @Override
      public void mouseReleased(MouseEvent e) {
         // TODO Auto-generated method stub

      }
   }

   private class goHome implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         FrameManager.getInstance().showFrame("Estimate");
      }
   }
   
   
   String cou[] = new String[10];
   
   private class OrderSelect implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         Object obj = e.getSource();

         ResultSet rs = null;

         try {

            conn = Main.conn;

            for (int cnt = tMemberModel.getRowCount(); cnt > 0; cnt--)
               tMemberModel.removeRow(0);

            String sql = null;

            if (obj == CPU) {
               sql = "select prt_name, prt_as, prt_price, prt_text , com_name ,grp_code, cpt_code from part,  company where part.com_CODE = company.com_code AND part.GRP_CODE='1'";
            }
            if (obj == VGA) {
               sql = "select prt_name, prt_as, prt_price, prt_text , com_name ,grp_code, cpt_code from part,  company where part.com_CODE = company.com_code AND part.GRP_CODE='4'";
            }
            if (obj == RAM) {
               sql = "select prt_name, prt_as, prt_price, prt_text , com_name ,grp_code, cpt_code from part,  company where part.com_CODE = company.com_code AND part.GRP_CODE='2'";
            }
            if (obj == HDD) {
               sql = "select prt_name, prt_as, prt_price, prt_text , com_name ,grp_code, cpt_code from part,  company where part.com_CODE = company.com_code AND part.GRP_CODE='5'";
            }
            if (obj == POWER) {
               sql = "select prt_name, prt_as, prt_price, prt_text , com_name ,grp_code, cpt_code from part,  company where part.com_CODE = company.com_code AND part.GRP_CODE='7'";
            }
            if (obj == CASE) {
               sql = "select prt_name, prt_as, prt_price, prt_text , com_name ,grp_code, cpt_code from part,  company where part.com_CODE = company.com_code AND part.GRP_CODE='6'";
            }
            if (obj == MBoard) {
               sql = "select prt_name, prt_as, prt_price, prt_text , com_name ,grp_code, cpt_code from part,  company where part.com_CODE = company.com_code AND part.GRP_CODE='3'";
            }

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sql);
            
            if (rs.next()) {
               System.out.println("조회 완료");
               System.out.println("sql_select");

               int cnt = 0;
               while (rs.next())
                  cnt++;
               rs.last();
               rs.beforeFirst();
               
               int a = 0;
               data = new String[cnt][5];
               while (rs.next()) {
                  String coa[] = new String[cnt+1];
                  String col[] = new String[5];
                 
                  col[0] = rs.getString("prt_name");
                  col[1] = rs.getString("prt_as");
                  col[2] = rs.getString("prt_price");
                  col[3] = rs.getString("prt_text");
                  col[4] = rs.getString("com_name");
                  coa[a] = rs.getString("grp_code");
                  cou[a] = rs.getString("cpt_code");
                  c = cou[cnt];
                  b = coa[cnt];
                  
                  tMemberModel.addRow(col);
                  a ++;
                  
                  

               }
               a = 0;
               DispClear();
            }
         } catch (SQLException ex) {
            ex.printStackTrace();
         }
      }
   }

}