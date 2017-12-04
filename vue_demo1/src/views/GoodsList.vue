<template>
  <div>
    <h1>我是商品列表页面</h1>
    <p><span>{{$route.params.goodsId}}</span></p><br>
    <p><span>{{$route.params.user}}</span></p>
    <router-link to="/goods/title">显示商品标题</router-link>
    <router-link to="/goods/image">显示商品图片</router-link>
    <div>
      <router-view></router-view>
    </div>
    <router-link to="/cart">显示Cart</router-link>
    <!--编程式路由-->
    <button @click="jump">button跳转到购物车页面</button>

    <!--命名路由-->
    <router-link v-bind:to="{name:'test'/*,params:{id:234}*/}">命名式路由配置</router-link>
  </div>
</template>

<script>
    export default {
        name: "goods-list",
        methods:{
          jump(){
            this.$router.push({path:'/cart?id=123'});
          }
        }
    }
</script>

<style scoped>

</style>
