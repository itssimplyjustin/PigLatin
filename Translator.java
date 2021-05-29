//Translator class
public class Translator {

	//Method that determines and extrapolates the position of the first and only the first vowel
	public static int firstVowelPos(String word) {
		int vpos = -1;
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' 
					|| word.charAt(i) == 'u' || word.charAt(i) == 'A' || word.charAt(i) == 'E' || word.charAt(i) == 'I' 
					|| word.charAt(i) == 'O' 
					|| word.charAt(i) == 'U') {
				vpos = i+1;
				break;
			}	
		}
		if(vpos == -1) {
			for(int i = 0; i < word.length(); i++) {
				if(word.charAt(i) == 'y' || word.charAt(i) == 'Y') {
					vpos = i+1;
					break;
				}
			}
		}
		if(vpos == -1) {
			vpos = 0;
		}
		return vpos;
	}
	//Method that uses data from the previous method and adds "ay" to the word
	//if needed as such.
	public static String Piggy (String word) {
		int[] caps = new int[word.length()];
		for(int i = 0; i < word.length(); i++) {
			if(Character.isUpperCase(word.charAt(i))) {
				caps[i] = 1;
			}
			else{
				caps[i] = 0;
			}
		}
		String piglat = "";
		if(firstVowelPos(word) == 0) {
			piglat += word + "-ay";
		}
		else if(firstVowelPos(word) == 1) {
			piglat = word;
		}
		else {
			int idx = 0;
			char replace;
			for(int i = firstVowelPos(word)-1; i < word.length(); i++) {
				if(caps[idx] == 1) {
					replace = Character.toUpperCase(word.charAt(i));
					piglat += replace;
					/*if(idx == word.length()-1) {
						piglat += "-";
					}*/
					idx++;
				}
				else if (caps[idx] == 0){
				replace = Character.toLowerCase(word.charAt(i));
				piglat += replace;
				/*if(idx == word.length()-1) {
					piglat += "-";
				}*/
				idx++;
				}
			}
			for(int i = 0; i < firstVowelPos(word)-1 ; i++) {
				if(caps[idx] == 1) {
					if(i == 0) {
					piglat+= "-";
					}
					replace = Character.toUpperCase(word.charAt(i));
					piglat += replace;
					idx++;
					/*if(idx == word.length()-1) {
						piglat += "-";
					}*/
				}
				else if (caps[idx] == 0){
					if(i == 0) {
						piglat+= "-";
						}
				replace = Character.toLowerCase(word.charAt(i));
				piglat += replace;
				idx++;
				/*if(idx == word.length()-1) {
					piglat += "-";
				}*/
				}
			}
			piglat += "ay";
		}
		return piglat;
	}
	//This method seeks to translate a whole setance into pig latin by determining which words to translate to begin with.
	public static String FullPiggy(String sentence) {
		String piggy = "";
		String fullpig = "";
	
		int j = 0;
		//for(int i = 0; i <= numWords; i++) {
		while(j < sentence.length()) {
			while((j < sentence.length()) && (sentence.charAt(j) != ' ')) {
				//System.out.println(j);
				piggy += sentence.charAt(j);
				if(j < sentence.length()) {
				j++;
				}
				//System.out.println(piggy);
			}
			if(piggy == "") {
				fullpig += " ";
				j++;
			}
			else {fullpig += Piggy(piggy) + " ";
			if(j < sentence.length()) {
				j++;
				}
			}
			//System.out.println(j);
			piggy = "";
			//System.out.println(fullpig);
		}
		return fullpig;
	}
}

