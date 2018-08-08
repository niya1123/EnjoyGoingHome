package map;

/**
 * 道筋のGUI描画の際に利用
 * @author kei
 *
 */
public class Routing {

	/**
	 * 東西南北のどれを通過に利用されたか
	 *
	 * NEWS
	 * 1234
	 */
	private boolean north;
	private boolean east;
	private boolean west;
	private boolean south;


	public Routing() {
		// TODO 自動生成されたコンストラクター・スタブ
		this.north= false;
		this.east= false;
		this.west= false;
		this.south= false;
	}


	public void through(int from, int to) {
		if(from==1 || to== 1) {
			north= true;
		}
		if(from==2 || to==2) {
			east= true;
		}
		if(from==3 || to== 3) {
			west= true;
		}
		if(from==4 || to==4 ) {
			south= true;
		}
	}



	/**
	 * フィールドの真偽から、必要な画像のファイルパスを返す
	 * @return
	 */
	public String toImagePath() {
		if(north && !east && !west && south)return "01";//NS
		else if(north && !east && west && !south)return "02";//NW
		else if(north && east && !west && !south)return "03";//NE
		else if(!north && east && west && !south)return "04";//EW
		else if(!north && !east && west && south)return "05";//WS
		else if(!north && east && !west && south)return "06";//ES
		else if(north && east && west && south)return "07";//NEWS
		else if(north && !east && west && south)return "08";//NWS
		else if(north && east && !west && south)return "09";//NES
		else if(north && east && west && !south)return "10";//NEW
		else if(!north && east && west && south)return "11";//EWS

		else {return "00";}
		}

	/**
	 * Containsの中のOrderから、ルート作成をし、同時にフィールドの更新をする
	 * @param contains
	 * @return
	 */
	public static Contains[][] makeRoute(Contains[][] contains){
		int maxOrder = 0;
		for(int i = 0; i < contains.length; i++) {
			for(int j = 0; j < contains[i].length; j++) {
				if(contains[i][j].getOrder() > maxOrder) {
					maxOrder = contains[i][j].getOrder();
				}
			}
		}
		
		int saveX = 0; 
		int saveY = 0;
		int north = 0, east = 0, west = 0, south = 0; 
		Contains esc = null;
		for(int i = 2; i <= maxOrder; i++) {
			for(int j = 0; j < contains.length; j++) {
				for(int k = 0; k < contains[j].length; k++) {
					if(contains[j][k].getOrder() == i) {
						esc = contains[j][k];
						saveX = k;
						saveY = j;
					}
				}
			}
			if(east < saveX || east > saveX) {
				esc.getRouting().through(west, 2);
				east = saveX;
			}
			if(west < saveX || west > saveX) {
				esc.getRouting().through(east, 3);
				west = saveX;
			}
			if(north < saveY || north > saveY) {
				esc.getRouting().through(south, 1);
				north = saveY;
			}
			if(south < saveY || south > saveY) {
				esc.getRouting().through(north, 4);
				south = saveY;
			}
			
		}

		return contains;
	}
	
	public boolean isWest() {
		return west;
	}
	
	public boolean isSouth() {
		return south;
	}
	
	public boolean isNorth() {
		return north;
	}
	
	public boolean isEast() {
		return east;
	}

}
