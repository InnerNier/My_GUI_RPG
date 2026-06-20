package Main;

public class Inventory 
{
	int Potions;
	int Smoke_Bombs;
	int Bombs;
	public Inventory() 
	{
		Potions = 3;
		Smoke_Bombs = 3;
		Bombs = 3;
	}
	public boolean Use_Potion()
	{
		return false;
	}
	public void Gain_Potion()
	{
		Potions++;
	}
	public boolean Use_Smoke_Bomb()
	{
		return false;
	}
	public void Gain_Smoke_Bomb()
	{
		Smoke_Bombs++;
	}
	public boolean Use_Bomb()
	{
		return false;
	}
	public void Gain_Bomb()
	{
		Bombs++;
	}
}
