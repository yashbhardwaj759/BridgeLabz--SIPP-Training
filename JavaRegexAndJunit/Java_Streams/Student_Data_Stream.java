import java.io.*;

class Student_Data_Stream 
{
    public static void main(String[] args) 
    {
        String fileName = "output.txt";

        // Sample student data
        int rollNumber     = 101;
        String studentName = "Shikhar Gupta";
        double gpa         = 9.2;

        writeStudentData(fileName, rollNumber, studentName, gpa);
        readStudentData(fileName);
    }

    public static void writeStudentData(String fileName, int roll, String name, double gpa) 
    {
        DataOutputStream dos = null;

        try 
        {
            dos = new DataOutputStream(new FileOutputStream(fileName));
            dos.writeInt(roll);
            dos.writeUTF(name);
            dos.writeDouble(gpa);

            System.out.println("✅ Student data written to " + fileName);
        } 
        catch (IOException e) 
        {
            System.out.println("⚠️ Write error: " + e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (dos != null) dos.close();
            } 
            catch (IOException e) 
            {
                System.out.println("⚠️ Error closing output stream: " + e.getMessage());
            }
        }
    }

    public static void readStudentData(String fileName) 
    {
        DataInputStream dis = null;

        try 
        {
            dis = new DataInputStream(new FileInputStream(fileName));

            int roll       = dis.readInt();
            String name    = dis.readUTF();
            double gpa     = dis.readDouble();

            System.out.println("\n✅ Retrieved Student Info:");
            System.out.println("Roll No : " + roll);
            System.out.println("Name    : " + name);
            System.out.println("GPA     : " + gpa);
        } 
        catch (IOException e) 
        {
            System.out.println("⚠️ Read error: " + e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (dis != null) dis.close();
            } 
            catch (IOException e) 
            {
                System.out.println("⚠️ Error closing input stream: " + e.getMessage());
            }
        }
    }
}