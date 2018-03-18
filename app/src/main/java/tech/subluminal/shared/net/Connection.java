package tech.subluminal.shared.net;

import tech.subluminal.shared.son.SONConverter;
import tech.subluminal.shared.son.SONRepresentable;

import java.util.function.Consumer;

/**
 * Represents a channel over which SONRepresentable objects can be sent and received.
 */
public interface Connection {

    /**
     * Registers a handler which is called when a provided type of SONRepresentable is received.
     * A call to this function should ideally look something like:
     * <pre>
     *     connection.registerHandler(MyMessage.class, MyMessage::fromSON, this::handleMyMessage)
     * </pre>
     *
     * @param type the class of the type of SONRepresentable this handler responds to.
     * @param converter
     * @param handler
     * @param <T>
     */
    <T extends SONRepresentable> void registerHandler(Class<T> type, SONConverter<T> converter, Consumer<T> handler);

    /**
     * Sends a message over the connection.
     *
     * @param message the message to send.
     */
    void sendMessage(SONRepresentable message);
}
