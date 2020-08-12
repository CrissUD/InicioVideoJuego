package app.client.vistaPrincipal;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.services.graphicServices.ObjGraficosService;
import app.services.graphicServices.RecursosService;

public class VistaPrincipalTemplate extends JFrame{

    // Declaración servicios e inyección
    private static final long serialVersionUID = 2938531812964878427L;
    private VistaPrincipalComponent vistaPrincipalComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;

    // Declaración objetos gráficos
    private JPanel pFondo, pIzquierda, pCentro, pDerecha;
    private JLabel lFondo, lIcono1, lIcono2, lIcono3;
    private JLabel lTitulo1, lTitulo2, lTitulo3;
    private JButton bCerrar;

    private ImageIcon iFondo, iIcono1, iIcono2, iIcono3, iCerrar, iDimAux;

    public VistaPrincipalTemplate(VistaPrincipalComponent vistaPrincipalComponent){
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        this.sObjGraficos = ObjGraficosService.getService();
        this.sRecursos = RecursosService.getService();

        this.crearObjetosDecoradores();
        this.crearJPanels();
        this.crearJButtons();
        this.crearJLabels();
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize (1300, 700);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void crearObjetosDecoradores(){
        iFondo = new ImageIcon("resources/images/fondo.gif");
        iIcono1 = new ImageIcon("resources/images/aventura.png");
        iIcono2 = new ImageIcon("resources/images/mundo.png");
        iIcono3 = new ImageIcon("resources/images/deporte.png");
        iCerrar = new ImageIcon("resources/images/x.png");
    }

    public void crearJPanels(){
        pFondo = sObjGraficos.construirJPanel(0, 0, 1300, 700, null, null);
        this.add(pFondo);

        pIzquierda = sObjGraficos.construirJPanel(305, 420, 230, 230, sRecursos.getColorAzul(), null);
        pIzquierda.setCursor(sRecursos.getCMano());
        pIzquierda.addMouseListener(this.vistaPrincipalComponent);
        pFondo.add(pIzquierda);

        pCentro = sObjGraficos.construirJPanel(535, 420, 230, 230, sRecursos.getColorVerde(), null);
        pCentro.setCursor(sRecursos.getCMano());
        pCentro.addMouseListener(this.vistaPrincipalComponent);
        pFondo.add(pCentro);

        pDerecha = sObjGraficos.construirJPanel(765, 420, 230, 230, sRecursos.getColorAzul(), null);
        pDerecha.setCursor(sRecursos.getCMano());
        pDerecha.addMouseListener(this.vistaPrincipalComponent);
        pFondo.add(pDerecha);
    }

    public void crearJLabels(){
        iDimAux = new ImageIcon(iIcono1.getImage().getScaledInstance(60, 60, Image.SCALE_AREA_AVERAGING));
        lIcono1 = sObjGraficos.construirJLabel(null, 85, 95, 60, 60, null, iDimAux, null, null, null,  null, "c");
        pIzquierda.add(lIcono1);
        
        iDimAux = new ImageIcon(iIcono2.getImage().getScaledInstance(60, 60, Image.SCALE_AREA_AVERAGING));
        lIcono2 = sObjGraficos.construirJLabel(null, 85, 95, 60, 60, null, iDimAux, null, null, null,  null, "c");
        pCentro.add(lIcono2);
        
        iDimAux = new ImageIcon(iIcono3.getImage().getScaledInstance(60, 60, Image.SCALE_AREA_AVERAGING));
        lIcono3 = sObjGraficos.construirJLabel(null, 85, 95, 60, 60, null, iDimAux, null, null, null,  null, "c");
        pDerecha.add(lIcono3);
        
        lTitulo1 = sObjGraficos.construirJLabel(
            "Aventura", (230 - 150) / 2 , 50, 150, 30, null, null, 
            sRecursos.getFontBotones(), null, Color.WHITE, null, "c"
        );
        pIzquierda.add(lTitulo1);
        
        lTitulo2 = sObjGraficos.construirJLabel(
            "Mundo Abierto", (230 - 150) / 2 , 50, 150, 30, null, null, 
            sRecursos.getFontBotones(), null, Color.WHITE, null, "c"
        );
        pCentro.add(lTitulo2);
        
        lTitulo3 = sObjGraficos.construirJLabel(
            "Deportes", (230 - 150) / 2 , 50, 150, 30, null, null, 
            sRecursos.getFontBotones(), null, Color.WHITE, null, "c"
        );
        pDerecha.add(lTitulo3);

        lFondo = sObjGraficos.construirJLabel(null, 0, 0, 1300, 700,  null, iFondo, null, null, null, null, "l");
        pFondo.add(lFondo);
    }

    public void crearJButtons(){

        iDimAux = new ImageIcon(iCerrar.getImage().getScaledInstance(25, 25, Image.SCALE_AREA_AVERAGING));
        bCerrar = sObjGraficos.construirJButton(
            null, 1250, 15, 25, 25, sRecursos.getCMano(), iDimAux, null, null, null, null, "c", false
        );
        bCerrar.addActionListener(this.vistaPrincipalComponent);
        pFondo.add(bCerrar); 
    }
}