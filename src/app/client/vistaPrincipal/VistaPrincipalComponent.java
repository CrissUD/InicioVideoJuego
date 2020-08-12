package app.client.vistaPrincipal;

import javax.swing.JPanel;

import app.services.graphicServices.RecursosService;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaPrincipalComponent implements ActionListener, MouseListener{
    
    private VistaPrincipalTemplate vistaPrincipalTemplate;

    public VistaPrincipalComponent(){
        this.vistaPrincipalTemplate = new VistaPrincipalTemplate(this);
    }

    public VistaPrincipalTemplate getVistaPrincipalTemplate(){
        return  vistaPrincipalTemplate;
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        JPanel panel = (JPanel) e.getSource();
        panel.setBackground(RecursosService.getService().getColorNaranja());
        this.vistaPrincipalTemplate.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JPanel panel = (JPanel) e.getSource();
        System.out.println();
        if(panel.getX() == 535)
            panel.setBackground(RecursosService.getService().getColorVerde());
        else
            panel.setBackground(RecursosService.getService().getColorAzul());
        this.vistaPrincipalTemplate.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}