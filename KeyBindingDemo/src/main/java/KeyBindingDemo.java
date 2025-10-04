/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class KeyBindingDemo extends JFrame {

    private JList<String> itemList;
    private DefaultListModel<String> listModel;

    public KeyBindingDemo() {
        setTitle("Captura de Tecla 'C' con Key Bindings");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Configuración de la interfaz
        listModel = new DefaultListModel<>();
        listModel.addElement("Elemento 1: Seleccionar con 'C'");
        listModel.addElement("Elemento 2");
        listModel.addElement("Elemento 3");

        itemList = new JList<>(listModel);
        JButton myButton = new JButton("Botón de Ejemplo");
        
        // Panel principal para organizar los componentes
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(new JScrollPane(itemList), BorderLayout.CENTER);
        mainPanel.add(myButton, BorderLayout.SOUTH);
        
        add(mainPanel);
        
        // 1. Definir la Acción (AbstractAction)
        Action cKeyAction;
        cKeyAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Comprobamos si hay elementos en la lista
                if (!listModel.isEmpty()) {
                    boolean isSelected = itemList.getSelectionModel().isSelectedIndex(0);
                    
                    // Lógica para alternar la selección y mensaje en consola
                    if (isSelected) {
                        itemList.clearSelection();
                        System.out.println("ACCIÓN 'C' EJECUTADA: Se deseleccionó el primer elemento.");
                    } else {
                        itemList.setSelectedIndex(0);
                        System.out.println("ACCIÓN 'C' EJECUTADA: Se seleccionó el primer elemento.");
                    }
                } else {
                    System.out.println("ACCIÓN 'C' EJECUTADA: Lista vacía. Solo mensaje.");
                }
            }
        };

       
        InputMap inputMap = mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = mainPanel.getActionMap();
        
      
        String actionKey = "toggleCAction";

      
        KeyStroke cKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_C, 0); // 0 significa sin modificadores (Ctrl, Shift, etc.)

        // 4. Registrar la acción en los mapas
        inputMap.put(cKeyStroke, actionKey); // Vincula la tecla al nombre de la acción
        actionMap.put(actionKey, cKeyAction); // Vincula el nombre de la acción al objeto Action
        
        // Configuración final de la ventana
        pack();
        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        // Ejecutar en el hilo de despacho de eventos de Swing (EDT)
        SwingUtilities.invokeLater(KeyBindingDemo::new);
    }
}
