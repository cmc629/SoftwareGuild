/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import studentquizgrades.StudentQuizGrades;

/**
 *
 * @author Christian Choi
 */
public class StudentQuizGradesTest {
    
    StudentQuizGrades classroom;
    
    public StudentQuizGradesTest() {
    }
    
    @Before
    public void setUp() {
        
        classroom = new StudentQuizGrades();
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void TestStudentQuizGrades() {
        
        Map<String, List<Integer>> expectedMap = new HashMap<>();
        
        //Add a student Mary Swanson
        classroom.addStudent("Mary Swanson");
        List<Integer> expectedMaryScores = new ArrayList();
        expectedMap.put("Mary Swanson", expectedMaryScores);
        Assert.assertEquals(expectedMap, classroom.getStudentMap());
        
        //Add another student George Bush
        classroom.addStudent("George Bush");
        List<Integer> expectedGeorgeScores = new ArrayList();
        expectedMap.put("George Bush", expectedGeorgeScores);
        Assert.assertEquals(expectedMap, classroom.getStudentMap());
        
        //Add another student Jill Jackson
        classroom.addStudent("Jill Jackson");
        List<Integer> expectedJillScores = new ArrayList();
        expectedMap.put("Jill Jackson", expectedJillScores);
        Assert.assertEquals(expectedMap, classroom.getStudentMap());
        
        //Get average score of Mary Swanson
        float maryAverage = classroom.getAverageScore("Mary Swanson");
        Assert.assertEquals(Float.NaN, maryAverage, 0.001);
        
        //List students with highest scores (shouldn't list any students)
        List<String> expectedHigh = new ArrayList();
        Assert.assertEquals(expectedHigh, classroom.listHighScoreStudents());
        
        //List studnets with lowest scores (shouldn't list any students)
        List<String> expectedLow = new ArrayList();
        Assert.assertEquals(expectedLow, classroom.listLowScoreStudents());
        
        //Add scores to Mary Swanson
        classroom.addScore("Mary Swanson", 30);
        expectedMaryScores.add(30);
        Assert.assertEquals(expectedMap, classroom.getStudentMap());
        
        //Add scores to George Bush more than once
        classroom.addScore("George Bush", 0);
        classroom.addScore("George Bush", 10);
        classroom.addScore("George Bush", 15);
        expectedGeorgeScores.add(0);
        expectedGeorgeScores.add(10);
        expectedGeorgeScores.add(15);
        Assert.assertEquals(expectedMap, classroom.getStudentMap());
        
        //Get average score of Mary Swanson. Her scores is just 30
        maryAverage = classroom.getAverageScore("Mary Swanson");
        Assert.assertEquals(30.0, maryAverage, 0.001);
        
        //Get average score of George Bush. His scores are 0, 10, 15
        float bushAverage = classroom.getAverageScore("George Bush");
        Assert.assertEquals(8.333, bushAverage, 0.001);
        
        //Get class average. Mary's average is 30 and George's is 8.33.
        //19.167 should be the class average. Jill is not accounted for since
        //she has no scores
        float classAverage = classroom.getClassAverage();
        Assert.assertEquals(19.167, classAverage, 0.001);
        
        //Add scores to Jill Jackson
        classroom.addScore("Jill Jackson", 100);
        classroom.addScore("Jill Jackson", 0);
        expectedJillScores.add(100);
        expectedJillScores.add(0);
        expectedMap.put("Jill Jackson", expectedJillScores);
        Assert.assertEquals(expectedMap, classroom.getStudentMap());
        
        //Get average score of Jill Jackson. Her scores are 0, 100
        float jillAverage = classroom.getAverageScore("Jill Jackson");
        Assert.assertEquals(50, jillAverage, 0.001);
        
        //Get class average. This time everyone should have an average score.
        //Get the average of 30, 8.333, and 50
        classAverage = classroom.getClassAverage();
        Assert.assertEquals(29.444, classAverage, 0.001);
        
        //List students with highest scores. Should only have Jill
        List<String> highScorers = classroom.listHighScoreStudents();
        boolean containsJill = highScorers.contains("Jill Jackson");
        boolean containsGeorge = highScorers.contains("George Bush");
        boolean containsMary = highScorers.contains("Mary Swanson");
        Assert.assertTrue(containsJill);
        Assert.assertFalse(containsGeorge);
        Assert.assertFalse(containsMary);
        
        //List students with lowest scores. Should have both Jill and George
        //ArrayLists are ordered so 
        //["Jill Jackson", "George Bush"] != ["George Bush", "Jill Jackson"].
        //Make a boolean that checks to see if the list contains both students
        List<String> lowScorers = classroom.listLowScoreStudents();
        containsJill = lowScorers.contains("Jill Jackson");
        containsGeorge = lowScorers.contains("George Bush");
        containsMary = highScorers.contains("Mary Swanson");
        Assert.assertTrue(containsJill);
        Assert.assertTrue(containsGeorge);
        Assert.assertFalse(containsMary);
        
        //Remove student George
        classroom.removeStudent("George Bush");
        expectedMap.remove("George Bush");
        Assert.assertEquals(expectedMap, classroom.getStudentMap());
        
        //Check class average. George's average score of 8.333 should be gone
        //so the average class score is calculated using Jill's 50 and Mary's
        //30.
        classAverage = classroom.getClassAverage();
        Assert.assertEquals(40, classAverage, 0.001);
        
        //List students with highest scores after removing George.
        //Should only have Jill
        highScorers = classroom.listHighScoreStudents();
        containsJill = highScorers.contains("Jill Jackson");
        containsGeorge = highScorers.contains("George Bush");
        containsMary = highScorers.contains("Mary Swanson");
        Assert.assertTrue(containsJill);
        Assert.assertFalse(containsGeorge);
        Assert.assertFalse(containsMary);
        
        //List students with lowest scores. George was removed so only Jill 
        //should be on the list.
        lowScorers = classroom.listLowScoreStudents();
        containsJill = lowScorers.contains("Jill Jackson");
        containsGeorge = lowScorers.contains("George Bush");
        containsMary = highScorers.contains("Mary Swanson");
        Assert.assertTrue(containsJill);
        Assert.assertFalse(containsGeorge);
        Assert.assertFalse(containsMary);
        
        //Remove student Jill
        classroom.removeStudent("Jill Jackson");
        expectedMap.remove("Jill Jackson");
        Assert.assertEquals(expectedMap, classroom.getStudentMap());
        
        //List students with highest scores. Mary is the only one left. She
        //should be in the list of students with highest scores.
        highScorers = classroom.listHighScoreStudents();
        containsJill = highScorers.contains("Jill Jackson");
        containsGeorge = highScorers.contains("George Bush");
        containsMary = highScorers.contains("Mary Swanson");
        Assert.assertFalse(containsJill);
        Assert.assertFalse(containsGeorge);
        Assert.assertTrue(containsMary);
        
        //List students with lowest scores. Mary is the only one left. She
        //should be in the list of students with lowest scores.
        lowScorers = classroom.listLowScoreStudents();
        containsJill = lowScorers.contains("Jill Jackson");
        containsGeorge = lowScorers.contains("George Bush");
        containsMary = highScorers.contains("Mary Swanson");
        Assert.assertFalse(containsJill);
        Assert.assertFalse(containsGeorge);
        Assert.assertTrue(containsMary);
        
        //Check class average. Mary is the only one left and her only score is
        //30. The class average should be 30
        classAverage = classroom.getClassAverage();
        Assert.assertEquals(30, classAverage, 0.001);
        
    }
    
}
