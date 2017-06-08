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
      </div>
      <div class="form-group">
        <div class="input-group">
          <div class="input-group-addon">창고</div>
          <select class="form-control">
            <option>생산창고-1반</option>
            <option>생산창고-2반</option>
            <option>생산창고-3반</option>
          </select>
        </div>
      </div>
      <div class="form-group">
        <div class="input-group">
          <div class="input-group-addon">설비</div>
          <select class="form-control">
            <option>350Ton(TPL)</option>
            <option>350Ton(TPL)</option>
            <option>350Ton(TPL)</option>
            <option>Door Line(조립)</option>
            <option>Front Line(조립)</option>
            <option>Motor,Funnel(조립)</option>
            <option>350Ton(TPL)</option>
            <option>클러치(조립)</option>
            <option>화일400Ton(Pro)</option>
            <option>고마츠80T</option>
          </select>
        </div>
        <button type="submit" class="btn btn-primary">Find</button>
      </div>

    </form>
    <div>
      <e-panel title="종합 정지 현황" style="display: inline-block; vertical-align: top">
        <e-pie-chart v-for="pie in new Array(pies[0])" :key="pie.name" legendHorizontalAlign="center" legendVerticalAlign="top" class="layout-horizontal" :title="pie.title" :dataProvider="pie.dataProvider" width="350" height="350"></e-pie-chart>
      </e-panel>
      <e-panel title="정지 유형별 현황" style="width: 1200px; height: 840px; display: inline-block;">
        <e-column-chart class="layout-horizontal" :title="pies[1].title" :ytitle="pies[1].ytitle" :dataProvider="pies[1].dataProvider" :xcategories="pies[1].xcategories" :unit="pies[1].unit" width="1150" height="260" :colors="['#7cb5ec', '#434348', '#90ed7d', '#f7a35c', '#8085e9', '#f15c80', '#e4d354', '#2b908f', '#f45b5b', '#91e8e1']"></e-column-chart>
        <e-column-chart class="layout-horizontal" :title="pies[2].title" :ytitle="pies[2].ytitle" :dataProvider="pies[2].dataProvider" :xcategories="pies[2].xcategories" :unit="pies[2].unit" width="1150" height="250" :colors="['#434348', '#90ed7d', '#f7a35c', '#8085e9', '#f15c80', '#e4d354', '#2b908f', '#f45b5b', '#91e8e1', '#7cb5ec']"></e-column-chart>
        <e-column-chart class="layout-horizontal" :title="pies[3].title" :ytitle="pies[3].ytitle" :dataProvider="pies[3].dataProvider" :xcategories="pies[3].xcategories" :unit="pies[3].unit" width="1150" height="250" :colors="['#90ed7d', '#f7a35c', '#8085e9', '#f15c80', '#e4d354', '#2b908f', '#f45b5b', '#91e8e1', '#7cb5ec', '#434348']"></e-column-chart>
      </e-panel>
    </div>
    <e-footer></e-footer>
  </div>
</template>

<script>
  /* eslint-disable */
  import ePanel from './Panel'
  import eGaugeChart from './GaugeChart'
  import ePieChart from './PieChart'
  import eColumnChart from './ColumnChart'
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
          ytitle: "시간 (분)",
          unit: "분",
          xcategories:[
            '설비문제',
            '금형문제',
            '사내품질',
            '자재품질',
            '자재부족',
            '대차부족',
            '샘플,금형Try',
            '계획변경'
          ],
          dataProvider: [{
            name: '정지 시간',
            data: [1330,1698,400,482,0,70,11,0]
          }]
        },{
          title: "생산정지",
          ytitle: "시간 (분)",
          unit: "분",
          xcategories:[
            '금형교환',
            '재료교환',
            '주변정리',
            '작업조건',
            '휴먼에러',
            '자재부족(생산)',
            '기타'
          ],
          dataProvider: [{
            name: '정지 시간',
            data: [6196, 2882, 0, 1123, 0, 301, 23]
          }]
        },{
          title: "휴지",
          ytitle: "시간 (분)",
          unit: "분",
          xcategories:[
            '파견/계획정지',
            '교육/훈련/조회',
            '대차수리',
            '금형교환(외작업)',
            '휴식',
            '기타'
          ],
          dataProvider: [{
            name: '정지 시간',
            data: [20,849,0,0,6120,0]
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
      eColumnChart,
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
