package program;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVWriter;

public class ProgramCoreJava
{
	
	
	public static void main(String[] args)   
		{  
		String line = "";  
		try   
		{  
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter the file path to read: e.g: //D:/temp/test.csv");
		String path=sc.nextLine();	
		//parsing a CSV file into BufferedReader class constructor  
		BufferedReader br = new BufferedReader(new FileReader(path)); 
		Double range;
	
		List symbol=new LinkedList<>();
		List rangeN=new LinkedList<>();
	
		int count=0;
		
			while ((line = br.readLine()) != null)   //returns a Boolean value  
			{  
			
				 if(count>0)
				 { 
					String[] employee = line.split(",");    // use comma as separator
					
					range= Double.parseDouble(employee[3])- Double.parseDouble(employee[4]);
					
					symbol.add(employee[0]);
					rangeN.add(range);
				 }
				 
				 count++;
				
			} 
			
			//write file
			 writefile(symbol,rangeN);
		}   
		catch (IOException e)   
		{  
		  e.printStackTrace();  
		}  
	}
	
	static int count=0;
	public static void writefile(List symbol,List rangeN)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter the file path to write: e.g: //D:/temp/output.csv");
		String path=sc.nextLine();	
		
		// File input path
        System.out.println("Starting....");
        File file = new File(path);          //D:/temp/output.csv
        try {
            FileWriter result = new FileWriter(file);
            CSVWriter write = new CSVWriter(result);

            // Header column value
              String[] header = { "Symbol", "Range" };
               write.writeNext(header);
           
            for(int i=0;i<symbol.size();i++)
            {
            	String[] data1 = {symbol.get(i).toString(),rangeN.get(i).toString()}; 
                write.writeNext(data1);
            }
            
            write.close();
        } catch (Exception e) {
            e.printStackTrace();

        }

        System.out.println("End.");
	
	
	}

		
}
