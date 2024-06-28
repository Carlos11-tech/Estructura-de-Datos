package Estructura_De_Datos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private JComboBox<String> comboBoxArbol;
    private JComboBox<String> comboBoxRecorrido;
    private JTextArea textAreaResultado;

    public VentanaPrincipal() {
        // Configuración de la ventana
        setTitle("Mi Aplicación");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior con opciones
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new GridLayout(2, 2));

        // ComboBox para seleccionar el tipo de árbol
        comboBoxArbol = new JComboBox<>(new String[]{"AVL", "Negro-Rojo", "Binario Simple"});
        panelSuperior.add(new JLabel("Selecciona el tipo de árbol:"));
        panelSuperior.add(comboBoxArbol);

        // ComboBox para seleccionar el tipo de recorrido
        comboBoxRecorrido = new JComboBox<>(new String[]{"Preorden", "Inorden", "Postorden"});
        panelSuperior.add(new JLabel("Selecciona el tipo de recorrido:"));
        panelSuperior.add(comboBoxRecorrido);

        add(panelSuperior, BorderLayout.NORTH);

        // Área de texto para mostrar el resultado del recorrido
        textAreaResultado = new JTextArea();
        add(new JScrollPane(textAreaResultado), BorderLayout.CENTER);

        // Botón para ejecutar el recorrido
        JButton boton = new JButton("Realizar recorrido");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarRecorrido();
            }
        });
        add(boton, BorderLayout.SOUTH);
    }

    private void realizarRecorrido() {
        String tipoArbol = (String) comboBoxArbol.getSelectedItem();
        String tipoRecorrido = (String) comboBoxRecorrido.getSelectedItem();

        if (tipoArbol == null || tipoRecorrido == null) {
            textAreaResultado.setText("Por favor, selecciona una opción válida.");
            return;
        }

        if (tipoArbol.equals("AVL")) {
            ArbolAvl arbolAVL = new ArbolAvl();
            arbolAVL.insertarNodo(5);
            arbolAVL.insertarNodo(3);
            arbolAVL.insertarNodo(7);

            if (tipoRecorrido.equals("Preorden")) {
                textAreaResultado.setText("Recorrido preorden del árbol AVL:\n" + arbolAVL.preOrden());
            } else if (tipoRecorrido.equals("Inorden")) {
                textAreaResultado.setText("Recorrido inorden del árbol AVL:\n" + arbolAVL.inOrden());
            } else if (tipoRecorrido.equals("Postorden")) {
                textAreaResultado.setText("Recorrido postorden del árbol AVL:\n" + arbolAVL.postOrden());
            }
        } else if (tipoArbol.equals("Negro-Rojo")) {
            ArbolNegroRojo arbolRN = new ArbolNegroRojo();
            arbolRN.insertarNodo(10);
            arbolRN.insertarNodo(5);
            arbolRN.insertarNodo(15);

            if (tipoRecorrido.equals("Preorden")) {
                textAreaResultado.setText("Recorrido preorden del árbol Negro-Rojo:\n" + arbolRN.preOrden());
            } else if (tipoRecorrido.equals("Inorden")) {
                textAreaResultado.setText("Recorrido inorden del árbol Negro-Rojo:\n" + arbolRN.inOrden());
            } else if (tipoRecorrido.equals("Postorden")) {
                textAreaResultado.setText("Recorrido postorden del árbol Negro-Rojo:\n" + arbolRN.postOrden());
            }
        } else if (tipoArbol.equals("Binario Simple")) {
            ArbolBinarioSimple arbolBinarioSimple = new ArbolBinarioSimple();
            arbolBinarioSimple.insertarNodo(10);
            arbolBinarioSimple.insertarNodo(5);
            arbolBinarioSimple.insertarNodo(15);

            if (tipoRecorrido.equals("Preorden")) {
                textAreaResultado.setText("Recorrido preorden del árbol Binario Simple:\n" + arbolBinarioSimple.preOrden());
            } else if (tipoRecorrido.equals("Inorden")) {
                textAreaResultado.setText("Recorrido inorden del árbol Binario Simple:\n" + arbolBinarioSimple.inOrden());
            } else if (tipoRecorrido.equals("Postorden")) {
                textAreaResultado.setText("Recorrido postorden del árbol Binario Simple:\n" + arbolBinarioSimple.postOrden());
            }
        }
    }
}

