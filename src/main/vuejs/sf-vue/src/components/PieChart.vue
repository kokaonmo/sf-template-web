<template>
  <div>
    <highcharts :options="options" :style="{width:this.width+'px', height:this.height+'px'}"></highcharts>
  </div>
</template>

<script>
  /* eslint-disable */
  import Highcharts from 'highcharts'

  export default {
    props: ['title', 'width', 'height', 'dataProvider', 'legendHorizontalAlign', 'legendVerticalAlign', 'legendLayout'],
    data () {
      return {
        options: {
          chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
          },
          legend: {
            align: this.legendHorizontalAlign,
            verticalAlign: this.legendVerticalAlign,
            layout: this.legendLayout,
            x: 0,
            y: 40
          },
          title: {
            text: this.title
          },
          tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
          },
          plotOptions: {
            pie: {
              allowPointSelect: true,
              cursor: 'pointer',
              dataLabels: {
                enabled: false
              },
              showInLegend: true
            }
          },
          series: [{
            name: '정지율',
            colorByPoint: true,
            data: this.dataProvider
          }],
          colors:['#7cb5ec', '#90ed7d', '#f7a35c', '#8085e9', '#f15c80', '#e4d354', '#2b908f', '#f45b5b', '#91e8e1']
        }
      }
    }
  }
</script>

<style>

</style>
