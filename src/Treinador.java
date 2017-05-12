import java.util.ArrayList;

public class Treinador {
	String nome;
	Pokemon [] pokemons;
	boolean venceu;
	int pokemonAtual = 0;
	int totalPokemons = 4;
	
	public Treinador(ArrayList<Pokemon> pokepedia){
		for (int i = 0; i < totalPokemons; i++){
			//é possivel ter o mesmo pokemon mais de uma vez
			pokemons[i] = pokepedia.get((int) Math.floor(pokepedia.size()*Math.random())).clone();
			venceu = false;
		}
	}
	
	public boolean venceu(){
		return venceu;
	}
	
	public boolean trocaPokemonAtual(){
		if(pokemonAtual != pokemons.length - 1){
			pokemonAtual++;
			return true;
		}
		return false;
	}
	
	public boolean atualVivo(){
		return pokemons[pokemonAtual].vida > 0;
	}
	
	public String nomeAtual(){
		return pokemons[pokemonAtual].nome;
	}
	
	public Ataque ataqueN(int n){
		return pokemons[pokemonAtual].ataques[n];
	}
	
	public void atualPerdeVida(int x){
		pokemons[pokemonAtual].perdeXVida(x);
	}
}
