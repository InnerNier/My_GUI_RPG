package Main;
import javax.swing.*;
import java.awt.*;


public class Main_Window 
{
	JFrame Main_Window;
	
	JPanel Next_Panel = new JPanel();
	JLabel Next_Label = new JLabel();
	JButton Next_Button = new JButton("Next");
	
	public Main_Window()
	{
		//Frame Set up
		Main_Window = new JFrame("My Video Game");
		Main_Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Main_Window.setSize(800, 600);
		Main_Window.setLayout(new BorderLayout());
		
		//Next Page Specification
		Next_Panel.setLayout(new BoxLayout(Next_Panel, BoxLayout.Y_AXIS));
		Next_Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        Next_Button.setAlignmentX(Component.CENTER_ALIGNMENT);
        Next_Panel.add(Box.createRigidArea(new Dimension(0, 100)));
		Next_Panel.add(Next_Label);
		Next_Panel.add(Box.createRigidArea(new Dimension(0, 10)));
		Next_Panel.add(Next_Button);
		
		//Initial Panel for the Frame
		Set_Next_Text("Welcome to the Game");
		Set_Next_Background(Color.BLACK);
		Add_Next_Panel();
		
		//Make it visible
		Main_Window.setVisible(true);
	}
	public void Add_Next_Panel()
	{
		Main_Window.add(Next_Panel);
	}
	public void Set_Next_Background(Color color)
	{
		Next_Panel.setBackground(color);
	}
	public void Set_Next_Text(String text)
	{
		Next_Label.setFont(new Font("Arial", Font.PLAIN, 24)); 
		Next_Label.setForeground(Color.RED);
		Next_Label.setText(text);
	}
	public void Clear_JFrame()
	{
		Main_Window.removeAll();
		Main_Window.revalidate();
        Main_Window.repaint();
	}
}
