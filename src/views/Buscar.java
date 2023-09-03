package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.HospedeController;
import controller.ReservaController;
import model.FormaDePagamento;
import model.Hospede;
import model.Reserva;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Date;



@SuppressWarnings("serial")
public class Buscar extends JFrame 
{

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHospedes = new JTable();
	private JTable tbReservas = new JTable();
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHospedes;
	private JLabel labelAtras;
	private JLabel labelExit;
	int xMouse, yMouse;
	private ReservaController reservaController;
	private HospedeController hospedeController;
	private static Hospede hospede = new Hospede();
	private static Reserva reserva = new Reserva();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				try 
				{
					Buscar frame = new Buscar();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Buscar() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Buscar.class.getResource("/imagenes/lOGO-50PX.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		
		JLabel lblTitulo = new JLabel("SISTEMA DE BUSCA");
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblTitulo.setBounds(331, 62, 280, 42);
		contentPane.add(lblTitulo);
		
		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);

		
	
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		modelo = (DefaultTableModel) tbReservas.getModel();
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Data Check In");
		modelo.addColumn("Data Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pago");

		
		
		JScrollPane scroll_table = new JScrollPane(tbReservas);
		panel.addTab("Reservas", new ImageIcon(Buscar.class.getResource("/imagenes/reservado.png")), scroll_table, null);
		scroll_table.setVisible(true);
		
		
		
		tbHospedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHospedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		modeloHospedes = (DefaultTableModel) tbHospedes.getModel();
		modeloHospedes.addColumn("Numero de Hóspede");
		modeloHospedes.addColumn("Nome");
		modeloHospedes.addColumn("Sobrenome");
		modeloHospedes.addColumn("Data de Nascimento");
		modeloHospedes.addColumn("Nacionalidade");
		modeloHospedes.addColumn("Telefone");
		modeloHospedes.addColumn("Numero de Reserva");
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHospedes);
		panel.addTab("Huéspedes", new ImageIcon(Buscar.class.getResource("/imagenes/pessoas.png")), scroll_tableHuespedes, null);
		scroll_tableHuespedes.setVisible(true);
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Buscar.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) { // Quando o usuário passa o mouse sobre o botão, ele muda de cor
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) { //Quando o usuário remove o mouse do botão, ele retornará ao estado original
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);
		
		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(panel.getSelectedIndex() == 0)
				{
					modelo.getDataVector().removeAllElements();
					modeloHospedes.getDataVector().removeAllElements();
					
					reservaController = new ReservaController();
					modelo = reservaController.buscaPorId(Long.parseLong(txtBuscar.getText().toString()), modelo);
					
					 
					hospedeController = new HospedeController();
					modeloHospedes = hospedeController.buscaPorIdReserva(Long.parseLong(txtBuscar.getText().toString()), modeloHospedes);
					
					
					if(modeloHospedes == null)
					{
						modeloHospedes.getDataVector().removeAllElements();
						modelo.getDataVector().removeAllElements();
						
						JOptionPane.showMessageDialog(null, "Não temos hóspede/reserva para este sobrenome.");
						
						Object[] rowData = new Object[7];
						rowData[0] = "";
						rowData[1] = "";
						rowData[2] = "";
						rowData[3] = "";
						rowData[4] = "";
						rowData[5] = "";
						rowData[6] = "";
						
						modeloHospedes.addColumn(rowData);

						
						Object[] rowDataModelo = new Object[5];
						rowDataModelo[0] = "";
						rowDataModelo[1] = "";
						rowDataModelo[2] = "";
						rowDataModelo[3] = "";
						rowDataModelo[4] = "";
						
						modelo.addColumn(rowDataModelo);
					}
				}
				
				if(panel.getSelectedIndex() == 1)
				{
					if(!txtBuscar.getText().equals(""))
					{
						modeloHospedes.getDataVector().removeAllElements();
						
						hospedeController = new HospedeController();
						modeloHospedes = hospedeController.buscaPorSobreNome(txtBuscar.getText(), modeloHospedes);
						
						
						if(modeloHospedes == null)
						{
							modeloHospedes.getDataVector().removeAllElements();
							modelo.getDataVector().removeAllElements();
							
							JOptionPane.showMessageDialog(null, "Não temos hóspede/reserva para este sobrenome.");
							
							Object[] rowData = new Object[7];
							rowData[0] = "";
							rowData[1] = "";
							rowData[2] = "";
							rowData[3] = "";
							rowData[4] = "";
							rowData[5] = "";
							rowData[6] = "";
							
							modeloHospedes.addColumn(rowData);

							
							Object[] rowDataModelo = new Object[5];
							rowDataModelo[0] = "";
							rowDataModelo[1] = "";
							rowDataModelo[2] = "";
							rowDataModelo[3] = "";
							rowDataModelo[4] = "";
							
							modelo.addColumn(rowDataModelo);
						}else
						{						
							if(modeloHospedes.getValueAt(0, 6) != null)
							{				 
								modelo.getDataVector().removeAllElements();
								reservaController = new ReservaController();
								modelo = reservaController.buscaPorId(Long.parseLong(modeloHospedes.getValueAt(0, 6).toString()), modelo);
							}else
							{
								modeloHospedes.getDataVector().removeAllElements();
								modelo.getDataVector().removeAllElements();
								
								JOptionPane.showMessageDialog(null, "Não temos hóspede/reserva para este sobrenome.");
							}
						}
					}
				}
			}
		});
		
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);
		
		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
		
 
		JPanel btnEditar = new JPanel();
		btnEditar.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{			
				int[] valor = tbHospedes.getSelectedRows();
				int[] valorReserva = tbReservas.getSelectedRows();
				
				
				if(panel.getSelectedIndex() == 0)
				{
					if(valorReserva[0] >= 0)
					{
						editarReserva(tbReservas);
					}
				}
				
				
				if(panel.getSelectedIndex() == 1)
				{
					if(valor[0] >= 0)
					{
						editarHospede(tbHospedes);
					}else
					{
						System.out.println("Não foi possível pegar o hóspede!");
					}
				}
			}
		});
		
		
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		

		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
		
		JPanel btnDeletar = new JPanel();
		btnDeletar.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{			
				
				int[] valor = tbHospedes.getSelectedRows();
				
				int[] valorReserva = tbReservas.getSelectedRows();
				
				try
				{
					if(panel.getSelectedIndex() == 0)
					{
						if(tbReservas.getSelectedRows().length >= 0)
						{
							deletarReserva(tbReservas, tbHospedes);
							
							modelo.removeRow(tbReservas.getSelectedRow());
							modelo.getDataVector().removeAllElements();
							modeloHospedes.getDataVector().removeAllElements();
						}
					}
					
					
					if(panel.getSelectedIndex() == 1)
					{
						if(valor[0] >= 0)
						{
							deletarHospede(tbHospedes);
							
							modeloHospedes.removeRow(tbHospedes.getSelectedRow());
							modeloHospedes.getDataVector().removeAllElements();					
							modelo.getDataVector().removeAllElements();
						}else
						{
							JOptionPane.showMessageDialog(null, "Não temos este hóspede!");
						}
					}
				}catch(ArrayIndexOutOfBoundsException ex)
				{
					JOptionPane.showMessageDialog(null, "Sem informação para excluir do sistema!");
				}
				
			}
		});
		
		
		btnDeletar.setLayout(null);
		btnDeletar.setBackground(new Color(12, 138, 199));
		btnDeletar.setBounds(767, 508, 122, 35);
		btnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnDeletar);
		
		JLabel lblExcluir = new JLabel("DELETAR");
		lblExcluir.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluir.setForeground(Color.WHITE);
		lblExcluir.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblExcluir.setBounds(0, 0, 122, 35);
		btnDeletar.add(lblExcluir);
		setResizable(false);
	}
	
	protected void deletarHospede(JTable tbHospedes) 
	{
		hospede.setId((int) tbHospedes.getValueAt(tbHospedes.getSelectedRow(), 0));
		hospede.setNome(tbHospedes.getValueAt(tbHospedes.getSelectedRow(), 1).toString());
		hospede.setSobrenome(tbHospedes.getValueAt(tbHospedes.getSelectedRow(), 2).toString());
		hospede.setDataNascimento((Date) tbHospedes.getValueAt(tbHospedes.getSelectedRow(), 3));
		hospede.setNacionalidade(tbHospedes.getValueAt(tbHospedes.getSelectedRow(), 4).toString());
		hospede.setTelefone(tbHospedes.getValueAt(tbHospedes.getSelectedRow(), 5).toString()) ;
		hospede.setNumeroDeReserva((Integer) tbHospedes.getValueAt(tbHospedes.getSelectedRow(), 6));
		
		
		if(hospedeController.deletarHospede(hospede))
		{
			JOptionPane.showMessageDialog(null, "Hóspede excluído com sucesso!");
		}else
		{
			JOptionPane.showMessageDialog(null, "Não foi possível deletar o hóspede!");
		}
	}

	protected void deletarReserva(JTable tbReservas, JTable tbHospedes) 
	{
		hospedeController.deletarHospede(hospede);
		
		System.out.println("1 "  );
		reserva.setId((long) tbReservas.getValueAt(tbReservas.getSelectedRow(), 0));
        reserva.setDataEntrada((Date) tbReservas.getValueAt(tbReservas.getSelectedRow(), 1));
        reserva.setDataSaida((Date) tbReservas.getValueAt(tbReservas.getSelectedRow(), 2));
        reserva.setValor(Double.valueOf(tbReservas.getValueAt(tbReservas.getSelectedRow(), 3).toString()));
        reserva.setFormaDePagamento((FormaDePagamento) tbReservas.getValueAt(tbReservas.getSelectedRow(), 4));
        
        if(reservaController.deletarReservaPorId(reserva))
        {System.out.println("2 "  );
        	JOptionPane.showMessageDialog(null, "Reserva excluída com sucesso!");
		}else
		{System.out.println("3 "  );
			JOptionPane.showMessageDialog(null, "Não foi possível deletar o reserva!");
		}

        modelo.getDataVector().removeAllElements();
        hospedeController.cadastraHospede(hospede);
        

   

	}
	
	
	
	
	
	
	
	

	protected void editarReserva(JTable tbReservas) 
	{
		reserva.setId((long) tbReservas.getValueAt(tbReservas.getSelectedRow(), 0));
        reserva.setDataEntrada((Date) tbReservas.getValueAt(tbReservas.getSelectedRow(), 1));
        reserva.setDataSaida((Date) tbReservas.getValueAt(tbReservas.getSelectedRow(), 2));
        reserva.setValor(Double.valueOf(tbReservas.getValueAt(tbReservas.getSelectedRow(), 3).toString()));
        reserva.setFormaDePagamento((FormaDePagamento) tbReservas.getValueAt(tbReservas.getSelectedRow(), 4));
        
        if(reservaController.atualizaReserva(reserva))
        {
        	JOptionPane.showMessageDialog(null,  "Reserva atualizada com sucesso!");
        }else
		{
			JOptionPane.showMessageDialog(null, "Por favor, verifique os campos do hóspede!");
		}
	}

	protected void editarHospede(JTable tbHospedes) 
	{		
		hospede.setId((int) tbHospedes.getValueAt(tbHospedes.getSelectedRow(), 0));
		hospede.setNome(tbHospedes.getValueAt(tbHospedes.getSelectedRow(), 1).toString());
		hospede.setSobrenome(tbHospedes.getValueAt(tbHospedes.getSelectedRow(), 2).toString());
		hospede.setDataNascimento((Date) tbHospedes.getValueAt(tbHospedes.getSelectedRow(), 3));
		hospede.setNacionalidade(tbHospedes.getValueAt(tbHospedes.getSelectedRow(), 4).toString());
		hospede.setTelefone(tbHospedes.getValueAt(tbHospedes.getSelectedRow(), 5).toString()) ;
		hospede.setNumeroDeReserva((Integer) tbHospedes.getValueAt(tbHospedes.getSelectedRow(), 6));
		
		if(hospedeController.atualizarHospede(hospede))
		{
			JOptionPane.showMessageDialog(null, "Hóspede atualizado com sucesso!");
		}else
		{
			JOptionPane.showMessageDialog(null, "Por favor, verifique os campos do hóspede!");
		}
	}

	//Código que permite movimentar a janela pela tela seguindo a posição de "x" e "y"	
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
}
}
