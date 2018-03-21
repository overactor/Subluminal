package tech.subluminal.main;

import tech.subluminal.client.init.ClientInitializer;
import tech.subluminal.server.init.ServerInitializer;

/**
 * The main class of the Subluminal project containing the main function which starts the program.
 */
public class Subluminal {

  public static void main(String[] args) {
    if (args.length < 2) {
      invalidArguments();
    }

    if ("client".equals(args[0])) {
      initClient(args);
    } else if ("server".equals(args[0])) {
      initServer(args[1]);
    } else {
      invalidArguments();
    }
  }

  private static void initServer(String portStr) {
    try {
      ServerInitializer.init(Integer.parseInt(portStr));
    } catch (NumberFormatException e) {
      invalidArguments();
    }
  }

  private static void initClient(String[] args) {
    String[] parts = args[1].split(":");
    if (parts.length != 2) {
      invalidArguments();
    }

    String host = parts[0];

    int port = 0;
    try {
      port = Integer.parseInt(parts[1]);
    } catch (NumberFormatException e) {
      invalidArguments();
    }

    String username = args.length > 2 ? args[2] : System.getProperty("user.name");

    ClientInitializer.init(host, port, username);
  }

  private static void invalidArguments() {
    System.err.println("Incorrect commandline arguments.");
    System.err.println("Call either with (client <hostaddress>:<port> [<username>]) or (server <port>)");
    System.exit(1);
  }
}