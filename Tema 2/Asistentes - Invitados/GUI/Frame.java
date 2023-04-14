package GUI;

import IO.Totales;
import TDA.Asistentes;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Frame extends JFrame implements ChangeListener, ActionListener, KeyListener, MouseListener { 
    
    // Declaracion de Elementos
    private Totales asistentes = new Totales();
    
    // Nombre   Edad    Sexo    EstadoCivil
    private JLabel labelNombre = new JLabel("Nombre");
    private JLabel labelEdad = new JLabel("Edad");
    private JLabel labelSexo = new JLabel("Sexo");
    private JLabel labelCivil = new JLabel("Estado Civil");
    
    private JTextField nombre = new JTextField();
    private JTextField edad = new JTextField();
    private JCheckBox sexo1 = new JCheckBox("Masculino");
    private JCheckBox sexo2 = new JCheckBox("Femenino");
    private ButtonGroup civil = new ButtonGroup();
    
    private JRadioButton btn1 = new JRadioButton("Soltero");
    private JRadioButton btn2 = new JRadioButton("Casado");
    private JRadioButton btn3 = new JRadioButton("Viudo");
    private JRadioButton btn4 = new JRadioButton("Divorciado");
    
    private JList<Asistentes> lista = new JList<>();
    private ScrollPane scroll = new ScrollPane();
    private DefaultListModel model = new DefaultListModel();
    
    private JButton add = new JButton("Agregar");
    private JButton remove = new JButton("Eliminar");
    private JButton stadistic   = new JButton("<html><body align='center'> Mostrar<p>Estadisticas </body></html>");
    
    private GridBagLayout gb = new GridBagLayout();
    private GridBagConstraints gbc = new GridBagConstraints();
    
    // Constructor
    public Frame(){
        super("Lista de Asistentes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(gb);
        setSize(300, 400);
        setLocationRelativeTo(null);
        inicializar();
        ubicar();
        check();
        agregar();
        // pack();
        asistentes.datosBrutos(model);
        setVisible(true);
    }
    
    // Otros Metodos
    public void inicializar () {
        lista.addMouseListener(this);
        
        civil.add(btn1);
        civil.add(btn2);
        civil.add(btn3);
        civil.add(btn4);
        
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.setModel(model);
        
        scroll.add(lista);
        
        add.setEnabled(false);
        remove.setEnabled(false);
        stadistic.setEnabled(false);
    }
    
    public void ubicar () {
        Insets padding = new Insets(10, 5, 10, 5);
         gbc.fill = GridBagConstraints.BOTH;
         gbc.weightx = 1;
         gbc.weighty = 1;
         gbc.insets = padding;
         
        // Añadir Etiquetas
        gb.setConstraints(labelNombre, gbc);
        gbc.gridy = 1;
        gb.setConstraints(labelEdad, gbc);
        
        gbc.gridheight = 2;
        gbc.gridy = 2;
        gb.setConstraints(labelSexo, gbc);
        gbc.gridy = 4;
        gb.setConstraints(labelCivil, gbc);
        
        // Añadir Campos de Texto
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gb.setConstraints(nombre, gbc);
        gbc.gridy = 1;
        gb.setConstraints(edad, gbc);
        
        padding.set(3, 1, 0, 1);
        gbc.insets = padding;
        gbc.gridy = 2;
        gb.setConstraints(sexo1, gbc);
        padding.set(0, 1, 3, 1);
        gbc.insets = padding;
        gbc.gridy = 3;
        gb.setConstraints(sexo2, gbc);
                
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        padding.set(3, 2, 0, 2);
        gbc.insets = padding;
        gb.setConstraints(btn1, gbc);
        gbc.gridx = 2;
        gb.setConstraints(btn2, gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        padding.set(0, 2, 3, 2);
        gbc.insets = padding;
        gb.setConstraints(btn3, gbc);
        gbc.gridx = 2;
        gb.setConstraints(btn4, gbc);
        
        padding.set(10, 5, 10, 5);
        gbc.gridwidth = 3;
        gbc.insets = padding;
        gbc.gridx = 0;
        gbc.gridy = 6;
        gb.setConstraints(scroll, gbc);
        
        gbc.gridwidth = 1;
        gbc.gridy = 7;
        gb.setConstraints(add, gbc);
        gbc.gridx = 1;
        gb.setConstraints(remove, gbc);
        gbc.gridx = 2;
        gb.setConstraints(stadistic, gbc);
    }
    
    public void agregar () {
        add(labelNombre);
        add(labelEdad);
        add(labelSexo);
        add(labelCivil);
        
        add(nombre);
        add(edad);
        add(sexo1);
        add(sexo2);
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        
        add(scroll);
        
        add(add);
        add(remove);
        add(stadistic);
    }
    
    public void check () {
        nombre.addKeyListener(this);
        edad.addKeyListener(this);
        
        sexo1.addChangeListener(e -> {
            if (sexo1.isSelected())
                sexo2.setSelected(false);
            enaDis();
        });
        sexo2.addChangeListener(e -> {
            if (sexo2.isSelected())
                sexo1.setSelected(false);
            enaDis();
        });
        
        btn1.addChangeListener(this);
        btn2.addChangeListener(this);
        btn3.addChangeListener(this);
        btn4.addChangeListener(this);
        
        add.addActionListener(this);
        remove.addActionListener(this);
        stadistic.addActionListener(this);
    }
    
    public void limpiar() {
        nombre.setText("");
        edad.setText("");
                
        civil.clearSelection();
                
        if (sexo1.isSelected())
            sexo1.setSelected(false);   
        else
            sexo2.setSelected(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String auxSexo = (sexo1.isSelected()) ? sexo1.getText() : sexo2.getText();
            String auxCivil = (btn1.isSelected()) ? btn1.getText() : 
                    (btn2.isSelected()) ? btn2.getText() :
                    (btn3.isSelected()) ? btn3.getText() : btn4.getText();
                
            Asistentes aux = asistentes.crear(nombre.getText(), Byte.parseByte(edad.getText()), auxSexo, auxCivil);
            asistentes.registrar(aux);
            model.addElement(aux);
            limpiar();
        } else if (e.getSource() == remove) {
            Asistentes aux = lista.getSelectedValue();
            int index = lista.getSelectedIndex();
            asistentes.eliminar(aux);
            model.remove(index);
            enaDis();
        } else if (e.getSource() == stadistic) {
            Graficos.crearGraficas(Graficos.edad(asistentes), Graficos.sexo(asistentes),
                    Graficos.civil(asistentes), Graficos.porcentaje(asistentes), asistentes);
        }
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        enaDis();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        enaDis();
    }
    @Override
    public void keyPressed(KeyEvent e) {
        enaDis();
    }
    @Override
    public void keyReleased(KeyEvent e) {
        enaDis();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        enaDis();
    }
    @Override
    public void mousePressed(MouseEvent e) {
        enaDis();
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        enaDis();
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        enaDis();
    }
    @Override
    public void mouseExited(MouseEvent e) {
        enaDis();
    }
    
    // Condiciones
    public boolean evaluaciones () {
        return (checkName() && checkAge() && checkSex() && checkStatus());
    }
    
    private boolean checkName () {
        return nombre.getText().trim().matches("([a-z A-Z]|\\s)+");
    }
    private boolean checkAge () {
        if (edad.getText().matches("\\d{1,3}"))
            return (Integer.parseInt(edad.getText()) > 0 && Integer.parseInt(edad.getText()) < 80);
        return false;
    }
    private boolean checkSex () {
        return (sexo1.isSelected() || sexo2.isSelected());
    }
    private boolean checkStatus () {
        return (btn1.isSelected() || btn2.isSelected() || btn3.isSelected() || btn4.isSelected());
    }
    
    // Habilitar / Deshabilitar los Botonoes
    public void enaDis () {
        add.setEnabled(evaluaciones());
        remove.setEnabled(!lista.isSelectionEmpty());
        stadistic.setEnabled(asistentes.totalAsistentes() > 0);
    }
    
}
