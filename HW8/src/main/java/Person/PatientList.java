package Person;

import java.util.ArrayList;

public class PatientList{

    static ArrayList<Patient> patients = new ArrayList<Patient>();

    public static ArrayList<Patient> GetByDiagnosis(String diagnosis)
    {
        ArrayList<Patient> rezult = new ArrayList<Patient>();

        for (Patient patient:patients)
        {
            if (patient.name.equals(diagnosis))
            {
                rezult.add(patient);
            }
        }

        return rezult;
    }

    public static Patient GetByMedicCardNumber(String card)
    {
        for (Patient patient:patients)
        {
            if (patient.medicCardNumber.equals(card))
            {
                return patient;
            }
        }
        return null;
    }

}
