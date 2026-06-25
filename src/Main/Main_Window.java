package Main;
import javax.swing.*;
import java.awt.*;


public class Main_Window 
{
	JFrame Main_Window;
	final Font gameFont = new Font("Arial", Font.PLAIN, 24);
	
	CardLayout cardlayout = new CardLayout();
	JPanel cardPanel = new JPanel(cardlayout);
	
	JPanel Next_Panel = new JPanel();
	JLabel Next_Label = new JLabel();
	JButton Next_Button = new JButton("Next");
	
	JPanel Options_Panel = new JPanel();
	JLabel Options_Label = new JLabel();
	JButton First_Button = new JButton("Default 1");
	JButton Second_Button = new JButton("Default 2");
	JButton Third_Button = new JButton("Default 3");
	
	public Main_Window()
	{
		//Frame Set up
		Main_Window = new JFrame("Simple Visual Novel");
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
		
		
		
		//Options Page Specification
		Options_Panel.setLayout(new BoxLayout(Options_Panel, BoxLayout.Y_AXIS));
		Options_Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        First_Button.setAlignmentX(Component.CENTER_ALIGNMENT);
        Second_Button.setAlignmentX(Component.CENTER_ALIGNMENT);
        Third_Button.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        Options_Panel.add(Box.createRigidArea(new Dimension(0, 100)));
        Options_Panel.add(Options_Label);
        Options_Panel.add(Box.createRigidArea(new Dimension(0, 10)));
        Options_Panel.add(First_Button);
        Options_Panel.add(Box.createRigidArea(new Dimension(0, 10)));
        Options_Panel.add(Second_Button);
        Options_Panel.add(Box.createRigidArea(new Dimension(0, 10)));
        Options_Panel.add(Third_Button);
        

        
        //Add Panels to card layout and add to Frame
        cardPanel.add(Next_Panel, "NEXT_SCREEN");
        cardPanel.add(Options_Panel, "OPTIONS_SCREEN");
        
        Main_Window.add(cardPanel);
		
        
        
		//Initial Panel
		Set_Next_Text("Welcome to the Game");
		Set_Next_Background(Color.BLACK);
		Show_Screen("NEXT_SCREEN");
		
		Set_Option_Background(Color.BLACK);
     
		
		
		//Make it visible
		Main_Window.setVisible(true);
	}
	public void Show_Screen(String screen)
	{
		cardlayout.show(cardPanel, screen);
	}
	
	//Next Page functions
	public void Set_Next_Background(Color color)
	{
		Next_Panel.setBackground(color);
	}
	public void Set_Next_Text(String text)
	{
		Next_Label.setFont(gameFont); 
		Next_Label.setForeground(Color.WHITE);
		Next_Label.setText(text);
	}
	
	//Battle Action Page functions
	public void Set_Option_Background(Color color)
	{
		Options_Panel.setBackground(color);
	}
	public void Set_Option_Text(String text)
	{
		Options_Label.setFont(gameFont);
		Options_Label.setForeground(Color.WHITE);
		Options_Label.setText(text);
	}
	public void Set_Option_Button_Names(String option1, String option2, String option3)
	{
		First_Button.setText(option1);
		Second_Button.setText(option2);
		Third_Button.setText(option3);
	}
}
