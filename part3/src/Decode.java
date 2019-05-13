import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Decode {
  public static void main(String[] args) throws Exception {
    int[] frequencies = createFrequencyTable(args[0]);
    Dict tree = Huffman.init(frequencies);
  }

  private static int[] createFrequencyTable(String filepath) {
    int[] table = new int[256];

    try (
      FileInputStream file = new FileInputStream(filepath);
      BitInputStream input = new BitInputStream(file);
    ) {
      for (int i = 0; i < table.length; i++) {
        table[i] = input.readInt();
      }
    } catch (IOException err) {
      System.out.print(err);
    }

    return table;
  }
}
