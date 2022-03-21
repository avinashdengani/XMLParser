import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class MyKeyEvents extends KeyAdapter {
    
    public void keyReleased(KeyEvent ke) {
        new Validator().checkForValidations(ke);
    }
}
