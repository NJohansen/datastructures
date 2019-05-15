import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Decode {
  public static void main(String[] args) throws Exception {
    //try open the streams so we can read and write to the files
    try (
      FileInputStream inputFile = new FileInputStream(args[0]);
      BitInputStream input = new BitInputStream(inputFile);
      FileOutputStream output = new FileOutputStream(args[1]);
    ) {
      //Initialize integer array with frequencies
      int[] frequencies = new int[256];

      // for loop that fills the frequencies array with the 256 bits
      for (int i = 0; i < frequencies.length; i++) {
        frequencies[i] = input.readInt();
      }

      //initiate the huffmann tree with the frequencies array as parameter
      Dict tree = Huffman.init(frequencies);
      //get the root node from the huffman tree
      Node node = tree.getRoot();
      int b;
      while ((b = input.readBit()) != -1) {
        if (b == 0) {
          // if the read bit is 0 then walk left
          node = node.left;
        } else {
          // if the read bit is 1 then walk right
          node = node.right;
        }

        if (node.left != null || node.right != null) {
          // Not a leaf node continue walking
          continue;
        }

        // write node index to output file
        output.write(node.index);

        // go back to the root of the tree
        node = tree.getRoot();
      }
    } catch(IOException err) {
      System.out.println(err);
    }
  }
}
