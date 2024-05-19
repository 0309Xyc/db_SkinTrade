<template>
  <div class = 'title'>
    <h1>
      SkinTradeSystem!
    </h1>
  </div>
  <div class = 'Register' >
  <h1>
    account:<br> <label><input type="number" placeholder = '账号' required></label><br>
    password:<br><label><input type="password" placeholder="密码" required></label><br>
    <button @click=>登录</button>
    <button>忘记密码</button><br>
    <button  @click="handleClick">注册</button>
  </h1>

  </div>

</template>


<script lang="js">

export default {
  name:'App',

}

</script>


<style>
  .title{
    background-color: #aaa;
    box-shadow: 0 0 10px;
    border-radius: 10px;
    padding: 20px;

  }
 .Register{
   background-color: #ddd;
   box-shadow: 0 0 10px;
   border-radius: 10px;
   padding: 20px;
 }
</style>