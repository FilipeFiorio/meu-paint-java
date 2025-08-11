package meupaint;

import java.awt.Graphics;

/**
 *
 * @author filipe
 */
public class Retangulo extends Forma {
    
    @Override
    public void desenhar(Graphics g){
        int x1d = x1 < x2 ? x1 : x2;
        int y1d = y1 < y2 ? y1 : y2;
        
        int x2d = x1 > x2 ? x1 : x2;
        int y2d = y1 > y2 ? y1 : y2;
        
        g = g.create();
        
        g.setColor(preenchimento);
        g.fillRect(x1d, y1d,x2d - x1d ,y2d - y1d);
        g.setColor(contorno);
        g.drawRect(x1d, y1d, x2d - x1d, y2d - y1d);
        
        g.dispose();
    }
        
}
