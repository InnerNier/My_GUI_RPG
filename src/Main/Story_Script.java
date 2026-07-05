package Main;

import java.awt.event.*;

import javax.swing.JButton;

public class Story_Script 
{
	//variables that are just the story text and options for player
	final String[] Segment_1_Dialogue = {"Welcome to the Monster Slayer Adventure", "You are a mercenary hired to slay a werewolf", "You sharpened your silver swords and took off toward the beast's lair", "One mistake could cost you your life", "You recall it has excellent senses, deadly claws, and a fearsome bite", "The lair is a narrow and compact dark cave pretty deep in the forest", "There's also other wildlife you'd rather not have to deal with, especially during the pitch black of night", "You are currently following the main road in the midday sun", "You think it's highly likely the beast will remain for some time", "After walking for some time, you run into a merchant with a grin on his face", "He seems to not be in pain, but has some blood on his clothes", "You cannot see his hands either"};
	final String Option_Text_1 = "What should you do?";
	final String[] Options_1 = {"Walk up and greet him", "Keep your distance and move along", "Draw your steel sword"};
	final String Options_1_Failed_Scenario_1 = "After carelessly approaching the sketchy merchant, he snuck attacked you with a small hand axe";
	final String Options_1_Failed_Scenario_2 = "After trying to mind your own business, the sketchy merchant chased and killed you with a small hand axe";
	final String[] Segment_2_Dialogue = {"After drawing your steel blade, the merchant tried to charge you with a small hand axe", "Fortunately, you reacted in time and sent your sword straight through his chest", "The man was likely a bandit, but he won't be hurting anyone else now", "You took what you could and proceeded towards your objective", "You arrived at the cave and pondered the best way to approach this", "You could always just head straight on, but you recall you still have some meat from lunch on you", "You could leave it out and hope it draws the werewolf out into an open and bright space", "The meat should have a strong enough scent, but you might invite more than just your prey", "You can also just rest till Night for the beast to make its way out"};
	final String Option_Text_2 = "How do you wanna approach your prey?";
	final String[] Options_2 = {"Set out the rest of your lunch as bait", "Wait till Nightfall", "Proceed in the cave"};
	final String Options_2_Failed_Scenario_1 = "The bait you laid out ended up attracting a pack of wolves who quickly surrounded and overwhelmed you";
	final String Options_2_Failed_Scenario_2 = "You waited for nightfall and made the unfortunate realization you will be in a pitch black forest and not have the advantage against your approaching opponent";
	final String[] Segment_3_Dialogue = {"You decided the best option was to get the drop on your prey in its own lair", "The cave is quite narrow and you doubt you will be able to use any large weapons in here", "The conditions are not ideal, but your contract is still doable", "Contrary to popular belief werewolves do not need it to be night to transform", "Even at rest, you think it's highly probable it's still in its beast form ready to pounce at the slightest misstep", "After proceeding further in, you spot the beast", "Black fur, very wolf-like, about the size of a small bear", "and most important of all, it is sleeping", "You could try to kill it stealthly with your silver dagger", "You could also charge it using one of your silver swords"};
	final String Option_Text_3 = "How should you proceed?";
	final String[] Options_3 = {"Charge with short silver sword", "Charge with long silver sword", "Creep up on it with a silver dagger"};
	
	
	//important variables that are not the story
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
			case 3:
				if(picked_option == 1)
				{
					Show_Failed_Option(Options_1_Failed_Scenario_1);
				}
				else if(picked_option == 2)
				{
					Show_Failed_Option(Options_1_Failed_Scenario_2);
				}
				else
				{
					Story(Segment_2_Dialogue);
				}
				break;
			case 4:
				Options(Option_Text_2, Options_2);
				break;
			case 5:
				if(picked_option == 1)
				{
					Show_Failed_Option(Options_2_Failed_Scenario_1);
				}
				else if(picked_option == 2)
				{
					Show_Failed_Option(Options_2_Failed_Scenario_2);
				}
				else
				{
					Story(Segment_3_Dialogue);
				}
				break;
			case 6:
				Options(Option_Text_3, Options_3);
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
		main_window.Set_Next_Text(Story_Array[0]);
		iterator++;
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
		ActionListener listener = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JButton clickedButton = (JButton) e.getSource();
				main_window.First_Button.removeActionListener(this);
				main_window.Second_Button.removeActionListener(this);
				main_window.Third_Button.removeActionListener(this);
				current_scene++;
				if(clickedButton.getText().equals(Options_Array[0]))
				{
					picked_option = 1;
				}
				else if(clickedButton.getText().equals(Options_Array[1]))
				{
					picked_option = 2;
				}
				else
				{
					picked_option = 3;
				}
				Story_Engine();
			}
		};
		main_window.First_Button.addActionListener(listener);
		main_window.Second_Button.addActionListener(listener);
		main_window.Third_Button.addActionListener(listener);
	}
	public void Show_Failed_Option(String Failed_Text)
	{
		main_window.Set_Next_Text(Failed_Text);
		main_window.Show_Screen("NEXT_SCREEN");
		ActionListener Dialogue_Listener = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		};
		main_window.Next_Button.setText("Game Over");
		main_window.Next_Button.addActionListener(Dialogue_Listener);
	}
}
