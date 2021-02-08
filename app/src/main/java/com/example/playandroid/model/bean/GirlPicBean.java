package com.example.playandroid.model.bean;

import java.util.List;

public class GirlPicBean {

    /**
     * code : 1
     * msg : 数据返回成功！
     * data : {"page":0,"totalCount":999,"totalPage":100,"limit":10,"list":[{"imageUrl":"https://tvax3.sinaimg.cn/large/005BYqpgly1g1ut4tnhtwj31c00u0dks.jpg","imageSize":"1728x1080","imageFileLength":181578},{"imageUrl":"https://tvax1.sinaimg.cn/large/005BYqpgly1g1uq1fat03j31hc0u00wc.jpg","imageSize":"1920x1080","imageFileLength":147340},{"imageUrl":"https://tvax3.sinaimg.cn/large/005BYqpgly1g1ut3xa5dkj31hc0u0acv.jpg","imageSize":"1920x1080","imageFileLength":118527},{"imageUrl":"https://tvax4.sinaimg.cn/large/005BYqpgly1g1usrlmzn8j31c00u0k6n.jpg","imageSize":"1728x1080","imageFileLength":262416},{"imageUrl":"https://tvax4.sinaimg.cn/large/005BYqpgly1g1utbdmvl8j31hc0u0jv6.jpg","imageSize":"1920x1080","imageFileLength":154776},{"imageUrl":"https://tvax2.sinaimg.cn/large/005BYqpgly1g1urangw2pj31c00u00xg.jpg","imageSize":"1728x1080","imageFileLength":116567},{"imageUrl":"https://tvax3.sinaimg.cn/large/005BYqpgly1g1urv1y0ngj31c00u0wsl.jpg","imageSize":"1728x1080","imageFileLength":182281},{"imageUrl":"https://tvax4.sinaimg.cn/large/005BYqpgly1g1utakzwq7j31c00u0q6j.jpg","imageSize":"1728x1080","imageFileLength":137622},{"imageUrl":"https://tvax2.sinaimg.cn/large/005BYqpgly1g1ursamh70j31c00u0k4b.jpg","imageSize":"1728x1080","imageFileLength":117255},{"imageUrl":"https://tvax3.sinaimg.cn/large/005BYqpggy1g1urvvt75jj31c00u017h.jpg","imageSize":"1728x1080","imageFileLength":152440}]}
     */

    private Integer code;
    private String msg;
    private DataDTO data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public static class DataDTO {
        /**
         * page : 0
         * totalCount : 999
         * totalPage : 100
         * limit : 10
         * list : [{"imageUrl":"https://tvax3.sinaimg.cn/large/005BYqpgly1g1ut4tnhtwj31c00u0dks.jpg","imageSize":"1728x1080","imageFileLength":181578},{"imageUrl":"https://tvax1.sinaimg.cn/large/005BYqpgly1g1uq1fat03j31hc0u00wc.jpg","imageSize":"1920x1080","imageFileLength":147340},{"imageUrl":"https://tvax3.sinaimg.cn/large/005BYqpgly1g1ut3xa5dkj31hc0u0acv.jpg","imageSize":"1920x1080","imageFileLength":118527},{"imageUrl":"https://tvax4.sinaimg.cn/large/005BYqpgly1g1usrlmzn8j31c00u0k6n.jpg","imageSize":"1728x1080","imageFileLength":262416},{"imageUrl":"https://tvax4.sinaimg.cn/large/005BYqpgly1g1utbdmvl8j31hc0u0jv6.jpg","imageSize":"1920x1080","imageFileLength":154776},{"imageUrl":"https://tvax2.sinaimg.cn/large/005BYqpgly1g1urangw2pj31c00u00xg.jpg","imageSize":"1728x1080","imageFileLength":116567},{"imageUrl":"https://tvax3.sinaimg.cn/large/005BYqpgly1g1urv1y0ngj31c00u0wsl.jpg","imageSize":"1728x1080","imageFileLength":182281},{"imageUrl":"https://tvax4.sinaimg.cn/large/005BYqpgly1g1utakzwq7j31c00u0q6j.jpg","imageSize":"1728x1080","imageFileLength":137622},{"imageUrl":"https://tvax2.sinaimg.cn/large/005BYqpgly1g1ursamh70j31c00u0k4b.jpg","imageSize":"1728x1080","imageFileLength":117255},{"imageUrl":"https://tvax3.sinaimg.cn/large/005BYqpggy1g1urvvt75jj31c00u017h.jpg","imageSize":"1728x1080","imageFileLength":152440}]
         */

        private Integer page;
        private Integer totalCount;
        private Integer totalPage;
        private Integer limit;
        private List<ListDTO> list;

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public Integer getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(Integer totalCount) {
            this.totalCount = totalCount;
        }

        public Integer getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(Integer totalPage) {
            this.totalPage = totalPage;
        }

        public Integer getLimit() {
            return limit;
        }

        public void setLimit(Integer limit) {
            this.limit = limit;
        }

        public List<ListDTO> getList() {
            return list;
        }

        public void setList(List<ListDTO> list) {
            this.list = list;
        }

        public static class ListDTO {
            /**
             * imageUrl : https://tvax3.sinaimg.cn/large/005BYqpgly1g1ut4tnhtwj31c00u0dks.jpg
             * imageSize : 1728x1080
             * imageFileLength : 181578
             */

            private String imageUrl;
            private String imageSize;
            private Integer imageFileLength;

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getImageSize() {
                return imageSize;
            }

            public void setImageSize(String imageSize) {
                this.imageSize = imageSize;
            }

            public Integer getImageFileLength() {
                return imageFileLength;
            }

            public void setImageFileLength(Integer imageFileLength) {
                this.imageFileLength = imageFileLength;
            }
        }
    }
}
