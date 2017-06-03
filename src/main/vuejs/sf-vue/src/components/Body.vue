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

    <e-panel title="종합가동률 TOP5(라인별)">
      <e-gauge-chart v-for="gauge in gauges" class="layout-horizontal" :title="gauge.title" minValue="0" maxValue="100" :value="gauge.value" width="300" height="250"></e-gauge-chart>
    </e-panel>
    <e-panel title="정지현황">
      <e-pie-chart v-for="pie in pies" class="layout-horizontal" :title="pie.title" :dataProvider="pie.dataProvider" width="350" height="250"></e-pie-chart>
    </e-panel>
    <e-panel title="실시간 종합 이벤트">
      <e-grid></e-grid>
    </e-panel>
  </div>
</template>

<script>
  /* eslint-disable */
  import ePanel from './Panel'
  import eGaugeChart from './GaugeChart'
  import ePieChart from './PieChart'
  import eGrid from './Grid'
  export default {
    data() {
      return {
        fromDate: this.formatDate(new Date),
        toDate: this.formatDate(new Date),
        gauges: [{
          title: "고속 60Ton",
          value: 30
        },{
          title: "350Ton(TPL)",
          value: 40
        },{
          title: "250Ton(TPL)",
          value: 50
        },{
          title: "화일400Ton(Pro)",
          value: 60
        },{
          title: "쌍용50Ton(Pro)",
          value: 70
        }],
        pies: [{
          title: "전체",
          dataProvider: [{
            name: '이상정지',
            y: 56.33
          }, {
            name: '생산정지',
            y: 24.03
          }, {
            name: '휴지',
            y: 10.38
          }]
        },{
          title: "이상정지",
          dataProvider: [{
            name: '이상정지',
            y: 56.33
          }, {
            name: '생산정지',
            y: 24.03
          }, {
            name: '휴지',
            y: 10.38
          }]
        },{
          title: "생산정지",
          dataProvider: [{
            name: '이상정지',
            y: 56.33
          }, {
            name: '생산정지',
            y: 24.03
          }, {
            name: '휴지',
            y: 10.38
          }]
        },{
          title: "휴지",
          dataProvider: [{
            name: '이상정지',
            y: 56.33
          }, {
            name: '생산정지',
            y: 24.03
          }, {
            name: '휴지',
            y: 10.38
          }]
        }]
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
    },
    components: {
      ePanel,
      eGaugeChart,
      ePieChart,
      eGrid
    }
  }
</script>

<style>
.layout-horizontal {
  display: inline-block;
}
</style>
