package tech.subluminal.client.presentation.controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import tech.subluminal.client.presentation.UserPresenter;
import tech.subluminal.client.presentation.customElements.PlayerStatusComponent;
import tech.subluminal.client.stores.UserStore;
import tech.subluminal.shared.records.PlayerStatus;
import tech.subluminal.shared.util.MapperList;


public class UserListController implements Initializable, UserPresenter {

  @FXML
  private ListView<PlayerStatusComponent> playerBoard;
  @FXML
  private VBox playerBoardWrapper;
  @FXML
  private Button updaterPlayerBoard;

  private LinkedList<Label> players;

  private boolean isBoardShown = false;
  private UserStore userStore;

  private UserPresenter.Delegate userDelegate;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    if (!isBoardShown) {
      playerBoard.setVisible(false);
    }

  }

  public void addPlayerStatus(String username, PlayerStatus status) {

  }

/**    private void removePlayerStatus(String username){
 for(PlayerStatusComponent player: playerBoard.getItems()){
 if(player.getText().equals(username)){
 Platform.runLater(() ->{
 playerBoard.getItems().remove(player);

 });
 break;
 }
 }
 }**/

  /**
   * public void updatePlayerStatus(String username, PlayerStatusComponent status){ for(Label
   * player: playerBoard.getItems()){ if(player.getText().equals(username)){
   * player.setTextFill(Color.web(getStatusColor(status))); } } }
   **/

  public void switchPlayerBoard(ActionEvent actionEvent) {
    if (isBoardShown) {
      playerBoard.setVisible(false);
      isBoardShown = false;
      updaterPlayerBoard.setText("Show Players");
    } else {
      playerBoard.setVisible(true);
      isBoardShown = true;
      updaterPlayerBoard.setText("Hide Players");
    }

  }

  public void setUserStore(UserStore userStore) {
    this.userStore = userStore;

    Platform.runLater(() -> {
      playerBoard.setItems(new MapperList<>(userStore.users().observableList(),
          user -> new PlayerStatusComponent(user.getUsername(), PlayerStatus.INGAME)));
    });

  }

  @Override
  public void loginSucceeded() {

  }

  @Override
  public void logoutSucceeded() {

  }

  @Override
  public void nameChangeSucceeded() {

  }

  @Override
  public void setUserDelegate(Delegate delegate) {

  }

  @Override
  public void onPlayerJoin(String username) {

  }

  @Override
  public void onPlayerLeave(String username) {

  }

  @Override
  public void onPlayerUpdate(String oldUsername, String newUsername) {

  }

  public UserListController getController() {
    return this;
  }

}
