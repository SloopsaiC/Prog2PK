/**
 *
 */
package de.pk.view.audio;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import de.pk.utils.MatheUtils;

/**
 * @author Dylan
 */
public class AudioSchnipsel implements Closeable
{

	public static final int MAXIMALE_PROZENTUALE_LAUTSTAERKE = 100;
	public static final int MINIMALE_PROZENTUALE_LAUTSTAERKE = 0;
	public static final int START_FRAME = 0;
	private static final int LAUTSTAERKE_DEZIBEL_UMRECHNUNGS_FAKTOR = 40;
	private static final int SLEEP_DAUER_LAUTSTAERKE_FADE = 75;

	private Clip audioClip = null;
	private FloatControl lautstaerkeControl = null;
	private int prozentualeLautstaerke = MINIMALE_PROZENTUALE_LAUTSTAERKE;

	public AudioSchnipsel(String dateipfad, int lautstaerke)
	{
		try
		{
			this.audioClip = AudioSystem.getClip();
			this.audioClip.open(AudioSystem.getAudioInputStream(new File(dateipfad)));
			this.lautstaerkeControl = (FloatControl) this.audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			this.prozentualeLautstaerke = lautstaerke;
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex)
		{
			//
		}
	}

	public void abspielen(boolean einblenden)
	{
		if (this.istBeendet())
		{
			this.stoppen(false);
		}
		this.audioClip.start();
		if (einblenden && !this.istAktivAbspielend())
		{
			this.passeLautstaerkeKontinuierlichAn(this.prozentualeLautstaerke,
					AudioSchnipsel.MINIMALE_PROZENTUALE_LAUTSTAERKE);
		} else
		{
			this.setzeDezibelLautstaerkeAusProzentualerAngabe(this.prozentualeLautstaerke);
		}
	}

	/**
	 * Schliesst den aktuellen AudioSchnipsel.
	 */
	@Override
	public void close()
	{
		this.audioClip.close();
	}

	public int getFramePosition()
	{
		return this.audioClip.getFramePosition();
	}

	public int getProzentualeLautstaerke()
	{
		return this.prozentualeLautstaerke;
	}

	public boolean istAktivAbspielend()
	{
		return this.audioClip.isActive() && this.audioClip.isRunning();
	}

	public boolean istBeendet()
	{
		return (this.audioClip.getFramePosition() == this.audioClip.getFrameLength());
	}

	private void passeLautstaerkeKontinuierlichAn(int neueProzentualeLautstaerke, int alteProzentualeLautstaerke)
	{
		try
		{
			for (int aktuelleLautstaerke = alteProzentualeLautstaerke; aktuelleLautstaerke < neueProzentualeLautstaerke; aktuelleLautstaerke++)
			{ // lauter
				this.setzeDezibelLautstaerkeAusProzentualerAngabe(aktuelleLautstaerke);
				Thread.sleep(AudioSchnipsel.SLEEP_DAUER_LAUTSTAERKE_FADE);
			} // leiser
			for (int aktuelleLautstaerke = alteProzentualeLautstaerke; aktuelleLautstaerke > neueProzentualeLautstaerke; aktuelleLautstaerke--)
			{
				this.setzeDezibelLautstaerkeAusProzentualerAngabe(aktuelleLautstaerke);
				Thread.sleep(AudioSchnipsel.SLEEP_DAUER_LAUTSTAERKE_FADE);
			}
		} catch (InterruptedException e)
		{
			//
		}
	}

	public int pausieren(boolean ausblenden)
	{
		if (ausblenden && this.istAktivAbspielend())
		{
			this.passeLautstaerkeKontinuierlichAn(AudioSchnipsel.MINIMALE_PROZENTUALE_LAUTSTAERKE,
					this.prozentualeLautstaerke);
		}
		this.audioClip.stop();
		return this.getFramePosition();
	}

	public void setFramePosition(int framePosition)
	{
		this.audioClip.setFramePosition(framePosition);
	}

	public void setProzentualeLautstaerke(int prozentWert, boolean kontinuierlich)
	{
		int alteLautstaerke = this.prozentualeLautstaerke;
		this.prozentualeLautstaerke = MatheUtils.begrenzeWertAufMinMax(prozentWert,
				AudioSchnipsel.MINIMALE_PROZENTUALE_LAUTSTAERKE, AudioSchnipsel.MAXIMALE_PROZENTUALE_LAUTSTAERKE);
		if (kontinuierlich)
		{
			this.passeLautstaerkeKontinuierlichAn(this.prozentualeLautstaerke, alteLautstaerke);
		} else
		{
			this.setzeDezibelLautstaerkeAusProzentualerAngabe(this.prozentualeLautstaerke);
		}

	}

	private void setzeDezibelLautstaerkeAusProzentualerAngabe(int prozentualeLautstaerke)
	{
		this.lautstaerkeControl.setValue((float) (AudioSchnipsel.LAUTSTAERKE_DEZIBEL_UMRECHNUNGS_FAKTOR
				* Math.log10(MatheUtils.begrenzeWertAufMinMax(prozentualeLautstaerke,
						AudioSchnipsel.MINIMALE_PROZENTUALE_LAUTSTAERKE,
						AudioSchnipsel.MAXIMALE_PROZENTUALE_LAUTSTAERKE)
						/ (float) AudioSchnipsel.MAXIMALE_PROZENTUALE_LAUTSTAERKE)));
	}

	public void stoppen(boolean ausblenden)
	{
		if (ausblenden && this.istAktivAbspielend())
		{
			this.passeLautstaerkeKontinuierlichAn(AudioSchnipsel.MINIMALE_PROZENTUALE_LAUTSTAERKE,
					this.prozentualeLautstaerke);
		}
		this.audioClip.stop();
		this.audioClip.flush();
		this.setFramePosition(AudioSchnipsel.START_FRAME);
	}

}
