/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import db.Dao;
import db.SqliteSession;
import java.util.Date;
import java.util.List;
import model.Road;

/**
 *
 * @author Raffan
 */
public class DbConnectionUi extends javax.swing.JPanel {

    /**
     * Creates new form DbConnectionUi
     */
    public DbConnectionUi() {
        initComponents();
    }

    private void getRoads() {
        String query = "select *, ST_ASTEXT(a.Geometry) from tl_2016_48439_roads  a limit 100";
        Date d1 = new Date();
        SqliteSession session = Dao.getSession(jtfFilename.getText());
        List<Road> roads = session.getRoads(query);
        Date d2 = new Date();
        for(Road road: roads){
            road.printInfo();
            jtaOutput.append(road.getPrintString());
        }
        System.out.println("Time taken: "+(d2.getTime()-d1.getTime()));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfFilename = new javax.swing.JTextField();
        getRoads = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaOutput = new javax.swing.JTextArea();

        jLabel1.setText("DB file (*.sqlite)");

        jtfFilename.setText("E:\\\\UTA\\\\Research\\\\SpatialAnalyzer\\\\database\\\\spatial-db.sqlite");

        getRoads.setText("Get roads");
        getRoads.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getRoadsActionPerformed(evt);
            }
        });

        jtaOutput.setEditable(false);
        jtaOutput.setColumns(20);
        jtaOutput.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jtaOutput.setRows(5);
        jScrollPane1.setViewportView(jtaOutput);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfFilename, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getRoads)
                .addContainerGap(213, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfFilename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(getRoads))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void getRoadsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getRoadsActionPerformed
        // TODO add your handling code here:
        getRoads();
    }//GEN-LAST:event_getRoadsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton getRoads;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jtaOutput;
    private javax.swing.JTextField jtfFilename;
    // End of variables declaration//GEN-END:variables
}
