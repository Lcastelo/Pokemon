
public class Ataque{
	String description;
	String name;
	int damage;
	Ataque(String name, String description, int damage) {
		this.description = description;
		this.damage = damage;
		this.name = name;
	}
	public String description(){
		return this.description;
	}
}
