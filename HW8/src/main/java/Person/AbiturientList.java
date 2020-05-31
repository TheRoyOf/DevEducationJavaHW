package Person;

import java.util.ArrayList;

public class AbiturientList {

    static ArrayList<Abiturient> abiturients = new ArrayList<Abiturient>();

    // Все методы должны начинаться с маленькой буквы и должны описывать действие, например - getRatingLessThat(), countRatingLessThat()
    public static ArrayList<Abiturient> RatingLessThat(float val)
    {
        ArrayList<Abiturient> rezult = new ArrayList<Abiturient>();

        for (Abiturient abiturient:abiturients)
        {
            for (String assesment:abiturient.GetAssesment())
            {
                if (abiturient.GetRating(assesment) <= val)
                {
                    rezult.add(abiturient);
                    break;
                }
            }
        }

        return rezult;
    }

    public static ArrayList<Abiturient> AverageRatingMoreThat(float val)
    {
        ArrayList<Abiturient> rezult = new ArrayList<Abiturient>();

        for (Abiturient abiturient:abiturients)
        {
            float bal = 0;
            int count = 0;
            for (String assesment:abiturient.GetAssesment())
            {
                bal += abiturient.GetRating(assesment);
                ++count;
            }
            if (bal/count >= val)
            {
                rezult.add(abiturient);
            }
        }

        return rezult;
    }
}
