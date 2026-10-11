package utils;


import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Erros
{
  public static void  mostrarErro(String erro,Container container)
  {

    // Cria o JOptionPane por showMessageDialog
    JOptionPane.showMessageDialog(container, erro, "ERRO",JOptionPane.ERROR_MESSAGE);
  }
}