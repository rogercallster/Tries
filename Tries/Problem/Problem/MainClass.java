package Problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 *This class Have Main method
 * 
 */


public class MainClass {
	
	public static void main(String[] str)
	
	{
		System.out.println("NOTE: ALL TIME IS IN MILLISECONDS "
				+"\n-------------------------------------------------------"
				+ "\nStating Program...\n"
				+ "Time at start is "+System.currentTimeMillis()
				+"\n-------------------------------------------------------");
		
		BufferedReader br;
		FileInputStream srcFile = null;
		String newLine;
		ArrayList<String> al = new ArrayList<String>();
		MyTree tree=new MyTree();
		try {
				srcFile = new FileInputStream(str[0]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		br = new BufferedReader(new InputStreamReader(srcFile));
		
		
		try {
			while ((newLine = br.readLine()) != null) {	 //read lines
				if (newLine!="" || newLine != null){
				al.add(newLine);
				tree.insertWord(newLine);
				}
			}
			br.close();srcFile.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("Time after file reading from disk  "+System.currentTimeMillis()
				+"\n-------------------------------------------------------");
		
		WordCombo wc =new WordCombo(al,tree);
		wc.sortCombo();
		String  biggest = wc.combo(0);//get the Element at the top of sorted List
		String  secondBiggest = wc.combo(1);//get the Element at the 2nd postion of sorted List
		int size= wc.size();//get size of combos

		System.out.println("Time of Completion "+System.currentTimeMillis()+
				"\n-------------------------------------------------------"
				+ "\n"+"Largest word formed is = "
						+ ""+biggest+"\nSecond Largest Word "
				+ "is = "+secondBiggest+"\nFinally .. total count of com"
						+ "binations are "+
				size+"\n-------------------------------------------------------");
				
				
	}

}

