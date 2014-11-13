import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.Font;
import java.util.LinkedList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.Printable;
import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.pdf.PdfLine;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
public class InterfazGuatemala extends JFrame {

	public static LinkedList contenedor = new LinkedList();
public int Encontrado;

	private JPanel contentPane;
	private JTextField Nombre;
	private JTextField Nit;
	private JTextField Telefono;
	private JTextField Tipodehabitacion;
	private JTextField direccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazGuatemala frame = new InterfazGuatemala();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazGuatemala() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Datos personales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(10, 11, 276, 95);
		contentPane.add(panel);

		JLabel label = new JLabel("Nombre");
		label.setBounds(20, 23, 46, 14);
		panel.add(label);

		JLabel label_1 = new JLabel("No.  telefono");
		label_1.setBounds(20, 45, 68, 14);
		panel.add(label_1);

		JLabel label_2 = new JLabel("NIT");
		label_2.setBounds(20, 70, 46, 14);
		panel.add(label_2);

		Nombre = new JTextField();
		Nombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				//int tecla =Event.getKeyEventChar();
				int tecla = evt.getKeyChar();
				if (tecla == 10){
					String nombre = Nombre.getText().trim();
					Guatemala u;
					for(int i = 0; i< contenedor.size();i++){
										
				u=(Guatemala) contenedor.get(i);
				
				if(nombre.equalsIgnoreCase(u.getNombre())){
						
					Nit.setText(u.getNit());
					Tipodehabitacion.setText(u.getTipodehabitaciones());
					Telefono.setText(u.getTelefono());	
				
					Encontrado =i;
					
					//Piso.setSelectedItem().toString();
					/*Nohabitaciones.setValue(u.getNohabitaciones());
					Piso.setSelectedItem(u.getPiso());
					Diashospedaje.setValue(u.getDiashospedaje());
					Formapago.setSelectedItem(u.getFormadepago());
					Mes.setSelectedItem(u.getMes());
					Dia.setValue(u.getDia()).toString();*/
				break;
		
				}
					}
				}
			}
			
		}	
			);
		Nombre.setColumns(10);
		Nombre.setBounds(91, 20, 175, 19);
		panel.add(Nombre);

		Nit = new JTextField();
		Nit.setColumns(10);
		Nit.setBounds(91, 67, 175, 19);
		panel.add(Nit);

		Telefono = new JTextField();
		Telefono.setColumns(10);
		Telefono.setBounds(91, 42, 175, 19);
		panel.add(Telefono);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Datos personales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(211, 211, 211));
		panel_1.setBounds(10, 117, 276, 253);
		contentPane.add(panel_1);

		JLabel label_3 = new JLabel("No. habitaciones");
		label_3.setBounds(10, 20, 80, 14);
		panel_1.add(label_3);

		JSpinner Nohabitaciones =  new JSpinner();
		Nohabitaciones.setBounds(118, 16, 37, 23);
		panel_1.add(Nohabitaciones);

		JLabel label_4 = new JLabel("Tipo de habitaci\u00F3n");
		label_4.setBounds(10, 50, 98, 23);
		panel_1.add(label_4);

		Tipodehabitacion = new JTextField();
		Tipodehabitacion.setColumns(10);
		Tipodehabitacion.setBounds(118, 50, 133, 23);
		panel_1.add(Tipodehabitacion);

		JComboBox Piso = new JComboBox();
		Piso.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		Piso.setBounds(118, 81, 37, 20);
		panel_1.add(Piso);

		JSpinner Diashospedaje = new JSpinner();
		Diashospedaje.setModel(new SpinnerNumberModel(0, 0, 15, 1));
		Diashospedaje.setBounds(118, 112, 37, 23);
		panel_1.add(Diashospedaje);

		JComboBox Formapago = new JComboBox();
		Formapago.setModel(new DefaultComboBoxModel(new String[] {"Tarjeta de debito.", "Tarjeta de credito.", "Cheque.", "Contado"}));
		Formapago.setBounds(118, 146, 131, 23);
		panel_1.add(Formapago);

		JComboBox Mes = new JComboBox();
		Mes.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo ", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Noviembre ", "Diciembre"}));
		Mes.setBounds(153, 206, 82, 20);
		panel_1.add(Mes);

		JLabel label_5 = new JLabel("Mes");
		label_5.setBounds(121, 209, 22, 14);
		panel_1.add(label_5);

		JSpinner Dia = new JSpinner();
		Dia.setModel(new SpinnerNumberModel(1, 1, 15, 1));
		Dia.setBounds(67, 205, 37, 23);
		panel_1.add(Dia);

		JLabel label_6 = new JLabel("Dia");
		label_6.setBounds(35, 209, 22, 14);
		panel_1.add(label_6);

		JLabel label_7 = new JLabel("Fecha de reservac\u00F3n");
		label_7.setBounds(10, 180, 113, 14);
		panel_1.add(label_7);

		JLabel label_8 = new JLabel("Forma de pago");
		label_8.setBounds(10, 146, 80, 23);
		panel_1.add(label_8);

		JLabel label_9 = new JLabel("Dias de hospedaje");
		label_9.setBounds(10, 121, 98, 14);
		panel_1.add(label_9);

		JLabel label_10 = new JLabel("Piso");
		label_10.setBounds(10, 84, 46, 14);
		panel_1.add(label_10);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Servicios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(new Color(211, 211, 211));
		panel_2.setBounds(306, 11, 196, 173);
		contentPane.add(panel_2);

		JLabel label_11 = new JLabel("Gimnacio");
		label_11.setBounds(20, 48, 68, 14);
		panel_2.add(label_11);

		JLabel label_12 = new JLabel("Discoteca");
		label_12.setBounds(20, 73, 46, 14);
		panel_2.add(label_12);

		JLabel label_13 = new JLabel("Centro de convenciones");
		label_13.setBounds(20, 98, 125, 14);
		panel_2.add(label_13);

		JLabel label_14 = new JLabel("Anfiteatro");
		label_14.setBounds(20, 123, 54, 14);
		panel_2.add(label_14);

		JLabel label_15 = new JLabel("Master Snack");
		label_15.setBounds(20, 148, 68, 14);
		panel_2.add(label_15);

		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(155, 70, 29, 20);
		panel_2.add(spinner_3);

		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(155, 95, 29, 20);
		panel_2.add(spinner_4);

		JSpinner spinner_5 = new JSpinner();
		spinner_5.setBounds(155, 120, 29, 20);
		panel_2.add(spinner_5);

		JSpinner spinner_6 = new JSpinner();
		spinner_6.setBounds(155, 45, 29, 20);
		panel_2.add(spinner_6);

		JSpinner spinner_7 = new JSpinner();
		spinner_7.setBounds(155, 145, 29, 20);
		panel_2.add(spinner_7);

		JLabel label_16 = new JLabel("Personas a asistir:");
		label_16.setBounds(100, 21, 96, 14);
		panel_2.add(label_16);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(null, "Precios servicios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBackground(new Color(112, 128, 144));
		panel_3.setBounds(512, 21, 258, 164);
		contentPane.add(panel_3);

		JLabel label_17 = new JLabel("Gimnacio");
		label_17.setBounds(21, 30, 60, 14);
		panel_3.add(label_17);

		JLabel label_18 = new JLabel("Discoteca");
		label_18.setBounds(21, 62, 60, 14);
		panel_3.add(label_18);

		JLabel label_19 = new JLabel("Centro de convenciones");
		label_19.setBounds(21, 87, 123, 14);
		panel_3.add(label_19);

		JLabel label_20 = new JLabel("Anfiteatro");
		label_20.setBounds(21, 112, 70, 14);
		panel_3.add(label_20);

		JLabel label_21 = new JLabel("Master Snack");
		label_21.setBounds(21, 144, 87, 14);
		panel_3.add(label_21);

		JLabel label_22 = new JLabel("Q. 35.00 por persona");
		label_22.setBounds(143, 30, 117, 14);
		panel_3.add(label_22);

		JLabel label_23 = new JLabel("Q. 290.00 por grupo");
		label_23.setBounds(143, 87, 117, 14);
		panel_3.add(label_23);

		JLabel label_24 = new JLabel("Q. 39.00 por persona");
		label_24.setBounds(143, 112, 117, 14);
		panel_3.add(label_24);

		JLabel label_25 = new JLabel("Q. 40.00 por persona");
		label_25.setBounds(143, 144, 117, 14);
		panel_3.add(label_25);

		JLabel label_26 = new JLabel("Q. 18.00 por persona");
		label_26.setBounds(143, 62, 117, 14);
		panel_3.add(label_26);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Restaurantes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBackground(new Color(211, 211, 211));
		panel_4.setBounds(331, 195, 402, 173);
		contentPane.add(panel_4);

		JLabel label_27 = new JLabel("Rest. Mayan Place");
		label_27.setBounds(10, 48, 103, 14);
		panel_4.add(label_27);

		JLabel label_28 = new JLabel("Personas a asistir:");
		label_28.setBounds(125, 26, 96, 14);
		panel_4.add(label_28);

		JSpinner spinner_8 = new JSpinner();
		spinner_8.setBounds(160, 70, 29, 20);
		panel_4.add(spinner_8);

		JSpinner spinner_9 = new JSpinner();
		spinner_9.setBounds(160, 95, 29, 20);
		panel_4.add(spinner_9);

		JSpinner spinner_10 = new JSpinner();
		spinner_10.setBounds(160, 120, 29, 20);
		panel_4.add(spinner_10);

		JSpinner spinner_11 = new JSpinner();
		spinner_11.setBounds(160, 45, 29, 20);
		panel_4.add(spinner_11);

		JSpinner spinner_12 = new JSpinner();
		spinner_12.setBounds(160, 145, 29, 20);
		panel_4.add(spinner_12);

		JLabel label_29 = new JLabel("Rest. Mayan Nights");
		label_29.setBounds(10, 73, 103, 14);
		panel_4.add(label_29);

		JLabel label_30 = new JLabel("Rest. Italian Noodles");
		label_30.setBounds(10, 98, 103, 14);
		panel_4.add(label_30);

		JLabel label_31 = new JLabel("Rest. Mediterranean Flavor");
		label_31.setBounds(10, 123, 139, 14);
		panel_4.add(label_31);

		JLabel label_32 = new JLabel("Rest. y bar Mayan Grill");
		label_32.setBounds(10, 148, 125, 14);
		panel_4.add(label_32);

		JLabel label_33 = new JLabel("Eligir especialidades:");
		label_33.setBounds(262, 26, 125, 14);
		panel_4.add(label_33);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(245, 45, 139, 20);
		panel_4.add(comboBox_3);

		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(245, 70, 139, 20);
		panel_4.add(comboBox_4);

		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(245, 95, 139, 20);
		panel_4.add(comboBox_5);

		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(245, 120, 139, 20);
		panel_4.add(comboBox_6);

		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBounds(245, 145, 139, 20);
		panel_4.add(comboBox_7);

		JButton button = new JButton("Listo");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String nombre= Nombre.getText();
				String nit= Nit.getText();
				String nohabitaciones = Nohabitaciones.getValue().toString();
				String tipodehabitaciones= Tipodehabitacion.getText();
				String piso = Piso.getSelectedItem().toString();
				String diashospedaje = Diashospedaje.getValue().toString();
				String formadepago= Formapago.getSelectedItem().toString();
				String mes = Mes.getSelectedItem().toString();
				int dia= (int) Dia.getValue();

				Guatemala clase = new Guatemala(nombre, nit, nohabitaciones, tipodehabitaciones, piso, diashospedaje, formadepago, mes, dia);
				contenedor.add(clase);
			
				Nombre.setText("");
			    Telefono.setText("");
				Nit.setText("");
				Tipodehabitacion.setText("");

			}
		});
		button.setForeground(new Color(250, 250, 210));
		button.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 12));
		button.setBackground(new Color(47, 79, 79));
		button.setBounds(10, 394, 89, 23);
		contentPane.add(button);

		JButton btnVerRegistro = new JButton("Ver registro");
		btnVerRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {   //Este e3s el boton ver registro que tiene que cambiar la accion del "get text"
				
				Lista l= new Lista();
				l.setVisible(true);
				
			}
		});
		btnVerRegistro.setForeground(new Color(250, 250, 210));
		btnVerRegistro.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 12));
		btnVerRegistro.setBackground(new Color(47, 79, 79));
		btnVerRegistro.setBounds(109, 394, 89, 23);
		contentPane.add(btnVerRegistro);

		JButton Eliminar = new JButton("Eliminar");
		Eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contenedor.remove(Encontrado);
				Nombre.setText("");
			    Telefono.setText("");
				Nit.setText("");
				Tipodehabitacion.setText("");
							}
		});
		Eliminar.setForeground(new Color(250, 250, 210));
		Eliminar.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 12));
		Eliminar.setBackground(new Color(47, 79, 79));
		Eliminar.setBounds(306, 394, 89, 23);
		contentPane.add(Eliminar);
		
		JButton actualizar = new JButton("Actualizar");
		actualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {	
				String nombre= Nombre.getText();
				String nit= Nit.getText();
				String nohabitaciones = Nohabitaciones.getValue().toString();
				String tipodehabitaciones= Tipodehabitacion.getText();
				String piso = Piso.getSelectedItem().toString();
				String diashospedaje = Diashospedaje.getValue().toString();
				String formadepago= Formapago.getSelectedItem().toString();
				String mes = Mes.getSelectedItem().toString();
				int dia= (int) Dia.getValue();
			
				Guatemala clase = new Guatemala(nombre, nit, nohabitaciones, tipodehabitaciones, piso, diashospedaje, formadepago, mes, dia);
				contenedor.set(Encontrado, clase);
				Nombre.setText("");
			    Telefono.setText("");
				Nit.setText("");
				Tipodehabitacion.setText("");
            	
			}
		});
		actualizar.setBounds(212, 394, 89, 23);
		contentPane.add(actualizar);
		
		direccion = new JTextField();
		direccion.setBounds(431, 395, 166, 20);
		contentPane.add(direccion);
		direccion.setColumns(10);
		
		JButton btnNewButton = new JButton("Direccion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser dlg = new JFileChooser();
				int option =dlg.showSaveDialog(btnVerRegistro);
				
				if(option == JFileChooser.APPROVE_OPTION){
					File f= dlg.getSelectedFile();
					String f1= f.toString();
					direccion.setText(f1)
					;
				}

			}
		});
		btnNewButton.setBounds(623, 374, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		
		JButton btnGenerar = new JButton("Generar");
		
		
		
		
		
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				String d=direccion.getText();
								
				
																						//Lista l= new Lista();  // esto no se esta usando
				
				String contenido = btnVerRegistro.getActionCommand();  //cambiar la accion get text
				
                 
				//Object 	 k =new Lista();
					//	getClass((Nombre.getText(), Nit.getText(),Nohabitaciones.getValue().toString(), Piso.getSelectedItem().toString(); Diashospedaje.getValue().toString();  Formapago.getSelectedItem().toString();Mes.getSelectedItem().toString(); Dia.getValue()));
	               //String contenido = l Nombre.getText();
						
				
				
				
				
				try{
					FileOutputStream archivo= new FileOutputStream(d +".pdf");
					Document doc = new Document();
					PdfWriter.getInstance(doc, archivo);
					doc.open();// doc por archivo
					
				//	Printable tabla = (Printable) new PdfLine(10);
					
				doc.add(new Paragraph(contenido));
				
				
				
				
				
				
				
				//No esta sirviendo!!!!
				
					/*Paragraph p=new Paragraph("Hoteles de Centro America", 
						FontFactory.getFont("arial", 14, Font.ITALIC, BaseColor.ORANGE));
				p.setAlignment(Element.ALIGN_CENTER);*/
				
					doc.close();
					
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "error"+e);
					
					
					
					
					
				}
				
				
				
				
				
				
			}
		});
		btnGenerar.setBounds(623, 400, 89, 23);
		contentPane.add(btnGenerar);
	}
}
