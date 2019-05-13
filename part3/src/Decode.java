import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Decode {
  public static void main(String[] args) throws Exception {
    try (
      FileInputStream inputFile = new FileInputStream(args[0]);
      BitInputStream input = new BitInputStream(inputFile);
      FileOutputStream output = new FileOutputStream(args[1]);
    ) {
      int[] frequencies = new int[256];
      int bytesRead = 0;

      for (int i = 0; i < frequencies.length; i++) {
        int b = input.readInt();
        frequencies[i] = b;
        bytesRead += b;
      }

      Dict tree = Huffman.init(frequencies);
      Node node = tree.getRoot();
      int b;
      while ((b = input.readBit()) != -1 && bytesRead > 0) {
        if (b == 0) {
          node = node.left;
        } else {
          node = node.right;
        }

        if (node.left != null || node.right != null) {
          continue;
        }

        output.write(node.index);
        bytesRead -= 1;
        node = tree.getRoot();
      }
    } catch(IOException err) {
      System.out.println(err);
    }
  }
}
