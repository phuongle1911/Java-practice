


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DbConnectionManager {
  private static String requireEnv(String name) {
    String value = System.getenv(name);
    if (value == null || value.isBlank()) {
        throw new IllegalStateException("Missing environment variable: " + name);
    }
    return value;
}
  public static Connection dbConnect() throws SQLException {
    try {
      Class.forName("org.postgresql.Driver");
      final String url = "jdbc:postgresql:///product-db-1a75d-database";
      final String instanceConnectionName = "product-db-1a75d:australia-southeast2:product-db-1a75d-instance";
      Properties props = new Properties();
      props.setProperty("user", requireEnv("DB_USER"));
      props.setProperty("password", requireEnv("DB_PASSWORD"));
      props.setProperty("cloudSqlInstance", instanceConnectionName);
      props.setProperty("socketFactory", "com.google.cloud.sql.postgres.SocketFactory");

      Connection conn = DriverManager.getConnection(url, props);
      return conn;
    } catch(Exception e) {
      e.printStackTrace();
      return null;
    }

  }
}
