/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		
		//System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "Hello";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
		
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		int[] his1 = new int[128];
		int[] his2 = new int[128];
		String processed1 = preProcess(str1);
		String processed2 = preProcess(str2);
		for(int i = 0; i < processed1.length(); i++)
		{
			his1[processed1.charAt(i)]++;
		}

		for(int i = 0 ; i<processed2.length(); i++) 
		{
			his2[processed2.charAt(i)]++;
		}
		for(int i = 0; i < 128; i++)
		{
			if(his1[i] != his2[i] && i != ' ')
			{
				return false;
			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String processed = "";
		for(int i = 0; i < str.length() ; i++)
		{
			if(str.charAt(i) <= 122 && str.charAt(i) >= 97 || str.charAt(i) == ' ')
			{
				processed += str.charAt(i);
			}	
			else if(str.charAt(i) >= 65 && str.charAt(i) <= 90)
			{
				processed += (char)(str.charAt(i) - 'A' + 'a');
			}
		}
		return processed;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String anagram = "";
		int random;
		while(str.length() > 0)
		{
			random = (int)(Math.random() * str.length());
			anagram += (char)str.charAt(random);
			str = str.substring(0,random) + str.substring(random+1, str.length());
		}
		return anagram;
	}
}
