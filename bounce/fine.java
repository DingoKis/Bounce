package bounce;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import java.util.*;

public class fine
{
    int contatore = 0;
    int sleep = 2;
    long time, playtime;
    
    Random caso = new Random();
    
    int velocitaX = 1;
    int velocitaY = 1;
    int posizioneX = 0;
    int posizioneY = 0;
    
    JFrame fullscreen = new JFrame();
    JFrame cornice = new JFrame();
    JButton bottone = new JButton();
    
    int[] dimensioni = new int[2];
    long end;
    String link;
    
    public void setDimensioni(int[] dimensioni)
    {
        this.dimensioni = dimensioni;
    }
    
    public void setEnd(long end)
    {
        this.end = end;
        this.playtime = end/1000;
    }
    
    public void setLink(String link)
    {
        this.link = link;
    }
    
    int large = 256;
    
    public void mostra()
    {
        ImageIcon sfondo = new ImageIcon("src/bounce/cheese.png");
        JLabel etichetta = new JLabel(sfondo);
        fullscreen.add(etichetta);
        fullscreen.setBounds(0, 0, dimensioni[0], dimensioni[1]);
        fullscreen.setUndecorated(true);
        fullscreen.setVisible(true);
        ImageIcon immagine = new ImageIcon(link);
        bottone.setIcon(immagine);
        cornice.setUndecorated(true);
        cornice.add(bottone);
        cornice.setSize(large, large);
        cornice.setAlwaysOnTop(true);
        cornice.show();
    }
    
