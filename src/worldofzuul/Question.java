package worldofzuul;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SteamyBlizzard
 */
public class Question {

    Questions hard, normal, easy;
    Scanner getAnswer = new Scanner(System.in);

    public Question() {
        hard = new HardQuestion();
        normal = new NormalQuestion();
        easy = new EasyQuestion();
    }
    public void answerQuestion(Questions question) {
        double answer;
        System.out.println(question.getQuestion());
        answer = getAnswer.nextDouble();
        if (answer == question.getAnswer()) {
            System.out.println("The answer was correct!");
        } else {
            System.out.println("Wrong answer :(");
        }
    }

    public Questions getHardQuestion() {
        return hard;
    }

    public Questions getNormalQuestion() {
        return normal;
    }

    public Questions getEasyQuestion() {
        return normal;
    }

}
