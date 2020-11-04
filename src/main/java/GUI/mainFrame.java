package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import peoplePack.*;
import taskPackage.*;

/**TODO:
 * sorted tasks
 * movement of complete tasks to closedTasks and out of openTasks
 * implement changing of data other than status
 * have description change to subtask description when selected
 * ***change table view from JTable to pseudo table layout, JTable is annoying to work with
 * Control logic for task assignment: 
 *  - don't let members assign tasks to others
 *  - Team Lead can only assign to team members they are leading or themselves
 *  - other logic once fully functional
 * If I have time:
 *  - fix subtasks so they can have subtasks as well
 *  - implement web layout
 */

/**
 *<p>
 * Public variables used where it makes sense, 
 * mainly to allow easy manipulation between frames/dialogues
 * </p>
 * @author Hunter Obendorfer 1834106
 */
public class mainFrame extends javax.swing.JFrame{

    //custom variables
    private  Manager admin; //could be final but that causes errors I'm not dealing with
    public Person CurrentUser;
    private LocalDate today = LocalDate.now();
    
    public ArrayList<Person> users = new ArrayList<>();
    public ArrayList<Task> openTasks = new ArrayList<>();
    public ArrayList<Task> closedTasks = new ArrayList<>();
    
    private DefaultComboBoxModel m;
    private DefaultTableModel table;
    
    public mainFrame() {
        try{ //add default admin user
            char[] pass = "Adm1n".toCharArray();
            admin = new Manager("Admin","Admin",pass,Role.MANAGER);
        }
        catch(MemberManagerException exc){ //unreachable but required
            admin = new Manager();
        }
        users.add(admin);
        //default task for admin
        openTasks.add(new Task("Create Tasks","Create tasks for employees to work on"
        ,new Categories("Administrative"),new Color(100,200,200), LocalDate.MAX, admin,admin));
        openTasks.get(0).addSubtask(new Subtask("sub","",new Categories(), new Color(100,100,100), LocalDate.MAX, admin, admin,openTasks.get(0)));
        initComponents();
        //Reminder: all custom populization of elements must occur AFTER initComponents()
        
        TableTop.addMouseListener(new JTableButtonMouseListener(TableTop));
        SubtaskTable.addMouseListener(new JTableButtonMouseListener(SubtaskTable));
        
        //login comes up before main menu
        loginCreationMenu l = new loginCreationMenu(this, true);
        l.setVisible(true);
        
        //set the table
        setTaskOptions();
        setTableTop();
        //visibility of team lead specific button
        if(CurrentUser.getRole()!=Role.TEAMLEAD){
            addTeamMember.setVisible(false);
            addTeamMember.setEnabled(false);
        }
    }
    
