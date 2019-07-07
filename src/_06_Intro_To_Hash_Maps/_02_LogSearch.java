package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.*;

public class _02_LogSearch extends JPanel implements ActionListener{
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	public static void main(String[] args) {
		_02_LogSearch instance = new _02_LogSearch();
	}
	HashMap<Integer, String> people = new HashMap<Integer, String>();
	JFrame frame = new JFrame();
	JPanel panel = this;
	JButton AddEntryButton = new JButton("Add Entry");
	JButton SearchButton = new JButton("Search for name");
	JButton ViewButton = new JButton("View IDs and names");
	JButton DeleteButton = new JButton("Delete Entry");
	public _02_LogSearch()
	{
		AddEntryButton.addActionListener(this);
		AddEntryButton.setActionCommand("Add Entry");
		ViewButton.addActionListener(this);
		ViewButton.setActionCommand("View Entries");
		SearchButton.addActionListener(this);
		SearchButton.setActionCommand("Search for name");
		DeleteButton.addActionListener(this);
		DeleteButton.setActionCommand("Delete Entry");
		frame.add(panel);
		panel.add(AddEntryButton);
		panel.add(SearchButton);
		panel.add(ViewButton);
		panel.add(DeleteButton);
		frame.pack();
		frame.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "Add Entry")
		{
			int id = Integer.parseInt(JOptionPane.showInputDialog(frame, "Whats your id?"));
			String name = JOptionPane.showInputDialog(frame, "Whats your name?");
			people.put(id, name);
		}
		else if(e.getActionCommand() == "Search for name")
		{
			int id = Integer.parseInt(JOptionPane.showInputDialog(frame, "Whats your ID?"));
			JOptionPane.showMessageDialog(frame, "The assosciated name for id " + id + " is " + people.get(id));
		}
		else if(e.getActionCommand() == "View Entries")
		{
			ArrayList<String> entries = new ArrayList<String>();
			for(Entry<Integer, String> pair : people.entrySet())
			{
				entries.add("ID: " + pair.getKey() + " Name: " + pair.getValue());
			}
			JOptionPane.showMessageDialog(frame, entries.toArray());
		}
		else if(e.getActionCommand() == "Delete Entry")
		{
			int id = Integer.parseInt(JOptionPane.showInputDialog(frame, "Which ID?"));
			people.remove(id);
		}
	}
}
