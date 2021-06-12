
package Formulario;
//Librerias
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.net.URL;

public final class Ventana extends JFrame
{
    //Atributos de la clase
    JPanel panelA,panelB;//Creacion del panel
    JLabel Nombre,Apellidos,Correo,Celular,Foto,GPS,Sexo;
    JButton BT_Enter,BT_Guardar,Eliminar,Modificar,Limpiar,BT_Salir,conexion, agregarFoto;
    DefaultTableModel modelo;
    JTable tabla;
    JComboBox opciones;
    JTextField jt_nombre,jt_apellido,jt_email,jt_cell,jt_GPS;
    public String nombre,apellidos, correo, cell,gps,sexo;
    public String[] Object;
    public int filas;
                         
    //Contructor de la clase
    public Ventana()
    {
       setTitle("Formulario de Contacto");//titulo de mi ventana
       this.setSize(540,500); //Este será el tamaño de la ventana
       //Posición iniciar de la ventana
       //setIconImage(new ImageIcon(getClass().getResource("App_Formulario/src/Imagenes/formulary.png")).getImage());
       setLocationRelativeTo(null);//Centralización de ventana en la pantalla
       Componentes();//Aqui se llama al metodo de los componentes de la ventana
       setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
       setDefaultCloseOperation(EXIT_ON_CLOSE);//Aquí cumple la función de cerrar mi ventana
       setVisible(true);//Hacemos visible la venatana
    }
    
    //Metodo Principal
    public void Componentes()
    {
       PanelA();//Agregamos al constructor de componentes; el constructor del panelA
       PanelB();
       crearCampos();//Agregamos al constructor de componentes; el constructor de las etiquetas
       Botones();//se agregó el constructor de los botones
       Mult_boton();//se agregó el construstor de opciones de boton
       Enter_Datos();//constructor para aceptar datos por teclado
       crearTabla();
       AccionesBoton();//metodo que guardas las acciones de los botones....
    }
    
    //Metodo del panelA de la ventana
    public void PanelA()
    {
        panelA = new JPanel();//instanciamiento del panel
        panelA.setLayout(null);//Posicion por defecto de la etiqueta desactivada
        this.getContentPane().add(panelA);  //Agregacion del panel a la ventana  
    }
    
    //Metodo del panelA de la ventana
    public void PanelB()
    {
        panelB = new JPanel();//instanciamiento del panel
        panelB.setLayout(null);//Posicion por defecto de la etiqueta desactivada
        this.getContentPane().add(panelB);  //Agregacion del panel a la ventana  
    }
    
