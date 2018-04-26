package tech.subluminal.shared.messages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import tech.subluminal.shared.son.SON;
import tech.subluminal.shared.son.SONConversionError;
import tech.subluminal.shared.son.SONParsingError;

public class PingTest {

  private Ping ping;
  private String ID;

  @Before
  public void initialize() {
    this.ID = "1234";
    this.ping = new Ping(ID);
  }

  @Test
  public void testParsing() {
    String pingMsg = ping.asSON().asString();
    try {
      Ping parsedPing = Ping.fromSON(SON.parse(pingMsg));
      String parsedID = parsedPing.getId();
      assertEquals(ping.getId(), parsedID);
    } catch (SONParsingError | SONConversionError e) {
      e.printStackTrace();
    }
    System.out.println(pingMsg);
  }

  @Test
  public void SONConversionErrorThrowing() {
    boolean parsingSucceeded = true;
    String faultyPingMsg = "{\"ID\":s\"1234\"}"; // the ID key correctly should be "id" instead of "ID"
    try {
      Ping parsedPing = Ping.fromSON(SON.parse(faultyPingMsg));
      String ID = parsedPing.getId();
      System.out.println(ID);
    } catch (SONParsingError | SONConversionError e) {
      e.printStackTrace();
      parsingSucceeded = false;
    }
    assertFalse(parsingSucceeded);
  }

}
