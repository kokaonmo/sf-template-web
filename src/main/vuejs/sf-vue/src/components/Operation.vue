<template>
  <div id="page-wrapper" class="gray-bg dashbard-1">
    <div class="row border-bottom">
      <e-operation-header></e-operation-header>
      <e-operation-body></e-operation-body>
    </div>
  </div>
</template>

<script>
  import eOperationHeader from './OperationHeader'
  import eOperationBody from './OperationBody'

  export default {
    data () {
      return {}
    },
    components: {
      eOperationHeader,
      eOperationBody
    }
  }
</script>

<style>

</style>
