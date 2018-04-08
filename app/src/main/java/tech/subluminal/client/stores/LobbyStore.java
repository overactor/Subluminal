package tech.subluminal.client.stores;

import java.util.List;
import tech.subluminal.shared.stores.records.Lobby;
import tech.subluminal.shared.stores.records.SingleEntity;
import tech.subluminal.shared.stores.records.SlimLobby;

public interface LobbyStore {

  SingleEntity<Lobby> currentLobby();

  SingleEntity<List<SlimLobby>> lobbies();
}