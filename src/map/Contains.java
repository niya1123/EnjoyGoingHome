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
	public abstract boolean isDetour(boolean flg);
}
