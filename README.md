# fenceMall

## git
### 安装 git
[教程](https://www.runoob.com/git/git-install-setup.html)

### 拉取项目
- cd 自己想存放项目的文件夹
- git clone https://github.com/xiangrujob/fenceMall.git

### 常用命令
- git status 
    - 查看 git 工作目录、暂存区和仓库状态（推荐经常使用）
- git checkout -b 分支名
  - 新建分支并切换到新分支 
- git add . 
  - 将工作目录代码提交到暂存区
- git commit -m "提交的备注（随意修改）" 
  - 将暂存区代码提交到本地仓库
- git push --set-upstream origin 分支名:分支名
  - 将本地仓库代码提交到远程仓库
- git pull 从远程仓库拉取最新的代码到本地仓库并覆盖工作目录
    - 注意：git pull 是一个复合命令 它等于 git fetch && git merge
    
每个人需要创建分支进行开发

