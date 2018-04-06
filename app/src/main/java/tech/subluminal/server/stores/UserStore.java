package tech.subluminal.server.stores;

import tech.subluminal.shared.stores.records.User;

/**
 * Stores server-side information about the users.
 */
public interface UserStore extends ReadOnlyUserStore {

  /**
   * Adds a user to the user store.
   *
   * @param user the user to add.
   */
  void addUser(User user);

  /**
   * Remooves a user identified by a given id from the user store.
   *
   * @param id the id of the user that should be removed.
   */
  void removeUserByID(String id);
}
