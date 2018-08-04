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
}
