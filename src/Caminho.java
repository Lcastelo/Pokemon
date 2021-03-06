import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Caminho {
	
	public static boolean prob(){
		return Math.random()<0.3;
	}
	
	public static void main(String[] args) {
		int i = 0;
		
		//CRIANDO O ARRAY POKEPEDIA//
				ArrayList<Pokemon> pokepedia = new ArrayList<Pokemon>();
				
				String fileName = "Pokemons.csv";
				File file = new File(fileName);
				try {
					Scanner inputStream = new Scanner(file);
					while(inputStream.hasNextLine()){
						String name = inputStream.nextLine();
						String[] atTa = inputStream.nextLine().split(",");
						String[] atTb = inputStream.nextLine().split(",");
						String[] att3 = inputStream.nextLine().split(",");
						String[] att4 = inputStream.nextLine().split(",");
						String tipo = inputStream.nextLine();
						
						pokepedia.add(new Pokemon(name, atTa, atTb, att3, att4, tipo));//classe pokemon que � responsavel por processar isso
					}
					inputStream.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		Treinador Ta = new Treinador(pokepedia, "Jonas");
		Treinador Tb = new Treinador(pokepedia, "Marcos");
		
		while((10-i++)!=0 && Ta.somaDasVidas()>0 && Tb.somaDasVidas()>0){
			System.out.println(i + ": " +Ta.nome + " andou para uma casa com graminha");
			if(prob()){
				(new Batalha(pokepedia,Ta)).battle();
			}

			System.out.println(i + ": " +Tb.nome + " andou para uma casa com graminha");
			if(prob()){
				(new Batalha(pokepedia,Tb)).battle();
			}
		}
		(new Batalha(pokepedia, Ta, Tb)).battle();
	}
}
