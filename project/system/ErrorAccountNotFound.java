// ErrorAccountNotFound.java
package project.system;

public class ErrorAccountNotFound extends Exception {
    public ErrorAccountNotFound(String message){
        super(message);
    }

    public ErrorAccountNotFound(){
        super("Account not found");
    }
}