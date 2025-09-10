package meupaint;

import java.awt.Graphics;

/**
 *
 * @author filipe
 */
public class Poligono extends Forma {
    
    private int lados;

    public Poligono(int lados) {
        super();
        this.lados = Math.max(3, lados);
    }

    @Override
    public void desenhar(Graphics g) {
        int centroX = Math.min(x1, x2) + Math.abs(x2 - x1) / 2;
        int centroY = Math.min(y1, y2) + Math.abs(y2 - y1) / 2;
        int raio = Math.min(Math.abs(x2 - x1), Math.abs(y2 - y1)) / 2;

        int[] xPoints = new int[lados];
        int[] yPoints = new int[lados];

        for (int i = 0; i < lados; i++) {
            double angulo = 2 * Math.PI * i / lados - Math.PI / 2;
            xPoints[i] = (int) (centroX + raio * Math.cos(angulo));
            yPoints[i] = (int) (centroY + raio * Math.sin(angulo));
        }

        g.setColor(preenchimento);
        g.fillPolygon(xPoints, yPoints, lados);

        g.setColor(contorno);
        g.drawPolygon(xPoints, yPoints, lados);
    }
}