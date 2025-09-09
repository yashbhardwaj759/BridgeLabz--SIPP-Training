import java.io.*;

// Class to demonstrate piped stream communication
class Piped_Communication 
{
    public static void main(String[] args) 
    {
        try 
        {
            // Create piped streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos); // Connect to output

            // Writer thread
            Thread writer = new Thread(new Runnable() 
            {
                public void run() 
                {
                    try 
                    {
                        String message = "Hello from Writer Thread!";
                        pos.write(message.getBytes());
                        pos.close();
                    } 
                    catch (IOException e) 
                    {
                        System.out.println("⚠️ Writer error: " + e.getMessage());
                    }
                }
            });

            // Reader thread
            Thread reader = new Thread(new Runnable() 
            {
                public void run() 
                {
                    try 
                    {
                        int data;
                        System.out.print("📥 Reader received: ");
                        while ((data = pis.read()) != -1) 
                        {
                            System.out.print((char) data);
                        }
                        pis.close();
                    } 
                    catch (IOException e) 
                    {
                        System.out.println("⚠️ Reader error: " + e.getMessage());
                    }
                }
            });

            // Start both threads
            writer.start();
            reader.start();

            // Wait for both to finish
            writer.join();
            reader.join();
        } 
        catch (IOException | InterruptedException e) 
        {
            System.out.println("⚠️ Error setting up piped communication: " + e.getMessage());
        }
    }
}