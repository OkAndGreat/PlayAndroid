package com.example.playandroid.model.bean;

/**
 * @author OkAndGreat
 */
public class PointBean {

    /**
     * data : {"coinCount":390,"level":4,"nickname":"","rank":"2700","userId":83159,"username":"l**kunt"}
     * errorCode : 0
     * errorMsg :
     */

    private DataDTO data;
    private Integer errorCode;
    private String errorMsg;

    @Override
    public String toString() {
        return "PointBean{" +
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
         * coinCount : 390
         * level : 4
         * nickname :
         * rank : 2700
         * userId : 83159
         * username : l**kunt
         */

        private Integer coinCount;
        private Integer level;
        private String nickname;
        private String rank;
        private Integer userId;
        private String username;

        public Integer getCoinCount() {
            return coinCount;
        }

        public void setCoinCount(Integer coinCount) {
            this.coinCount = coinCount;
        }

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        @Override
        public String toString() {
            return "DataDTO{" +
                    "coinCount=" + coinCount +
                    ", level=" + level +
                    ", nickname='" + nickname + '\'' +
                    ", rank='" + rank + '\'' +
                    ", userId=" + userId +
                    ", username='" + username + '\'' +
                    '}';
        }
    }
}
