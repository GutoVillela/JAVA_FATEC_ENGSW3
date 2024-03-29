/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.SalaController;
import Model.Sala;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author alexandre
 */
public class frmSalasPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form frmSalasPrincipal
     */
    public frmSalasPrincipal() {
        initComponents();
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
        btnPrincipalAdd = new javax.swing.JButton();
        btnPrincipalRemover = new javax.swing.JButton();
        btnPrincipalEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("aakar", 0, 24)); // NOI18N

        jLabel1.setText("OPÇÕES DE SALA");

        btnPrincipalAdd.setText("ADICIONAR");
        btnPrincipalAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrincipalAddActionPerformed(evt);
            }
        });

        btnPrincipalRemover.setText("REMOVER");
        btnPrincipalRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrincipalRemoverActionPerformed(evt);
            }
        });

        btnPrincipalEditar.setText("EDITAR");
        btnPrincipalEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrincipalEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnPrincipalAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPrincipalRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPrincipalEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPrincipalAdd)
                .addGap(18, 18, 18)
                .addComponent(btnPrincipalEditar)
                .addGap(18, 18, 18)
                .addComponent(btnPrincipalRemover)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrincipalEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrincipalEditarActionPerformed
        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da SALA"));
        System.out.println(id);
        SalaController sc = new SalaController();

        try {
            //Caso encontra uma sala com o id informado                
            if (sc.buscar(id)) {
                Sala s = new Sala();   
                s = s.buscar(id);   //busacar() retorna um objeto do tipo Sala
                frmSalas.salaEstatica = s;     //atibui o objeto retornado a variável estática do prox. form
                new frmSalas(0).setVisible(true);                     
                System.out.println("OK");
            } else {
                System.out.println(";NOK");
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmSalas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPrincipalEditarActionPerformed

    private void btnPrincipalRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrincipalRemoverActionPerformed
        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da SALA"));
        System.out.println(id);
        SalaController sc = new SalaController();
        Sala s = new Sala();
        s.setId(id);
        if (sc.remover(s))
            JOptionPane.showMessageDialog(null, "Sala removida com sucesso !", "SUCESSO !", JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Sala não removida!", "ERRO !", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnPrincipalRemoverActionPerformed

    private void btnPrincipalAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrincipalAddActionPerformed
        new frmSalas(1).setVisible(true);
    }//GEN-LAST:event_btnPrincipalAddActionPerformed

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
            java.util.logging.Logger.getLogger(frmSalasPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSalasPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSalasPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSalasPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSalasPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrincipalAdd;
    private javax.swing.JButton btnPrincipalEditar;
    private javax.swing.JButton btnPrincipalRemover;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
