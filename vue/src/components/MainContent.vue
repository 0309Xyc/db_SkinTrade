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

      <ElMain width="1000px">
          <ElCarousel height="300px" autoplay loop>
            <ElCarouselItem v-for="item in imgList" :key="item.id">
              <ElImage :src="item.url" alt="图片" class="carouse-img">

              </ElImage>
            </ElCarouselItem>
          </ElCarousel>
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

export default {
  name: "MainContent",
  data(){
    return{
      imgList:[
        {
          id:1,
          url:'https://th.bing.com/th/id/OIP.nOVCTYsNaPeQSYxXr9vz_gHaEh?rs=1&pid=ImgDetMain'
        },
        {
          id:2,
          url:'https://th.bing.com/th/id/OIP.rTOulXKesi3z83KHowLZpgHaEh?pid=ImgDet&w=204&h=124&c=7&dpr=1.5'
        }
      ]
    }
  }
}
</script>





<style>
.carouse-img{
  width: 40%;
  height: 100%;
}
.nav-bar{
  background: skyblue;
  text-align: center;
  float: left;
  width:80px;
  height: 500px;
  padding: 10px;
  color: white;
  border-radius: 20px;
  font-size: 20px;
}
</style>