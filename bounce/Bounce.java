package bounce;

import java.io.FileNotFoundException;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Bounce
{
    public static void main(String[] args) throws InterruptedException, FileNotFoundException
    {
        JFrame intro = new JFrame();
        JLabel introText = new JLabel();
        intro.setUndecorated(true);
        intro.setLayout(null);
        
        String benvenuto = "<html>THIS GAME IS VERY HARD<br>It lets you hit monsters bouncing off the screen borders for the chosen time<br>You'll notice that hitting the target may have adverse effects and increase the difficulty<br>Your score will be shown at the end of the match<br>Time to play now. have fun!</html>";
        
        introText.setText(benvenuto);
        introText.setBounds(25, 25, 200, 200);
        intro.add(introText);
        
        scelte esegui = new scelte();
        
        esegui.schermo();
        
        int size = 256;
        
        int tempo;
        String link;
        int[] schermo = new int[2];
        
        schermo = esegui.getSchermo();
        intro.setBounds(schermo[0]/2-size/2, schermo[1]/2-size/2, size, size);
        intro.show();
        Thread.sleep(7500);
        intro.hide();
        
        esegui.tempo();
        esegui.colore();
        link = esegui.getColore();
        tempo = esegui.getTempo();
        
        do
        {
            Thread.sleep(100);
            if(esegui.getReady()==true)
            {
                fine gioco = new fine();
                gioco.setDimensioni(schermo);
                gioco.setEnd(tempo);
                gioco.setLink(link);
                gioco.mostra();
                gioco.contatore();
                gioco.movimento();
                gioco.fine();
                gioco.storeScore();
            }
        }while(esegui.getReady()==false);
    }
}
