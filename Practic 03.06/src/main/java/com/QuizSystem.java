package com;

import java.util.HashMap;
import java.util.Map;

public class QuizSystem {

   private static Map<String, Quiz> quizes = new HashMap<String, Quiz>();

    public static Map<String, Quiz> getQuiz() {
        return quizes;
    }

    public static void addQuiz(Quiz quiz){
        quizes.put(quiz.getName(), quiz);
    }
}
