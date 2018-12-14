package worldofzuul.logic;

import java.util.Random;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fredd
 */
public class QuestionBoss extends Question{
    public QuestionBoss(){}

    @Override
    public QuestionResults addition() {
        number1 = getRandomNumber();
        number2 = getRandomNumber();
        question = "What is " + number1 + " + " + number2 + "?";
        answer = number1 + number2;
        return results = new QuestionResults(question, answer);
    }

    @Override
    public QuestionResults multiplication() {
        number1 = getRandomNumber()*10;
        number2 = getRandomNumber()/10;
        question = "What is " + number1 + " x " + number2 + "?";
        answer = number1 * number2;
        return results = new QuestionResults(question, answer);
    }

    @Override
    public QuestionResults division() {
        while(true){
            number1 = (getRandomNumber()*10);
            number2 = getRandomNumber()/10.0;
            if(number1%number2==0 && number2 > 1){
                break;
            }
        } 
        question = "What is " + number1 + " / " + number2 + "?";
        answer = number1 / number2;
        return results = new QuestionResults(question, answer);
    }

    @Override
    public QuestionResults subtraction() {
        number1 = getRandomNumber();
        number2 = getRandomNumber();
        question = "What is " + number1 + " - " + number2 + "?";
        answer = number1 - number2;
        return results = new QuestionResults(question, answer);
    }

    @Override
    public double getRandomNumber() {    
        return new Random().nextInt(100)+1;
    }
  
    
}
