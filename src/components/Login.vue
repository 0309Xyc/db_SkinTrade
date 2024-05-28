<template>
  <div class="login-container" v-if="isLogin">
    <h2>Login</h2>
    <form @submit.prevent="handleLogin">
      <div class="form-group">
        <label for="username"  >Username:</label>
        <input type="text" id="username" v-model="username"  required>
      </div>
      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="password" required>
      </div>

    </form>
    <ElButton type="primary"><router-link to="/MainContent" @click="handleLogin" >登录</router-link></ElButton>
    <div v-if="error" class="error-message">{{ error }}</div>
    <ElButton type="primary"><router-link to="/RegisterPage" @click="ClickToRegisterPage">注册</router-link></ElButton>
  </div>



</template>

<script>
import {RouterView,RouterLink} from "vue-router";
import {ElButton} from "element-plus";
export default {

  name: 'LoginForm',

  data() {
    return {
      username: '',
      password: '',
      error: '',
      isLogin: true
    }
  },
  methods: {
    handleLogin() {
      // 管理员账号和密码
      const adminUsername = 'root';
      const adminPassword = 'password';

      if (this.username === adminUsername && this.password === adminPassword) {
        this.isLogin=false;
        // 登录成功, 跳转到主页面

      } else if (this.username === 'admin' && this.password === 'password') {
        // 普通用户登录成功, 跳转到主页面
        this.isLogin=false

      } else {
        this.error = 'Invalid username or password';
      }
    },

    ClickToRegisterPage(){
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



button:hover {
  background-color: #0056b3;
}

.error-message {
  color: #dc3545;
  margin-top: 1rem;
  text-align: center;
}
</style>
