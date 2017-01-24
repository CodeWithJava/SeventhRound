public class Solution extends Reader4
{
	/**
	* @param buf Destination buffer
	* @param n   Maximum number of characters to read
	* @return    The number of characters read
	*/

	public int read(char [] buf, int n)
	{
		char [] buffer = new char [4];
		int readBytes = 0;
		boolean eof = false;

		while(!eof && readBytes < n)
		{
			int x = read4(buffer);
			if(x < 4) eof = true;
			int bytes = Math.min(x, n - readBytes);
			System.arraycopy(buffer, 0, buf, readBytes, bytes);

			readBytes += bytes;
		}

		return readBytes;
	}
}