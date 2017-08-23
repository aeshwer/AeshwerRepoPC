import java.util.HashMap;

/*
 * Two strings are called anagrams if they contain same set of characters but in different order
 */
public class AnagramProgram {
	
	private static void isAnagram(String s1, String s2) {
		
		//Removing white spaces from s1 and s2 and converting case to lower
        String copyOfs1 = s1.replaceAll("\\s", "").toLowerCase();
        String copyOfs2 = s2.replaceAll("\\s", "").toLowerCase();
        //Initially setting status as true
        boolean status = true;
        if(copyOfs1.length() != copyOfs2.length())
        {	
        	//Setting status as false if copyOfs1 and copyOfs2 doesn't have same length
            status = false;
        }
        else
        {
            //Constructing a map containing character as a key and character occurrences as a value
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            for (int i = 0; i < copyOfs1.length(); i++)
            {
                //Getting char from copyOfs1
                char charAsKey = copyOfs1.charAt(i);
                //Initializing char count to 0
                int charCountAsValue = 0;
                //Checking whether map contains this char
                if(map.containsKey(charAsKey))
                {
                    //If contains, retrieving it's count
                    charCountAsValue = map.get(charAsKey);
                }
 
                //Putting char and it's count to map with pre-incrementing char count
                map.put(charAsKey, ++charCountAsValue);
                //Getting char from copyOfs2
                charAsKey = copyOfs2.charAt(i);
                //Initializing char count to 0
                charCountAsValue = 0;
                //Checking whether map contains this char
                if(map.containsKey(charAsKey))
                {
                    //If contains, retrieving it's count
                    charCountAsValue = map.get(charAsKey);
                }
                //Putting char and it's count to map with pre-decrementing char count
                map.put(charAsKey, --charCountAsValue);
            }
 
            //Checking each character and it's count
            for (int value : map.values())
            {
                if(value != 0)
                {
                    //If character count is not equal to 0, then setting status as false
                    status = false;
                }
            }
        }
 
        //Output
        if(status)
        {
            System.out.println(s1+" and "+s2+" are anagrams");
        }
        else
        {
            System.out.println(s1+" and "+s2+" are not anagrams");
        }
	}
	
	public static void main(String[] args) {
		isAnagram("Mother In Law", "Hitler Woman");
        isAnagram("keEp", "peeK");
        isAnagram("SiLeNt CAT", "LisTen AcT");
        isAnagram("Debit Card", "Bad Credit");
        isAnagram("School MASTER", "The ClassROOM");
        isAnagram("DORMITORY", "Dirty Room");
        isAnagram("ASTRONOMERS", "NO MORE STARS");
        isAnagram("Toss", "Shot");
        isAnagram("joy", "enjoy");
    }
	
}
