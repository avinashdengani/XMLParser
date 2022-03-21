import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

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
                System.out.println("IOException caught: " +io.getMessage());		
            }
		}catch(IOException io){
			System.out.println("IOException caught: " +io.getMessage());
		}
		return completeData;
	}
}