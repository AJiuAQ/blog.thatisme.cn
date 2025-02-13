# thatisme 系统说明

    that is me，一个我自己的博客系统，包含PC、H5、安卓端的个人博客展示及博客管理系统。
## 如何运行
1. 获取代码  
`git clone https://github.com/AJiuAQ/blog.thatisme.cn.git`
2. 下载依赖
3. 配置数据库url和用户名密码  
编辑文件[application-mysql.yml](src/main/resources/application-mysql.yml)修改数据库为自己的数据库连接
4. 运行项目
5. 测试请求
+ 访问：`http://IP:PORT/graphiql`发送请求
+ 或者打开[http](http)目录，使用 IDEA request 功能发送请求，内有一些测试用例


## 阶段

### 产品需求阶段

- [x] [thatisme产品需求文档PRD.md](./thatisme产品需求文档PRD.md)
- [ ] 领域设计
- [ ] 原型图

### 开发阶段

- [x] 后端开发
- [ ] PC前端开发
- [ ] H5前端开发
- [ ] 安卓APP开发

### 运维阶段

- [ ] 系统上线并投入使用
- [ ] 功能升级迭代

### 各部分技术选型

+ 系统相关文档
  统一使用 markdown
+ 图像
  oss
+ 原型图
  axure
+ 后端
  java、spring
+ 前端
  vue3、ts、dart（安卓端）待定
+ 运维
  云服务器、域名、oss

