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
          path: '/jotter',
          name: 'Jotter',
          component: () => import('../components/jotter/Articles')
        },
        {
          path: '/jotter/article',
          name: 'Article',
          component: () => import('../components/jotter/ArticleDetails')
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

// 用于创建默认路由
export const createRouter = routes => new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Default',
      redirect: '/home',
      component: Home
    },
    {
      // home页面并不需要被访问，只是作为其它组件的父组件
      path: '/home',
      name: 'Home',
      component: Home,
      redirect: '/index',
      children: [
        {
          path: '/index',
          name: 'AppIndex',
          component: () => import('../components/home/AppIndex')
        },
        {
          path: '/jotter',
          name: 'Jotter',
          component: () => import('../components/jotter/Articles')
        },
        {
          path: '/jotter/article',
          name: 'Article',
          component: () => import('../components/jotter/ArticleDetails')
        },
        // {
        //   path: '/admin/content/editor',
        //   name: 'Editor',
        //   component: () => import('../components/admin/content/ArticleEditor'),
        //   meta: {
        //     requireAuth: true
        //   }
        // },
        {
          path: '/library',
          name: 'Library',
          component: () => import('../components/library/LibraryIndex')
        }
      ]
    },
    {
      path: '/login',
      name: 'Login',
      component: () => import('../components/Login')
    },
    {
      path: '/register',
      name: 'Register',
      component: () => import('../components/Register')
    },
    // {
    //   path: '/admin',
    //   name: 'Admin',
    //   component: () => import('../components/admin/AdminIndex'),
    //   meta: {
    //     requireAuth: true
    //   },
    //   children: [
    //     {
    //       path: '/admin/dashboard',
    //       name: 'Dashboard',
    //       component: () => import('../components/admin/dashboard/admin/index'),
    //       meta: {
    //         requireAuth: true
    //       }
    //     }
    //   ]
    // },
    // {
    //   path: '*',
    //   component: () => import('../components/pages/Error404')
    // }
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
