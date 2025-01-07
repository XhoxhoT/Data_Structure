package Hashtable;

import java.util.*;

public class Main {

    public static boolean itemInCommon(int[] array1, int[] array2){

        // kompleksiteti O(n2)
        for(int i : array1){
            for(int j:array2){
                if(i==j)
                    return  true;
            }
        }

        return false;
    }

    public static boolean itemInCommon1(int[] array1, int[] array2) {

        HashMap<Integer, Boolean> myHashMap = new HashMap<>();

        for (int i : array1) {
            myHashMap.put(i,true);
        }
        for(int j: array2){
            if(myHashMap.get(j) != null)
                return true;
        }
        return false;
    }

    public static List<Integer> findDuplicates(int[] nums){

        Map<Integer,Integer> numCounts = new HashMap<>();

        for(int num : nums){
            // metoda getorDefault kthen vleren per ket key ose nese ska kthen 0, pra
            // nese nje element shtohet per here  te pare e ka 0 value.
            // nese shtohet perseri me vone, atehere metoda kthen 1 dhe ne shtojme +1, ajo ruhet 2 mrp ne map.
            numCounts.put(num,numCounts.getOrDefault(num,0) +1);
        }

        List<Integer> duplicates = new ArrayList<>();
// kjo entrySet kthen nje set view te tegjitha entryve ne map
        // ne shofim nese value eshte greater se 1 ateher e shtojme key-n e tij si vlere tek lista.
        for(Map.Entry<Integer,Integer> entry : numCounts.entrySet()){

            if(entry.getValue() > 1){
                duplicates.add(entry.getKey());
            }
        }
        return duplicates;
    }

    public static Character firstNonRepeatingChar(String test){

        Map<Character,Integer> myHashTB = new HashMap<>();
        // kthen karakterin e pare jo te perseritur, nese te gjithe te perseritur ateher kthe null

        for(char c : test.toCharArray()){
            myHashTB.put(c, myHashTB.getOrDefault(c,0) +1);
        }

        for(Map.Entry<Character, Integer> entry : myHashTB.entrySet()){

            if(entry.getValue()==1){
                return entry.getKey();
            }

        }
        return null;

    }

    public static List<List<String>> groupAnagrams(String[] str){

        Map<String, List<String>> anagramGroups = new HashMap<>();

        for(String string : str){

            char[] chars = string.toCharArray();
            Arrays.sort(chars);

            String canonical = new String(chars);

            if(anagramGroups.containsKey(canonical)){
                anagramGroups.get(canonical).add(string);
            }else{
                List<String> newGroup = new ArrayList();
                newGroup.add(string);
                anagramGroups.put(canonical,newGroup);
            }

        }
        return new ArrayList<>(anagramGroups.values());
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;

            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(num, i);
        }

        return new int[]{};
    }

    public static int [] subarraySum(int[] nums, int target){

        Map<Integer, Integer> sumIndex = new HashMap<>();

        sumIndex.put(0,-1);

        int currentSum = 0;

        for(int i= 0;i< nums.length;i++){

            currentSum+=nums[i];
            if(sumIndex.containsKey(currentSum - target)){
                return new int []{sumIndex.get((currentSum-target) +1), i};
            }else{
                sumIndex.put(currentSum,i);
            }
        }

        return new int [] {};

    }


    public static List<Integer> removeDuplicates(List<Integer> myList){

        Set<Integer> mySet= new HashSet<>(myList);

        return new ArrayList<>(mySet);
    }


    public static boolean hasUniqueChars(String string){

        Set<Character> mySet = new HashSet<>();

        for(char c : string.toCharArray()){
            mySet.add(c);
        }

        if(mySet.size() == string.toCharArray().length){
            return true;
        }
        return false;
    }

    public static boolean hasUniqueCharsUdemy(String string) {
        Set<Character> charSet = new HashSet<>();

        for (char ch : string.toCharArray()) {
            if (charSet.contains(ch)) {
                return false;
            }
            charSet.add(ch);
        }

        return true;
    }

    public static int longestConsecutiveSequence(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }


    public static List<int []> findPairs(int[] arr1, int[] arr2, int target){

        Set<Integer> mySet = new HashSet<>();
        List<int []> myList = new ArrayList<>();

        // kaloj tgjitha vlerat tek seti te array 1
        for(int num : arr1){
            mySet.add(num);
        }
        // tek array 2 shof nese pjesa e ngelur nga ndryshesa e target me num, ndodhet ne set
        // nese gjendet ateher e shtoj tek lista qe do kthej.
        for(int num: arr2){
            int complement = target - num;
            if(mySet.contains(complement)){
                myList.add(new int[]{complement, num});
            }
        }
        return myList;
    }

    public static void main(String[] args){

        HashTable myHashTable = new HashTable();

        myHashTable.set("nails", 100);
        myHashTable.set("title", 50);
        myHashTable.set("lumber", 150);
        myHashTable.set("bolts", 250);
        myHashTable.set("screws", 120);

        myHashTable.printTable();

        System.out.println(myHashTable.get("lumber"));

        System.out.println(myHashTable.keys());

    }
}
