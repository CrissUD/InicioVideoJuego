package app.services.graphicServices;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.FontFormatException;

import java.io.File;
import java.io.IOException;

/** @author Cristian Felipe Patiño Cáceres */

public class RecursosService {

    // Declaración Objetos Decoradores
    private Color colorVerde, colorNaranja, colorAzul;
    private Font fontBotones;
    private Cursor cMano;

    static private RecursosService servicio;

    private RecursosService(){
        this.generarFuente();

        this.colorAzul = new Color(1, 141, 209, 100);
        this.colorVerde = new Color(60, 209, 128, 100);
        this.colorNaranja = new Color(255, 193, 47, 100);
        this.fontBotones = new Font("Francois One", Font.PLAIN, 22);
        this.cMano = new Cursor(Cursor.HAND_CURSOR);
    }

    public void generarFuente(){
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(
                Font.TRUETYPE_FONT, new File("resources/fonts/FrancoisOne-Regular.ttf"))
            );
        } catch (IOException|FontFormatException e) {
            System.out.println(e);
            
        }
    }

    public Color getColorAzul(){
        return colorAzul;
    }

    public Color getColorNaranja(){
        return colorNaranja;
    }

    public Color getColorVerde(){
        return colorVerde;
    }

    public Font getFontBotones(){
        return fontBotones;
    }

    public Cursor getCMano(){
        return cMano;
    }

    public static RecursosService getService(){
        if(servicio == null)
            servicio = new RecursosService();
        return servicio;
    }
}