/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import javax.swing.JPanel;

/**
 *
 * @author DivyaThanigaiArasu
 */
public class LogInScreen extends javax.swing.JPanel {

    /**
     * Creates new form SeatAssignmentPanel
     */
        private JPanel rightPanel;
        
    public LogInScreen( JPanel rightPanel) {
         this.rightPanel = rightPanel;
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

        jLabel2 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Welcome!! You have been logged in!!");
        add(jLabel2, "card2");
    }// </editor-fold>//GEN-END:initComponents
       
        
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables


}
