package com.example.playandroid.model.bean;

import java.util.List;

public class PointDetailBean {

    /**
     * data : {"curPage":1,"datas":[{"coinCount":39,"date":1613493926000,"desc":"2021-02-17 00:45:26 签到 , 积分：10 + 29","id":375057,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":38,"date":1613462509000,"desc":"2021-02-16 16:01:49 签到 , 积分：10 + 28","id":374970,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":37,"date":1613323308000,"desc":"2021-02-15 01:21:48 签到 , 积分：10 + 27","id":374676,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":36,"date":1613293040000,"desc":"2021-02-14 16:57:20 签到 , 积分：10 + 26","id":374601,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":35,"date":1613146496000,"desc":"2021-02-13 00:14:56 签到 , 积分：10 + 25","id":374311,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":11,"date":1613121202000,"desc":"2021-02-12 17:13:22 分享文章 , 积分：10 + 1","id":374237,"reason":"分享文章","type":3,"userId":83159,"userName":"larkunt"},{"coinCount":34,"date":1613060464000,"desc":"2021-02-12 00:21:04 签到 , 积分：10 + 24","id":374124,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":33,"date":1612973992000,"desc":"2021-02-11 00:19:52 签到 , 积分：10 + 23","id":373969,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":10,"date":1612948691000,"desc":"2021-02-10 17:18:11 分享文章 , 积分：10 + 0","id":373869,"reason":"分享文章","type":3,"userId":83159,"userName":"larkunt"},{"coinCount":32,"date":1612921232000,"desc":"2021-02-10 09:40:32 签到 , 积分：10 + 22","id":373675,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":31,"date":1612836554000,"desc":"2021-02-09 10:09:14 签到 , 积分：10 + 21","id":372996,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":30,"date":1612762527000,"desc":"2021-02-08 13:35:27 签到 , 积分：10 + 20","id":372703,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":29,"date":1612632110000,"desc":"2021-02-07 01:21:50 签到 , 积分：10 + 19","id":372021,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":28,"date":1612621103000,"desc":"2021-02-06 22:18:23 签到 , 积分：10 + 18","id":371977,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":27,"date":1612461175000,"desc":"2021-02-05 01:52:55 签到 , 积分：10 + 17","id":371142,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":26,"date":1612374345000,"desc":"2021-02-04 01:45:45 签到 , 积分：10 + 16","id":370542,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":25,"date":1612283438000,"desc":"2021-02-03 00:30:38 签到 , 积分：10 + 15","id":369901,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":24,"date":1612207802000,"desc":"2021-02-02 03:30:02 签到 , 积分：10 + 14","id":369295,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":23,"date":1612150103000,"desc":"2021-02-01 11:28:23 签到 , 积分：10 + 13","id":368947,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":22,"date":1611796862000,"desc":"2021-01-28 09:21:02 签到 , 积分：10 + 12","id":366925,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"}],"offset":0,"over":false,"pageCount":2,"size":20,"total":32}
     * errorCode : 0
     * errorMsg :
     */

    private DataDTO data;
    private Integer errorCode;
    private String errorMsg;

