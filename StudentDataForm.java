import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class StudentDataForm {
    
	//Labels, Textfields,buttons, Table and Frame
	static JLabel rollNoLabel, nameLabel, phoneNoLabel, emailLabel;
	static JLabel rollNoErrorLabel, nameErrorLabel, phoneNoErrorLabel, emailErrorLabel;
	static JButton submitBtn;
	static JTextField rollNoTextField, nameTextField, phoneNoTextField, emailTextField;
	static JFrame frame;
	static Table jTable;
	
	//ScrollPane
	static int v = JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED;
	static int h = JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED;
	static JScrollPane tableScrollPane;
	static JScrollPane formScrollPane;
	
	// Table columns and rows
	static final String[] colheads = {"Roll No.", "Name", "Phone no.", "Email"};
	static String[][] tableData = new String[1][4];
	
	//Method to set error label text
	public static void setErrorLabelTextStatus(JLabel errorLabel, JLabel dataLabel, boolean status) {
		String msg = "";
		if(status) {
			msg = "Valid";
			errorLabel.setForeground(Color.GREEN);

		} else {
			msg = "Invalid";
			errorLabel.setForeground(Color.RED);
		}
		errorLabel.setText(msg + " " + dataLabel.getText());
	}
	
	//This method will clear all textfields and error labels
	public static void clearInputs() {
		nameTextField.setText("");
		nameErrorLabel.setText("");
		rollNoTextField.setText("");
		rollNoErrorLabel.setText("");
		emailTextField.setText("");
		emailErrorLabel.setText("");
		phoneNoTextField.setText("");
		phoneNoErrorLabel.setText("");
	}

	public static void main(String[] args) {
		
		//Frame
		frame = new Frame("Student Form");
		
		JPanel formPanel = new JPanel();

		//Icons
		ImageIcon nameIcon = new ImageIcon("images/names.png");
		ImageIcon rollIcon = new ImageIcon("images/roll.png");
		ImageIcon emailIcon = new ImageIcon("images/email.png");
		ImageIcon phoneIcon = new ImageIcon("images/phone.png");
		
		//Labels
		nameLabel = new JLabel("Name");
		nameErrorLabel = new JLabel("");

		rollNoLabel = new JLabel("Roll No");
		rollNoErrorLabel = new JLabel("");
		
		emailLabel = new JLabel("Email");
		emailErrorLabel = new JLabel("");
		
		phoneNoLabel = new JLabel("Phone No");
		phoneNoErrorLabel = new JLabel("");

		//Setting Icons
		nameLabel.setIcon(nameIcon);
		rollNoLabel.setIcon(rollIcon);
		emailLabel.setIcon(emailIcon);
		phoneNoLabel.setIcon(phoneIcon);
		
		//Textfields and events
		nameTextField = new JTextField(30);
		nameTextField.addActionListener(new MyActionEvents());
		nameTextField.addKeyListener(new MyKeyEvents());

		rollNoTextField = new NumericTextField(30);
		rollNoTextField.addActionListener(new MyActionEvents());
		rollNoTextField.addKeyListener(new MyKeyEvents());

		phoneNoTextField = new JTextField(30);
		phoneNoTextField.addActionListener(new MyActionEvents());
		phoneNoTextField.addKeyListener(new MyKeyEvents());

		emailTextField = new JTextField(30);
		emailTextField.addActionListener(new MyActionEvents());
		emailTextField.addKeyListener(new MyKeyEvents());

		//Submit button
		submitBtn = new JButton("SUBMIT");
		submitBtn.addActionListener(new MyActionEvents());

		//FileReader to get and set data
		MyFileReader filereader = new MyFileReader();
		StringBuffer data = filereader.getData();
		filereader.setData(data);

		//Table
		jTable= new Table(tableData, colheads);

		//Adding all labels, textfields and buttins in  form panel 
		formPanel.add(nameLabel);
		formPanel.add(nameTextField);
		formPanel.add(nameErrorLabel);
		formPanel.add(rollNoLabel);
		formPanel.add(rollNoTextField);
		formPanel.add(rollNoErrorLabel);
		formPanel.add(emailLabel);
		formPanel.add(emailTextField);
		formPanel.add(emailErrorLabel);
		formPanel.add(phoneNoLabel);
		formPanel.add(phoneNoTextField);		
		formPanel.add(phoneNoErrorLabel);		
		formPanel.add(submitBtn);
		formPanel.setPreferredSize(new Dimension(460, 200));
		formPanel.setBackground(Color.gray);
		
		//Scroll Pane for form panel
		formScrollPane = new JScrollPane(formPanel, v, h);

		//Scroll pane for table
		tableScrollPane = new JScrollPane(jTable, v, h);

		//Adding components into frane
		frame.add(formScrollPane, BorderLayout.NORTH);
		frame.add(tableScrollPane, BorderLayout.CENTER);
		

        //Frame's visiblity to be initialsed at the end
        frame.setVisible(true);
	}
}