    public void contatore()
    {
        bottone.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                contatore++;
                int ok = caso.nextInt(9);
                if(ok==0)
                    velocitaX = -velocitaX;
                if(ok==1)
                    velocitaY = -velocitaY;
                if(ok==2)
                {
                    velocitaY = -velocitaY;
                    velocitaX = -velocitaX;
                }
                if(ok==3)
                    if(velocitaX<3&&velocitaX>-3)
                        velocitaX = velocitaX + velocitaX;
                if(ok==4)
                    if(velocitaY<3&&velocitaY>-3)
                        velocitaY = velocitaY + velocitaY;
                if(ok==5)
                {
                    if(velocitaX<3&&velocitaY<3&&velocitaY>-3&&velocitaX>-3)
                    {
                        velocitaY = velocitaY + velocitaY;
                        velocitaX = velocitaX + velocitaX;
                    }
                }
                if(ok==6)
                {
                    do{
                        posizioneX = 1+caso.nextInt(dimensioni[0]-256);
                        posizioneY = 1+caso.nextInt(dimensioni[1]-256);
                    }while(posizioneY+large>=dimensioni[1]/2-large/2&&posizioneY+large<=dimensioni[1]/2+large/2&&posizioneX>=dimensioni[0]/2-large/2&&posizioneX<=dimensioni[0]/2+large/2||posizioneY>=dimensioni[1]/2-large/2&&posizioneY<=dimensioni[1]/2+large/2&&posizioneX+large>=dimensioni[0]/2-large/2&&posizioneX+large<=dimensioni[0]/2+large/2||posizioneY+large>=dimensioni[1]/2-large/2&&posizioneY+large<=dimensioni[1]/2+large/2&&posizioneX+large>=dimensioni[0]/2-large/2&&posizioneX+large<=dimensioni[0]/2+large/2||posizioneX>=dimensioni[0]/2-large/2&&posizioneX<=dimensioni[0]/2+large/2&&posizioneY>=dimensioni[1]/2-large/2&&posizioneY<=dimensioni[1]/2+large/2);
                }
                if(ok==7)
                    do{
                        posizioneY = 1+caso.nextInt(dimensioni[1]-256);
                    }while(posizioneY+large>=dimensioni[1]/2-large/2&&posizioneY+large<=dimensioni[1]/2+large/2&&posizioneX>=dimensioni[0]/2-large/2&&posizioneX<=dimensioni[0]/2+large/2||posizioneY>=dimensioni[1]/2-large/2&&posizioneY<=dimensioni[1]/2+large/2&&posizioneX+large>=dimensioni[0]/2-large/2&&posizioneX+large<=dimensioni[0]/2+large/2||posizioneY+large>=dimensioni[1]/2-large/2&&posizioneY+large<=dimensioni[1]/2+large/2&&posizioneX+large>=dimensioni[0]/2-large/2&&posizioneX+large<=dimensioni[0]/2+large/2||posizioneX>=dimensioni[0]/2-large/2&&posizioneX<=dimensioni[0]/2+large/2&&posizioneY>=dimensioni[1]/2-large/2&&posizioneY<=dimensioni[1]/2+large/2);
                if(ok==8)
                    do{
                        posizioneX = 1+caso.nextInt(dimensioni[0]-256);
                    }while(posizioneY+large>=dimensioni[1]/2-large/2&&posizioneY+large<=dimensioni[1]/2+large/2&&posizioneX>=dimensioni[0]/2-large/2&&posizioneX<=dimensioni[0]/2+large/2||posizioneY>=dimensioni[1]/2-large/2&&posizioneY<=dimensioni[1]/2+large/2&&posizioneX+large>=dimensioni[0]/2-large/2&&posizioneX+large<=dimensioni[0]/2+large/2||posizioneY+large>=dimensioni[1]/2-large/2&&posizioneY+large<=dimensioni[1]/2+large/2&&posizioneX+large>=dimensioni[0]/2-large/2&&posizioneX+large<=dimensioni[0]/2+large/2||posizioneX>=dimensioni[0]/2-large/2&&posizioneX<=dimensioni[0]/2+large/2&&posizioneY>=dimensioni[1]/2-large/2&&posizioneY<=dimensioni[1]/2+large/2);
            }
        });
    }
        
    public void movimento() throws InterruptedException
    {
        time = System.currentTimeMillis();
        end = end + time; 
        JFrame prova= new JFrame();
        prova.setAlwaysOnTop(true);
        prova.setBounds(dimensioni[0]/2-large/2, dimensioni[1]/2-large/2, large, large);
        prova.setUndecorated(true);
        prova.show();
        while(System.currentTimeMillis()<end)
        {
            Thread.sleep(sleep);
            
            posizioneX = posizioneX + velocitaX;
            posizioneY = posizioneY + velocitaY;
            
            cornice.setLocation(posizioneX, posizioneY);
            
            if(posizioneY+large>=dimensioni[1]/2-large/2&&posizioneY+large<=dimensioni[1]/2+large/2&&posizioneX>=dimensioni[0]/2-large/2&&posizioneX<=dimensioni[0]/2+large/2||posizioneY>=dimensioni[1]/2-large/2&&posizioneY<=dimensioni[1]/2+large/2&&posizioneX+large>=dimensioni[0]/2-large/2&&posizioneX+large<=dimensioni[0]/2+large/2||posizioneY+large>=dimensioni[1]/2-large/2&&posizioneY+large<=dimensioni[1]/2+large/2&&posizioneX+large>=dimensioni[0]/2-large/2&&posizioneX+large<=dimensioni[0]/2+large/2||posizioneX>=dimensioni[0]/2-large/2&&posizioneX<=dimensioni[0]/2+large/2&&posizioneY>=dimensioni[1]/2-large/2&&posizioneY<=dimensioni[1]/2+large/2)
            {
                velocitaX = -velocitaX;
                velocitaY = -velocitaY;
            }
            
            if(posizioneX>=dimensioni[0]-256||posizioneX<=0)
                velocitaX=-velocitaX;
            
            if(posizioneY>=dimensioni[1]-256||posizioneY<=0)
                velocitaY=-velocitaY;
        }
    }
    
    public void fine() throws InterruptedException
    {
        fullscreen.hide();
        cornice.hide();
        JFrame fine = new JFrame();
        fine.setLayout(null);
        JLabel ok = new JLabel();
        ok.setBounds(0, 0, large, large);
        String fine1="<html>Congratulations, you hit the target "+contatore+" times in just "+playtime+" seconds!<br>You are good at this game <br>but I'm sure you can do better ☺</html>";
        fine.setBounds(dimensioni[0]/2-large/2, dimensioni[1]/2-large/2, large, large);
        ok.setBounds(25, 25, 200, 200);
        ok.setText(fine1);
        fine.add(ok);
        fine.setUndecorated(true);
        fine.setAlwaysOnTop(true);
        fine.show();
        Thread.sleep(9000);
    }
    
    public void storeScore() throws FileNotFoundException
    {
        File file = new File("src/bounce/scoreboard.txt");
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true)))
        {
            writer.write("Score "+contatore+" hits in "+playtime+" seconds\n");
            writer.newLine();
            writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        System.exit(0);
    }
}