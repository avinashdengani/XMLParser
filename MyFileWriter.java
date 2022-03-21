import java.io.IOException;
import java.io.FileWriter;

public class MyFileWriter {
    public String convertDataToXml(String name, String rollNo, String email, String phoneNo) {		
        String xmlData = "<Student>\n\t<RollNo>"+ rollNo +"</RollNo>\n\t<Name>"+ name +"</Name>\n\t<Phone>"+ phoneNo +"</Phone>\n\t<Email>"+ email +"</Email>\n</Student>\n";
		return xmlData;
	}
    public boolean appendData(String data) {
        try {
            FileWriter appendInDataFileObj = new FileWriter("data.xml", true);
            appendInDataFileObj.write(data);
            appendInDataFileObj.close();
            return true;
        }catch (IOException e) {
           System.out.println("An error occurred.");
           e.printStackTrace();
           return false;
       }
    }
}