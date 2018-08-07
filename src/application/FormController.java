package application;

import java.net.URL;
import java.util.ResourceBundle;

import data.ReadMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import map.Contains;
import map.ContainsTypes;
import map.CreateMap;
/**
 * GUI処理部
 * MAP生成や検索条件のオンオフを管理
 * アルゴリズムでの処理は他のクラスに投げる.
 * @author kei
 *
 */
public class FormController implements Initializable{
	@FXML
	private ImageView map00= new ImageView();
	@FXML
	private ImageView map01= new ImageView();
	@FXML
	private ImageView map02= new ImageView();
	@FXML
	private ImageView map03= new ImageView();
	@FXML
	private ImageView map04= new ImageView();
	@FXML
	private ImageView map05= new ImageView();
	@FXML
	private ImageView map06= new ImageView();
	@FXML
	private ImageView map07= new ImageView();
	@FXML
	private ImageView map08= new ImageView();
	@FXML
	private ImageView map09= new ImageView();

	@FXML
	private ImageView map10= new ImageView();
	@FXML
	private ImageView map11= new ImageView();
	@FXML
	private ImageView map12= new ImageView();
	@FXML
	private ImageView map13= new ImageView();
	@FXML
	private ImageView map14= new ImageView();
	@FXML
	private ImageView map15= new ImageView();
	@FXML
	private ImageView map16= new ImageView();
	@FXML
	private ImageView map17= new ImageView();
	@FXML
	private ImageView map18= new ImageView();
	@FXML
	private ImageView map19= new ImageView();

	@FXML private ImageView map20= new ImageView();
	@FXML private ImageView map21= new ImageView();
	@FXML private ImageView map22= new ImageView();
	@FXML private ImageView map23= new ImageView();
	@FXML private ImageView map24= new ImageView();
	@FXML private ImageView map25= new ImageView();
	@FXML private ImageView map26= new ImageView();
	@FXML private ImageView map27= new ImageView();
	@FXML private ImageView map28= new ImageView();
	@FXML private ImageView map29= new ImageView();

	@FXML private ImageView map30= new ImageView();
	@FXML private ImageView map31= new ImageView();
	@FXML private ImageView map32= new ImageView();
	@FXML private ImageView map33= new ImageView();
	@FXML private ImageView map34= new ImageView();
	@FXML private ImageView map35= new ImageView();
	@FXML private ImageView map36= new ImageView();
	@FXML private ImageView map37= new ImageView();
	@FXML private ImageView map38= new ImageView();
	@FXML private ImageView map39= new ImageView();

	@FXML private ImageView map40= new ImageView();
	@FXML private ImageView map41= new ImageView();
	@FXML private ImageView map42= new ImageView();
	@FXML private ImageView map43= new ImageView();
	@FXML private ImageView map44= new ImageView();
	@FXML private ImageView map45= new ImageView();
	@FXML private ImageView map46= new ImageView();
	@FXML private ImageView map47= new ImageView();
	@FXML private ImageView map48= new ImageView();
	@FXML private ImageView map49= new ImageView();

	@FXML private ImageView map50= new ImageView();
	@FXML private ImageView map51= new ImageView();
	@FXML private ImageView map52= new ImageView();
	@FXML private ImageView map53= new ImageView();
	@FXML private ImageView map54= new ImageView();
	@FXML private ImageView map55= new ImageView();
	@FXML private ImageView map56= new ImageView();
	@FXML private ImageView map57= new ImageView();
	@FXML private ImageView map58= new ImageView();
	@FXML private ImageView map59= new ImageView();

	@FXML private ImageView map60= new ImageView();
	@FXML private ImageView map61= new ImageView();
	@FXML private ImageView map62= new ImageView();
	@FXML private ImageView map63= new ImageView();
	@FXML private ImageView map64= new ImageView();
	@FXML private ImageView map65= new ImageView();
	@FXML private ImageView map66= new ImageView();
	@FXML private ImageView map67= new ImageView();
	@FXML private ImageView map68= new ImageView();
	@FXML private ImageView map69= new ImageView();

	@FXML private ImageView map70= new ImageView();
	@FXML private ImageView map71= new ImageView();
	@FXML private ImageView map72= new ImageView();
	@FXML private ImageView map73= new ImageView();
	@FXML private ImageView map74= new ImageView();
	@FXML private ImageView map75= new ImageView();
	@FXML private ImageView map76= new ImageView();
	@FXML private ImageView map77= new ImageView();
	@FXML private ImageView map78= new ImageView();
	@FXML private ImageView map79= new ImageView();

