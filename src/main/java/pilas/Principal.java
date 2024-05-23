package pilas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Principal extends JFrame {
    private Pilas pila;
    private JTextArea textArea;
    private JTextField idField;
    private JTextField nombreField;
    private JTextField telefonoField;

    public Principal() {
        pila = new Pilas(10);

        setTitle("Directorio de Contactos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setEditable(false);

        JPanel panel = new JPanel(new GridLayout(5, 2));

        panel.add(new JLabel("ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        panel.add(nombreField);

        panel.add(new JLabel("Teléfono:"));
        telefonoField = new JTextField();
        panel.add(telefonoField);

        JButton agregarButton = new JButton("Agregar Contacto");
        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarContacto();
            }
        });
        panel.add(agregarButton);

        JButton eliminarButton = new JButton("Eliminar Contacto");
        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarContacto();
            }
        });
        panel.add(eliminarButton);

        JButton mostrarButton = new JButton("Mostrar Contactos");
        mostrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarContactos();
            }
        });
        panel.add(mostrarButton);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    private void agregarContacto() {
        try {
            int id = Integer.parseInt(idField.getText());
            String nombre = nombreField.getText();
            String telefono = telefonoField.getText();

            Contacto nuevoContacto = new Contacto(id, nombre, telefono);
            pila.push(nuevoContacto);
            textArea.setText("Contacto agregado con éxito.");
        } catch (NumberFormatException e) {
            textArea.setText("Error: ID debe ser un número entero.");
        }
    }

    private void eliminarContacto() {
        Contacto eliminado = pila.pop();
        if (eliminado != null) {
            textArea.setText("Contacto eliminado: " + eliminado);
        } else {
            textArea.setText("La Pila está vacía, no hay contacto para eliminar.");
        }
    }

   private void mostrarContactos() {
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
}
