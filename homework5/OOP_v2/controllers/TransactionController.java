import java.math.BigDecimal;
import java.time.LocalDateTime;

import homework5.OOP_v2.models.Transaction;
import homework5.OOP_v2.utils.FileHandling;

public class TransactionController {

  private String transFile = "transactions.txt";
  

  public save(String cardNum, LocalDateTime transTime, TransactionTypeEnums type, BigDecimal amount) {
    Transaction newTransaction = new Transaction(cardNum, transTime, type, amount);
    FileHandling transFileHandler = new FileHandling();
    transFileHandler.filePath = transFile;
    transFileHandler.fileWrite(newTransaction.formatTransInfo());
  }
}
