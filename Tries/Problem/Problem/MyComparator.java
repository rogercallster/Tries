package Problem;

import java.util.Comparator;


public class MyComparator implements Comparator<String>
{
public int compare(String stringA, String stringB)
{

if (stringA.length() < stringB.length())
return 1;
else if (stringA.length() == stringB.length())
return 0;
else 
return -1;
}
}