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
		ArrayList<String> temp = new ArrayList<>();
		for(String line: data) {
			for(String cha: line.split(" ")){
				temp.add(cha);
			}
		}
		
		//ArrayListのtempにちゃんと記号入ってるかチェック
		for(int i = 0; i < temp.size(); i++) {
			System.out.print(temp.get(i));
			if(i%10 == 9) System.out.println();
		}
		
		//map[][]にアルファベットに対応したオブジェクトを生成, 代入
		int k=0;
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				if(temp.get(k).equals("H")) map[i][j] = new Home(0);
				else if(temp.get(k).equals("P")) map[i][j] = new Path(0);
				else if(temp.get(k).equals("S")) map[i][j] = new Store(0);
				else if(temp.get(k).equals("E")) map[i][j] = new Station(0);
				else {
					System.out.println("mapに無効な値が指定されました");
					System.exit(0);
				}
			}
		}
		
		return map;
	}
}
