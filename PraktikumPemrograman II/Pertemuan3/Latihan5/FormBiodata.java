
import java.awt.*;
import javax.swing.*;

public class FormBiodata extends JFrame {

    public FormBiodata() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Form Biodata");

        // Menggunakan GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.LIGHT_GRAY); // Menambahkan latar belakang abu-abu
        GridBagConstraints gbc = new GridBagConstraints();

        // Label header
        JLabel headerLabel = new JLabel("Form Biodata");
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10); // Margin
        panel.add(headerLabel, gbc);

        // Label Nama
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Nama:"), gbc);

        // Text field Nama
        JTextField namaField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(namaField, gbc);

        // Label Nomor HP
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(new JLabel("Nomor HP:"), gbc);

        // Text field Nomor HP
        JTextField hpField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(hpField, gbc);

        // Label Jenis Kelamin
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(new JLabel("Jenis Kelamin:"), gbc);

        // Radio button Laki-Laki dan Perempuan
        JRadioButton lakiRadio = new JRadioButton("Laki-Laki");
        JRadioButton perempuanRadio = new JRadioButton("Perempuan");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(lakiRadio);
        genderGroup.add(perempuanRadio);

        // Menambahkan radio button ke layout
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(lakiRadio, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        panel.add(perempuanRadio, gbc);

        // Checkbox Warga Negara Asing
        JCheckBox wnaCheckBox = new JCheckBox("Warga Negara Asing");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(wnaCheckBox, gbc);

        // Tombol Simpan
        JButton simpanButton = new JButton("Simpan");
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 10, 10, 10);
        panel.add(simpanButton, gbc);

        // Menambahkan panel ke frame
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);  // Pusatkan window
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FormBiodata().setVisible(true);
            }
        });
    }
}
