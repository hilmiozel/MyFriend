/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db2.diagnostic.view;

import db2.diagnostic.User;
import db2.diagnostic.db.MysqlConnect;
import ganimed.SwingShell;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Rasit
 */
public class Home extends javax.swing.JFrame {

    MysqlConnect conn = MysqlConnect.getDbCon();

    /**
     * Creates new form Home
     */
    public Home(User user) {
        initComponents();
        this.setTitle("MyFriend - "+user.getName()+" " +user.getSurname());

        try {
            ResultSet result = conn.query("Select * from systems group by customer desc");
            while (result.next()) {
                String sid = result.getString("sid");
                String customer = result.getString("customer");
                customercombo.addItem(customer);
            }
            setSids();

        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        customercombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selected = customercombo.getSelectedItem().toString();

                DefaultComboBoxModel model = new DefaultComboBoxModel();
                

                try {
                    ResultSet result = conn.query("Select sid from systems where customer ='" + selected + "'");
                    while (result.next()) {
                        String sid = result.getString("sid");
                        model.addElement(sid);
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                sidcombo.setModel(model);
                
                
            }

        });
        //TODO: Burası Sid ile ilgili not alanını güncelelyecek.
        sidcombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selected = sidcombo.getSelectedItem().toString();

               

                try {
                    ResultSet result = conn.query("Select * from notes where customer ='" + selected + "'");
                    while (result.next()) {
                        String sid = result.getString("sid");
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        

    }

    private void setSids() {
        String selected = customercombo.getSelectedItem().toString();
        try {
            ResultSet result = conn.query("Select sid from systems where customer ='" + selected + "'");
            while (result.next()) {
                String sid = result.getString("sid");
                sidcombo.addItem(sid);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        customercombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sidcombo = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        notetextarea = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MyFriend");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jButton2.setText("OS Connect");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Customer");

        jLabel3.setText("System SID");

        jButton3.setText("StartGui");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable1);

        notetextarea.setColumns(20);
        notetextarea.setRows(5);
        jScrollPane4.setViewportView(notetextarea);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(customercombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sidcombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(customercombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(sidcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Daily Operations", jPanel2);

        jButton1.setText("jButton1");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jTextPane1.setText("1960 yılında MIT, AT&T Bell Teknoloji Laboratuvarları ve GE(General Electric)'nin birlikte geliştirdikleri MULTICS (Multiplexed Operating and Computing System [Çoğullandırılmış İşletim ve Bilgisayar Sistemi]) projesiyle temelleri atılmıştır. MULTICS projesinin hedefi çoklu kullanıcının bilgisayar erişimine izin vererek eş zamanlı veri paylaşımını gerçekleştirebilmekti. Multics, aynı zamanda çok yenilikçi ve zamanına göre çok gelişmişti ama pek çok sorunu vardı.\n\n1969 yılında proje karmaşık bir hal almaya başlamış ve AT&T Bell Teknoloji Laboratuvarları projeden çekilmiştir. Bunun nedeni artık MULTICS'in amaçları dışarısında büyümesi ve yavaşlamasıdır. Ancak aynı yıl içinde MULTICS işi daha küçük ölçekli hale getirmeye başlamış ve Bell'de araştırmacı olarak çalışan Ken Thompson'ın MULTICS yazılımını simüle eden bir dosya sistemini kodlamasıyla Unix'in ilk sürümü UNICS (Uniplexed Information and Computing System[Birleştirilmiş Bilgi ve Bilgisayar Sistemi]) ismiyle çıkmıştır. İlk sürümü assembler ile yazılmış olup, sadece yazıldığı tür makinede çalışabilen bir versiyondu.\n\n1973 yılında Thompson, C derleyicisinin atası Dennis Ritchie ile birlikte çekirdeği C ile tekrar kodlayarak Unix'in 5. sürümünü oluşturdu. Böylece Unix, taşınabilir özelliği olan C dili sayesinde, çeşitli hedef donanımlara uygun olarak tekrar derlenebilen kodlardan oluşan taşınabilir bir işletim sistemine dönüşmüş oldu.\n\n1978 yılı Unix için çok önemli bir yıl olarak geçti. Unix İşletim Sistemi 7. sürümüyle birlikte gelişimini artık iki farklı çizgide gerçekteştirecekti: BSD(Berkeley Software Distribution) ve System V.[kaynak belirtilmeli]\n\n    BSD\n\nBerkeley Universitesinde Thompson ve öğrenci Bill Joy ile Chuck Haley Unix'in Berkeley sürümünü kodladı. Bu sürüm, kaynak kod üzerinde çalışan diğer öğrencilere de dağıtıldı. Berkeley öğrencileri, orijinal Unix kaynak kodunun %90'nını değiştirdiler. Araştırmacılar da vi ve C shell gibi metin düzenleme yazılımlarını ekleyerek sistemi daha da geliştirdiler. Sanal bellek (virtual memory), Sendmail, TCP/IP desteği gibi özellikler BSD sürümünden gelmiştir. Daha sonraları\n\n    Linux,\n    NextStep,\n    (NeXT),\n    Sun OS 4.x, ve\n    ULTRIX (DEC)\n\ngibi işletim sistemleri BSD üzerinden türemiştir.\n\n    System V\n\nBell, Unix'in ticari olarak varlığını sürdürebilir bir ürün olacağını düşündü ve ürünü lisansladı. System V işletim sistemi, konsorsiyum tarafından ortak bir standartta geliştirildi ve yeni özellikleriyle daha güçlü, güvenilir ve güvenli bir sistem oldu. Birkaç yıl System V ticari olarak en çok desteklenen ürün oldu. Tüm System V ürünleri, Bell'de gerçekleştirilen çalışmalar üzerine kurulmuştur ve lisans hakkı Unix System Laboratories'e aittir. Bunlara örnek olarak\n\n    AIX (IBM),\n    Digital Unix (DEC),\n    HP-UX (HP),\n    IRIX (SGI),\n    SCO UNIXware ve\n    Sun OS 5.x/Solaris (SUN)\n\nverilebilir.\n\nGünümüzde BSD ve System V'in birçok komut ve özellikleri birbirine benzemektedir. Unix'in çoğu sürümünde her iki yaklaşımdan da faydalanılmıştır. Örnek olarak ps ve printing komutlarında sadece sözdizim farklılıkları vardır.\n\nUNIX markası AT&T Bell Labs tarafından Novell'e satılmıştır. 1994'te UNIX tanımı ve markası günümüzdeki sahibi The Open Group'a devredilmiştir.\nUNIX Tarihindeki Önemli İsimler\n\n    Brian Kernighan\n    Dennis Ritchie\n    Ken Thompson\n    Linus Torvalds\n\nUNIX Standartları\n\n    POSIX Standartı\n\nPOSIX (Portable Operating Standard)sistemin taşınabilirliğinin ölçüsüdür. System V üzerinde yazılmış bir yazılım BSD üzerinde çalışabiliyorsa taşınabilirlik özelliğine sahiptir. IEEE POSIX standartları için bir dizi standartlar komiteleri oluşturdu. POSIX.1 komitesi Unix için yazılım yazmada kullanılan C kütüphanesi arayüzünü standartlaştırırken; POSIX.2 komitesi genel kullanıcının erişimine açık komutların standartlarını belirledi.\n\n    OSF Standartı\n\nOpen Software Foundation tarafından geliştirilen standart.");
        jScrollPane2.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("DB2 Operation", jPanel1);
        jTabbedPane1.addTab("DB2 Restore", jTabbedPane2);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Operations");

        jMenuItem1.setText("DB Operations");
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        setSize(new java.awt.Dimension(768, 522));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        
        String sid = sidcombo.getSelectedItem().toString();
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        try {
                    ResultSet result = conn.query("Select * from servers where sid ='" + sid + "'");
                    while (result.next()) {
                        String hostname = result.getString("hostname");
                        model.addElement(hostname);
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
        SelectServer form = new SelectServer(model);
        form.setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "dir");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) { break; }
                System.out.println(line);
                
                
            }       } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Home().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> customercombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextArea notetextarea;
    private javax.swing.JComboBox<String> sidcombo;
    // End of variables declaration//GEN-END:variables
}
