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
public class NormalQuestion extends Questions{
    
    public NormalQuestion(){
        
    }

    @Override
    public QuestionResults addition() {
        number1 = (int)getRandomNumber();
        number2 = (int)getRandomNumber();
        question = "What is " + number1 + " + " + number2 + "?";
        answer = number1 + number2;
        return results = new QuestionResults(question, answer);
    }

    @Override
    public QuestionResults multiplication() {
        number1 = (int)getRandomNumber()/10;
        number2 = (int)getRandomNumber();
        question = "What is " + (int)number1 + " x " + number2 + "?";
        answer = number1 * number2;
        return results = new QuestionResults(question, answer);
    }

    @Override
    public QuestionResults division() {
        while(true){
            number1 = (int)getRandomNumber();
            number2 = (int)(getRandomNumber()/10.0);
            if(number1%number2==0 && number1 != 0 && number2 > 1){
                break;
            }
        } 
        question = "What is " + number1 + " / " + number2 + "?";
        answer = number1 / number2;
        return results = new QuestionResults(question, answer);
    }

    @Override
    public QuestionResults subtraction() {
        number1 = (int)getRandomNumber();
        number2 = (int)getRandomNumber();
        question = "What is " + number1 + " - " + number2 + "?";
        answer = number1 - number2;
        return results = new QuestionResults(question, answer);
    }

    @Override
    public double getRandomNumber() {
        return Math.random()*100;
    }

   
    
}
