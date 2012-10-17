/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Decoder.java
 *
 * Created on 30.11.2011, 21:45:27
 */
package chiffre;

/**
 *
 * @author Tobias
 */
public class Decoder extends javax.swing.JFrame {

    /** Creates new form Decoder */
    public Decoder() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        urlIn = new javax.swing.JTextField();
        codeIn = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        code = new javax.swing.JButton();
        decode = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        codeAusgabe = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        urlAusgabe = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        urlIn.setText("Adresse hier eingeben");

        codeIn.setText("Code hier eingeben");

        jLabel1.setText("URL:");

        code.setText("Verschlüsseln");
        code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeActionPerformed(evt);
            }
        });

        decode.setText("Entschlüsseln");
        decode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decodeActionPerformed(evt);
            }
        });

        codeAusgabe.setColumns(20);
        codeAusgabe.setRows(5);
        jScrollPane1.setViewportView(codeAusgabe);

        jLabel2.setText("Code:");

        jLabel3.setText("Verschlüsselte URL:");

        urlAusgabe.setColumns(20);
        urlAusgabe.setRows(5);
        jScrollPane2.setViewportView(urlAusgabe);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                            .addComponent(code, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(decode)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(codeIn, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
                            .addComponent(urlIn, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(urlIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(code)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(decode)
                            .addComponent(codeIn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(188, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeActionPerformed
        // TODO add your handling code here:
        Chiffrierung c = new Chiffrierung();
        jLabel1.setText("URL:");
        String ausgabe = c.codierterInput(urlIn.getText());
        urlAusgabe.setText(ausgabe.substring(0, urlIn.getText().length()));
        codeAusgabe.setText(ausgabe.substring(urlIn.getText().length()+1));
        FileHandler.putToFile("\n"+ausgabe.substring(0, urlIn.getText().length())+
        		"\n"+ausgabe.substring(urlIn.getText().length()+1),
        		//"C:\\sites\\sites.txt");
			"/home/tobias/Arbeitsfläche/out.txt");
    }//GEN-LAST:event_codeActionPerformed

    private void decodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decodeActionPerformed
        // TODO add your handling code here:
        Chiffrierung c = new Chiffrierung();
        jLabel1.setText("Entschlüsselte URL:");
        urlIn.setText(c.entschlüsseln(urlIn.getText(), codeIn.getText()));
    }//GEN-LAST:event_decodeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Decoder().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton code;
    private javax.swing.JTextArea codeAusgabe;
    private javax.swing.JTextField codeIn;
    private javax.swing.JButton decode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea urlAusgabe;
    private javax.swing.JTextField urlIn;
    // End of variables declaration//GEN-END:variables
}
