import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import test from '@/views/test1'
import test1 from '@/views/test1_1'
import test2 from '@/views/test1_2'
import test3 from '@/views/test1_3'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/test',
      name: 'test',
      components:{
        default:test1 ,
        a : test2 ,
        b :test3
      }
    }
  ]
})
