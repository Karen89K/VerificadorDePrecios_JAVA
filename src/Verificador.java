
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.Statement;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Karen Ornelas
 */
public class Verificador extends javax.swing.JFrame {

    /**
     * Creates new form Verificador
     */
    private Dimension size;
    private String codigo = "";
    private int width, height;

    public Verificador() {
        initComponents();
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        jLabel10.setText("Fecha: " + dia + "/" + (mes+1) + "/" + año);
        
 //ESTE EL CÓDIGO PARA LA HORA Y FECHA DEL VERIFICADOR
   DateTimeFormatter formateador = DateTimeFormatter.ofPattern("HH:mm:ss");
   Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                        jLabel8.setText("Hora: " + formateador.format(LocalDateTime.now()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread hilo = new Thread(runnable);
        hilo.start();
        
        
        this.setExtendedState(MAXIMIZED_BOTH);
        this.getContentPane().setBackground(Color.decode("#4caf4f"));
        size = Toolkit.getDefaultToolkit().getScreenSize();

        width = Toolkit.getDefaultToolkit().getScreenSize().width;
        height = Toolkit.getDefaultToolkit().getScreenSize().height;

        this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);

        this.setLayout(null);

      
        jLabel6.setLocation(0, 0);
        jLabel7.setLocation(this.getWidth() - jLabel7.getWidth(), 0);
        jLabel8.setLocation(0, this.getHeight() - jLabel8.getHeight()-35);
        jLabel10.setLocation(0, this.getHeight() - jLabel8.getHeight());
        jLabel9.setLocation(this.getWidth() - jLabel9.getWidth(), this.getHeight() - jLabel9.getHeight());

        jLabel1.setLocation(this.getWidth() / 2 - jLabel1.getWidth() / 2, this.getHeight() / 2 - jLabel1.getWidth() / 2 - 30);

        jLabel3.setLocation(this.getWidth() / 2 - jLabel2.getWidth() / 2, jLabel1.getLocation().y + jLabel1.getHeight());

        jLabel3.setLocation(this.getWidth() / 2 - jLabel3.getWidth() / 2, jLabel2.getLocation().y + jLabel2.getHeight() + 10);
        jLabel12.setLocation(this.getWidth() / 2 - jLabel3.getWidth() / 3, jLabel2.getLocation().y + jLabel2.getHeight() + 15);

        jLabel2.setVisible(false);
        jLabel2.setLocation(this.getWidth() / 2 - jLabel4.getWidth(), this.getHeight() / 2 - jLabel4.getHeight() / 2);
        jLabel5.setLocation(jLabel4.getLocation().x + jLabel4.getHeight() + 15, jLabel4.getLocation().y);
        jLabel4.setLocation(jLabel4.getLocation().x + jLabel4.getHeight() + 15, jLabel5.getLocation().y + jLabel5.getHeight() + 8);
        jLabel5.setText("");
        jLabel4.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 102));
        setUndecorated(true);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono_super.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 380, 258));

        jLabel2.setMinimumSize(new java.awt.Dimension(200, 200));
        jLabel2.setName(""); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 200, 200));

        jLabel3.setFont(new java.awt.Font("Palatino Linotype", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Por favor, pase el código de barras por debajo del escaner...");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 0));
        jLabel4.setText("jLabel4");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel4.setMaximumSize(new java.awt.Dimension(350, 220));
        jLabel4.setMinimumSize(new java.awt.Dimension(350, 220));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 350, 220));

        jLabel5.setFont(new java.awt.Font("Palatino Linotype", 3, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(187, 89, 17));
        jLabel5.setText("\"\"");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel5.setAutoscrolls(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 750, 40));

        jLabel6.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel6.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel6.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 50, 50));

        jLabel7.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel7.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel7.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 50, 50));

        jLabel8.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("jLabel6");
        jLabel8.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel8.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel8.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 200, 50));

        jLabel9.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel9.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel9.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 50, 50));

        jLabel10.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("jLabel10");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 350, 60));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/jjn.gif"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() != 10) {
            codigo += evt.getKeyChar();
        } else {
            //JOptionPane.showMessageDialog(null, "El codigo presionado es " + codigo);
            try {
                Connection con = null;
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/verificador_de_precios", "root", "");
                PreparedStatement pstm = con.prepareStatement("SELECT producto_nombre, producto_precio, producto_cantidad, producto_imagen FROM productos WHERE producto_codigo = " + codigo);
                ResultSet rs = pstm.executeQuery();

                //Aquí los índices empiezan en 1
                if (rs.next()) {

                    VerProducto v = new VerProducto(codigo, rs);
                    v.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "PRODUCTO NO ENCONTRADO. PASE A SERVICIO A CLIENTES.");
                }

                //JOptionPane.showMessageDialog(null, "SELECT * FROM productos WHERE producto_codigo = "+codigo);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error.");
                System.out.println(e.toString());
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error" + e.toString());

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
            }
            codigo = "";
        }
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Verificador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Verificador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Verificador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Verificador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Verificador().setVisible(true);
               
                
            }
        });
    }

    void PantallaPrincipal() throws InterruptedException {
        Thread.sleep(5000);
        jLabel1.setVisible(true);
        jLabel3.setVisible(true);
        jLabel2.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        this.getContentPane().setBackground(Color.decode("#34BA28"));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
