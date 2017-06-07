<template>
  <div id="page-wrapper" class="gray-bg dashbard-1">
    <div class="row border-bottom">
      <e-header></e-header>
      <e-body></e-body>
    </div>
  </div>
</template>

<script>
  import eHeader from './Header'
  import eBody from './Body'

  export default {
    data () {
      return {}
    },
    components: {
      eHeader,
      eBody
    }
  }
</script>

<style>

</style>
