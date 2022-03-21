import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Frame extends JFrame {
	public Frame(String title) {
		super(title);
		setSize(1500, 600);
		setLayout(new BorderLayout(10, 10));
		// setLocationRelativeTo(null);
		addWindowListener(new WindowEvents());
	}
}
