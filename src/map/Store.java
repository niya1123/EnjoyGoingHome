package map;

/**
 * 店のクラス
 * @author YK
 */
public class Store extends Contains{

	/**
	 * Storeのデフォルトのノード値は0とする.
	 * @param nodePoint
	 */
	public Store(int nodePoint) {
		super(nodePoint);
		super.type= ContainsTypes.STORE;
	}

	@Override
	public void showInfo() {
		System.out.print("店 ");
	}
}
