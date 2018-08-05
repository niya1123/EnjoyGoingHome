package map;

import java.util.ArrayList;
//import java.util.HashMap;

/**
 * Mapの生成
 * @author YK
 */
public class CreateMap {
	
	/**
	 * Map生成のクラスメソッド.テスト用.
	 */
	public static Contains[][] createmap(){
		Contains[][] map = new Contains[4][5];
 		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = new Path(1);
			}
		}
 		map[3][0] = new Home(0);
		map[0][4] = new Station(0);
		map[1][2] = new Store(0);
		map[3][4] = new Path(2);
		return map;
		
	}
	
	/**
	 * Map生成のクラスメソッド.txtファイルから情報を得る.
	 * @param data txtから読み出されたdata
	 * @return map マップ
	 */
	public static Contains[][] createmap(ArrayList<String> data){
		Contains[][] map = new Contains[10][10];
		for(String line: data) {
			String[] lineData = line.split(" ");
			for(int i = 0; i < lineData.length; i++) {
				System.out.print(lineData[i]);
				if(i == 9) System.out.println();
				
			}
		}
		
		return map;
	}
}
