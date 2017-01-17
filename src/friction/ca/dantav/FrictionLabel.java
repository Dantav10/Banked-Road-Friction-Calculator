package friction.ca.dantav;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

public final class FrictionLabel {

	private final String name;
	
	private final int x;
	
	private final int y;
	
	private final JLabel label;
	
	public FrictionLabel(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
		
		this.label = new JLabel(name);
		this.label.setVisible(true);

		this.label.setSize(name.length() * 8, 20);
		this.label.setLocation(x, y);
	}
	
	public JLabel getLabel() {
		return label;
	}
	
	public String getName() {
		return name;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
