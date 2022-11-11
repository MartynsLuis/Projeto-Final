import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.util.HashMap;

public class InterfaceLogin {
    private JFrame tela;
    private HashMap<String,Usuario> usuarios;

    public InterfaceLogin(){
        makeFrame();
        usuarios = new HashMap<String,Usuario>();
        adicionarUsuariosRapido();
    }

    // adicionando algumas coisas para teste
    public void adicionarUsuariosRapido(){
        for(int i = 1; i <= 10; i++){
            if (i < 5){
                Usuario sus = new Usuario("pessoa" + i, "login" + i, "1" + i, "Professor");
                usuarios.put(sus.getLogin(), sus);
            }
            if (i == 7){
                Usuario sus = new Usuario("pessoa" + i, "login" + i, "1" + i, "Diretor");
                usuarios.put(sus.getLogin(), sus);
            }
            Usuario sus = new Usuario("pessoa" + i, "login" + i, "1" + i, "Aluno");
            usuarios.put(sus.getLogin(), sus);
        }
    }

    // criando a janela de login
    private void makeFrame(){
        tela = new JFrame("Interface");
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        criarMenubar();
        Container telalogin = tela.getContentPane();
        Container subLogin = new Container();
        Container subSenha = new Container();

        // Login
        telalogin.setLayout(new BoxLayout(telalogin, BoxLayout.Y_AXIS));

        // caixa de login
        subLogin.setLayout(new FlowLayout());
        criarCaixaDeTexto(subLogin, "Login");

        // caixa da senha
        subSenha.setLayout(new FlowLayout());
        JLabel senhaTexto = new JLabel("Senha");
        subSenha.add(senhaTexto);

        JPasswordField caixaTextoSenha = new JPasswordField(25);
        subSenha.add(caixaTextoSenha);

        // adicionando tudo
        telalogin.add(subLogin);
        telalogin.add(subSenha);

        // Botão de entrar
        JButton botaoEntrar = new JButton("Entrar");
        botaoEntrar.setAlignmentX(Component.RIGHT_ALIGNMENT);
        botaoEntrar.addActionListener((ActionEvent e) -> { confirmaLogin(((JTextComponent) subLogin.getComponent(1)).getText(), caixaTextoSenha); });
        telalogin.add(botaoEntrar);

        tela.pack();
    }

    // serve para criar uma caixa de texto com uma frase do lado
    private void criarCaixaDeTexto(Container container,String texto){
        JLabel senhaTexto = new JLabel(texto);
        container.add(senhaTexto);

        JTextField caixaTextoSenha = new JTextField(25);
        container.add(caixaTextoSenha);

    }

    // cria a menubar
    private void criarMenubar(){

        JMenuBar menubar = new JMenuBar();
        tela.setJMenuBar(menubar);

        JMenu fileMenu = new JMenu("File");
        menubar.add(fileMenu);

        JMenu helpMenu = new JMenu("Help");
        menubar.add(helpMenu);

        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener((ActionEvent e) -> { System.out.println("Menu item: Open"); });
        fileMenu.add(openItem);

        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.addActionListener((ActionEvent e) -> { System.out.println("Menu item: Quit"); });
        fileMenu.add(quitItem);

        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener((ActionEvent e) -> { System.out.println("Menu item: About"); });
        helpMenu.add(aboutItem);
    }


    // Confirma se o login e a senha são existentes/corretas
    private void confirmaLogin(String login, JPasswordField senha){
        Usuario usuario = usuarios.get(login);
        String senhaComparacao = String.valueOf(senha.getPassword());
        // verifica se o login é inválido
        if (usuario == null){
            System.out.println(login + "\n" + senha);
            JOptionPane.showMessageDialog(tela, "Login inválido", "Login Inválido", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        // verifica se a senha é a correta
        if (usuario.getSenha().equals(senhaComparacao)){
            tela.dispose();
            usuario.janelaEscola();
            return;
        }
        JOptionPane.showMessageDialog(tela, "Senha inválido", "Senha Inválido", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarTela(){
        tela.setVisible(true);
    }
    
}
