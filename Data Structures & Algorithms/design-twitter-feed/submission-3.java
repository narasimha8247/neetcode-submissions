class Twitter {

    private int timeStamp; // Global timestamp counter
    private Map<Integer, Set<Integer>> follow;
    private Map<Integer, List<Tweet>> tweets; // Store Tweets with their timestamps

    // Helper class to tie a tweet to its chronological timestamp
    private static class Tweet {
        int time;
        int tweetId;

        public Tweet(int time, int tweetId) {
            this.time = time;
            this.tweetId = tweetId;
        }
    }

    public Twitter() {
        timeStamp = 0;
        follow = new HashMap<>();
        tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        List<Tweet> li = tweets.computeIfAbsent(userId, k -> new ArrayList<>());
        if (li.size() == 10) {
            li.remove(0); // Keep max 10 tweets per user
        }
        // Save the tweet along with the current global timestamp, then increment time
        li.add(new Tweet(timeStamp++, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> allTweets = new ArrayList<>();
        
        // Add user's own tweets
        if (tweets.containsKey(userId)) {
            allTweets.addAll(tweets.get(userId));
        }
        
        // Add followees' tweets
        Set<Integer> following = follow.get(userId);
        if (following != null) {
            for (int followee : following) {
                if (tweets.containsKey(followee)) {
                    allTweets.addAll(tweets.get(followee));
                }
            }
        }
        
        // Sort by timestamp in descending order (most recent time first), 
        // limit to 10, and extract just the tweetId
        return allTweets.stream()
            .sorted((a, b) -> Integer.compare(b.time, a.time)) // Sort by time, not tweetId!
            .limit(10)
            .map(tweet -> tweet.tweetId)
            .collect(Collectors.toList());
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        follow.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (follow.containsKey(followerId)) {
            follow.get(followerId).remove(followeeId);
        }
    }
}
