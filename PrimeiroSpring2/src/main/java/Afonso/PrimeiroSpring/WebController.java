package Afonso.PrimeiroSpring;

import java.sql.Connection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pro.conectarbanco.conectaMySQL;
//import pro.mongocrud.conectaMongo;

@Controller
public class WebController {

    @RequestMapping("/pag1")

    public String DigaOla(Model modelo) {
        System.out.println("Chamando o método DigaOla");
        modelo.addAttribute("mensagem", "Bem vindo a essa maluquice");
        return "pag1";
    }

    @RequestMapping("/form")
    public String DigaOla2(Model modelo) {
        System.out.println("Chamando o método DigaOla2");
        modelo.addAttribute("mensagem2", "Formulário");
        return "form";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String Logar(String login, String senha) {
        System.out.println("Chamando o método DigaOla3");
//        modelo.addAttribute("mensagem3", "Resultado do formulário:\n" + email + " seja bem vindo\n" + "seu email é: " + email);

        //Conexão Mongo
//        conectaMongo con = new conectaMongo();
//        con.findValuesEmail(email, senha);
//        con.getValues();
        //Conexão MySQL
        conectaMySQL obj = new conectaMySQL();
        Connection conexao = obj.connectionMySql();
        obj.dataBaseSelect(login, senha);
        obj.consulta(conexao);
        return "respostaform";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String Cadastrar(String login, String senha) {
        System.out.println("Chamando o método DigaOla4");
//        modelo.addAttribute("mensagem4", "Resultado do formulário:\n" + login + " seja bem vindo\n" + "seu email é: " + login);

        //Conexão Mongo
//        conectaMongo con = new conectaMongo();
//        con.findValuesEmail(email, senha);
//        con.getValues();
        //Conexão MySQL
        conectaMySQL obj = new conectaMySQL();
        Connection conexao = obj.connectionMySql();
        obj.dataBaseInsert(login, senha);
        obj.consulta(conexao);
        return "respostaform";
    }
}
