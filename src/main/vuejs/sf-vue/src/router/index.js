import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Dashboard from '@/components/Dashboard'
import Availability from '@/components/Availability'
import StopStatus from '@/components/StopStatus'

Vue.use(Router)

/* eslint-disable */
export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      children: [
        {
          path: '/',
          name: 'dashboard',
          component: Dashboard
        },
        {
          path: 'availability',
          name: 'availability',
          component: Availability
        },
        {
          path: 'stopstatus',
          name: 'stopstatus',
          component: StopStatus
        }
      ]
    }
  ]
})
