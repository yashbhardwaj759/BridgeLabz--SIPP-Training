import java.io.*;

// Class to handle file read-write operations
class File_Copy {

    public static void main(String[] args) 
    {
        String srcPath = "input.txt";        // Source file path
        String destPath = "output.txt";  // Destination file path

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try 
        {
            // Try opening the source file
            File srcFile = new File(srcPath);

            if (!srcFile.exists()) 
            {
                System.out.println("❌ Source file does not exist: " + srcPath);
                return;
            }

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destPath); // Creates file if not exists

            int byteData;

            // Read byte-by-byte and write to destination
            while ((byteData = fis.read()) != -1) 
            {
                fos.write(byteData);
            }

            System.out.println("✅ File copied successfully to: " + destPath);

        } 
        catch (IOException e) 
        {
            System.out.println("⚠️ An I/O error occurred: " + e.getMessage());

        } 
        finally 
        {
            try 
            {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } 
            catch (IOException e) 
            {
                System.out.println("⚠️ Error closing streams: " + e.getMessage());
            }
        }
    }
}