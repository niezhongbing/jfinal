<template>
  <div>
<!--
    命名式路由，参数：{{$route.params.id}}
-->
    我是test1.vue界面
    <router-view class="main" ></router-view>
    <router-view name="title" class="left"></router-view>
    <router-view name="img" class="right"></router-view>
  </div>
</template>

<script>
  export default {
    name: "test1"
  }
</script>

<style scoped>
  .left, .right {
    float: left;
    width: 49%;
    border: 1px solid gray;
  }
</style>
