<script lang="ts" setup xmlns="http://www.w3.org/1999/html">
const tableData = [

  {
    date: '2024-05-01',
    username: 'aaa',
    email: '456@163.com',
    password: '1234567',
  },
  {
    date: '2024-05-02',
    username: 'bbb',
    email: '123@qq.com',
    password: '123456',
  },
  {
    date: '2024-05-03',
    username: 'ccc',
    email: '12344@qq.com',
    password: '1234567',
  },
  {
    date: '2024-05-04',
    username: 'aiyi',
    email: '145@qq.com',
    password: '123456',
  },
  {
    date: '2024-6-04',
    username: 'xyz',
    email: 'xyz@qq.com',
    password: '1234567',
  },
]
</script>

<template>
  <div class="El-table">
    <El-table :data="tableData" style="width: 100%">
      <El-table-column prop="date" label="Date" width="180"/>
      <El-table-column prop="username" label="username" width="180"/>
      <El-table-column prop="email" label="email" width="180"/>
      <El-table-column prop="password" label="password"/>
    </El-table>
    <button><a href="http://localhost:5173">返回</a></button>
  </div>
</template>

<style scoped>
.El-table {
  color: black;
}
</style>