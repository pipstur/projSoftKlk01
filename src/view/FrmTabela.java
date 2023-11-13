/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import domain.Nastavnik;
import domain.Zvanje;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeli.NastavnikTableModel;

/**
 *
 * @author vojislav
 */
public class FrmTabela extends javax.swing.JFrame {

    /**
     * Creates new form FrmTabela
     */
    List<Nastavnik> nastavnici = new ArrayList<>();
    public FrmTabela() {
        initComponents();
        populateFields();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblNastavnici = new javax.swing.JTable();
        btnDetalji = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblNastavnici.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblNastavnici);

        btnDetalji.setText("Detalji");
        btnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetaljiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDetalji)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDetalji)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetaljiActionPerformed
        
        int selectedRow = tblNastavnici.getSelectedRow();

        if (selectedRow >= 0) {
            Nastavnik selektovaniNastavnik = nastavnici.get(selectedRow); 
            openDetailsForm(selektovaniNastavnik);
        } else {
            System.out.println("Nije selektovan profesor");
        }
    }//GEN-LAST:event_btnDetaljiActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalji;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNastavnici;
    // End of variables declaration//GEN-END:variables

    private void populateFields() {
            
            Connection connection = null;
            String url = "jdbc:mysql://localhost:3306/projsoft";
            String user = "root";
            String pass = "";
        try {
            connection = DriverManager.getConnection(url, user, pass);
            // posto pise da treba da budu sortirani po zvanju order by zvanje_id
            String upit = "select id,ime,prezime,zvanje_id from nastavnik order by zvanje_id";
            System.out.println(upit);
            var statement = connection.prepareStatement(upit);
            
            var rs = statement.executeQuery();
            
            while(rs.next()){
                Nastavnik nastavnik = new Nastavnik();
                nastavnik.setId(rs.getInt("id"));
                nastavnik.setIme(rs.getString("ime"));
                nastavnik.setPrezime(rs.getString("prezime"));
                nastavnik.setZvanje(Zvanje.valueOf(rs.getInt("zvanje_id")));
                nastavnici.add(nastavnik);
                //System.out.println(nastavnik);
            }
            tblNastavnici.setModel(new NastavnikTableModel(nastavnici));
        } catch (SQLException ex) {
            Logger.getLogger(FrmTabela.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    private void openDetailsForm(Nastavnik selektovaniNastavnik) {
        FrmDetalji detailsForm = new FrmDetalji(selektovaniNastavnik);
        detailsForm.setLocationRelativeTo(this); // da bi se otvorilo na sred ovog prozora a ne gore levo
        detailsForm.setVisible(true);
       
    }
}
