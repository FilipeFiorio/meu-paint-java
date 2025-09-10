package meupaint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author filipe
 */
public class PainelDesenho extends JPanel {
        
    private Forma formaTemp;
    private List<Forma> formas;
    private Stack<Forma> pilhaRefazer; 
    
    public PainelDesenho() {
        formas = new ArrayList<>();
        pilhaRefazer = new Stack<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g.setColor(Color.WHITE);
        g.fillRect( 0, 0, getWidth(), getHeight());
        
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
    
        for(Forma forma : formas) {
            forma.desenhar(g);
        }
                
        if(formaTemp != null) {
            formaTemp.desenhar(g);
        } 
    }

    public void setFormaTemp(Forma formaTemp) {
        this.formaTemp = formaTemp;
    }
    
    public void addForma(Forma forma) {
        formas.add(forma);
        pilhaRefazer.clear(); 
    }
    
    public void limpar() {
        formas.clear();
        pilhaRefazer.clear();
        formaTemp = null;
        repaint();
    }

    public void desfazer() {
        if (!formas.isEmpty()) {
            Forma ultimaForma = formas.remove(formas.size() - 1);
            pilhaRefazer.push(ultimaForma);
            repaint();
        }
    }
    
    public void refazer() {
        if (!pilhaRefazer.isEmpty()) {
            Forma formaParaRefazer = pilhaRefazer.pop();
            formas.add(formaParaRefazer);
            repaint();
        }
    }
}
