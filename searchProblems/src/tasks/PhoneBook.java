package tasks;

import helper.GTuple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
	
	public String[] findNames(List<GTuple<Integer,String>> books, Integer[] numbers){
		String[] names = new String[numbers.length];
		Map<Integer,String> tempo = new HashMap<>();
		for(GTuple<Integer,String> record : books){
			tempo.put(record.first, record.second);
		}
		
		for(int i = 0; i < numbers.length; i++){
			
			String name = tempo.get(numbers[i]);
			if(null != name){
				names[i] = name;				
			}else{
				names[i] = "NOT IN MY BOOK BRO";
				continue;
			}
		}
		return names;
	}
	public static void main(String[] args) {
		List<GTuple<Integer, String>> phonebook = new ArrayList<GTuple<Integer,String>>();
		phonebook.add(new GTuple<Integer, String>(35911, "Jorkata1"));
		phonebook.add(new GTuple<Integer, String>(35922, "Jorkata2"));
		phonebook.add(new GTuple<Integer, String>(35933, "Jorkata3"));
		phonebook.add(new GTuple<Integer, String>(35944, "Jorkata4"));
		phonebook.add(new GTuple<Integer, String>(35955, "Jorkata5"));
		
		Integer[] telephones = new Integer[6];
		for (int i = 0; i < telephones.length; i++) {
			telephones[i] = 35900 + (i+1)*11;
		}
		
		telephones[telephones.length-1] = 123;
		System.out.println(Arrays.toString(telephones));
		
		System.out.println(Arrays.toString(new PhoneBook().findNames(phonebook, telephones)));
	}
}
