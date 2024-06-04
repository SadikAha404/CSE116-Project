package tests;

import org.junit.Test;
import ratings.ProblemSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestProblemSet {

    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class

    @Test
    public void testAverage() {
        ArrayList<Double> temp = new ArrayList<>(Arrays.asList(1.0,2.0,3.0));
        assertEquals(2.0,ProblemSet.average(temp), 0.001);
        ArrayList<Double> temp2 = new ArrayList<>(Arrays.asList(-5.0,5.0));
        assertEquals(0.0,ProblemSet.average(temp2),0.001);
        ArrayList<Double> temp3 = new ArrayList<>(Arrays.asList(6.5,6.5,8.5,8.5));
        assertEquals(7.5, ProblemSet.average(temp3), 0.001);
        ArrayList<Double> temp4 = new ArrayList<>();
        assertEquals(0.0, ProblemSet.average(temp4), 0.001);
        ArrayList<Double> temp5 = new ArrayList<>(Arrays.asList(6.5));
        assertEquals(6.5,ProblemSet.average(temp5), 0.001);
    }

    @Test
    public void testSumOfDigits() {
        assertTrue(ProblemSet.sumOfDigits(123)==6);
        assertTrue(ProblemSet.sumOfDigits(57)==12);
        assertTrue(ProblemSet.sumOfDigits(-36)==9);
    }

    @Test
    public void testBestKey(){
        HashMap<String,Integer> temp = new HashMap<>();{{
            temp.put("CSE", 100);
            temp.put("MTH",90);
            temp.put("MGT",10);
        }}
        assertTrue(ProblemSet.bestKey(temp).equals("CSE"));
        HashMap<String,Integer> temp2 = new HashMap<>();{{
            temp2.put("cat", 5);
            temp2.put("dog",5);
            temp2.put("fox",4);
        }}
        assertTrue(ProblemSet.bestKey(temp2).equals("cat") || ProblemSet.bestKey(temp2).equals("dog"));
        HashMap<String,Integer> temp3 = new HashMap<>();
        assertTrue(ProblemSet.bestKey(temp3).equals(""));
        HashMap<String,Integer> temp4 = new HashMap<>();{{
            temp4.put("CSE", -100);
            temp4.put("MTH",-90);
            temp4.put("MGT",-10);
        }}
        assertTrue(ProblemSet.bestKey(temp4).equals("MGT"));


    }


}