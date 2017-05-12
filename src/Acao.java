
public class Acao extends Event{
	Treinador t1, t2;
	Acao(Treinador t1, Treinador t2){
		this.t1 = t1;
		this.t2 = t2;
	}
	public void action(){
		/*
		 * sorteia um numero, se ele é menor que 0.05 (5% de chance) 
		 * então ele usa a cura
		 * se não sorteia um ataque
		 */
		double r = Math.random();
		if(r < 0.05){//ganha vida do item
			t1.atualMudaVida(30);
			System.out.println(t1.nome + ": " + t1.nomeAtual() + " usou um item e ganhou 30pt de vida" 
			+ "   :" + t1.nomeAtual() + t1.vidaAtual() + " " + t2.nomeAtual()+t2.vidaAtual());
			System.out.println();
		}
		else{
			if(t1.atualVivo()){
				int n = (int)Math.floor(t1.totalPokemons*Math.random());
				t2.atualMudaVida(-t1.ataqueN(n).damage);
				
				System.out.println(t1.nome + ": " + t1.nomeAtual() + " " + t1.ataqueN(n).description()
						+ "   :" + t1.nomeAtual() + t1.vidaAtual() + " " + t2.nomeAtual()+t2.vidaAtual());
				System.out.println();
			}
		}

	}
	public String description(){
		return "Um treinador ataca";
	}
}
