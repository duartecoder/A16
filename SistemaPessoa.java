// Classe responsável por inicializar a aplicação
public class SistemaPessoa {
    public static void main(String[] args) {
        // Inicia a aplicação criando o menu principal
        Sistema sistema = new Sistema();
        sistema.iniciar();
    }
}

// Classe que representa o sistema
class Sistema {
    private MenuPrincipal menuPrincipal;

    // Construtor do sistema
    public Sistema() {
        menuPrincipal = new MenuPrincipal(); // Cria o menu principal
    }

    // Método para iniciar o sistema
    public void iniciar() {
        menuPrincipal.mostrarMenu(); // Exibe o menu principal
    }
}

// Classe responsável pelo menu principal da aplicação
class MenuPrincipal {
    // Construtor do MenuPrincipal
    public MenuPrincipal() {
        // Aqui você pode inicializar qualquer coisa relacionada ao menu
        System.out.println("Menu Principal Inicializado.");
    }

    // Método para exibir o menu
    public void mostrarMenu() {
        System.out.println("Exibindo Menu Principal...");
        // Aqui você pode adicionar lógica para criar o menu na interface gráfica
        // Exemplo: criar itens de menu, associar eventos, etc.
    }
}
