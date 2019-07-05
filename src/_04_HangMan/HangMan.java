package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.*;

public class HangMan extends JPanel implements KeyListener{
	JFrame frame;
	JPanel panel;
	JLabel title;
	JLabel wordLabel;
	JLabel livesLabel;
	int livesLeft = 3;
	Stack<String> words;
	StringBuilder word;
	String wordAnswer;
	public static void main(String[] args) {
		HangMan instance = new HangMan();
	}
	public HangMan()
	{
		//Initialize StringBuilder
		word = new StringBuilder();
		//Construct UI
		frame = new JFrame("Hangman frame");
		panel = this;
		title = new JLabel("Hangman");
		wordLabel = new JLabel("wordhere");
		livesLabel = new JLabel("Words: " + livesLeft);
		frame.add(panel);
		panel.add(title);
		panel.add(wordLabel);
		panel.add(livesLabel);
		frame.addKeyListener(this);
		frame.pack();
		frame.setVisible(true);
		//Get the necessary amount of words
		int wordCount = Integer.parseInt(JOptionPane.showInputDialog("How many words would you like to play with?"));
		//Make a stack and add the appropriate amount of words
		words = new Stack<String>();
		for(int i = 0; i < wordCount; i++)
		{
			words.push(Utilities.readRandomLineFromFile("dictionary.txt"));
			System.out.println(words.peek());
		}
		nextWord();
	}
	void nextWord()
	{
		if(words.size() > 0)
		{
			wordAnswer = words.pop();
			//Clear StringBuilder
			word.setLength(0);
			//Add the placeholder _s
			for(int i = 0; i < wordAnswer.length(); i++)
			{
				word.append('_');
			}
			updateFrame();
		}
		else
		{
			reset();
		}
	}
	void reset()
	{
		//Check if they want to reset
		String response = JOptionPane.showInputDialog("Do you want to play again?  Type 'yes' if so.");
		System.out.println(response.toUpperCase() == "YES");
		if(response.equalsIgnoreCase("YES"))
		{
			System.out.println("yes");
			frame.dispose();
			main(new String[0]);
		}
		else
		{
			System.exit(0);
		}
	}
	void updateFrame()
	{	
		wordLabel.setText(word.toString());
		livesLabel.setText("Lives Left: " + livesLeft);
		frame.pack();
	}
	Boolean wordFound()
	{
		for(int i = 0; i < word.length(); i++)
		{
			if(word.charAt(i) == '_')
				return false;
		}
		return true;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(wordAnswer.contains(String.valueOf(e.getKeyChar())))
		{
			for(int i = 0; i < wordAnswer.length(); i++)
			{
				if(wordAnswer.charAt(i) == e.getKeyChar())
					word.replace(i, i + 1, String.valueOf(wordAnswer.charAt(i)));
			}
			updateFrame();
			if(wordFound())
			{
				nextWord();
			}
		}
		else
		{
			livesLeft--;
			updateFrame();
			if(livesLeft <= 0)
				reset();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
