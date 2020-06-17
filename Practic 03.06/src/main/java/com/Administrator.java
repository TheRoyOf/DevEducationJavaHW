package com;

import java.util.Map;

public class Administrator extends User {

    public void addNewQuiz(String name ,Map<String, Question> questionMap){
        Quiz quiz = new Quiz(name, questionMap);
        quiz.setName(name);
        QuizSystem.addQuiz(quiz);
    }

    public Map<String, Question> addQuestion(Map<String, Question> questionMap, Question newQuestion){
        questionMap.put(newQuestion.getQuestion(), newQuestion);
        return questionMap;
    }

    public Map<String, Question> removeQuestion(Map<String, Question> questionMap, Question question){
        questionMap.remove(question);
        return questionMap;
    }

    public void setUserBanned(User user) {
        user.setBanned(true);
    }

    public void setUserUnbanned(User user) {
        user.setBanned(false);
    }
}
