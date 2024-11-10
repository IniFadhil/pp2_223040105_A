/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Membership.src.view.main;

/**
 *
 * @author fadhi
 */
import java.awt.FlowLayout;
import javax.swing.*;
import src.Membership.src.model.*;
import src.Membership.src.view.jenismember.JenisMemberFrame;
import src.Membership.src.view.member.MemberFrame;
import src.Membership.src.dao.*;

public class MainFrame extends JFrame {
    private JenisMemberFrame jenisMemberFrame;
    private MemberFrame memberFrame;
    private JButton buttonJenisMember;
    private JButton buttonMember;
    private JenisMemberDao jenisMemberDao;
    private MemberDao memberDao;

    public MainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);

        // Initialize DAOs
        this.jenisMemberDao = new JenisMemberDao();
        this.memberDao = new MemberDao();

        // Initialize frames
        this.jenisMemberFrame = new JenisMemberFrame(jenisMemberDao);
        this.memberFrame = new MemberFrame(memberDao, jenisMemberDao);

        this.setLayout(new FlowLayout());

        // Initialize buttons and add action listeners
        this.buttonJenisMember = new JButton("Jenis Member");
        this.buttonMember = new JButton("Member");

        this.buttonJenisMember.addActionListener(e -> showJenisMemberFrame());
        this.buttonMember.addActionListener(e -> showMemberFrame());

        this.add(buttonJenisMember);
        this.add(buttonMember);
    }

    public JButton getButtonJenisMember() {
        return buttonJenisMember;
    }

    public JButton getButtonMember() {
        return buttonMember;
    }

    public void showJenisMemberFrame() {
        if (jenisMemberFrame == null) {
            jenisMemberFrame = new JenisMemberFrame(jenisMemberDao);
        }
        jenisMemberFrame.setVisible(true);
    }

    public void showMemberFrame() {
        if (memberFrame == null) {
            memberFrame = new MemberFrame(memberDao, jenisMemberDao);
        }
        memberFrame.populateComboJenis(); // Populate the combo box before displaying
        memberFrame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}