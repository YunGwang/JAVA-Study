package wootya;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class Home1 extends JFrame {
	public static String ID;
	public static String PW;

	JLayeredPane LPHome;
	JPanel pHomeBackground;
	JButton bScheduling, bMake, bRequestBoard ,showEst;
	JButton logout,memsu;
	Image img;

public Home1() {
        setLayout(null);
        img = Toolkit.getDefaultToolkit().getImage("image/irene.jpg");
        LPHome = new JLayeredPane();       
        pHomeBackground = new JPanel(){      
            public void paintComponent(Graphics g){
                g.drawImage(img, 0, 0, 1000 , 800, this);
            }
        };
        

        bScheduling = new JButton("견적서 작성");
        bScheduling.addActionListener(new goEstimate());
        bScheduling.setBackground(new Color(67, 116, 217));
        bScheduling.setForeground(new Color(253,243,222));
        bScheduling.setBounds(80,200,200,150);
        bScheduling.setFont(new Font("굴림",Font.BOLD,15));
        
        showEst= new JButton("견적서 수정&삭제");
        showEst.addActionListener(new showEstimate());
        showEst.setBackground(new Color(67, 116, 217));
        showEst.setForeground(new Color(253,243,222));
        showEst.setBounds(330,200,200,150);
        showEst.setFont(new Font("굴림",Font.BOLD,13));

        logout = new JButton("로그아웃");
        logout.addActionListener(new GoFirst());
        logout.setBackground(new Color(67, 116, 217));
        logout.setForeground(new Color(253,243,222));
        logout.setBounds(140,10,100,30);
        logout.setFont(new Font("굴림",Font.BOLD,12));  
        
        memsu = new JButton("회원수정");
        memsu.setBackground(new Color(67, 116, 217));
        memsu.setForeground(new Color(253,243,222));
		memsu.addActionListener(new GoMemberAdjust());
		memsu.setBounds(10, 10, 100, 30);
		memsu.setFont(new Font("굴림", Font.BOLD, 12));


        LPHome.setLayout(null);
        LPHome.setBounds(0, 0, 1000, 800);
        pHomeBackground.setBounds(0, 0, 1000, 800);

        
        LPHome.add(pHomeBackground, new Integer(0));
        LPHome.add(bScheduling,new Integer(1));
        LPHome.add(showEst,new Integer(1));
        LPHome.add(logout,new Integer(1));
        LPHome.add(memsu, new Integer(1));
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("홈화면");
       
        setContentPane(LPHome);
        setSize(1000, 600);
    }
private class GoMemberAdjust implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        ID = First.ID;
        PW = First.PW;
        FrameManager.getInstance().showFrame("MemberAdjust");    
        }
     }

  
    private class goEstimate implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
			FrameManager.getInstance().showFrame("Estimate");
			ID = null;
	        PW = null;
		}
	}
    
    private class showEstimate implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
			FrameManager.getInstance().showFrame("ShowEstimate");
			 ID = First.ID;
		     PW = First.PW;
		}
	}
    private class GoFirst implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        ID = null;
        PW = null;
            FrameManager.getInstance().showFrame("First");
        }
     }
    
    
}