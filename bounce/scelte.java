package bounce;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class scelte
{
    Scanner s = new Scanner(System.in);
    
    String link="";
    int durata=0;
    int[] dimensioni = new int[2];
    
    Dimension schermo = Toolkit.getDefaultToolkit().getScreenSize();
        
    public void schermo()
    {
        int altezza = schermo.height;
        int larghezza = schermo.width;
        dimensioni[0] = larghezza;
        dimensioni[1] = altezza;
    }
        
    public int[] getSchermo()
    {
        return dimensioni;
    }
    
    public void tempo() throws InterruptedException
    {
        JFrame riquadro = new JFrame();
        JLabel etichetta = new JLabel();
        String[] timing = {"  10 seconds", "  20 seconds", "  30 seconds", "  40 seconds", "  50 seconds", "  60 seconds"};
        JComboBox tempo = new JComboBox(timing);
        
        riquadro.setLayout(null);
        riquadro.setUndecorated(true);
        riquadro.setBounds(dimensioni[0]/2-200, dimensioni[1]/2-200, 400, 400);
        tempo.setBounds(0, 100, 400, 300);
        tempo.setFont(new Font(timing[2], Font.PLAIN, 50));
        etichetta.setBounds(20, 0, 400, 100);
        etichetta.setText("<html>For how many seconds would you like to play?<br>Reccomended play time for the best experience is 30 seconds</html>");
        
        riquadro.add(etichetta);
        riquadro.add(tempo);
        riquadro.show();
        
        while(durata==0)
        {
        tempo.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String scegliDurata = (String)tempo.getSelectedItem();
                switch (scegliDurata)
                {
                    case "  10 seconds":
                        durata = 10;
                        break;
                
                    case "  20 seconds":
                        durata = 20;
                        break;
                
                    case "  30 seconds":
                        durata = 30;
                        break;
                
                    case "  40 seconds":
                        durata = 40;
                        break;
                
                    case "  50 seconds":
                        durata = 50;
                        break;
                
                    case "  60 seconds":
                        durata = 60;
                        break;
                }
                riquadro.hide();
            }
        }
        );
        Thread.sleep(750);
        }
    }
    
    public void colore() throws InterruptedException
    {
        String choices = "<html>You can choose between different monsters<br>Don't worry, they are equally strong<br>You can choose the color you like more<br>I suggest the color you feel is more noticeable<br>You'll need great reaction time</html>";
        
        JFrame quadro = new JFrame();
        
        String[] colori = {"RED", "GREEN", "BLUE", "████"};
        
        JComboBox palla = new JComboBox(colori);
        
        palla.setSelectedIndex(3);
        
        quadro.setLayout(null);
        quadro.setUndecorated(true);
        JLabel pannello = new JLabel();
        pannello.setText(choices);
        pannello.setBounds(25, 0, 400, 180);
        quadro.setBounds(dimensioni[0]/2-200, dimensioni[1]/2-200, 400, 400);
        quadro.add(pannello);
        palla.setBounds(0, 200, 400, 200);
        quadro.add(pannello);
        quadro.add(palla);
        quadro.show();
        
        while(link=="")
        {
        palla.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String scelta = (String)palla.getSelectedItem();
                switch (scelta)
                {
                    case "RED":
                        link = "src/bounce/red_dot.png";
                        break;
                        
                    case "BLUE":
                        link = "src/bounce/blue_dot.png";
                        break;
                        
                    case "GREEN":
                        link = "src/bounce/green_dot.png";
                        break;
                        
                    case "████":
                        link = "src/bounce/secret_dot.png";
                }
                
                quadro.hide();
            }
        });
        Thread.sleep(750);
        }
    }
    
    public String getColore() throws InterruptedException
    {
        return link;
    }
    
    public int getTempo() throws InterruptedException
    {
        durata = durata * 1000;
        return durata;
    }
    
    public boolean getReady()
    {
        boolean ready = false;
        if(durata>0)
        {
            ready = true;
        }
        
        return ready;
    }
}