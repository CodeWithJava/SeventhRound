public class Solution extends Reader4
{
	char [] buffer = new char [4];
	int remaining = 0;
	int offset = 0;

	/**
	* @param buf Destination buffer
	* @param n   Maximum number of characters to read
	* @return    The number of characters read
	*/

	public int read(char [] buf, int n)
	{
		int readBytes = 0;
		boolean eof = false;

		while(!eof && readBytes < n)
		{
			int x = remaining > 0 ? remaining:read4(buffer);
			if(x < 4 && remaining == 0) eof = true;
			int bytes = Math.min(x, n - readBytes);
			System.arraycopy(buffer, offset, buf, readBytes, bytes);
			remaining = x - bytes;
			offset = (offset + bytes) % 4;

			readBytes += bytes;
		}

		return readBytes;
	}
}