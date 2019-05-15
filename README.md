# dians
RecyclerView  多条目展示


#  recyclerview  多条目 实现思路


1 导入依赖 
2 加入网络权限
3 创建mvp契约类  实现model  和 presenter 层   model层实现网络请求数据  presenter层 实现传值到activity 
4 网络请求使用的是okhttp  最简单的请求 因为感觉那个vollet有点麻烦 暂时先用这个了
5 创建一个api包 存放banner 接口 和 home接口 
6 创建bean类  创建一个bannerbean  homebean 
7 在activity里实现一个recyclerview布局管理器 用线性的 实例化presenter层 创建一个解析banner的gson解析的方法 还有一个的home的gson解析的方法  创建一
  个适配器
  传入 this 当前类 banner解析数据和home解析数据 
8 创建一个MyAdapter 继承RecyclerView，Adapter  实现三个构造方法 onCreateViewHolder 这个判断为0时用的那个布局 为1时用的那个布onBindViewHolder这个
  是你实现不同类型时的需要展示的东西getItemCount 还有接受activity传过来的数据创造一个方法实现  在创建一个方法 getItemViewType这个是判断你首页的不同   类
  型的holder 例如  position为0时 实现banner的类型 position为0时 实现rxxp的类型 
  
  
  暂时还是写不出来的  只能看懂这个意思  多条目还有点不会 其他的别的都能够理解  只有到适配器的时候 思路就有点没有了 明天多练练 能够了解这个多条目的适配
  器这个的思路  
