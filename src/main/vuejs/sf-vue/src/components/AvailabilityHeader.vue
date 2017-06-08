<template>
  <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0; margin-left: 20px; height: 60px; line-height: 50px;">
    <div class="navbar-header">
      <h2>시간가동률</h2>
    </div>
  </nav>
</template>

<script>
  /* eslint-disable */
  export default {
    data() {
      return {
        fromDate: this.formatDate(new Date),
        toDate: this.formatDate(new Date)
      }
    },
    methods: {
      formatDate(date) {
        let d = new Date(date),
          month = '' + d.getMonth(),
          day = '' + d.getDate(),
          year = d.getFullYear()

        if (month.length < 2) month = '0' + month
        if (day.length < 2) day = '0' + day

        return [year, month, day].join('-');
      },
      search(){

      }
    }
  }
</script>

<style>

</style>
