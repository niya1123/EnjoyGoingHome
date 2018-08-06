package data;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReadMap {
	
	public static ArrayList<String> readMap(String name){
		ArrayList<String> data = new ArrayList<>();
		Path path = Paths.get("./src/data/" + "map" + name + ".txt");
		try(BufferedReader reader = Files.newBufferedReader(path)){
			String line;
			while((line = reader.readLine()) != null) {
				String[] token = line.split(",");
				data.add(token[0]);
			}
		} catch (IOException e) {
			System.out.println("ファイルが開けませんでした");
			e.printStackTrace();
		}
		
		
		return data;
	}
}