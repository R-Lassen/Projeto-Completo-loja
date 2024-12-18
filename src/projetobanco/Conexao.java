
/**
 *
 * @author 44966
 */
  
package projetobanco;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao {
    static Connection con = null;
    // Configurações para conexão com MySQL
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/ideal"; // Substitua "seuBancoDeDados" pelo nome do seu banco
    static String usuario = "root"; // Substitua "seuUsuario" pelo seu usuário do banco de dados
    static String senha = "Pmsp@mudar123"; // Substitua "suaSenha" pela sua senha do banco de dados
    public static Connection obterConexao() {
        try {
            if (con == null) {
                // Carregar o driver do MySQL
                Class.forName(driver);
                // Conectar ao banco de dados
                con = DriverManager.getConnection(url, usuario, senha);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver não encontrado", e);
        } catch (SQLException e) {
            throw new RuntimeException("Erro de conexão com o banco de dados", e);
        }
        return con;
    }
    public static void main(String[] args) {
        // Testar conexão
        obterConexao();
        System.out.println("Conectado com sucesso");
    }
}

/*
create table produto(
    id int primary key auto_increment,
    status char(1),
    nome varchar(32),
    descricao text,
    qtd_estoque int(11),
    qtd_minima int(11) ,
    qtd_maxima int(11),
    preco_compra decimal(12,2),
    preco_venda decimal(12,2),
    bar_code int(11),
    ncm int(20),
    fator decimal(12,2) ,

    imagem longblob
);
*/