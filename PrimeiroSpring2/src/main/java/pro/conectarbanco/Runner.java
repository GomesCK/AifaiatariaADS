package pro.conectarbanco;
import java.sql.Connection;
import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {     
        conectaMySQL obj = new conectaMySQL();
        Connection conexao = obj.connectionMySql();
        System.out.println("Digite o codigo a buscar no banco:");
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        System.out.println("Cod: " + a);
        String x = obj.dataBaseInsert(a,b);
        System.out.println(x);
        obj.closeConnectionMySql(conexao);
    }
}
