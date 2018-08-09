package map;

/**
 * 道のクラス.
 * @author YK
 */
public class Path extends Contains{


	/**
	 * Pathのデフォルトのノード値は1とする.
	 * 最大10を設定.
	 * @param nodePoint
	 */
	public Path(int nodePoint) {
		super(nodePoint);
		super.type= ContainsTypes.PATH;
	}

	@Override
	public void showInfo() {
		System.out.print("道 ");
	}
}
