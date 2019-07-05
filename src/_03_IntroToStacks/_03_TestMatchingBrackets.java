package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		char [] chars = b.toCharArray();
		Stack<Character> charStack = new Stack<Character>();
		

		for(int i = 0; i < chars.length; i++)
		{
			if(chars[i] == '}')
			{
				if(charStack.empty())
					return false;
				else
				{
					charStack.pop();
				}
			}
			else
			{
				charStack.push('{');
			}
		}
		
		return charStack.empty();
	}
	

}