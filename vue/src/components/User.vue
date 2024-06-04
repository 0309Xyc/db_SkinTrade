<!--
<template>
  <ElContainer>
    <ElHeader>
      <ElMenu mode="horizontal" @close="close" default-active="this.$route.path" router>
        <ElMenuItem index="/MainContent">首页</ElMenuItem>
        <ElMenuItem index="/Storage">库存</ElMenuItem>
        <ElMenuItem index="/Trade">交易</ElMenuItem>
        <ElMenuItem index="/User">我</ElMenuItem>
        <ElMenuItem ><input></ElMenuItem>
      </ElMenu>
    </ElHeader>
    <ElContainer>
      <ElAside width="200px" height="400px">
&lt;!&ndash;        <ElMenu mode="horizontal" default-active="this.$route.path" router>
          <ElMenuItem index="/ButterFlyKnife">
            蝴蝶刀
          </ElMenuItem>
          <ElMenuItem index="/M9">
            M9-刺刀
          </ElMenuItem>
          <ElMenuItem>

          </ElMenuItem>
        </ElMenu>&ndash;&gt;
      </ElAside>
    </ElContainer>


  </ElContainer>





</template>

<script>
import {ElContainer} from "element-plus";
import {ElAside} from "element-plus";
import {ElDropdownMenu} from "element-plus";
import {ElMain} from "element-plus";
import {ElImage} from "element-plus";
import {ElCarousel} from "element-plus";

export default {
  name: "User",
  data(){
    return{

    }
  }
}
</script>





<style>


</style>-->

<template>
  <ElContainer>
    <ElHeader>
      <ElMenu mode="horizontal" @close="close" default-active="this.$route.path" router>
        <ElMenuItem index="/MainContent">首页</ElMenuItem>
        <ElMenuItem index="/Storage">库存</ElMenuItem>
        <ElMenuItem index="/Trade">交易</ElMenuItem>
        <ElMenuItem index="/News">咨讯</ElMenuItem>
        <ElMenuItem index="/User">我</ElMenuItem>
      </ElMenu>
    </ElHeader>
    <ElContainer>
      <ElAside width="200px" height="400px">
        <!-- 侧边栏内容 -->
      </ElAside>
      <ElContainer>
        <ElMain>
          <h2>修改密码</h2>
          <ElForm :model="passwordForm" ref="passwordForm" :rules="passwordRules" label-width="100px">
            <ElFormItem label="旧密码" prop="oldPassword">
              <ElInput type="password" v-model="passwordForm.oldPassword"></ElInput>
            </ElFormItem>
            <ElFormItem label="新密码" prop="newPassword">
              <ElInput type="password" v-model="passwordForm.newPassword"></ElInput>
            </ElFormItem>
            <ElFormItem label="确认新密码" prop="confirmPassword">
              <ElInput type="password" v-model="passwordForm.confirmPassword"></ElInput>
            </ElFormItem>
            <ElFormItem>
              <ElButton type="primary" @click="submitPasswordForm">修改密码</ElButton>
            </ElFormItem>
          </ElForm>

          <h2>修改邮箱</h2>
          <ElForm :model="emailForm" ref="emailForm" :rules="emailRules" label-width="100px">
            <ElFormItem label="新邮箱" prop="email">
              <ElInput v-model="emailForm.email"></ElInput>
            </ElFormItem>
            <ElFormItem>
              <ElButton type="primary" @click="submitEmailForm">修改邮箱</ElButton>
            </ElFormItem>
          </ElForm>
        </ElMain>
      </ElContainer>
    </ElContainer>
  </ElContainer>
</template>

<script>
import { ElContainer, ElHeader, ElMenu, ElMenuItem, ElAside, ElMain, ElForm, ElFormItem, ElInput, ElButton } from "element-plus";
import request from "@/utils/request.js";

export default {
  name: "User",
  data() {
    return {
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {},
      passwordForm: {
        oldPassword: "",
        newPassword: "",
        confirmPassword: ""
      },
      emailForm: {
        email: ""
      },
      passwordRules: {
        oldPassword: [
          { required: true, message: "请输入旧密码", trigger: "blur" }
        ],
        newPassword: [
          { required: true, message: "请输入新密码", trigger: "blur" },
          { min: 6, message: "密码长度不能小于6位", trigger: "blur" }
        ],
        confirmPassword: [
          { required: true, message: "请确认新密码", trigger: "blur" },
          { validator: (rule, value, callback) => {
              if (value !== this.passwordForm.newPassword) {
                callback(new Error("两次输入的密码不一致"));
              } else {
                callback();
              }
            }, trigger: "blur" }
        ]
      },
      emailRules: {
        email: [
          { required: true, message: "请输入新邮箱", trigger: "blur" },
          { type: "email", message: "请输入正确的邮箱地址", trigger: "blur" }
        ]
      }
    };
  },
  methods: {
    submitPasswordForm() {
      this.$refs.passwordForm.validate((valid) => {
        if (valid) {
          request.post("/user/changePassword", {
            username: this.user.username,
            password:  this.passwordForm.newPassword
          }).then(res => {
            if (res.code === 1) {
              this.$message.success("密码修改成功");
            } else {
              this.$message.error(res.msg);
            }
          });
        }
      });
    },
    submitEmailForm() {
      this.$refs.emailForm.validate((valid) => {
        if (valid) {
          request.post("/user/changeEmail", {
            username: this.user.username,
            email: this.emailForm.email
          }).then(res => {
            if (res.code === 1) {
              this.$message.success("邮箱修改成功");
            } else {
              this.$message.error(res.msg);
            }
          });
        }
      });
    }
  }
}
</script>

<style>
/* 你可以根据需要添加样式 */
</style>
