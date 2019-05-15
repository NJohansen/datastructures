/**
 * DM507 Algoritmer og datastrukturer
 *
 * @author Niclas Westergaard Johansen, njoha17@student.sdu.dk
 * @author Frederik Kvartborg Albertsen, fralb17@student.sdu.dk
 */

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
   * Create the frequency table
   * @param  filepath takes the filepath as an parameter
   * @return list of with frequency of characters, where the index in the list
   *         is the integer representation of a character
   */
  private static int[] createFrequencyTable(String filepath) {
    //define the table size which is 256 bits
    int[] table = new int[256];
    //try catch the FileInputStream to make sure we only opens the stream if the filepath exists
    try (FileInputStream file = new FileInputStream(filepath)) {
      // int we can use when we loop through the file.
      int b;
      // as long as the file isn't -1 keep the while loop running
      while ((b = file.read()) != -1) {
        // fill the table with the bytes read from the file
        table[b]++;
      }
      // catch IOExceptions
    } catch (IOException err) {
      System.out.print(err);
    }

    //return the frequency table
    return table;
  }

  /**
   * Write frequency and keyword table to an output file
   * @param inputpath   path to input file
   * @param outputPath  path to output file
   * @param frequencies table
   * @param codes table
   */
  private static void write(String inputpath, String outputPath, int[] frequencies, String[] codes) {
    // try open the FileInputStream and BitOutputStream so we can read and write to the outputfile file
    try (
      //Initialize the FileInputStream as input
      FileInputStream input = new FileInputStream(inputpath);
      //Initialize the BitOutputStream as the output which is the file we are going to write the encoded characters to
      BitOutputStream file = new BitOutputStream(new FileOutputStream(outputPath))
    ) {
      // write the integers from the frequency table to the outputfile
      for (int i : frequencies) {
        file.writeInt(i);
      }

      int b;
      // read through the inputfile
      while ((b = input.read()) != -1) {
        // write the code matching the bytes index
        for (String s : codes[b].split("")) {
          file.writeBit(Integer.parseInt(s));
        }
      }
      //catch the exception
    } catch (IOException err) {
      System.out.println(err);
    }
  }
}
