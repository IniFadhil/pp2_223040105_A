/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Membership.src.view.member;

/**
 *
 * @author fadhi
 */
import java.awt.event.*;
import java.util.UUID;
import src.Membership.src.model.*;
import src.Membership.src.dao.MemberDao;

public class MemberButtonSimpanActionListener implements ActionListener {
    private MemberFrame memberFrame;
    private MemberDao memberDao;
    
    public MemberButtonSimpanActionListener(MemberFrame memberFrame, MemberDao memberDao) {
        this.memberFrame = memberFrame;
        this.memberDao = memberDao;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the name from the frame
        String nama = this.memberFrame.getNama();
        
        // Validate if name is not empty
        if (nama.isEmpty()) {
            this.memberFrame.showAlert("Nama tidak boleh kosong");
        } else {
            // Get selected JenisMember from the frame
            JenisMember jenisMember = this.memberFrame.getJenisMember();
            
            // Create new Member instance
            Member member = new Member();
            // Generate a unique ID using UUID
            member.setId(UUID.randomUUID().toString());
            member.setNama(nama);
            member.setJenisMember(jenisMember);
            
            // Update both the frame and database
            this.memberFrame.addMember(member);
            this.memberDao.insert(member);
        }
    }
}