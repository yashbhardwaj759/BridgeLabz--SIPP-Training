import java.io.*;

class Convert_To_Lowercase 
{
    public static void main(String[] args) 
    {
        String inputFile  = "input.txt";
        String outputFile = "output.txt";

        BufferedReader reader = null;
        BufferedWriter writer = null;

        try 
        {
            // Reader with character encoding (UTF-8)
            reader = new BufferedReader(
                        new InputStreamReader(
                            new FileInputStream(inputFile), "UTF-8"));

            // Writer with character encoding (UTF-8)
            writer = new BufferedWriter(
                        new OutputStreamWriter(
                            new FileOutputStream(outputFile), "UTF-8"));

            String line;

            while ((line = reader.readLine()) != null) 
            {
                writer.write(line.toLowerCase());
                writer.newLine();
            }

            System.out.println("✅ File converted to lowercase and saved as " + outputFile);
        } 
        catch (IOException e) 
        {
            System.out.println("⚠️ I/O error: " + e.getMessage());
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