    //Metodo de etiquetas o campos
    public void crearCampos()
    {
        //Agregamos un borde interno a nuestro panelA
        panelA.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"// Datos Personales //",
         TitledBorder.LEFT,TitledBorder.DEFAULT_POSITION));
        panelB.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),
                "//                                                                   //",
         TitledBorder.LEFT,TitledBorder.DEFAULT_POSITION));
        
        //---------Nombre
        Nombre = new JLabel("Nombre(s) del Contacto:");
        Nombre.setBounds(15,25,160,40);
        Nombre.setForeground(Color.black);//Color de las letras
        Nombre.setFont(new Font("calibri light",Font.ITALIC,14));//Tipo de letra
        panelA.add(Nombre);
        
        //-------Apellidos
        Apellidos = new JLabel("Apellidos del Contacto:");
        Apellidos.setBounds(15,35,250,110);
        Apellidos.setForeground(Color.black);
        Apellidos.setFont(new Font("calibri light",Font.ITALIC,14));//Tipo de letra
        panelA.add(Apellidos);
        
        //------Correo
        Correo = new JLabel("E-mail:");
        Correo.setBounds(15,55,290,180);
        Correo.setForeground(Color.black);
        Correo.setFont(new Font("calibri light",Font.ITALIC,14));//Tipo de letra
        panelA.add(Correo);
        
        //------Celular
        Celular = new JLabel("Celular:");
        Celular.setBounds(190,55,270,180);
        Celular.setForeground(Color.black);
        Celular.setFont(new Font("calibri light",Font.ITALIC,14));//Tipo de letra
        panelA.add(Celular);
        
        //------Dirección
        GPS = new JLabel("Dirección:");
        GPS.setBounds(15,90,320,180);
        GPS.setForeground(Color.black);
        GPS.setFont(new Font("calibri light",Font.ITALIC,14));//Tipo de letra
        panelA.add(GPS);
        
        //-------Sexo
        Sexo = new JLabel("Sexo:");
        Sexo.setBounds(340,85, 390, 195);
        Sexo.setForeground(Color.black);
        Sexo.setFont(new Font("calibri light",Font.ITALIC,14));//Tipo de letra
        panelA.add(Sexo);

        //-----Foto del usuario (etiqueta tipo imagen)
        //ImageIcon ig = new ImageIcon("");
        Foto = new JLabel();
        Foto.setText("                Foto");
        Foto.setBounds(335,45,130,90);//Posicion de la foto
        Foto.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        //Colocando el tamaño que se quiere a la foto
        panelA.add(Foto);//agragamos la foto al panel
    }
    
    //Metodo para agregar datos del usuario
    public void Enter_Datos()
    {
       //-----recibe el nombre
       jt_nombre = new JTextField();// acepta cadena de textos
       jt_nombre.setBounds(15,50,280,20);//posicion
       panelA.add(jt_nombre);
       
       //-----recibe el apellido
       jt_apellido = new JTextField();// acepta cadena de textos
       jt_apellido.setBounds(15,95,280,20);//posicion
       panelA.add(jt_apellido);
       
       //-----recibe el Email
       jt_email = new JTextField();// acepta cadena de textos
       jt_email.setBounds(15,150,170,20);//posicion
       panelA.add(jt_email);
       
       //-----recibe el numero de telefono
       jt_cell = new JTextField();// acepta cadena de textos
       jt_cell.setBounds(190,150,105,20);//posicion
       panelA.add(jt_cell);
       
       //-----recibe la direccion del contacto
       jt_GPS = new JTextField();// acepta cadena de textos
       jt_GPS.setBounds(15,190,280,20);//posicion
       panelA.add(jt_GPS);
    }
    
    //Metodo botones
    public void Botones()
    {
        //------Boton Entrar
        BT_Enter = new JButton("Ir");//instanciamiento del boton
        BT_Enter.setBounds(10,185, 50, 40);//Posicion del boton
        panelB.add(BT_Enter);//agregamos el boton la panel
        
        //------Boton BT_Guardar
        BT_Guardar= new JButton("Guardar");//instanciamiento del boton
        BT_Guardar.setBounds(60,185, 110, 40);//Posicion del boton
        ImageIcon salvar = new ImageIcon("guardar.jpg");//imagen creada
        BT_Guardar.setIcon(new ImageIcon(salvar.getImage().getScaledInstance(25, 20, Image.SCALE_SMOOTH)));
        panelB.add(BT_Guardar);//agregamos el boton la panel
        
        
        //------Boton Eliminar
        Eliminar= new JButton("Eliminar");//instanciamiento del boton
        Eliminar.setBounds(170,185, 90, 40);//Posicion del boton
        panelB.add(Eliminar);//agregamos el boton la panel
        
        //------Boton Modificar
        Modificar= new JButton("Modificar");//instanciamiento del boton
        Modificar.setBounds(250,185, 90, 40);//Posicion del boton
        panelB.add(Modificar);//agregamos el boton la panel
        
        //------Boton Limpiar
        Limpiar= new JButton("Limpiar");//instanciamiento del boton
        Limpiar.setBounds(330,185, 90, 40);//Posicion del boton
        panelB.add(Limpiar);//agregamos el boton la panel
        
        //------Boton BT_Salir
        BT_Salir= new JButton("Salir");//instanciamiento del boton
        BT_Salir.setBounds(420,185, 95, 40);//Posicion del boton
        ImageIcon salir = new ImageIcon("salir.png");//imagen creada
        //Colocando el tamaño que se quiere a la foto
        BT_Salir.setIcon(new ImageIcon(salir.getImage().getScaledInstance(25, 20, Image.SCALE_SMOOTH)));
        panelB.add(BT_Salir);//agregamos el boton la panel
        
        
        //------Boton Probar conexion
        conexion= new JButton("Probar Conexión");//instanciamiento del boton
        conexion.setBounds(20,10, 190, 25);//Posicion del boton
        panelB.add(conexion);//agregamos el boton la panel

        //------Boton Agregar foto
        agregarFoto= new JButton("Agregar Foto");//instanciamiento del boton
         agregarFoto.setBounds(340,138, 120, 25);//Posicion del boton
        panelA.add(agregarFoto);//agregamos el boton la panel
     
    }
    
    public void AccionesBoton()
    {
        //Accion del boton salir...
        ActionListener oir = (ActionEvent e) -> 
        {
             dispose();
        };
        BT_Salir.addActionListener(oir);//Boton que insertará
        
         //-----Acción o Evento del botón agregar
       ActionListener oyente = (ActionEvent e) -> 
       {
           
           modelo.addRow(new Object[filas]);
           nombre = jt_nombre.getText();
           apellidos = jt_apellido.getText();
           correo = jt_email.getText();
           cell = jt_cell.getText();
           gps = jt_GPS.getText();
           //Variable que recibirá el valor generado por el comboBox
           sexo = (String) opciones.getItemAt(opciones.getSelectedIndex());
           
           for(int x=0; x < this.tabla.getColumnCount()-1; x++)
           {
               modelo.setValueAt(this.nombre,filas,0);
               modelo.setValueAt(this.apellidos,filas,1);
               modelo.setValueAt(this.correo,filas,2);
               modelo.setValueAt(this.cell,filas,3);
               modelo.setValueAt(this.gps,filas,4);
               modelo.setValueAt(this.sexo,filas,5);     
           }
           filas++;//según se vaya agregando elementos se va subando una fila más
         
           //Mensaje de agregación de una persona
           JOptionPane.showMessageDialog(null, "¡SE AGREGÓ UNA PERSONA!");
           
        };//fin del evento
        BT_Guardar.addActionListener(oyente);//Boton que insertará
      
    }
    
    //Metodo de boton con opciones multiples
    public void Mult_boton()
    {
        String [] Sexo ={"Seleccione","Masculino","Femenino"};//Arreglo
        opciones = new JComboBox(Sexo);//Boton instanciado
        opciones.setBounds(330, 190, 150, 20);//Localizacion y tamaño
        panelA.add(opciones);//Agregamos al panel el boton de opciones
    }
    
    //Metodo crear Tbla
    public void crearTabla()
    {
        //tabla

        modelo = new DefaultTableModel();
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("E-mail");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Dirección");
        modelo.addColumn("Sexo");
        tabla = new JTable(modelo);
        tabla.setForeground(Color.blue);//color de las letras de las filas
        JScrollPane JS_sp = new JScrollPane(tabla);
        tabla.setEnabled(false);
        JS_sp.setBounds(10, 50, 500, 120);
        panelB.add(JS_sp);
    }
    
}
