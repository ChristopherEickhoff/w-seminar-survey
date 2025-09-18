import { createRouter, createWebHistory } from 'vue-router'
import Home from '../App.vue'
import Survey from '../components/SurveyBootstrap.vue'
import Results from '../components/Results.vue'
import ThankYou from '../components/ThankYou.vue'

const routes = [
  { path: '/', component: Survey },
  { path: '/results', component: Results },
  { path: '/thankyou', component: ThankYou }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router