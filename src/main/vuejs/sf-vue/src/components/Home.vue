<template>
  <div id="wrapper">
    <e-menu></e-menu>
    <!--<test></test>-->
    <e-content></e-content>
  </div>
</template>

<script>
  /* eslint-disable */
  import eMenu from './Menu'
  import eContent from './Content'
  //import Test from './GridsterTest'
  export default {
    data () {
      return {}
    },
    components: {
      eMenu,
      eContent
//      Test
    }
  }
</script>

<style>

</style>
