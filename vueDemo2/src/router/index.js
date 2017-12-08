import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import test from '@/views/test1'


Vue.use(Router)
const Foo = {template: '<div>foo</div>'}
const Bar = {template: '<div>bar</div>'}
const Baz = {template: '<div>baz</div>'}
export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component:{
        HelloWorld
      }
    },
    {
      path: '/test',
      name: 'test',
      component: {
        test
      }
    }
  ]
})
