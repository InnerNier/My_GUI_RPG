package Main;

public class Main 
{
	public static void main(String[] args)
	{
		Main_Window main_window = new Main_Window();
		Story_Script story_script = new Story_Script();
		story_script.Beginning_Dialogue(main_window);
	}
}
