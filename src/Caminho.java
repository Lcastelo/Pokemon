import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Caminho {
	
	public static boolean prob(){
		return Math.random()<0.09;
	}
	
	public static void main(String[] args) {
		int i = 0;
		Batalha b;
		
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
						
						pokepedia.add(new Pokemon(name, atTa, atTb, att3, att4));//classe pokemon que � responsavel por processar isso
					}
					inputStream.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		Treinador Ta = new Treinador(pokepedia, "Jonas");
		Treinador Tb = new Treinador(pokepedia, "Marcos");
		
		while((10-i++)!=0 && Ta.atualVivo() && Tb.atualVivo()){
			System.out.println(Ta.nome + "andou para uma casa com graminha");
			if(prob())
				b = new Batalha(pokepedia,Ta);
			System.out.println(Tb.nome + "andou para uma casa com graminha");
			if(prob())
				b = new Batalha(pokepedia,Tb);
		}
		
		b = new Batalha(pokepedia, Ta, Tb);
	}
}