package testdrive;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import data.ReadMap;
import map.Contains;
import map.ContainsTypes;
import map.CreateMap;
import resource.ResourceLoader;

public class TestContainsType {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String name = "1";

		InputStreamReader isr= new InputStreamReader(ResourceLoader.getInstance().getResourceMap(name));
		if(isr!= null) {
			System.out.println("InputStream is not null");
		}
		BufferedReader reader = new BufferedReader(isr);
			if(reader != null) {
				System.out.println("BufferedReader is not null");
			}

		Contains[][] map = CreateMap.createmap(ReadMap.readMap("1"));

		for(int i= 0; i< 10; i++) {
			for(int j= 0; j< 10; j++) {
			System.out.print(ContainsTypes.class.getSimpleName().getClass().getResourceAsStream(map[i][j].getPath())+ ": ");
			}
			System.out.println();
		}

	}

}
