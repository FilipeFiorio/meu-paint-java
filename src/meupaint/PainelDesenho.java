package meupaint;

import java.awt.Color;
import java.awt.Graphics;
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
    
    // Declara a pilha que guardará as formas desfeitas, para poderem ser refeitas.
    private Stack<Forma> pilhaRefazer; 
    
    public PainelDesenho() {
        formas = new ArrayList<>();
        // Inicialização da pilha
        pilhaRefazer = new Stack<>();
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
        // Limpa a pilha de refazer
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
        // Verifica se a pilha de refazer não está vazia.
        if (!pilhaRefazer.isEmpty()) {
            // Remove a forma do topo da pilha 
            Forma formaParaRefazer = pilhaRefazer.pop();
            formas.add(formaParaRefazer);
            repaint();
        }
    }
}