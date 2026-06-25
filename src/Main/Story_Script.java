package Main;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class Story_Script 
{
	final String[] Beginning_Dialogue = {"The party of adventurers are trying to make it through a horde of monsters", "You must guide their actions"};
	final String[] Monster_Dialogue = {"Werewolf appears", "Wraith appears", "Giant appears"};
	int iterator = 0;
	private Color Color;
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
					main_window.Set_Next_Text("Charge on!");
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
		main_window.Set_Next_Background(Color.RED);
		ActionListener Dialogue_2_Listener = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(iterator == Monster_Dialogue.length)
				{
					main_window.Next_Button.removeActionListener(this);
					System.out.println("Success");
				}
				else
				{
					main_window.Set_Next_Text(Monster_Dialogue[iterator]);
					iterator++;
				}
			}
		};
		main_window.Next_Button.addActionListener(Dialogue_2_Listener);
	}
}
