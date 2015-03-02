import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class DisplayWindow extends JFrame {
	
	private Container container;
	
	public DisplayWindow() {
		super("Display");
		container = this.getContentPane();
	}
	
	public void addPanel(JPanel panel) {
		container.add(panel);
	}
	
	public void showFrame() {
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
