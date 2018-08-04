package map;

/**
 * Mapの生成
 * @author YK
 */
public class CreateMap {
	
	/**
	 * Map生成のクラスメソッド.
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
}
