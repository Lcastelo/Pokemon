import java.util.ArrayList;

public class Batalha extends Controller{
	static Treinador T1;
	static Treinador T2;
	static ArrayList<Pokemon> pokepedia;
	public Batalha(ArrayList<Pokemon> pokepedia, Treinador T1){
		Batalha.pokepedia = pokepedia;
		Batalha.T1 = T1;
		T2 = new Treinador(pokepedia);//queremos um pokemon só

	}
	public Batalha(ArrayList<Pokemon> pokepedia, Treinador T1, Treinador T2){
		Batalha.pokepedia = pokepedia;
		Batalha.T1 = T1;
		Batalha.T2 = T2;
	}
	public void battle(){
		
		//CRIA O OBJETO BATALHA
		Batalha b = new Batalha(pokepedia, T1, T2);
		
		System.out.println("----------------------------------------");
		
		
		//ADICIONA AS APRESENTAÇÕES
		b.addEvent(new Apresentacao(T1));
		if(!T2.fantasma)b.addEvent(new Apresentacao(T2));

		/*	enquanto nenhum dos dois tiver vencido
		 * 		enquanto nenhum dos dois pokemons atuais tiver morrido
		 * 			t1 ataca, t2 ataca, b.run()
		 * 		se o atual do primeiro morreu
		 * 			se ele tem mais pokemons
		 * 				troca o atual
		 * 			se não
		 * 				t2 venceu = true e add o evento de vitoria
		 * 		se o atual do segundo morreu
		 * 			se ele tem mais pokemons
		 * 				troca o atual
		 * 			se não
		 * 				t1 venceu = true e add o evento de vitoria
		 * 	evento fim da batalha
		 * 	b.run();
		 */

		while(!T1.venceu() && !T2.venceu()){
			while(T1.atualVivo() && T2.atualVivo()){
				if(Math.random() < 3/(1+T1.somaDasVidas())){//vida 100% ->0 vida em 0%-> 1
					//quanto menos vida ele te no total mais chance tem de fugir da batalha
					T2.venceu = true;
					System.out.println("  >" + T1.nome + " fugiu da batalha...");
					break;
				}
				if(Math.random() < 3/(1+T2.somaDasVidas())){
					T1.venceu = true;
					System.out.println("  >" + T2.nome + " fugiu da batalha...");
					break;
				}
				b.addEvent(new Acao(T1, T2));
				b.addEvent(new Acao(T2, T1));
				b.run();
			}
			if(!T1.atualVivo()){//se ele tem outros pokemons isso retorna true
				if(T1.trocaPokemonAtual()){
					System.out.println("  >" + T1.nome + " escolheu " + T1.nomeAtual());
				}
				else{
					T2.venceu = true;
					System.out.println("  >" + T1.nome + " perdeu a batalha");
				}
			}
			if(!T2.atualVivo()){
				if(T2.trocaPokemonAtual()){
					System.out.println("  >" + T2.nome + " escolheu " + T2.nomeAtual());
				}
				else{
					T1.venceu = true;
					System.out.println("  >" + T2.nome + " perdeu a batalha");
				}
			}
		}
		if(T2.nome != null){
			System.out.println("É o fim da batalha: " + (T1.venceu()?T1.nome:T2.nome) + " é o vencedor");
			System.out.println("----------------------------------------");
		}
		T1.venceu = false;
		T2.venceu = false;
		

	}
}