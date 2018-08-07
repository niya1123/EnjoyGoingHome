package map;

/**
 * Containsクラスの種別判別用の列挙
 * @author kei
 *
 */
public enum ContainsTypes {
	/**
	 * 各種列挙要素に、対応する画像ファイルのパスをもたせる。
	 */

	HOME("/pic/home.png"),
	PATH("/pic/path.jpg"),
	STATIOM("/pic/station.png"),
	STORE("/pic/store.png");

	private String path;

	private ContainsTypes(String path) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.path = path;
	}

	/**
	 * 列挙要素の持つパスのゲッター
	 * @return
	 */
	public String getPath() {
		return path;
	}
}
