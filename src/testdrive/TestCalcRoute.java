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
		Contains[][] esc = CreateMap.createmap(ReadMap.readMap("6"));
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
		esc = calcRoute.setDetour(ReadMap.readMap("6"), isDetour, isDetour);
		for(int i = 0; i < esc.length; i ++) {
			for(int j = 0; j < esc[i].length; j++) {
				if(esc[i][j].isDetour()) System.out.print("t");
				esc[i][j].showInfo();
				if( j == 9 ) System.out.println();
			}
		}
		
		System.out.println("calcRouteするまえ---------------<");
		for(int i = 0; i < esc.length; i++) {
			for(int j = 0; j < esc[i].length; j++) {
				if (esc[i][j].isDetour()) System.out.printf("|%3d", 1);
				else System.out.printf("|%3d", esc[i][j].getOrder());
				if( j == 9 ) System.out.println("|");
			}
		}
		
		
		System.out.println("calcRouteしたあと---------------<");
		esc = CalcRoute.calcRoute(esc);
		for(int i = 0; i < esc.length; i++) {
			for(int j = 0; j < esc[i].length; j++) {
				System.out.printf("|%3d", esc[i][j].getOrder());
				if( j == 9 ) System.out.println("|");
			}
		}	
	}
}
