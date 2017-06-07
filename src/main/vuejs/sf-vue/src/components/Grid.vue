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
  import ButtonRenderer from './renderers/ButtonRenderer'
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
              width: 120
            },
            {
              headerName: '문제',
              field: 'problem',
              width: 100
            },
            {
              headerName: '시간',
              field: 'date',
              width: 140
            },{
              headerName: 'C/T',
              width: 80,
              field: 'isct',
              cellRendererFramework: 'ButtonRenderer'
            }
          ]
        },
        rowData: this.dataProvider
      }
    },
    components: {
      AgGridVue,
      ButtonRenderer
    },
    created () {
      this.$on('clickct', this.onClickct)
    },
    methods: {
      onClickct (){
        alert('clicked')
      },
      methodFromParent(cell) {
        alert(`"Parent Component Method from ${cell}!`);
      }
    }
  }
</script>

<style>

</style>
