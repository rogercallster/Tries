package Problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

public class WordCombo {
     ArrayList<String> al;
     MyTree tree;
     ArrayList<String> sortedCombo=new ArrayList<String>();
     Hashtable<String, Boolean> ht =new Hashtable<String, Boolean>();
     
     
	public WordCombo(ArrayList<String> al, MyTree tree) {
		this.al=al;
		this.tree=tree;
	}
   
    public void  sortCombo()
    {
    	if (getCombo()!=null)
    	 Collections.sort(getCombo(),new MyComparator());
    	
    }
    
	private ArrayList<String> getCombo() {
		
		for (String word: al)
		{	
			//System.out.println(word);
			if (wordCheck(word,false) && ht.get(word)==null)
			{ 
				ht.put(word, true);
				sortedCombo.add(word);
			}
		//	System.out.println(word);
		}
		
		return sortedCombo;
	}

	private Boolean wordCheck(String word, Boolean isSub)
	{
		//System.out.println(word);
		char[] ch = word.toCharArray();
		
		String st ="";
		for (int i =0;i< ch.length;i++)
		{
			 st=st+ch[i];
			if (tree.getWord(st) && st.length()!= word.length())
			{
				String sub ="";
				for (int j =i+1; j< ch.length;j++)
				{
					sub=sub+ch[j];
				}
				if (wordCheck(sub,true))
					return true;
			}
			else if (tree.getWord(st) && isSub )  {
				return true;
			}
		}
				
				return false;
	}
	
	public String combo(int i) {// this module is key component as it will creates combos
		
	return sortedCombo.get(i);
	}


	public int size() {
		
		return sortedCombo.size();
	}

}
