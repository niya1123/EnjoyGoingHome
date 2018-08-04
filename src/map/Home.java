package map;

/**
 * 家クラス
 * @author YK
 */
public class Home extends Contains{
	
	/**
	 * Homeのデフォルトのノード値は0とする.
	 * @param nodePoint ノード値
	 */
	public Home(int nodePoint) {
		super(nodePoint);
	}

	@Override
	public void showInfo() {
		System.out.print("家 ");
	}

	@Override
	public boolean isDetour(boolean flg) {
		return flg;
	}

}
