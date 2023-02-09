package conectaBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

public class ApartadoGrafico extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	ButtonGroup btn;
    public ApartadoGrafico() {
        initComponents();
    }                       
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        tablafuera = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        datos = new javax.swing.JPanel();
        datos2 = new javax.swing.JPanel();
        productosC = new javax.swing.JTextField();
        categoriaC = new javax.swing.JTextField();
        montoC = new javax.swing.JTextField();
        seccionC = new javax.swing.JTextField();
        productos = new javax.swing.JLabel();
        categoria = new javax.swing.JLabel();
        seccion = new javax.swing.JLabel();
        monto = new javax.swing.JLabel();
        idC = new javax.swing.JTextPane();
        bAgregar = new javax.swing.JButton();
        bModificar = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();
        bNuevo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondo.setBackground(new java.awt.Color(0, 153, 153));

        titulo.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        titulo.setText("Productos");

        tablafuera.setBackground(new java.awt.Color(0, 153, 153));
        tablafuera.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tablafuera.addMouseListener(new java.awt.event.MouseAdapter() {
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Producto", "Categoria", "Seccion", "Monto"
            }
        ) {
			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pasarDatos(evt);
            }
        });
        tablafuera.setViewportView(tabla);

        datos.setBackground(new java.awt.Color(204, 204, 204));
        datos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        datos2.setBackground(new java.awt.Color(153, 153, 153));
        datos2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        productos.setText("Productos");

        categoria.setText("Categoria");

        seccion.setText("Seccion");

        monto.setText("Monto");

        javax.swing.GroupLayout datos2Layout = new javax.swing.GroupLayout(datos2);
        datos2.setLayout(datos2Layout);
        datos2Layout.setHorizontalGroup(
            datos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datos2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(datos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(categoria)
                    .addComponent(productos)
                    .addComponent(seccion)
                    .addComponent(monto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(datos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(productosC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(categoriaC, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(montoC, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(seccionC))
                .addGap(23, 23, 23))
        );
        datos2Layout.setVerticalGroup(
            datos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datos2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(datos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productosC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(datos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoriaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(datos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seccion)
                    .addComponent(seccionC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(datos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(montoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monto))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout datosLayout = new javax.swing.GroupLayout(datos);
        datos.setLayout(datosLayout);
        datosLayout.setHorizontalGroup(
            datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datosLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(datos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        datosLayout.setVerticalGroup(
            datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosLayout.createSequentialGroup()
                .addGroup(datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(datos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(datosLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(idC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        bAgregar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bAgregar.setText("Agregar");
        bAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarLineaDatos(evt);
            }
        });

        bModificar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bModificar.setText("Modificar");
        bModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarLineaDatos(evt);
            }
        });

        bEliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bEliminar.setText("Eliminar");
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarLineaDatos(evt);
            }
        });

        bNuevo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bNuevo.setText("Nuevo");
        bNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoDato(evt);
            }
        });

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addComponent(bAgregar)
                        .addGap(69, 69, 69)
                        .addComponent(bModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bEliminar)
                        .addGap(61, 61, 61)
                        .addComponent(bNuevo))
                    .addComponent(tablafuera, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106))
            .addGroup(fondoLayout.createSequentialGroup()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(titulo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tablafuera, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAgregar)
                    .addComponent(bModificar)
                    .addComponent(bEliminar)
                    .addComponent(bNuevo))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        imprimirTabla();
    }                   
                    

    private void modificarLineaDatos(java.awt.event.ActionEvent evt) {
    	try {
	    	int id = Integer.parseInt(idC.getText());
	    	String productos = productosC.getText();
	    	String categoria = categoriaC.getText();
	    	String seccion = seccionC.getText();
	    	Double monto = Double.parseDouble(montoC.getText());
	    	try {
	    		Connection miConexion = Conecta_Pruebas.conectarse();
	    		PreparedStatement ps = miConexion.prepareStatement("UPDATE productos SET producto=?, categoria=?, seccion=?, monto=? WHERE id=?");
	    		ps.setString(1, productos);
	    		ps.setString(2, categoria);
	    		ps.setString(3, seccion);
	    		ps.setDouble(4, monto);
	    		ps.setInt(5, id);
	    		ps.executeUpdate();
	    		
	    		JOptionPane.showMessageDialog(null , "Registro modificado");
	    		limpiar();
	    		imprimirTabla();
	    		
	    	} catch(Exception e){
	    		JOptionPane.showMessageDialog(null , e.toString());
	    	}
	    	imprimirTabla();
	    	} catch (Exception e) {
	    		JOptionPane.showMessageDialog(null , "Hubo algun error al guardar datos\n Codigo de error:"+e.toString());
	    }
    }

    private void agregarLineaDatos(java.awt.event.ActionEvent evt) {
    	try {
    	String productos = productosC.getText();
    	String categoria = categoriaC.getText();
    	String seccion = seccionC.getText();
    	Double monto = Double.parseDouble(montoC.getText());
    	
    	try {
    		Connection miConexion = Conecta_Pruebas.conectarse();
    		PreparedStatement ps = miConexion.prepareStatement("INSERT INTO productos(producto, categoria, seccion, monto) VALUES(?, ?, ?, ?)");
    		ps.setString(1, productos);
    		ps.setString(2, categoria);
    		ps.setString(3, seccion);
    		ps.setDouble(4, monto);
    		ps.executeUpdate();
    		JOptionPane.showMessageDialog(null , "Registro guardado");
    		limpiar();
    		imprimirTabla();
    		
    	} catch(Exception e){
    		JOptionPane.showMessageDialog(null , e.toString());
    	}
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(null , "Hubo algun error al guardar datos\n Codigo de error:"+e.toString());
    	}
    }                                  

    private void eliminarLineaDatos(java.awt.event.ActionEvent evt) {
    	try {
    	int id = Integer.parseInt(idC.getText());
    	
    	
    	try {
    		Connection miConexion = Conecta_Pruebas.conectarse();
    		PreparedStatement ps = miConexion.prepareStatement("DELETE FROM productos WHERE id=?");
    		ps.setInt(1, id);
    		ps.executeUpdate();
    		
    		JOptionPane.showMessageDialog(null , "Registro eliminado");
    		limpiar();
    		imprimirTabla();
    		
    	} catch(Exception e){
    		JOptionPane.showMessageDialog(null , e.toString());
    	}
    	imprimirTabla();
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(null , "Hubo algun error al guardar datos\n Codigo de error:"+e.toString());
    	}
    }

    private void nuevoDato(java.awt.event.ActionEvent evt) {
        limpiar();
    }                          

    private void pasarDatos(java.awt.event.MouseEvent evt) {
    	try {
    		int fila = tabla.getSelectedRow();
    		int id = Integer.parseInt(tabla.getValueAt(fila, 0).toString());
    		Connection miConexion = Conecta_Pruebas.conectarse();
    		PreparedStatement ps;
    		ResultSet rs;
    		ps = miConexion.prepareStatement("SELECT producto, categoria, seccion, monto FROM productos WHERE id=?");
    		ps.setInt(1, id);
    		rs = ps.executeQuery();
    		while(rs.next()) {
    			idC.setText(String.valueOf(id));
    			productosC.setText(rs.getString("producto"));
    			categoriaC.setText(rs.getString("categoria"));
    			seccionC.setText(rs.getString("seccion"));
    			montoC.setText(rs.getString("monto"));
    		}
    		imprimirTabla();
    		
    		
    	}catch (Exception e){
    		
    	}
    }
    
    private void imprimirTabla() {
    	DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
    	modeloTabla.setRowCount(0);
    	PreparedStatement ps;
    	ResultSet rs;
    	ResultSetMetaData rsmd;
    	int columnas;
    	
    	try {
    		Connection miConexion = Conecta_Pruebas.conectarse();
    		ps = miConexion.prepareStatement("SELECT id, producto, categoria, seccion, monto FROM productos");
    		rs = ps.executeQuery();
    		rsmd = rs.getMetaData();
    		columnas = rsmd.getColumnCount();
    		
    		while(rs.next()) {
    			Object[] fila = new Object [columnas];
    			for(int i=0; i<columnas; i++) {
    				fila[i] = rs.getObject(i+1);
    			}
    			modeloTabla.addRow(fila);
    		}
    	}catch (Exception e){
    		JOptionPane.showMessageDialog(null , e.toString());
    	}
    }
    
    private void limpiar() {
    	productosC.setText("");
    	categoriaC.setText("");
    	seccionC.setText("");
    	montoC.setText("");
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ApartadoGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApartadoGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApartadoGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApartadoGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApartadoGrafico().setVisible(true);
            }
        });
    }

    private JTextPane idC;
    private javax.swing.JButton bAgregar, bEliminar, bModificar, bNuevo;
    private javax.swing.JPanel datos, datos2, fondo;
    private javax.swing.JLabel productos, categoria, seccion, monto, titulo;
    private javax.swing.JTextField productosC, categoriaC, seccionC, montoC;
    private javax.swing.JTable tabla;
    private javax.swing.JScrollPane tablafuera;
}
