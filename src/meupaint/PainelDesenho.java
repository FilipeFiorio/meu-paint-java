package meupaint;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.util.List;

/**
 *
 * @author filipe
 */
public class PainelDesenho extends JPanel {
        
    private Forma formaTemp;
    private List<Forma> formas;
    
    public PainelDesenho() {
        formas = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.WHITE);
        g.fillRect( 0, 0, getWidth(), getHeight());
        
        g.setColor( Color.BLACK);
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
    }
    
    public void limpar() {
        formas.clear();
        formaTemp = null;
        repaint();
    }
    
}
