package de.pk.view.visuell.fxmlSzenenController;

import java.net.URL;
import java.util.ResourceBundle;

import de.pk.utils.Spielkonstanten;
import de.pk.view.visuell.fxmlSzenenLayouts.AnwendungFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class DungeonSzeneController implements Initializable
{

	@FXML
	private Label dungeonTitelLabel;
	@FXML
	private ProgressBar dungeonFortschrittProgressBar;
	@FXML
	private Button dungeonMenueButton1;
	@FXML
	private Button dungeonMenueButton2;
	@FXML
	private Button dungeonMenueButton3;
	@FXML
	private Label goldAnzeigeLabel;
	@FXML
	private Label fragmenteAnzeigeLabel;
	@FXML
	private ProgressIndicator grosseLebensPunkteAnzeigeProgressIndicator;
	@FXML
	private Button wirkendeEffekteButton1;
	@FXML
	private Button wirkendeEffekteButton2;
	@FXML
	private Button wirkendeEffekteButton3;
	@FXML
	private Button wirkendeEffekteButton4;
	@FXML
	private Button wirkendeEffekteButton5;
	@FXML
	private Button aktionButton1;
	@FXML
	private Button aktionButton2;
	@FXML
	private Button aktionButton3;
	@FXML
	private Button aktionButton4;
	@FXML
	private Button heldenInventarButton1;
	@FXML
	private Button heldenInventarButton2;
	@FXML
	private Button heldenInventarButton3;
	@FXML
	private Button heldenInventarButton4;
	@FXML
	private ProgressBar erfahrungsPunkteProgressBar;
	@FXML
	private Label erfahrungsPunkteGesamtLevelLabel;
	@FXML
	private ProgressIndicator grosseSpezialFaehigkeitsAnzeigeProgressIndicator;
	@FXML
	private HBox heldenStatusAnzeigeHBox1;
	@FXML
	private ImageView heldenAvatarImageView1;
	@FXML
	private ProgressBar kleineLebensPunkteAnzeigeProgressBar1;
	@FXML
	private ProgressBar kleineSpezialFaehigkeitsAnzeigeProgressBar1;
	@FXML
	private ImageView aktuellerHeldenModusImageView1;
	@FXML
	private ImageView verbleibendePhasenImageView1;
	@FXML
	private ImageView verbleibendePhasenImageView2;
	@FXML
	private ImageView verbleibendePhasenImageView3;
	@FXML
	private HBox heldenStatusAnzeigeHBox2;
	@FXML
	private ImageView heldenAvatarImageView2;
	@FXML
	private ProgressBar kleineLebensPunkteAnzeigeProgressBar2;
	@FXML
	private ProgressBar kleineSpezialFaehigkeitsAnzeigeProgressBar2;
	@FXML
	private ImageView aktuellerHeldenModusImageView2;
	@FXML
	private HBox heldenStatusAnzeigeHBox3;
	@FXML
	private ImageView heldenAvatarImageView3;
	@FXML
	private ProgressBar kleineLebensPunkteAnzeigeProgressBar3;
	@FXML
	private ProgressBar kleineSpezialFaehigkeitsAnzeigeProgressBar3;
	@FXML
	private ImageView aktuellerHeldenModusImageView3;
	@FXML
	private HBox heldenStatusAnzeigeHBox4;
	@FXML
	private ImageView heldenAvatarImageView4;
	@FXML
	private ProgressBar kleineLebensPunkteAnzeigeProgressBar4;
	@FXML
	private ProgressBar kleineSpezialFaehigkeitsAnzeigeProgressBar4;
	@FXML
	private ImageView aktuellerHeldenModusImageView4;


	@FXML
	public void aktionButton1Pressed (ActionEvent event)
	{
		//
	}


	@FXML
	public void aktionButton2Pressed (ActionEvent event)
	{
		//
	}


	@FXML
	public void aktionButton3Pressed (ActionEvent event)
	{
		//
	}


	@FXML
	public void aktionButton4Pressed (ActionEvent event)
	{
		//
	}


	@FXML
	public void dungeonMenueButton1Pressed (ActionEvent event)
	{
		//
	}


	@FXML
	public void dungeonMenueButton2Pressed (ActionEvent event)
	{
		//
	}


	@FXML
	public void dungeonMenueButton3Pressed (ActionEvent event)
	{
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_HAUPTMENUE_SZENE);
	}


	@FXML
	public void heldenInventarButton1Pressed (ActionEvent event)
	{
		//
	}


	@FXML
	public void heldenInventarButton2Pressed (ActionEvent event)
	{//
	}


	@FXML
	public void heldenInventarButton3Pressed (ActionEvent event)
	{
		//
	}


	@FXML
	public void heldenInventarButton4Pressed (ActionEvent event)
	{
		//
	}


	@Override
	public void initialize (URL location, ResourceBundle resources)
	{
		//
	}

}
