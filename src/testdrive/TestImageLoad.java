package testdrive;

import java.nio.file.Paths;

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
		System.out.println(Paths.get(ContainsTypes.PATH.getPath()).toUri().toString());
		Image imagePath= new Image(Paths.get(ContainsTypes.PATH.getPath()).toUri().toString());
		if(imagePath != null) {
			System.out.println("notnull");
		}

	}
}
