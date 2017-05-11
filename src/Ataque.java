
public class Ataque extends Event{
	String description;
	String name;
	int damage;
	Ataque(long eventTime,String name, String description, int damage) {
		super(eventTime);
		this.description = description;
		this.damage = damage;
		this.name = name;
	}
	public void action(){
		//tira vida do outro pokemon
	}
	public String description(){
		return this.description;
	}
}
