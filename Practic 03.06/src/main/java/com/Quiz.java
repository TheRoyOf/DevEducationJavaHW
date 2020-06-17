package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Quiz {
    private String name;
    private Map<String, Question> questions = new HashMap<String, Question>();

    public Quiz(String name, Map<String, Question> questions) {
        this.name = name;
        this.questions = questions;
    }

    public Question getQuestion(String key) {
        return questions.get(key);
    }

    public Set<String> correctAnswers() {
        return questions.keySet();
    }

    public void setAnswer (Question question, Map<String,Boolean> selectedAnswers){
        for (String s : selectedAnswers.keySet()) {
           question.addSelectedAnswers(s,selectedAnswers.get(s));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
