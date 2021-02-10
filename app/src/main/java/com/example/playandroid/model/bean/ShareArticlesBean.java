package com.example.playandroid.model.bean;

import java.util.List;

public class ShareArticlesBean {

    /**
     * data : {"coinInfo":{"coinCount":493,"level":5,"nickname":"","rank":"2227","userId":83159,"username":"l**kunt"},"shareArticles":{"curPage":1,"datas":[{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"host":"","id":17247,"link":"https://blog.csdn.net/qq_39477770/article/details/109491286?utm_medium=distribute.wap_feed.none-task-blog-cf-2.nonecase&amp;depth_1-utm_source=distribute.wap_feed.none-task-blog-cf-2.nonecase","niceDate":"1小时前","niceShareDate":"1小时前","origin":"","prefix":"","projectLink":"","publishTime":1612948691000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1612948691000,"shareUser":"larkunt","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"只因拎不清 插件化 和 热修复 的实现原理，我痛失了阿里的offer_清风Coolbreeze的博客-CSDN博客","type":0,"userId":83159,"visible":0,"zan":0}],"offset":0,"over":true,"pageCount":1,"size":20,"total":1}}
     * errorCode : 0
     * errorMsg :
     */

    private DataDTO data;
    private Integer errorCode;
    private String errorMsg;

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
         * coinInfo : {"coinCount":493,"level":5,"nickname":"","rank":"2227","userId":83159,"username":"l**kunt"}
         * shareArticles : {"curPage":1,"datas":[{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"host":"","id":17247,"link":"https://blog.csdn.net/qq_39477770/article/details/109491286?utm_medium=distribute.wap_feed.none-task-blog-cf-2.nonecase&amp;depth_1-utm_source=distribute.wap_feed.none-task-blog-cf-2.nonecase","niceDate":"1小时前","niceShareDate":"1小时前","origin":"","prefix":"","projectLink":"","publishTime":1612948691000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1612948691000,"shareUser":"larkunt","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"只因拎不清 插件化 和 热修复 的实现原理，我痛失了阿里的offer_清风Coolbreeze的博客-CSDN博客","type":0,"userId":83159,"visible":0,"zan":0}],"offset":0,"over":true,"pageCount":1,"size":20,"total":1}
         */

        private CoinInfoDTO coinInfo;
        private ShareArticlesDTO shareArticles;

        public CoinInfoDTO getCoinInfo() {
            return coinInfo;
        }

        public void setCoinInfo(CoinInfoDTO coinInfo) {
            this.coinInfo = coinInfo;
        }

        public ShareArticlesDTO getShareArticles() {
            return shareArticles;
        }

        public void setShareArticles(ShareArticlesDTO shareArticles) {
            this.shareArticles = shareArticles;
        }

        public static class CoinInfoDTO {
            /**
             * coinCount : 493
             * level : 5
             * nickname :
             * rank : 2227
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
        }

        public static class ShareArticlesDTO {
            /**
             * curPage : 1
             * datas : [{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"host":"","id":17247,"link":"https://blog.csdn.net/qq_39477770/article/details/109491286?utm_medium=distribute.wap_feed.none-task-blog-cf-2.nonecase&amp;depth_1-utm_source=distribute.wap_feed.none-task-blog-cf-2.nonecase","niceDate":"1小时前","niceShareDate":"1小时前","origin":"","prefix":"","projectLink":"","publishTime":1612948691000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1612948691000,"shareUser":"larkunt","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"只因拎不清 插件化 和 热修复 的实现原理，我痛失了阿里的offer_清风Coolbreeze的博客-CSDN博客","type":0,"userId":83159,"visible":0,"zan":0}]
             * offset : 0
             * over : true
             * pageCount : 1
             * size : 20
             * total : 1
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
                 * apkLink :
                 * audit : 1
                 * author :
                 * canEdit : false
                 * chapterId : 494
                 * chapterName : 广场
                 * collect : false
                 * courseId : 13
                 * desc :
                 * descMd :
                 * envelopePic :
                 * fresh : true
                 * host :
                 * id : 17247
                 * link : https://blog.csdn.net/qq_39477770/article/details/109491286?utm_medium=distribute.wap_feed.none-task-blog-cf-2.nonecase&amp;depth_1-utm_source=distribute.wap_feed.none-task-blog-cf-2.nonecase
                 * niceDate : 1小时前
                 * niceShareDate : 1小时前
                 * origin :
                 * prefix :
                 * projectLink :
                 * publishTime : 1612948691000
                 * realSuperChapterId : 493
                 * selfVisible : 0
                 * shareDate : 1612948691000
                 * shareUser : larkunt
                 * superChapterId : 494
                 * superChapterName : 广场Tab
                 * tags : []
                 * title : 只因拎不清 插件化 和 热修复 的实现原理，我痛失了阿里的offer_清风Coolbreeze的博客-CSDN博客
                 * type : 0
                 * userId : 83159
                 * visible : 0
                 * zan : 0
                 */

                private String apkLink;
                private Integer audit;
                private String author;
                private Boolean canEdit;
                private Integer chapterId;
                private String chapterName;
                private Boolean collect;
                private Integer courseId;
                private String desc;
                private String descMd;
                private String envelopePic;
                private Boolean fresh;
                private String host;
                private Integer id;
                private String link;
                private String niceDate;
                private String niceShareDate;
                private String origin;
                private String prefix;
                private String projectLink;
                private Long publishTime;
                private Integer realSuperChapterId;
                private Integer selfVisible;
                private Long shareDate;
                private String shareUser;
                private Integer superChapterId;
                private String superChapterName;
                private List<?> tags;
                private String title;
                private Integer type;
                private Integer userId;
                private Integer visible;
                private Integer zan;

                public String getApkLink() {
                    return apkLink;
                }

                public void setApkLink(String apkLink) {
                    this.apkLink = apkLink;
                }

                public Integer getAudit() {
                    return audit;
                }

                public void setAudit(Integer audit) {
                    this.audit = audit;
                }

                public String getAuthor() {
                    return author;
                }

                public void setAuthor(String author) {
                    this.author = author;
                }

                public Boolean getCanEdit() {
                    return canEdit;
                }

                public void setCanEdit(Boolean canEdit) {
                    this.canEdit = canEdit;
                }

                public Integer getChapterId() {
                    return chapterId;
                }

                public void setChapterId(Integer chapterId) {
                    this.chapterId = chapterId;
                }

                public String getChapterName() {
                    return chapterName;
                }

                public void setChapterName(String chapterName) {
                    this.chapterName = chapterName;
                }

                public Boolean getCollect() {
                    return collect;
                }

                public void setCollect(Boolean collect) {
                    this.collect = collect;
                }

                public Integer getCourseId() {
                    return courseId;
                }

                public void setCourseId(Integer courseId) {
                    this.courseId = courseId;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getDescMd() {
                    return descMd;
                }

                public void setDescMd(String descMd) {
                    this.descMd = descMd;
                }

                public String getEnvelopePic() {
                    return envelopePic;
                }

                public void setEnvelopePic(String envelopePic) {
                    this.envelopePic = envelopePic;
                }

                public Boolean getFresh() {
                    return fresh;
                }

                public void setFresh(Boolean fresh) {
                    this.fresh = fresh;
                }

                public String getHost() {
                    return host;
                }

                public void setHost(String host) {
                    this.host = host;
                }

                public Integer getId() {
                    return id;
                }

                public void setId(Integer id) {
                    this.id = id;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public String getNiceDate() {
                    return niceDate;
                }

                public void setNiceDate(String niceDate) {
                    this.niceDate = niceDate;
                }

                public String getNiceShareDate() {
                    return niceShareDate;
                }

                public void setNiceShareDate(String niceShareDate) {
                    this.niceShareDate = niceShareDate;
                }

                public String getOrigin() {
                    return origin;
                }

                public void setOrigin(String origin) {
                    this.origin = origin;
                }

                public String getPrefix() {
                    return prefix;
                }

                public void setPrefix(String prefix) {
                    this.prefix = prefix;
                }

                public String getProjectLink() {
                    return projectLink;
                }

                public void setProjectLink(String projectLink) {
                    this.projectLink = projectLink;
                }

                public Long getPublishTime() {
                    return publishTime;
                }

                public void setPublishTime(Long publishTime) {
                    this.publishTime = publishTime;
                }

                public Integer getRealSuperChapterId() {
                    return realSuperChapterId;
                }

                public void setRealSuperChapterId(Integer realSuperChapterId) {
                    this.realSuperChapterId = realSuperChapterId;
                }

                public Integer getSelfVisible() {
                    return selfVisible;
                }

                public void setSelfVisible(Integer selfVisible) {
                    this.selfVisible = selfVisible;
                }

                public Long getShareDate() {
                    return shareDate;
                }

                public void setShareDate(Long shareDate) {
                    this.shareDate = shareDate;
                }

                public String getShareUser() {
                    return shareUser;
                }

                public void setShareUser(String shareUser) {
                    this.shareUser = shareUser;
                }

                public Integer getSuperChapterId() {
                    return superChapterId;
                }

                public void setSuperChapterId(Integer superChapterId) {
                    this.superChapterId = superChapterId;
                }

                public String getSuperChapterName() {
                    return superChapterName;
                }

                public void setSuperChapterName(String superChapterName) {
                    this.superChapterName = superChapterName;
                }

                public List<?> getTags() {
                    return tags;
                }

                public void setTags(List<?> tags) {
                    this.tags = tags;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
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

                public Integer getVisible() {
                    return visible;
                }

                public void setVisible(Integer visible) {
                    this.visible = visible;
                }

                public Integer getZan() {
                    return zan;
                }

                public void setZan(Integer zan) {
                    this.zan = zan;
                }
            }
        }
    }
}
