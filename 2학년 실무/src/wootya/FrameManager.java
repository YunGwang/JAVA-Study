package wootya;


import java.util.HashMap;

import javax.swing.JFrame;

public class FrameManager {

	HashMap<String, JFrame> frames;
	JFrame curFrame;
	
	private FrameManager() {
		frames = new HashMap<String, JFrame>();
		
		frames.put("First",new First());
		frames.put("MemberJoin",new MemberJoin());
		frames.put("Home1", new Home1());
		frames.put("MemberFind", new PartFind());
		frames.put("MemberAdjust",new MemberAdjust());	
		frames.put("Estimate",new Estimate());	
		frames.put("ShowEstimate",new ShowEstimate());				
		curFrame = new JFrame();
		curFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		curFrame.setVisible(true);
	}
	
	private static FrameManager uInstance = null;
	
	public static FrameManager getInstance() {
		if (uInstance == null)
			uInstance = new FrameManager();
		
		return uInstance;
	}
	
	public void showFrame(String name) {
		JFrame frame = frames.get(name);
		curFrame.setContentPane(frame.getContentPane());
		curFrame.setTitle(frame.getTitle());
		curFrame.setSize(frame.getSize());
	}
}