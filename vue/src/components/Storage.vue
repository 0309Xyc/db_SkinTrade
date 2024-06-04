<template>
  <ElContainer>
    <ElHeader>
      <ElMenu mode="horizontal" default-active="this.$route.path" router>
        <ElMenuItem index="/MainContent">首页</ElMenuItem>
        <ElMenuItem index="/Storage">库存</ElMenuItem>
        <ElMenuItem index="/Trade">交易</ElMenuItem>
        <ElMenuItem index="/News">咨讯</ElMenuItem>
        <ElMenuItem index="/User">我</ElMenuItem>
        <ElMenuItem>
          <input type="text" v-model="searchInput" placeholder="搜索">
        </ElMenuItem>
      </ElMenu>
    </ElHeader>
    <ElContainer>
      <ElMain>
        <ElButton type="primary" @click="ClickToUploadItem">添加物品</ElButton>
        <ElRow>
          <ElCol :span="6" v-for="item in inventory" :key="item.item_id">
            <ElCard>
              <ElImage :src="'https://igstatic.igxe.cn/steam/image/730/d2d7a36fadffb79c1a4e07cc075f58a8.png'" alt="物品图片" style="width: 100%; height: 200px;" />
              <div>
                <p>磨损: {{ item.wear }}</p>
                <p>皮肤名: {{ item.skin_name }}</p>
                <p>武器类型: {{ item.weapon_type }}</p>
                <ElRow justify="space-between">
                  <ElCol :span="12">
                    <ElInput v-model="item.price" placeholder="请输入价格"  />
                  </ElCol>
                  <ElCol :span="12">
                    <ElButton type="success" @click="addToOrder(item)">上架</ElButton>
                  </ElCol>
                </ElRow>
              </div>
            </ElCard>
          </ElCol>
        </ElRow>
      </ElMain>
    </ElContainer>
  </ElContainer>
</template>

<script>
import { ElContainer, ElHeader, ElMenu, ElMenuItem, ElMain, ElRow, ElCol, ElCard, ElImage, ElInput, ElButton } from 'element-plus';
import request from "@/utils/request.js";
import router from "@/router/index.js";

export default {
  name: "Storage",
  data() {
    return {
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {},
      inventory: []
    };
  },
  created() {
    this.fetchInventory();
  },
  methods: {
    fetchInventory() {
      const userId = this.user.user_id;
      request.get(`/item/getItem`, { params: { user_id: userId } })
          .then(res => {
            if (res.code === 1) {
              this.inventory = res.data;
            } else {
              this.$message.error(res.msg);
            }
          });
    },
    ClickToUploadItem(){
      router.push({path:'/UploadItem'});
    },
    addToOrder(item) {
      const userId = this.user.user_id;
      const price = item.price;
      const item_id = item.item_id;

/*      this.$message.error(price);
      this.$message.error(userId);
      this.$message.error(item_id);*/


      request.post(`/listing/addListing?item_id=${item_id}&user_id=${userId}&price=${price}`)
          .then(res => {
            if (res.code === 1) {
              // 处理成功添加订单的情况
              this.$message.success('上架成功');
            } else {
              this.$message.error(res.msg);
            }
          });
    }
  }
}
</script>

<style>
</style>
