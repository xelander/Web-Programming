package com.didacusabella.clientsupply1;

import com.didacusabella.supplierejb.Supply;
import com.didacusabella.supplierejb.SupplyEJBRemote;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


/**
 * Enterprise Application Client main class.
 *
 */
public class Main {

  private static final String HELP = "!quit per uscire, [NAME]-[name] cerca per nome\n"
          + "[SURNAME]-[surname] cerca per cognome\n"
          + "[MAXORDER]-[maxorder] cerca per ordine massimo";

  public static void main(String[] args) {
    try {
      Context ctx = new InitialContext();
      SupplyEJBRemote remote = (SupplyEJBRemote) ctx.lookup("java:global/SupplierEJB/SupplyEJB!"
              + "org.diego.supplierejb.SupplyEJBRemote");
      remote.createSupply(new Supply("Marco", "Ferraioli", "Bamba Spa", "081", 800));
      remote.createSupply(new Supply("Angelo", "Passaro", "Cinese Spa", "666", 500));
      remote.createSupply(new Supply("Antonio", "Terrano", "Mushroom Spa", "082", 1000));
      remote.createSupply(new Supply("Dario", "Tecchia", "Sugar Spa", "083", 200));
      System.out.println("Client inizializzato. !help per i comandi");
      String line;
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      while (!(line = bf.readLine()).equals("!quit")) {
        if (line.equals("!help")) {
          System.out.println(HELP);
        } else if (line.matches("name-\\w+")) {
          printResult(remote.findForName(line.substring(5)));
        } else if (line.matches("surname-\\w+")) {
          printResult(remote.findForlastName(line.substring(8)));
        } else if (line.matches("id-\\d+")) {
          int value = Integer.parseInt(line.substring(3));
          List<Supply> aList = (value == 0) ? remote.findAll() : remote.findForOrder(value);
          printResult(aList);
        } else {
          System.out.println("Comando non valido!");
        }
      }
    } catch (NamingException ex) {
      System.err.println("Errore naming:" + ex.getMessage());
    } catch (IOException e) {
      System.err.println("Errore nell'input da tastiera:" + e.getMessage());
    }
    System.exit(0);
  }

  private static void printResult(List<Supply> list) {
    for (Supply i : list) {
      System.out.println(i.toString());
    }
  }
}
