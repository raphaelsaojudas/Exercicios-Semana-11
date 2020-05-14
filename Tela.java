import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela extends JFrame implements ActionListener {
   private JTextField txtTexto;
   private JLabel lblTexto;
   private JButton btnMostrar, btnLimpa, btnSai;
   
   public void actionPerformed (ActionEvent e){
      if (e.getSource() == btnMostrar){
         String txt = txtTexto.getText();
         JOptionPane.showMessageDialog (null, "Texto Digitado e:\n" + txt);
      }
      else if (e.getSource() == btnLimpa){
         txtTexto.setText("");
      }
      else if (e.getSource() == btnSai){
         System.exit(0);
      }
   }
   
   public Tela (){
      super ("Mostrar Texto Digitado");
      JPanel painelDadosEntrada = new JPanel (new GridLayout (4, 2));
      JPanel painelEntrada = new JPanel (new FlowLayout());
      txtTexto = new JTextField (30);
      lblTexto = new JLabel ("Digitar texto: ");

      painelDadosEntrada.add(lblTexto);
      painelDadosEntrada.add(txtTexto);
      painelEntrada.add(painelDadosEntrada);
            
      JPanel painelBotoes = new JPanel (new FlowLayout());
      btnMostrar = new JButton ("Mostrar");
      btnLimpa = new JButton ("Limpar");
      btnSai = new JButton ("Sair");
      
      btnMostrar.addActionListener(this);
      btnLimpa.addActionListener(this);
      btnSai.addActionListener(this);
      
      painelBotoes.add(btnMostrar);
      painelBotoes.add(btnLimpa);
      painelBotoes.add(btnSai);
      
      Container painelDeConteudo = getContentPane();
      
      painelDeConteudo.setLayout (new BorderLayout());
      painelDeConteudo.add(painelEntrada, BorderLayout.CENTER);
      painelDeConteudo.add(painelBotoes, BorderLayout.SOUTH);
      
      setSize (410, 150);
      setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo (null);
      setVisible(true);
  
   }  
   public static void main (String [] args){
      SwingUtilities.invokeLater(new Runnable (){
         public void run (){
            new Tela();
         }
      });
   }    
}