import java.io.*;

class File_Copy_Performance 
{
    public static void main(String[] args) 
    {
        String inputFile         = "input.txt";
        String outputUnbuffered  = "output_unbuffered.txt";
        String outputBuffered    = "output_buffered.txt";

        long timeUnbuffered = copyUsingUnbuffered(inputFile, outputUnbuffered);
        long timeBuffered   = copyUsingBuffered(inputFile, outputBuffered);

        System.out.println("\n⏱️ Time taken (Unbuffered): " + timeUnbuffered + " ns");
        System.out.println("⏱️ Time taken (Buffered)  : " + timeBuffered + " ns");
    }

    public static long copyUsingUnbuffered(String src, String dest) 
    {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try 
        {
            File srcFile = new File(src);

            if (!srcFile.exists()) 
            {
                System.out.println("❌ Source file does not exist: " + src);
                return 0;
            }

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(dest);

            byte[] buffer = new byte[4096];
            int bytesRead;

            long start = System.nanoTime();

            while ((bytesRead = fis.read(buffer)) != -1) 
            {
                fos.write(buffer, 0, bytesRead);
            }

            long end = System.nanoTime();
            System.out.println("✅ Unbuffered copy complete.");
            return (end - start);
        } 
        catch (IOException e) 
        {
            System.out.println("⚠️ I/O error in unbuffered copy: " + e.getMessage());
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

        return 0;
    }

    public static long copyUsingBuffered(String src, String dest) 
    {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try 
        {
            File srcFile = new File(src);

            if (!srcFile.exists()) 
            {
                System.out.println("❌ Source file does not exist: " + src);
                return 0;
            }

            bis = new BufferedInputStream(new FileInputStream(src));
            bos = new BufferedOutputStream(new FileOutputStream(dest));

            byte[] buffer = new byte[4096];
            int bytesRead;

            long start = System.nanoTime();

            while ((bytesRead = bis.read(buffer)) != -1) 
            {
                bos.write(buffer, 0, bytesRead);
            }

            long end = System.nanoTime();
            System.out.println("✅ Buffered copy complete.");
            return (end - start);
        } 
        catch (IOException e) 
        {
            System.out.println("⚠️ I/O error in buffered copy: " + e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (bis != null) bis.close();
                if (bos != null) bos.close();
            } 
            catch (IOException e) 
            {
                System.out.println("⚠️ Error closing buffered streams: " + e.getMessage());
            }
        }

        return 0;
    }
}