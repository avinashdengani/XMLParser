import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowEvents extends WindowAdapter {

	public void windowClosing(WindowEvent we) {
		System.exit(0); //FOR CLOSING WINDOW PERMANENTLY
	}
}