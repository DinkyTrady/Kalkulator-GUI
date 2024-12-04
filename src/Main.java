import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Main extends JFrame implements ActionListener {

  // Deklarasi variable untuk komponen GUI
  private JTextField container;
  private JButton[] tombolNomor;
  private JButton tombolPlus, tombolMin, tombolKali, tombolBagi, tombolHasil, tombolClr, tombolHapus, tombolPersen,
      tombolDeci,
      tombolExit;
  private String operator;
  private double num1, num2, hasil;

  // Pengaturan dasar JFrame
  Main() {
    setTitle("Kalkulator GUI");
    setSize(500, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    // Gunakan external font
    Font cusFont;
    try {
      cusFont = Font.createFont(Font.TRUETYPE_FONT,
          new File("assets/fonts/NotoSansMNerdFontMono-Regular.ttf"));
      cusFont = cusFont.deriveFont(30f);
    } catch (FontFormatException | IOException e) {
      // TODO: handle exception
      e.printStackTrace();
      cusFont = new Font("Arial", Font.PLAIN, 30);
    }

    // Inisialisasi komponen
    container = new JTextField();
    container.setEditable(false);
    container.setFont(cusFont);

    // Inisialisasi tombol angka 0-9
    tombolNomor = new JButton[10];
    for (int i = 0; i < 10; i++) {
      tombolNomor[i] = new JButton(String.valueOf(i));
      tombolNomor[i].addActionListener(this);
    }

    // Inisialisasi tombol operasi
    tombolPlus = new JButton("+"); // Tombol penambahan
    tombolMin = new JButton("-"); // Tombol pengurangan
    tombolKali = new JButton("x"); // Tombol perkalian
    tombolBagi = new JButton(":"); // Tombol pembagian
    tombolHasil = new JButton("󰇼"); // Print hasil operasi
    tombolClr = new JButton("C"); // Clear operasi
    tombolHapus = new JButton("󰁮"); // Tombol hapus
    tombolPersen = new JButton("%"); // Tombol merubah angka menjadi percent desimal
    tombolDeci = new JButton(","); // Tombol desimal
    tombolExit = new JButton("󰈆 Exit"); // Tombol exit

    // ActionListener ketika tombol dipilih
    tombolPlus.addActionListener(this);
    tombolMin.addActionListener(this);
    tombolKali.addActionListener(this);
    tombolBagi.addActionListener(this);
    tombolHasil.addActionListener(this);
    tombolClr.addActionListener(this);
    tombolHapus.addActionListener(this);
    tombolPersen.addActionListener(this);
    tombolDeci.addActionListener(this);
    tombolExit.addActionListener(this);

    // Layout untuk tombol kalkulator
    JPanel panel = new JPanel();
    // @param GridLayout(rows, columns, margin, margin)
    // margin x and y for each button
    panel.setLayout(new GridLayout(5, 4, 10, 10));

    // Baris pertama: Clear, Hapus, Persen, dan Kali
    panel.add(tombolClr);
    panel.add(tombolHapus);
    panel.add(tombolPersen);
    panel.add(tombolKali);

    // Baris kedua: tombol angka 7, 8, 9, dan Bagi
    panel.add(tombolNomor[7]);
    panel.add(tombolNomor[8]);
    panel.add(tombolNomor[9]);
    panel.add(tombolBagi);

    // Baris ketiga: tombol angka 4, 5, 6, dan Tambah
    panel.add(tombolNomor[4]);
    panel.add(tombolNomor[5]);
    panel.add(tombolNomor[6]);
    panel.add(tombolPlus);

    // Baris keempat: tombol angka 1, 2, 3, dan Kurang
    panel.add(tombolNomor[1]);
    panel.add(tombolNomor[2]);
    panel.add(tombolNomor[3]);
    panel.add(tombolMin);

    // Baris kelima: tombol exit, 0, Decimal, dan hasil (sama dengan)
    panel.add(tombolExit);
    panel.add(tombolNomor[0]);
    panel.add(tombolDeci);
    panel.add(tombolHasil);

    setLayout(new BorderLayout());
    // Layout untuk container dan tombol
    add(container, BorderLayout.NORTH);
    add(panel, BorderLayout.CENTER);
  }

  // Method untuk menghandle tombol yang dipilih
  @Override
  public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();

    // Jika tombol angka ditekan
    if ((command.charAt(0) >= '0' && command.charAt(0) <= '9')) {
      container.setText(container.getText() + command);
    }
    // Jika tombol operasi ditekan
    else if (command.equals("+") || command.equals("-") || command.equals("x") || command.equals(":")) {
      num1 = Double.parseDouble(container.getText().replace(',', '.'));
      operator = command;
      container.setText("");
    }
    // Perbuhan persen
    else if (command.equals("%")) {
      num1 = Double.parseDouble(container.getText().replace(',', '.'));
      hasil = num1 / 100;
      container.setText(String.valueOf(hasil).replace('.', ','));
    }
    // Tombol desimal
    else if (command.equals(",")) {
      if (!container.getText().contains(",")) {
        container.setText(container.getText() + ",");
      }
    }
    // Tombol sama dengan (hasil)
    else if (command.equals("󰇼")) {
      num2 = Double.parseDouble(container.getText().replace(',', '.'));
      switch (operator) {
        case "+":
          hasil = num1 + num2;
          break;
        case "-":
          hasil = num1 - num2;
          break;
        case "x":
          hasil = num1 * num2;
          break;
        case ":":
          hasil = num1 / num2;
          break;
        default:
          break;
      }
      container.setText(String.valueOf(hasil).replace('.', ','));
    }
    // Tombol clear (C)
    else if (command.equals("C")) {
      container.setText("");
      num1 = num2 = hasil = 0;
    }
    // Tombol delete
    else if (command.equals("󰁮")) {
      String text = container.getText();
      if (text.length() > 0) {
        container.setText(text.substring(0, text.length() - 1));
      }
    }
    // Tombol exit
    else if (command.equals("󰈆 Exit")) {
      System.exit(0);
    }
  }

  // panggil untuk menjalankan program
  public static void main(String[] args) {
    new Main().setVisible(true);
  }
}
