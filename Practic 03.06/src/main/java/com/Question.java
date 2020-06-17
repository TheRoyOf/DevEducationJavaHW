package com;

import java.util.HashMap;
import java.util.Map;

public class Question {
    private String question;
    private Map<String, Boolean> answers = new HashMap<String, Boolean>();
    private Map<String, Boolean> selectedAnswers = new HashMap<String, Boolean>();

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void addAnswer (String answer, Boolean isCorrect){
        answers.put(answer, isCorrect);
    }

    public void removeAnswer (String answer, Boolean isCorrect){
        answers.remove(answer);
    }

    @Override
    public String toString() {
        return "com.Question{" +
                "question='" + question + '\'' +
                ", answers=" + answers +
                '}';
    }

    public Map<String, Boolean> getAnswers() {
        return answers;
    }

    public void addSelectedAnswers(String answer, Boolean isSelected){
        selectedAnswers.put(answer, isSelected);
    }
}
