<template>
  <div>
    <ag-grid-vue class="ag-fresh" style="height:300px"
                 :gridOptions="gridOptions"
                 :rowData="rowData">
    </ag-grid-vue>
  </div>
</template>

<script>
  /* eslint-disable */
  import {AgGridVue} from 'ag-grid-vue';
  import '../../node_modules/ag-grid/dist/styles/ag-grid.css';
  import '../../node_modules/ag-grid/dist/styles/theme-fresh.css';

  export default {
    data () {
      return {
        gridOptions: {
          columnDefs: [
            {
              headerName: '제품',
              field: 'name',
              width: 300
            },
            {
              headerName: '설비',
              field: 'asset',
              width: 160
            },
            {
              headerName: '문제',
              field: 'problem',
              width: 200
            },
            {
              headerName: '시간',
              field: 'date',
              width: 120
            }
          ]
        },
        rowData: [
          {name: 'MAIN FILTER -TYCHE PRESS', asset:'고속 60Ton', problem:'이상정지', date:'2017-04-21 08:31'},
          {name: 'CABINET R(CLARUS/SUXURY SILVER)', asset:'350Ton(TPL)', problem:'C/T 이상', date:'2017-04-22 11:28'},
          {name: 'MAIN FILTER -THCHE PRESS', asset:'고속 60Ton', problem:'시간가동률 이상', date:'2017-04-21 08:11'},
          {name: 'CABINET R(CLARUS/SUXURY SILVER)', asset:'350Ton(TPL)', problem:'성능가동률 이상', date:'2017-04-21 08:05'},
          {name: 'MAIN FILTER -TYCHE PRESS', asset:'고속 60Ton', problem:'이상정지', date:'2017-04-21 08:31'}
        ]
      }
    },
    components: {
      AgGridVue
    }
  }
</script>

<style>

</style>
