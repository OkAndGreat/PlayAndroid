# App的简要介绍

主体界面用ViewPager+Fragment+TabLayout实现,并使用MVP架构

打开activivty先进入一个欢迎界面,使用Handler延迟1秒后才跳转到MainActivity

进入app后分为四个主界面: 首页 问答 分享 休息

在首页,问答,分享等Fragment中的OnCreateView中不直接inflate一个成功请求数据的view并return,而是return一个UILoader,这样可以让UILoader去处理网络出错,或请求数据为空时的界面显示情况,UILoader中有一个抽象方法getSuccessView要求每一个Fragment去实现,当成功请求数据后会显示这个界面

休息界面的数据是从Github找的免费API: [RollToolsApi](https://github.com/MZCretin/RollToolsApi)

登陆和注册的数据以及文章的数据是使用WanAndroid的API: [玩Android开放API](https://www.wanandroid.com/blog/show/2)

其中还有一个"抽屉"界面

主要用来负责登录,登出,查看历史点击记录等

在点击文章时会有一个监听将所点击文章的相关信息(如author link)等放到数据库中,然后在历史记录界面取出并展示


# 功能展示
|  **欢迎界面**   | 
|  ----  |
| ![gif](https://github.com/OkAndGreat/PlayAndroid/blob/master/gif/open.gif)  |

|  **home界面**   | 
|  ----  |
| ![gif](https://github.com/OkAndGreat/PlayAndroid/blob/master/gif/home.gif)  |

|  **积分界面**   | 
|  ----  |
| ![gif](https://github.com/OkAndGreat/PlayAndroid/blob/master/gif/Point.gif)  |

|  **历史记录界面**   | 
|  ----  |
|  ![gif](https://github.com/OkAndGreat/PlayAndroid/blob/master/gif/History.gif) |

|  **登录和注册界面**   | 
|  ----  |
| ![gif](https://github.com/OkAndGreat/PlayAndroid/blob/master/gif/login.gif)  |

|  **搜索界面**   | 
|  ----  |
|  ![gif](https://github.com/OkAndGreat/PlayAndroid/blob/master/gif/search.gif) |

|  **分享界面**   | 
|  ----  |
| ![gif](https://github.com/OkAndGreat/PlayAndroid/blob/master/gif/share.gif)  |

|  **看美图和笑话界面**   | 
|  ----  |
| ![gif](https://github.com/OkAndGreat/PlayAndroid/blob/master/gif/JokesAndGirls.gif) |

|  **开源项目与关于作者界面**   | 
|  ----  |
| ![gif](https://github.com/OkAndGreat/PlayAndroid/blob/master/gif/OpenProjectsAndAboutAuthor.gif)  |

|  **问答界面**   | 
|  ----  |
| ![gif](https://github.com/OkAndGreat/PlayAndroid/blob/master/gif/question.gif)  |


# 心得体会

1.写一个比较大的程序时应该提前构思好,如果马上就上手的话很容易不停删删补补造成代码混乱

2.写较大程序时命名要规范,否则很容易让自己迷糊

# 待提升优化的地方

1.实现下拉刷新功能

2.设计一个用户引导页

3.UI做的更漂亮

4.实现懒加载

5.希望用Kotlin来写

6.还有一些Bug因为个人技术问题暂时无法解决

7.有很多wanandroid的功能在PlayAndroid都没有去实现,一部分是个人技术问题无法实现,还有一部分是可以实现但太累了不想再继续做下去了,比如首页轮播图,收藏功能等(~~好吧其实就是我懒~~).



