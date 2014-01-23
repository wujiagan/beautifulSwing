package beautifulSwing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BPanel extends JPanel{
	private Image img = null;
	
	public BPanel() {
		this.setOpaque(false);
	}
	
	public BPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		this.setOpaque(false);
	}
	
	public BPanel(LayoutManager layout) {
		super(layout);
		this.setOpaque(false);
	}
	
	public BPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		this.setOpaque(false);
	}
	
	/**
	 * 设置背景图
	 * @param g
	 */
	private void paintBackgroundImage(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		int width = getWidth();
		int height = getHeight();
		try {
			img = ImageIO.read(getClass().getResource("/beautifulSwing/images/bpanel.jpg"));
		} catch (Exception e) {
		}    
		if(img != null)
			g2.drawImage(img, 0, 0, width, height, this);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		paintBackgroundImage(g);   
	}
	
	public static void main(String arg[]) {
		JFrame app = new JFrame("test");
		app.setSize(900, 600);
		app.add(new BPanel());
		app.setVisible(true);
	}
}