    //custom methods
    public LocalDate getToday(){
        return today;
    }
    //updates open tasks drop down options
    public final void setTaskOptions(){
        String[] mode;
        mode = new String[openTasks.size()];
        for(int x = 0; x<mode.length; x++){
            mode[x] = openTasks.get(x).getName();
        }
        m = new DefaultComboBoxModel(mode);
        TaskSelection.setModel(m);
    }
    //updates table view with open task drop down selection
    public final void setTableTop(){
        //<editor-fold defaultstate="collasped" desc="Set First Table">
        String[] columnNames = {"Name","Status","Catagory","Due Date"
                ,"Assigned To","Assigned By","Create Subtask","Mark Started","Mark Complete"};
        Object[][] taskData = new Object[1][9];
        //instantiate and design buttons/combBox
        JButton CreateSub = new JButton(columnNames[6]);
        JButton MarkStarted = new JButton(columnNames[7]);
        JButton CompleteButton = new JButton(columnNames[8]);
        
        CreateSub.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CompleteButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MarkStarted.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        
        //subtask button action
        CreateSub.addActionListener((ActionEvent e) -> {
            CreateSubtaskActionPerformed(e);
        });
        CompleteButton.addActionListener((ActionEvent e) -> {
            MarkSubtaskCompleteActionPerformed(e);
        });
        MarkStarted.addActionListener((ActionEvent e) ->{
            MarkSubtaskStartedActionPerformed(e);
        });
        
        int selected = TaskSelection.getSelectedIndex();
        Task t = openTasks.get(selected);
        if(selected>=0){
            if(selected < openTasks.size() && openTasks.get(selected)!=null){ //create table model
                taskData[0][0] = t.getName();
                taskData[0][1] = t.getStatus().toString();
                taskData[0][2] = t.getCategory().toString();
                taskData[0][3] = t.getDueDate().toString();
                taskData[0][4] = t.assignment().getName();
                taskData[0][5] = t.creator().getName();
                taskData[0][6] = CreateSub;
                taskData[0][7] = MarkStarted;
                taskData[0][8] = CompleteButton;
                DescrArea.setText("Description:\n" + t.describe());
            }
        }
        //set table
        table = new DefaultTableModel(taskData,columnNames){
            @Override
            public boolean isCellEditable(int r, int c){
                if(c == 6 || c == 7 || c == 8){ //prevents error caused by editing buttons
                    return(false);
                }
                else{
                    return(true);
                }
            }
        };
        TableTop.setModel(table);
        
        TableTop.getColumn("Create Subtask").setCellRenderer(new JTableButtonRender());
        TableTop.getColumn("Mark Started").setCellRenderer(new JTableButtonRender());
        TableTop.getColumn("Mark Complete").setCellRenderer(new JTableButtonRender());
        
        TableTop.setBackground(t.getColor());
        
        
        //action/mouse listeners
        TableTop.addMouseListener(new JTableButtonMouseListener(TableTop));
        //show table
        TableTop.repaint();
        //</editor-fold>
        
        //<editor-fold defaultstate="collasped" desc="Set Second Table">
        Object[] subtaskHeader = {"Name","Status","Catagory","Due Date"
                ,"Assigned To","Assigned By","Mark Started","Mark Complete"};
        DefaultTableModel two = new DefaultTableModel(new Object[0][0],subtaskHeader){
        @Override
            public boolean isCellEditable(int r, int c){ //fix for role specific data manipulation
                if(c == 6 || c == 7){
                    return(false);
                }
                else{
                    return(true);
                }
            }
        };
        openTasks.get(TaskSelection.getSelectedIndex()).getSubtasks().forEach(a -> {
            two.addRow(getSubArray(a));
        });
        SubtaskTable.setModel(two);
        SubtaskTable.setBackground(new Color(100,200,200)); //fix for other colors
        SubtaskTable.getColumn("Mark Started").setCellRenderer(new JTableButtonRender());
        SubtaskTable.getColumn("Mark Complete").setCellRenderer(new JTableButtonRender());
        SubtaskTable.addMouseListener(new JTableButtonMouseListener(SubtaskTable));
        SubtaskTable.repaint();
        
    //</editor-fold>
    this.repaint();
    }
    private Object[] getSubArray(Subtask s){
        JButton mkSt = new JButton("Mark Started");
        JButton mkD = new JButton("Mark Complete");
        mkSt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mkD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mkSt.addActionListener((ActionEvent e)->{
            MarkStartedActionPerformed(e);
        });
        mkD.addActionListener((ActionEvent e)->{
            MarkCompleteActionPerformed(e);
        });
        Object[] a = {s.getName(),s.getStatus().toString(), s.getCategory().toString(), s.getDueDate().toString(),
            s.assignment().toString(), s.creator().getName(),mkSt,mkD}; 
        return(a);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SidePanel = new javax.swing.JPanel();
        Create_Task_Button = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        TaskSelection = new javax.swing.JComboBox<>();
        OpenTaskLabel = new javax.swing.JLabel();
        addTeamMember = new javax.swing.JButton();
        ViewsPane = new javax.swing.JTabbedPane();
        TabularView = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableTop = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        SubtaskTable = new javax.swing.JTable();
        DescrScroll = new javax.swing.JScrollPane();
        DescrArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Task Manager");
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(700, 550));

        SidePanel.setBackground(new java.awt.Color(100, 152, 252));

