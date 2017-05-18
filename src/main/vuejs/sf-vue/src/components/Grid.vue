<template>
  <div>
    <ag-grid-vue
                 :gridOptions="gridOptions"
                 :rowData="rowData">
    </ag-grid-vue>
  </div>
</template>

<script>
  import {AgGridVue} from 'ag-grid-vue'

  export default {
    data () {
      return {
        gridOptions: {
          columnDefs: [
            {
              headerName: 'Name',
              field: 'name',
              width: 400
            },
            {
              headerName: 'Age',
              field: 'age',
              width: 399
            }
          ]
        },
        rowData: [
          {name: 'Bob', age: 10},
          {name: 'Harry', age: 3},
          {name: 'Sally', age: 20},
          {name: 'Mary', age: 5},
          {name: 'John', age: 15},
          {name: 'Bob', age: 10},
          {name: 'Harry', age: 3},
          {name: 'Sally', age: 20},
          {name: 'Mary', age: 5},
          {name: 'John', age: 15},
          {name: 'Jack', age: 25},
          {name: 'Sue', age: 43},
          {name: 'Sean', age: 44},
          {name: 'Niall', age: 2},
          {name: 'Alberto', age: 32},
          {name: 'Fred', age: 53},
          {name: 'Jenny', age: 34},
          {name: 'Larry', age: 13}
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
