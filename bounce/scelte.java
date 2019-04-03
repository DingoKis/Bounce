package bounce;
import java.util.Scanner;
import java.awt.*;

public class scelte
{
    public void costruisci() throws InterruptedException
    {   
        Scanner s = new Scanner(System.in);
    
        Dimension schermo = Toolkit.getDefaultToolkit().getScreenSize();
    
        int altezza = schermo.height;
        int larghezza = schermo.width;
        int[] dimensioni = new int[2];
        dimensioni[1] = larghezza;
        dimensioni[0] = altezza;
        
        fine finale = new fine();
        
        System.out.print("Write 1 for the red bouncy ball\nWrite 2 for the green bouncy ball\nWrite 3 for the blue bouncy ball\n");
        int colore = s.nextInt();
        
        int h;
        do
        {
            System.out.println("For how many seconds would you like to see the ball bouncing?");
            h = s.nextInt();
        }while(h<0);
        h = h*1000;
            
        switch (colore)
        {
                case 1:
                    finale.rossa(dimensioni, h);
                    break;
        
                case 2:
                    finale.verde(dimensioni, h);
                    break;
        
                case 3:
                    finale.blu(dimensioni, h);
                    break;
                
                default:
                    finale.segreto(dimensioni, h);
                    break;
        }
    }
}
