package tech.subluminal.shared.son;

import static tech.subluminal.shared.son.SONParsing.BOOLEAN_ID;
import static tech.subluminal.shared.son.SONParsing.DOUBLE_ID;
import static tech.subluminal.shared.son.SONParsing.ENTRY_DELIMITER;
import static tech.subluminal.shared.son.SONParsing.INTEGER_ID;
import static tech.subluminal.shared.son.SONParsing.KEY_VALUE_DELIMITER;
import static tech.subluminal.shared.son.SONParsing.LIST_ID;
import static tech.subluminal.shared.son.SONParsing.OBJECT_ID;
import static tech.subluminal.shared.son.SONParsing.OBJECT_LEFTBRACE;
import static tech.subluminal.shared.son.SONParsing.OBJECT_RIGHTBRACE;
import static tech.subluminal.shared.son.SONParsing.STRING_ID;
import static tech.subluminal.shared.son.SONParsing.integerString;
import static tech.subluminal.shared.son.SONParsing.doubleString;
import static tech.subluminal.shared.son.SONParsing.booleanString;
import static tech.subluminal.shared.son.SONParsing.partialParseBoolean;
import static tech.subluminal.shared.son.SONParsing.partialParseDouble;
import static tech.subluminal.shared.son.SONParsing.partialParseInt;
import static tech.subluminal.shared.son.SONParsing.partialParseString;
import static tech.subluminal.shared.son.SONParsing.stringString;
import static tech.subluminal.shared.son.SONParsing.LIST_LEFTBRACE;
import static tech.subluminal.shared.son.SONParsing.LIST_RIGHTBRACE;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import tech.subluminal.shared.son.SONParsing.PartialParseResult;

/**
 * Subluminal Object Notation List:
 *
 * <p>A dynamic list with typed values.
 */
public class SONList {

  private List<Object> list = new ArrayList<>();

  /**
   * Adds a value to the end of the list.
   *
   * @param value the integer value to add.
   * @return this for method chaining.
   */
  public SONList add(int value) {
    list.add(value);
    return this;
  }

  /**
   * Adds a value to the end of the list.
   *
   * @param value the double value to add.
   * @return this for method chaining.
   */
  public SONList add(double value) {
    list.add(value);
    return this;
  }

  /**
   * Adds a value to the end of the list.
   *
   * @param value the boolean value to add.
   * @return this for method chaining.
   */
  public SONList add(boolean value) {
    list.add(value);
    return this;
  }

  /**
   * Adds a value to the end of the list.
   *
   * @param value the string value to add.
   * @return this for method chaining.
   */
  public SONList add(String value) {
    list.add(value);
    return this;
  }

  /**
   * Adds a value to the end of the list.
   *
   * @param value the SON object to add.
   * @return this for method chaining.
   */
  public SONList add(SON value) {
    list.add(value);
    return this;
  }

  /**
   * Adds a value to the end of the list.
   *
   * @param value the SON list value to add.
   * @return this for method chaining.
   */
  public SONList add(SONList value) {
    list.add(value);
    return this;
  }

  /**
   * Sets a value for a given index.
   *
   * @param value the integer value to set.
   * @param i the position where the value will be added.
   * @return this for method chaining.
   */
  public SONList set(int value, int i) {
    list.set(i, value);
    return this;
  }

  /**
   * Sets a value for a given index.
   *
   * @param value the double value to set.
   * @param i the position where the value will be added.
   * @return this for method chaining.
   */
  public SONList set(double value, int i) {
    list.set(i, value);
    return this;
  }

  /**
   * Sets a value for a given index.
   *
   * @param value the boolean value to set.
   * @param i the position where the value will be added.
   * @return this for method chaining.
   */
  public SONList set(boolean value, int i) {
    list.set(i, value);
    return this;
  }

  /**
   * Sets a value for a given index.
   *
   * @param value the string value to set.
   * @param i the position where the value will be added.
   * @return this for method chaining.
   */
  public SONList set(String value, int i) {
    list.set(i, value);
    return this;
  }

  /**
   * Sets a value for a given index.
   *
   * @param value the SON object to set.
   * @param i the position where the value will be added.
   * @return this for method chaining.
   */
  public SONList set(SON value, int i) {
    list.set(i, value);
    return this;
  }

  /**
   * Sets a value for a given index.
   *
   * @param value the SON list to set.
   * @param i the position where the value will be added.
   * @return this for method chaining.
   */
  public SONList set(SONList value, int i) {
    list.set(i, value);
    return this;
  }

  /**
   * Gets an integer for a given index.
   *
   * @param i the index to look at.
   * @return the found value if it was found and the right type, empty otherwise.
   */
  public Optional<Integer> getInt(int i) {
    Object value = list.get(i);
    return value instanceof Integer ? Optional.of((Integer) value) : Optional.empty();
  }

