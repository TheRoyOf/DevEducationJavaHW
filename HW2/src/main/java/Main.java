public class Main
{
    enum EAction
    {
        Sum,
        Sub,
        Mul,
        Div,
        Mod;
    }

    public static void main(String[] args)
    {
        byte val_byte = 1;
        short val_short = 2;
        int val_int = 3;
        long val_long = 4;
        char val_char = 'a';
        float val_float = 6;
        double val_double = 7; //объявили и инициализировали переменные
        // а где boolean? это ведь тоже примитив

        System.out.println("Примеры неявного преобразования");
        System.out.println("Byte + Short = " + MathAction(EAction.Sum,val_byte, val_short));
        System.out.println("Short + Int = " + MathAction(EAction.Sum,val_short, val_int));
        System.out.println("Short + Char = " + MathAction(EAction.Sum,val_short, (int) val_char)); //Наш метод прнимает числовые значения, однако char является символьным значением, потому закостылим явное преобразование в число и ок
        System.out.println("Int + Long = " + MathAction(EAction.Sum,val_int, val_long));
        System.out.println("Int + Float = " + MathAction(EAction.Sum,val_int, val_float));
        System.out.println("Int + Double = " + MathAction(EAction.Sum,val_int, val_double));

        System.out.println("\nМатематические операции. деление целочисленных типов и остаток от деления");
        System.out.println("Long 4 + int 3 = " + (int)MathAction(EAction.Sum,val_long, val_int) + " пример математической операции");
        System.out.println("Long 4 / int 3 = " + (int)MathAction(EAction.Div,val_long, val_int) + " Потеря в виду отсечки дробной части"); // тут делаю дополнительно явное преобразование для корректности демонстрации
        System.out.println("int 9 / int 2 = " + (int)MathAction(EAction.Div,9,2) + " Потеря в виду отсечки дробной части");
        System.out.println("Long 4 % Int 3 = " + MathAction(EAction.Mod,val_long, val_int));

        val_int = 100; // для далнейшего преведения в char

        System.out.println("\nПреобразование int -> char -> int");
        System.out.println("Int " + val_int + " to char = " + (char) val_int);
        System.out.println("char '" + val_char + "' to int = " + (int) val_char);

        val_double = 1.99999;

        System.out.println("\nПриводим double " + val_double + " к int = " + (int)val_double + " новичик ожидали округление? Java пофиг, дробную часть откинули и готово");

// лишние пробелы

    }

    /**
     * Математические операции над любыми числовыми типами данных
     *
     * @param act - Действие
     * @param operand_A,operand_B - Сумируемые числовые значения
     * @return Возвращает сумму в типе double
     */

    public static <T extends Number, S extends Number> double MathAction(EAction act,T operand_A, S operand_B)
    {
        switch (act)
        {
            case Sum:
                return operand_A.doubleValue() + operand_B.doubleValue();
            case Div:
                return operand_A.doubleValue() / operand_B.doubleValue();
            case Sub:
                return operand_A.doubleValue() - operand_B.doubleValue();
            case Mul:
                return operand_A.doubleValue() * operand_B.doubleValue();
            case Mod:
                return operand_A.doubleValue() % operand_B.doubleValue();
        }
        return 0;
    }
}
