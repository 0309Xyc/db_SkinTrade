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
        <ElCol :span="6" v-for="image in imgList" :key="image.id">

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

export default {
  name: "Trade",
  data(){
    return{
      imgList:[
          {
            id:1,
            url:'https://th.bing.com/th/id/OIP.nOVCTYsNaPeQSYxXr9vz_gHaEh?rs=1&pid=ImgDetMain'
          }
      ]
    }
  }
}
</script>





<style>


</style>