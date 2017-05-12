
public class TAtaque extends Event{
	Treinador t1, t2;
	TAtaque(Treinador t1, Treinador t2){
		this.t1 = t1;
		this.t2 = t2;
	}
	public void action(){
		//sorteia um ataque
		//fala qual ataque foi usado no log
		//tira vida do pokemon afetado
		if(t1.atualVivo()){
			int n = (int)Math.floor(t1.totalPokemons*Math.random());
			t2.atualMudaVida(-t1.ataqueN(n).damage);
			
			System.out.println(t1.nome + ": " + t1.nomeAtual() + " " + t1.ataqueN(n).description()
					+ "   :" + t1.nomeAtual() + t1.vidaAtual() + " " + t2.nomeAtual()+t2.vidaAtual());
		}
	}
	public String description(){
		return "Um treinador ataca";
	}
}
