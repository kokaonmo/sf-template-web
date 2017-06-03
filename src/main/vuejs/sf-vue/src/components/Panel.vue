<template>
  <div class="ibox float-e-margins">
    <div class="ibox-title">
      <h5>{{ title }}</h5>
      <div class="ibox-tools">
        <a class="collapse-link">
          <i class="fa fa-chevron-up"></i>
        </a>
        <a class="close-link">
          <i class="fa fa-times"></i>
        </a>
      </div>
    </div>
    <div class="ibox-content">
      <slot></slot>
    </div>
  </div>
</template>

<script>
  export default {
    data () {
      return {
      }
    },
    props: ['title'],
    computed: {

    }
  }
</script>

<style>

</style>
