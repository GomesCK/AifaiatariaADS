package pro.conectarbanco;
import java.sql.*;

public class conectaMySQL {

    private static Connection conexao_MySql = null;
    private static String localBD = "localhost";
    private static String LINK = 
            "jdbc:mysql://" + localBD + ":3306/alfaiataria";
    private static final String usuario = "root";
    private static final String senha = "";
    
    // Método para fazer a conexão com um banco de dados MySql
    public Connection connectionMySql() {
      try {
         conexao_MySql = 
                DriverManager.getConnection(LINK, usuario, senha);
          System.out.println("conexão OK!");
      } catch (SQLException e) {
         throw new 
        RuntimeException("Ocorreu um problema na conexão com o BD", e);
      }
       return conexao_MySql;
    }

      public String dataBaseSelect(String login, String senha) {
        Connection connection = connectionMySql();
        String x = "";
        String sql = "select login, senha "
                + "from LoginSenha "
                + "where login = ? and senha = ?";
        
        PreparedStatement preparedStmt;
        
        try {
            preparedStmt = connection.prepareStatement(sql);
            //Efetua a troca do '?' pelos valores na query
            preparedStmt.setString(1, login);
            preparedStmt.setString(2, senha);
            ResultSet result = preparedStmt.executeQuery();
            //valida resultado
            while (result.next()) {
//                int code = result.getInt("id");
                String name = result.getString("login");
                String name2 = result.getString("senha");
//                System.out.println("cod: " + code);
                System.out.println("name: " + name);
                System.out.println("senha : " + name2);
                x = name;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return x;
    }
 public void closeConnectionMySql(Connection con) {
        try {
            if (con != null) {
                con.close();
                System.out.println("Fechamento OK");
            }
        } catch (SQLException e) {
            throw new 
        RuntimeException("Ocorreu um problema para encerrar "
                + "a conexão com o BD.", e);
        }
    }     

    public String dataBaseInsert(String login, String senha) {
        String x = "";
        Connection connection = connectionMySql();
        String sql = "INSERT INTO LoginSenha (login, senha) VALUES (?,?)";
        PreparedStatement preparedStmt;
        try {
            preparedStmt = connection.prepareStatement(sql);
            //Efetua a troca do '?' pelos valores na query 			
            preparedStmt.setString(1, login);
            preparedStmt.setString(2, senha);
//            preparedStmt.setInt(3, 1);
            preparedStmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return x;
    }
         
    
    
    
    
      public void consulta(Connection con) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from LoginSenha");
            System.out.println("Consulta ao banco:");
            while (rs.next()) {
                System.out.println("id: " + rs.getInt(1) + " - Login: " + rs.getString(2) + " - Senha: " + rs.getString(3));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }



}
