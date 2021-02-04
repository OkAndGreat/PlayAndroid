package com.example.playandroid.model.bean;

import java.util.List;

public class TopHomeArticleBean {

    /**
     * data : [{"apkLink":"","audit":1,"author":"扔物线","canEdit":false,"chapterId":249,"chapterName":"干货资源","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"host":"","id":12554,"link":"http://i0k.cn/59VQB","niceDate":"刚刚","niceShareDate":"2020-03-23 16:36","origin":"","prefix":"","projectLink":"","publishTime":1614441600000,"realSuperChapterId":248,"selfVisible":0,"shareDate":1584952597000,"shareUser":"","superChapterId":249,"superChapterName":"干货资源","tags":[],"title":"Android 面试黑洞&mdash;&mdash;当我按下 Home 键再切回来，会发生什么？","type":1,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"Android指北","canEdit":false,"chapterId":249,"chapterName":"干货资源","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"host":"","id":17189,"link":"https://mp.weixin.qq.com/s/Efdq8GWSOfG1MDbnDxqdJQ","niceDate":"7小时前","niceShareDate":"7小时前","origin":"","prefix":"","projectLink":"","publishTime":1612427823000,"realSuperChapterId":248,"selfVisible":0,"shareDate":1612427811000,"shareUser":"","superChapterId":249,"superChapterName":"干货资源","tags":[],"title":"良心巨作！阿里大佬熬夜整理了508页Android核心源码学习笔记，现开放下载！","type":1,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"xiaoyang","canEdit":false,"chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>今天的问题比较细了，探索一个大家可能没关注过的 API，View中包含一个方法：<\/p>\r\n<ul>\r\n<li>hasOverlappingRendering() <\/li>\r\n<\/ul>\r\n<p>问题很直接：<\/p>\r\n<ol>\r\n<li>这个方法有什么用？<\/li>\r\n<li>在什么情况下我们会考虑复写这个方法？<\/li>\r\n<\/ol>","descMd":"","envelopePic":"","fresh":false,"host":"","id":17131,"link":"https://wanandroid.com/wenda/show/17131","niceDate":"2021-01-31 17:20","niceShareDate":"2021-01-31 17:09","origin":"","prefix":"","projectLink":"","publishTime":1612084806000,"realSuperChapterId":439,"selfVisible":0,"shareDate":1612084141000,"shareUser":"","superChapterId":440,"superChapterName":"问答","tags":[{"name":"本站发布","url":"/article/list/0?cid=440"},{"name":"问答","url":"/wenda"}],"title":"每日一问 | 今天还探索一个 View 的方法 hasOverlappingRendering()","type":1,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"xiaoyang","canEdit":false,"chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>大家都知道一个Java类从class文件到可以运行时，需要经历：加载、链接、初始化等过程，然后才能被创建对象（实例化）。<\/p>\r\n<p>今天问一个有趣的问题，有可能一个对象的实例化调用，要早于其初始化吗？<\/p>\r\n<p>白话点说：这个类中的构造方法要早于静态代码块的执行？<\/p>\r\n<ol>\r\n<li>怎么写会出现这种情况？<\/li>\r\n<li>分析其执行流程<\/li>\r\n<\/ol>","descMd":"","envelopePic":"","fresh":false,"host":"","id":17083,"link":"https://www.wanandroid.com/wenda/show/17083","niceDate":"2021-01-27 23:59","niceShareDate":"2021-01-27 23:58","origin":"","prefix":"","projectLink":"","publishTime":1611763188000,"realSuperChapterId":439,"selfVisible":0,"shareDate":1611763136000,"shareUser":"","superChapterId":440,"superChapterName":"问答","tags":[{"name":"本站发布","url":"/article/list/0?cid=440"},{"name":"问答","url":"/wenda"}],"title":"每日一问 | 类要先加载、链接、初始化才能实例化，有特殊Case吗？","type":1,"userId":2,"visible":1,"zan":7},{"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":377,"chapterName":"优质内推","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":16100,"link":"https://mp.weixin.qq.com/s/1u7W3gIAwY6-LNBw5eYuTw","niceDate":"2021-01-20 15:19","niceShareDate":"2020-11-17 01:11","origin":"","prefix":"","projectLink":"","publishTime":1611127172000,"realSuperChapterId":376,"selfVisible":0,"shareDate":1605546687000,"shareUser":"","superChapterId":377,"superChapterName":"内推","tags":[],"title":"我来招人啦！","type":1,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":360,"chapterName":"小编发布","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":16446,"link":"https://www.wanandroid.com/blog/show/2030","niceDate":"2020-12-13 20:21","niceShareDate":"2020-12-13 15:43","origin":"","prefix":"","projectLink":"","publishTime":1607862102000,"realSuperChapterId":297,"selfVisible":0,"shareDate":1607845415000,"shareUser":"","superChapterId":298,"superChapterName":"原创文章","tags":[{"name":"本站发布","url":"/article/list/0?cid=360"}],"title":"年底收租 大家自由支持 感谢 &amp; 通知","type":1,"userId":-1,"visible":1,"zan":0}]
     * errorCode : 0
     * errorMsg :
     */

    private List<DataDTO> data;
    private Integer errorCode;
    private String errorMsg;

    public List<DataDTO> getData() {
        return data;
    }

    public void setData(List<DataDTO> data) {
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
         * apkLink :
         * audit : 1
         * author : 扔物线
         * canEdit : false
         * chapterId : 249
         * chapterName : 干货资源
         * collect : false
         * courseId : 13
         * desc :
         * descMd :
         * envelopePic :
         * fresh : true
         * host :
         * id : 12554
         * link : http://i0k.cn/59VQB
         * niceDate : 刚刚
         * niceShareDate : 2020-03-23 16:36
         * origin :
         * prefix :
         * projectLink :
         * publishTime : 1614441600000
         * realSuperChapterId : 248
         * selfVisible : 0
         * shareDate : 1584952597000
         * shareUser :
         * superChapterId : 249
         * superChapterName : 干货资源
         * tags : []
         * title : Android 面试黑洞&mdash;&mdash;当我按下 Home 键再切回来，会发生什么？
         * type : 1
         * userId : -1
         * visible : 1
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
