<template>
  <div id="page-wrapper" class="gray-bg dashbard-1">
    <div class="row border-bottom">
      <e-correlation-header></e-correlation-header>
      <e-correlation-body></e-correlation-body>
    </div>
  </div>
</template>

<script>
  import eCorrelationHeader from './CorrelationHeader'
  import eCorrelationBody from './CorrelationBody'

  export default {
    data () {
      return {}
    },
    components: {
      eCorrelationHeader,
      eCorrelationBody
    }
  }
</script>

<style>

</style>
