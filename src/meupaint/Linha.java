package meupaint;

import java.awt.Graphics;

/**
 *
 * @author filipe
 */
public class Linha extends Forma {
    
    @Override
    public void desenhar(Graphics g){
        g = g.create();
        
        g.setColor(contorno);
        g.drawLine(x1, y1, x2, y2);
        
        g.dispose();
    }
        
}
