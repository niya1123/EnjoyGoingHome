package map;

/**
 * 家,道,店,駅を管理するクラス.
 * @author YK
 */
public abstract class Contains {
	/**
	 * 家,道,店,駅の優先度を数で収めたもの.
	 */
	private int nodePoint;

	/**
	 * 寄り道するか否かを判断するためのもの.
	 */
	protected boolean detour;


	/**
	 * Containsの小クラスの種類判別及び画像描写用
	 * 具体的な型は、小クラスのコンストラクタで定義
	 * @author kei
	 */
	protected ContainsTypes type;

	/**
	 * 順番を保持するフィールド
	 * @author obt
	 */
	protected int order;

	/**
	 * 初期値はfalse
	 * 探索済みだとtrueになる
	 * @author obt
	 */
	protected boolean isVisited;

	/**
	 * ルート描画用
	 */
	protected Routing routing;

	/**
	 * 家,道,店,駅はコンストラクタの引数に渡される数によって優先度が決まる.
	 * @param nodePoint 優先度のための数
	 */
	public Contains(int nodePoint) {
		this.nodePoint = nodePoint;
		this.order = 0;
		routing= new Routing();
	}

	/**
	 * フィールドnodePointのゲッター.
	 * @return nodePoint 優先度のための数
	 */
	public int getNodePoint() {
		return nodePoint;
	}

	/**
	 * nodePointのセッター
	 * @param nodePoint 優先度のための数
	 */
	public void setNodePoint(int nodePoint) {
		this.nodePoint = nodePoint;
	}

	/**
	 * 家なら家と表示したりする.
	 */
	public abstract void showInfo();

	/**
	 * 寄り道するかどうか判断するもの.
	 * @return 寄り道するか否か.
	 */
	public boolean isDetour() {
		return detour;
	}

	/**
	 * 寄り道のセッター
	 * @param flg
	 */
	public void setDetour(boolean flg) {
		this.detour = flg;
	}


	/**
	 * orderのセッター
	 * @param order 順番
	 * @author obata
	 */
	public void setOrder(int order){
		this.order = order;
	}

	/**
	 * orderのゲッター
	 * @return int型order 順番
	 * @author obata
	 */
	public int getOrder(){
		return order;
	}

	/**
	 * isVisitedのセッター
	 */
	public void setVisited(boolean bool){
		this.isVisited=bool;
	}

	/**
	 * isVisitedのゲッター
	 * @return isVisited
	 */
	public boolean getVisited(){
		return this.isVisited;
	}

	/**
	 * フィールドtypeのgetPathメソッド用
	 */
	public String getPath() {
		return type.getPath();
	}

	public ContainsTypes getType() {
		return type;
	}

	public void setType(ContainsTypes type) {
		this.type= type;
	}

	public Routing getRouting() {
		return routing;
	}

	/**
	 * detourのまとめてセッター
	 * ２つめの引数のbooleanがtrueならStationのdetourをtrueに。
	 * 3つめの引数のbooleanがtrueならStoreのdetourをtrueに。
	 */
	public static Contains[][] setDetourSS(Contains[][] contains, boolean checkStation, boolean checkStore){
//		10*10の２次元配列というぜんていで記入

		for(int i= 0; i< 10; i++) {
			for(int j= 0; j< 10; j++) {
//				駅のチェック
				if(contains[i][j].type.equals(ContainsTypes.STATION) && checkStation) {
					contains[i][j].setDetour(checkStation);
					contains[i][j].setType(ContainsTypes.STATION_C);
				}

//				店のチェック
				else if(contains[i][j].type.equals(ContainsTypes.STORE) && checkStore) {
					contains[i][j].setDetour(checkStore);
					contains[i][j].setType(ContainsTypes.STORE_C);
				}
			}
		}

		return contains;
	}
}
