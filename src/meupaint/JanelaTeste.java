package meupaint;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author filipe
 */
public class JanelaTeste extends JFrame {
    
    private JButton botao;
    
    public JanelaTeste() {
        setTitle("Minha Janela Teste");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        botao = new JButton("Clique-me!!!");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("oi");
            }
            
        });
        
        setLayout(new FlowLayout() );
        add(botao);
    }
    
    public static void main(String[] args) {
        JanelaTeste janela = new JanelaTeste();
        janela.setVisible(true);
    }
}
