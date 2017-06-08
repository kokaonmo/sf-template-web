<template>
  <div>
    <highcharts :options="options" :style="{width:this.width+'px', height:this.height+'px'}"></highcharts>
  </div>
</template>

<script>
  /* eslint-disable */
  import Highcharts from 'highcharts'

  export default {
    props: ['title', 'ytitle', 'width', 'height', 'leftDataProvider', 'rightDataProvider', 'xcategories', 'unit', 'colors'],
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
            categories: this.xcategories,
            crosshair: true
          }],
          yAxis: [{ // Primary yAxis
            labels: {
              format: '{value}%',
              style: {
                color: Highcharts.getOptions().colors[3]
              }
            },
            title: {
              text: '정지율',
              style: {
                color: Highcharts.getOptions().colors[3]
              }
            },
            opposite: true

          }, { // Secondary yAxis
            gridLineWidth: 0,
            title: {
              text: '시간',
              style: {
                color: Highcharts.getOptions().colors[0]
              }
            },
            labels: {
              format: '{value} 분',
              style: {
                color: Highcharts.getOptions().colors[0]
              }
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
          colors:this.colors,
          series: [{
            name: '정지시간',
            type: 'column',
            yAxis: 1,
            data: this.leftDataProvider.sort(function(a, b) {
              return b - a;
            }),
            tooltip: {
              valueSuffix: ' 분'
            }
          }, {
            name: '정지율',
            type: 'spline',
            data: this.rightDataProvider,
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
