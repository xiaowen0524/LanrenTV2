package lanren.com.lanrentv2.bean;

import java.util.List;

/**
 * 1.version:
 * 2.date:2017/1/13 20:27
 * 3.update:2017/1/13.
 * 4.autour:张玉杰
 */

public class DailyBean {
    private List<Stories> stories;
    private List<Top_stories> top_stories;

    public List<Stories> getStories() {
        return stories;
    }

    public void setStories(List<Stories> stories) {
        this.stories = stories;
    }

    public List<Top_stories> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<Top_stories> top_stories) {
        this.top_stories = top_stories;
    }

    public DailyBean(List<Stories> stories, List<Top_stories> top_stories) {
        this.stories = stories;
        this.top_stories = top_stories;
    }

    public DailyBean() {
        super();
    }

    @Override
    public String toString() {
        return "DailyBean{" +
                "stories=" + stories +
                ", top_stories=" + top_stories +
                '}';
    }

    public class Stories {
        private int id;
        private int ga_prefix;
        private String title;
        private List<String> images;


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(int ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public Stories(int id, int ga_prefix, String title, List<String> images) {
            this.id = id;
            this.ga_prefix = ga_prefix;
            this.title = title;
            this.images = images;
        }

        public Stories() {
            super();
        }

        @Override
        public String toString() {
            return "Stories{" +
                    "id=" + id +
                    ", ga_prefix=" + ga_prefix +
                    ", title='" + title + '\'' +
                    ", images=" + images +
                    '}';
        }
    }

    public class Top_stories {
        private int id;
        private int ga_prefix;
        private String image;
        private String title;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(int ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Top_stories(int id, int ga_prefix, String image, String title) {
            this.id = id;
            this.ga_prefix = ga_prefix;
            this.image = image;
            this.title = title;
        }

        public Top_stories() {
            super();
        }

        @Override
        public String toString() {
            return "Top_stories{" +
                    "id=" + id +
                    ", ga_prefix=" + ga_prefix +
                    ", image='" + image + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }
    }
}
