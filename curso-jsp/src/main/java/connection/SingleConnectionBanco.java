package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionBanco {
	
	private static String banco = "jdbc:postgresql://localhost:5432/curso-jps?autoReconnect=true";
	private static String user = "postgres";
	private static String senha = "Admin";
	private static Connection connection = null;
	
	
	
	public static Connection getConnection() {
		return connection;
	}
	
	static {
		conectar();
	}
	
	
	public SingleConnectionBanco() {/*quando tiver um instancia vai conectar*/
		conectar();
	}
	
	
	private static void conectar() {
		
		try {
			
			if(connection == null) {
				System.out.println("Iniciar Conexão ao BD");
				Class.forName("org.postgresql.Driver"); /*Carrega o driver de conex�o do banco*/
				connection = DriverManager.getConnection(banco, user, senha);
				connection.setAutoCommit(false); /*para nao efetuar alteracoes no banco sem nosso comando*/
				System.out.println("Conectado ao BD");
			}
			
		}catch (Exception e) {
			System.out.println("Erro na Conexão");
			e.printStackTrace();/*Mostrar qualquer erro no momento de conectar*/
		}
	}

}
