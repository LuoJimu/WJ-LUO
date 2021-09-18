import Vue from 'vue'
import Router from 'vue-router'
// 导入编写的组件
import AppIndex from '../components/home/AppIndex'
import Login from '../components/Login'
import Home from '../components/Home'
import LibraryIndex from '../components/library/LibraryIndex'

Vue.use(Router)

export default new Router({
  // 前端路由使用 History 模式20210120
  mode: 'history',
  routes: [
    // 下面都是固定的写法
    {
      path: '/',
      name: 'Default',
      redirect: '/home',
      component: Home
    },
    {
      path: '/home',
      name: 'Home',
      component: Home,
      // home页面并不需要被访问
      redirect: '/index',
      children: [
        {
          path: '/index',
          name: 'AppIndex',
          component: AppIndex,
          // 区分页面是否需要拦截20210125
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/library',
          name: 'Library',
          component: LibraryIndex,
          meta: {
            requireAuth: true
          }
        }
      ]
    },
    {
      path: '/login',
      name: 'Login',
      // component: Login
      component: () => import('../components/Login')

    },
    {
      path: '/register',
      name: 'Register',
      component: () => import('../components/Register')
    },
  ]
})

// 复制过来的代码20210701
// import Vue from 'vue'
// import Router from 'vue-router'
// import AppIndex from '../components/home/AppIndex'
// import Login from '../components/Login'
// import Home from '../components/Home'
//
// Vue.use(Router)
//
// export default new Router({
//   mode: 'history',
//   routes: [
//     {
//       path: '/home',
//       name: 'Home',
//       component: Home,
//       // home页面并不需要被访问
//       redirect: '/index',
//       children: [
//         {
//           path: '/index',
//           name: 'AppIndex',
//           component: AppIndex,
//           meta: {
//             requireAuth: true
//           }
//         }
//       ]
//     },
//     {
//       path: '/login',
//       name: 'Login',
//       component: Login
//     }
//   ]
// })
