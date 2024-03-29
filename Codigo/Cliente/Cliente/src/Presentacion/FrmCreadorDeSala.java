/**
 * FrmCreadorDeSala.java
 */
package presentacion;

import presentacion.juego.FrmSala;
import presentacion.inicio.MenuInicial;
import Dominio.Jugador;

/**
 *
 *
 */
public class FrmCreadorDeSala extends javax.swing.JFrame {
    
    private static FrmCreadorDeSala instance;
    private Jugador jugador;
    private int tamanio;

    /**
     * Crea FrmCreadorSala
     */
    private FrmCreadorDeSala(Jugador jugador) {
        initComponents();
        this.setTitle("Tamaño de la sala");
        this.setLocationRelativeTo(null);
        this.jugador = jugador;
    }
    
    public static FrmCreadorDeSala getInstance(Jugador jugador){
        if(instance == null){
            instance = new FrmCreadorDeSala(jugador);
        }
        instance.jugador = jugador;
        return instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dosButton = new javax.swing.JButton();
        tresButton = new javax.swing.JButton();
        cuatroButton = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));

        dosButton.setBackground(new java.awt.Color(0, 204, 204));
        dosButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        dosButton.setForeground(new java.awt.Color(0, 153, 153));
        dosButton.setText("2");
        dosButton.setMaximumSize(new java.awt.Dimension(120, 120));
        dosButton.setMinimumSize(new java.awt.Dimension(120, 120));
        dosButton.setPreferredSize(new java.awt.Dimension(120, 120));
        dosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosButtonActionPerformed(evt);
            }
        });

        tresButton.setBackground(new java.awt.Color(204, 51, 0));
        tresButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tresButton.setForeground(new java.awt.Color(204, 51, 0));
        tresButton.setText("3");
        tresButton.setMaximumSize(new java.awt.Dimension(120, 120));
        tresButton.setMinimumSize(new java.awt.Dimension(120, 120));
        tresButton.setPreferredSize(new java.awt.Dimension(120, 120));
        tresButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tresButtonActionPerformed(evt);
            }
        });

        cuatroButton.setBackground(new java.awt.Color(51, 204, 0));
        cuatroButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cuatroButton.setForeground(new java.awt.Color(51, 204, 0));
        cuatroButton.setText("4");
        cuatroButton.setMaximumSize(new java.awt.Dimension(120, 120));
        cuatroButton.setMinimumSize(new java.awt.Dimension(120, 120));
        cuatroButton.setPreferredSize(new java.awt.Dimension(120, 120));
        cuatroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuatroButtonActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));

        jLabel2.setBackground(new java.awt.Color(204, 0, 51));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("¿Cuántos jugadores habrá en la sala?");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(55, 55, 55))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dosButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(tresButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(cuatroButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(375, 375, 375)
                        .addComponent(cancelar)))
                .addGap(55, 55, 55))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dosButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tresButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cuatroButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cancelar)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        MenuInicial menuIn = MenuInicial.getInstance(jugador);
        menuIn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void dosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosButtonActionPerformed
        this.tamanio = 2;
        crearSala();
    }//GEN-LAST:event_dosButtonActionPerformed

    private void tresButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tresButtonActionPerformed
        this.tamanio = 3;
        crearSala();
    }//GEN-LAST:event_tresButtonActionPerformed

    private void cuatroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuatroButtonActionPerformed
        this.tamanio = 4;
        crearSala();
    }//GEN-LAST:event_cuatroButtonActionPerformed

    private void crearSala(){
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JButton cuatroButton;
    private javax.swing.JButton dosButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton tresButton;
    // End of variables declaration//GEN-END:variables
}