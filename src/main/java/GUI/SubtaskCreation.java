package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import peoplePack.Person;
import taskPackage.*;

/**
 * @author h_obe
 */
public class SubtaskCreation extends javax.swing.JDialog{
    private final mainFrame p = (mainFrame)this.getParent();
    private final DefaultComboBoxModel model = new DefaultComboBoxModel(getUsers());
    private final Task head = p.visibleTasks.get(p.TaskSelection.getSelectedIndex());
    
    /**
     * Creates new form TaskCreation
     * @param parent mainFrame
     * @param modal always true
     */
    public SubtaskCreation(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ErrorLabel.setVisible(false);
        UserAssign.setModel(model);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        CreateButton = new javax.swing.JButton();
        NameEntry = new java.awt.TextField();
        DescEntry = new java.awt.TextField();
        DescLabel = new javax.swing.JLabel();
        TaskNameLabel = new javax.swing.JLabel();
        ColorPick = new javax.swing.JColorChooser();
        CataEntry = new javax.swing.JTextField();
        CataLabel = new javax.swing.JLabel();
        DateEntry = new javax.swing.JTextField();
        DateLabel = new javax.swing.JLabel();
        UserAssign = new javax.swing.JComboBox<>();
        AssignLabel = new javax.swing.JLabel();
        ErrorLabel = new javax.swing.JLabel();
        DateSame = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setName("Subtask Creation  Window"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));

