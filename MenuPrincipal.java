import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// Classe que encapsula as configurações do sistema
public class ConfiguracoesSistema {
    private String versaoSistema;
    private String nomeUsuario;
    private DateFormat dateFormat;
    private String dataAcesso;

    // Construtor da classe ConfiguracoesSistema
    public ConfiguracoesSistema(String versaoSistema, String nomeUsuario) {
        this.versaoSistema = versaoSistema;
        this.nomeUsuario = nomeUsuario;
        this.dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
        this.dataAcesso = dateFormat.format(new Date());
    }

    // Métodos de acesso (getters)
    public String getVersaoSistema() {
        return versaoSistema;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getDataAcesso() {
        return dataAcesso;
    }
}
import javax.swing.*;
import java.awt.*;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;

// Classe responsável pela criação do menu principal
public class MenuPrincipal {

    private JFrame principal;
    private JMenuBar menuPrincipal;
    private JTextArea areaTrabalho;
    private JPanel painelRodape;
    private ConfiguracoesSistema configuracoes;

    // Construtor que recebe as configurações do sistema
    public MenuPrincipal(ConfiguracoesSistema configuracoes) {
        this.configuracoes = configuracoes;
        this.principal = new JFrame("Sistema Pessoa");
        this.menuPrincipal = new JMenuBar();
        this.areaTrabalho = new JTextArea();
        this.painelRodape = new JPanel();

        configurarJanela();
        configurarMenu();
        configurarRodape();
    }

    // Método para configurar a janela principal
    private void configurarJanela() {
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setSize(800, 800);
        principal.setLocationRelativeTo(null); // Centraliza a janela
    }

    // Método para configurar o menu
    private void configurarMenu() {
        // Criação e adição das opções de menu
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenu menuVisualizacao = new JMenu("Visualização");

        JMenu menuSair = new JMenu("Sair");
        menuSair.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                System.exit(0); // Sai do sistema
            }
            @Override public void menuDeselected(MenuEvent e) {}
            @Override public void menuCanceled(MenuEvent e) {}
        });

        menuPrincipal.add(menuCadastro);
        menuPrincipal.add(menuVisualizacao);
        menuPrincipal.add(menuSair);

        // Itens de menu para cadastro
        JMenuItem itemMenuCadastroUsuarios = new JMenuItem("Usuários");
        JMenuItem itemMenuCadastroPessoas = new JMenuItem("Pessoas");
        menuCadastro.add(itemMenuCadastroUsuarios);
        menuCadastro.add(itemMenuCadastroPessoas);

        // Itens de menu para visualização
        JMenuItem itemMenuVisualizacaoListaUsuarios = new JMenuItem("Lista de usuários");
        JMenuItem itemMenuVisualizacaoListaPessoas = new JMenuItem("Lista de pessoas");
        menuVisualizacao.add(itemMenuVisualizacaoListaUsuarios);
        menuVisualizacao.add(itemMenuVisualizacaoListaPessoas);

        // Adiciona a barra de menu ao frame
        principal.getContentPane().add(BorderLayout.NORTH, menuPrincipal);
        principal.getContentPane().add(BorderLayout.CENTER, areaTrabalho);
    }

    // Método para configurar o rodapé com as configurações
    private void configurarRodape() {
        JLabel labelRodape = new JLabel("Versão: " + configuracoes.getVersaoSistema() +
                " | Usuário: " + configuracoes.getNomeUsuario() +
                " | Data de acesso: " + configuracoes.getDataAcesso());
        painelRodape.add(labelRodape);

        // Adiciona o painel de rodapé ao frame
        principal.getContentPane().add(BorderLayout.SOUTH, painelRodape);
    }

    // Exibe a janela
    public void exibir() {
        principal.setVisible(true); // Torna a janela visível
    }
}
public class Sistema {

    public static void main(String[] args) {
        // Inicializa as configurações do sistema
        ConfiguracoesSistema configuracoes = new ConfiguracoesSistema("12.1.2024", "denys.silva");

        // Cria o menu principal e o passa as configurações
        MenuPrincipal menuPrincipal = new MenuPrincipal(configuracoes);

        // Exibe o menu
        menuPrincipal.exibir();
    }
}
