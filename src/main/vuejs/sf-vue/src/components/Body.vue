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

    <e-panel title="종합가동률 TOP5(라인별)" style="height: 300px;">
      <e-gauge-chart v-for="gauge in gauges" :key="gauge.title" class="layout-horizontal" :title="gauge.title" minValue="0" maxValue="100" :value="gauge.value" width="300" height="250"></e-gauge-chart>
    </e-panel>
    <e-panel title="정지현황" style="height: 300px">
      <e-pie-chart v-for="pie in pies" :key="pie.name" class="layout-horizontal" :title="pie.title" :dataProvider="pie.dataProvider" legendHorizontalAlign="right" legendVerticalAlign="top" width="350" height="250"></e-pie-chart>
    </e-panel>
    <e-panel title="실시간 종합 이벤트" style="height: 210px;">
      <e-grid :dataProvider="events" :key="events.value" style="width: 740px; display: inline-block" @clickct="onClickct"></e-grid>
      <textarea rows="8" cols="100">
        2017.04.21 08: 31
        LG 고객사의 IN FILTER -TYCHE PRESS 제품 생산시 고속 60Ton 설비에서 금형문제로 이상정지 3분 발생.
      </textarea>
    </e-panel>
    <e-footer></e-footer>
  </div>
</template>

<script>
  /* eslint-disable */
  import ePanel from './Panel'
  import eGaugeChart from './GaugeChart'
  import ePieChart from './PieChart'
  import eGrid from './Grid'
  import eFooter from './Footer'

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
            y: 3991
          }, {
            name: '생산정지',
            y: 10525
          }, {
            name: '휴지',
            y: 6989
          }]
        },{
          title: "이상정지",
          dataProvider: [{
            name: '설비문제',
            y: 1330
          }, {
            name: '금형문제',
            y: 1698
          }, {
            name: '사내품질',
            y: 400
          }, {
            name: '자재품질',
            y: 482
          }, {
            name: '자재부족',
            y: 0
          }, {
            name: '대차부족',
            y: 70
          }, {
            name: '샘플,금형Try',
            y: 11
          }, {
            name: '계획변경',
            y: 0
          }]
        },{
          title: "생산정지",
          dataProvider: [{
            name: '금형교환',
            y: 6196
          }, {
            name: '재료교환',
            y: 2882
          }, {
            name: '주변정리',
            y: 0
          }, {
            name: '작업조건',
            y: 1123
          }, {
            name: '휴먼에러',
            y: 0
          }, {
            name: '자재부족(생산)',
            y: 301
          }, {
            name: '기타',
            y: 23
          }]
        },{
          title: "휴지",
          dataProvider: [{
            name: '파견/계획정지',
            y: 20
          }, {
            name: '교육/훈련/조회',
            y: 849
          }, {
            name: '대차수리',
            y: 0
          }, {
            name: '금형교환(외작업)',
            y: 0
          }, {
            name: '휴식',
            y: 6120
          }, {
            name: '기타',
            y: 0
          }]
        }],
        events:[{
            item: 'MAIN FILTER -TYCHE PRESS',
            asset: '고속 60Ton',
            problem: '이상정지',
            date: '2017-06-21 08:31',
            isct: true
          },{
            item: 'CABINET R(CLARUS/RUXURY SILVER)',
            asset: '350Ton(TPL)',
            problem: 'C/T 이상',
            date: '2017-06-21 08:23',
            isct: true
          },{
            item: 'MAIN FILTER -TYCHE PRESS',
            asset: '고속 60Ton',
            problem: 'C/T 이상',
            date: '2017-06-21 08:16',
            isct: true
          },{
            item: 'CABINET R(CLARUS/RUXURY SILVER)',
            asset: '고속 60Ton',
            problem: '이상정지',
            date: '2017-06-21 08:12',
            isct: true
          },{
            item: 'MAIN FILTER -TYCHE PRESS',
            asset: '고속 60Ton',
            problem: 'C/T 이상',
            date: '2017-06-21 08:05',
            isct: true
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
      onClickct(){
        alert('clicked')
        //alert(event.srcElement.textContent)
      },
      search(){

      }
    },
    components: {
      ePanel,
      eGaugeChart,
      ePieChart,
      eGrid,
      eFooter
    }
  }
</script>

<style>
.layout-horizontal {
  display: inline-block;
}
</style>