	@FXML private ImageView map80 = new ImageView();
	@FXML private ImageView map81= new ImageView();
	@FXML private ImageView map82= new ImageView();
	@FXML private ImageView map83= new ImageView();
	@FXML private ImageView map84= new ImageView();
	@FXML private ImageView map85= new ImageView();
	@FXML private ImageView map86= new ImageView();
	@FXML private ImageView map87= new ImageView();
	@FXML private ImageView map88= new ImageView();
	@FXML private ImageView map89= new ImageView();

	@FXML private ImageView map90= new ImageView();
	@FXML private ImageView map91= new ImageView();
	@FXML private ImageView map92= new ImageView();
	@FXML private ImageView map93= new ImageView();
	@FXML private ImageView map94= new ImageView();
	@FXML private ImageView map95= new ImageView();
	@FXML private ImageView map96= new ImageView();
	@FXML private ImageView map97= new ImageView();
	@FXML private ImageView map98= new ImageView();
	@FXML private ImageView map99= new ImageView();


	@FXML private Button button_reload;

	@FXML private RadioButton radio_map1;
	@FXML private RadioButton radio_map2;
	@FXML private RadioButton radio_map3;
	@FXML private RadioButton radio_map4;
	@FXML private RadioButton radio_map5;

	@FXML private ToggleGroup mapSelection;


	/**
	 * ImageView の２次元配列
	 */
	private ImageView[][] mapImages= {{map00, map01, map02, map03, map04, map05, map06, map07, map08, map09},
									{map10, map11, map12, map13, map14, map15, map16, map17, map18, map19},
									{map20, map21, map22, map23, map24, map25, map26, map27, map28, map29},
									{map30, map31, map32, map33, map34, map35, map36, map37, map38, map39},
									{map40, map41, map42, map43, map44, map45, map46, map47, map48, map49},
									{map50, map51, map52, map53, map54, map55, map56, map57, map58, map59},
									{map60, map61, map62, map63, map64, map65, map66, map67, map68, map69},
									{map70, map71, map72, map73, map74, map75, map76, map77, map78, map79},
									{map80, map81, map82, map83, map84, map85, map86, map87, map88, map89},
									{map90, map91, map92, map93, map94, map95, map96, map97, map98, map99}} ;

	/**
	 * 別クラスで投げられたContainsクラスのオブジェクト軍から、マップを生成、描写する
	 */
	public void drawMap(Contains[][] map) {
//		Image imagePath = new Image(ResourceLoader.getInstance().getResourceStreamPath());
//		Image imageHome = new Image(ResourceLoader.getInstance().getResourceStreamHome());
//		Image imageStation = new Image(ResourceLoader.getInstance().getResourceStreamStation());
//		Image imageStore = new Image(ResourceLoader.getInstance().getResourceStreamStore());
		System.out.println(ContainsTypes.PATH.getPath());
		Image imagePath = new Image(ContainsTypes.PATH.getPath());
		Image imageHome = new Image(ContainsTypes.HOME.getPath());
		Image imageStation = new Image(ContainsTypes.STATION.getPath());
		Image imageStore = new Image(ContainsTypes.STORE.getPath());


		System.out.println(imagePath +"\n"+ imageHome +"\n"+ imageStation + "\n"+ imageStore);
		for(int i= 0; i< map.length; i++) {
			for(int j= 0; j< map[i].length; j++) {
//				 Image image= new Image(getClass().getResourceAsStream(map[i][j].getPath()));
				//mapImages[i][j]= new ImageView();


				switch(map[i][j].getType()) {
				case HOME:
					mapImages[i][j].setImage(imageHome);
					break;
				case STATION:
					mapImages[i][j].setImage(imageStation);
					break;
				case STORE:
					mapImages[i][j].setImage(imageStore);
					break;
				case PATH:
				default:
					mapImages[i][j].setImage(imagePath);
					break;

				}
				mapImages[i][j].setVisible(true);

				System.out.println("map["+i+"]["+j+"] is set: "+ map[i][j]);

			}
		}
	}

	/**
	 * 経路表示のためのマップ更新メソッド
	 */
	public void drawRoute() {

	}

	@FXML
	public void onReloadClicked(ActionEvent e) {

	}

	/**
	 * 起動時の初期化
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO 自動生成されたメソッド・スタブ
		drawMap(CreateMap.createmap(ReadMap.readMap("1")));


	}











}
