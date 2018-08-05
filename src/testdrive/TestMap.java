package testdrive;

import data.ReadMap;
import map.Contains;
import map.CreateMap;

public class TestMap {
	public static void main(String[] args) {
		System.out.println("createmap()のテスト");
		Contains[][] esc = CreateMap.createmap();
		for(int i = 0; i < esc.length; i++) {
			for(int j = 0; j < esc[i].length; j++) {
				esc[i][j].showInfo();
				if( j == 4 ) System.out.println();
			}
		}
		System.out.println();
		System.out.println("ReadMapのテスト");
		for(String line: ReadMap.readMap()) {
			System.out.println(line);
		}
		
		System.out.println();
		System.out.println("createmap(data)のテスト");
		CreateMap.createmap(ReadMap.readMap());
	}
		
}
