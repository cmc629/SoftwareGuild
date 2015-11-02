/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentquizgrades;

/**
 *
 * @author Christian Choi
 */
public class UI {
    
    
    public static void main(String[] args) {
        
        StudentQuizGrades classroom = new StudentQuizGrades();
        ConsoleIO console = new ConsoleIO();
        boolean isRunning = true;
        console.printToConsole("Welcome to the classroom!");
        while(isRunning) {
            int input = console.promptInt("\nWould you like to: " +
            "\n1) Add student(s)?\n2) Add quiz score(s)?" +
            "\n3) Get a list of current students?" + 
            "\n4) Find the student(s) with the highest score?" +
            "\n5) Find the student(s) with the lowest score?" +
            "\n6) Get the class average score?\n7) Remove student(s)" +
            "\n8) Close the program?\n> ", 1, 8);
            
            if (input == 1) {
                while (true) {
                    String name = console.promptString("\nPlease enter the student's full name. Enter 'exit' to stop adding students: ");
                    if (name.toLowerCase().equals("exit")) {
                        break;
                    }
                    classroom.addStudent(name);
                    console.printToConsole(name + " has been added to the classroom!");
                }
            }
            if (input == 2) {
                console.printToConsole("\nList of current students: " + classroom.getStudents());
                while (true) {
                    if (classroom.getStudents().isEmpty()) {
                        console.printToConsole("There are currently no students!");
                        break;
                    }
                    String name = console.promptString("\nPlease enter a student name to add a score. Enter 'exit' to go back to main menu: ");
                    if (name.toLowerCase().equals("exit")) break;
                    while (!classroom.getStudents().contains(name)) {
                        name = console.promptString("Student not found! Please enter a student name to add a score: ");
                    }
                    boolean shouldAdd = true;
                    while (shouldAdd) {
                        int score = console.promptInt("\nPlease enter the quiz score between 0-100. " + 
                                "Enter -1 to stop adding scores: ", -1, 100);
                        if (score == -1) {
                            shouldAdd = false;
                            break;
                        }
                        classroom.addScore(name, score);
                        console.printToConsole("The score " + score + " was added to " + name + "'s quiz scores.");
                    }
                }
            }
            if (input == 3) { 
                boolean shouldContinue = true;
                while(shouldContinue) {
                    if (classroom.getStudents().isEmpty()) {
                        console.printToConsole("\nThere are currently no students!");
                        break;
                    }
                    console.printToConsole("\nList of current students: " + classroom.getStudents());
                    String name = console.promptString("Please pick a student to view his/her results: ");
                    while (!classroom.getStudents().contains(name)) {
                        name = console.promptString("Student not found! Please pick a student to view his/her results: ");
                    }
                    console.printToConsole("\nThe list of scores for " + name + " is: " + classroom.getStudentScores(name));
                    console.printToConsole("The average scores for " + name + " is: " + classroom.getAverageScore(name));
                    boolean isValid = false;
                    while(!isValid) {
                        String answer = console.promptString("\nPick another student? Yes/No? ").toLowerCase();
                        if (answer.equals("no")) {
                            shouldContinue = false;
                            isValid = true;
                        }
                        else if (answer.equals("yes")) {
                            shouldContinue = true;
                            isValid = true;
                        }
                        else {
                            console.printToConsole("Invalid input!");
                        }
                    }
                }
            }
            if (input == 4) {
                console.printToConsole("\nThe student(s) with the highest score: " + classroom.listHighScoreStudents());
            }
            if (input == 5) {
                console.printToConsole("\nThe student(s) with the lowest score: " + classroom.listLowScoreStudents());
            }
            if (input == 6) {
                console.printToConsole("\nThe average score of the entire class is: " + classroom.getClassAverage());
            }
            if (input == 7) {
                console.printToConsole("\nList of current students: " + classroom.getStudents());
                while (true) {
                    if (classroom.getStudents().isEmpty()) {
                        console.printToConsole("There are currently no students!");
                        break;
                    }
                    String name = console.promptString("\nEnter a student name to remove student. Enter 'exit' to go back to main menu: ");                   
                    if (name.toLowerCase().equals("exit")) {
                        break;
                    }
                    while (!classroom.getStudents().contains(name)) {
                        name = console.promptString("Student not found! Please enter a current student name to remove: ");
                    }
                    classroom.removeStudent(name); 
                    console.printToConsole(name + " was removed from the class.");
                }
            }
            if (input == 8) {
                console.printToConsole("\nThank you and goodbye. Closing program...");
                isRunning = false;
            }
        }
        
    }
    
    
   
}
