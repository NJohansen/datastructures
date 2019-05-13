import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Encode {
  public static void main(String[] args) throws Exception {
    int[] frequencies = createFrequencyTable(args[0]);
    Dict tree = Huffman.init(frequencies);
    write(args[0], args[1], frequencies, tree.orderedTraversal());
  }

  /**
   * Create frequency table
   * @param  filepath
   * @return list of with frequency of characters, where the index in the list
   *         is the integer representation of a character
   */
  private static int[] createFrequencyTable(String filepath) {
    int[] table = new int[256];

    try (FileInputStream file = new FileInputStream(filepath)) {
      for (int b = 0; b != -1; b = file.read()) {
        table[b]++;
      }
    } catch (IOException err) {
      System.out.print(err);
    }

    return table;
  }

  /**
   * Write frequency and keyword table to an output file
   * @param inputpath   path to input file
   * @param outputPath  path to output file
   * @param frequencies table
   * @param keywords    table
   */
  private static void write(String inputpath, String outputPath, int[] frequencies, String[] keywords) {
    try (
      FileInputStream input = new FileInputStream(inputpath);
      BitOutputStream file = new BitOutputStream(new FileOutputStream(outputPath))
    ) {
      for (int i : frequencies) {
        file.writeInt(i);
      }

      for (int b = 0; b != -1; b = input.read()) {
        for (String s : keywords[b].split("")) {
          file.writeBit(Integer.parseInt(s));
        }
      }
    } catch (IOException err) {
      System.out.println(err);
    }
  }
}
