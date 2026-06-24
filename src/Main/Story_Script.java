package Main;

import java.awt.event.*;

public class Story_Script 
{
	final String[] Beginning_Dialogue = {"The party of adventurers are trying to make it through a horde of monsters", "You must guide their actions"};
	int iterator = 0;
	public void Beginning_Dialogue(Main_Window main_window)
	{
		iterator = 0;
		ActionListener Dialogue_Listener = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(iterator == Beginning_Dialogue.length)
				{
					main_window.Next_Button.removeActionListener(this);
					Exploration_Script(main_window);
				}
				else
				{
					main_window.Set_Next_Text(Beginning_Dialogue[iterator]);
					iterator++;
				}
			}
		};
		main_window.Next_Button.addActionListener(Dialogue_Listener);
	}
	public void Exploration_Script(Main_Window main_window)
	{
		iterator = 0;
		System.out.println("Success");
	}
}
