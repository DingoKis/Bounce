package bounce;
import javax.swing.*;
import java.util.*;

public class fine
{
    public void rossa(int[] dimensioni, int h) throws InterruptedException
    {
        Scanner s = new Scanner(System.in);
        
        JFrame cornice = new JFrame("Red ball bouncing");
        ImageIcon immagine = new ImageIcon("src/bounce/red_dot.png");
        JLabel palla = new JLabel(immagine);
        JPanel pannello = new JPanel();
        JButton tastone = new JButton("");
        
        cornice.add(tastone);
        pannello.add(palla);
        cornice.add(pannello);
        cornice.setSize(305, 305);
        cornice.show();
        
        int z = 1;
        int y = 1;
        int x = 1;
        int k = 1;
        
        int dormi = 2;
        
        long time = System.currentTimeMillis();
        long end = time + h;
        
        while(System.currentTimeMillis()<end)
        {
            Thread.sleep(dormi);
            
            z = x + z;
            k = y + k;
            
            cornice.setLocation(z, k);
            
            if(z==dimensioni[1]-300||z==0)
                x=-x;
            
            if(k==dimensioni[0]-300||k==0)
                y=-y;
        }
        
        cornice.setDefaultCloseOperation(cornice.EXIT_ON_CLOSE);
    }

    public void verde(int[] dimensioni, int h) throws InterruptedException
    {
        Scanner s = new Scanner(System.in);
        
        JFrame cornice = new JFrame("Green ball bouncing");
        ImageIcon immagine = new ImageIcon("src/bounce/green_dot.png");
        JLabel palla = new JLabel(immagine);
        JPanel pannello = new JPanel();
        
        pannello.add(palla);
        cornice.add(pannello);
        cornice.setSize(305, 305);
        cornice.show();
        
        int z = 1;
        int y = 1;
        int x = 1;
        int k = 1;
        
        int dormi = 2;
        
        long time = System.currentTimeMillis();
        long end = time + h;
        
        while(System.currentTimeMillis()<end)
        {
            Thread.sleep(dormi);
            
            z = x + z;
            k = y + k;
            
            cornice.setLocation(z, k);
            
            if(z==dimensioni[1]-300||z==0)
                x=-x;
            
            if(k==dimensioni[0]-300||k==0)
                y=-y;
        }
        
        cornice.setDefaultCloseOperation(cornice.EXIT_ON_CLOSE);
    }

    public void blu(int[] dimensioni, int h) throws InterruptedException
    {
        Scanner s = new Scanner(System.in);
        
        JFrame cornice = new JFrame("Blue dot bouncing");
        ImageIcon immagine = new ImageIcon("src/bounce/blue_dot.png");
        JLabel palla = new JLabel(immagine);
        JPanel pannello = new JPanel();
        
        pannello.add(palla);
        cornice.add(pannello);
        cornice.setSize(305, 305);
        cornice.show();
        
        int z = 1;
        int y = 1;
        int x = 1;
        int k = 1;
        
        int dormi = 2;
        
        long time = System.currentTimeMillis();
        long end = time + h;
        
        while(System.currentTimeMillis()<end)
        {
            Thread.sleep(dormi);
            
            z = x + z;
            k = y + k;
            
            cornice.setLocation(z, k);
            
            if(z==dimensioni[1]-300||z==0)
                x=-x;
            
            if(k==dimensioni[0]-300||k==0)
                y=-y;
        }
        
        cornice.setDefaultCloseOperation(cornice.EXIT_ON_CLOSE);
    }
    
    public void segreto(int[] dimensioni, int h) throws InterruptedException
    {
        Scanner s = new Scanner(System.in);
        
        JFrame cornice = new JFrame("SECRET DISCOVERED !");
        ImageIcon immagine = new ImageIcon("src/bounce/f6cc957c00b34bc9992efcc282d2a9a7_icon.png");
        JLabel palla = new JLabel(immagine);
        JPanel pannello = new JPanel();
        
        pannello.add(palla);
        cornice.add(pannello);
        cornice.setSize(305, 305);
        cornice.show();
        
        int z = 1;
        int y = 1;
        int x = 1;
        int k = 1;
        
        int dormi = 2;
        
        long time = System.currentTimeMillis();
        long end = time + h;
        
        while(System.currentTimeMillis()<end)
        {
            Thread.sleep(dormi);
            
            z = x + z;
            k = y + k;
            
            cornice.setLocation(z, k);
            
            if(z==dimensioni[1]-300||z==0)
                x=-x;
            
            if(k==dimensioni[0]-300||k==0)
                y=-y;
        }
        
        cornice.setDefaultCloseOperation(cornice.EXIT_ON_CLOSE);
    }
}