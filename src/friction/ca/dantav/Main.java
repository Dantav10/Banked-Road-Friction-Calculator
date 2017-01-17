package friction.ca.dantav;

import javax.swing.JFrame;

public final class Main {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame(Constants.APPLET_NAME);
		frame.setSize(Constants.APPLET_DIMENSION);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FrictionPanel frictionPanel = new FrictionPanel();
		frame.add(frictionPanel);
		frame.setVisible(true);
		
		double deg = Math.tan(19.3 * Math.PI / 180);
		
		
		System.out.println(deg);
	}

}
