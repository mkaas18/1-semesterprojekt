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

    public void mathQuestion(Command command) {
        boolean gotType = false;
        if (!command.hasSecondWord()) {
            System.out.println("What difficulty?");
        } else {
            switch (command.getSecondWord()) {
                case "easy":
                    gotType = questionType(easy);
                    if (gotType) {
                        answerQuestion(easy);
                    }
                    break;
                case "normal":
                    gotType = questionType(normal);
                    if (gotType) {
                        answerQuestion(normal);
                    }
                    break;
                case "hard":
                    gotType = questionType(hard);
                    if (gotType) {
                        answerQuestion(hard);
                    }
                    break;
                default:
                    System.out.println("There is no such difficulty");
                    break;
            }

        }
    }

    public boolean questionType(Questions question) {
        System.out.println("What question type?");
        switch (getAnswer.next()) {
            case "addition":
                question.addition();
                return true;
            case "subtraction":
                question.subtraction();
                return true;
            case "multiplication":
                question.multiplication();
                return true;
            case "division":
                question.division();
                return true;
            default:
                System.out.println("No such question of that type");
                return false;

        }
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
