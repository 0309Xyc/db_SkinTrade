<template>
  <div class="login-container" v-if="isLogin">
    <h2>Login</h2>
    <form @submit.prevent="handleLogin">
      <div class="form-group">
        <label for="username"  >Username:</label>
        <input type="text" id="username" v-model="User.username"  required>
      </div>
      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="User.password" required>
      </div>

    </form>
    <button @click="handleLogin" >登录</button>
    <div v-if="error" class="error-message">{{ error }}</div>
    <button @click="ClickToRegisterPage">注册</button>
  </div>



</template>

<script>
import request from "@/utils/request.js";
import router from "@/router";

export default {

  name: 'LoginForm',

  data() {
    return {
      User: {},
      error: '',
      isLogin: true
    }
  },
  methods: {
    handleLogin() {
      request.post("/user/login",this.User).then(res =>{
        // 管理员账号和密码
        const adminUsername = 'root';
        const adminPassword = 'root';

        if(this.User.username === adminUsername && this.User.password === adminPassword){//管理员登录
          localStorage.setItem("user",JSON.stringify(res.data));
          this.isLogin=false
          router.push({path:'/Admin'});
        } else if(res.code===1){//用户登录
          localStorage.setItem("user",JSON.stringify(res.data));
          this.isLogin=false
          router.push({path:'/MainContent'});
        } else {
          this.error = res.msg;
        }
      })
    },

    ClickToRegisterPage(){
      router.push({path:'/RegisterPage'});
      this.isLogin=false
    }
  }
}
</script>

<style scoped>
.login-container {
  max-width: 400px;
  margin: 0 auto;
  padding: 2rem;
  background-color: #87ceeb;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

h2 {
  text-align: center;
  margin-bottom: 1.5rem;
}

.form-group {
  margin-bottom: 1.5rem;
}

label {
  display: block;
  font-weight: bold;
  margin-bottom: 0.5rem;
}

input {
  color: black;
  width: 100%;
  padding: 0.75rem;
  border: 1px solid #ccc;
  border-radius: 4px;
}

button {
  width: 100%;
  padding: 0.75rem;
  background-color: #007bff;
  color: #ddd;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 20px;
}

button:hover {
  background-color: #0056b3;
}

.error-message {
  color: #dc3545;
  margin-top: 1rem;
  text-align: center;
}
</style>
