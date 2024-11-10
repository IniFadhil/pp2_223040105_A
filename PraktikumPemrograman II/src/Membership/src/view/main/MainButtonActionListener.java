/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Membership.src.view.main;

/**
 *
 * @author fadhi
 */
import java.awt.event.*;

public class MainButtonActionListener implements ActionListener{
    private MainFrame mainFrame;

    public MainButtonActionListener(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() == mainFrame.getButtonJenisMember()){
            mainFrame.showJenisMemberFrame();
        } else {
            mainFrame.showMemberFrame();
        }
    }

    private static class MainFrame {

        public MainFrame() {
        }

        private Object getButtonJenisMember() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void showJenisMemberFrame() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void showMemberFrame() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}