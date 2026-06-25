package Main;

import java.util.Random;

public class Stats 
{
	int level;
	int max_hp;
	int current_hp;
	int strength;
	int magic;
	int speed;
	int defense;
	int experience;
	Random random = new Random();
	final int[] Level_Milestones = {10, 30, 60, 100, 200};
	public Stats(int level, int hp, int strength, int magic, int speed, int defense, int experience)
	{
		this.level = level;
		this.max_hp = hp;
		this.current_hp = hp;
		this.strength = strength;
		this.magic = magic;
		this.speed = speed;
		this.defense = defense;
		this.experience = experience;
	}
	public void Take_Damage(int damage, boolean ismagic)
	{
		if(ismagic)
		{
			damage = damage - this.magic;
		}
		else
		{
			damage = damage - this.defense;
		}
		if(damage < 0)
		{
			damage = 0;
		}
		this.current_hp = this.current_hp - damage;
		if(this.current_hp < 0)
		{
			this.current_hp = 0;
		}
	}
	public void Heal(int heal)
	{
		this.current_hp = this.current_hp + heal;
		if(this.current_hp > this.max_hp)
		{
			this.current_hp = this.max_hp;
		}
	}
	public int Attack()
	{
		return this.strength + random.nextInt(5);
	}
	public int Magic()
	{
		return this.magic + random.nextInt(5);
	}
	public void Gain_Experience(int experience)
	{
		this.experience = this.experience + experience;
	}
	public boolean Can_Level_Up()
	{
		if(this.level == 5)
		{
			return false;
		}
		if(this.experience >= Level_Milestones[level - 1])
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void Level_Up()
	{
		//Need logic for Level Up Screen
		//Decide how stats are calculated later
	}
	
}
