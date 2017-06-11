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
            categories: ['2017-05-01 08:31:10',
                        '2017-05-01 08:31:20',
                        '2017-05-01 08:31:30',
                        '2017-05-01 08:31:40',
                        '2017-05-01 08:31:50',
                        '2017-05-01 08:32:00',
                        '2017-05-01 08:32:10',
                        '2017-05-01 08:32:20',
                        '2017-05-01 08:32:30',
                        '2017-05-01 08:32:40'],
            crosshair: true
          }],
          yAxis: [{ // Primary yAxis
            labels: {
              format: '{value}'
            },
            title: {
              text: '각도'
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
          series: [{
            name: 'D4000',
            type: 'spline',
            yAxis: 0,
            data: [
              41,
              82,
              28,
              61,
              69,
              23,
              76,
              28,
              57,
              27],
            tooltip: {
              valueSuffix: ''
            }
          }]
        }
      }
    }
  }
</script>

<style>

</style>
