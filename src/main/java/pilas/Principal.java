package pilas;

import colas.Colas;  // Importar la clase Colas
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Principal extends JFrame {
    private Pilas pila;
    private Colas cola;
    private JTextArea textArea;
    private JTextField idField;
    private JTextField nombreField;
    private JTextField telefonoField;

    public Principal() {
        pila = new Pilas(10);
        cola = new Colas();

        setTitle("Directorio de Contactos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setEditable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // ID Label
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("ID:"), gbc);

        // ID Text Field
        gbc.gridx = 1;
        idField = new JTextField();
        panel.add(idField, gbc);

        // Nombre Label
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Nombre:"), gbc);

        // Nombre Text Field
        gbc.gridx = 1;
        nombreField = new JTextField();
        panel.add(nombreField, gbc);

        // Teléfono Label
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Teléfono:"), gbc);

        // Teléfono Text Field
        gbc.gridx = 1;
        telefonoField = new JTextField();
        panel.add(telefonoField, gbc);

        // Botones
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;

        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 5, 5));
        JButton agregarPilaButton = new JButton("Agregar Contacto a Pila");
        agregarPilaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarContactoPila();
            }
        });
        buttonPanel.add(agregarPilaButton);

        JButton eliminarPilaButton = new JButton("Eliminar Contacto de Pila");
        eliminarPilaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarContactoPila();
            }
        });
        buttonPanel.add(eliminarPilaButton);

        JButton mostrarPilaButton = new JButton("Mostrar Contactos en Pila");
        mostrarPilaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarContactosPila();
            }
        });
        buttonPanel.add(mostrarPilaButton);

        JButton agregarColaButton = new JButton("Agregar Contacto a Cola");
        agregarColaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarContactoCola();
            }
        });
        buttonPanel.add(agregarColaButton);

        JButton eliminarColaButton = new JButton("Eliminar Contacto de Cola");
        eliminarColaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarContactoCola();
            }
        });
        buttonPanel.add(eliminarColaButton);

        JButton mostrarColaButton = new JButton("Mostrar Contactos en Cola");
        mostrarColaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarContactosCola();
            }
        });
        buttonPanel.add(mostrarColaButton);

        panel.add(buttonPanel, gbc);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    private void agregarContactoPila() {
        try {
            int id = Integer.parseInt(idField.getText());
            String nombre = nombreField.getText();
            String telefono = telefonoField.getText();

            Contacto nuevoContacto = new Contacto(id, nombre, telefono);
            pila.push(nuevoContacto);
            textArea.setText("Contacto agregado a la pila con éxito.");
        } catch (NumberFormatException e) {
            textArea.setText("Error: ID debe ser un número entero.");
        }
    }

    private void eliminarContactoPila() {
        Contacto eliminado = pila.pop();
        if (eliminado != null) {
            textArea.setText("Contacto eliminado de la pila: " + eliminado);
        } else {
            textArea.setText("La Pila está vacía, no hay contacto para eliminar.");
        }
    }

    private void mostrarContactosPila() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contactos en la pila:\n");

        if (pila.isEmpty()) {
            sb.append("La Pila está vacía");
        } else {
            for (int i = pila.size() - 1; i >= 0; i--) {
                sb.append(pila.stck[i]).append("\n");
            }
        }

        textArea.setText(sb.toString());
    }

    private void agregarContactoCola() {
        try {
            int id = Integer.parseInt(idField.getText());
            String nombre = nombreField.getText();
            String telefono = telefonoField.getText();

            Contacto nuevoContacto = new Contacto(id, nombre, telefono);
            cola.insertar(nuevoContacto);
            textArea.setText("Contacto agregado a la cola con éxito.");
        } catch (NumberFormatException e) {
            textArea.setText("Error: ID debe ser un número entero.");
        }
    }

    private void eliminarContactoCola() {
        try {
            Contacto eliminado = cola.extraer();
            textArea.setText("Contacto eliminado de la cola: " + eliminado);
        } catch (RuntimeException e) {
            textArea.setText("La Cola está vacía, no hay contacto para eliminar.");
        }
    }

    private void mostrarContactosCola() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contactos en la cola:\n");

        if (cola.estaVacia()) {
            sb.append("La Cola está vacía");
        } else {
            sb.append(cola.toString());
        }

        textArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
}
