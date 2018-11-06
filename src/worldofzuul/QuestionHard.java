package worldofzuul;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fredd
 */
public class QuestionHard extends Question{
    public QuestionHard(){}

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
        number1 = (getRandomNumber()*10);
        number2 = (int)getRandomNumber()/10;
        question = "What is " + (int)number1 + " x " + number2 + "?";
        answer = number1 * number2;
        return results = new QuestionResults(question, answer);
    }

    @Override
    public QuestionResults division() {
        while(true){
            number1 = (getRandomNumber()*10);
            number2 = getRandomNumber()/10.0;
            if(number1%number2==0 && number1 != 0 && number2 > 1){
                break;
            }
        } 
        question = "What is " + (int)number1 + " / " + (int)number2 + "?";
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
        return ((int)(Math.random()*1000)/10.0);
    }
  
    
}
