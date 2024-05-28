<template>
  <div class="container">
    <h2>User Registration</h2>
    <form action="/register" method="post">
      <label for="username">Username:</label>
      <input type="text" id="username" name="username" placeholder="Enter your username" required>

      <label for="email">Email:</label>
      <input type="text" id="email" name="email" placeholder="Enter your email" required>

      <label for="password">Password:</label>
      <input type="password" id="password" name="password" placeholder="Enter your password" required>

      <label for="confirmPassword">Confirm Password:</label>
      <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm your password" required>

      <button type="submit">Register</button>
    </form>
  </div>
</template>

<script>
export default {
  name: "RegisterPage",
}
</script>

<style>
h2{
  text-align: center;
  color: black;
}

body {
  font-family: Arial, sans-serif;
  background-color: #f2f2f2;
}

.container {
  background-color: white;
  padding: 20px;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  max-width: 400px;
  margin: 50px auto;
}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  width: 100%;
}

button:hover {
  background-color: #45a049;
}
</style>