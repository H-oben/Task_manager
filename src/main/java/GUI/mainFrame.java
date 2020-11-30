package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import peoplePack.*;
import taskPackage.*;

//note: this code is a lot easier to read if you collapse all editor folds in netbeans, CTRL+SHIFT+_

//<editor-fold desc="ToDo">
/**
 * add color column to implement different colors in subtask table
 * have description change to subtask description when selected
 * use more efficient data structures
 * add logic for task dates and status
 * ***change table view from JTable to pseudo table layout, JTable is annoying to work with
 * If I have time:
 *  - fix subtasks so they can have subtasks as well
 *  - implement web layout
 *  - sorted tasks
 */
//</editor-fold>

/**
 *<p>
 * Public variables used where it makes sense, 
 * mainly to allow easy manipulation between frames/dialogues
 * </p>
 * @author Hunter Obendorfer 1834106
 */

public class mainFrame extends javax.swing.JFrame{

    //<editor-fold desc="custom variables" defaultstate="collapsed">
    private  Manager admin; //could be final but that causes errors I'm not dealing with
    public Person CurrentUser;
    private LocalDate today = LocalDate.now();
    
    public ArrayList<Person> users = new ArrayList<>();
    public ArrayList<Task> openTasks = new ArrayList<>();
    public ArrayList<Task> closedTasks = new ArrayList<>();
    
    public ArrayList<Task> visibleTasks = new ArrayList<>();
    public ArrayList<Person> assignablePeople = new ArrayList<>();
    
    private DefaultComboBoxModel m;
    private DefaultTableModel table;
    
    private loginCreationMenu l;
    //</editor-fold>
    
    public mainFrame() {
        //<editor-fold desc="admin addition" defaultstate="collapsed">
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
        //</editor-fold>
        //<editor-fold desc="team lead testing" defaultstate="collapsed">
        char[] p = {'a','s','d','f','g'};
        member hunter = new member("Hunter", "Obendorfer", p);
        member mem = new member();
        users.add(hunter);
        users.add(mem);
        Manager lead;
        try{
            lead= new Manager("team","lead",p,Role.TEAMLEAD);
        }
        catch(Exception e){
            lead = new Manager();
        }
        users.add(lead);
        //</editor-fold>
        
        initComponents();
        //Reminder: all custom populization of elements must occur AFTER initComponents()
        TableTop.addMouseListener(new JTableButtonMouseListener(TableTop));
        SubtaskTable.addMouseListener(new JTableButtonMouseListener(SubtaskTable));
        
        //login comes up before main menu
        l = new loginCreationMenu(this, true);
        l.setVisible(true);
        
        //set assignablePeople
        if(CurrentUser.getRole()==Role.MANAGER){
            assignablePeople=users;
        }
        else if(CurrentUser.getRole()==Role.TEAMLEAD){
            assignablePeople =((Manager)CurrentUser).getTeamMembers();
            assignablePeople.add(0, CurrentUser);
        }
        else{
            assignablePeople.add(CurrentUser);
        }
        
        //set the table
        markDates();
        setTaskOptions();
        setTableTop();
        //visibility of team lead specific button
        if(CurrentUser.getRole()!=Role.TEAMLEAD){
            addTeamMember.setVisible(false);
            addTeamMember.setEnabled(false);
        }
        InvalidDate.setVisible(false);
        //<editor-fold desc="naming for testing" defaultstate="collapsed">
        CommitButton.setName("CommitButton");
        Create_Task_Button.setName("CreateTaskButton");
        DescrArea.setName("DescrArea");
        addTeamMember.setName("addTeamMember");
        //</editor-fold>
    }
    
