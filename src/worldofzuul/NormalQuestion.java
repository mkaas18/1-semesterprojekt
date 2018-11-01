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
public class NormalQuestion implements Questions{
    private String question;
    private double answer;
    private double number1;
    private double number2;
    
    public NormalQuestion(){
        
    }

    @Override
    public void addition() {
        number1 = (int)getRandomNumber();
        number2 = (int)getRandomNumber();
        question = "What is " + number1 + " + " + number2 + "?";
        answer = number1 + number2;
    }

    @Override
    public void multiplication() {
        number1 = (int)getRandomNumber()/10;
        number2 = (int)getRandomNumber();
        question = "What is " + (int)number1 + " x " + number2 + "?";
        answer = number1 * number2;
    }

    @Override
    public void division() {
        while(true){
            number1 = (int)getRandomNumber();
            number2 = (int)(getRandomNumber()/10.0);
            if(number1%number2==0 && number1 != 0 && number2 > 1){
                break;
            }
        } 
        question = "What is " + number1 + " / " + number2 + "?";
        answer = number1 / number2;
    }

    @Override
    public void subtraction() {
        number1 = (int)getRandomNumber();
        number2 = (int)getRandomNumber();
        question = "What is " + number1 + " - " + number2 + "?";
        answer = number1 - number2;
    }

    @Override
    public double getRandomNumber() {
        return Math.random()*100;
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
