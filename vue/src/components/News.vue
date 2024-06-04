<script setup>

</script>

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
  </ElContainer>
  <div class="content">
    <p class="text"><span>游戏资讯<br></span></p>
    <hr>
    <ul>
      <li class="tr"><a href="https://buff.163.com/news/50141"
                        target="_blank">G2夺冠相关动态汇总：HLTV作者被NiKo剃头(2024-06-03)</a></li>
      <p><img src="./resource/p1.png" alt="" title="" height=250px width=400px></p><br>
      <li class="tr"><a href="https://buff.163.com/news/50130"
                        target="_blank">IEM达拉斯站冠军战队动态：NiKo两次IEM冠军照片同框(2024-06-03)</a></li>
      <p><img src="./resource/p2.png" alt="" title="" height=250px width=400px></p><br>
      <li class="tr"><a href="https://buff.163.com/news/50097" target="_blank">IEM达拉斯：G2 2-1
        Vitality成功夺冠！(2024-06-03)</a></li>
      <p><img src="./resource/p3.png" alt="" title="" height=250px width=400px></p><br>
      <li class="tr"><a href="https://buff.163.com/news/50105" target="_blank">m0NESY：我并不畏惧去Peek
        ZywOo(2024-06-03)</a></li>
      <p><img src="./resource/p4.png" alt="" title="" height=250px width=400px></p><br>
      <li class="tr"><a href="https://buff.163.com/news/50104"
                        target="_blank">flameZ：我们不能再输给自己了(2024-06-03)</a></li>
      <p><img src="./resource/p5.png" alt="" title="" height=250px width=400px></p><br>
      <li class="tr"><a href="https://buff.163.com/news/50103"
                        target="_blank">G2赛后采访：没有比这更好的童话故事了(2024-06-03)</a></li>
      <p><img src="./resource/p6.png" alt="" title="" height=250px width=400px></p><br>
      <li class="tr"><a href="https://buff.163.com/news/50068" target="_blank">nexa：真赢了决赛会觉得怪怪的，因为HooXi没参加这次比赛(2024-06-02)</a>
      </li>
      <p><img src="./resource/p7.png" alt="" title="" height=250px width=400px></p><br>
      <li class="tr"><a href="https://buff.163.com/news/50017" target="_blank">Stewie2K：NiKo就是世一步，绝对值得Major冠军(2024-06-01)</a>
      </li>
      <p><img src="./resource/p8.png" alt="" title="" height=250px width=400px></p><br>
      <li class="tr"><a href="https://buff.163.com/news/50014"
                        target="_blank">apEX：明天的选图里，我跟donk会对位磕枪(2024-06-01)</a></li>
      <p><img src="./resource/p9.png" alt="" title="" height=250px width=400px></p><br>
      <p>想看更多请点击：<a href="https://buff.163.com/news/" target="_blank">https://buff.163.com/news/</a>
      </p><br>
    </ul>
    <hr>
    <p>友情链接：<a href="https://buff.163.com/?game=csgo">网易BUFF</a></p>
    <p>网易公司版权所有&copy;网易BUFF饰品交易平台</p>
  </div>
</template>

<style scoped>
.content {
  width: 1280px;
  height: auto;
  margin: 0 auto;
  padding: 25px;
  border: 2.5px solid skyblue;
  border-radius: 15px 15px 5px 5px;
  color: black;
}

.tr:hover {
  background: skyblue;
}
</style>
