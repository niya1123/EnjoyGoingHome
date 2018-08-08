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


		return contains;
	}



}
