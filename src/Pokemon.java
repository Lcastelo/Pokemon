import java.util.ArrayList;

public class Pokemon {
	public String nome;
	public String tipo;
	public int vida;
	public ArrayList<Ataque> ataques;
	public static Item it = new Item();
	
	public Pokemon(){
		ataques = new ArrayList<Ataque>();
	};//default constructor 
	
	public Pokemon(String nome, String[] att1, String[] att2, String[] att3, String[] att4, String tipo){
		ataques = new ArrayList<Ataque>();
		
		//CRIA OS 4 ATAQUES APARTIR DOS PARAMETROS ATT1, ATT2, ATT3, ATT4
		ataques.add(new Ataque(att1[0], att1[1], Integer.parseInt(att1[2])));
		ataques.add(new Ataque(att2[0], att2[1], Integer.parseInt(att2[2])));
		ataques.add(new Ataque(att3[0], att3[1], Integer.parseInt(att3[2])));
		ataques.add(new Ataque(att4[0], att4[1], Integer.parseInt(att4[2])));
		
		this.nome = nome;
		this.tipo = tipo;
		this.vida = 300;
	}
	
	public Pokemon clone(){
		Pokemon c = new Pokemon();
		for (int i = 0; i<4; i++){
			c.ataques.add(this.ataques.get(i));
		}
		c.vida = this.vida;
		c.nome = this.nome;
		c.tipo = this.tipo;
		return c;
	}
	
	public void mudaXVida(int x){
		this.vida += x;
		if(this.vida < 0) this.vida = 0;
		if(this.vida > 300) this.vida = 300;
	}
}
