package util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class part1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String [] array = new String [] {"hA","h2","h3","h4","h5","h6","h7","h8","h9","h10","hJ","hQ","hK",
											"sA","s2","s3","s4","s5","s6","s7","s8","s9","s10","sJ","sQ","sK",
											"dA","d2","d3","d4","d5","d6","d7","d8","d9","d10","dJ","dQ","dK",
											"cA","c2","c3","c4","c5","c6","c7","c8","c9","c10","cJ","cQ","cK",
											"j1","j2"};
			List<String> arrList = Arrays.asList(array);
			//String [] randArray1 = arrList.toArray(new String[arrList.size()]);
			
				
	        File file1 = new File("/home/cloudera/Downloads/db/Assgn1/randomArray.txt");

	        try 
	        {
	            file1.createNewFile();
	            FileWriter filewriter = new FileWriter(file1.getAbsoluteFile());
	            BufferedWriter bufrwriter = new BufferedWriter(filewriter);
	            for(int i=0; i<100;i++)
	            {
	            Collections.shuffle(arrList);
				String [] randArray = arrList.toArray(new String[arrList.size()]);	
				
	            
				bufrwriter.append(java.util.Arrays.toString(randArray).replace(" ", "").replace("[", "").replace("]", "").trim()+"\n");
	            }
	            bufrwriter.close();		
			}
	        catch (IOException e) 
	        {
	            e.printStackTrace();
	        }
	}
}
