package map;

/**
 * 家クラス
 * @author YK
 */
public class Home extends Contains{


	/**
	 * Homeのノード値は固定で0とする.
	 * @param nodePoint ノード値
	 */
	public Home(int nodePoint) {
		super(nodePoint);
		super.type= ContainsTypes.HOME;
	}

	@Override
	public void showInfo() {
		System.out.print("家 ");
	}

}
