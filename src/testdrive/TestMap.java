package testdrive;

import java.util.Scanner;

import data.CalcRoute;
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
		System.out.print("mapを選択してください: ");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		sc.close();
		for(String line: ReadMap.readMap(name)) {
			System.out.println(line);
		}
		
		System.out.println();
		System.out.println("createmap(data)のテスト");
		Contains[][] esc2 = CreateMap.createmap(ReadMap.readMap(name));
		for(int i = 0; i < esc2.length; i++) {
			for(int j = 0; j < esc2[i].length; j++) {
				esc2[i][j].showInfo();
				if( j == 9 ) System.out.println();
			}
		}
		
		System.out.println();
		System.out.println("CalcRouteのテスト");
		//home以外のStationとStoreが寄り道するか否かを納めた配列
		boolean[] isDetour = {true, false};
		CalcRoute calcRoute = new CalcRoute();
		Contains[][] esc3 = calcRoute.calcRoute(isDetour, ReadMap.readMap(name));
		for(int i = 0; i < esc3.length; i ++) {
			for(int j = 0; j < esc3[i].length; j++) {
				if(esc3[i][j].isDetour()) System.out.print("t");
				esc3[i][j].showInfo();
				if( j == 9 ) System.out.println();
			}
		}
		
	}
		
}
