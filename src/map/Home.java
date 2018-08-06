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
	}

	@Override
	public void showInfo() {
		System.out.print("家 ");
	}

	@Override
	public boolean isDetour() {
		return detour;
	}

	@Override
	public void setDetour(boolean flg) {
		this.detour = flg;
		
	}

}
