<template>
  <div>
    <p>我是父类：<span>{{nums}}</span></p>
    <comments v-bind:num="nums" v-on:incress="increment" v-on:deincress="deincrement"></comments>
  </div>
</template>

<script>
import comment from "./comment"
export default {
  name: 'HelloWorld',
  data () {
    return {
      nums:8,
      msg: 'Welcome to Your Vue.js App'
    }
  },
  components:{
    comments:comment
  },
  methods:{
    increment(){
      this.nums++;
    },
    deincrement(){
      this.nums--;
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
