package Game_version5;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AePlayWave extends  Thread{
    private String fileName;

    public AePlayWave(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void run() {
        File file = new File(fileName);

        AudioInputStream audioInputStream = null;

        try {

            audioInputStream = AudioSystem.getAudioInputStream(file);

        } catch (Exception e) {

            e.printStackTrace();

            return;

        }

        AudioFormat format = audioInputStream.getFormat();

        SourceDataLine auline = null;

        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

        try {

            auline = (SourceDataLine) AudioSystem.getLine(info);

            auline.open(format);

        } catch (Exception e) {

            e.printStackTrace();

            return;

        }

        auline.start();

        int nBytesRead = 0;

        byte[] abbytes = new byte[512];

        try {

            while ((nBytesRead = audioInputStream.read(abbytes, 0, abbytes.length)) != -1) {

                if (nBytesRead >= 0) {

                    auline.write(abbytes, 0, nBytesRead);

                }

            }

        } catch (Exception e) {

            e.printStackTrace();

            return;

        } finally {

            auline.drain();

            auline.close();

        }


    }
}
