<template>
  <div>
    <highcharts :options="options" :style="{width:this.width+'px', height:this.height+'px'}"></highcharts>
  </div>
</template>

<script>
  /* eslint-disable */
  import Highcharts from 'highcharts'

  export default {
    props: ['title', 'ytitle', 'width', 'height', 'dataProvider', 'xcategories', 'unit', 'colors'],
    data () {
      return {
        options: {
          chart: {
            zoomType: 'xy'
          },
          title: {
            text: ''
          },
          xAxis: [{
            categories: ['2017-06-01', '2017-06-02', '2017-06-03', '2017-06-04', '2017-06-05', '2017-06-06', '2017-06-07'],
            crosshair: true
          }],
          yAxis: [{ // Primary yAxis
            labels: {
              format: '{value}'
            },
            title: {
              text: 'Profortion'
            }
          }],
          tooltip: {
            shared: true
          },
          legend: {
            layout: 'horizontal',
            align: 'center',
            verticalAlign: 'top'
          },
          colors:['#7cb5ec', '#90ed7d', '#f7a35c', '#8085e9', '#f15c80', '#e4d354', '#2b908f', '#f45b5b', '#91e8e1'],
          series: [{
            name: '3UL',
            type: 'spline',
            yAxis: 0,
            data: [425,461,458,253,440,417,490],
            tooltip: {
              valueSuffix: ' UL'
            }
          }, {
            name: 'Value',
            type: 'spline',
            yAxis: 0,
            data: [345,348,352,181,333,341,322],
            tooltip: {
              valueSuffix: ' Value'
            }
          }, {
            name: '3LL',
            type: 'spline',
            yAxis: 0,
            data: [445,448,452,281,433,441,422],
            tooltip: {
              valueSuffix: ' LL'
            }
          }, {
            name: 'P',
            type: 'spline',
            yAxis: 0,
            data: [415,415,415,415,415,415,415],
            tooltip: {
              valueSuffix: ' P'
            }
          }]
        }
      }
    }
  }
</script>

<style>

</style>
