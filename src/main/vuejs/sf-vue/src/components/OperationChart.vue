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
              format: '{value}%'
            },
            title: {
              text: '가동률'
            },
            opposite: true

          }, { // Secondary yAxis
            gridLineWidth: 0,
            title: {
              text: '시간'
            },
            labels: {
              format: '{value} 분'
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
            name: '가동공수',
            type: 'column',
            yAxis: 1,
            data: [425,461,458,253,440,417,490],
            tooltip: {
              valueSuffix: ' 분'
            }
          }, {
            name: '정미가동공수',
            type: 'column',
            yAxis: 1,
            data: [345,348,352,181,333,341,322],
            tooltip: {
              valueSuffix: ' 분'
            }
          }, {
            name: '가동률',
            type: 'spline',
            data: [81.18,75.49,76.86,71.54,75.68,81.77,65.71],
            tooltip: {
              valueSuffix: ' %'
            }
          }]
        }
      }
    }
  }
</script>

<style>

</style>
