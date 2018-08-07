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
	 * 家,道,店,駅はコンストラクタの引数に渡される数によって優先度が決まる.
	 * @param nodePoint 優先度のための数
	 */
	public Contains(int nodePoint) {
		this.nodePoint = nodePoint;
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
	 * フィールドtypeのgetPathメソッド用
	 */
	public String getPath() {
		return type.getPath();
	}
}
