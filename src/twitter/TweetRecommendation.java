package twitter;

/**Tweet Recommendation
        Twitter Interview Online Test
        On Twitter, millions of tweets are posted on a daily basis. Help Twitter write a simple ranking algorithm to find the best of all tweets. It works as follows: A good tweet receives many “likes” from people on Twitter, either from people you follow, or people you do now follow. A tweet is more relevant to you if people you follow also liked the tweet. If enough people you follow have liked that tweet, we recommend that tweet to you.

        Your task is to complete the function
        getRecommendedTweets(followGraph_edges, likeGraph_edges, targetUser, minLikeThreshold), which returns a list of tweet IDs in sorted order that should be recommended for a certain user. It takes 4 parameters:

        followGroup_edges stores follow relationships as an array of tuple of integers.
        For example, followGraph_edges = Array{(A, B), (A, C), (B, C)} represents 3 follow relationships:
        A follows B
        A follows C
        B follows C
        likeGraph_edges stores like relationships, also in an array of tuple of integers.
        For example, likeGraph_edges = Array{(A, T1), (B, T2), (A, T2)} means:
        A liked tweet T1
        B liked tweet T2
        A liked tweet T2
        targetUser is the user ID for which we generate recommended tweets
        minLikeThreshold is the minimum number of likes a tweet mush receive from people you follow to be recommended
        For example, if minLikeThreshold = 4, only tweets that received at least 4 likes from people you follow should be recommended
        Note: If you cannot find a single tweet that meets our requirement, simply return an empty list. You may also use any functions provided by the standard library.

 Solution:
    1. Create list of users targetUser follows
    2. Using this list create a map which maps tweet to number of times the tweet has been liked by users that targetUser follows
    3. Remove tweets with likes less than minLikeThreshold
    4. Return the remaining tweets

**/
public class TweetRecommendation {
}
