package article_web.Services;

import com.password4j.BcryptFunction;
import com.password4j.Hash;
import com.password4j.Password;

public class PasswordService {
  BcryptFunction bcrypt = BcryptFunction.getInstance(12);

  public String hashPassword(String password) {
    Hash hash = Password.hash(password).with(bcrypt);
    return hash.getResult();
  }

  public boolean verifyPassword(String inputPassword, String storedPassword) {
    return Password.check(inputPassword, storedPassword).with(bcrypt);
  }



}
