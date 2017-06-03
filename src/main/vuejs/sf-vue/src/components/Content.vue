<template>
  <div id="page-wrapper" class="gray-bg dashbard-1">
    <div class="row border-bottom">
      <e-header></e-header>
      <e-body></e-body>
      <e-footer></e-footer>
    </div>
  </div>
</template>

<script>
  import eHeader from './Header'
  import eBody from './Body'
  import eFooter from './Footer'

  export default {
    data () {
      return {}
    },
    components: {
      eHeader,
      eBody,
      eFooter
    }
  }
</script>

<style>

</style>
