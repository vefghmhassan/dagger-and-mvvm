package com.vefgh.projecttest.Models;

import java.util.List;

public class News {

    private List<NewPostBean> newPost;

    public List<NewPostBean> getNewPost() {
        return newPost;
    }

    public void setNewPost(List<NewPostBean> newPost) {
        this.newPost = newPost;
    }

    public static class NewPostBean {
        /**
         * id : 4
         * title : test 4
         * image : 2.jpg
         * writerName : amin rezai
         */

        private int id;
        private String title;
        private String image;
        private String writerName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getWriterName() {
            return writerName;
        }

        public void setWriterName(String writerName) {
            this.writerName = writerName;
        }
    }
}
