package friction.ca.dantav;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public final class FrictionPanel extends JPanel {

	
	private final FrictionLabel speed;
	
	private final FrictionLabel radius;
	
	private final FrictionLabel properSpeed;
	
	private final JTextField speedText;
	
	private final JTextField radiusText;
	
	private final JTextField properSpeedText;
	
	private double friction;
		
	private final JButton button;
	
	public FrictionPanel() {
		this.setLayout(null);
		this.speed = new FrictionLabel("Speed", 20, 50);
		this.radius = new FrictionLabel("Radius", 20, 80);
		this.properSpeed = new FrictionLabel("Proper Speed", 20, 20);
		this.speedText = new JTextField();
		this.radiusText = new JTextField();
		this.properSpeedText = new JTextField();
		this.button = new JButton("Calculate");

		
		init();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		

		double friction = this.friction < 0 ? 0 : this.friction;
		
		g.setColor(Color.RED);
		g.setFont(new Font("Arial", Font.BOLD, 14));
		g.drawString("" + friction, 90, 150);
	}
	
	private final void init() {
		this.speedText.setLocation(70, 50);
		this.radiusText.setLocation(70, 80);
		this.properSpeedText.setLocation(105, 20);
		this.speedText.setSize(50, 20);
		this.radiusText.setSize(50, 20);
		this.properSpeedText.setSize(50, 20);
		this.button.setLocation(70, 110);
		this.button.setSize(70, 20);
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				calculate();
			}
			
		});
		
		this.add(button);
		this.add(speed.getLabel());
		this.add(radius.getLabel());
		this.add(properSpeed.getLabel());
		this.add(speedText);
		this.add(radiusText);
		this.add(properSpeedText);
		this.validate();
	}
	
	private void calculate() {
		
		double speed = Double.parseDouble(this.speedText.getText()) * 1000 / 3600;
		double properSpeed = Double.parseDouble(this.properSpeedText.getText()) * 1000 / 3600;
		
		int radius = Integer.parseInt(radiusText.getText());
		
		double acceleration = Math.pow(speed, 2) / radius;

		double angle = Math.toDegrees(Math.atan((Math.pow(properSpeed, 2) / (9.8 * radius))));

		
		double numerator = acceleration - (9.8 * Math.tan(angle * Math.PI / 180));
		double doniminator = 9.8 + (acceleration * Math.tan(Math.tan(angle * Math.PI / 180)));
		
		friction = numerator / doniminator;
		
		NumberFormat format = DecimalFormat.getInstance();
		
		format.setRoundingMode(RoundingMode.FLOOR);
		format.setMinimumIntegerDigits(0);
		format.setMaximumFractionDigits(2);
		
		this.friction = Double.parseDouble(format.format(friction));
		
		repaint();
		
	}
}
