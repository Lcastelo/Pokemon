import java.util.ArrayList;

public class Treinador {
	String nome;
	Pokemon [] pokemons;
	
	public Treinador(ArrayList<Pokemon> pokepedia){
		for (int i = 0; i < 4; i++){
			//é possivel ter o mesmo pokemon mais de uma vez
			pokemons[i] = pokepedia.get((int) Math.floor(pokepedia.size()*Math.random()));
		}
	}
}
