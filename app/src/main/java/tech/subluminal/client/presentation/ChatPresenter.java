package tech.subluminal.client.presentation;

import java.util.List;
import tech.subluminal.server.stores.records.HighScore;

/**
 * Handles the presentation of the chat.
 */
public interface ChatPresenter {

  void displaySystemMessage(String message);

  /**
   * Fired when a someone sends a message to all users on the server.
   *
   * @param username from the sender of the message.
   * @param message is the text of the message.
   */
  void globalMessageReceived(String message, String username);

  /**
   * Fired when a personal message is received.
   *
   * @param message of the received whisper.
   * @param username of the sender.
   */
  void whisperMessageReceived(String message, String username);

  /**
   * Fired when a message from the same game is received.
   *
   * @param message of the game message.
   * @param username fo the sender.
   */
  void gameMessageReceived(String message, String username);

  /**
   * Sets the delegate who gets fired by user messages.
   *
   * @param delegate is the delegate which will be set.
   */
  void setChatDelegate(Delegate delegate);

  void updateHighscore(List<HighScore> highScores);

  public static interface Delegate {

    void sendGlobalMessage(String message);

    void sendGameMessage(String message);

    void sendWhisperMessage(String message, String username);

    void requestHighScores();
  }
}
