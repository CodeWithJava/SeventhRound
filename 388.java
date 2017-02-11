public class Solution
{
	public int lengthLongestPath(String input)
	{
		if(input == null || input.length() == 0)	
			return 0;

		input = input.trim();

		String [] files = input.split("\n");

		Stack<File> paths = new Stack<>();

		int currLength = 0;
		int result = 0;

		for(String file: files)
		{
			File x = new File(file);

			while(!paths.isEmpty() && x.tabLength <= paths.peek().tabLength)
				currLength -= paths.pop().fileName.length() + 1;

			if(x.isFile)
				result = Math.max(result, currLength + x.fileName.length());
			else
			{
				paths.push(x);
				currLength += x.fileName.length() + 1;
			}
		}

		return result;
	}
}
class File
{
	int tabLength;
	String fileName;
	boolean isFile;

	File(String file)
	{
		tabLength = file.lastIndexOf("\t") + 1;
		fileName = file.substring(tabLength);
		isFile = false;

		if(file.indexOf(".") != -1)
			isFile = true;
	}
}