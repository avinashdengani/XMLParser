import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyFileReader {
    
    public StringBuffer getData() {
		File dataXMLFile = new File("data.xml");
		StringBuffer completeData = new StringBuffer("");			
		try{
			BufferedReader br = new BufferedReader(new FileReader(dataXMLFile));	
			String tempData = "";
			while ((tempData = br.readLine()) != null) {				
				completeData.append(tempData.trim());
			}   
		}catch(FileNotFoundException e){
            try {
                dataXMLFile.createNewFile();
            } catch(IOException io) {
                System.out.println("IOException caught: " + io.getMessage());		
            }
		}catch(IOException io){
			System.out.println("IOException caught: " + io.getMessage());
		}
		return completeData;
	}

	void setData(StringBuffer data) {
		
		if(!data.equals("") || data.length() != 0 ) {
			
			int totalStudents = 0;
			
			String totalNumberOfStudentsRegex = "(<Student>)(.*?)(</Student>)";
			Pattern totalNumberOfStudentsPattern = Pattern.compile(totalNumberOfStudentsRegex);
			Matcher totalNumberOfStudentsMatcher = totalNumberOfStudentsPattern.matcher(data);
			
			while(totalNumberOfStudentsMatcher.find()) {
				totalStudents++;
			}

			String studentPattern = "(<Student>)(<RollNo>)(.*?)(</RollNo>)(<Name>)(.*?)(</Name>)(<Phone>)(.*?)(</Phone>)(<Email>)(.*?)(</Email>)(</Student>)";
			Pattern pattern = Pattern.compile(studentPattern);
			Matcher matcher = pattern.matcher(data);
			
			StudentDataForm.tableData = new String[totalStudents][4];
			
            System.out.println("********STUDENT DETAILS************");
			
			int i = 0;
			
			while(matcher.find()) {

				String studentRollNo = matcher.group(3); 
				String studentName = matcher.group(6);
				String studentPhoneNo = matcher.group(9);
				String studentEmail = matcher.group(12);

				System.out.println();
				System.out.println("Name: " + studentName);
				System.out.println("Roll No.: " + studentRollNo);
				System.out.println("Phone No.: " + studentPhoneNo);
				System.out.println("Email: " + studentEmail);
				System.out.println();
				
				try {
					StudentDataForm.tableData[i][0] = studentRollNo;
					StudentDataForm.tableData[i][1] = studentName;
					StudentDataForm.tableData[i][2] = studentPhoneNo;
					StudentDataForm.tableData[i][3] = studentEmail;

				} catch(ArrayIndexOutOfBoundsException aiobe) {
					aiobe.printStackTrace();
				}
				i++;
			}
		}
	}
}