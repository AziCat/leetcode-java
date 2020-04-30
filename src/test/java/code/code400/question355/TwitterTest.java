package code.code400.question355;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TwitterTest {
    @Test
    public void test() throws Exception {
        Twitter twitter = new Twitter();

        twitter.postTweet(1, 5);

        List<Integer> list = twitter.getNewsFeed(1);
        System.out.println(list.toString());
        twitter.follow(1, 2);

        twitter.postTweet(2, 6);

        list = twitter.getNewsFeed(1);
        System.out.println(list.toString());
        twitter.unfollow(1, 2);

        list = twitter.getNewsFeed(1);
        System.out.println(list.toString());
    }

    @Test
    public void test1() throws Exception {
        Twitter twitter = new Twitter();

        twitter.postTweet(1, 1);

        List<Integer> list = twitter.getNewsFeed(1);
        System.out.println(list.toString());
        twitter.follow(2, 1);


        list = twitter.getNewsFeed(2);
        System.out.println(list.toString());
        twitter.unfollow(2, 1);

        list = twitter.getNewsFeed(2);
        System.out.println(list.toString());
    }

    @Test
    public void test2() throws Exception {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 4);
        twitter.postTweet(2, 5);



        twitter.unfollow(1, 2);
        twitter.getNewsFeed(1);
    }
}