package testdrive;

import data.ReadMap;
import map.Contains;
import map.ContainsTypes;
import map.CreateMap;

public class TestContainsType {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Contains[][] map = CreateMap.createmap(ReadMap.readMap("1"));

		for(int i= 0; i< 10; i++) {
			for(int j= 0; j< 10; j++) {
			System.out.print(ContainsTypes.class.getSimpleName().getClass().getResourceAsStream(map[i][j].getPath())+ ": ");
			}
			System.out.println();
		}

	}

}
