package worldofzuul;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SteamyBlizzard
 */
public class QuestionResults {
    String question;
    String correctAnswer = null;
    String wrongAnswer1 = null;
    String wrongAnswer2 = null;
    double answer = 0;

    public QuestionResults(String question, double answer) {
        this.question = question;
        this.answer = answer;
    }
    public QuestionResults(String question, String correctAnswer, 
            String wrongAnswer1, String wrongAnswer2) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer1 = wrongAnswer1;
        this.wrongAnswer2 = wrongAnswer2;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getWrongAnswer1() {
        return wrongAnswer1;
    }

    public void setWrongAnswer1(String wrongAnswer1) {
        this.wrongAnswer1 = wrongAnswer1;
    }

    public String getWrongAnswer2() {
        return wrongAnswer2;
    }

    public void setWrongAnswer2(String wrongAnswer2) {
        this.wrongAnswer2 = wrongAnswer2;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public double getAnswer() {
        return answer;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }
    @Override
    public String toString(){
        String output = "";
        if(this.correctAnswer==null){
            output += this.question + "\n" + this.answer;
            return output;
        } else {
            output += this.question + "\n";
            output += "Possible answers: \n";
            output += this.correctAnswer + "\n";
            output += this.wrongAnswer1 + "\n";
            output += this.wrongAnswer2 + "\n";
            return output;
        }
    }
    
}
