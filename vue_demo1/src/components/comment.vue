<template>
    <div>
      <button v-on:click="zeng">+</button>
      <button v-on:click="jian">-</button>
      <p><span>{{num}}</span></p>
      <images></images>
    </div>
</template>

<script>
  import  images from '@/views/image'
    export default {
        name: "comment",
        props:["num"],
        data(){
          return{
            num:0
          }
        },
        methods:{
          zeng(){
            this.$emit("incress");
          },
          jian(){
            this.$emit("deincress");
          }
        },
      components:{
        images
      }
    }
</script>

<style scoped>

</style>
