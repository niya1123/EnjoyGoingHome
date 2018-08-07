package map;

/**
 * 駅のクラス.
 * @author YK
 */
public class Station extends Contains{

	/**
	 * Stationのデフォルドのノード値は0とする.
	 * @param nodePoint
	 */
	public Station(int nodePoint) {
		super(nodePoint);
		super.type= ContainsTypes.STATIOM;
	}

	@Override
	public void showInfo() {
		System.out.print("駅 ");
	}

	@Override
	public boolean isDetour() {
		return detour;
	}

	public void setDetour(boolean flg) {
		this.detour = flg;
	}

}
