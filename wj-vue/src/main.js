
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from './store'

// 设置反向代理，前端请求默认发送到 http://localhost:8443/api
var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8443/WJ-LUO'

// 使请求带上凭证信息20210918
axios.defaults.withCredentials = true

// 全局注册，之后可在其他组件中通过 this.$axios 发送数据
Vue.prototype.$axios = axios
Vue.config.productionTip = false

// 引入ElementUI
Vue.use(ElementUI)


/* eslint-disable no-new */
// 此段代码放在钩子函数先后影响着前端是否能拦截
new Vue({
  el: '#app',
  render: h => h(App),
  router,
  // 注意这里20210125
  store,
  components: { App },
  template: '<App/>'
})

// 20210125钩子函数及在某些时机会被调用的函数。这里我们使用 router.beforeEach()，意思是在访问每一个路由前调用
// 如果前端没有登录信息则直接拦截，如果有则判断后端是否正常登录（防止构造参数绕过）
router.beforeEach((to, from, next) => {
    if (to.meta.requireAuth) {
        if (store.state.user) {
          axios.get('/authentication').then(resp => {
            if (resp) next()
          })
      } else {
        next({
          path: 'login',
          query: {redirect: to.fullPath}
        })
      }
    } else {
      next()
    }
  }
)