  /**
   * Gets a double for a given index.
   *
   * @param i the index to look at.
   * @return the found value if it was found and the right type, empty otherwise.
   */
  public Optional<Double> getDouble(int i) {
    Object value = list.get(i);
    return value instanceof Double ? Optional.of((Double) value) : Optional.empty();
  }

  /**
   * Gets a boolean for a given index.
   *
   * @param i the index to look at.
   * @return the found value if it was found and the right type, empty otherwise.
   */
  public Optional<Boolean> getBoolean(int i) {
    Object value = list.get(i);
    return value instanceof Boolean ? Optional.of((Boolean) value) : Optional.empty();
  }

  /**
   * Gets a string for a given index.
   *
   * @param i the index to look at.
   * @return the found value if it was found and the right type, empty otherwise.
   */
  public Optional<String> getString(int i) {
    Object value = list.get(i);
    return value instanceof String ? Optional.of((String) value) : Optional.empty();
  }

  /**
   * Gets a SON object for a given index.
   *
   * @param i the index to look at.
   * @return the found value if it was found and the right type, empty otherwise.
   */
  public Optional<SON> getObject(int i) {
    Object value = list.get(i);
    return value instanceof SON ? Optional.of((SON) value) : Optional.empty();
  }

  /**
   * Gets a SON list for a given index.
   *
   * @param i the index to look at.
   * @return the found value if it was found and the right type, empty otherwise.
   */
  public Optional<SONList> getList(int i) {
    Object value = list.get(i);
    return value instanceof SONList ? Optional.of((SONList) value) : Optional.empty();
  }

  public String asString() {
    StringBuilder builder = new StringBuilder();

    builder.append(LIST_LEFTBRACE);

    list.stream()
        .map(v -> {
          if (v instanceof Integer) {
            return INTEGER_ID + integerString((Integer) v);
          } else if (v instanceof Double) {
            return DOUBLE_ID + doubleString((Double) v);
          } else if (v instanceof Boolean) {
            return BOOLEAN_ID + booleanString((Boolean) v);
          } else if (v instanceof String) {
            return STRING_ID + stringString((String) v);
          } else if (v instanceof SON) {
            return OBJECT_ID + ((SON) v).asString();
          } else if (v instanceof SONList) {
            return LIST_ID + ((SONList) v).asString();
          }
          throw new RuntimeException(new SONParsingError("Encountered an unexpected type while printing a SONList: " + v.toString()));
        })
        .flatMap(s -> Stream.of(ENTRY_DELIMITER, s))
        .skip(1)
        .forEach(builder::append);

    builder.append(LIST_RIGHTBRACE);

    return builder.toString();
  }

  static PartialParseResult<SONList> partialParse(String str, int start)
      throws SONParsingError {
    try {
      if (str.charAt(start) != LIST_LEFTBRACE) {
        throw new SONParsingError("Expected a list but found no left brace.");
      }

      SONList list = new SONList();

      if (str.charAt(start + 1) == LIST_RIGHTBRACE) {
        return new PartialParseResult<>(list, start + 2);
      }
      int i = start + 1;

      do {
        if (str.charAt(i++) != KEY_VALUE_DELIMITER) {
          throw new SONParsingError("Expected a key-value pair, but found no colon.");
        }

        char typeID = str.charAt(i++);
        switch (typeID) {
          case INTEGER_ID:
            PartialParseResult<Integer> intRes = partialParseInt(str, i);
            i = intRes.pos;
            list.add(intRes.result);
            break;
          case DOUBLE_ID:
            PartialParseResult<Double> doubleRes = partialParseDouble(str, i);
            i = doubleRes.pos;
            list.add(doubleRes.result);
            break;
          case BOOLEAN_ID:
            PartialParseResult<Boolean> boolRes = partialParseBoolean(str, i);
            i = boolRes.pos;
            list.add(boolRes.result);
            break;
          case STRING_ID:
            PartialParseResult<String> strRes = partialParseString(str, i);
            i = strRes.pos;
            list.add(strRes.result);
            break;
          case OBJECT_ID:
            PartialParseResult<SON> objRes = SON.partialParse(str, i);
            i = objRes.pos;
            list.add(objRes.result);
            break;
          case LIST_ID:
            PartialParseResult<SONList> listRes = SONList.partialParse(str, i);
            i = listRes.pos;
            list.add(listRes.result);
            break;
          default:
            throw new SONParsingError("Expected a value, but found no type identifier.");
        }
      } while (str.charAt(i) == ENTRY_DELIMITER);

      if (str.charAt(i) != LIST_RIGHTBRACE) {
        throw new SONParsingError("SON list was not terminated.");
      }

      return new PartialParseResult<>(list, i + 1);
    } catch (IndexOutOfBoundsException e) {
      throw new SONParsingError("SON list was not terminated.");
    }
  }
}
