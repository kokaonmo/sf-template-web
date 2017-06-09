<template>
  <div id="page-wrapper" class="gray-bg dashbard-1">
    <div class="row border-bottom">
      <e-performance-header></e-performance-header>
      <e-performance-body></e-performance-body>
    </div>
  </div>
</template>

<script>
  import ePerformanceHeader from './PerformanceHeader'
  import ePerformanceBody from './PerformanceBody'

  export default {
    data () {
      return {}
    },
    components: {
      ePerformanceHeader,
      ePerformanceBody
    }
  }
</script>

<style>

</style>
