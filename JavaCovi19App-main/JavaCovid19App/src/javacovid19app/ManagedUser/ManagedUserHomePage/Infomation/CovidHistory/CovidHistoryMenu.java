
package javacovid19app.ManagedUser.ManagedUserHomePage.Infomation.CovidHistory;

import com.mysql.jdbc.Connection;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.sql.*;
import javacovid19app.Manager.ManagerHomePage.DataClasses.CovidHistory;
import javacovid19app.Manager.ManagerHomePage.DataClasses.ManagedUser;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;




public class CovidHistoryMenu extends javax.swing.JFrame {
    private ArrayList <CovidHistory> covidHistoryList=new ArrayList<> ();
    private ArrayList <ManagedUser>managedUserList = new ArrayList<> ();
    
    String userID="";
    
    public CovidHistoryMenu() {
        initComponents();
        this.setResizable(false); // can not fix size of a Frame;
        this.setTitle("Covid History");
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        
        statusTextField.setEditable(false);
        beginTimeTextField.setEditable(false);
        endTimeTextField.setEditable(false);
        involvedPersonTextField.setEditable(false);
    }
    
    public CovidHistoryMenu(String username,ArrayList <ManagedUser>List){
        initComponents();
        this.setResizable(false);
        this.setTitle("Covid History");
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        this.userID=username;
        this.managedUserList=List;
        
        statusTextField.setEditable(false);
        beginTimeTextField.setEditable(false);
        endTimeTextField.setEditable(false);
        involvedPersonTextField.setEditable(false);
     
        getCovidHistoryList();
        show_historyCovid();
        
        //edit size of column
        covidHistoryTable.getTableHeader().setFont(new Font("Fredoka One", Font.PLAIN, 14));
        final TableColumnModel columnModel = covidHistoryTable.getColumnModel();
        for (int column = 0; column < covidHistoryTable.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < covidHistoryTable.getRowCount(); row++) {
                TableCellRenderer renderer = covidHistoryTable.getCellRenderer(row, column);
                Component comp = covidHistoryTable.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            if(width > 300)
                width=300;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
    
    
    public void show_historyCovid(){
        DefaultTableModel model=(DefaultTableModel)covidHistoryTable.getModel();
        Object row[]=new Object[4];
        String relatePerson="";
        
        for(int i=0;i<managedUserList.size();i++){
            if(managedUserList.get(i).getID().compareTo(userID)==0){
               // Traverse all managedUSerList to find involved person
                for(int j=0;j<managedUserList.size();j++){
                    if(managedUserList.get(j).getID().compareTo(managedUserList.get(i).getInvolvedID())==0){
                        relatePerson=managedUserList.get(j).getFullname();
                    }
                } 
            }
        }
        
        for (int i=0;i<covidHistoryList.size();i++){
            row[0]=covidHistoryList.get(i).getStatus();
            row[1]=covidHistoryList.get(i).getBeginTime();
            row[2]=covidHistoryList.get(i).getEndTime();
            row[3]=relatePerson;
            model.addRow(row);
        }
    }
    
    // get Facility data
    public void getCovidHistoryList(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6448649?useSSL = true", "sql6448649", "ygTCgTJZu6");
            Statement state = connect.createStatement();

            String sql = "Select * from CovidHistory where CovidHistory.UserID= '"+userID+"'";
            ResultSet res = state.executeQuery(sql);
            
            CovidHistory tmp;
            while(res.next()){
                tmp = new CovidHistory(res.getString("UserID"), res.getDate("BeginTime"),res.getDate("EndTime"), res.getString("Status"),res.getString("InvolvedPerson")); 
                this.covidHistoryList.add(tmp);
            }
            connect.close();
           }catch(Exception e){
           System.out.println(e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        covidHistoryTable = new javax.swing.JTable();
        involvedPersonTextField = new javax.swing.JTextField();
        statusTextField = new javax.swing.JTextField();
        beginTimeTextField = new javax.swing.JTextField();
        endTimeTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backLabelMouseClicked(evt);
            }
        });
        getContentPane().add(backLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, 60));

        covidHistoryTable.setBackground(new java.awt.Color(153, 255, 153));
        covidHistoryTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        covidHistoryTable.setFont(new java.awt.Font("Fredoka One", 0, 16)); // NOI18N
        covidHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STATUS", "BEGIN TIME", "END TIME", "INVOLVED"
            }
        ));
        covidHistoryTable.setOpaque(false);
        covidHistoryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                covidHistoryTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(covidHistoryTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 126, 510, 310));

        involvedPersonTextField.setFont(new java.awt.Font("Fredoka One", 0, 16)); // NOI18N
        involvedPersonTextField.setForeground(new java.awt.Color(255, 255, 255));
        involvedPersonTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        involvedPersonTextField.setOpaque(false);
        getContentPane().add(involvedPersonTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 150, 30));

        statusTextField.setFont(new java.awt.Font("Fredoka One", 0, 16)); // NOI18N
        statusTextField.setForeground(new java.awt.Color(255, 255, 255));
        statusTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        statusTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        statusTextField.setOpaque(false);
        getContentPane().add(statusTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 150, 30));

        beginTimeTextField.setFont(new java.awt.Font("Fredoka One", 0, 16)); // NOI18N
        beginTimeTextField.setForeground(new java.awt.Color(255, 255, 255));
        beginTimeTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        beginTimeTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        beginTimeTextField.setOpaque(false);
        getContentPane().add(beginTimeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 150, 30));

        endTimeTextField.setFont(new java.awt.Font("Fredoka One", 0, 16)); // NOI18N
        endTimeTextField.setForeground(new java.awt.Color(255, 255, 255));
        endTimeTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        endTimeTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        endTimeTextField.setOpaque(false);
        getContentPane().add(endTimeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 150, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javacovid19app/ManagedUser/ManagedUserHomePage/Infomation/CovidHistory/CovidHistoryBackground.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backLabelMouseClicked
        dispose();
    }//GEN-LAST:event_backLabelMouseClicked

    private void covidHistoryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_covidHistoryTableMouseClicked
        int i = covidHistoryTable.getSelectedRow();
        TableModel model=covidHistoryTable.getModel();
        statusTextField.setText(model.getValueAt(i, 0).toString());
        beginTimeTextField.setText(model.getValueAt(i, 1).toString());
        if(model.getValueAt(i,2)!=null && model.getValueAt(i,2).toString().trim().length()!=0){
            endTimeTextField.setText(model.getValueAt(i, 2).toString());
        }
        else{
            endTimeTextField.setText("NULL");
        }
        involvedPersonTextField.setText(model.getValueAt(i, 3).toString());
    }//GEN-LAST:event_covidHistoryTableMouseClicked

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
            java.util.logging.Logger.getLogger(CovidHistoryMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CovidHistoryMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CovidHistoryMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CovidHistoryMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CovidHistoryMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backLabel;
    private javax.swing.JTextField beginTimeTextField;
    private javax.swing.JTable covidHistoryTable;
    private javax.swing.JTextField endTimeTextField;
    private javax.swing.JTextField involvedPersonTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField statusTextField;
    // End of variables declaration//GEN-END:variables
}
