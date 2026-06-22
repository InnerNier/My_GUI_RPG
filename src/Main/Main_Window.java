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
	
	JPanel Battle_Panel = new JPanel();
	JLabel Battle_Label = new JLabel();
	JButton Attack_Button = new JButton("Attack");
	JButton Magic_Button = new JButton("Magic");
	JButton Potion_Button = new JButton("Potion");
	JButton Smoke_Bomb_Button = new JButton("Smoke Bomb");
	
	JPanel Battle_Log_Panel = new JPanel();
	JLabel Battle_Log_Label = new JLabel();
	
	public Main_Window()
	{
		//Frame Set up
		Main_Window = new JFrame("Simple GUI RPG");
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
		
		
		
		//Battle Action Page Specification
		Battle_Panel.setLayout(new BoxLayout(Battle_Panel, BoxLayout.Y_AXIS));
		Battle_Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        Attack_Button.setAlignmentX(Component.CENTER_ALIGNMENT);
        Magic_Button.setAlignmentX(Component.CENTER_ALIGNMENT);
        Potion_Button.setAlignmentX(Component.CENTER_ALIGNMENT);
        Smoke_Bomb_Button.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        Battle_Panel.add(Box.createRigidArea(new Dimension(0, 100)));
        Battle_Panel.add(Battle_Label);
        Battle_Panel.add(Box.createRigidArea(new Dimension(0, 10)));
        Battle_Panel.add(Attack_Button);
        Battle_Panel.add(Box.createRigidArea(new Dimension(0, 10)));
        Battle_Panel.add(Magic_Button);
        Battle_Panel.add(Box.createRigidArea(new Dimension(0, 10)));
        Battle_Panel.add(Potion_Button);
        Battle_Panel.add(Box.createRigidArea(new Dimension(0, 10)));
        Battle_Panel.add(Smoke_Bomb_Button);
        
        
        
        //Battle Log Page Specification
        Battle_Log_Panel.setLayout(new BoxLayout(Battle_Log_Panel, BoxLayout.Y_AXIS));
		Battle_Log_Label.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		Battle_Log_Panel.add(Box.createRigidArea(new Dimension(0, 100)));
        Battle_Log_Panel.add(Battle_Log_Label);
        
        
        
        //Add Panels to card layout and add to Frame
        cardPanel.add(Next_Panel, "NEXT_SCREEN");
        cardPanel.add(Battle_Panel, "BATTLE_SCREEN");
        cardPanel.add(Battle_Log_Panel, "Log_SCREEN");
        
        Main_Window.add(cardPanel);
		
        
        
		//Initial Panel
		Set_Next_Text("Welcome to the Game");
		Set_Next_Background(Color.BLACK);
		Show_Screen("NEXT_SCREEN");
     
		
		
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
	public void Set_Battle_Background(Color color)
	{
		Battle_Panel.setBackground(color);
	}
	public void Set_Battle_Text(String text)
	{
		Battle_Label.setFont(gameFont);
		Battle_Label.setForeground(Color.WHITE);
		Battle_Label.setText(text);
	}
	
	//Battle Log Page functions
	public void Set_Battle_Log_Background(Color color)
	{
		Battle_Log_Panel.setBackground(color);
	}
	public void Set_Battle_Log_Text(String text)
	{
		Battle_Log_Label.setFont(gameFont);
		Battle_Log_Label.setForeground(Color.WHITE);
		Battle_Log_Label.setText(text);
	}
}
