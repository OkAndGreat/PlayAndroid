package com.example.playandroid.model.bean;

import java.util.List;

public class JokesBean {

    /**
     * code : 1
     * msg : 数据返回成功！
     * data : {"page":1,"totalCount":87145,"totalPage":8715,"limit":10,"list":[{"content":"课上，小雯觉得时间很难熬。　　就开始敲桌子打板凳，还念念有词道，\u201c真是渡分如年啊！\u201d　　然后，就问坐在旁边的小佩：\u201c还有几分钟下课？\u201d　　小佩看了看表，淡淡地说：\u201c还有一年。\u201d","updateTime":"2020-06-18 23:59:24"},{"content":"听说你又被开除啦? 是啊!老板娘怀孕了,就把我开除了～我去!老板娘怀孕开除你!你和她肚子的里孩子有什么关系啊? 就是怕有关系才把我开除的，老板娘说,怀孕的时候天天见我的样子,怕孩子生出来长的像我一样丑,就把我开除了\u2026\u2026","updateTime":"2020-06-18 23:59:23"},{"content":"和女朋友分手，她舍不得我，说再给我做一顿饭。晚上去她家，她给我做的黄瓜花生拌的凉菜，煮的螃蟹，板栗炖牛肉，还做了个羊肉汤，之后还准备了西瓜，还给我剥桔子，她说看着我都吃了，就满足了，看她这么用心，我就都吃了，那么现在到底分，还是 ？","updateTime":"2020-06-18 23:59:23"},{"content":"甲：\u201d你怎么总是在晚上九点后才和女朋友相约，难道真像作家们所说的\u201c爱情需要黑暗\u2026\u2026。\u201d乙：\u201d那倒不是，只因为九点后街上的商店都关了门呀。\u201d","updateTime":"2020-06-18 23:59:22"},{"content":"夜深了，两个男子走在路上开始谈论起鬼来。其中一个说：\u201c有些人活着的时候就够吓人的了，死了之后还要吓人。听说天黑了以后这条街上会有个鬼出现，那个鬼长得丑死了，有好几个胆小的女孩子都被他吓晕过，并且他以吓人为乐。\u201d这时，突然从他们后面传出话来：\u201c是哪个家伙在说我的坏话？\u201d","updateTime":"2020-06-18 23:59:21"},{"content":"儿子上幼儿园时交了个女盆友；直到上小学一年级还是藕断丝连，我怕影响到学习，劝其不要来往。一年后他俩还在交往，两人每次考试都是100、100的！！！","updateTime":"2020-06-18 23:59:20"},{"content":"出月子后把头发剪了，因为长胖了把老公衣服拿来先穿着准备上街买衣服。到衣服店。导购马上迎了上来:你好，你是给女朋友买衣服吗?我:我自己穿的。导购一脸茫然:大哥我们这是女装店。","updateTime":"2020-06-18 23:59:17"},{"content":"今天下的雪，让人感觉浪漫又让人冻的发嗖。进门看到为家忙碌的妻子，心理十分感动，于是走到妻子旁边，轻声细语的附在老婆耳旁说到，亲爱的，要不要来点刺激的！！\r\n之见老婆红着脸说声讨厌。在老婆默认的情况下，我把在冰天雪地骑了五里路没有带手套的手伸进了她的后背！！！","updateTime":"2020-06-18 23:59:16"},{"content":"和闺蜜一起出门，闺蜜身着一袭白裙，很是惹眼。我开玩笑道:\u201c呦,好漂亮啊,跟个公主似的。\u201d闺蜜脸上顿时笑开了花:\u201c真的吗,是像白雪公主吗?\u201d我坏笑道:\u201c不,像令月公主!\u201d闺蜜一怔：\u201c令月公主是谁?\"\u201c令月公主是大唐第一美女。\"看到闺蜜打开了手机百度，我立刻跑开了","updateTime":"2020-06-18 23:59:16"},{"content":"石阶问佛像：\u201c我们都是石头，凭什么你受人膜拜,我却遭人践踏？\u201d\r\n佛像笑到：你只挨了四刀就成石阶，我却挨了千刀万剐才有现在的模样，想成功就要历经磨烂。\u201d\r\n过几天石阶带了个同伴找到佛像：\u201c这是我表亲，切菜板，您也给他说到说到。\u201d佛像:\u2026\u2026","updateTime":"2020-06-18 23:59:15"}]}
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
         * page : 1
         * totalCount : 87145
         * totalPage : 8715
         * limit : 10
         * list : [{"content":"课上，小雯觉得时间很难熬。　　就开始敲桌子打板凳，还念念有词道，\u201c真是渡分如年啊！\u201d　　然后，就问坐在旁边的小佩：\u201c还有几分钟下课？\u201d　　小佩看了看表，淡淡地说：\u201c还有一年。\u201d","updateTime":"2020-06-18 23:59:24"},{"content":"听说你又被开除啦? 是啊!老板娘怀孕了,就把我开除了～我去!老板娘怀孕开除你!你和她肚子的里孩子有什么关系啊? 就是怕有关系才把我开除的，老板娘说,怀孕的时候天天见我的样子,怕孩子生出来长的像我一样丑,就把我开除了\u2026\u2026","updateTime":"2020-06-18 23:59:23"},{"content":"和女朋友分手，她舍不得我，说再给我做一顿饭。晚上去她家，她给我做的黄瓜花生拌的凉菜，煮的螃蟹，板栗炖牛肉，还做了个羊肉汤，之后还准备了西瓜，还给我剥桔子，她说看着我都吃了，就满足了，看她这么用心，我就都吃了，那么现在到底分，还是 ？","updateTime":"2020-06-18 23:59:23"},{"content":"甲：\u201d你怎么总是在晚上九点后才和女朋友相约，难道真像作家们所说的\u201c爱情需要黑暗\u2026\u2026。\u201d乙：\u201d那倒不是，只因为九点后街上的商店都关了门呀。\u201d","updateTime":"2020-06-18 23:59:22"},{"content":"夜深了，两个男子走在路上开始谈论起鬼来。其中一个说：\u201c有些人活着的时候就够吓人的了，死了之后还要吓人。听说天黑了以后这条街上会有个鬼出现，那个鬼长得丑死了，有好几个胆小的女孩子都被他吓晕过，并且他以吓人为乐。\u201d这时，突然从他们后面传出话来：\u201c是哪个家伙在说我的坏话？\u201d","updateTime":"2020-06-18 23:59:21"},{"content":"儿子上幼儿园时交了个女盆友；直到上小学一年级还是藕断丝连，我怕影响到学习，劝其不要来往。一年后他俩还在交往，两人每次考试都是100、100的！！！","updateTime":"2020-06-18 23:59:20"},{"content":"出月子后把头发剪了，因为长胖了把老公衣服拿来先穿着准备上街买衣服。到衣服店。导购马上迎了上来:你好，你是给女朋友买衣服吗?我:我自己穿的。导购一脸茫然:大哥我们这是女装店。","updateTime":"2020-06-18 23:59:17"},{"content":"今天下的雪，让人感觉浪漫又让人冻的发嗖。进门看到为家忙碌的妻子，心理十分感动，于是走到妻子旁边，轻声细语的附在老婆耳旁说到，亲爱的，要不要来点刺激的！！\r\n之见老婆红着脸说声讨厌。在老婆默认的情况下，我把在冰天雪地骑了五里路没有带手套的手伸进了她的后背！！！","updateTime":"2020-06-18 23:59:16"},{"content":"和闺蜜一起出门，闺蜜身着一袭白裙，很是惹眼。我开玩笑道:\u201c呦,好漂亮啊,跟个公主似的。\u201d闺蜜脸上顿时笑开了花:\u201c真的吗,是像白雪公主吗?\u201d我坏笑道:\u201c不,像令月公主!\u201d闺蜜一怔：\u201c令月公主是谁?\"\u201c令月公主是大唐第一美女。\"看到闺蜜打开了手机百度，我立刻跑开了","updateTime":"2020-06-18 23:59:16"},{"content":"石阶问佛像：\u201c我们都是石头，凭什么你受人膜拜,我却遭人践踏？\u201d\r\n佛像笑到：你只挨了四刀就成石阶，我却挨了千刀万剐才有现在的模样，想成功就要历经磨烂。\u201d\r\n过几天石阶带了个同伴找到佛像：\u201c这是我表亲，切菜板，您也给他说到说到。\u201d佛像:\u2026\u2026","updateTime":"2020-06-18 23:59:15"}]
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
             * content : 课上，小雯觉得时间很难熬。　　就开始敲桌子打板凳，还念念有词道，“真是渡分如年啊！”　　然后，就问坐在旁边的小佩：“还有几分钟下课？”　　小佩看了看表，淡淡地说：“还有一年。”
             * updateTime : 2020-06-18 23:59:24
             */

            private String content;
            private String updateTime;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }
        }
    }
}
