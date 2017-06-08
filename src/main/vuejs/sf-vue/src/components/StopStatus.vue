<template>
  <div id="page-wrapper" class="gray-bg dashbard-1">
    <div class="row border-bottom">
      <stop-status-header></stop-status-header>
      <stop-status-body></stop-status-body>
    </div>
  </div>
</template>

<script>
  import StopStatusHeader from './StopStatusHeader'
  import StopStatusBody from './StopStatusBody'

  export default {
    data () {
      return {}
    },
    components: {
      StopStatusHeader,
      StopStatusBody
    }
  }
</script>

<style>

</style>
