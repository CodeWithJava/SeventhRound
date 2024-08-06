// Solution One
public class Solution
{
	public boolean detectCapitalUse(String word)
	{
		if(word == null || word.length() == 0)
			return false;

		boolean result = true;
		int upper = 0;

		for(int i = 0;i < word.length();i++)
		{
			char x = word.charAt(i);

			if(Character.isLetter(x))
			{
				if(Character.isUpperCase(x) && i == 0)
				{
				    	upper++;
					continue;
				}

				if(Character.isUpperCase(x) && upper == i)
				{
					result = true;
					upper++;
				}
				else if(Character.isUpperCase(x))
				{
					result = false;
					break;
				}
				else if(Character.isLowerCase(x) && upper == i && i > 1)
				{
				    result = false;
				    break;
				}
			}
		}

		return result;
	}
}

// Solution Two
public class Solution
{
	public boolean detectCapitalUse(String word)
	{
		if(word == null || word.length() < 2)
			return true;

		if(word.toUpperCase().equals(word))
			return true;

		if(word.substring(1).toLowerCase().equals(word.substring(1)))
			return true;

		return false;
	}
}

// Solution Three
public class Solution
{
	public boolean detectCapitalUse(String word)
	{
		return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
	}
}

// Solution Four
class Solution {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() < 2) {
            return true;
        }

        int caps = 0;

        for (char c: word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                caps++;
            }
        }

        return caps == 0 || caps == word.length() || caps == 1 && Character.isUpperCase(word.charAt(0));
    }
}
