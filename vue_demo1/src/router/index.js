import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import GoodsList from '@/views/GoodsList'
import title from '@/views/title'
import image from '@/views/image'
import cart from '@/views/Cart'
import test from '@/views/test1'
import test1 from '@/views/test1_1'
import test2 from '@/views/test1_2'
import test3 from '@/views/test1_3'

Vue.use(Router)

export default new Router({
  /*
    mode:'history',
  */
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/goods',
      name: 'GoodsList',
      component: GoodsList,
      children: [
        {
          path: 'title',
          name: 'title',
          component: title
        },
        {
          path: 'image',
          name: 'image',
          component: image
        }
      ]
    },
    {
      path: '/cart',
      name: 'cart',
      component: cart
    },
    {
      path: '/test',
      name: 'test',
/*
            component: test
*/
      components: {
        default: test1,
        title: test2,
        img: test3
      }
    }
  ]
})
