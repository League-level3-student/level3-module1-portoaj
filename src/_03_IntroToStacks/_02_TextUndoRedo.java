package _03_IntroToStacks;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.*;

public class _02_TextUndoRedo extends JPanel implements KeyListener{
	StringBuilder sb;
	JFrame frame;
	JPanel panel;
	JLabel label;
	Stack<Character> undoStack = new Stack<Character>();
	public static void main(String[] args) {
		_02_TextUndoRedo instance = new _02_TextUndoRedo();
		
	}
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	public _02_TextUndoRedo()
	{	
		sb = new StringBuilder("Test: ");
		frame = new JFrame("Console Frame");
		panel = this;
		label = new JLabel("test");
		frame.add(panel);
		frame.addKeyListener(this);
		panel.add(label);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	void updateLabel()
	{
		label.setText(sb.toString());
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() != KeyEvent.VK_BACK_SPACE && e.getKeyCode() != KeyEvent.VK_BACK_SLASH)
		{
			sb.append(e.getKeyChar());
		}
		else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
		{
			undoStack.push(sb.charAt(sb.length() -1));
			if (sb.length() > 0) {
				sb.setLength(sb.length() - 1);
			}
			System.out.println(sb.length());
		}
		else if(e.getKeyCode() == KeyEvent.VK_BACK_SLASH)
		{
			char poppedChar = undoStack.pop();
			sb.append(poppedChar);
		}
		updateLabel();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
