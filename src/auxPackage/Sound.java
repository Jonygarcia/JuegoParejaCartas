package auxPackage;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	
	public void playMusic(URL sound) {
//		Funci�n que ejecuta la m�sica del juego como un loop infinito.
		try {
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInput);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void effectSound(URL sound) {
//		Funci�n que ejecuta efectos de sonido una �nica vez, como el efecto de voltear una carta,
//		la campanita al acertar las parejas o la percusi�n al fallar una pareja.
		try {
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInput);
			clip.loop(0);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
