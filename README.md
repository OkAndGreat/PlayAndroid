# App的简要介绍

主体界面用ViewPager+Fragment+TabLayout实现,并使用MVP设计

打开activivty先进入一个欢迎界面,使用Handler延迟1秒后才跳转到MainActivity

进入app后分为四个主界面: 首页 问答 分享 休息

在首页,问答,分享等Fragment中的OnCreateView中不直接inflate一个成功请求数据的view并return,而是return一个UILoader,这样可以让UILoader去处理网络出错,或请求数据为空时的界面显示情况,UILoader中有一个抽象方法getSuccessView要求每一个Fragment去实现,当成功请求数据后会显示这个界面

其中还有一个"抽屉"界面

主要用来负责登录,登出,查看历史点击记录等

在点击文章时会有一个监听将所点击文章的相关信息(如author link)等放到数据库中,然后在历史记录界面取出并展示

# 功能展示
![gif](https://github.com/OkAndGreat/PlayAndroid/blob/master/gif/open.gif)
![gif](https://github.com/OkAndGreat/PlayAndroid/blob/master/gif/home.gif)
![gif](https://github.com/OkAndGreat/PlayAndroid/blob/master/gif/History.gif)
![gif](https://github.com/OkAndGreat/PlayAndroid/blob/master/gif/login.gif)
![gif](https://github.com/OkAndGreat/PlayAndroid/blob/master/gif/search.gif)
![gif](https://github.com/OkAndGreat/PlayAndroid/blob/master/gif/share.gif)
![gif](https://github.com/OkAndGreat/PlayAndroid/blob/master/gif/JokesAndGirls.gif)
![gif](https://github.com/OkAndGreat/PlayAndroid/blob/master/gif/OpenProjectsAndAboutAuthor.gif)
![gif](https://github.com/OkAndGreat/PlayAndroid/blob/master/gif/question.gif)


# 心得体会

1.写一个比较大的程序时应该提前构思好,如果马上就上手的话很容易不停删删补补造成代码混乱

2.写较大程序时命名要规范,否则很容易让自己迷糊

# 待提升优化的地方

1.实现下拉刷新功能

安卓自带的SwipeRefreshLayout仅支持上拉刷新,而下拉刷新如果不用第三方库的话要自定义控件

2.设计一个用户引导页

也要自定义控件

3.UI做的更漂亮

4.实现懒加载

5.希望用Kotlin来写



