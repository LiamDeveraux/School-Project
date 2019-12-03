import java.io.*;
import java.util.Scanner;

class Patient
{
    private String name;
    private static int patientID = 0;
    public String getName() {
        return name;
    }
    void setName(String n) throws IOException{
        name = n;
        PrintWriter writer = new PrintWriter(new FileWriter("name.txt",true));
        patientID++;
        writer.println(patientID + "|" +name + "|");
        writer.close();
    }
}

class Management
{
    private String[] tempNameArray = new String[100];
    public void readFile() throws ArrayIndexOutOfBoundsException, IOException
    {
        boolean end = false;
        int nameCounter = 0;
        try {
	        BufferedReader reader = new BufferedReader(new FileReader("name.txt"));
	
	        while(!end) {
		        try{
		        	String temp = reader.readLine();
		            tempNameArray[nameCounter] = temp;
		        } catch(EOFException e) {
		            end = true;
		            System.out.println("End of file reached, bro");
		        }
		        nameCounter++; 
		    }
		    reader.close();
	        for(int i =0; i<2; i++){
	            System.out.println(tempNameArray[i]);
	        }
        }catch (IOException e) {
        	e.printStackTrace();
        }
    }
}

public class JavaApplication1 {

    public static void main(String[] args) throws IOException{
        Patient[] patient = new Patient[100];
        Scanner scanner = new Scanner (System.in);
        String pName;
        int i=0;
        int sentinel = 1;
        while(sentinel != 0) {
            patient[i] = new Patient();
            pName = scanner.next();
            System.out.println("Name : " + pName);
            patient[i].setName(pName);
            System.out.println("You just entered " + patient[i].getName() + " ID : " + i);
            i++;
            System.out.print("press 0 to stop => ");
            sentinel = scanner.nextInt();
        }
        scanner.close();
        System.out.println("avssss");
        Management management = new Management();
        management.readFile();
    }
    
}
