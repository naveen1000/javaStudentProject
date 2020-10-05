import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner; // Import the Scanner class to read text files
class Person{  
    long rNo;
    String name;
    String phNo;
    Person(long rNo,String name,String phNo){
        this.rNo = rNo;
        this.name = name;
        this.phNo = phNo;
    }
}

class Student extends Person{
    double cgpa;
    Student(long rNo,String name,String phNo,double cgpa){
        super(rNo, name, phNo);
        this.cgpa = cgpa;
    }

    public String toString() {
        return rNo + " " + " " + phNo + " " + cgpa + " " + name;
    }

}

class Sortbyroll implements Comparator<Student> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Student a, Student b) 
    { 
        return (int) ((b.cgpa *100) - (a.cgpa*100));
    } 
}

public class App{

    public static void main(String[] args) {

        Student[] s = new Student[214];
        int i = 0;
        try {
            
            File myObj = new File("result42.txt");
            Scanner myReader = new Scanner(myObj);

            File myObj1 = new File("test1.txt");
            Scanner myReader1 = new Scanner(myObj1);
            String name = "";
            double cgpa = 0;
            while (myReader1.hasNextLine()) {
              String data1 = myReader1.nextLine();
              String[] words1=data1.split("\\s");
              //System.out.println(data);
              long rNo1 = Long.parseLong(words1[0]);
              String phNo = words1[1];
              for(int j =2;j<words1.length ; j++){
                if(words1[j].isEmpty())
                  continue;
                name =name + words1[j] + " ";
              } 
              if(myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] words=data.split("\\s");
                long rNo = Long.parseLong(words[0]);
                if(rNo1 == rNo){
                    cgpa = Double.parseDouble(words[2]);
                }
                else{
                    cgpa = 0;
                }

              }

              s[i] = new Student(rNo1, name, phNo, cgpa);
              name = "";
              cgpa = 0;
              i++;
            }
            myReader.close();
            myReader1.close();
        
            Arrays.sort(s , new Sortbyroll());
            for(int j=0; j<214 ;j++)
                System.out.println( j + " " + s[j]);

          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }



    }
}