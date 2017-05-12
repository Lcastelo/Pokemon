import java.util.ArrayList;

public class Treinador {
	String nome;
	ArrayList<Pokemon> pokemons;//pokemon vai ser trocado pra arraylist
	boolean venceu;
	int pokemonAtual = 0;
	int totalPokemons = 4;
	boolean fantasma;
	
	public Treinador(ArrayList<Pokemon> pokepedia, String nome){
		this.nome = nome;
		fantasma = false;

		pokemons = new ArrayList<Pokemon>();
		
		for (int i = 0; i < totalPokemons; i++){
			//� possivel ter o mesmo pokemon mais de uma vez
			int n = (int) Math.floor(pokepedia.size()*Math.random());
			pokemons.add(pokepedia.get(n).clone());
		}
		venceu = false;
	}
	public Treinador(ArrayList<Pokemon> pokepedia){
		fantasma = true;
		pokemons = new ArrayList<Pokemon>();
		int n = (int) Math.floor(pokepedia.size()*Math.random());
		pokemons.add(pokepedia.get(n).clone());
		venceu = false;
		this.nome =  pokemons.get(0).nome + " selvagem";
	}
	
	public boolean venceu(){
		return venceu;
	}
	
	public boolean trocaPokemonAtual(){
		if(pokemonAtual != pokemons.size() - 1){
			pokemonAtual++;
			return true;
		}
		return false;
	}
	
	public boolean atualVivo(){
		return (pokemons.get(pokemonAtual).vida > 0);
	}
	
	public String nomeAtual(){
		return pokemons.get(pokemonAtual).nome;
	}
	
	public Ataque ataqueN(int n){
		return pokemons.get(pokemonAtual).ataques.get(n);
	}
	
	public void atualMudaVida(int x){
		pokemons.get(pokemonAtual).mudaXVida(x);
	}
	public int vidaAtual(){
		return pokemons.get(pokemonAtual).vida;
	}
	public int somaDasVidas(){
		int soma = 0;
		for (int k = 0; k < pokemons.size(); k++){
			soma += pokemons.get(k).vida;
		}
		return soma;
	}
}
