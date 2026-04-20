// ErrorLowFunds.java
package project.system;

public class ErrorLowFunds extends Exception {
    public ErrorLowFunds(String message){
        super(message);
    }

    public ErrorLowFunds(){
        super("Insufficient funds to support operation");
    }
}