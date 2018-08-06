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
	
	public Contains[][] calcRoute(boolean[] isDetours, ArrayList<String> data) {
		Contains[][] esc = saveData.getReadMap(data); 
		for(int i = 0; i < esc.length; i++) {
			for(int j = 0; j < esc[i].length; j++) {
				if(esc[i][j] instanceof Station) esc[i][j].setDetour(isDetours[0]);
				if(esc[i][j] instanceof Store) esc[i][j].setDetour(isDetours[1]);
			}
		}
		
		return esc;
	}
}
