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
		if(north && !east && !west && south)return "/picRoute/path01";//NS
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
	public static Contains[][] makeRoute_Kei(Contains[][] contains){
		int saveX= 0, saveY= 0, maxOrder= 0;

//		左右上下の直前までの移動方向の確認
		boolean moveRight= true;
		boolean moveDown= true;



//		Orderの最大値の算出
		for(int i= 0; i< contains.length;i++) {
			for(int j=0; j< contains[i].length; j++) {
				if(contains[i][j].getOrder()> maxOrder) {
					maxOrder= contains[i][j].getOrder();
				}
			}
		}

//		Order最大値までのあいだ
		for(int o= 2; o<= maxOrder; o++) {

			for(int i= 0; i< contains.length; i++) {
				for(int j= 0; j< contains[i].length; j++) {
//					次の目的地
					if(contains[i][j].getOrder()== o) {
//						横移動(iやsaveXは変えない)
						if(saveX<= j) {	//右移動
							moveRight= true;
							for(int k= ++saveX; k< j; k++) {
								contains[saveY][k].getRouting().through(2, 3);
							}
						}
						else {//左移動
							moveRight= false;
							for(int k= --saveX; k> j; k--) {
								contains[saveY][k].getRouting().through(3, 2);
							}
						}

//						横移動後のContains[saveY][j]のL字の処理
						if(saveY<= i) {//下移動
							moveDown= true;

							if(moveRight) {//右移動
								contains[saveY][i].getRouting().through(3, 4);//左から来て下へ
							}
							else {//左移動
								contains[saveY][i].getRouting().through(2, 4);//右から来て下へ
							}

							for(int k=  ++saveY; k< i; k++) {
								contains[k][i].getRouting().through(1, 4);
							}

						}
						else {//上移動
							moveDown= false;

							if(moveRight) {//右移動
								contains[saveY][i].getRouting().through(3, 1);//左から来て上へ
							}
							else {//左移動
								contains[saveY][i].getRouting().through(2, 1);//右から来て上へ
							}

							for(int k=  --saveY; k> i; k--) {
								contains[k][i].getRouting().through(4, 1);
							}
						}
					saveY= i;
					saveX= j;
					}
				}
			}

		}
		return contains;
	}



}
