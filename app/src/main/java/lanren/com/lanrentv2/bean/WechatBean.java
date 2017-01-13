package lanren.com.lanrentv2.bean;

import java.util.List;

/**
 * 1.version:
 * 2.date:2017/1/12 14:50
 * 3.update:2017/1/12.
 * 4.autour:张玉杰
 */

public class WechatBean {
    private List<Newslist> newslist;

    public List<Newslist> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<Newslist> newslist) {
        this.newslist = newslist;
    }

    public WechatBean(List<Newslist> newslist) {
        this.newslist = newslist;
    }

    public WechatBean() {
        super();
    }

    @Override
    public String toString() {
        return "WechatBean{" +
                "newslist=" + newslist +
                '}';
    }

    public class Newslist {
        private String ctime;
        private String description;
        private String picUrl;
        private String title;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Newslist(String ctime, String description, String picUrl, String title, String url) {
            this.ctime = ctime;
            this.description = description;
            this.picUrl = picUrl;
            this.title = title;
            this.url = url;
        }

        public Newslist() {
            super();
        }

        @Override
        public String toString() {
            return "Newslist{" +
                    "ctime='" + ctime + '\'' +
                    ", description='" + description + '\'' +
                    ", picUrl='" + picUrl + '\'' +
                    ", title='" + title + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }
}
