package data;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import resource.ResourceLoader;

public class ReadMap {

	public static ArrayList<String> readMap(String name){
		ArrayList<String> data = new ArrayList<>();
		/*  Pathの中身はEclipseで操作するときはsrc/data....
		 * 実行jarにするときはsrc/を取り除く*/
		Path path = Paths.get("src/data/" + "map" + name + ".txt");



		try {
				InputStreamReader isr= new InputStreamReader(ResourceLoader.getInstance().getResourceMap(name));
				BufferedReader reader = new BufferedReader(isr);
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