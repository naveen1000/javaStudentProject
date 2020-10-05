import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

class Test {
  public static void main(String[] args) {
    try {
      File myObj = new File("test1.txt");
      Scanner myReader = new Scanner(myObj);
      String name = "";
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String[] words=data.split("\\s");
        System.out.println(words[0]);
        System.out.println(words[1]);
        for(int i =2;i<words.length ; i++){
          if(words[i].isEmpty())
            continue;
          name =name + words[i] + " ";
        } 
        System.out.print(name);
        name = "";
        System.out.print("\n");
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}