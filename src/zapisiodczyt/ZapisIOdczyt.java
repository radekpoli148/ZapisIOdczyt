package zapisiodczyt;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ZapisIOdczyt {

    public static void main(String[] args) 
    {
        try 
        {
            PrintWriter drukarz = new PrintWriter(new FileWriter("Dane.txt"));
            
            drukarz.println(1234);
            //drukarz.flush();//wymuszone zapisanie wszystkiego co znajduje się w buforze
            
            drukarz.close();
            
            //drukarz.println("LALA");// nie zostanie zapisane drukarz jest juz zamknięty
            
            drukarz = new PrintWriter(new FileWriter("Dane.txt", true));
            drukarz.append("Dopis po ponownym otwarciu strumienia");
            drukarz.println();
            drukarz.printf("On ma %d kilogramów oraz %.2f %s wzrostu", 50 , 175.656, "cm");
            drukarz.close();
            
            BufferedReader reader = new BufferedReader(new FileReader("Dane.txt"));
            
            //System.out.println(reader.readLine());
            BufferedWriter writer = new BufferedWriter(new FileWriter("Baza.txt"));
            String tresc = "";
            while((tresc = reader.readLine()) != null)
            {
                writer.write(tresc);
                writer.newLine();
                //System.out.println(tresc);
            }
            writer.close();
            reader.close();
        } 
        catch (IOException ex) 
        {
            System.out.println(ex.getMessage());
        }
        
        //ZapisIOdczyt.test(1, 2, 5, 64.3, "lol czy to tekst????", "XD");
    }
    
    static void test(Object... a)
    {
        for(int i = 0; i < a.length; i++)
        {
            System.out.println(a[i]);
        }
    }
}
