package data;

import java.util.ArrayList;

import data.SaveData;
import map.Contains;
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
	
//	public Contains[][] calcRoute(/*boolean[] isDetours,*/ ArrayList<String> data) {
//		Contains[][] esc = saveData.getReadMap(data); 
////		for(int i = 0; i < esc.length; i++) {
////			for(int j = 0; j < esc[i].length; j++) {
////				if(esc[i][j] instanceof Station) esc[i][j].setDetour(isDetours[0]);
////				if(esc[i][j] instanceof Store) esc[i][j].setDetour(isDetours[1]);
////			}
////		}
//		
//		return esc;
//	}
}
