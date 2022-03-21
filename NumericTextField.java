import javax.swing.JTextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class NumericTextField extends JTextField implements KeyListener{
	public NumericTextField() {
		super();
		addKeyListener(this);
	}

	public NumericTextField(int cols) {
		super(cols);
		addKeyListener(this);
	}

	public NumericTextField(String defaultStr) {
		super(defaultStr);
		addKeyListener(this);
	}

	public NumericTextField(String defaultStr, int cols) {
		super(defaultStr, cols);
		addKeyListener(this);
	}
	
	public void keyTyped(KeyEvent ke) {
     	isNumeric(ke); 	
    }
	public void keyReleased(KeyEvent ke) {}
	
	public void keyPressed(KeyEvent ke) {
		// isNumeric(ke);
	}

	private void isNumeric(KeyEvent ke) {
		char c = ke.getKeyChar();
      	if (! ((c >= KeyEvent.VK_0) && (c <= KeyEvent.VK_9) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER)) ) {
        	ke.consume();
      	}
	}
}