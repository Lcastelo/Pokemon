
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
		int n = (int)Math.floor(t1.totalPokemons*Math.random());
		
		System.out.println(t1.nomeAtual() + " " + t1.ataqueN(n).description());
		t2.atualPerdeVida(t1.ataqueN(n).damage);
		
	}
	public String description(){
		return "Um treinador ataca";
	}
}
