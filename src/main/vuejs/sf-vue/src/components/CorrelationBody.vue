<template>
  <div class="border-bottom white-bg dashboard-header">
    <form class="form-inline" style="margin-bottom: 5px;">
      <div class="form-group">
        <div class="input-group">
          <div class="input-group-addon">FROM</div>
          <input type="date" class="form-control" v-model="fromDate">
        </div>
      </div>
      <div class="form-group">
        <div class="input-group">
          <div class="input-group-addon">TO</div>
          <input type="date" class="form-control" v-model="toDate">
        </div>
        <button type="submit" class="btn btn-primary">Find</button>
      </div>
    </form>

    <e-panel title="설비 센서 데이터 상관 분석" style="height: 500px;">
      <div>
        <img src="img/tmp/sensor.png" style="width: 1000px; height: 450px; display: block; margin: auto" >
      </div>
    </e-panel>
    <e-panel title="이상 센서 데이터 트렌드 분석" style="height: 300px">
      <e-correlation-chart class="layout-horizontal" width="1600" height="250"></e-correlation-chart>
    </e-panel>

    <e-footer></e-footer>
  </div>
</template>

<script>
  /* eslint-disable */
  import ePanel from './Panel'
  import eCorrelationChart from './CorrelationChart'
  import eGrid from './Grid'
  import eFooter from './Footer'

  export default {
    data() {
      return {
        fromDate: this.formatDate(new Date),
        toDate: this.formatDate(new Date),

      }
    },
    methods: {
      formatDate(date) {
        let d = new Date(date),
          month = '' + (d.getMonth()+1),
          day = '' + d.getDate(),
          year = d.getFullYear()

        if (month.length < 2) month = '0' + month
        if (day.length < 2) day = '0' + day

        return [year, month, day].join('-');
      },
      onClickct(){
        alert('clicked')
        //alert(event.srcElement.textContent)
      },
      search(){

      }
    },
    components: {
      ePanel,
      eCorrelationChart,
      eFooter
    }
  }
</script>

<style>
.layout-horizontal {
  display: inline-block;
}
</style>
