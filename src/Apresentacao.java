
public class Apresentacao extends Event{
	Treinador t;
	public Apresentacao(Treinador t){
		this.t = t;
		
	}
	public void action(){
		System.out.println("Ol� eu sou " + t.nome);
	}
	public String description(){
		return "Treinador se apresenta";
	}
}
