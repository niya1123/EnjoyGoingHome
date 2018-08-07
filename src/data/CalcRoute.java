package data;

import java.util.ArrayList;

import com.sun.java.swing.plaf.gtk.resources.gtk_it;

import data.SaveData;
import map.Contains;
import map.Home;
import map.Station;
import map.Store;

public class CalcRoute {
	
	protected SaveData saveData;
	
	public CalcRoute() {
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
//		Contains[][] esc = saveData.getCreateMap(data);
		
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
		//距離の最大値
		int range=0;
		
		//初期位置
		esc[startY][startX].setOrder(1);
		
		int orderCount=2;
		
		
		//isDetourの数だけループ
		while(true){
			
			for(int i=0; i<esc.length; i++){
				for(int j=0; j<esc[i].length; j++){
					if(esc[i][j].isDetour() && !esc[i][j].getVisited()){
						if( range < calcRange(startY, startX, i, j) ){
							range = calcRange(startY, startX, i, j);
							startY = i;
							startX = j;
						}
					}
					esc[startY][startX].setOrder(orderCount);
					esc[startY][startX].setVisited(true);
				}
			}
			
//			System.out.println(orderCount);
			orderCount++;
			
			
			count--;
			if(count<=0) break;
		}
		
		//家に最後のorderを設定
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
