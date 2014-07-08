package Problem;

import java.util.Hashtable;

public class Node<T> {
	
	Object ch;
	Boolean endOfWord;
	Boolean haveChild;
	int counter;
	Hashtable <Object, Node<T>> listOfChildren ;
	
	Node(Character ch){
		this.ch = ch;
		listOfChildren =  new Hashtable<Object,Node<T>>();
		endOfWord=false;
		haveChild=false;
		counter=0;
	}
	
	Node(){
		this.ch = '\0';
		listOfChildren =  new Hashtable<Object,Node<T>>();
		endOfWord=false;
		haveChild=false;
		counter=0;
	}
	
	public Node<T> childExists(char ch)
	{
		return this.listOfChildren.get(ch);
	}

   public Boolean addChild(Node<T> node){
	    
	   if (this.listOfChildren.get(node.ch) ==null)
		   
		   this.listOfChildren.put(node.ch, node);
	       this.setWordCount();
	   
	   return true;
   }
   public Boolean getEndOfWord()
   {
	   return this.endOfWord;
   }
   
   
   public Boolean setEndOfWord()
   {
	   return this.endOfWord =true;
   }
   
   public int getWordCount()
   {
	   return this.counter;
   }
   public int setWordCount()
   {
	   return this.counter++;
   }
}
