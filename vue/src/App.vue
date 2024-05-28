<template>
  <h1 class = "title1">SkinTradeSystem!</h1>
  <Login/>
  <div class="main-contain">
    <RouterView></RouterView>
  </div>
</template>

<script >
import {RouterView} from "vue-router";
import Login from "@/components/Login.vue";
export default {
  name:'App',//组件名
  components:{Login}//注册组件
}
</script>

<style scoped>
  .title1{
    background-color: skyblue;
    text-align: center;
    color: white;
    padding: 10px;
    font-weight: bold;
    border-radius: 20px;

  }
  .main-contain{
    background-color: white;
    text-align: center;
    padding: 10px;
    color: white;
    font-weight: bold;
    font-size: 20px;

  }
</style>