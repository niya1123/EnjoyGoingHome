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
//		System.out.println(ContainsTypes.class.getName());
//		System.out.println(ContainsTypes.class.getSimpleName().getClass().getResourceAsStream("/pic/path.jpg"));
//		System.out.println(ContainsTypes.class.getResourceAsStream("./src/pic/path.jpg"));
//		Image imagePath= new Image(ContainsTypes.class.getSimpleName().getClass().getResourceAsStream(ContainsTypes.PATH.getPath()));
		Image imagePath = new Image(ContainsTypes.class.getSimpleName().getClass().getResourceAsStream(ContainsTypes.PATH.getPath()));
		if(imagePath != null) {
			System.out.println("notnull");
		}

	}
}
