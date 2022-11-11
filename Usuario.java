import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Usuario {

    private String nome;
    private String login;
    private String senha;
    private String funcao;
    private JFrame telaUsuario;


    public Usuario(String nome, String login, String senha, String funcao){
        this.nome  = nome;
        this.login = login;
        this.senha = senha;
        this.funcao = funcao;
        telaUsuario = new JFrame();
        telaUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getNome(){
        return nome;
    }

    public String getLogin(){
        return login;
    }

    public String getSenha(){
        return senha;
    }

    public String getFuncao(){
        return funcao;
    }

    public void janelaEscola(){
        partesEmcomum();
        telaUsuario.setVisible(true);

    }

    // não vai ter isso
    public void partesEmcomum(){

        Container contentPane = telaUsuario.getContentPane();
        Container textos = new Container();
        JScrollPane info = new JScrollPane(textos, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        textos.setLayout(new BoxLayout(textos, BoxLayout.Y_AXIS));

        for(int i = 1; i <= 100; i++){
            JLabel labelteste = new JLabel("ronaldo");
            labelteste.setAlignmentX(Component.CENTER_ALIGNMENT);
            textos.add(labelteste);
        }

        contentPane.add(info);

        telaUsuario.pack();


    }
    
}
