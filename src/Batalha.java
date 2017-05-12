import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Batalha extends Controller{
	public static void main(String[] args) {
		/*
		 * 
		 */
		
		//CRIANDO O ARRAY POKEPEDIA//
		ArrayList<Pokemon> pokepedia = new ArrayList<Pokemon>();
		
		String fileName = "Pokemons.csv";
		File file = new File(fileName);
		try {
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNextLine()){
				String name = inputStream.nextLine();
				String[] att1 = inputStream.nextLine().split(",");
				String[] att2 = inputStream.nextLine().split(",");
				String[] att3 = inputStream.nextLine().split(",");
				String[] att4 = inputStream.nextLine().split(",");
				
				pokepedia.add(new Pokemon(name, att1, att2, att3, att4));//classe pokemon que � responsavel por processar isso
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//CRIA OS OBJETOS
		Batalha b = new Batalha();
		Treinador T1 = new Treinador(pokepedia);
		Treinador T2 = new Treinador(pokepedia);
		
		//ADICIONA AS APRESENTA��ES
		b.addEvent(new Apresentacao(T1));
		b.addEvent(new Apresentacao(T2));
		
		/*	enquanto nenhum dos dois tiver vencido
		 * 		enquanto nenhum dos dois pokemons atuais tiver morrido
		 * 			t1 ataca, t2 ataca, b.run()
		 * 		se o atual do primeiro morreu
		 * 			se ele tem mais pokemons
		 * 				troca o atual
		 * 			se n�o
		 * 				t2 venceu = true e add o evento de vitoria
		 * 		se o atual do segundo morreu
		 * 			se ele tem mais pokemons
		 * 				troca o atual
		 * 			se n�o
		 * 				t1 venceu = true e add o evento de vitoria
		 * 	evento fim da batalha
		 * 	b.run();
		 */
		
		while(!T1.venceu() && !T2.venceu()){
			while(T1.atualVivo() && T2.atualVivo()){
				b.addEvent(new TAtaque());
			}
		}
		
		b.run();
	}
}