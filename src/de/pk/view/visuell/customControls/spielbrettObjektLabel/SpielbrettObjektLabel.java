package de.pk.view.visuell.customControls.spielbrettObjektLabel;

import de.pk.control.spielbrett.spielbrettObjekte.SpielbrettObjekt;
import javafx.scene.control.Label;

public class SpielbrettObjektLabel extends Label
{

	SpielbrettObjekt darstellendesSpielbrettObjekt = null;

	public SpielbrettObjektLabel(SpielbrettObjekt darstellendesSpielbrettObjekt)
	{
		super();
		this.darstellendesSpielbrettObjekt = darstellendesSpielbrettObjekt;
		this.setStyle("-fx-background-color: transparent;" + "-fx-background-repeat: no-repeat;"
				+ "-fx-background-size: stretch;"
				+ "-fx-background-image:  url(\"../../../ressourcen/bildDateien/labelIcons/modus_beispiel.png\");");
	}

}
