import { createRouter, createWebHistory } from 'vue-router'
import Home from '../pages/Home.vue'
import  HelloWorld  from '../components/HelloWorld.vue'

let history = createWebHistory()
let routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/hello',
    name: 'Hello',
    component: HelloWorld
  },
]

export default createRouter({ history, routes })
