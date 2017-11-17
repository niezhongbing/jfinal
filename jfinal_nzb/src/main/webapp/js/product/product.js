var vm = new Vue({
	el:"#app"
    ,data:{
        message: 'Hello Vue.js!'
       ,title: '我是标题!'
    }
	,filters:{
		
	}
 	,mounted:function(){
 		this.$nextTick(function(){
 			this.createView();
 		})
 	}
 	,methods:{
 		createView :function(){
 			var _this = this;
 			this.$http.get("/product/product_list").then(function(res){
 				console.log(res.data);
 			});
 		}
 	}
});