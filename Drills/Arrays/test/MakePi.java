/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian Choi
 */
class MakePi {

    public int[] MakePi(int n) {
        String piString = String.valueOf(Math.PI);
        piString = piString.replace(".", "");
        int[] piArray = new int[n];
        for (int index = 0; index < n; index++) {
            piArray[index] = Integer.parseInt(String.valueOf(piString.charAt(index)));
        }
        return piArray;
    }
    
}
