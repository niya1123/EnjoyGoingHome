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
		if(north && !east && !west && south)return "/picRoute/path01.png";//NS
		else if(north && !east && west && !south)return "/picRoute/path02.png";//NW
		else if(north && east && !west && !south)return "/picRoute/path03.png";//NE
		else if(!north && east && west && !south)return "/picRoute/path04.png";//EW
		else if(!north && !east && west && south)return "/picRoute/path05.png";//WS
		else if(!north && east && !west && south)return "/picRoute/path06.png";//ES
		else if(north && east && west && south)return "/picRoute/path07.png";//NEWS
		else if(north && !east && west && south)return "/picRoute/path08.png";//NWS
		else if(north && east && !west && south)return "/picRoute/path09.png";//NES
		else if(north && east && west && !south)return "/picRoute/path10.png";//NEW
		else if(!north && east && west && south)return "/picRoute/path11.png";//EWS

		else {return "/picRoute/path00.png";}
		}

	/**
	 * Containsの中のOrderから、ルート作成をし、同時にフィールドの更新をする
	 * @param contains
	 * @return
	 */
	public static Contains[][] makeRoute(Contains[][] contains){

		//orderの最大値を取ってくる
		int maxOrder=0;
		for(int i = 0; i < contains.length; i++) {
			for(int j = 0; j < contains[i].length; j++) {
				if(contains[i][j].getOrder() > maxOrder){
					maxOrder = contains[i][j].getOrder();
				}
			}
		}

		//orderのカウンター
		int countOrder=2;

		//１つ目のノードの添字
		int y1=0;
		int x1=0;

		//２つ目のノードの添字
		int y2=0;
		int x2=0;

		//boolean
		boolean moveRight=false;
		boolean moveDown=false;

		// 1→2, 2→3ってずらして処理する
		while(true){
			moveRight=false;
			moveDown=false;

			//orderを探す
			for(int i = 0; i < contains.length; i++) {
				for(int j = 0; j < contains[i].length; j++) {
					if(contains[i][j].getOrder() == countOrder){
						y2 = i;
						x2 = j;
					}
				}
			}

			if ( (x2-x1)>=0 ) moveRight=true;
			if ( (y2-y1)>=0 ) moveDown=true;

			//→↓
			if ( moveRight && moveDown ) {
				//→と↓に移動する回数
				int rangeX=Math.abs(x2-x1);//→にrangeX回
				int rangeY=Math.abs(y2-y1)-1;//↓にrangeY回

				//→
				for(int i=1; i<=rangeX; i++) {
					contains[y1][x1+i].getRouting().through(3, 2);
					if(i==rangeX) contains[y1][x1+i].getRouting().through(3, 4);
				}

				//↓
				for(int j=1; j<=rangeY; j++) {
					contains[y1+j][x1+rangeX].getRouting().through(1, 4);
				}
			}

			//→↑
			if( moveRight && !moveDown ) {
				//→と↑に移動する回数
				int rangeX=Math.abs(x2-x1);//→にrangeX回
				int rangeY=Math.abs(y2-y1)-1;//↓にrangeY回

				//→
				for(int i=1; i<=rangeX; i++) {
					contains[y1][x1+i].getRouting().through(3, 2);
					if(i==rangeX) contains[y1][x1+i].getRouting().through(3, 1);
				}

				//↑
				for(int j=1; j<=rangeY; j++) {
					contains[y1-j][x1+rangeX].getRouting().through(4, 1);
				}
			}

			//←↓
			if( !moveRight && moveDown ){
				//→と↑に移動する回数
				int rangeX=Math.abs(x2-x1);//→にrangeX回
				int rangeY=Math.abs(y2-y1)-1;//↓にrangeY回

				//←
				for(int i=1; i<=rangeX; i++) {
					contains[y1][x1-i].getRouting().through(2, 3);
					if(i==rangeX) contains[y1][x1-i].getRouting().through(2, 4);
				}

				//↓
				for(int j=1; j<=rangeY; j++) {
					contains[y1+j][x1+rangeX].getRouting().through(4, 1);
				}
			}

			//←↑
			if( !moveRight && !moveDown ){
				//→と↑に移動する回数
				int rangeX=Math.abs(x2-x1);//→にrangeX回
				int rangeY=Math.abs(y2-y1)-1;//↓にrangeY回

				//←
				for(int i=1; i<=rangeX; i++) {
					contains[y1][x1-i].getRouting().through(2, 3);
					if(i==rangeX) contains[y1][x1-i].getRouting().through(2, 4);
				}

				//↑
				for(int j=1; j<=rangeY; j++) {
					contains[y1-j][x1+rangeX].getRouting().through(4, 1);
				}
			}

			//次のために添え字の設定
			y1 = y2;
			x1 = x2;

			//カウント
			countOrder++;
			if (maxOrder<0) break;
			maxOrder--;
		}
		return contains;
	}



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
//						横移動(iやsaveYは変えない)
						if(saveX< j) {	//右移動
							moveRight= true;
							for(int k= ++saveX; k< j; k++) {
								contains[saveY][k].getRouting().through(2, 3);
							}
						}
						else if(saveX> j){//左移動
							moveRight= false;
							for(int k= --saveX; k> j; k--) {
								contains[saveY][k].getRouting().through(3, 2);
							}
						}

//						横移動後のContains[saveY][j]のL字の処理
						if(saveY< i) {//下移動
							moveDown= true;

							if(moveRight) {//右移動
								contains[saveY][j].getRouting().through(3, 4);//左から来て下へ
							}
							else {//左移動
								contains[saveY][j].getRouting().through(2, 4);//右から来て下へ
							}

							for(int k=  ++saveY; k< i; k++) {
								contains[k][j].getRouting().through(1, 4);
							}

						}
						else {//上移動
							moveDown= false;

							if(moveRight) {//右移動
								contains[saveY][j].getRouting().through(3, 1);//左から来て上へ
							}
							else {//左移動
								contains[saveY][j].getRouting().through(2, 1);//右から来て上へ
							}

							for(int k=  --saveY; k> i; k--) {
								contains[k][j].getRouting().through(4, 1);
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
