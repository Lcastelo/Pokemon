
public class Pokemon {
	public String nome;
	public int vida;
	public Ataque [] att;
	public int vidamax;
	
	public Pokemon(String n, int v, String att_descriptions[], int att_danos[]){
		nome = n;
		vida = v;
		for(int i = 0; i < 4 ; i++){
			att[i] = new Ataque(200, att_descriptions[i], att_danos[i]);
		}
		vidamax = v;
	}
}