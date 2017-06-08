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

    <e-panel title="시간가동률" style="height: 300px;">
      <e-availability-chart class="layout-horizontal" width="1600" height="250"></e-availability-chart>
    </e-panel>
    <e-panel title="관리도 분석" style="height: 500px;">
      <e-availability-manage-chart style="display: inline-block;" class="layout-horizontal" width="1200" height="460"></e-availability-manage-chart>
      <form style="display: inline-block; vertical-align: top">
        <div style="display: inline-block; vertical-align: top">
          <div class="radio" v-for="i in 7" style="width: 80px">
            <label v-if="i==1"><input type="radio" name="optradio" value="i" @click="changeSelectVal(i)" checked>Rule {{i}}</label>
            <label v-else><input type="radio" name="optradio" value="i" @click="changeSelectVal(i)">Rule {{i}}</label>
          </div>
        </div>
        <div style="display: inline-block; margin-top: 10px"><img ref="img" src="img/rule/rule1.png" width="295" height="160"></div>
        <e-manage-rule-grid ref="grid" :dataProvider="rules" ruleNumber="1" style="width: 380px; height: 200px;"></e-manage-rule-grid>

      </form>

    </e-panel>
    <e-footer></e-footer>
  </div>
</template>

<script>
  /* eslint-disable */
  import ePanel from './Panel'
  import eGaugeChart from './GaugeChart'
  import ePieChart from './PieChart'
  import eAvailabilityChart from './AvailabilityChart'
  import eAvailabilityManageChart from './AvailabilityManageChart'
  import eManageRuleGrid from './ManageRuleGrid'
  import eFooter from './Footer'

  export default {
    data() {
      return {
        fromDate: this.formatDate(new Date),
        toDate: this.formatDate(new Date),
        selectedRuleNumber: 1,
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
          }],
        rules:[
          [{
            rule: 1,
            description: '상하한치 초과',
            guide: '상한치 초과 시 기준 C/T 산출 필요 (성능가동률에 한함) \n 하한치 미만 시 "공정 관리 상태 이탈 발생"으로 이상 원인에 의한 가동률 저하 발생 (경고 수준)'
          }],[{
            rule: 2,
            description: '연속된 3점중 2점이 Zone A에 위치',
            guide: 'Zone A(위쪽) 시 기준 C/T 산출 필요 (성능가동률에 한함) \n Zone A(아래쪽) 시 "공정 관리 상태 이탈 조기 감지"로 이상 원인에 의한 가동률 저하 발생 (권고 수준)'
          }],[{
            rule: 3,
            description: '연속된 5점중 4점이 Zone B와 Zone A에 위치',
            guide: 'Zone A,B(위쪽) 시 기준 C/T 산출 필요 (성능가동률에 한함) \n Zone A,B(아래쪽) 시 "약한 공정 관리 상태 이탈 경향 발생"으로 이상 원인에 의한 가동률 저하 발생 (권고 수준)'
          }],[{
            rule: 4,
            description: '연속된 6점이 꾸준히 증가 및 감소',
            guide: '(가동률은 꾸준히 증가해도 문제없음) \n 꾸준히 감소하는 경우 이상 원인에 의한 가동률 저하 진행중'
          }],[{
            rule: 5,
            description: '연속된 9점이 중심선에 대하여 같은 쪽에 위치',
            guide: '평균, 상한치 하한치 재산출 필요 \n -> 분석 시작점 업데이트 (연속된 9점 중 첫 점에서 재시작)'
          }],[{
            rule: 6,
            description: '연속된 15점이 Zone C에 위치',
            guide: '평균, 상한치 하한치 재산출 필요 \n -> 분석 시작점 업데이트 (연속된 15점 중 첫 점에서 재시작)'
          }],[{
            rule: 7,
            description: '연속된 8점이 Zone C를 벗어나 위치',
            guide: '가동률 변동성이 큼'
          }]
        ]
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

      },
      changeSelectVal(ruleNumber){
        this.$refs.grid.setDataProvider(ruleNumber)
        this.$refs.img.src = 'img/rule/rule'+ruleNumber+'.png'
      }
    },
    components: {
      ePanel,
      eGaugeChart,
      ePieChart,
      eAvailabilityChart,
      eAvailabilityManageChart,
      eManageRuleGrid,
      eFooter
    }
  }
</script>

<style>
.layout-horizontal {
  display: inline-block;
}
</style>
