package Main;

import java.awt.Color;
import java.awt.event.*;

public class Story_Script 
{
	final String[] Segment_1_Dialogue = {"I'm so mad", "So afraid", "Why me of all people?", "I understand one of us has to go", "But why me?", "Every year one of has to go", "and give up a body part to a terrible spirit", "They say those who give up something important...", "Get to walk away in one piece", "and those too cowardly or don't give up something important enough...", "receive a terrible curse", "What will I have to give up?", "Will I just get cursed anyway?", "Like some kind of sick joke"};
	final String Option_Text_1 = "Should I just go back to the village or run away?";
	final String[] Options_1 = {"Go to the spirit", "Go to the village", "Try to leave"};
	private int current_scene = 1;
	private int iterator = 0;
	private int picked_option = 1; //Should have a value of 1, 2, or 3 based on Options()
	private Main_Window main_window;
	
	public Story_Script(Main_Window main_window)
	{
		this.main_window = main_window;
		Story_Engine();
	}
	public void Story_Engine()
	{
		switch(current_scene)
		{
			case 1:
				Story(Segment_1_Dialogue);
				break;
			case 2:
				Options(Option_Text_1, Options_1);
				break;
			default:
				//The End Screen when implemented
				break;
		}
	}
	public void Story(String[] Story_Array)
	{
		iterator = 0;
		main_window.Show_Screen("NEXT_SCREEN");
		ActionListener Dialogue_Listener = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(iterator == Story_Array.length)
				{
					main_window.Next_Button.removeActionListener(this);
					current_scene++;
					Story_Engine();
				}
				else
				{
					main_window.Set_Next_Text(Story_Array[iterator]);
					iterator++;
				}
			}
		};
		main_window.Next_Button.addActionListener(Dialogue_Listener);
	}
	public void Options(String Option_Text, String[] Options_Array)
	{
		main_window.Set_Option_Text(Option_Text);
		main_window.Set_Option_Button_Names(Options_Array[0], Options_Array[1], Options_Array[2]);
		main_window.Show_Screen("OPTIONS_SCREEN");
		//Listener for main_window.First_Button
		//Listener for main_window.Second_Button
		//Listener for main_window.Third_Button
	}
	public void Show_Failed_Option()
	{
	
	}
}
