package code.code400.question355;

import java.util.*;

/**
 * @author yan
 * @version 1.0
 * @date 2020/4/15
 */
public class Twitter {
    private class Tweet {
        long timestamp;
        int id;
        public Tweet next;

        Tweet(int tweetId, long timestamp) {
            this.id = tweetId;
            this.timestamp = timestamp;
        }
    }

    private long timestamp = -1;
    private final Map<Integer, Set<Integer>> followMap;
    private final Map<Integer, Tweet> tweetMap;
    private final PriorityQueue<Tweet> queue;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        this.followMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
        this.queue = new PriorityQueue<>((o1, o2) -> (int) (o2.timestamp - o1.timestamp));
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        timestamp++;
        Tweet tweet = tweetMap.get(userId);
        Tweet newTweet = new Tweet(tweetId, timestamp);
        if (null != tweet) {
            newTweet.next = tweet;
        }
        tweetMap.put(userId, newTweet);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        queue.clear();
        //自己的
        Tweet myTweet = tweetMap.get(userId);
        if (null != myTweet) {
            queue.offer(myTweet);
        }
        //关注的
        Set<Integer> followSet = followMap.get(userId);
        if (null != followSet) {
            for (Integer followeeId : followSet) {
                Tweet followeeTweet = tweetMap.get(followeeId);
                if (null != followeeTweet) {
                    queue.offer(followeeTweet);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Tweet tweet = queue.poll();
            list.add(tweet.id);
            if (list.size() == 10) {
                break;
            }
            if (null != tweet.next) {
                queue.offer(tweet.next);
            }

        }
        return list;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }
        Set<Integer> followSet = followMap.getOrDefault(followerId, new HashSet<>());
        followSet.add(followeeId);
        followMap.put(followerId, followSet);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }
        Set<Integer> followSet = followMap.get(followerId);
        if (null != followSet) {
            followSet.remove(followeeId);
        }
    }
}
