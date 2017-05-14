
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
			System.out.println("  >" + t1.nome + ": " + t1.nomeAtual() + " usou um item e ganhou 30pt de vida" 
			+ "   :" + t1.nomeAtual() + t1.vidaAtual() + " " + t2.nomeAtual()+t2.vidaAtual());
			System.out.println();
		}
		else{
			if(t1.atualVivo()){
				if (this.relacaoTipo() == 1){
					int n = (int)Math.floor(t1.totalAtaques*Math.random());
					t2.atualMudaVida(-t1.ataqueN(n).damage*2);
					
					System.out.println("  >" + t1.nome + ": " + t1.nomeAtual() + " " + t1.ataqueN(n).description()
							+ ". It's super effective." + "   :" + t1.nomeAtual() + t1.vidaAtual() + " " + t2.nomeAtual()+t2.vidaAtual());
					System.out.println();
				}
				else if (this.relacaoTipo() == -1){
					int n = (int)Math.floor(t1.totalAtaques*Math.random());
					t2.atualMudaVida(-t1.ataqueN(n).damage/2);
					
					System.out.println("  >" + t1.nome + ": " + t1.nomeAtual() + " " + t1.ataqueN(n).description()
							+ ". It's not very effective." +"   :" + t1.nomeAtual() + t1.vidaAtual() + " " + t2.nomeAtual()+t2.vidaAtual());
					System.out.println();
				}
				
				else{
					int n = (int)Math.floor(t1.totalAtaques*Math.random());
					t2.atualMudaVida(-t1.ataqueN(n).damage);
					
					System.out.println("  >" + t1.nome + ": " + t1.nomeAtual() + " " + t1.ataqueN(n).description()
							+ "   :" + t1.nomeAtual() + t1.vidaAtual() + " " + t2.nomeAtual()+t2.vidaAtual());
					System.out.println();
				}
			}
		}

	}
	public String description(){
		return "Um treinador ataca";
	}
	
	public int relacaoTipo(){//retorna 1 pra vantagem do t1, retorna -1 pra vantagem do t2, retorna 0 se nenhum dos dois tem vantagem
		if((t2.atualTipo().equals("Fogo") && t1.atualTipo().equals("Agua")) ||
				(t2.atualTipo().equals("Grama") && t1.atualTipo().equals("Fogo")) ||
				(t2.atualTipo().equals("Agua") && t1.atualTipo().equals("Grama")) ||
				(t2.atualTipo().equals("Terra") && t1.atualTipo().equals("Agua")) ||
				(t2.atualTipo().equals("Eletrico") && t1.atualTipo().equals("Terra")) ||
				(t2.atualTipo().equals("Agua") && t1.atualTipo().equals("Eletrico")) ||
				(t2.atualTipo().equals("Lutador") && t1.atualTipo().equals("Psiquico")) ||
				(t2.atualTipo().equals("Dark") && t1.atualTipo().equals("Lutador")) ||
				(t2.atualTipo().equals("Psiquico") && t1.atualTipo().equals("Dark"))){
			return 1;
		}
		else if ((t1.atualTipo().equals("Fogo") && t2.atualTipo().equals("Agua")) ||
				(t1.atualTipo().equals("Grama") && t2.atualTipo().equals("Fogo")) ||
				(t1.atualTipo().equals("Agua") && t2.atualTipo().equals("Grama")) ||
				(t1.atualTipo().equals("Terra") && t2.atualTipo().equals("Agua")) ||
				(t1.atualTipo().equals("Eletrico") && t2.atualTipo().equals("Terra")) ||
				(t1.atualTipo().equals("Agua") && t2.atualTipo().equals("Eletrico")) ||
				(t1.atualTipo().equals("Lutador") && t2.atualTipo().equals("Psiquico")) ||
				(t1.atualTipo().equals("Dark") && t2.atualTipo().equals("Lutador")) ||
				(t1.atualTipo().equals("Psiquico") && t2.atualTipo().equals("Dark"))){
			return -1;
		}
		else return 0;
	}
}
