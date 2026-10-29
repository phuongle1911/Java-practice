package article_web.Entity;

public class User {
  private String username;
  private int id;
  private String password_hash;
  public User(String username, int id, String password) {
    this.username = username;
    this.id = id;
    this.password_hash = password;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getPassword_hash() {
    return password_hash;
  }
  public void setPassword_hash(String password_hash) {
    this.password_hash = password_hash;
  }

  
}
