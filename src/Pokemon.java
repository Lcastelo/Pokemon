
public class Pokemon {
	public String nome;
	public int vida;
	public Ataque [] ataques;
	
	public Pokemon(String nome, String[] att1, String[] att2, String[] att3, String[] att4){
		//CRIA OS 4 ATAQUES APARTIR DOS PARAMETROS ATT1, ATT2, ATT3, ATT4
		ataques[0] = new Ataque(200, att1[0], att1[1], Integer.parseInt(att1[2]));
		ataques[1] = new Ataque(200, att2[0], att2[1], Integer.parseInt(att2[2]));
		ataques[2] = new Ataque(200, att3[0], att3[1], Integer.parseInt(att3[2]));
		ataques[3] = new Ataque(200, att4[0], att4[1], Integer.parseInt(att4[2]));
		
		this.nome = nome;
		
		this.vida = 150;
	}
}