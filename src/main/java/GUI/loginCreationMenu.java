package GUI;

import java.awt.event.WindowEvent;
import peoplePack.*;

/**
 *
 * @author h_obe
 */
public class loginCreationMenu extends javax.swing.JDialog {
    private final String LoginErr = "Login Failed";
    private final String CreationErr = "User exists, please login";
    private final String EmptyErr = "Please fill out all areas";
    private mainFrame p;
    
    /**
     * Creates new form loginCreationMenu
     * @param parent mainFrame
     * @param modal should always be true
     */
    public loginCreationMenu(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        p=(mainFrame)parent;
        initComponents();
        LoginFailedNoti.setVisible(false);
        //<editor-fold desc="naming for testing" defaultstate="collapsed">
        LoginFailedNoti.setName("LoginFail");
        NameInput.setName("NameInput");
        PassInput.setName("PassInput");
        TypeBox.setName("TypeBox");
        CreateButton.setName("CreateButton");
        ExitButton.setName("ExitButton");
        LoginButton.setName("LoginButton");
        this.setName("LoginMenu");
        //</editor-fold>
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CreateButton = new javax.swing.JButton();
        LoginButton = new javax.swing.JButton();
        TypeBox = new javax.swing.JComboBox();
        NameLabel = new javax.swing.JLabel();
        Passlabel = new javax.swing.JLabel();
        TypeLabel = new javax.swing.JLabel();
        NameInput = new javax.swing.JTextField();
        PassInput = new javax.swing.JPasswordField();
        ExitButton = new javax.swing.JButton();
        LoginFailedNoti = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setModal(true);

        jPanel1.setBackground(new java.awt.Color(150, 200, 200));

        CreateButton.setText("Create User");
        CreateButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateButtonActionPerformed(evt);
            }
        });

        LoginButton.setText("Login");
        LoginButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        TypeBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Member", "Manager", "Team Lead" }));

        NameLabel.setForeground(new java.awt.Color(0, 0, 0));
        NameLabel.setLabelFor(NameInput);
        NameLabel.setText("Name:");

        Passlabel.setForeground(new java.awt.Color(0, 0, 0));
        Passlabel.setLabelFor(PassInput);
        Passlabel.setText("Password:");

        TypeLabel.setForeground(new java.awt.Color(0, 0, 0));
        TypeLabel.setLabelFor(TypeBox);
        TypeLabel.setText("User Type:");

        ExitButton.setText("Exit");
        ExitButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        LoginFailedNoti.setForeground(new java.awt.Color(0, 0, 0));
        LoginFailedNoti.setText("Login Failed");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NameInput))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Passlabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PassInput))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TypeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TypeBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LoginButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CreateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ExitButton))
                    .addComponent(LoginFailedNoti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(190, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NameLabel)
                    .addComponent(NameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Passlabel)
                    .addComponent(PassInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TypeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoginFailedNoti)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginButton)
                    .addComponent(CreateButton)
                    .addComponent(ExitButton))
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
        LoginFailedNoti.setVisible(false);
        boolean failed = false;
        String name = NameInput.getText();
        if(!name.isBlank() && !name.isEmpty()){
            Object r = TypeBox.getSelectedItem();
            r=r.toString();
            if(r.equals("Member")){
                r = Role.MEMBER; 
            }
            else if(r.equals("Manager")){
                r = Role.MANAGER;
            }
            else{
                r = Role.TEAMLEAD;
            }
            for(Person a : p.users){
                if(a.getRole() == r){
                    if(a.getName().equals(NameInput.getText())){
                        LoginFailedNoti.setText(CreationErr);
                        LoginFailedNoti.setVisible(true);
                        failed = true;
                        break;
                    }
                }
            }
            if(!failed){ //actual user creation
                String[] names = name.split(" ");
                if(r!= Role.MEMBER){
                    Role role;
                    if(r==Role.MANAGER){
                        role = Role.MANAGER;
                    }
                    else{
                        role = Role.TEAMLEAD;
                    }
                    try {
                        Manager x = new Manager(names[0],names[1],PassInput.getPassword(),role);
                        p.users.add(x);
                        p.CurrentUser=x;
                    } catch (MemberManagerException ex) {
                        //unreachable but required
                    }
                    
                }
                else{
                    member x = new member(names[0],names[1],PassInput.getPassword());
                    p.users.add(x);
                    p.CurrentUser=x;
                }
                LoginFailedNoti.setVisible(false);
                if(p.CurrentUser.getRole()!=Role.TEAMLEAD){ //sets visibility of add team member button
                    p.addTeamMember.setVisible(false);
                    p.addTeamMember.setEnabled(false);
                    p.repaint();
                }
                else{
                    p.addTeamMember.setVisible(true);
                    p.addTeamMember.setEnabled(true);
                    p.repaint();
                }
                this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
                this.dispose();
            }
        }
        else{
            LoginFailedNoti.setText(EmptyErr);
            LoginFailedNoti.setVisible(true);
        }
    }//GEN-LAST:event_CreateButtonActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        LoginFailedNoti.setVisible(false);
        LoginFailedNoti.setText(LoginErr);
        boolean failed = true;
        Object r = TypeBox.getSelectedItem();
        r=r.toString(); //role conversion
        if(r.equals("Member")){
           r = Role.MEMBER; 
        }
        else if(r.equals("Manager")){
            r = Role.MANAGER;
        }
        else{
            r= Role.TEAMLEAD;
        }
        for(Person a : p.users){
            if(a.getRole()==r){
                if(a.getName().equals(NameInput.getText()) && a.testPassword(PassInput.getPassword())){
                    p.CurrentUser=a;
                    failed = false;
                    break;
                }
            }
        }
        if(!failed){
            LoginFailedNoti.setVisible(false);
            this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
            this.dispose(); 
        }
        else{
            LoginFailedNoti.setVisible(true);
        }
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        p.dispatchEvent(new WindowEvent(p, WindowEvent.WINDOW_CLOSING));
        this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
        this.dispose();
        p.dispose();
    }//GEN-LAST:event_ExitButtonActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(loginCreationMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            loginCreationMenu dialog = new loginCreationMenu(new java.awt.Frame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    
    //<editor-fold desc="generated variables" defaultstate="collapsed">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateButton;
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel LoginFailedNoti;
    private javax.swing.JTextField NameInput;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JPasswordField PassInput;
    private javax.swing.JLabel Passlabel;
    private javax.swing.JComboBox TypeBox;
    private javax.swing.JLabel TypeLabel;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}
