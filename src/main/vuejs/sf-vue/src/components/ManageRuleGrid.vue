<template>
  <div>
    <ag-grid-vue class="ag-fresh" style="height:260px;"
                 :gridOptions="gridOptions"
                 :rowData="rowData">
    </ag-grid-vue>
  </div>
</template>

<script>
  /* eslint-disable */
  import {AgGridVue} from 'ag-grid-vue';
  import ButtonRenderer from './renderers/ButtonRenderer'
  import '../../node_modules/ag-grid/dist/styles/ag-grid.css';
  import '../../node_modules/ag-grid/dist/styles/theme-fresh.css';

  export default {
    props: ['dataProvider', 'ruleNumber'],
    data () {
      return {
        gridOptions: {
          columnDefs: [
            {
              headerName: '설명',
              field: 'description',
              width: 150,
              cellStyle: {
                'white-space': 'normal'
              },
              cellRenderer (params) {
                return '<p style="padding-left: 10px; padding-right: 10px;">'+params.value+'</p>';
              }
            },
            {
              headerName: '상황판단 및 대응',
              field: 'guide',
              width: 230,
              cellStyle: {
                'white-space': 'normal'
              },
              cellRenderer (params) {
                return '<p style="padding-left: 10px; padding-right: 10px;">'+params.value+'</p>';
              }
            }
          ],
          rowHeight: 260
        },
        rowData: this.dataProvider[this.ruleNumber-1]
      }
    },
    methods: {
      setDataProvider (ruleNumber){
        this.$data.rowData = this.dataProvider[ruleNumber-1]
      }
    },
    components: {
      AgGridVue
    }
  }
</script>

<style>

</style>
