public class Twitter
{
	Map<Integer, List<Integer>> tweet;
	Map<Integer, List<Integer>> follow;
	List<Integer> tweetList;

	/** Initialize your data structure here. */
	public Twitter()
	{
		tweet = new HashMap<>();
		follow = new HashMap<>();
		tweetList = new ArrayList<>();
	}
	
	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId)
	{
		List<Integer> t = new ArrayList<>();

		if(tweet.containsKey(userId))
			t = tweet.get(userId);

		t.add(tweetId);
		tweet.put(userId, t);
		tweetList.add(tweetId);
	}
	
	/** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
	public List<Integer> getNewsFeed(int userId)
	{
		List<Integer> list = new ArrayList<>();

		if(tweet.containsKey(userId))
			list = tweet.get(userId);

		List<Integer> all = new ArrayList<>(list);
		List<Integer> followees = new ArrayList<>();

		if(follow.containsKey(userId))
			followees = follow.get(userId);

		for(int i = 0;i < followees.size();i++)
			if(tweet.containsKey(followees.get(i)))
				all.addAll(tweet.get(followees.get(i)));

		Set<Integer> set = new HashSet<>(all);
		List<Integer> feed = new ArrayList<>();

		int k = 0;

		for(int i = tweetList.size() - 1;i >= 0;i--)
		{
			if(k == 10)
				break;

			int tweetId = tweetList.get(i);

			if(set.contains(tweetId))
			{
				feed.add(tweetId);
				k++;
			}
		}

		return feed;
	}
	
	/** Follower follows a followee. If the operation is invalid, it should be a no-op. */
	public void follow(int followerId, int followeeId)
	{
		List<Integer> t = new ArrayList<>();

		if(follow.containsKey(followerId))
			t = follow.get(followerId);

		if(!t.contains(followeeId))
			t.add(followeeId);

		follow.put(followerId, t);
	}
	
	/** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
	public void unfollow(int followerId, int followeeId)
	{
		if(follow.containsKey(followerId))
			follow.get(followerId).remove((Integer)followeeId);
	}
}