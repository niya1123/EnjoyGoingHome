package testdrive;

import data.ReadMap;
import map.Contains;
import map.CreateMap;
import map.Path;
import map.Routing;

public class TestRouting {

	public static void main(String[] args) {
		Contains[][] esc = Routing.makeRoute(CreateMap.createmap(ReadMap.readMap("1")));
		
		for(int i = 0; i < esc.length; i++) {
			for(int j = 0; j < esc[i].length; j++) {
				esc[i][j].showInfo();
				if(esc[i][j] instanceof Path) {
//					System.out.print("p");
					if(esc[i][j].getRouting().isWest()) {
						System.out.print("w");
					}
					if(esc[i][j].getRouting().isSouth()) {
						System.out.print("s");
					}
					if(esc[i][j].getRouting().isNorth()) {
						System.out.print("n");
					}
					if(esc[i][j].getRouting().isEast()) {
						System.out.print("e");
					}
					
				}
				if( j == 9 ) System.out.println();
			}
		}

	}

}
