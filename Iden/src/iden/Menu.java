/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iden;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.util.StringTokenizer;
/**
 *
 * @author LL829
 */
public class Menu extends javax.swing.JFrame {

    DefaultListModel<String> menu=new DefaultListModel<>();
    DefaultListModel menu1=new DefaultListModel();
    
    //Ingeniero ing=new Ingeniero(menu, menu1);
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        menu=new DefaultListModel();
        jList1.setModel(menu);
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
        txtCadena = new javax.swing.JTextField();
        btnOperar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cadena");

        btnOperar.setText("Operar");
        btnOperar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperarActionPerformed(evt);
            }
        });

        jLabel2.setText("Sus identificadores:");

        jScrollPane1.setViewportView(jList1);

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(190, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(txtCadena))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnOperar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCadena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnOperar)
                        .addGap(19, 19, 19)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jButton2))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperarActionPerformed
        // TODO add your handling code here:
        
       // String entrada = this.txtCadena.getText();
       // StringTokenizer token = new StringTokenizer(entrada," ");
        
       // while(token.hasMoreTokens()){
        //    this.txtCadena.append(token.nextToken()+ "/n");
        //}
        
        //ing.IngresarNombre(this.txtCadena.getText());
        //ing.IngresarEdad(Integer.parseInt(txtCadena.getText()));
        
        String texto, palabra = "", letra, palabraCaracter;
        int largo;
        char caracter, caracterIndividual;
        Palabra palabraObjeto = new Palabra("", Tipo.IDENTIFICADOR);
        texto = txtCadena.getText();
        texto = texto.trim();
        jList1.setModel(menu);
        largo = texto.length();
        
        for (int x = 0; x < largo; x++){
            caracter = texto.charAt(x);
            letra = Character.toString(caracter);
            //EVALUA SI ENCUENTRA UN ESPACIO ENTONCES MUESTRA LO GUARDADO Y REINICIA
            if (letra.equals(" ")){
                palabraObjeto.texto = palabra;
                palabra = "";
                palabraObjeto = palabraObjeto.EvaluarIdentificador(palabraObjeto.texto, palabraObjeto);
                //MOSTRAR CARACTER POR CARACTER
                if (palabraObjeto.tipo == Tipo.CARACTER){
                    for (int y = 0; y < palabraObjeto.texto.length(); y++){
                        caracterIndividual = palabraObjeto.texto.charAt(y);
                        palabraCaracter = Character.toString(caracterIndividual);
                        menu.addElement(palabraObjeto.tipo.tipo + " " + palabraCaracter);
                    }
                }
                else{//NO ES DE TIPO CARACTER, ENTONCES MUESTRA
                    menu.addElement(palabraObjeto.tipo.tipo + " " + palabraObjeto.texto);
                }
            }
            else{
                palabra = palabra + letra;
            }
            //EVALUA SI YA LLEGO AL FINAL DEL CICLO PARA MOSTRAR LO QUE HA GUARDADO
            if (x == largo-1){
                palabraObjeto.texto = palabra;
                palabraObjeto = palabraObjeto.EvaluarIdentificador(palabraObjeto.texto, palabraObjeto);
                if (palabraObjeto.tipo == Tipo.CARACTER){
                    for (int y = 0; y < palabraObjeto.texto.length(); y++){
                        caracterIndividual = palabraObjeto.texto.charAt(y);
                        palabraCaracter = Character.toString(caracterIndividual);
                        menu.addElement(palabraObjeto.tipo.tipo + " " + palabraCaracter);
                    }
                } 
                else{
                    menu.addElement(palabraObjeto.tipo.tipo + " " + palabraObjeto.texto);
                }

            
        }
        //FIN DEL FOR
    }//GEN-LAST:event_jButton1MouseClicked
        
        
        String hard=txtCadena.getText();
       menu.addElement(hard);
        
        txtCadena.setText(""); 
    }//GEN-LAST:event_btnOperarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Bai");
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOperar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCadena;
    // End of variables declaration//GEN-END:variables
}
