import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyActionEvents implements ActionListener{
    public void actionPerformed(ActionEvent ae) {
		
		//Submit button event
		if(ae.getActionCommand() == StudentDataForm.submitBtn.getActionCommand()){
			if(new Validator().checkForValidations(ae)) {

				MyFileWriter dataAppender = new MyFileWriter();
				dataAppender.appendData(dataAppender.convertDataToXml(StudentDataForm.nameTextField.getText(), StudentDataForm.rollNoTextField.getText(), StudentDataForm.emailTextField.getText(), StudentDataForm.phoneNoTextField.getText()));

				new MyFileReader().setData(new MyFileReader().getData());
				StudentDataForm.jTable = new Table(StudentDataForm.tableData, StudentDataForm.colheads);    			
				StudentDataForm.tableScrollPane.setViewportView(StudentDataForm.jTable);

				//Clearing Inputs
				StudentDataForm.clearInputs();
			}
		}
	}
}
