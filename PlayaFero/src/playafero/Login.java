package playafero;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {
    
    private String user;
    private String pass;
    private JPasswordField fpass = new JPasswordField();
    private JTextField fuser = new JTextField();

    public Login(){
    
    }
    
    public Login(String user, String pass) {
        this.user = user;
        this.pass = pass;

        //Objetos
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);
        frame.setLayout(null);
        frame.setResizable(true);
        frame.getContentPane().setBackground(Color.ORANGE);

        JLabel label = new JLabel("Playa Estacionamiento ");
        label.setBounds(100, 10, 200, 30);
        label.setForeground(Color.black);

        JLabel labUser = new JLabel("Usuario:");
        labUser.setBounds(25, 50, 60, 30);
        labUser.setForeground(Color.black);

        JLabel labPass = new JLabel("Contraseña:");
        labPass.setBounds(20, 90, 100, 30);
        labPass.setForeground(Color.black);

        fuser.setBounds(110, 52, 170, 25);
        fuser.setText(user);

        fpass.setBounds(110, 92, 170, 25);
        fpass.setText(pass);

        JCheckBox ver = new JCheckBox("Mostrar contraseña");
        ver.setBounds(107, 120, 250, 15);
        ver.setBackground(Color.orange);
        ver.setForeground(Color.black);
        ver.setMnemonic('M');
        fpass.setEchoChar('*');

        JButton enter = new JButton("Ingresar");
        enter.setBounds(100, 200, 175, 30);
        enter.setMnemonic('I');

        JCheckBox checkbox = new JCheckBox("Recordarme");
        checkbox.setBounds(20, 135, 110, 30);
        checkbox.setBackground(Color.orange);
        checkbox.setForeground(Color.black);
        checkbox.setMnemonic('R');
        checkbox.setSelected(true);

        //Acciones
        fuser.addActionListener((e) -> {
            fpass.requestFocus();
        });

        fpass.addActionListener((e) -> {
            pasarVentana(frame, checkbox, fuser, fpass);
        });

        enter.addActionListener((e) -> {
            pasarVentana(frame, checkbox, fuser, fpass);

        });

        ver.addActionListener((e) -> {
            if (ver.isSelected()) {
                fpass.setEchoChar((char) 0);
            } else {
                fpass.setEchoChar('*');
            }
            fpass.requestFocus();
        });

        frame.add(ver);
        frame.add(checkbox);
        frame.add(enter);
        frame.add(fpass);
        frame.add(fuser);
        frame.add(labPass);
        frame.add(labUser);
        frame.add(label);
        frame.setVisible(true);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public void pasarVentana(JFrame frame, JCheckBox checkbox, JTextField fuser, JPasswordField fpass) {
        String clavedef = String.valueOf(fpass.getPassword());
        if (fuser.getText().equals("a") && clavedef.equals("a")) {
            if (!checkbox.isSelected()) {
                this.user = "";
                this.pass = "";
            }else{
                this.user = fuser.getText();
                this.pass = String.valueOf(fpass.getPassword());
            }
            frame.dispose();
            
            java.awt.EventQueue.invokeLater(() -> {
            
            new ControlEstacionamient().setVisible(true);
       
        });
        }else{
            showMessageDialog(null, "El usuario o la contraseña es incorrecta");
        }
    }
}