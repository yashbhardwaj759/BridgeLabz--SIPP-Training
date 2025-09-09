import java.io.*;

class Image_ByteArray_Converter 
{
    public static void main(String[] args) 
    {
        String inputImagePath  = "input.jpg";
        String outputImagePath = "output.jpg";

        try 
        {
            // Step 1: Read image into byte array
            byte[] imageBytes = readImageToByteArray(inputImagePath);

            // Step 2: Write byte array back to a new image
            writeByteArrayToImage(imageBytes, outputImagePath);

            System.out.println("✅ Image copied successfully using byte array streams.");
        } 
        catch (IOException e) 
        {
            System.out.println("⚠️ I/O error: " + e.getMessage());
        }
    }

    public static byte[] readImageToByteArray(String imagePath) throws IOException 
    {
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;

        try 
        {
            fis = new FileInputStream(imagePath);
            baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) 
            {
                baos.write(buffer, 0, bytesRead);
            }

            return baos.toByteArray();
        } 
        finally 
        {
            if (fis != null) fis.close();
            if (baos != null) baos.close();
        }
    }

    public static void writeByteArrayToImage(byte[] imageBytes, String outputPath) throws IOException 
    {
        ByteArrayInputStream bais = null;
        FileOutputStream fos = null;

        try 
        {
            bais = new ByteArrayInputStream(imageBytes);
            fos  = new FileOutputStream(outputPath);

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = bais.read(buffer)) != -1) 
            {
                fos.write(buffer, 0, bytesRead);
            }
        } 
        finally 
        {
            if (bais != null) bais.close();
            if (fos  != null) fos.close();
        }
    }
}
