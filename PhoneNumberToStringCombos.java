package LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneNumberToStringCombos {
	public static void main(String[] args) {
		System.out.println(letterCombinations(""));
	}
	public static List<String> letterCombinations(String digits) {
		HashMap<Character,List<Character>> digitToLettersMap =new HashMap<>();
		int character = 'a';
		for(int i=2;i<10;i++) {
			List<Character> charList = new ArrayList<>();
			if(i==7||i==9)
				charList.add((char)character++);
			for(int j=0;j<3;j++) {
				charList.add((char)character++);

			}
			digitToLettersMap.put((char)(i+48),charList);
		}
		List<String>finals = createStringsfromMaps(digits,digitToLettersMap,new HashMap<String,List<String>>());
		return finals;
	}
	private static List<String> createStringsfromMaps(String digits,
			HashMap<Character, List<Character>> digitToLettersMap, HashMap<String, List<String>> previousEntries) {
		if(digits==null) {
			List<String> newList = new ArrayList<>();
			newList.add("");
			return newList;
		}else if(digits.equals("")) {
			List<String> newList = new ArrayList<>();
			return newList;
		}
		else if(previousEntries.containsKey(digits)) {
			return previousEntries.get(digits);
		}
		List<String>returned = new ArrayList<>();
		List<String>previous= createStringsfromMaps(digits.length()>1?digits.substring(0,digits.length()-1):null,digitToLettersMap,previousEntries);
		List<Character> newOnes = digitToLettersMap.get(digits.charAt(digits.length()-1));
		if(newOnes==null) {
			previousEntries.put(digits, previous);
		}else {
			for(String s: previous) {
				for(Character ch:newOnes) {
					returned.add(s+ch.toString());
				}
			}
			previousEntries.put(digits, returned);		

		}
		return previousEntries.get(digits);
	}
}
