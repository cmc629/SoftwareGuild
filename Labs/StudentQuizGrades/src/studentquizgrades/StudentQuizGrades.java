/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentquizgrades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Christian Choi
 */
public class StudentQuizGrades {
    
    private Map<String, List<Integer>> studentMap;
    
    
    public StudentQuizGrades() {
        this.studentMap = new HashMap<>();
    }

    public Map<String, List<Integer>> getStudentMap() {
        return studentMap;
    }

    public Set<String> getStudents() {
        return this.studentMap.keySet();
    }
    
    public void addStudent(String student) {
        List<Integer> emptyScores = new ArrayList();
        this.studentMap.put(student, emptyScores);
    }
    
    public void addStudent(String student, List<Integer> scores) {
        this.studentMap.put(student, scores);
    }
    
    public void addScore(String student, int score) {
        this.studentMap.get(student).add(score);
    }
    
    public void removeStudent(String student) {
        this.studentMap.remove(student);
    }
    
    public List<Integer> getStudentScores(String student) {
        return this.studentMap.get(student);
    }
    
    public float getAverageScore(String student) {
        List<Integer> scoreList = this.getStudentScores(student);
        float total = 0.0f;
        if (scoreList.isEmpty()) {
            System.out.println("\n" + student + " does not have any quiz scores!");
            return Float.NaN;
        }
        else {
            for (int score: scoreList) {
                total += score;
            }
            return total/scoreList.size();
        }
    }
    
    public float getClassAverage() {
        float total = 0.0f;
        float numValidStudents = 0.0f;
        for (String student : this.getStudents()) {
            if (this.getStudentScores(student).isEmpty()) {
                System.out.println("\n" + student + " does not have any quiz scores. " + student + " was not included when calculating class average.");
                continue;
            }
            total += getAverageScore(student);
            numValidStudents++;
        }
        return total/numValidStudents;
    }
    
    public int getHighestScore() {
        int maxScore = 0;
        for (String student : this.getStudents()) {
            List<Integer> scoreList = this.getStudentScores(student);
            for (int score : scoreList) {
                if (score > maxScore) maxScore = score;
            }
        }
        return maxScore;
    }
    
    public int getLowestScore() {
        int minScore = 10000;
        for (String student : this.getStudents()) {
            List<Integer> scoreList = this.getStudentScores(student);
            for (int score : scoreList) {
                if (score < minScore) minScore = score;
            }
        }
        return minScore;
    }
    
    public List<String> listHighScoreStudents() {
        List<String> listHighScores = new ArrayList();
        for (String student : this.getStudents()) {
            List<Integer> studentScores = this.getStudentScores(student);
            for (int score : studentScores) {
                if (score == this.getHighestScore()) {
                    listHighScores.add(student);
                }
            }
        }
        return listHighScores;
    }
    
    public List<String> listLowScoreStudents() {
        List<String> listLowScores = new ArrayList();
        for (String student : this.getStudents()) {
            List<Integer> studentScores = this.getStudentScores(student);
            for (int score : studentScores) {
                if (score == this.getLowestScore()) {
                    listLowScores.add(student);
                }
            }
        }
        return listLowScores;
    }

} 
