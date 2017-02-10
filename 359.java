public class Logger
{
	Map<String, Integer> map;

	/** Initialize your data structure here. */
	Logger()
	{
		map = new HashMap<>();
	}

	/** Returns true if the message should be printed in the given timestamp, otherwise returns false.
		If this method returns false, the message will not be printed.
		The timestamp is in seconds granularity. */
	public boolean shouldPrintMessage(int timestamp, String message)
	{
		if(!map.containsKey(message))
		{
			map.put(message, timestamp);
			return true;
		}
		else
		{
			int t = map.get(message);

			if(timestamp - t < 10)
				return false;

			map.put(message, timestamp);

			return true;
		}
	}
}