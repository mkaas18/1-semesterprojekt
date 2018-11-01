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
public class EasyQuestion implements Questions{
    private String question;
    private double answer;
    private double number1;
    private double number2;
    
    public EasyQuestion(){

    }

    @Override
    public void addition() {
        number1 = getRandomNumber();
        number2 = getRandomNumber();
        question = "What is " + number1 + " + " + number2 + "?";
        answer = number1 + number2;
    }

    @Override
    public void multiplication() {
        number1 = getRandomNumber();
        number2 = getRandomNumber();
        question = "What is " + number1 + " x " + number2 + "?";
        answer = number1 * number2;

    }

    @Override
    public void division() {
        while(true){
            number1 = getRandomNumber();
            number2 = getRandomNumber();
            if(number1%number2==0 && number1 != 0 && number2 > 1){
                break;
            }
        } 
        question = "What is " + number1 + " / " + number2 + "?";
        answer = number1 / number2;

    }

    @Override
    public void subtraction() {
        number1 = getRandomNumber();
        number2 = getRandomNumber();
        question = "What is " + number1 + " - " + number2 + "?";
        answer = number1 - number2;
    }

    @Override
    public double getRandomNumber() {
        return (int)(Math.random()*10);
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public double getAnswer() {
        return answer;
    }

   
    
}