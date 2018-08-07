package testdrive;

import java.util.ArrayList;

import data.CalcRoute;
import data.ReadMap;
import map.Contains;
import map.CreateMap;
import map.Station;
import map.Store;

public class TestCalcRoute {

	public static void main(String[] args) {
		System.out.println("CalcRouteのテスト");
		/**
		 * map1を読み込んで表示
		 */
		Contains[][] esc = CreateMap.createmap(ReadMap.readMap("1"));
		for(int i = 0; i < esc.length; i++) {
			for(int j = 0; j < esc[i].length; j++) {
				esc[i][j].showInfo();
				if( j == 9 ) System.out.println();
			}
		}
		
		System.out.println("--------------------------------------");
		System.out.println("すべての駅と店を通るように設定");
		ArrayList<Boolean> isDetour = new ArrayList<>();
		for(int i = 0; i < esc.length; i++) {
			for(int j = 0; j < esc[i].length; j++) {
				if(esc[i][j] instanceof Station || esc[i][j] instanceof Store){
					isDetour.add(true);
				}
			}
		}
		CalcRoute calcRoute = new CalcRoute();
		esc = calcRoute.setDetour(ReadMap.readMap("1"), isDetour, isDetour);
		for(int i = 0; i < esc.length; i ++) {
			for(int j = 0; j < esc[i].length; j++) {
				if(esc[i][j].isDetour()) System.out.print("t");
				esc[i][j].showInfo();
				if( j == 9 ) System.out.println();
			}
		}
		
		esc = calcRoute.calcRoute(esc);
		System.out.println("かるくルートしたあと");
	}

}
