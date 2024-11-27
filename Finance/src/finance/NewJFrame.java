

package finance;

import java.text.SimpleDateFormat;
import java.util.Stack;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class NewJFrame extends javax.swing.JFrame {

   
    public NewJFrame() {
        initComponents();
    }

      private DefaultTableModel model;
    private TransactionList transactions = new TransactionList();
    private Stack<Transaction> undoStack = new Stack<>();
    SimpleDateFormat dateFormat;

    class Transaction {

        String wow;
        String txt;
        double amo;
        String theDate;
        Transaction next;

        public Transaction(String date, String description, String type, double amount) {
            this.wow = type;
            this.amo = amount;
            this.theDate = date;
            this.txt = description;
            this.next = null;
        }

        @Override
        public String toString() {
            return wow + " | Amount: " + amo + " | Date: " + txt + " | Description: ";
        }
    }

    class TransactionList {

        private Transaction head;

        public void addTransaction(String type, double amount, String date, String description) {
            Transaction newTransaction = new Transaction(date, description, type, amount);
            if (head == null) {
                head = newTransaction;
            } else {
                Transaction current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newTransaction;
            }
        }
        public void displayTransactions() {
            model.setRowCount(0);
            Transaction current = head;
            while (current != null) {
                model.addRow(new Object[]{current.theDate, current.txt, current.wow, current.amo});
                current = current.next;
            }
        }
        public void sortTransactions(boolean byAmount) {
            if (head == null || head.next == null) {
                JOptionPane.showMessageDialog(null, "No transactions to sort.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            boolean swapped;
            do {
                swapped = false;
                Transaction current = head;
                while (current.next != null) {
                    boolean condition = byAmount
                            ? current.amo > current.next.amo
                            : current.theDate.compareTo(current.next.theDate) > 0;
                    if (condition) {
                        String tempType = current.wow;
                        double tempAmount = current.amo;
                        String tempDate = current.theDate;
                        String tempDescription = current.txt;

                        current.wow = current.next.wow;
                        current.amo = current.next.amo;
                        current.theDate = current.next.theDate;
                        current.txt = current.next.txt;

                        current.next.wow = tempType;
                        current.next.amo = tempAmount;
                        current.next.theDate = tempDate;
                        current.next.txt = tempDescription;

                        swapped = true;
                    }
                    current = current.next;
                }
            } while (swapped);

            JOptionPane.showMessageDialog(null, "Transactions sorted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        }

        public Transaction removeLastTransaction() {
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                Transaction temp = head;
                head = null;
                return temp;
            }
            Transaction current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            Transaction temp = current.next;
            current.next = null;
            return temp;
        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        d = new com.toedter.calendar.JDateChooser();
        jTextField4 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField7 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField8 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Description", "Type", "Amount"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1010, 380));
        jPanel1.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, 130, 60));
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 480, 120, 60));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Income", "Expense" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 480, 140, 60));
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 480, 160, 60));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton1.setText("Sort By Amount");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, -1, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton2.setText("Sort By Date");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 580, -1, 30));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton3.setText("Undo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 580, 80, 30));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton4.setText("Add");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 580, 80, 30));

        jButton5.setText("Total Balance");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 580, -1, 30));

        jTextField8.setText("Balance: ");
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 570, 160, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel1.setText("Date:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 506, 50, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel2.setText("Description:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 500, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel3.setText("Type:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 490, -1, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel4.setText("Amount:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 500, -1, -1));

        jLabel5.setFont(new java.awt.Font("Goudy Old Style", 1, 24)); // NOI18N
        jLabel5.setText("PERSONAL FINANCE MANAGEMENT");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 420, 60));

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       transactions.sortTransactions(true);
        transactions.displayTransactions();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         transactions.sortTransactions(false);
        transactions.displayTransactions();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         if (undoStack.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No transactions to undo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Transaction removed = undoStack.pop();
        transactions.removeLastTransaction();
        transactions.displayTransactions();
        JOptionPane.showMessageDialog(null, "Last transaction undone.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String theDate;
        try {
            theDate = dateFormat.format(d.getDate());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Please select a valid date.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String txt = jTextField4.getText().trim();
        String wow = (String) jComboBox1.getSelectedItem();
        String amo = jTextField7.getText().trim();

        double amount;
        try {
            amount = Double.parseDouble(amo);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid amount entered.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{theDate, txt, wow, amount});

        Transaction transaction = new Transaction(theDate, txt, wow, amount);
        undoStack.push(transaction);
        transactions.addTransaction(wow, amount, theDate, txt);

  
        JOptionPane.showMessageDialog(null, "Transaction added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         double totalBalance = 0.0;
        Transaction current = transactions.head; 

       
        while (current != null) {
            if ("Income".equalsIgnoreCase(current.wow)) {
                totalBalance += current.amo; 
            } else if ("Expense".equalsIgnoreCase(current.wow)) {
                totalBalance -= current.amo; 
            }
            current = current.next;
        }
        jTextField8.setText("Balance: P" + totalBalance);

    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser d;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
