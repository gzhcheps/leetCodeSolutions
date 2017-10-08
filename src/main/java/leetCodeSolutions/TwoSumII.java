package leetCodeSolutions;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
	@Test
	public void main() {
		String test = "abdbdbbdbaejieojfioiaijdfhue";
		System.out.println(canConstruct("dbac",test));

	}

	public boolean canConstruct(String ransomNote, String magazine) {
		char[] rasomNoteChar = ransomNote.toCharArray();
		char[] magazineChar = magazine.toCharArray();

		Map<Character,Integer> rasomMap = new HashMap<Character,Integer>();
		for (char r : magazineChar){
			if (rasomMap.get(r) == null){
				rasomMap.put(r,1);
			}else {
				rasomMap.put(r,rasomMap.get(r) +1);
			}
		}

		boolean canConstruct = true;

		for (char r : rasomNoteChar){
			if (rasomMap.get(r) == null){
				canConstruct = false;
				break;
			}else {
				if (rasomMap.get(r) == 0){
					canConstruct = false;
					break;
				}else {
					rasomMap.put(r,rasomMap.get(r) -1);
				}
			}
		}

		return canConstruct;
	}
}
