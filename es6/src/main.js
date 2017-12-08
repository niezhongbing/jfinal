// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
//import * as util from "./util";

Vue.config.productionTip = false

/* eslint-disable no-new */
// console.log("sum:" +util.sum(1,6));
// console.log("minus:" +util.minus(6,6));
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})
