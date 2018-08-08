package application;

import java.net.URL;
import java.util.ResourceBundle;

import data.CalcRoute;
import data.ReadMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
	@FXML private Button button_serach;

	@FXML private RadioButton radio_map1;
	@FXML private RadioButton radio_map2;
	@FXML private RadioButton radio_map3;
	@FXML private RadioButton radio_map4;
	@FXML private RadioButton radio_map5;
	@FXML private RadioButton radio_map6;

	@FXML private ToggleGroup mapSelection;

	@FXML private CheckBox checkStation;
	@FXML private CheckBox checkStore;


	/**
	 * マップの番号を保持
	 * 初期値は"1"
	 */
	private String currentNum= "1";



	/**
	 * 別クラスで投げられたContainsクラスのオブジェクト軍から、マップを生成、描写する
	 */
	public void drawMap(Contains[][] map) {
		System.out.println(ContainsTypes.PATH.getPath());
		Image imagePath = new Image(ContainsTypes.PATH.getPath());
		Image imageHome = new Image(ContainsTypes.HOME.getPath());
		Image imageStation = new Image(ContainsTypes.STATION.getPath());
		Image imageStore = new Image(ContainsTypes.STORE.getPath());
		Contains contains[] = new Contains[100];
		for(int i= 0; i< 10; i++) {
			for(int j= 0; j< 10; j++) {
				contains[(i*10)+j]= map[i][j];
			}
		}

		System.out.println(imagePath +"\n"+ imageHome +"\n"+ imageStation + "\n"+ imageStore);

		/**
		 * 100個のImageViewを一つひとつ更新。もっと他に良い手段はなかったのだろうか...
		 */
		map00.setImage(containsToImage(contains[0]));
		map01.setImage(containsToImage(contains[1]));
		map02.setImage(containsToImage(contains[2]));
		map03.setImage(containsToImage(contains[3]));
		map04.setImage(containsToImage(contains[4]));
		map05.setImage(containsToImage(contains[5]));
		map06.setImage(containsToImage(contains[6]));
		map07.setImage(containsToImage(contains[7]));
		map08.setImage(containsToImage(contains[8]));
		map09.setImage(containsToImage(contains[9]));

		map10.setImage(containsToImage(contains[10]));
		map11.setImage(containsToImage(contains[11]));
		map12.setImage(containsToImage(contains[12]));
		map13.setImage(containsToImage(contains[13]));
		map14.setImage(containsToImage(contains[14]));
		map15.setImage(containsToImage(contains[15]));
		map16.setImage(containsToImage(contains[16]));
		map17.setImage(containsToImage(contains[17]));
		map18.setImage(containsToImage(contains[18]));
		map19.setImage(containsToImage(contains[19]));

		map20.setImage(containsToImage(contains[20]));
		map21.setImage(containsToImage(contains[21]));
		map22.setImage(containsToImage(contains[22]));
		map23.setImage(containsToImage(contains[23]));
		map24.setImage(containsToImage(contains[24]));
		map25.setImage(containsToImage(contains[25]));
		map26.setImage(containsToImage(contains[26]));
		map27.setImage(containsToImage(contains[27]));
		map28.setImage(containsToImage(contains[28]));
		map29.setImage(containsToImage(contains[29]));

		map30.setImage(containsToImage(contains[30]));
		map31.setImage(containsToImage(contains[31]));
		map32.setImage(containsToImage(contains[32]));
		map33.setImage(containsToImage(contains[33]));
		map34.setImage(containsToImage(contains[34]));
		map35.setImage(containsToImage(contains[35]));
		map36.setImage(containsToImage(contains[36]));
		map37.setImage(containsToImage(contains[37]));
		map38.setImage(containsToImage(contains[38]));
		map39.setImage(containsToImage(contains[39]));

		map40.setImage(containsToImage(contains[40]));
		map41.setImage(containsToImage(contains[41]));
		map42.setImage(containsToImage(contains[42]));
		map43.setImage(containsToImage(contains[43]));
		map44.setImage(containsToImage(contains[44]));
		map45.setImage(containsToImage(contains[45]));
		map46.setImage(containsToImage(contains[46]));
		map47.setImage(containsToImage(contains[47]));
		map48.setImage(containsToImage(contains[48]));
		map49.setImage(containsToImage(contains[49]));

		map50.setImage(containsToImage(contains[50]));
		map51.setImage(containsToImage(contains[51]));
		map52.setImage(containsToImage(contains[52]));
		map53.setImage(containsToImage(contains[53]));
		map54.setImage(containsToImage(contains[54]));
		map55.setImage(containsToImage(contains[55]));
		map56.setImage(containsToImage(contains[56]));
		map57.setImage(containsToImage(contains[57]));
		map58.setImage(containsToImage(contains[58]));
		map59.setImage(containsToImage(contains[59]));

		map60.setImage(containsToImage(contains[60]));
		map61.setImage(containsToImage(contains[61]));
		map62.setImage(containsToImage(contains[62]));
		map63.setImage(containsToImage(contains[63]));
		map64.setImage(containsToImage(contains[64]));
		map65.setImage(containsToImage(contains[65]));
		map66.setImage(containsToImage(contains[66]));
		map67.setImage(containsToImage(contains[67]));
		map68.setImage(containsToImage(contains[68]));
		map69.setImage(containsToImage(contains[69]));

		map70.setImage(containsToImage(contains[70]));
		map71.setImage(containsToImage(contains[71]));
		map72.setImage(containsToImage(contains[72]));
		map73.setImage(containsToImage(contains[73]));
		map74.setImage(containsToImage(contains[74]));
		map75.setImage(containsToImage(contains[75]));
		map76.setImage(containsToImage(contains[76]));
		map77.setImage(containsToImage(contains[77]));
		map78.setImage(containsToImage(contains[78]));
		map79.setImage(containsToImage(contains[79]));

		map80.setImage(containsToImage(contains[80]));
		map81.setImage(containsToImage(contains[81]));
		map82.setImage(containsToImage(contains[82]));
		map83.setImage(containsToImage(contains[83]));
		map84.setImage(containsToImage(contains[84]));
		map85.setImage(containsToImage(contains[85]));
		map86.setImage(containsToImage(contains[86]));
		map87.setImage(containsToImage(contains[87]));
		map88.setImage(containsToImage(contains[88]));
		map89.setImage(containsToImage(contains[89]));

		map90.setImage(containsToImage(contains[90]));
		map91.setImage(containsToImage(contains[91]));
		map92.setImage(containsToImage(contains[92]));
		map93.setImage(containsToImage(contains[93]));
		map94.setImage(containsToImage(contains[94]));
		map95.setImage(containsToImage(contains[95]));
		map96.setImage(containsToImage(contains[96]));
		map97.setImage(containsToImage(contains[97]));
		map98.setImage(containsToImage(contains[98]));
		map99.setImage(containsToImage(contains[99]));






	}

	/**
	 * containsの中身を見て、必要なImageオブジェクトで返す(drawMap補助
	 */
	private Image containsToImage(Contains contains) {
		switch(contains.getType()) {
		case HOME:
			return  new Image(ContainsTypes.HOME.getPath());
		case STATION:
			return new Image(ContainsTypes.STATION.getPath());
		case STORE:
			return new Image(ContainsTypes.STORE.getPath());
		case PATH:
			return new Image(ContainsTypes.PATH.getPath());
		case HOME_C:
			return new Image(ContainsTypes.HOME_C.getPath());
		case STATION_C:
			return new Image(ContainsTypes.STATION_C.getPath());
		case STORE_C:
			return new Image(ContainsTypes.STORE_C.getPath());
		default:
			return new Image(ContainsTypes.PATH.getPath());

		}

	}

	/**
	 * 経路表示のためのマップ更新メソッド
	 */
	public void drawRoute() {
		drawMap(CalcRoute.calcRoute(Contains.setDetourSS(CreateMap.createmap(ReadMap.readMap(currentNum)),
				checkStation.isSelected(), checkStore.isSelected())));
	}

	@FXML
	public void onReloadClicked(ActionEvent e) {
		drawMap(CreateMap.createmap(ReadMap.readMap(currentNum)));
	}

	@FXML
	public void onSearchClicked(ActionEvent e){
		drawMap(Contains.setDetourSS(CreateMap.createmap(ReadMap.readMap(currentNum)),
				checkStation.isSelected(), checkStore.isSelected()));
	}

	/**
	 * マップの種類をせんたくするラジオボタンの処理メソッド
	 */
	@FXML
	public void handleRadio() {
		if(radio_map1.isSelected()) {
			currentNum= "1";
		}
		else if(radio_map2.isSelected()) {
			currentNum= "2";
		}
		else if(radio_map3.isSelected()) {
			currentNum= "3";
		}
		else if(radio_map4.isSelected()) {
			currentNum= "4";
		}
		else if(radio_map5.isSelected()) {
			currentNum= "5";
		}
		else if(radio_map6.isSelected()) {
			currentNum= "6";
		}

		System.out.println("Select map: "+ currentNum);
	}

	/**
	 * 起動時の初期化
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO 自動生成されたメソッド・スタブ
		drawMap(CreateMap.createmap(ReadMap.readMap(currentNum)));


	}











}
