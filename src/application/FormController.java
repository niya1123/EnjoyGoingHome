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
import map.CreateMap;
/**
 * GUI処理部
 * MAP生成や検索条件のオンオフを管理
 * アルゴリズムでの処理は他のクラスに投げる.
 * @author kei
 *
 */
public class FormController implements Initializable{
	@FXML public ImageView map00;
	@FXML public ImageView map01;
	@FXML public ImageView map02;
	@FXML public ImageView map03;
	@FXML public ImageView map04;
	@FXML public ImageView map05;
	@FXML public ImageView map06;
	@FXML public ImageView map07;
	@FXML public ImageView map08;
	@FXML public ImageView map09;

	@FXML public ImageView map10;
	@FXML public ImageView map11;
	@FXML public ImageView map12;
	@FXML public ImageView map13;
	@FXML public ImageView map14;
	@FXML public ImageView map15;
	@FXML public ImageView map16;
	@FXML public ImageView map17;
	@FXML public ImageView map18;
	@FXML public ImageView map19;

	@FXML public ImageView map20;
	@FXML public ImageView map21;
	@FXML public ImageView map22;
	@FXML public ImageView map23;
	@FXML public ImageView map24;
	@FXML public ImageView map25;
	@FXML public ImageView map26;
	@FXML public ImageView map27;
	@FXML public ImageView map28;
	@FXML public ImageView map29;

	@FXML public ImageView map30;
	@FXML public ImageView map31;
	@FXML public ImageView map32;
	@FXML public ImageView map33;
	@FXML public ImageView map34;
	@FXML public ImageView map35;
	@FXML public ImageView map36;
	@FXML public ImageView map37;
	@FXML public ImageView map38;
	@FXML public ImageView map39;

	@FXML public ImageView map40;
	@FXML public ImageView map41;
	@FXML public ImageView map42;
	@FXML public ImageView map43;
	@FXML public ImageView map44;
	@FXML public ImageView map45;
	@FXML public ImageView map46;
	@FXML public ImageView map47;
	@FXML public ImageView map48;
	@FXML public ImageView map49;

	@FXML public ImageView map50;
	@FXML public ImageView map51;
	@FXML public ImageView map52;
	@FXML public ImageView map53;
	@FXML public ImageView map54;
	@FXML public ImageView map55;
	@FXML public ImageView map56;
	@FXML public ImageView map57;
	@FXML public ImageView map58;
	@FXML public ImageView map59;

	@FXML public ImageView map60;
	@FXML public ImageView map61;
	@FXML public ImageView map62;
	@FXML public ImageView map63;
	@FXML public ImageView map64;
	@FXML public ImageView map65;
	@FXML public ImageView map66;
	@FXML public ImageView map67;
	@FXML public ImageView map68;
	@FXML public ImageView map69;

	@FXML public ImageView map70;
	@FXML public ImageView map71;
	@FXML public ImageView map72;
	@FXML public ImageView map73;
	@FXML public ImageView map74;
	@FXML public ImageView map75;
	@FXML public ImageView map76;
	@FXML public ImageView map77;
	@FXML public ImageView map78;
	@FXML public ImageView map79;

	@FXML public ImageView map80;
	@FXML public ImageView map81;
	@FXML public ImageView map82;
	@FXML public ImageView map83;
	@FXML public ImageView map84;
	@FXML public ImageView map85;
	@FXML public ImageView map86;
	@FXML public ImageView map87;
	@FXML public ImageView map88;
	@FXML public ImageView map89;

	@FXML public ImageView map90;
	@FXML public ImageView map91;
	@FXML public ImageView map92;
	@FXML public ImageView map93;
	@FXML public ImageView map94;
	@FXML public ImageView map95;
	@FXML public ImageView map96;
	@FXML public ImageView map97;
	@FXML public ImageView map98;
	@FXML public ImageView map99;


	@FXML public Button button_reload;

	@FXML public RadioButton radio_map1;
	@FXML public RadioButton radio_map2;
	@FXML public RadioButton radio_map3;
	@FXML public RadioButton radio_map4;
	@FXML public RadioButton radio_map5;

	@FXML public ToggleGroup mapSelection;


	/**
	 * ImageView の２次元配列
	 */
	public ImageView[][] mapImages= {{map00, map01, map02, map03, map04, map05, map06, map07, map08, map09},
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
		for(int i= 0; i< map.length; i++) {
			for(int j= 0; j< map[i].length; j++) {
				Image image= new Image(getClass().getResourceAsStream(map[i][j].getPath()));
				mapImages[i][j].setImage(image);


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
