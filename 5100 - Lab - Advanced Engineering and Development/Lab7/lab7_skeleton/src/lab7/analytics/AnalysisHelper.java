/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import lab7.entities.Comment;
import lab7.entities.Post;
import lab7.entities.User;

/**
 *
 * @author harshalneelkamal
 */
public class AnalysisHelper {

    // find user with Most Likes
    public void userWithMostLikes() {
        Map<Integer, Integer> userLikesCount = new HashMap<>();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        for (User user : users.values()) {
            for (Comment c : user.getComments()) {
                int likes = 0;
                if (userLikesCount.containsKey(user.getId())) {
                    likes = userLikesCount.get(user.getId());
                }
                likes += c.getLikes();
                userLikesCount.put(user.getId(), likes);
            }
        }
        int max = 0;
        int maxId = 0;
        for (int id : userLikesCount.keySet()) {
            if (userLikesCount.get(id) > max) {
                max = userLikesCount.get(id);
                maxId = id;
            }
        }

        System.out.println("User with most likes:" + max + "\n" + users.get(maxId));
        System.out.println("__________________________________________________________________________________________");
    }

    // find 5 comments which have the most likes
    public void getFiveMostLikedComments() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        List<Comment> commentList = new ArrayList<>(comments.values());
        Collections.sort(commentList, new Comparator<Comment>() {
            @Override
            public int compare(Comment c1, Comment c2) {
                return c2.getLikes() - c1.getLikes();
            }
        });

