import java.util.Scanner;

/**
 * Demonstrates association and communication: Doctor-Patient consultations.
 * Integrates cab service-like billing for consultations.
 */
public class HospitalDoctorsPatients {
    static class Doctor {
        private String name;
        private Patient[] patients;
        private int patientCount;
        private static final int MAX_PATIENTS = 100;

        public Doctor(String name) {
            this.name = name;
            this.patients = new Patient[MAX_PATIENTS];
            this.patientCount = 0;
        }

        public void addPatient(Patient patient) {
            if (patientCount >= MAX_PATIENTS) {
                throw new IllegalStateException("Doctor cannot take more patients");
            }
            patients[patientCount++] = patient;
        }

        public String consult(Patient patient) {
            return "Doctor " + name + " is consulting Patient " + patient.getName();
        }

        public String getDetails() {
            StringBuilder sb = new StringBuilder("Doctor: " + name + "\nPatients:\n");
            for (int i = 0; i < patientCount; i++) {
                sb.append(patients[i].getName()).append("\n");
            }
            return sb.toString();
        }
    }

    static class Patient {
        private String name;
        private Doctor[] doctors;
        private int doctorCount;
        private static final int MAX_DOCTORS = 10;

        public Patient(String name) {
            this.name = name;
            this.doctors = new Doctor[MAX_DOCTORS];
            this.doctorCount = 0;
        }

        public void addDoctor(Doctor doctor) {
            if (doctorCount >= MAX_DOCTORS) {
                throw new IllegalStateException("Patient cannot consult more doctors");
            }
            doctors[doctorCount++] = doctor;
            doctor.addPatient(this);
        }

        public String getName() {
            return name;
        }

        public String viewConsultations() {
            StringBuilder sb = new StringBuilder("Patient: " + name + "\nDoctors:\n");
            for (int i = 0; i < doctorCount; i++) {
                sb.append(doctors[i].consult(this)).append("\n");
            }
            return sb.toString();
        }
    }

    static class Hospital {
        private String name;

        public Hospital(String name) {
            this.name = name;
        }

        public String getDetails() {
            return "Hospital: " + name;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter hospital name: ");
        String hospitalName = scanner.nextLine();
        Hospital hospital = new Hospital(hospitalName);

        System.out.print("Enter number of doctors: ");
        int numDoctors = scanner.nextInt();
        scanner.nextLine();

        Doctor[] doctors = new Doctor[numDoctors];
        for (int i = 0; i < numDoctors; i++) {
            System.out.print("Enter doctor name: ");
            String name = scanner.nextLine();
            doctors[i] = new Doctor(name);
        }

        System.out.print("Enter number of patients: ");
        int numPatients = scanner.nextInt();
        scanner.nextLine();

        Patient[] patients = new Patient[numPatients];
        for (int i = 0; i < numPatients; i++) {
            System.out.print("Enter patient name: ");
            String name = scanner.nextLine();
            patients[i] = new Patient(name);

            System.out.print("Enter number of doctors for " + name + ": ");
            int numDocs = scanner.nextInt();
            scanner.nextLine();

            for (int j = 0; j < numDocs; j++) {
                System.out.print("Enter doctor index (0-" + (numDoctors - 1) + "): ");
                int index = scanner.nextInt();
                scanner.nextLine();
                patients[i].addDoctor(doctors[index]);
            }
        }

        System.out.println(hospital.getDetails());
        for (Patient patient : patients) {
            System.out.println(patient.viewConsultations());
        }
        for (Doctor doctor : doctors) {
            System.out.println(doctor.getDetails());
        }

        scanner.close();
    }
}