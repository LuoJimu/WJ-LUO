<template>
  <body id="poster">
<!--  版本1-->
<!--  <div>
    用户名:<input type="text" v-model="loginForm.username" placeholder="请输入用户名"/>
    <br><br>
    密码： <input type="password" v-model="loginForm.password" placeholder="请输入密码"/>
    <br><br>
    <button v-on:click="login">登录</button>
  </div>

  版本2：引入element后修改为如下
  <el-card>
    用户名:<input type="text" v-model="loginForm.username" placeholder="请输入用户名"/>
    <br><br>
    密码： <input type="password" v-model="loginForm.password" placeholder="请输入密码"/>
    <br><br>
    <button v-on:click="login">登录</button>
  </el-card>-->

<!--  版本3：优化界面-->
  <el-form class="login-container" label-position="left" label-width="0px">
    <h3 class="login_title">系统登录</h3>
    <el-form-item>
      <el-input type="text" v-model="loginForm.username" auto-complete="off" placeholder="账号">
      </el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="password" v-model="loginForm.password" auto-complete="off" placeholder="密码">
      </el-input>
    </el-form-item>
<!--    <el-checkbox class="login_remember" v-model="checked" label-position="left"><span style="color: #505458">记住密码</span></el-checkbox>-->
    <el-form-item style="width: 100%">
      <el-button type="primary" style="background: #505458;border: none" v-on:click="login">登录</el-button>
<!--      <el-button type="primary" style="background: #505458;border: none" @click="resetForm">重置</el-button>-->
      <router-link to="register"><el-button type="primary" style="background: #505458;border: none">注册</el-button></router-link>
    </el-form-item>
  </el-form>
  </body>
</template>

<script>
    export default {
        name: 'Login',
        data () {
            return {
                rules: {
                    username: [{required: true, message: '用户名不能为空', trigger: 'blur'}],
                    password: [{required: true, message: '密码不能为空', trigger: 'blur'}]
                },
                checked: true,
                loginForm: {
                    username: '',
                    password: ''
                },
                responseResult: [],
                loading: false
            }
    },
        methods: {
            // 重置密码
            // resetForm () {
            //     this.loginForm = {
            //         username: '',
            //         password: ''
            //     }
            // },
            login () {
                // 20210125
                var _this = this
                console.log(this.$store.state)

                this.$axios
                    .post('/login', {
                        username: this.loginForm.username,
                        password: this.loginForm.password
                    })
                    // 20210125
                    // 1.点击登录按钮，向后端发送数据
                    // 2.受到后端返回的成功代码时，触发 store 中的 login() 方法，把 loginForm 对象传递给 store 中的 user 对象
                    // （*这里只是简单的实现，在后端我们可以通过用户名和密码查询数据库，获得 user 表的完整信息，比如用户昵称、用户级别等，返回前端，并传递给 user 对象，以实现更复杂的功能）
                    // 3.获取登录前页面的路径并跳转，如果该路径不存在，则跳转到首页
                    .then(successResponse => {
                        if (successResponse.data.code === 200) {
                            // var data = this.loginForm
                            _this.$store.commit('login', _this.loginForm)
                            var path = this.$route.query.redirect
                            this.$router.replace({path: path === '/' || path === undefined ? '/index' : path})
                        }
                    })
                    .catch(failResponse => {
                    })
            }
        }
    }
</script>

<style scoped>
  #poster {
    background:url("../assets/bg/loginBackground.jpg") no-repeat;
    background-position: center;
    height: 100%;
    width: 100%;
    background-size: cover;
    position: fixed;
  }
  body{
    margin: 0px;
  }
  .login-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 90px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }
</style>
