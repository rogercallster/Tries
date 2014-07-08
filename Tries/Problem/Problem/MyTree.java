package Problem;

public class MyTree {//tree with each alphabet a node and branch 
	
	 Node<Character> ROOT = new Node<Character>();
	

	 public int insertWord (String s)
	 {
		 
		 Node<Character> temp = ROOT;
		 if(s.length()==0) 
			   temp.setEndOfWord();
		 	
		 	  for(int i=0;i<s.length();i++){
		 		Node<Character> next =  temp.childExists(s.charAt(i));
		 		if (next==null) //try to put data in node
		 		{
		 			next= new Node<Character>(s.charAt(i));
		 			temp.addChild(next);
		 			temp=next;
		 		}
		 		else 
		 		{
		 			temp=next;
		 			next.setWordCount();
		 		}
		 		if (i== s.length()-1)
		 		{
		 			temp.setEndOfWord();
		 		}
		 	  }
		 
		 return 0;
	 }
	

		public Boolean deleteWord(String word)
		{ 
			if(word==null)
				return true;
			else{
				Node<Character> temp=ROOT;
				for (int i =0 ; i< word.length();i++)
					temp = temp.listOfChildren.get(word.toCharArray()[i]);
				temp.endOfWord=false;
			}
			
			return false;
		}
		
	 public Boolean getWord(String word)
	 {
		 char[] arrayOfCharacters= word.toCharArray();
		 
		 Node<Character> temp= ROOT;
		 if (temp==null)
			 return false;
		 for(int i=0; i< arrayOfCharacters.length;i++)
		 {
			temp = temp.listOfChildren.get(arrayOfCharacters[i]);
			if (temp==null)
				return false;
			if (temp.endOfWord==true && i== (arrayOfCharacters.length-1))
				return true;
			 
		 }
		 
		 return false;
	 }
	
}
