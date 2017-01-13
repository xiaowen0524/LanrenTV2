package lanren.com.lanrentv2.bean;

import java.util.List;

/**
 * 1.version:
 * 2.date:2017/1/5 20:29
 * 3.update:2017/1/5.
 * 4.autour:张玉杰
 */

public class Column {
    private List<Data> data;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public Column(List<Data> data) {
        this.data = data;
    }

    public Column() {
        super();
    }

    @Override
    public String toString() {
        return "Column{" +
                "data=" + data +
                '}';
    }

    public class Data {
        private int id;
        private String description;
        private String thumbnail;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Data(int id, String description, String thumbnail, String name) {
            this.id = id;
            this.description = description;
            this.thumbnail = thumbnail;
            this.name = name;
        }

        public Data() {
            super();
        }

        @Override
        public String toString() {
            return "Data{" +
                    "id=" + id +
                    ", description='" + description + '\'' +
                    ", thumbnail='" + thumbnail + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
