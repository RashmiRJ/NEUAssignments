/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

import java.io.IOException;
import java.util.Map;
import lab7.analytics.AnalysisHelper;
import lab7.analytics.DataStore;
import lab7.entities.Comment;
import lab7.entities.Post;
import lab7.entities.User;

/**
 *
 * @author harshalneelkamal
 */
public class Lab7 {

    DataReader commentReader;
    DataReader userReader;
    AnalysisHelper helper;

    public Lab7() throws IOException {
        DataGenerator generator = DataGenerator.getInstance();
        commentReader = new DataReader(generator.getCommentFilePath());
        userReader = new DataReader(generator.getUserCataloguePath());
        helper = new AnalysisHelper();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Lab7 inst = new Lab7();
        inst.readData();
    }

    private void readData() throws IOException {
        String[] row;
        while ((row = userReader.getNextRow()) != null) {
            generateUser(row);
        }
        while ((row = commentReader.getNextRow()) != null) {
            Comment comment = generateComment(row);
            generatePost(row, comment);
        }
        runAnalysis();
    }

    private void generateUser(String[] row) {
        int userID = Integer.parseInt(row[0]);
        User user = new User(userID, row[1], row[2]);
        DataStore.getInstance().getUsers().put(userID, user);
    }

    private Comment generateComment(String[] row) {
        int commentID = Integer.parseInt(row[0]);
        int commentingUserId = Integer.parseInt(row[4]);
        int postingUserId = Integer.parseInt(row[2]);
        int likes = Integer.parseInt(row[3]);
        int postId = Integer.parseInt(row[1]);
        String comment = row[5];

        Comment c = new Comment(commentID, commentingUserId, postId, comment, likes, postingUserId);
        DataStore.getInstance().getComments().put(commentID, c);

        Map<Integer, User> users = DataStore.getInstance().getUsers();
        if (users.containsKey(commentingUserId)) {
            users.get(commentingUserId).getComments().add(c);
        }

        return c;
    }

    private void generatePost(String[] row, Comment comment) {
        int postID = Integer.parseInt(row[1]);
        int userID = Integer.parseInt(row[2]);

        Map<Integer, Post> posts = DataStore.getInstance().getPosts();

        if (posts.containsKey(postID)) {
            posts.get(postID).getComments().add(comment);
        } else {
            Post post = new Post(postID, userID);
            post.getComments().add(comment);
            posts.put(postID, post);
        }
    }

    private void runAnalysis() {
        helper.getFiveMostLikedComments();
        helper.userWithMostLikes();
        helper.getAvgNumOfLikesPerComment();
        helper.postWithMostLikes();
        helper.getPostWithMostComments();
        helper.inactiveUsersBasedOnPosts();
        helper.getInactiveUserOverall();
        helper.getProactiveUserOverall();
        helper.getInactiveUserComments();
    }
}
