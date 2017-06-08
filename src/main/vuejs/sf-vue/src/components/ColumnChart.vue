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
            type: 'column'
          },
          title: {
            text: this.title
          },
          colors: this.colors,
          xAxis: {
            categories: this.xcategories,
            crosshair: true
          },
          yAxis: {
            min: 0,
            title: {
              text: this.ytitle
            }
          },
          tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.0f} </b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
          },
          plotOptions: {
            column: {
              pointPadding: 0.2,
              borderWidth: 0
            }
          },
          series: this.dataProvider
        }
      }
    }
  }
</script>

<style>

</style>
