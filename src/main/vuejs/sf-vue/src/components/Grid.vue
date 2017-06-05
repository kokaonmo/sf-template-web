<template>
  <div>
    <ag-grid-vue class="ag-fresh" style="height:150px;"
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
    props: ['dataProvider'],
    data () {
      return {
        gridOptions: {
          columnDefs: [
            {
              headerName: '제품',
              field: 'item',
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
        rowData: this.dataProvider
      }
    },
    components: {
      AgGridVue
    }
  }
</script>

<style>

</style>
