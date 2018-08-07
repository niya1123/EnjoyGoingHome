package data;

import java.util.ArrayList;

import map.Contains;
import map.CreateMap;

/**
 * 各種データを保持するクラス.
 * @author YK
 */
public class SaveData {
	
	/**
	 * CreateMapMapのゲッター
	 * @param data ファイルから読み込んだArrayList
	 * @return　Mapのオブジェクト群
	 */
	public Contains[][] getCreateMap(ArrayList<String> data){
		return CreateMap.createmap(data);
	}
	
}
