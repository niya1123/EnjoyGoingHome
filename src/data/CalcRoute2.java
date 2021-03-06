package data;

import java.util.ArrayList;


import data.SaveData;
import map.Contains;
import map.Home;
import map.Station;
import map.Store;

public class CalcRoute2 {
	
	protected SaveData saveData;
	
	public CalcRoute2() {
		this.saveData = new SaveData();
	}
	
	public Contains[][] setDetour(ArrayList<String> data, ArrayList<Boolean> isStationDetour, ArrayList<Boolean> isStoreDetour){
		Contains[][] esc = saveData.getCreateMap(data); 
		int e = 0;
		int s = 0;
		for(int i = 0; i < esc.length; i++) {
			for(int j = 0; j < esc[i].length; j++) {
				if(esc[i][j] instanceof Station) {
					esc[i][j].setDetour(isStationDetour.get(e));
					e++;
				}
				if(esc[i][j] instanceof Store) {
					esc[i][j].setDetour(isStoreDetour.get(s));
					s++;
				}
			}
		}
		return esc;
		
	}
	
	/**
	 * ルートを計算するメソッド
	 * @param startY 初期値点の行の添字
	 * @param startX 初期値点の列の添字
	 * @param data 通る点をtrueにした２次元配列
	 * @return 新たに順序を代入した２次元配列を返す
	 * @author obata
	 */
	public Contains[][] calcRoute(Contains[][] esc) {		
		//通り道の数(isDetourの数)
		int count=0;
		for(int i=0; i<esc.length; i++){
			for(int j=0; j<esc[i].length; j++){
				if(esc[i][j].isDetour()) count++;
			}
		}
		
		//始点の座標
		int startY=0;
		int startX=0;
		//距離の最小値
		int range=1000000;
		
		//初期位置
		esc[0][0].setOrder(1);
		esc[0][0].setVisited(true);
		
		int orderCount=2;
		
		while(true) {
			range = 1000000;
			for(int i = 0; i < esc.length; i++) {
				for(int j = 0; j < esc[i].length; j++) {
					if(!esc[i][j].getVisited()) {
						if(esc[i][j].isDetour()) {
							if(range > calcRange(startY, startX, i, j)) {
								range = calcRange(startY, startX, i ,j);
								startY = i;
								startX = j;
								esc[startY][startX].setOrder(orderCount);
								orderCount++;
							}
						}
						esc[startY][startX].setVisited(true);
					}
				}
			}
			count--;
			if(count<=0) break;
		}
		
		for(int i=0; i<esc.length; i++){
			for(int j=0; j<esc[i].length; j++){
				if(esc[i][j] instanceof Home){
					esc[i][j].setOrder(orderCount);
				}
			}
		}
		
		return esc;
	}
	
	
	/**
	 * ノード間の距離を計算するメソッド
	 * @param aX  １つ目のノードのj
	 * @param aY    １つ目のノードのi
	 * @param bX  ２つ目のノードのj
	 * @param bY    ２つ目のノードのi
	 */
	public int calcRange(int aY, int aX, int bY, int bX){
		return Math.abs(aY-bY) + Math.abs(aX-bX);
	}
}
