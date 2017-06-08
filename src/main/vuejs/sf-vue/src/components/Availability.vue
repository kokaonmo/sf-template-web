<template>
  <div id="page-wrapper" class="gray-bg dashbard-1">
    <div class="row border-bottom">
      <e-availability-header></e-availability-header>
      <e-availability-body></e-availability-body>
    </div>
  </div>
</template>

<script>
  import eAvailabilityHeader from './AvailabilityHeader'
  import eAvailabilityBody from './AvailabilityBody'

  export default {
    data () {
      return {}
    },
    components: {
      eAvailabilityHeader,
      eAvailabilityBody
    }
  }
</script>

<style>

</style>
