/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sounds;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Toshiba
 */
public abstract class AudioController {
       public static void clickSound() {
            String soundFile = AudioController.class.getResource("/audios/gameClick.wav").toExternalForm();
            Media media = new Media(soundFile);
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();        
    }

    
}
