import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcessoAplicativo extends JFrame {

    // Construtor da classe
    public AcessoAplicativo() {
        // Definindo o título da janela
        setTitle("Acesso ao Aplicativo");

        // Configurando o layout
        setLayout(new GridLayout(3, 2));

        // Criando os componentes
        JLabel lblUsuario = new JLabel("Usuário:");
        JTextField txtUsuario = new JTextField();
        JLabel lblSenha = new JLabel("Senha:");
        JPasswordField txtSenha = new JPasswordField();
        JButton btnConfirmar = new JButton("Confirmar");
        JButton btnCancelar = new JButton("Cancelar");

        // Adicionando os componentes à janela
        add(lblUsuario);
        add(txtUsuario);
        add(lblSenha);
        add(txtSenha);
        add(btnConfirmar);
        add(btnCancelar);

        // Ação do botão Confirmar
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String senha = new String(txtSenha.getPassword());

                if (usuario.equals("denys.silva") && senha.equals("Teste@2024")) {
                    JOptionPane.showMessageDialog(null, "Acesso confirmado!");
                    dispose(); // Fecha a janela após a confirmação
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha inválido!");
                }
            }
        });

        // Ação do botão Cancelar
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela
            }
        });

        // Configurações finais da janela
        setSize(300, 150); // Define o tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao fechar a janela
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setVisible(true); // Torna a janela visível
    }

    // Método principal para rodar o programa
    public static void main(String[] args) {
        // Executa a interface gráfica na thread principal
        new AcessoAplicativo();
    }
}
