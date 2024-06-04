<template>
  <ElContainer>
    <ElHeader>
      <ElMenu mode="horizontal" default-active="this.$route.path" router>
        <ElMenuItem index="/MainContent">首页</ElMenuItem>
        <ElMenuItem index="/Storage">库存</ElMenuItem>
        <ElMenuItem index="/Trade">交易</ElMenuItem>
        <ElMenuItem index="/User">我</ElMenuItem>
        <ElMenuItem>
          <input type="text" v-model="searchInput" placeholder="搜索">
        </ElMenuItem>
      </ElMenu>
    </ElHeader>
    <ElContainer>
      <ElMain>
        <ElForm :model="newItem" label-width="80px">
          <ElFormItem label="磨损">
            <ElInput v-model="newItem.wear"></ElInput>
          </ElFormItem>
          <ElFormItem label="皮肤名">
            <ElInput v-model="newItem.skin_name"></ElInput>
          </ElFormItem>
          <ElFormItem label="武器类型">
            <ElInput v-model="newItem.weapon_type"></ElInput>
          </ElFormItem>
<!--          <ElFormItem label="图片">
            <input type="file" @change="onFileChange">
          </ElFormItem>-->
          <ElFormItem>
            <ElButton type="primary" @click="addItem">添加</ElButton>
          </ElFormItem>
        </ElForm>



      </ElMain>
    </ElContainer>
  </ElContainer>
</template>

<script>
import { ElContainer, ElHeader, ElMenu, ElMenuItem, ElMain, ElRow, ElCol, ElCard, ElImage, ElDialog, ElForm, ElFormItem, ElInput, ElButton } from 'element-plus';
import request from "@/utils/request.js";
import router from "@/router/index.js";

export default {
  name: "UploadItem",
  data() {
    return {
      user: JSON.parse(localStorage.getItem("user")) || {},
      newItem: {
        wear: '',
        skin_name: '',
        weapon_type: '',
/*        image: null*/
      },
      searchInput: '',
      error: ''
    };
  },
  created() {
  },
  methods: {
    onFileChange(event) {
      const file = event.target.files[0];
      this.newItem.image = file;
    },
    addItem() {
      const formData = new FormData();
      formData.append('wear', this.newItem.wear);
      formData.append('skin_name', this.newItem.skin_name);
      formData.append('weapon_type', this.newItem.weapon_type);
/*      formData.append('image', this.newItem.image);*/

      request.post('/item/addItem', formData,this.user.user_id)
          .then(res => {
            if (res.code === 1) {
              router.push({path:'/MainContent'});
            } else {
              this.error = res.msg;
            }
          });
    }
  }
}
</script>

<style>
/* 你可以根据需要添加样式 */
</style>
