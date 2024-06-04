import {createRouter, createWebHistory} from 'vue-router'
import MainContent from "@/components/MainContent.vue";
import RegisterPage from "@/components/RegisterPage.vue";
import Storage from "@/components/Storage.vue";
import User from "@/components/User.vue";
import Trade from "@/components/Trade.vue";
import News from "@/components/News.vue";
import Admin from "@/components/Admin.vue";
import ShowButterFlyKnife from "@/SkinGroup/ShowButterFlyKnife.vue";
import ShowM9 from "@/SkinGroup/ShowM9.vue";
import UploadItem from "@/components/UploadItem.vue";

import Login from "@/components/Login.vue";

const router = createRouter({
    history: createWebHistory(),
    routes: [

        {
            path: '/MainContent',
            component: MainContent
        },

        {
            path: '/RegisterPage',
            component: RegisterPage
        },
        {
            path: '/Storage',
            component: Storage
        },
        {
            path: '/User',
            component: User
        },
        {
            path: '/Trade',
            component: Trade
        },
        {
            path: '/News',
            component: News
        },
        {
            path: '/Admin',
            component: Admin
        },
        {
            path: '/ButterFlyKnife',
            component: ShowButterFlyKnife

        },
        {
            path: '/M9',
            component: ShowM9
        },
        {
            path: '/UploadItem',
            component: UploadItem
        }


    ]
})
export default router;








