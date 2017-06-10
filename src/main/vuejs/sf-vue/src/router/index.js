import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Dashboard from '@/components/Dashboard'
import Availability from '@/components/Availability'
import Performance from '@/components/Performance'
import Operation from '@/components/Operation'
import StopStatus from '@/components/StopStatus'
import Correlation from '@/components/Correlation'

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
          path: 'performance',
          name: 'performance',
          component: Performance
        },
        {
          path: 'operation',
          name: 'operation',
          component: Operation
        },
        {
          path: 'stopstatus',
          name: 'stopstatus',
          component: StopStatus
        },
        {
          path: 'correlation',
          name: 'correlation',
          component: Correlation
        }
      ]
    }
  ]
})
