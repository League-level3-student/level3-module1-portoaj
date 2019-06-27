package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		ArrayList<String> strings = new ArrayList<String>();
		//   Don't forget to import the ArrayList class

		//2. Add five Strings to your list
		strings.add("1");
		strings.add("2");
		strings.add("3");
		strings.add("4");
		strings.add("5");
		//3. Print all the Strings using a standard for-loop
		for(int i = 0; i < strings.size(); i ++)
		{
			System.out.println(strings.get(i));
		}
		
		//4. Print all the Strings using a for-each loop
		for(String str: strings)
		{
			System.out.println(str);
		}
		//5. Print only the even numbered elements in the list.
		for(int i = 0; i < strings.size(); i += 2)
		{
			System.out.println(strings.get(i));
		}
		//6. Print all the Strings in reverse order.
		for(int i = strings.size() - 1; i > 0; i --)
		{
			System.out.println(strings.get(i));
		}
		//7. Print only the Strings that have the letter 'e' in them.
		for(String str: strings)
		{
			if(str.contains("e"))
			System.out.println(str);
		}
	}
}
