package Main;
import javax.swing.*;
import java.awt.*;


public class Main_Window 
{
	JFrame Main_Window;
	public Main_Window()
	{
		Main_Window = new JFrame("Test");
		Main_Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Main_Window.setSize(500, 400);
		Main_Window.setLayout(new BorderLayout());
		
		Main_Window.setVisible(true);
		
	}
}
