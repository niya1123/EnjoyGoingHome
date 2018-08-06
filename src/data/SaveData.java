package data;

import java.util.ArrayList;

/**
 * 各種データを保持するクラス.
 * @author YK
 */
public class SaveData {
	
	/**
	 * ReadMapのゲッター
	 * @param name　map?.txtの？の部分
	 * @return　ファイルから読み込んだArrayList
	 */
	public ArrayList<String> getReadMap(String name){
		return ReadMap.readMap(name);
	}
	
}
