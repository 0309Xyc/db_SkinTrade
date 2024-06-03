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
<!--        <ElMenu mode="horizontal" default-active="this.$route.path" router>&lt;!&ndash;
          <ElMenuItem index="/ButterFlyKnife">
            蝴蝶刀
          </ElMenuItem>
          <ElMenuItem index="/M9">
            M9-刺刀
          </ElMenuItem>
          <ElMenuItem>

          </ElMenuItem>&ndash;&gt;
        </ElMenu>-->
      </ElAside>
    </ElContainer>
    <ElContainer>
      <ElMain>
        <ElRow>
<!--          <ElCol :span="6" v-for="image in imageList" :key="image.id">
            <ElImage :src="image.url" alt="图片" @click="showimage(image)">

            </ElImage>
          </ElCol>-->

        </ElRow>
      </ElMain>
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
import {ElRow} from "element-plus";
import {ElCol} from "element-plus";
import request from "@/utils/request.js";
export default {
  name: "Storage",
  data(){

    return{
      user:localStorage.getItem("user")?JSON.parse(localStorage.getItem("user")):{},
      inventory: [],
      newItem: {
        wear: '',
        skin_name: '',
        weapon_type: '',
        image: null
      },
      error:''
    }
  },
  created() {
    this.fetchInventory();
  },
  methods:{
    fetchInventory() {
      const userId = this.user.user_id;
      request.get(`/item/getitem?user_id=${userId}`)
          .then(res => {
            if(res.code===1){
              this.inventory = res.data;
            } else {
              this.error=res.msg;
            }
          });
    },
    onFileChange(event) {
      const file = event.target.files[0];
      this.newItem.image = file;
    },
    addItem() {
      const userId = this.user.user_id;
      request.post(`/item/additem?user_id=${userId}`, this.newItem)
          .then(res => {
            if(res.code===1){
              this.fetchInventory(); // 更新库存显示
            } else {
              this.error=res.msg;
            }
          });
    }
  }
}
</script>





<style>


</style>