import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class StudentDataForm {
    
	// static JLabel rollNoLabel, nameLabel, phoneNoLabel, emailLabel;
	
	static JLabel rollNoErrorLabel, nameErrorLabel, phoneNoErrorLabel, emailErrorLabel;
	static JButton submitBtn;
	static JTextField rollNoTextField, nameTextField, phoneNoTextField, emailTextField;
	static JFrame frame;
	static Table jTable;

	static final String[] colheads = {"Roll No.", "Name", "Phone no.", "Email"};
	static String[][] tableData = new String[1][4];
	
	static JScrollPane jsp;

	public static void main(String[] args) {
		
		//Frame
		frame = new Frame("Student Form");
		
		

        //Frame's visiblity to be initialsed at the end
        frame.setVisible(true);
	}
}
