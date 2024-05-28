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
    <ElContainer>
      <ElMain>
        <ElRow>
          <ElCol :span="6" v-for="image in imageList" :key="image.id">
            <ElImage :src="image.url" alt="图片" @click="showimage(image)">

            </ElImage>
          </ElCol>

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
export default {
  name: "Storage",
  data(){

    return{
      imageList:[
        {
          id:1,
          Name:'butterflyknife1',
          patten:'fade',
          url:'https://th.bing.com/th/id/OIP.nOVCTYsNaPeQSYxXr9vz_gHaEh?rs=1&pid=ImgDetMain'
        },
        {
          id:2,
          Name:'butterflyknife2',
          patten:'fade',
          url:'https://th.bing.com/th/id/OIP.rTOulXKesi3z83KHowLZpgHaEh?pid=ImgDet&w=204&h=124&c=7&dpr=1.5'
        }
      ]
    }
  },

  methods:{
    showimage(image){
      alert(`ID: ${image.id}, Pattern: ${image.patten}`);
    }
  }
}
</script>





<style>


</style>