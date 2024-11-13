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

    // Método para obter a versão do sistema
    public String getVersaoSistema() {
        return versaoSistema;
    }

    // Método para obter o nome do usuário
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    // Método para obter o formato da data
    public DateFormat getDateFormat() {
        return dateFormat;
    }

    // Método para obter a data de acesso
    public String getDataAcesso() {
        return dataAcesso;
    }

    // Método para exibir todas as configurações
    public void exibirConfiguracoes() {
        System.out.println("Versão do Sistema: " + versaoSistema);
        System.out.println("Usuário: " + nomeUsuario);
        System.out.println("Data de Acesso: " + dataAcesso);
    }

    // Classe de teste para verificar as configurações
    public static void main(String[] args) {
        // Criar uma instância da classe com valores dinâmicos
        ConfiguracoesSistema configuracoes = new ConfiguracoesSistema("12.1.2024", "denys.silva");
        
        // Exibir configurações do sistema
        configuracoes.exibirConfiguracoes();
    }
}
