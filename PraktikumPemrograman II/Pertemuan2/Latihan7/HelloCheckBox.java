
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloCheckBox extends JFrame {

    // Declare all input fields and components as class-level variables for easy access
    private JTextField textFieldName;
    private JTextField textFieldPhone;
    private JRadioButton rbMale;
    private JRadioButton rbFemale;
    private JCheckBox checkBoxWNA;
    private JList<String> listAccountTypes;
    private JSlider sliderTransactionFrequency;
    private JTextArea txtOutput;

    public HelloCheckBox() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Input Nama
        JLabel labelName = new JLabel("Nama:");
        labelName.setBounds(15, 20, 350, 10);

        textFieldName = new JTextField();
        textFieldName.setBounds(15, 40, 350, 30);

        // Input Nomor HP
        JLabel labelPhone = new JLabel("Nomor HP:");
        labelPhone.setBounds(15, 80, 350, 10);

        textFieldPhone = new JTextField();
        textFieldPhone.setBounds(15, 100, 350, 30);

        // Pilihan Jenis Kelamin
        JLabel labelGender = new JLabel("Jenis Kelamin:");
        labelGender.setBounds(15, 140, 350, 10);

        rbMale = new JRadioButton("Laki-Laki");
        rbMale.setBounds(15, 160, 100, 30);

        rbFemale = new JRadioButton("Perempuan");
        rbFemale.setBounds(120, 160, 100, 30);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);

        // CheckBox Warga Negara Asing
        checkBoxWNA = new JCheckBox("Warga Negara Asing");
        checkBoxWNA.setBounds(15, 200, 200, 30);

        // Pilihan Jenis Tabungan dengan JList
        JLabel labelAccountType = new JLabel("Jenis Tabungan:");
        labelAccountType.setBounds(15, 240, 200, 30);

        String[] accountTypes = {"Tabungan Simpanan", "Tabungan Haji", "Tabungan Pendidikan", "Tabungan Investasi"};
        listAccountTypes = new JList<>(accountTypes);
        listAccountTypes.setBounds(15, 270, 350, 70);
        listAccountTypes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Input Frekuensi Transaksi Per Bulan dengan JSlider
        JLabel labelTransactionFrequency = new JLabel("Frekuensi Transaksi per Bulan:");
        labelTransactionFrequency.setBounds(15, 350, 200, 30);

        // Slider with range from 1 to 100
        sliderTransactionFrequency = new JSlider(JSlider.HORIZONTAL, 1, 100, 1);
        sliderTransactionFrequency.setBounds(220, 350, 150, 50);
        sliderTransactionFrequency.setMajorTickSpacing(10);
        sliderTransactionFrequency.setMinorTickSpacing(1);
        sliderTransactionFrequency.setPaintTicks(true);
        sliderTransactionFrequency.setPaintLabels(true);

        // Tombol Simpan
        JButton button = new JButton("Simpan");
        button.setBounds(15, 420, 100, 30);

        txtOutput = new JTextArea();
        txtOutput.setBounds(15, 460, 350, 100);

        // Action for button click
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder output = new StringBuilder();
                String nama = textFieldName.getText();
                String nomorHP = textFieldPhone.getText();
                String jenisKelamin = rbMale.isSelected() ? "Laki-Laki" : rbFemale.isSelected() ? "Perempuan" : "Tidak Dipilih";
                String jenisTabungan = listAccountTypes.getSelectedValue() != null ? listAccountTypes.getSelectedValue() : "Tidak Dipilih";
                int frekuensiTransaksi = sliderTransactionFrequency.getValue();

                output.append("Nama: ").append(nama).append("\n");
                output.append("Nomor HP: ").append(nomorHP).append("\n");
                output.append("Jenis Kelamin: ").append(jenisKelamin).append("\n");
                output.append("Jenis Tabungan: ").append(jenisTabungan).append("\n");
                output.append("Frekuensi Transaksi per Bulan: ").append(frekuensiTransaksi).append("\n");

                if (checkBoxWNA.isSelected()) {
                    output.append("Status: Warga Negara Asing\n");
                } else {
                    output.append("Status: Warga Negara Lokal\n");
                }

                txtOutput.setText(output.toString());
            }
        });

        // Add components to JFrame
        this.add(labelName);
        this.add(textFieldName);
        this.add(labelPhone);
        this.add(textFieldPhone);
        this.add(labelGender);
        this.add(rbMale);
        this.add(rbFemale);
        this.add(checkBoxWNA);
        this.add(labelAccountType);
        this.add(listAccountTypes);
        this.add(labelTransactionFrequency);
        this.add(sliderTransactionFrequency);
        this.add(button);
        this.add(txtOutput);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");

        // Reset Menu
        JMenuItem resetMenuItem = new JMenuItem("Reset");
        resetMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reset all fields to default
                textFieldName.setText("");
                textFieldPhone.setText("");
                genderGroup.clearSelection();
                checkBoxWNA.setSelected(false);
                listAccountTypes.clearSelection();
                sliderTransactionFrequency.setValue(1);  // Reset slider to 1
                txtOutput.setText("");
            }
        });
        menu.add(resetMenuItem);

        // Exit Menu
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the application
            }
        });
        menu.add(exitMenuItem);

        menuBar.add(menu);
        this.setJMenuBar(menuBar); // Set the menu bar

        // Frame settings
        this.setSize(400, 600);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                HelloCheckBox h = new HelloCheckBox();
                h.setVisible(true);
            }
        });
    }
}
