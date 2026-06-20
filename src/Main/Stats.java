package Main;

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
}
