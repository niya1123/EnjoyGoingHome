package testdrive;

import java.util.ArrayList;
import java.util.Scanner;

import data.CalcRoute;
import data.ReadMap;
import map.Contains;
import map.CreateMap;
import map.Station;
import map.Store;

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
//		sc.close();
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
		int s = 0;
		int e = 0;
		ArrayList<Boolean> isStationDetour = new ArrayList<>();
		ArrayList<Boolean> isStoreDetour = new ArrayList<>();
		for(int i = 0; i < esc2.length; i++) {
			for(int j = 0; j < esc2[i].length; j++) {
				if(esc2[i][j] instanceof Station) {
					System.out.println("駅" + (e+1) + "に寄り道しますか?(するなら1,しないなら0)");
					if(sc.next().equals("1")) isStationDetour.add(true);
					else isStationDetour.add(false);
					e++;
				}
				if(esc2[i][j] instanceof Store) {
					System.out.println("店" + (s+1) + "に寄り道しますか?(するなら1,しないなら0)");
					if(sc.next().equals("1")) isStoreDetour.add(true);
					else isStoreDetour.add(false);
					s++;
				}
			}
		}
		sc.close();
		CalcRoute calcRoute = new CalcRoute();
//		Contains[][] esc3 = calcRoute.calcRoute(/*isDetour,*/ ReadMap.readMap(name));
		Contains[][] esc3 = calcRoute.setDetour(ReadMap.readMap(name), isStationDetour, isStoreDetour);
		for(int i = 0; i < esc3.length; i ++) {
			for(int j = 0; j < esc3[i].length; j++) {
				if(esc3[i][j].isDetour()) System.out.print("t");
				esc3[i][j].showInfo();
				if( j == 9 ) System.out.println();
			}
		}
		
		System.out.println("calcRouteのテスト");
		System.out.println("orderを表示");
		TestCalcRoute testmap = new TestCalcRoute();
		testmap.main(null);
	}
		
}
