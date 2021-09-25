<template>
  <el-menu
    :default-active="currentPath"
    router
    mode="horizontal"
    background-color="white"
    text-color="#222"
    active-text-color="red"
    style="min-width: 1300px">
    <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name">
      {{ item.navItem }}
    </el-menu-item>
<!--    <a href="#nowhere" style="color: #222;float: right;padding: 20px;">更多功能</a>-->
<!--    <i class="el-icon-menu" style="float:right;font-size: 45px;color: #222;padding-top: 8px"></i>-->
    <i class="el-icon-switch-button" @click="logout" style="font-size: 40px;float: right"></i>
    <span style="position: absolute;padding-top: 20px;right: 43%;font-size: 20px;font-weight: bold">Welcome To Heart Of Luosanhei！</span>
<!--    <el-input-->
<!--      placeholder="快速搜索..."-->
<!--      prefix-icon="el-icon-search"-->
<!--      size="medium"-->
<!--      style="width: 300px;position:absolute;margin-top: 12px;right: 18%"-->
<!--      v-model="keywords">-->
<!--    </el-input>-->
  </el-menu>
</template>

<script>
    import {createRouter} from '../../router'
    export default {
        name: 'NavMenu',
        data() {
            return {
                navList: [
                    {name: '/index', navItem: '首页'},
                    {name: '/jotter', navItem: '笔记本'},
                    {name: '/library', navItem: '图书馆'},
                    {name: '/admin', navItem: '个人中心'}
                ],
                keywords: ''
            }
        },
        computed: {
            hoverBackground() {
                return '#ffd04b'
            },
            currentPath() {
                var x = this.$route.path.indexOf('/', 1)
                if (x !== -1) {
                    return this.$route.path.substring(0, x)
                } else {
                    return this.$route.path
                }
            }
        },
        methods: {
            // 用户退出登录
            logout () {
                this.$confirm('确认退出登录?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                        var _this = this
                        this.$axios.get('/logout').then(resp => {
                            if (resp && resp.data.code === 200) {
                                _this.$store.commit('logout')
                                _this.$router.replace('/login')
                                // 清空路由，防止路由重复加载
                                const newRouter = createRouter()
                                _this.$router.matcher = newRouter.matcher
                                this.$message({type: 'info', message: '已退出登录!'})
                            }
                        }).catch(failResponse => {
                        })
                    }
                ).catch(() => {
                    this.$message({type: 'info', message: '已取消操作！'})
                })
            }
        }
    }
</script>

<style scoped>
  a{
    text-decoration: none;
  }
  span {
    pointer-events: none;
  }
  .el-icon-switch-button {
    cursor: pointer;
    outline:0;
  }
</style>