        System.out.println("5 most liked comments:");
        for (int i = 0; i < commentList.size() && i < 5; i++) {
            System.out.println(commentList.get(i));
        }
        System.out.println("__________________________________________________________________________________________");
    }

    // avg num of likes per comment
    public void getAvgNumOfLikesPerComment() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        List<Comment> commentList = new ArrayList<>(comments.values());
        float sumOfAllLikes = 0;
        for (Comment c : commentList) {
            sumOfAllLikes += c.getLikes();
        }
        float avgLikes = sumOfAllLikes / commentList.size();

        System.out.println("Avg num of likes per comment:" + String.valueOf(avgLikes));
        System.out.println("__________________________________________________________________________________________");
    }

    // post with most liked comments
    public void postWithMostLikes() {
        Map<Integer, Integer> postLikesCount = new HashMap<>();
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        for (Post post : posts.values()) {
            for (Comment c : post.getComments()) {
                int likes = 0;
                if (postLikesCount.containsKey(post.getPostId())) {
                    likes = postLikesCount.get(post.getPostId());
                }
                likes += c.getLikes();
                postLikesCount.put(post.getPostId(), likes);
            }
        }
        int max = 0;
        int maxId = 0;
        for (int id : postLikesCount.keySet()) {
            if (postLikesCount.get(id) > max) {
                max = postLikesCount.get(id);
                maxId = id;
            }
        }

        System.out.println("Post with most likes:" + max + "Post ID: " + maxId);
        System.out.println("__________________________________________________________________________________________");
    }

    public void getPostWithMostComments() {
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        int maxComments = 0;
        int postid = 0;
        for (Post post : posts.values()) {
            if (post.getComments().size() > maxComments) {
                maxComments = post.getComments().size();
                postid = post.getPostId();
            }

        }
        System.out.println("Post with most comments postID: " + postid + " Number of comments: " + maxComments);
        System.out.println("__________________________________________________________________________________________");
    }

    // find inactive users based on posts
    public void inactiveUsersBasedOnPosts() {
        Map<Integer, Integer> userPostsCount = new HashMap<>();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();

        for (User user : users.values()) {
            int postNumber = 0;
            ArrayList<Integer> postListForUser = new ArrayList<>();
            for (Comment c : comments.values()) {
                if (c.getPostingUserId() == user.getId()) {
                    if (!(postListForUser.contains(c.getPostId()))) {
                        postNumber++;
                        postListForUser.add(c.getPostId());
                    }
                }
            }
            userPostsCount.put(user.getId(), postNumber);
        }

        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(userPostsCount.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> c1, Map.Entry<Integer, Integer> c2) {
                return (c1.getValue()).compareTo(c2.getValue());
            }
        });

        System.out.println("5 most inactive user ID and their number of posts are as follows:");
        for (int i = 0; i < list.size() && i < 5; i++) {
            System.out.println(list.get(i).getKey());
        }
        System.out.println("__________________________________________________________________________________________");
    }

    //top 5 inactive users overall
    public void getInactiveUserOverall() {
        Map<Integer, Integer> userOverallCount = new HashMap<>();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();

        for (User user : users.values()) {
            int postNumber = 0;
            int commentNumber = 0;
            int likeNumber = 0;
            int sum = 0;
            ArrayList<Integer> postListForUser = new ArrayList<>();
            for (Comment c : comments.values()) {
                if (c.getPostingUserId() == user.getId()) {
                    if (!(postListForUser.contains(c.getPostId()))) {
                        postNumber++;
                        postListForUser.add(c.getPostId());
                    }
                }
                if (c.getUserId() == user.getId()) {
                    commentNumber++;
                    likeNumber += c.getLikes();
                }
            }
            sum = postNumber + commentNumber + likeNumber;
            userOverallCount.put(user.getId(), sum);
        }
        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(userOverallCount.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> c1, Map.Entry<Integer, Integer> c2) {
                return (c1.getValue()).compareTo(c2.getValue());
            }
        });

        System.out.println("5 most inactive user ID and their overall number are as follows:");
        for (int i = 0; i < list.size() && i < 5; i++) {
            System.out.println(list.get(i).getKey());
        }
        System.out.println("__________________________________________________________________________________________");

    }

    //top 5 proactive users overall
    public void getProactiveUserOverall() {
        Map<Integer, Integer> userOverallCount = new HashMap<>();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();

        for (User user : users.values()) {
            int postNumber = 0;
            int commentNumber = 0;
            int likeNumber = 0;
            int sum = 0;
            ArrayList<Integer> postListForUser = new ArrayList<>();
            for (Comment c : comments.values()) {
                if (c.getPostingUserId() == user.getId()) {
                    if (!(postListForUser.contains(c.getPostId()))) {
                        postNumber++;
                        postListForUser.add(c.getPostId());
                    }
                }
                if (c.getUserId() == user.getId()) {
                    commentNumber++;
                    likeNumber += c.getLikes();
                }
            }
            sum = postNumber + commentNumber + likeNumber;
            userOverallCount.put(user.getId(), sum);
        }
        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(userOverallCount.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> c1, Map.Entry<Integer, Integer> c2) {
                return (c2.getValue()).compareTo(c1.getValue());
            }
        });

        System.out.println("5 most proactive user ID and their overall number are as follows:");
        for (int i = 0; i < list.size() && i < 5; i++) {
            System.out.println(list.get(i).getKey());
        }
        System.out.println("__________________________________________________________________________________________");

    }
// find inactive users based on comments

    public void getInactiveUserComments() {
        Map<Integer, Integer> userCommentCount = new HashMap<>();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();

        for (User user : users.values()) {
            int commentNumber = 0;
            for (Comment c : comments.values()) {
                if (c.getUserId() == user.getId()) {
                    commentNumber++;
                }
            }
            userCommentCount.put(user.getId(), commentNumber);
        }
        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(userCommentCount.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> c1, Map.Entry<Integer, Integer> c2) {
                return (c1.getValue()).compareTo(c2.getValue());
            }
        });

        System.out.println("5 most inactive user ID and their comment number are as follows:");
        for (int i = 0; i < list.size() && i < 5; i++) {
            System.out.println(list.get(i).getKey());
        }
        System.out.println("__________________________________________________________________________________________");
    }
}
