package resource;

import java.io.InputStream;

import map.ContainsTypes;

public class ResourceLoader {

	private static ResourceLoader singleton;


	public static ResourceLoader getInstance() {
		if(singleton == null) {
			singleton = new ResourceLoader();
		}

		return singleton;
	}


	public InputStream getResourceStreamPath() {
		return singleton.getClass().getResourceAsStream(ContainsTypes.PATH.getPath());
	}

	public InputStream getResourceStreamHome() {
		return singleton.getClass().getResourceAsStream(ContainsTypes.HOME.getPath());
	}

	public InputStream getResourceStreamStation() {
		return singleton.getClass().getResourceAsStream(ContainsTypes.STATION.getPath());
	}

	public InputStream getResourceStreamStore() {
		return singleton.getClass().getResourceAsStream(ContainsTypes.STORE.getPath());
	}
	
	public InputStream getResourceMap(String name) {
		return singleton.getClass().getResourceAsStream("../data/"+ "map"+ name+ ".txt");
	}
}
