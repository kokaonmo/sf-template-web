<template>
  <div class="hello">
    <b-alert show>
      Default Alert
    </b-alert>

    <b-alert state="success" show>
      Success Alert
    </b-alert>

    <b-alert state="danger" dismissible :show="showDismissibleAlert" @dismissed="showDismissibleAlert=false">
      Dismissible Alert!
    </b-alert>

    <b-alert :show="dismissCountDown" dismissible state="warning" @dismiss-count-down="countDownChanged">
      This alert will dismiss after {{dismissCountDown}} seconds...
    </b-alert>

    <b-btn @click="showAlert" variant="info" class="m-1">Show alert with count-down timer</b-btn>
    <b-btn @click="showDismissibleAlert=true" variant="info" class="m-1">
      Show dismissible alert ({{showDismissibleAlert?'visible':'hidden'}})
    </b-btn>
  </div>
</template>

<script>
export default {
  name: 'hello',
  data () {
    return {
      dismissCountDown: null,
      showDismissibleAlert: false
    }
  },
  methods: {
    countDownChanged (dismissCountDown) {
      this.dismissCountDown = dismissCountDown
    },
    showAlert () {
      this.dismissCountDown = 5
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .hello {
    padding: 20px;
    height: 300px;
  }
/*h1, h2 {*/
  /*font-weight: normal;*/
/*}*/

/*ul {*/
  /*list-style-type: none;*/
  /*padding: 0;*/
/*}*/

/*li {*/
  /*display: inline-block;*/
  /*margin: 0 10px;*/
/*}*/

/*a {*/
  /*color: #42b983;*/
/*}*/
</style>