    @Override
    public String toString() {
        return "PointDetailBean{" +
                "data=" + data +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataDTO {
        /**
         * curPage : 1
         * datas : [{"coinCount":39,"date":1613493926000,"desc":"2021-02-17 00:45:26 签到 , 积分：10 + 29","id":375057,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":38,"date":1613462509000,"desc":"2021-02-16 16:01:49 签到 , 积分：10 + 28","id":374970,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":37,"date":1613323308000,"desc":"2021-02-15 01:21:48 签到 , 积分：10 + 27","id":374676,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":36,"date":1613293040000,"desc":"2021-02-14 16:57:20 签到 , 积分：10 + 26","id":374601,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":35,"date":1613146496000,"desc":"2021-02-13 00:14:56 签到 , 积分：10 + 25","id":374311,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":11,"date":1613121202000,"desc":"2021-02-12 17:13:22 分享文章 , 积分：10 + 1","id":374237,"reason":"分享文章","type":3,"userId":83159,"userName":"larkunt"},{"coinCount":34,"date":1613060464000,"desc":"2021-02-12 00:21:04 签到 , 积分：10 + 24","id":374124,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":33,"date":1612973992000,"desc":"2021-02-11 00:19:52 签到 , 积分：10 + 23","id":373969,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":10,"date":1612948691000,"desc":"2021-02-10 17:18:11 分享文章 , 积分：10 + 0","id":373869,"reason":"分享文章","type":3,"userId":83159,"userName":"larkunt"},{"coinCount":32,"date":1612921232000,"desc":"2021-02-10 09:40:32 签到 , 积分：10 + 22","id":373675,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":31,"date":1612836554000,"desc":"2021-02-09 10:09:14 签到 , 积分：10 + 21","id":372996,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":30,"date":1612762527000,"desc":"2021-02-08 13:35:27 签到 , 积分：10 + 20","id":372703,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":29,"date":1612632110000,"desc":"2021-02-07 01:21:50 签到 , 积分：10 + 19","id":372021,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":28,"date":1612621103000,"desc":"2021-02-06 22:18:23 签到 , 积分：10 + 18","id":371977,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":27,"date":1612461175000,"desc":"2021-02-05 01:52:55 签到 , 积分：10 + 17","id":371142,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":26,"date":1612374345000,"desc":"2021-02-04 01:45:45 签到 , 积分：10 + 16","id":370542,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":25,"date":1612283438000,"desc":"2021-02-03 00:30:38 签到 , 积分：10 + 15","id":369901,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":24,"date":1612207802000,"desc":"2021-02-02 03:30:02 签到 , 积分：10 + 14","id":369295,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":23,"date":1612150103000,"desc":"2021-02-01 11:28:23 签到 , 积分：10 + 13","id":368947,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"},{"coinCount":22,"date":1611796862000,"desc":"2021-01-28 09:21:02 签到 , 积分：10 + 12","id":366925,"reason":"签到","type":1,"userId":83159,"userName":"larkunt"}]
         * offset : 0
         * over : false
         * pageCount : 2
         * size : 20
         * total : 32
         */

        private Integer curPage;
        private List<DatasDTO> datas;
        private Integer offset;
        private Boolean over;
        private Integer pageCount;
        private Integer size;
        private Integer total;

        public Integer getCurPage() {
            return curPage;
        }

        public void setCurPage(Integer curPage) {
            this.curPage = curPage;
        }

        public List<DatasDTO> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasDTO> datas) {
            this.datas = datas;
        }

        public Integer getOffset() {
            return offset;
        }

        public void setOffset(Integer offset) {
            this.offset = offset;
        }

        public Boolean getOver() {
            return over;
        }

        public void setOver(Boolean over) {
            this.over = over;
        }

        public Integer getPageCount() {
            return pageCount;
        }

        public void setPageCount(Integer pageCount) {
            this.pageCount = pageCount;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public static class DatasDTO {
            /**
             * coinCount : 39
             * date : 1613493926000
             * desc : 2021-02-17 00:45:26 签到 , 积分：10 + 29
             * id : 375057
             * reason : 签到
             * type : 1
             * userId : 83159
             * userName : larkunt
             */

            private Integer coinCount;
            private Long date;
            private String desc;
            private Integer id;
            private String reason;
            private Integer type;
            private Integer userId;
            private String userName;

            public Integer getCoinCount() {
                return coinCount;
            }

            public void setCoinCount(Integer coinCount) {
                this.coinCount = coinCount;
            }

            public Long getDate() {
                return date;
            }

            public void setDate(Long date) {
                this.date = date;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getReason() {
                return reason;
            }

            public void setReason(String reason) {
                this.reason = reason;
            }

            public Integer getType() {
                return type;
            }

            public void setType(Integer type) {
                this.type = type;
            }

            public Integer getUserId() {
                return userId;
            }

            public void setUserId(Integer userId) {
                this.userId = userId;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            @Override
            public String toString() {
                return "DatasDTO{" +
                        "coinCount=" + coinCount +
                        ", date=" + date +
                        ", desc='" + desc + '\'' +
                        ", id=" + id +
                        ", reason='" + reason + '\'' +
                        ", type=" + type +
                        ", userId=" + userId +
                        ", userName='" + userName + '\'' +
                        '}';
            }
        }
    }
}
