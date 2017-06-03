/* eslint-disable */
// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
//import Vue from 'vue'
import Vue from 'vue'
import App from './App'
import router from './router'
import Highcharts from 'highcharts'
import VueHighcharts from 'vue-highcharts'
import highchartsMore from 'highcharts/highcharts-more'

highchartsMore(Highcharts)
Vue.use(VueHighcharts, {Highcharts})

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})