        jPanel1.setBackground(new java.awt.Color(150, 200, 200));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        cancelButton.setText("Cancel");
        cancelButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        CreateButton.setText("Create");
        CreateButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateButtonActionPerformed(evt);
            }
        });

        NameEntry.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        NameEntry.setName("Name entry"); // NOI18N
        NameEntry.setPreferredSize(new java.awt.Dimension(40, 20));

        DescEntry.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        DescEntry.setName("Name entry"); // NOI18N
        DescEntry.setPreferredSize(new java.awt.Dimension(40, 20));

        DescLabel.setBackground(new java.awt.Color(150, 200, 200));
        DescLabel.setForeground(new java.awt.Color(0, 0, 0));
        DescLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DescLabel.setLabelFor(DescEntry);
        DescLabel.setText("Description:");

        TaskNameLabel.setBackground(new java.awt.Color(150, 200, 200));
        TaskNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        TaskNameLabel.setLabelFor(NameEntry);
        TaskNameLabel.setText("Task Name:");

        CataEntry.setBackground(new java.awt.Color(255, 255, 255));
        CataEntry.setForeground(new java.awt.Color(0, 0, 0));

        CataLabel.setBackground(new java.awt.Color(0, 0, 0));
        CataLabel.setForeground(new java.awt.Color(0, 0, 0));
        CataLabel.setText("Catagory:");

        DateEntry.setBackground(new java.awt.Color(255, 255, 255));
        DateEntry.setForeground(new java.awt.Color(0, 0, 0));
        DateEntry.setText("YYYY-MM-DD");
        DateEntry.setMinimumSize(new java.awt.Dimension(64, 89));

        DateLabel.setBackground(new java.awt.Color(0, 0, 0));
        DateLabel.setForeground(new java.awt.Color(0, 0, 0));
        DateLabel.setLabelFor(DateEntry);
        DateLabel.setText("Due Date:");

        UserAssign.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        AssignLabel.setForeground(new java.awt.Color(0, 0, 0));
        AssignLabel.setLabelFor(UserAssign);
        AssignLabel.setText("Assign To:");

        ErrorLabel.setForeground(new java.awt.Color(0, 0, 0));

        DateSame.setForeground(new java.awt.Color(0, 0, 0));
        DateSame.setText("Same as parent");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ColorPick, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DescLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                            .addComponent(TaskNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CataLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DescEntry, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(CataEntry)
                            .addComponent(NameEntry, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DateLabel)
                                    .addComponent(AssignLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(DateEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(DateSame)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(UserAssign, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(ErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NameEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TaskNameLabel)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DateEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DateSame)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DescEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DescLabel)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(UserAssign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AssignLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CataEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ErrorLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ColorPick, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(CreateButton))
                .addContainerGap())
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

    private void CreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateButtonActionPerformed
        Subtask t = this.getCreatedSubtask();
        if(t!=null){
            p.visibleTasks.get(p.TaskSelection.getSelectedIndex()).addSubtask(t);
        }
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        p.setTableTop();
        p.setTaskOptions();
    }//GEN-LAST:event_CreateButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        //this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed
    
    private String[] getUsers(){ //members can assign tasks to themsevles, team leads to themselves and  members, managers to anyone
        String[] users = new String[p.assignablePeople.size()];
        for(int x = 0; x<users.length;x++){
            users[x]=p.assignablePeople.get(x).getName();
        }
        return(users);
    }
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubtaskCreation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            SubtaskCreation dialog = new SubtaskCreation(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    
    private Subtask getCreatedSubtask(){
        Color c = ColorPick.getColor();
        String d = DescEntry.getText();
        String n = NameEntry.getText();
        String date = DateEntry.getText();
        LocalDate due=null;
        //error handle
        if(DateSame.isSelected()){
            due = head.getDueDate();
        }
        else{
            try{
                due = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
            }
            catch(Exception e){
                if(date.isEmpty() || date.equals("YYY-MM-DD") || date.isBlank()){
                    ErrorLabel.setText("Date cannot be blank");
                }
                else if(due == null || !due.isAfter(p.getToday())){
                    ErrorLabel.setText("Date is invalid");
                }
                else{
                    ErrorLabel.setText(e.getMessage());
                }
                ErrorLabel.setVisible(true);
                return(null);
            }
        }
        int x = UserAssign.getSelectedIndex(); 
        Person assigned = p.assignablePeople.get(x);
        
        Categories cat; //set category
        String cata = CataEntry.getText();
        if(!cata.isBlank() && !cata.isEmpty()){
            cat = new Categories(CataEntry.getText());
        }
        else{
            cat= new Categories();
        }
        
        if(n.isBlank() || n.isEmpty()){
            ErrorLabel.setText("Name cannot be blank");
            ErrorLabel.setVisible(true);
            return(null);
        }
        ErrorLabel.setVisible(false);
        return(new Subtask(n,d,cat,c,due,assigned,p.CurrentUser,head));
        
    }
    
    /**
     * @param s subtask object
     * @return object array to be used in mainFrame's JTable
     */
    private Object[] toRow(Subtask s){
        JButton MarkComplete= new JButton("Mark Complete");
        JButton marSt = new JButton("Mark Started");
        MarkComplete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        marSt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MarkComplete.addActionListener((ActionEvent evt) ->{
            MarkCompleteActionPerformed(evt);
        });
        marSt.addActionListener((ActionEvent evt) ->{
            MarkStartedActionPerformed(evt);
        });
        Object[] r = {s.getName(),s.getStatus().toString(), s.getCategory().toString()
        , s.getDueDate().toString(), s.assignment().getName(), s.creator().getName(),marSt , MarkComplete};
        return(r);
    }
    private void MarkCompleteActionPerformed(ActionEvent e){
        for(int x = 0; x < p.SubtaskTable.getRowCount(); x++){
            if(((JButton)e.getSource()).equals(p.SubtaskTable.getValueAt(x, 7))){
                p.openTasks.get(p.TaskSelection.getSelectedIndex()).getTask(x).setStatus(Status.COMPLETE);
            }
        }        
        p.setTableTop();
    }
    private void MarkStartedActionPerformed(ActionEvent e){
        for(int x = 0; x < p.SubtaskTable.getRowCount(); x++){
            if(((JButton)e.getSource()).equals(p.SubtaskTable.getValueAt(x, 6))){
                p.openTasks.get(p.TaskSelection.getSelectedIndex()).getTask(x).setStatus(Status.IN_PROGRESS);
            }
        }        
        p.setTableTop();
    }
    
    //<editor-fold desc="generated variables" defaultstate="collapsed">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AssignLabel;
    private javax.swing.JTextField CataEntry;
    private javax.swing.JLabel CataLabel;
    private javax.swing.JColorChooser ColorPick;
    private javax.swing.JButton CreateButton;
    private javax.swing.JTextField DateEntry;
    private javax.swing.JLabel DateLabel;
    private javax.swing.JCheckBox DateSame;
    private java.awt.TextField DescEntry;
    private javax.swing.JLabel DescLabel;
    private javax.swing.JLabel ErrorLabel;
    private java.awt.TextField NameEntry;
    private javax.swing.JLabel TaskNameLabel;
    private javax.swing.JComboBox<String> UserAssign;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}