    //custom methods
    public LocalDate getToday(){
        return today;
    }
    //updates open tasks drop down options
    public final ArrayList<Task> setTaskOptions(){
        visibleTasks.clear(); //prevents duplicates
        if(CurrentUser!=null){
            if(CurrentUser.getRole()==Role.MANAGER){ //manager can see all tasks
                visibleTasks=openTasks; //other functions will operate on visibletasks
            }
            else if(CurrentUser.getRole()==Role.TEAMLEAD){ //teamlead can see their tasks and tasks of their team
                for(int x = 0; x<openTasks.size(); x++){
                    if(openTasks.get(x).assignment().equals(CurrentUser) ||
                            ((Manager)CurrentUser).findTeamMember(openTasks.get(x).assignment()))
                        visibleTasks.add(openTasks.get(x));
                }
            }
            else{ //for members
                for(int x = 0; x<openTasks.size(); x++){
                    if(openTasks.get(x).assignment().equals(CurrentUser)){
                        visibleTasks.add(openTasks.get(x));
                    }
                }
            }
        }
        else{
            return(visibleTasks);
        }
        String[] mode = new String[visibleTasks.size()];
        for(int x = 0; x < visibleTasks.size(); x++){
            mode[x] = visibleTasks.get(x).getName();
        }
        m = new DefaultComboBoxModel(mode);
        TaskSelection.setModel(m);
        return(visibleTasks);
    }
    //updates table view with open task drop down selection
    public final boolean setTableTop(){
        int selected = TaskSelection.getSelectedIndex();
        if(selected<0){// skip everything if user has no tasks
            
            //<editor-fold desc="resets table if no selection available" defaultstate="collapsed">
            String[] columnNames = {"Name","Status","Catagory","Due Date"
                ,"Assigned To","Assigned By","Create Subtask","Mark Started","Mark Complete"};
            Object[][] taskData = new Object[1][9];
            table = new DefaultTableModel(taskData,columnNames){
            @Override
            public boolean isCellEditable(int r, int c){
                if(r<0){
                    return(false); //for empty table
                }
                if(c == 6 || c == 7 || c == 8){ //prevents error caused by editing buttons
                    return(false);
                }
                //<editor-fold desc="data editing control" defaultstate="collapsed">
                if(!visibleTasks.get(selected).creator().equals(CurrentUser)){ 
                    return(false);
                }
                if(visibleTasks.equals(openTasks.get(selected).assignment())){
                    if(c!=1 && c<=3){
                        return(true);
                    }
                }
                else{
                    if(CurrentUser.getRole()==Role.MEMBER){
                        return(false);
                    }
                    else if(CurrentUser.getRole()==Role.TEAMLEAD){
                        if(c == 2){
                            return(true);
                        }
                        else{
                            return(false);
                        }
                    }
                    else{
                        if(c == 2 || c == 3){
                            return(true);
                        }
                        else{
                            return(false);
                        }
                    }
                }
                //</editor-fold>
                return(false);
            }
        };
            TableTop.setModel(table);
            TableTop.repaint();
            Object[] subtaskHeader = {"Name","Status","Catagory","Due Date"
                ,"Assigned To","Assigned By","Mark Started","Mark Complete"};
            DefaultTableModel two = new DefaultTableModel(new Object[0][0],subtaskHeader){
        @Override
            public boolean isCellEditable(int r, int c){ //fix for role specific data manipulation
                if(r<0){
                    return(false); //for empty table
                }
                if(c == 6 || c == 7){
                    return(false);
                }
                //<editor-fold desc="data editing control" defaultstate="collapsed">
                if(!visibleTasks.get(selected).creator().equals(CurrentUser)){ 
                    return(false);
                }
                if(CurrentUser.equals(visibleTasks.get(selected).assignment())){
                    if(c<=3 && c!=1){
                        return(true);
                    }
                }
                else{
                    if(CurrentUser.getRole()==Role.MEMBER){
                        return(false);
                    }
                    else if(CurrentUser.getRole()==Role.TEAMLEAD){
                        if(c == 2){
                            return(true);
                        }
                        else{
                            return(false);
                        }
                    }
                    else{
                        if(c <= 3 && c != 1){
                            return(true);
                        }
                        else{
                            return(false);
                        }
                    }
                }
                //</editor-fold>
                return(false);
            }
        };
            SubtaskTable.setModel(two);
            SubtaskTable.repaint();
            DescrArea.setText("");
            //</editor-fold>
            
            return(false);
        }
        Task t = visibleTasks.get(selected);
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
            MarkCompleteActionPerformed(e);
        });
        MarkStarted.addActionListener((ActionEvent e) ->{
            MarkStartedActionPerformed(e);
        });
        
        
        if(selected>=0){
            if(selected < visibleTasks.size() && visibleTasks.get(selected)!=null){ //create table model
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
                if(r<0){
                    return(false); //for empty table
                }
                if(c == 6 || c == 7 || c == 8){ //prevents error caused by editing buttons
                    return(false);
                }
                //<editor-fold desc="data editing control" defaultstate="collapsed">
                if(!visibleTasks.get(selected).creator().equals(CurrentUser)){ 
                    return(false);
                }
                if(visibleTasks.equals(openTasks.get(selected).assignment())){
                    if(c!=1 && c<=3){
                        return(true);
                    }
                }
                else{
                    if(CurrentUser.getRole()==Role.MEMBER){
                        return(false);
                    }
                    else if(CurrentUser.getRole()==Role.TEAMLEAD){
                        if(c == 2){
                            return(true);
                        }
                        else{
                            return(false);
                        }
                    }
                    else{
                        if(c == 2 || c == 3){
                            return(true);
                        }
                        else{
                            return(false);
                        }
                    }
                }
                //</editor-fold>
                return(false);
            }
        };
        TableTop.setModel(table);
        
        TableTop.getColumn("Create Subtask").setCellRenderer(new JTableButtonRender());
        TableTop.getColumn("Mark Started").setCellRenderer(new JTableButtonRender());
        TableTop.getColumn("Mark Complete").setCellRenderer(new JTableButtonRender());
        
        if(t instanceof RecurringTask){
            RecurringTask r = (RecurringTask) t;
            if(r.hasSecondaryColor()){
                TableTop.setBackground(r.getSecondayColor());
            }
            else{
                TableTop.setBackground(r.getColor());
            }
        }
        else{
            TableTop.setBackground(t.getColor());
        }
        
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
                if(r<0){
                    return(false); //for empty table
                }
                if(c == 6 || c == 7){
                    return(false);
                }
                //<editor-fold desc="data editing control" defaultstate="collapsed">
                if(!visibleTasks.get(selected).creator().equals(CurrentUser)){ 
                    return(false);
                }
                if(CurrentUser.equals(visibleTasks.get(selected).assignment())){
                    if(c<=3 && c!=1){
                        return(true);
                    }
                }
                else{
                    if(CurrentUser.getRole()==Role.MEMBER){
                        return(false);
                    }
                    else if(CurrentUser.getRole()==Role.TEAMLEAD){
                        if(c == 2){
                            return(true);
                        }
                        else{
                            return(false);
                        }
                    }
                    else{
                        if(c <= 3 && c != 1){
                            return(true);
                        }
                        else{
                            return(false);
                        }
                    }
                }
                //</editor-fold>
                return(false);
            }
        };
        visibleTasks.get(TaskSelection.getSelectedIndex()).getSubtasks().forEach(a -> {
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
        return(true);
    }
    
    private Object[] getSubArray(Subtask s){
        JButton mkSt = new JButton("Mark Started");
        JButton mkD = new JButton("Mark Complete");
        mkSt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mkD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mkSt.addActionListener((ActionEvent e)->{
            MarkSubtaskStartedActionPerformed(e);
        });
        mkD.addActionListener((ActionEvent e)->{
            MarkSubtaskCompleteActionPerformed(e);
        });
        Object[] a = {s.getName(),s.getStatus().toString(), s.getCategory().toString(), s.getDueDate().toString(),
            s.assignment().getName(), s.creator().getName(),mkSt,mkD}; 
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
        CommitButton = new javax.swing.JButton();
        DescrLabel = new javax.swing.JLabel();
        InvalidDate = new javax.swing.JLabel();
        ViewsPane = new javax.swing.JTabbedPane();
        TabularView = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableTop = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        SubtaskTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        Selection = new javax.swing.JComboBox<>();
        SelectionLabel = new javax.swing.JLabel();
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

        CommitButton.setText("Commit Changes");
        CommitButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CommitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CommitButtonActionPerformed(evt);
            }
        });

        DescrLabel.setForeground(new java.awt.Color(0, 0, 0));
        DescrLabel.setLabelFor(DescrArea);
        DescrLabel.setText("Description");
        DescrLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        InvalidDate.setForeground(new java.awt.Color(0, 0, 0));
        InvalidDate.setText("Invalid date format use YYYY-MM-DD");
        InvalidDate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout SidePanelLayout = new javax.swing.GroupLayout(SidePanel);
        SidePanel.setLayout(SidePanelLayout);
        SidePanelLayout.setHorizontalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Create_Task_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TaskSelection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OpenTaskLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addTeamMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CommitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SidePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(DescrLabel))
                    .addComponent(InvalidDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(CommitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addTeamMember)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InvalidDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 302, Short.MAX_VALUE)
                .addComponent(DescrLabel)
                .addGap(56, 56, 56)
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

        jPanel2.setBackground(new java.awt.Color(150, 200, 200));

        Selection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Overall" }));

        SelectionLabel.setForeground(new java.awt.Color(0, 0, 0));
        SelectionLabel.setLabelFor(Selection);
        SelectionLabel.setText("Selection");
        SelectionLabel.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SelectionLabel)
                    .addComponent(Selection, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(388, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SelectionLabel)
                .addGap(7, 7, 7)
                .addComponent(Selection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(379, Short.MAX_VALUE))
        );

        ViewsPane.addTab("Statistics", jPanel2);

        DescrArea.setBackground(new java.awt.Color(200, 200, 200));
        DescrArea.setColumns(20);
        DescrArea.setForeground(new java.awt.Color(0, 0, 0));
        DescrArea.setRows(5);
        DescrScroll.setViewportView(DescrArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ViewsPane, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
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
    }
    
    //<editor-fold desc="tableButton action listeners" defaultstate="collapsed">
    private void MarkCompleteActionPerformed(ActionEvent e){ 
        if((visibleTasks.get(TaskSelection.getSelectedIndex())) instanceof RecurringTask){
            ((RecurringTask)visibleTasks.get(TaskSelection.getSelectedIndex())).complete();
        }
        else{
            for(int x = 0; x< TableTop.getRowCount(); x++){
                if(((JButton)e.getSource()).equals(TableTop.getValueAt(x, 8))){
                    visibleTasks.get(TaskSelection.getSelectedIndex()).setStatus(Status.COMPLETE);
                }
            }   
        }
        setTableTop();
    }
    private void MarkStartedActionPerformed(ActionEvent e) {
        for(int x = 0; x< TableTop.getRowCount(); x++){
            if(((JButton)e.getSource()).equals(TableTop.getValueAt(x, 7))){
                visibleTasks.get(TaskSelection.getSelectedIndex()).setStatus(Status.IN_PROGRESS);
            }
        }        
        setTableTop();
    }
    private void MarkSubtaskCompleteActionPerformed(ActionEvent e) {
        for(int x = 0; x< SubtaskTable.getRowCount(); x++){
            if(((JButton)e.getSource()).equals(SubtaskTable.getValueAt(x, 7))){
                visibleTasks.get(TaskSelection.getSelectedIndex()).getTask(x).setStatus(Status.COMPLETE);
            }
        }        
        setTableTop();
    }
    private void MarkSubtaskStartedActionPerformed(ActionEvent e) {
        for(int x = 0; x< SubtaskTable.getRowCount(); x++){
            if(((JButton)e.getSource()).equals(SubtaskTable.getValueAt(x, 6))){
                visibleTasks.get(TaskSelection.getSelectedIndex()).getTask(x).setStatus(Status.IN_PROGRESS);
            }
        }        
        setTableTop();
    }
    //</editor-fold>
    
    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        this.dispose();
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void TaskSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaskSelectionActionPerformed
        setTableTop();
    }//GEN-LAST:event_TaskSelectionActionPerformed

    private void addTeamMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTeamMemberActionPerformed
        addTeamMember atm = new addTeamMember(this,true);
        atm.setVisible(true);
        atm.requestFocus();
    }//GEN-LAST:event_addTeamMemberActionPerformed
    
    //fix index out of bounds error (non-fatal) & description editing/logic control
    private void CommitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CommitButtonActionPerformed
        Task t = visibleTasks.get(TaskSelection.getSelectedIndex());
        String n = (String)TableTop.getValueAt(0, 0);
        
        if(!t.getName().equals(n)){
            t.setName(n);
        }
        String cat = (String)TableTop.getValueAt(0, 2);
        if(!t.getCategory().toString().equals(cat)){
            t.setCatagory(new Categories(cat));
        }
        try{
            LocalDate due = LocalDate.parse((String)TableTop.getValueAt(0, 3),DateTimeFormatter.ISO_LOCAL_DATE);
            if(!t.getDueDate().equals(due)){
                t.setDueDate(due);
            }
        }
        catch(Exception e){
            InvalidDate.setVisible(true);
        }
        String assigned = (String) TableTop.getValueAt(0, 4);
        if(!t.assignment().getName().equals(assigned)){
            for(int x = 0; x<assignablePeople.size();x++){
                if(assignablePeople.get(x).getName().equals(assigned)){ //assuming no two people have the same name
                    t.reassign(assignablePeople.get(x));
                    break;
                }
            }
        }
        //set subtasks
        if(t.getNumberOfSubTasks()>=0){
            for(int x = 0; x < t.getSubtasks().size(); x++){ //loop through subs
                n = (String)SubtaskTable.getValueAt(x, 0);
                if(!t.getTask(x).getName().equals(n)){
                    t.getTask(x).setName(n);
                }
                cat = (String)SubtaskTable.getValueAt(x, 2);
                if(!t.getTask(x).getCategory().toString().equals(cat)){
                    t.getTask(x).setCatagory(new Categories(cat));
                }
                try{
                    LocalDate due = LocalDate.parse((String)SubtaskTable.getValueAt(x, 3),DateTimeFormatter.ISO_LOCAL_DATE);
                    if(!t.getTask(x).getDueDate().equals(due)){
                        t.getTask(x).setDueDate(due);
                    }
                }
                catch(Exception e){
                    InvalidDate.setVisible(true);
                }
                assigned = (String) SubtaskTable.getValueAt(x, 4);
                if(!t.getTask(x).assignment().getName().equals(assigned)){
                    for(int y = 0; y<assignablePeople.size();y++){
                        if(assignablePeople.get(y).getName().equals(assigned)){ //assuming no two people have the same name
                            t.getTask(x).reassign(assignablePeople.get(y));
                            break;
                        }
                    }
                }
            }
        }
        //put changed task in proper place
        int l = openTasks.indexOf(t);
        visibleTasks.set(TaskSelection.getSelectedIndex(),t);
        if(t.getStatus()==Status.COMPLETE){
            closedTasks.add(openTasks.remove(l)); //takes out completed task and puts in proper spot
            visibleTasks.remove(t);
        }
        setTaskOptions();
        setTableTop();
        InvalidDate.setVisible(false);
    }//GEN-LAST:event_CommitButtonActionPerformed
    /**
     * @param args the command line arguments
     */
    
    //sets Status and color
    private void markDates(){
        LocalDate x = getToday();
        for(Task t : openTasks){
            int y = t.getDueDate().compareTo(x);
            if(!(t instanceof RecurringTask)){
                if(y>=0 && y<=7){
                    t.setStatus(Status.DUE_SOON);
                    t.setColor(Color.YELLOW);
                    markSubtasks(t,Color.RED,Status.OVERDUE);
                }
                else if(y<0){
                    t.setStatus(Status.OVERDUE);
                    t.setColor(Color.RED);
                    markSubtasks(t,Color.RED,Status.OVERDUE);
                }
            }
            else{
                RecurringTask r = (RecurringTask) t;
                if(y>=0 && y<=7 && r.getType()!=RecurType.DAILY){ //dont want to change color of daily tasks, you'll never see the actual color
                    r.setSecondaryColor(Color.YELLOW);
                    r.setStatus(Status.DUE_SOON);
                    markSubtasks(r,null,Status.DUE_SOON);
                }
                else if(y<0){
                    r.setStatus(Status.OVERDUE);
                    r.setSecondaryColor(Color.RED);
                    markSubtasks(r,null,Status.DUE_SOON);
                }
            }
        }
    }
    private void markSubtasks(Task t, Color c, Status s){ //pass null to color if task is recurring
        if(t.hasDescendants() && c!=null){
            for(Subtask x : t.getSubtasks()){
                x.setColor(c);
                x.setStatus(s);
            }
        }
        else if(t.hasDescendants()){ //dont want to lose color of subtasks
            for(Subtask x : t.getSubtasks()){
                x.setStatus(s);
            }
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold desc=" Look and feel setting code (optional) " defaultstate="collapsed">
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
    //<editor-fold desc="generated variables" defaultstate="collapsed">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CommitButton;
    private javax.swing.JButton Create_Task_Button;
    private javax.swing.JTextArea DescrArea;
    private javax.swing.JLabel DescrLabel;
    private javax.swing.JScrollPane DescrScroll;
    private javax.swing.JButton ExitButton;
    private javax.swing.JLabel InvalidDate;
    private javax.swing.JLabel OpenTaskLabel;
    private javax.swing.JComboBox<String> Selection;
    private javax.swing.JLabel SelectionLabel;
    private javax.swing.JPanel SidePanel;
    public javax.swing.JTable SubtaskTable;
    public javax.swing.JTable TableTop;
    private javax.swing.JScrollPane TabularView;
    public javax.swing.JComboBox<Task> TaskSelection;
    private javax.swing.JTabbedPane ViewsPane;
    public javax.swing.JButton addTeamMember;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}