        Create_Task_Button.setText("Create Task");
        Create_Task_Button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Create_Task_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Create_Task_ButtonActionPerformed(evt);
            }
        });

        ExitButton.setText("Exit");
        ExitButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        TaskSelection.setName("Tasks"); // NOI18N
        TaskSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaskSelectionActionPerformed(evt);
            }
        });

        OpenTaskLabel.setForeground(new java.awt.Color(0, 0, 0));
        OpenTaskLabel.setLabelFor(TaskSelection);
        OpenTaskLabel.setText("Open Tasks");

        addTeamMember.setText("Add Team Member");
        addTeamMember.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addTeamMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTeamMemberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SidePanelLayout = new javax.swing.GroupLayout(SidePanel);
        SidePanel.setLayout(SidePanelLayout);
        SidePanelLayout.setHorizontalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Create_Task_Button, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(ExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TaskSelection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OpenTaskLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addTeamMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        SidePanelLayout.setVerticalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Create_Task_Button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OpenTaskLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TaskSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addTeamMember)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 422, Short.MAX_VALUE)
                .addComponent(ExitButton)
                .addContainerGap())
        );

        ViewsPane.setBackground(new java.awt.Color(150, 200, 200));
        ViewsPane.setForeground(new java.awt.Color(0, 0, 0));
        ViewsPane.setOpaque(true);

        TabularView.setBackground(new java.awt.Color(175, 200, 200));

        jPanel1.setBackground(new java.awt.Color(200, 200, 200));

        jScrollPane2.setBackground(new java.awt.Color(200, 200, 200));

        TableTop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableTop.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        TableTop.setMinimumSize(new java.awt.Dimension(60, 850));
        TableTop.setRowSelectionAllowed(false);
        TableTop.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TableTop.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TableTop.setShowHorizontalLines(true);
        TableTop.setShowVerticalLines(true);
        TableTop.getTableHeader().setReorderingAllowed(false);
        TableTop.removeRowSelectionInterval(1, 3);
        jScrollPane2.setViewportView(TableTop);

        SubtaskTable.setModel(new javax.swing.table.DefaultTableModel(
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
        SubtaskTable.setMinimumSize(new java.awt.Dimension(60, 850));
        jScrollPane1.setViewportView(SubtaskTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 380, Short.MAX_VALUE))
        );

        TabularView.setViewportView(jPanel1);

        ViewsPane.addTab("Tabular View", TabularView);

        DescrArea.setBackground(new java.awt.Color(200, 200, 200));
        DescrArea.setColumns(20);
        DescrArea.setForeground(new java.awt.Color(0, 0, 0));
        DescrArea.setRows(5);
        DescrArea.setText("Description");
        DescrScroll.setViewportView(DescrArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ViewsPane, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addComponent(DescrScroll)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ViewsPane, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(DescrScroll))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Create_Task_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Create_Task_ButtonActionPerformed
        TaskCreation t = new TaskCreation(this, true);
        t.setVisible(true);
        t.requestFocus();
        t.pack();
        t.repaint();
    }//GEN-LAST:event_Create_Task_ButtonActionPerformed

    private void CreateSubtaskActionPerformed(ActionEvent e){
        SubtaskCreation sc = new SubtaskCreation(this, true);
        sc.setVisible(true);
        sc.requestFocus();
        //sc.pack();
        //sc.repaint();
    }
    
    private void MarkCompleteActionPerformed(ActionEvent e){ 
        for(int x = 0; x< TableTop.getRowCount(); x++){
            if(((JButton)e.getSource()).equals(TableTop.getValueAt(x, 8))){
                openTasks.get(TaskSelection.getSelectedIndex()).setStatus(Status.COMPLETE);
            }
        }        
        setTableTop();
    }
    private void MarkStartedActionPerformed(ActionEvent e) {
        for(int x = 0; x< TableTop.getRowCount(); x++){
            if(((JButton)e.getSource()).equals(TableTop.getValueAt(x, 7))){
                openTasks.get(TaskSelection.getSelectedIndex()).setStatus(Status.IN_PROGRESS);
            }
        }        
        setTableTop();
    }
    
    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        this.dispose();
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void TaskSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaskSelectionActionPerformed
        setTableTop();
    }//GEN-LAST:event_TaskSelectionActionPerformed

    private void addTeamMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTeamMemberActionPerformed
        
    }//GEN-LAST:event_addTeamMemberActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold desc=" Look and feel setting code (optional) ">
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
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new mainFrame().setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Create_Task_Button;
    private javax.swing.JTextArea DescrArea;
    private javax.swing.JScrollPane DescrScroll;
    private javax.swing.JButton ExitButton;
    private javax.swing.JLabel OpenTaskLabel;
    private javax.swing.JPanel SidePanel;
    public javax.swing.JTable SubtaskTable;
    public javax.swing.JTable TableTop;
    private javax.swing.JScrollPane TabularView;
    public javax.swing.JComboBox<Task> TaskSelection;
    private javax.swing.JTabbedPane ViewsPane;
    public javax.swing.JButton addTeamMember;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private void MarkSubtaskCompleteActionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void MarkSubtaskStartedActionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
