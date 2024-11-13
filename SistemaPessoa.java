import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// Classe responsável pela inicialização e configuração do sistema
public class SistemaPessoa {
    
    public static void main(String[] args) {
        // Cria o sistema e inicializa
        Sistema sistema = new Sistema();
        sistema.iniciarSistema();
    }
}

// Classe que representa o Sistema Pessoa
class Sistema {
    private JFrame principal;
    private JMenuBar menuPrincipal;
    private JTextArea areaTrabalho;
    private JPanel painelRodape;
    
    private final String versaoSistema = "12.1.2024";
    private final String nomeUsuario = "denys.silva";
    private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
    private final String dataAcesso = dateFormat.format(new Date());

    // Construtor do Sistema
    public Sistema() {
        this.principal = new JFrame("Sistema Pessoa");
        this.menuPrincipal = new JMenuBar();
        this.areaTrabalho = new JTextArea();
        this.painelRodape = new JPanel();
    }

    // Método para iniciar o sistema
    public void iniciarSistema() {
        configurarJanela();
        configurarMenu();
        configurarRodape();
        mostrarJanela();
    }

    // Configura o JFrame principal
    private void configurarJanela() {
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setSize(800, 800);
        principal.setLocationRelativeTo(null); // Centraliza a janela
    }

    // Configura a barra de menu
    private void configurarMenu() {
        // Criar menus principais
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenu menuSair = new JMenu("Sair");
        
        // Adicionar ouvintes de evento no menu "Sair"
        menuSair.addMenuListener(new javax.swing.event.MenuListener() {
            @Override
            public void menuSelected(javax.swing.event.MenuEvent e) {
                System.exit(0); // Sai do sistema
            }

            @Override
            public void menuDeselected(javax.swing.event.MenuEvent e) {}

            @Override
            public void menuCanceled(javax.swing.event.MenuEvent e) {}
        });

        // Criar itens do menu de cadastro
        JMenuItem itemMenuCadastroUsuarios = new JMenuItem("Usuários");
        JMenuItem itemMenuCadastroPessoas = new JMenuItem("Pessoas");
        menuCadastro.add(itemMenuCadastroUsuarios);
        menuCadastro.add(itemMenuCadastroPessoas);
        
        // Criar itens do menu de visualização
        JMenuItem itemMenuVisualizacaoListaUsuarios = new JMenuItem("Lista de usuários");
        JMenuItem itemMenuVisualizacaoListaPessoas = new JMenuItem("Lista de pessoas");
        menuVisualizacao.add(itemMenuVisualizacaoListaUsuarios);
        menuVisualizacao.add(itemMenuVisualizacaoListaPessoas);
        
        // Adicionar menus na barra de menu
        menuPrincipal.add(menuCadastro);
        menuPrincipal.add(menuVisualizacao);
        menuPrincipal.add(menuSair);
        
        // Configurar a barra de menu
        principal.getContentPane().add(BorderLayout.NORTH, menuPrincipal);
        principal.getContentPane().add(BorderLayout.CENTER, areaTrabalho);
    }

    // Configura o rodapé
    private void configurarRodape() {
        JLabel labelRodape = new JLabel("Versão: " + versaoSistema + "               Usuário: " + nomeUsuario + "               Data de acesso: " + dataAcesso);
        painelRodape.add(labelRodape);
        principal.getContentPane().add(BorderLayout.SOUTH, painelRodape);
    }

    // Exibe a janela principal
    private void mostrarJanela() {
        principal.setVisible(true);
    }
}
