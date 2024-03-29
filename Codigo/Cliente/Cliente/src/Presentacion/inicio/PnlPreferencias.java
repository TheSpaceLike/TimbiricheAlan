/**
 * PnlPreferencias.java
 */
package presentacion.inicio;

import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

/**
 *
 *
 */
public class PnlPreferencias extends javax.swing.JPanel {

    /**
     * Crea panelConfiguracion
     */
    public PnlPreferencias(String color) {
        initComponents();
        this.panelColorEscogido.setBackground(Color.decode(color));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLinea = new javax.swing.JPanel();
        panelColorEscogido = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(200, 221));
        setMinimumSize(new java.awt.Dimension(200, 221));

        panelLinea.setBackground(new java.awt.Color(255, 255, 255));
        panelLinea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        panelColorEscogido.setBackground(new java.awt.Color(0, 0, 0));
        panelColorEscogido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelColorEscogido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelColorEscogidoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelColorEscogidoLayout = new javax.swing.GroupLayout(panelColorEscogido);
        panelColorEscogido.setLayout(panelColorEscogidoLayout);
        panelColorEscogidoLayout.setHorizontalGroup(
            panelColorEscogidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );
        panelColorEscogidoLayout.setVerticalGroup(
            panelColorEscogidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelLineaLayout = new javax.swing.GroupLayout(panelLinea);
        panelLinea.setLayout(panelLineaLayout);
        panelLineaLayout.setHorizontalGroup(
            panelLineaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLineaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelColorEscogido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelLineaLayout.setVerticalGroup(
            panelLineaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLineaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelColorEscogido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLinea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void panelColorEscogidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelColorEscogidoMouseClicked
        Color color = JColorChooser.showDialog(this, "Escoge un color para la linea", Color.BLACK);
        if (color == null){
            color = Color.BLACK;
        }
        
        this.panelColorEscogido.setBackground(color);
    }//GEN-LAST:event_panelColorEscogidoMouseClicked

    /**
     * Regresa el color escogido.
     * @return 
     */
    public Color getColorEscogido() {
        return panelColorEscogido.getBackground();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelColorEscogido;
    private javax.swing.JPanel panelLinea;
    // End of variables declaration//GEN-END:variables
}
