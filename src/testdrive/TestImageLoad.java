package testdrive;

import javafx.scene.image.Image;
import map.ContainsTypes;

/**
 * 画像読み込みのテスト兼エラー確認
 * @author kei
 *
 */

public class TestImageLoad {
	public static void main(String[] args) {
		TestImageLoad ti = new TestImageLoad();
		ti.load();
	}


	private void load() {
		Image imagePath= new Image(getClass().getResourceAsStream(ContainsTypes.PATH.getPath()));
		if(imagePath != null) {
			System.out.println("notnull");
		}

	}
}
