<template>
  <div id="wrapper">
    <e-menu @clickmenu="onClickMenu"></e-menu>
    <!--<test></test>-->
    <router-view></router-view>
    <!--<e-content></e-content>-->
  </div>
</template>

<script>
  /* eslint-disable */
  import eMenu from './Menu'
  //import eContent from './Content'
  import eDashboard from './Dashboard'
  import eUPH from './Availability'
  //import Test from './GridsterTest'
  export default {
    data () {
      return {}
    },
    components: {
      eMenu,
      eDashboard,
      eUPH
//      eContent
//      Test
    },
    methods: {
      onClickMenu(menu){
        this.$router.push(menu.path)
      }
    }
  }
</script>

<style>

</style>
