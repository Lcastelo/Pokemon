import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Batalha extends Controller{
	public static void main(String[] args) {
		
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
				
				pokepedia.add(new Pokemon(name, att1, att2, att3, att4));//classe pokemon que é responsavel por processar isso
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		Batalha b = new Batalha();
		Treinador T1 = new Treinador(pokepedia);
		Treinador T2 = new Treinador(pokepedia);
		
		b.run();
	}
}