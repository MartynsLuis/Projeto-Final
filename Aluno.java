import java.util.HashMap;
import java.util.ArrayList;

public class Aluno extends Usuario {
    private  HashMap<String,ArrayList<Int>> notas;

    public Aluno(String nome, String login, String senha){
        super(nome,login,senha,"Aluno");
        montarNotas();
    }

    private void montarNotas(){
        notas = new HashMap<String,ArrayList<Int>>();
    }
}
