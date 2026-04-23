package bgms.FileHandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
	
	public String[][] readFile(String fileName) 
	{
		
		List<String[]> rows = new ArrayList<>();
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
		    String line;
		    while ((line = br.readLine()) != null) 
		    {
		    	String[] values = line.split("; ");
		        rows.add(values);
		    }
		    
		 	br.close();
		 	
		} catch (IOException e) 
		{
		    e.printStackTrace();
		}
		
		String[][] result = new String[rows.size()][];
		for (int i = 0; i < rows.size(); i++) 
		{
			result[i] = rows.get(i);
		}
		
		return result;
	}
	
	public void appendToFile(String fileName, String[] row) 
	{
		try 
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true)); //its true so that it will append to the file instead of overwriting it
			bw.newLine();
			bw.write(String.join("; ", row));
			bw.close();
			
		} catch (IOException e) 
		{
		    e.printStackTrace();
		}
	}
	
	public void replaceLine(String fileName, String[] oldRow, String[] newRow) 
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
		    String line;
		    List<String> lines = new ArrayList<>();
		    
		    //read the file line by line and replace the line that matches oldRow with newRow, then store all lines in a list
		    while ((line = br.readLine()) != null) 
		    {
		        if (line.equals(String.join("; ", oldRow))) 
		        {
		        	if (newRow != null)
		        	{
		        		lines.add(String.join("; ", newRow));
		        	} else 
		        	{
		        		//if newRow is null, it means we want to delete the line, so we just skip adding it to the list
		        	}
		            
		        } else 
		        {
		            lines.add(line);
		        }
		    }
		    br.close();
		    
		    //write the modified lines back to the file
		    BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		    for (String l : lines) 
		    {
		        bw.write(l);
		        bw.newLine();
		    }
		    bw.close();
			
		} catch (IOException e) 
		{
		    e.printStackTrace();
		}
	}
	
	public void deleteLine(String fileName, String[] row) 
	{
		replaceLine(fileName, row, null);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
