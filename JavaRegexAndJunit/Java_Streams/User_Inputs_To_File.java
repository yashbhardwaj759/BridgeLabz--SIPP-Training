import java.io.*;

class User_Input_To_File 
{
    public static void main(String[] args) 
    {
        BufferedReader reader = null;
        FileWriter writer = null;

        try 
        {
            reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            writer = new FileWriter("output.txt"); // Writing to output.txt as per your default
            writer.write("Name    : " + name + "\n");
            writer.write("Age     : " + age + "\n");
            writer.write("Language: " + language + "\n");

            System.out.println("✅ Information saved to output.txt");
        } 
        catch (IOException e) 
        {
            System.out.println("⚠️ Error during input/output: " + e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } 
            catch (IOException e) 
            {
                System.out.println("⚠️ Error closing streams: " + e.getMessage());
            }
        }
    }
}