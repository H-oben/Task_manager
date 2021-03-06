package GUI;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultComboBoxModel;
import peoplePack.Person;
import taskPackage.*;

/**
 * @author h_obe
 */
public class TaskCreation extends javax.swing.JDialog{
    private final mainFrame p = (mainFrame)this.getParent();
    private final DefaultComboBoxModel model = new DefaultComboBoxModel(getUsers());
    
    /**
     * Creates new form TaskCreation
     * @param parent mainFrame
     * @param modal always true
     */
    public TaskCreation(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ErrorLabel.setVisible(false);
        UserAssign.setModel(model);
        SingleButton.setSelected(true); // default one time task, dont have to account for no button selected
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        typeGroup = new javax.swing.ButtonGroup();
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
        SingleButton = new javax.swing.JRadioButton();
        DailyButton = new javax.swing.JRadioButton();
        WeeklyButton = new javax.swing.JRadioButton();
        YearlyButton = new javax.swing.JRadioButton();
        TypeLabel = new javax.swing.JLabel();
        MonthlyButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Task Creation Window"); // NOI18N
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

        DateLabel.setBackground(new java.awt.Color(0, 0, 0));
        DateLabel.setForeground(new java.awt.Color(0, 0, 0));
        DateLabel.setLabelFor(DateEntry);
        DateLabel.setText("Due Date:");

        UserAssign.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        AssignLabel.setForeground(new java.awt.Color(0, 0, 0));
        AssignLabel.setLabelFor(UserAssign);
        AssignLabel.setText("Assign To:");

        ErrorLabel.setForeground(new java.awt.Color(0, 0, 0));

        typeGroup.add(SingleButton);
        SingleButton.setForeground(new java.awt.Color(0, 0, 0));
        SingleButton.setText("One Time Task");

        typeGroup.add(DailyButton);
        DailyButton.setForeground(new java.awt.Color(0, 0, 0));
        DailyButton.setText("Daily Task");

        typeGroup.add(WeeklyButton);
        WeeklyButton.setForeground(new java.awt.Color(0, 0, 0));
        WeeklyButton.setText("Weekly Task");

        typeGroup.add(YearlyButton);
        YearlyButton.setForeground(new java.awt.Color(0, 0, 0));
        YearlyButton.setText("Yearly Task");

        TypeLabel.setForeground(new java.awt.Color(0, 0, 0));
        TypeLabel.setText("Type:");

        typeGroup.add(MonthlyButton);
        MonthlyButton.setForeground(new java.awt.Color(0, 0, 0));
        MonthlyButton.setText("Monthly Task");

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
                            .addComponent(DateLabel)
                            .addComponent(AssignLabel)
                            .addComponent(TypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UserAssign, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(WeeklyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DateEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SingleButton)
                                    .addComponent(YearlyButton))
                                .addGap(0, 0, 0)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DailyButton)
                                            .addComponent(MonthlyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))))
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
                        .addComponent(DateEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DescEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DescLabel)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UserAssign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AssignLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SingleButton)
                            .addComponent(DailyButton)
                            .addComponent(TypeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MonthlyButton)
                            .addComponent(WeeklyButton))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CataEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ErrorLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(YearlyButton)))
                .addGap(10, 10, 10)
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
        Task t = this.getCreatedTask();
        if(t!=null){
            p.openTasks.add(t);
            p.setTaskOptions();
            p.setTableTop();
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }

    }//GEN-LAST:event_CreateButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed
    
    private String[] getUsers(){
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
            java.util.logging.Logger.getLogger(TaskCreation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            TaskCreation dialog = new TaskCreation(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    
    //task creation logic
    private Task getCreatedTask(){
        ErrorLabel.setVisible(false);
        Color c = ColorPick.getColor();
        String d = DescEntry.getText();
        String n = NameEntry.getText();
        String date = DateEntry.getText();
        LocalDate due;
        try{
            due = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        }
        catch(Exception e){
            due = null;
        }
        Categories cat;
        String cata = CataEntry.getText();
        int x = UserAssign.getSelectedIndex();
        Person assigned = p.assignablePeople.get(x);
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
        if(date.isEmpty() || date.equals("YYY-MM-DD") || date.isBlank()){
            ErrorLabel.setText("Date cannot be blank");
            ErrorLabel.setVisible(true);
            return(null);
        }
        else if(due == null || !due.isAfter(p.getToday())){
            ErrorLabel.setText("Date is invalid");
            ErrorLabel.setVisible(true);
            return(null);
        }
        else{
            ErrorLabel.setVisible(false);
            if(SingleButton.isSelected()){
                return(new Task(n,d,cat,c,due,assigned,p.CurrentUser));
            }
            else if(DailyButton.isSelected()){
                return(new RecurringTask(n,d,cat,c,due,assigned,p.CurrentUser,RecurType.DAILY));
            }
            else if(MonthlyButton.isSelected()){
                return(new RecurringTask(n,d,cat,c,due,assigned,p.CurrentUser,RecurType.MONTHLY));
            }
            else if(WeeklyButton.isSelected()){
                return(new RecurringTask(n,d,cat,c,due,assigned,p.CurrentUser,RecurType.WEEKLY));
            }
            else{
                return(new RecurringTask(n,d,cat,c,due,assigned,p.CurrentUser,RecurType.YEARLY));
            }
        }
    }
    
    //<editor-fold desc="Generated Variables" defaultstate="collapsed">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AssignLabel;
    private javax.swing.JTextField CataEntry;
    private javax.swing.JLabel CataLabel;
    private javax.swing.JColorChooser ColorPick;
    private javax.swing.JButton CreateButton;
    private javax.swing.JRadioButton DailyButton;
    private javax.swing.JTextField DateEntry;
    private javax.swing.JLabel DateLabel;
    private java.awt.TextField DescEntry;
    private javax.swing.JLabel DescLabel;
    private javax.swing.JLabel ErrorLabel;
    private javax.swing.JRadioButton MonthlyButton;
    private java.awt.TextField NameEntry;
    private javax.swing.JRadioButton SingleButton;
    private javax.swing.JLabel TaskNameLabel;
    private javax.swing.JLabel TypeLabel;
    private javax.swing.JComboBox<String> UserAssign;
    private javax.swing.JRadioButton WeeklyButton;
    private javax.swing.JRadioButton YearlyButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.ButtonGroup typeGroup;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}
