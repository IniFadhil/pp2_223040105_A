/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Tugas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class PendaftaranKuliah extends JFrame {
    // Components
    private JTextField nameField;
    private JTextArea addressArea;
    private JRadioButton maleRadio, femaleRadio;
    private JCheckBox sportsCheck, artsCheck, musicCheck;
    private JComboBox<String> programComboBox, categoryComboBox;
    private JSlider progressSlider;
    private JTable registrationTable;
    private DefaultTableModel tableModel;
    private JRadioButton highPriority, mediumPriority, lowPriority;
    private JCheckBox completedCheckBox;
    private JSpinner dateSpinner;

    public PendaftaranKuliah() {
        setTitle("Aplikasi Pendaftaran Kuliah");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set up menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem registerMenuItem = new JMenuItem("Form Pendaftaran");
        registerMenuItem.addActionListener(e -> openRegistrationForm());
        menu.add(registerMenuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Set up table to display registrations
        String[] columnNames = {"Nama", "Alamat", "Jenis Kelamin", "Program Studi", "Minat", "Hobi", "Prioritas", "Kategori", "Selesai", "Progress", "Tanggal"};
        tableModel = new DefaultTableModel(columnNames, 0);
        registrationTable = new JTable(tableModel);

        add(new JScrollPane(registrationTable), BorderLayout.CENTER);
    }

    private void openRegistrationForm() {
        JPanel formPanel = new JPanel(new BorderLayout(10, 10));
        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 10, 10));

        // Name field
        inputPanel.add(new JLabel("Nama:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        // Address area
        inputPanel.add(new JLabel("Alamat:"));
        addressArea = new JTextArea(3, 20);
        inputPanel.add(new JScrollPane(addressArea));

        // Gender radio buttons
        inputPanel.add(new JLabel("Jenis Kelamin:"));
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        maleRadio = new JRadioButton("Laki-laki");
        femaleRadio = new JRadioButton("Perempuan");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        inputPanel.add(genderPanel);

        // Program studi combo box
        inputPanel.add(new JLabel("Program Studi:"));
        String[] programs = {"Teknik Informatika", "Sistem Informasi", "Teknik Elektro"};
        programComboBox = new JComboBox<>(programs);
        inputPanel.add(programComboBox);

        // Interests checkboxes
        inputPanel.add(new JLabel("Minat:"));
        JPanel interestPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sportsCheck = new JCheckBox("Olahraga");
        artsCheck = new JCheckBox("Seni");
        musicCheck = new JCheckBox("Musik");
        interestPanel.add(sportsCheck);
        interestPanel.add(artsCheck);
        interestPanel.add(musicCheck);
        inputPanel.add(interestPanel);

        // Hobbies list
        inputPanel.add(new JLabel("Hobi:"));
        String[] hobbies = {"Membaca", "Menulis", "Bersepeda", "Memasak"};
        JList<String> hobbiesList = new JList<>(hobbies);
        hobbiesList.setVisibleRowCount(3);
        inputPanel.add(new JScrollPane(hobbiesList));

        // Priority radio buttons
        inputPanel.add(new JLabel("Prioritas:"));
        JPanel priorityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        highPriority = new JRadioButton("Tinggi");
        mediumPriority = new JRadioButton("Sedang");
        lowPriority = new JRadioButton("Rendah");
        ButtonGroup priorityGroup = new ButtonGroup();
        priorityGroup.add(highPriority);
        priorityGroup.add(mediumPriority);
        priorityGroup.add(lowPriority);
        priorityPanel.add(highPriority);
        priorityPanel.add(mediumPriority);
        priorityPanel.add(lowPriority);
        inputPanel.add(priorityPanel);

        // Category combo box
        inputPanel.add(new JLabel("Kategori:"));
        String[] categories = {"Akademik", "Organisasi", "Pribadi", "Lainnya"};
        categoryComboBox = new JComboBox<>(categories);
        inputPanel.add(categoryComboBox);

        // Completed checkbox
        inputPanel.add(new JLabel("Selesai:"));
        completedCheckBox = new JCheckBox();
        inputPanel.add(completedCheckBox);

        // Progress slider
        inputPanel.add(new JLabel("Progress:"));
        progressSlider = new JSlider(0, 100, 0);
        progressSlider.setMajorTickSpacing(25);
        progressSlider.setPaintTicks(true);
        progressSlider.setPaintLabels(true);
        inputPanel.add(progressSlider);

        // Date picker (Spinner)
        inputPanel.add(new JLabel("Waktu:"));
        dateSpinner = new JSpinner(new SpinnerDateModel());
        dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy HH:mm"));
        inputPanel.add(dateSpinner);

        // Add input panel to form panel
        formPanel.add(inputPanel, BorderLayout.CENTER);

        // Submit button
        JButton submitButton = new JButton("Daftar");
        submitButton.addActionListener((ActionEvent e) -> {
            // Retrieve form data
            String name1 = nameField.getText();
            String address = addressArea.getText();
            String gender = maleRadio.isSelected() ? "Laki-laki" : "Perempuan";
            String program = (String) programComboBox.getSelectedItem();
            // Get interests
            StringBuilder interests = new StringBuilder();
            if (sportsCheck.isSelected()) interests.append("Olahraga ");
            if (artsCheck.isSelected()) interests.append("Seni ");
            if (musicCheck.isSelected()) interests.append("Musik ");
            // Get selected hobbies
            String hobbies1 = String.join(", ", hobbiesList.getSelectedValuesList());
            // Get priority
            String priority = highPriority.isSelected() ? "Tinggi" : (mediumPriority.isSelected() ? "Sedang" : "Rendah");
            // Get category
            String category = (String) categoryComboBox.getSelectedItem();
            // Get completion status and progress
            boolean isCompleted = completedCheckBox.isSelected();
            int progress = progressSlider.getValue();
            // Get date
            Date date = (Date) dateSpinner.getValue();
            // Add data to table
            tableModel.addRow(new Object[]{name1, address, gender, program, interests.toString(), hobbies1, priority, category, isCompleted, progress, date});
            // Clear form
            nameField.setText("");
            addressArea.setText("");
            genderGroup.clearSelection();
            priorityGroup.clearSelection();
            sportsCheck.setSelected(false);
            artsCheck.setSelected(false);
            musicCheck.setSelected(false);
            hobbiesList.clearSelection();
            completedCheckBox.setSelected(false);
            progressSlider.setValue(0);
            dateSpinner.setValue(new Date());
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        formPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Show dialog with form panel
        JOptionPane.showMessageDialog(this, formPanel, "Form Pendaftaran", JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PendaftaranKuliah().setVisible(true));
    }
}
