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
		Contains[][] esc2 = CreateMap.createmap(ReadMap.readMap());
		for(int i = 0; i < esc2.length; i++) {
			for(int j = 0; j < esc2[i].length; j++) {
				esc2[i][j].showInfo();
				if( j == 9 ) System.out.println();
			}
		}
	}
		
}
