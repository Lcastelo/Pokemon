
public class Ataque extends Event{
	String description;
	int damage;
	Ataque(long eventTime, String description, int damage) {
		super(eventTime);
		this.description = description;
		this.damage = damage;
	}
	public void action(){
		//tira vida do outro pokemon
	}
	public String description(){
		return this.description;
	}
}
