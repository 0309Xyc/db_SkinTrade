<template>
  <ElContainer>
    <ElHeader>
      <ElMenu mode="horizontal" @close="close" default-active="this.$route.path" router>
        <ElMenuItem index="/MainContent">首页</ElMenuItem>
        <ElMenuItem index="/Storage">库存</ElMenuItem>
        <ElMenuItem index="/Trade">交易</ElMenuItem>
        <ElMenuItem index="/News">咨讯</ElMenuItem>
        <ElMenuItem index="/User">我</ElMenuItem>
        <ElMenuItem ><input></ElMenuItem>
      </ElMenu>
    </ElHeader>
    <ElContainer>
      <ElAside width="200px" height="400px">
      </ElAside>
    </ElContainer>
    <ElMain>
      <ElRow gutter="20">
        <ElCol :span="6" v-for="order in orderList" :key="order.listing_id">
          <ElCard v-if="flag">
            <ElImage :src="'https://igstatic.igxe.cn/steam/image/730/d2d7a36fadffb79c1a4e07cc075f58a8.png'" alt="物品图片" style="width: 100%; height: 100px;" />
            <div>
              <p>皮肤名: {{ order.skin_name }}</p>
              <p>武器类型: {{ order.weapon_type }}</p>
              <p>价格: {{ order.price }}</p>
              <p>发布人: {{ order.username }}</p>
            </div>
            <div>
              <ElButton type="primary" @click="buyItem(order)">购买</ElButton>
            </div>
          </ElCard>
        </ElCol>
      </ElRow>
    </ElMain>

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
import {ElButton} from "element-plus";
import request from "@/utils/request.js";

export default {
  name: "Trade",
  data() {
    return {
      user: JSON.parse(localStorage.getItem("user")) || {},
      orderList: [],
      error: '',
      flag:true
    };
  },
  created() {
    this.fetchOrders();
  },
  methods: {
    fetchOrders() {
      const userId = this.user.user_id;
      request.get('/listing/getListingInfo')
          .then(res => {
            if (res.code === 1) {
              this.orderList = res.data;
            } else {
              this.error = res.msg;
            }
          });
    },
    buyItem(order) {
      // 在这里实现购买物品的逻辑，可以根据 order 中的物品 ID 发起购买请求
      this.$message.success('购买成功');
      this.flag = false;
    }
  }
}
</script>





<style>


</style>