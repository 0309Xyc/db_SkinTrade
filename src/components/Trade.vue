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
        <ElMenu mode="horizontal" default-active="this.$route.path" router>
          <ElMenuItem index="/ButterFlyKnife">
            蝴蝶刀
          </ElMenuItem>
          <ElMenuItem index="/M9">
            M9-刺刀
          </ElMenuItem>
          <ElMenuItem>

          </ElMenuItem>
        </ElMenu>
      </ElAside>
    </ElContainer>
    <ElMain>
      <ElRow gutter="20">
        <ElPopover :visible="visible" placement="top" :width="160">
        <p>Are you sure to buy this?</p>
        <div style="text-align: right; margin: 0">
          <ElButton size="small" text @click="visible = false">cancel</ElButton>
          <ElButton size="small" type="primary" @click="visible = false">confirm</ElButton>
        </div>
        <template #reference>
          <ElButton @click="visible = true">
            BUY
            <div>
              <ElCol :span="6" v-for="image in imgList" :key="image.id">
                <ElImage :src="image.url" alt="图片" @click="showimage(image)">

                </ElImage>
              </ElCol>
            </div>
          </ElButton>
        </template>
      </ElPopover>

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

export default {
  name: "Trade",
  data(){
    return{
      visible:false,
      imgList:[
          {
            id:1,
            Name:'butterflyknife',
            patten:'op',
            price:10000,
            url:'https://igstatic.igxe.cn/steam/image/730/d2d7a36fadffb79c1a4e07cc075f58a8.png'
          }
      ]
    }
  },
  methods:{
    showimage(image){
      alert(`ID: ${image.id}, Pattern: ${image.patten},Price: ${image.price}`);

    }
  }
}
</script>





<style>


</style>