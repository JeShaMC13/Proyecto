import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;


public class Lista extends JFrame {

	private DefaultTableModel model;
	int con = 0;
	
	private JPanel contentPane;
	private JTable datos;

	/**
	 * Launch the application.
	 */
	
	public void mostrarinterfaz(){
		String data [][]={};
		String col [] = {"Nombre", "Nit", "No.habitaciones", "Tipo", "Piso", "Forma de pago", "mes", "dia"};
		model = new DefaultTableModel(data, col);
		datos.setModel(model);
		datos.setVisible(true);		
	}	
	public void mostrardatos(){
		Guatemala g;
		for(int i= 0; i<InterfazGuatemala.contenedor.size(); i++){
			
			g = (Guatemala) InterfazGuatemala.contenedor.get(i);
			model.insertRow(con, new Object[]{});
			model.setValueAt(g.getNombre(), con, 0);
			model.setValueAt(g.getNit(), con, 1);
			model.setValueAt(g.getNohabitaciones(), con, 2);
			model.setValueAt(g.getTipodehabitaciones(), con, 3);
			model.setValueAt(g.getPiso(), con, 4);
			model.setValueAt(g.getFormadepago(), con, 5);
			model.setValueAt(g.getMes(), con, 6);
			model.setValueAt(g.getDia(), con, 7);
		}
		
	}
	
	//public Lista(mostrardatos()){
		
	//}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lista frame = new Lista();
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
	public Lista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		datos = new JTable();
		datos.setBounds(33, 80, 647, 303);
		contentPane.add(datos);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(33, 55, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblNit = new JLabel("Nit");
		lblNit.setBounds(105, 55, 46, 14);
		contentPane.add(lblNit);
		
		JLabel lblNoDeHabitaciones = new JLabel("No. de habitaciones");
		lblNoDeHabitaciones.setBounds(161, 55, 101, 14);
		contentPane.add(lblNoDeHabitaciones);
		
		JLabel lblTipoDeHabitacion = new JLabel("Tipo");
		lblTipoDeHabitacion.setBounds(288, 55, 34, 14);
		contentPane.add(lblTipoDeHabitacion);
		
		JLabel lblPiso = new JLabel("Dias de hospedaje");
		lblPiso.setBounds(329, 55, 113, 14);
		contentPane.add(lblPiso);
		
		JLabel lblFormaDePago = new JLabel("Forma de pago");
		lblFormaDePago.setBounds(452, 55, 90, 14);
		contentPane.add(lblFormaDePago);
		
		JLabel lblDiaIngreso = new JLabel("Dia ingreso");
		lblDiaIngreso.setBounds(542, 55, 66, 14);
		contentPane.add(lblDiaIngreso);
		
		JLabel lblMesIngreso = new JLabel("Mes ingreso");
		lblMesIngreso.setBounds(618, 55, 72, 14);
		contentPane.add(lblMesIngreso);
	 mostrarinterfaz();	
	mostrardatos();

	
	
	}
}
